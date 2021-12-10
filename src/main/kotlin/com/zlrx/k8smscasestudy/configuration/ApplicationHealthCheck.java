package com.zlrx.k8smscasestudy.configuration;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class ApplicationHealthCheck implements HealthIndicator {
    @Override
    public Health health() {
        return Health.up().build();
    }
}
