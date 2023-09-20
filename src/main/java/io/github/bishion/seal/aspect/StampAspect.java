package io.github.bishion.seal.aspect;

import io.github.bishion.seal.annotation.Stamp;
import io.github.bishion.seal.dto.StampTrack;
import io.github.bishion.seal.service.BuildStampTrackService;
import io.github.bishion.seal.service.impl.StampTrackService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Objects;

/**
 * 打点核心切面
 *
 * @author: guofangbi
 * @version: 1.0.0
 * @since 2022/6/4-20:45
 */
@Aspect
public class StampAspect {
    @Value("${toolkit.snail.maxRespLen:1024}")
    private Integer maxRespLen;

    @Resource
    private BuildStampTrackService buildStampTrackService;
    @Resource
    private StampTrackService stampTrackService;

    @Around(value = "@annotation(io.github.bishion.toolkit.snail.annotation.Stamp)")
    public Object process(ProceedingJoinPoint joinPoint, Stamp stamp) throws Throwable {
        Date startTime = new Date();

        Object[] args = joinPoint.getArgs();
        StampTrack.StampTrackBuilder builder = buildStampTrackService.createStampTrackBuilder(stamp, args, startTime);
        try {
            Object result = joinPoint.proceed();
            String response = Objects.isNull(result) ? null : result.toString();
            if (result instanceof BaseResult && !((BaseResult<?>) result).valid()) {
                builder.success(BaseConst.FAILURE);
            } else {
                builder.success(BaseConst.SUCCESS);
            }
            builder.response(CharSequenceUtil.subPre(response, maxRespLen));
            buildStampTrackService.buildReqAndResp(builder, stamp, args, response);
            return result;
        } catch (Exception e) {
            builder.success(BaseConst.FAILURE).response(CharSequenceUtil.subPre(e.getMessage(), maxRespLen));
            throw e;
        } finally {
            Date endTime = new Date();

            Long endTimeSeconds = endTime.getTime();
            builder.costTime(endTimeSeconds - startTime.getTime()).endTime(endTime);

            stampTrackService.persist(builder.build(), stamp);
        }
    }

}
