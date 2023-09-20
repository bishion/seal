package io.github.bishion.seal.service.impl;


import io.github.bishion.seal.dto.StampTrack;
import io.github.bishion.seal.service.StampTracker;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: guofangbi
 * @version: 1.0.0
 * @since 2022/6/5-21:00
 */
public class StampTrackService {
    @Resource
    private List<StampTracker> stampTrackerList;

    public void persist(StampTrack stampTrack, Stamp stamp) {
        stampTrackerList.parallelStream().forEach(stampTracker ->
                stampTracker.persist(stampTrack)
        );
        SpringUtil.getBean(stamp.closeoutService(), CloseoutService.class).posted(stampTrack);
    }
}
