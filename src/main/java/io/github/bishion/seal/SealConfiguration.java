package io.github.bishion.seal;

import io.github.bishion.seal.aspect.StampAspect;
import io.github.bishion.seal.service.*;
import io.github.bishion.seal.service.impl.LogStampTracker;
import io.github.bishion.seal.service.impl.SpelParseService;
import io.github.bishion.seal.service.impl.StampTrackService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.expression.BeanFactoryResolver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: guofangbi
 * @version: 1.0.0
 * @since 2022/6/5-13:13
 */
public class SealConfiguration {
    @Bean
    public SealSpelParser defaultActionParser() {
        return (action, params, resp) -> action;
    }

    @Bean
    public ParamParser defaultParamParser() {
        return params -> Arrays.deepToString(params);
    }

    @Bean
    public CloseoutService defaultCloseoutService() {
        return stampTrack -> {
            // 默认收尾啥都不做
        };
    }

    @Bean
    public StampTracker logStampTracker() {
        return new LogStampTracker();
    }

    @Bean
    public SealSpelParser spelDefaultParser(SpelParseService spelParseService) {
        return (spel, params, resp) -> {
            Map<String, Object> param = new HashMap<>(1);
            if (params == null && params.length ==1) {
                param.put(SealSpelParser.PARAM_REQ, params[0]);
            } else {
                param.put(SealSpelParser.PARAM_REQ, params);
            }
            param.put(SealSpelParser.PARAM_RESP, resp);
            return spelParseService.parseSpel(spel, param);
        };

    }

    @Bean
    public SpelParseService spelParserService(BeanFactory beanFactory) {
        return new SpelParseService(new BeanFactoryResolver(beanFactory));
    }

    @Bean
    public StampTrackService stampTrackService() {
        return new StampTrackService();
    }

    @Bean
    public StampAspect stampAspect() {
        return new StampAspect();
    }

    @Bean
    public BuildStampTrackService buildStampTrackService() {
        return new BuildStampTrackService();
    }
}
