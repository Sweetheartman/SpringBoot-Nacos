package com.senyint.exercise.aop.annotation;

import java.lang.annotation.*;

/**
* @Description: 自定义注解记录用户操作日志
 * Target说明了Annotation所修饰的对象范围：Annotation可被用于 packages、
 * types（类、接口、枚举、Annotation类型）、类型成员（方法、构造方法、成员变量、
 * 枚举值）、方法参数和本地变量（如循环变量、catch参数）。在Annotation类型的声
 * 明中使用了target可更加明晰其修饰的目标。
* @Param: 
* @return: 
* @Author: lidekun
* @Date: 2020/8/28
*/

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyLog {

    /**
     * 用户操作哪个模块
     */
    String title() default "";

    /**
     * 记录用户操作的动作
     */
    String action() default "";
}
