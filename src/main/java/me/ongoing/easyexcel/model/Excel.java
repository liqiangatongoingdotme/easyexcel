package me.ongoing.easyexcel.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Excel {


    /**
     * 导出的时间格式,以这个是否为空来判断是否需要格式化日期
     */
    public String exportFormat() default "";



    /**
     * 对应的excel里的列名
     */
    public String name();



}
