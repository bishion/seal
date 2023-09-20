package io.github.bishion.seal.dto;

import io.github.bishion.common.consts.BaseConst;
import io.github.bishion.common.consts.BaseError;
import io.github.bishion.seal.consts.SealError;

/**
 * 业务异常
 *
 * @author: guofangbi
 * @version: 1.0.0
 * @since 2022-05-24 23:01:52
 */
public class SealException extends RuntimeException {
    private static final long serialVersionUID = 4090231776804948548L;
    private final String code;
    private final String msg;

    private SealException(SealError baseError, Object... param) {
        this(baseError.getCode(), baseError.getMsg(param));
    }

    private SealException(String code, String msg) {
        super(code + BaseConst.COLON + msg);
        this.code = code;
        this.msg = msg;
    }

    public static BizException throwExp(BaseError baseError, Object... param) {
        return new BizException(baseError, param);
    }

    /**
     * 抛出异常
     * 该方法只给baseResult
     *
     * @param code 代码
     * @param msg  信息
     * @return {@link BizException}
     */
    static BizException throwExp(String code, String msg) {
        return new BizException(code, msg);
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
