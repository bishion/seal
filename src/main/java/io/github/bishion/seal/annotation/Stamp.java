package io.github.bishion.seal.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: guofangbi
 * @version: 1.0.0
 * @since 2022/6/4-19:52
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Stamp {
    String DEFAULT_ACTION_PARSER = "defaultActionParser";
    String DEFAULT_CLOSEOUT = "defaultCloseoutService";
    String DEFAULT_PARAM_PARSER = "defaultParamParser";

    /**
     * 模块
     *
     * @return {@link String}
     */
    String module();

    String bizNo();

    /**
     * 操作
     *
     * @return {@link String}
     */
    String action();

    /**
     * 操作类型
     *
     * @return {@link String}
     */
    String actionType();

    /**
     * 动作解析器
     *
     * @return {@link String}
     */
    String actionParser() default DEFAULT_ACTION_PARSER;

    String paramParser() default DEFAULT_PARAM_PARSER;

    String closeoutService() default DEFAULT_CLOSEOUT;
}
