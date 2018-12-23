package com.eriz.common.annotation;

import java.lang.annotation.*;

/**
 * <pre>
 * </pre>
 *
 * <small> 2018年12月23日 | eriz</small>
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Log {
	String value() default "";
}
