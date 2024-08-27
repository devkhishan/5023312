package com.devkhishan.bookstoreapi.config;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricsConfig {

    @Bean
    public CustomMetrics customMetrics(MeterRegistry meterRegistry) {
        return new CustomMetrics(meterRegistry);
    }

    public static class CustomMetrics {
        public CustomMetrics(MeterRegistry meterRegistry) {
            meterRegistry.gauge("custom.metric", this, CustomMetrics::getCustomMetricValue);
        }

        public double getCustomMetricValue() {
            // Return the value you want to expose. Example: a random value for demonstration.
            return Math.random();
        }
    }
}
