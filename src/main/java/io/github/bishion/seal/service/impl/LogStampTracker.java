package io.github.bishion.seal.service.impl;

import io.github.bishion.seal.dto.StampTrack;
import io.github.bishion.seal.service.StampTracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: guofangbi
 * @since 2022/6/5-11:44
 * @version: 1.0.0
 */
public class LogStampTracker implements StampTracker {
    private static final Logger log = LoggerFactory.getLogger(LogStampTracker.class);
    public void persist(StampTrack stampTrack) {
        log.info(stampTrack.toString());
    }
}
