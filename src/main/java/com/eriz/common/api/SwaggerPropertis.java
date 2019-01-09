package com.eriz.common.api;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>
 *      swagger2 propertis
 * </p>
 * 2019年1月9日 | eriz
 */
@Component
@ConfigurationProperties(prefix = "eriz.swagger2")
public class SwaggerPropertis {
    /* 标题 */
    private String title;
    /* 开发者 */
    private String contactName;
    /* 项目路径 */
    private String contactUrl;
    /* email */
    private String contactEmail;
    /* 版本 */
    private String version;
    /* 描述 */
    private String description;
    /* 扫描包 */
    private String basePackage;
    /* 链接地址 */
    private String termsOfServiceUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactUrl() {
        return contactUrl;
    }

    public void setContactUrl(String contactUrl) {
        this.contactUrl = contactUrl;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public String getTermsOfServiceUrl() {
        return termsOfServiceUrl;
    }

    public void setTermsOfServiceUrl(String termsOfServiceUrl) {
        this.termsOfServiceUrl = termsOfServiceUrl;
    }
}
