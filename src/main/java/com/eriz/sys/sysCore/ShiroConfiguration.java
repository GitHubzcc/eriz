package com.eriz.sys.sysCore;

import com.eriz.common.shiro.config.ShiroProperties;
import com.eriz.common.shiro.session.RedisSessionDAO;
import com.eriz.sys.config.BDSessionListener;
import org.apache.shiro.authc.Authenticator;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.authz.Authorizer;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.*;

/**
 * <pre>
 * . cache ehcache
 * . realm(cache)
 * . securityManager（realm）
 * . ShiroFilterFactoryBean 注册
 *
 * </pre>
 * <small> 2018年12月18日 | eriz</small>
 */
@Configuration
public class ShiroConfiguration {

    /**
     * 设置sessionDAO
     * @param config
     * @return
     */
    @Bean
    SessionDAO sessionDAO(ShiroProperties config){
        RedisSessionDAO sessionDAO = new RedisSessionDAO(config.getSessionKeyPrefix());
        return sessionDAO;
    }

    /**
     * cookie 配置
     * @param config
     * @return
     */
    @Bean
    public SimpleCookie sessionIdCookie(ShiroProperties config) {
        return new SimpleCookie(config.getJsessionidKey());
    }

    /**
     * 设置sessionManager
     * @param sessionDAO
     * @param simpleCookie
     * @return
     */
    @Bean
    public SessionManager sessionManager(SessionDAO sessionDAO, SimpleCookie simpleCookie) {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionIdCookie(simpleCookie);

        Collection<SessionListener> sessionListeners = new ArrayList<SessionListener>();
        sessionListeners.add(new BDSessionListener());
        sessionManager.setSessionListeners(sessionListeners);
        sessionManager.setSessionDAO(sessionDAO);
        return sessionManager;
    }

    /**
     * 添加自己得认证器
     * @param sysShiroRealm
     * @return
     */
    @Bean
    Authenticator authenticator(SysShiroRealm sysShiroRealm) {
        ModularRealmAuthenticator authenticator = new ModularRealmAuthenticator();
        authenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
        List<Realm> realms = new ArrayList<>();
        realms.add(sysShiroRealm);
        authenticator.setRealms(realms);
        return authenticator;
    }

    /**
     * 添加自己的shiro
     * @param sysShiroRealm
     * @return
     */
    @Bean
    Authorizer authorizer(SysShiroRealm sysShiroRealm) {
        ModularRealmAuthorizer authorizer = new ModularRealmAuthorizer();
        List<Realm> realms = new ArrayList<>();
        realms.add(sysShiroRealm);
        authorizer.setRealms(realms);
        return authorizer;
    }

    /**
     * 配置securityManager
     * @param sessionManager
     * @param authenticator
     * @param authorizer
     * @return
     */
    @Bean("securityManager")
    public DefaultWebSecurityManager getManager(SessionManager sessionManager,Authenticator authenticator,Authorizer authorizer) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        // 使用自己的realm
        manager.setAuthenticator(authenticator);
        manager.setAuthorizer(authorizer);
//        manager.setCacheManager();
        manager.setSessionManager(sessionManager);
        return manager;
    }

    @Bean
    ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 添加jwt过滤器
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("jwt", new JWTFilter());
        shiroFilterFactoryBean.setFilters(filterMap);
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/index");
        shiroFilterFactoryBean.setUnauthorizedUrl("/shiro/405");
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/shiro/**", "anon");
        filterChainDefinitionMap.put("/api/**", "jwt"); // api
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/layui/**", "anon");
        filterChainDefinitionMap.put("/fonts/**", "anon");
        filterChainDefinitionMap.put("/img/**", "anon");
        filterChainDefinitionMap.put("/docs/**", "anon");
        filterChainDefinitionMap.put("/druid/**", "anon");
        filterChainDefinitionMap.put("/upload/**", "anon");
        filterChainDefinitionMap.put("/files/**", "anon");
        filterChainDefinitionMap.put("/test/**", "anon");
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/", "anon");
        filterChainDefinitionMap.put("/kaptcha", "anon");
        filterChainDefinitionMap.put("/loginFrom", "anon");
        filterChainDefinitionMap.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 下面的代码是添加注解支持
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        // 强制使用cglib，防止重复代理和可能引起代理出错的问题
        // https://zhuanlan.zhihu.com/p/29161098
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

}
