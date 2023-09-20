package io.github.bishion.seal.service;

import io.github.bishion.seal.annotation.Stamp;
import io.github.bishion.seal.consts.SealError;
import io.github.bishion.seal.dto.StampTrack;
import io.github.bishion.seal.dto.ReqInfo;
import io.github.bishion.seal.util.AssertUtil;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * @author: guofangbi
 * @version: 1.0.0
 * @since 2022/6/5-12:29
 */
public class BuildStampTrackService {
    @Value("${spring.application.name}")
    private String appName;
    @Resource
    private Map<String, SealSpelParser> actionParserMap;
    @Resource
    private SealSpelParser spelDefaultParser;
    @Resource
    private Map<String, ParamParser> paramParserMap;
    @Resource
    public ReqInfoService reqInfoService;

    @Resource
    private EnvInfoService envInfoService;

    public StampTrack.StampTrackBuilder createStampTrackBuilder(Stamp stamp, Object[] params, Date startTime) {
        StampTrack.StampTrackBuilder builder = StampTrack.builder();

        builder.appName(appName).hostIp(envInfoService.hostIp()).hostName(envInfoService.hostName());
        builder.module(stamp.module()).actionType(stamp.actionType());

        buildBaseReqInfo(builder);
        buildParam(builder, stamp, params);

        return builder;
    }


    public void buildBaseReqInfo(StampTrack.StampTrackBuilder builder) {
        ReqInfo baseReqInfo = reqInfoService.currentReqInfo();
        builder.clientIp(baseReqInfo.getClientIp()).operatorNo(baseReqInfo.getOperatorNo())
                .operatorName(baseReqInfo.getOperatorName());
    }

    public void buildParam(StampTrack.StampTrackBuilder builder,
                           Stamp stamp, Object[] params) {
        ParamParser paramParser = paramParserMap.get(stamp.paramParser());
        BaseAssert.nonNull(paramParser, SealError.ACTION_PARSER_NAME_WRONG, stamp.actionParser());

        builder.param(paramParser.parse(params));
    }

    public void buildReqAndResp(StampTrack.StampTrackBuilder builder,
                                Stamp stamp, Object[] params, Object resp) {

        SealSpelParser snailSpelParser = actionParserMap.get(stamp.actionParser());
        AssertUtil.nonNull(snailSpelParser, SealError.ACTION_PARSER_NAME_WRONG, stamp.actionParser());
        String action = snailSpelParser.parse(stamp.action(), params, resp);
        builder.action(action);

        ParamParser paramParser = paramParserMap.get(stamp.paramParser());
        BaseAssert.nonNull(paramParser, SealError.ACTION_PARSER_NAME_WRONG, stamp.actionParser());

        builder.bizNo(spelDefaultParser.parse(stamp.bizNo(), params, resp));
    }

}
