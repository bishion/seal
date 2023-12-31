package io.github.bishion.seal.service;

import io.github.bishion.seal.dto.StampTrack;

/**
 * @author: guofangbi
 * @since 2022/6/5-11:18
 * @version: 1.0.0
 */
public interface StampTracker {
    /**
     * 持久化追踪数据
     *
     * @param stampTrack 邮票跟踪
     */
    void persist(StampTrack stampTrack);
}
