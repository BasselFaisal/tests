package com.demo.config.redis.queue;

public interface MessagePublisher {

    void publish(final String message);
}