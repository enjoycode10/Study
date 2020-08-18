package com.okgo.jwt.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Shawn
 * @date 2020/7/5 2:25
 * @title 定义一个用户需要登录才能进行其他接口访问等一系列操作的注解TokenRequired
 *
 *  @Target
 *      旨意为我们自定义注解@TokenRequired的作用目标，因为我们本次注解的作用目标为方法层级，因此使用 ElementType.METHOD。
 *
 *  @Retention
 *      旨意为我们自定义注解 @TokenRequired的保留位置，@TokenRequired的保留位置被定义为RetentionPolicy.
 *      RUNTIME这种类型的注解将被JVM保留,他能在运行时被JVM或其他使用反射机制的代码所读取和使用。
 *
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface TokenRequired {
    boolean required() default true;
}
