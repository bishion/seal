package io.github.bishion.seal.consts;

import java.text.Format;

/**
 * @author: guofangbi
 * @since 2022/6/4-19:53
 * @version: 1.0.0
 */
public enum SealError {
    /**
     * 解析器名字错了
     */
    ACTION_PARSER_NAME_WRONG("TRK001", "未找到操作描述解析器.{0}"),
    PARAM_PARSER_NAME_WRONG("TRK002", "未找到参数解析器.{0}"),
    SPEL_PARSE_FAIL("TRK102", "SPEL解析失败.{0}"),
    ;

    private String code;
    private String pattern;

    SealError(String code, String pattern) {
        this.code = code;
        this.pattern = pattern;
    }

    public String getCode() {
        return code;
    }

    public String getPattern() {
        return pattern;
    }
    public String getMsg(Object... params) {
        return StrUtil.format(getPattern(), params);
    }
}
