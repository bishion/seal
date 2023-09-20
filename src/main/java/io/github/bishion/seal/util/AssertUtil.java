package io.github.bishion.seal.util;

import io.github.bishion.seal.consts.SealError;
import io.github.bishion.seal.dto.SealException;

import java.util.Objects;

public class AssertUtil {
    public static void nonNull(Object obj, SealError error, Object... params) {
        if (Objects.isNull(obj)) {
            throw SealException.throwExp(error, params);
        }
    }
}
