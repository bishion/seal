package io.github.bishion.seal.service;


import io.github.bishion.seal.dto.StampTrack;

/**
 * 收尾服务
 *
 * @author: guofangbi
 * @version: 1.0.0
 * @since 2022-06-05 21:11:47
 */
public interface CloseoutService {
    /**
     * 收尾, 比如做一些其他操作
     *
     * @param stampTrack 邮票跟踪
     */
    void posted(StampTrack stampTrack);
}
