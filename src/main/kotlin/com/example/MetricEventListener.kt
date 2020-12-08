package com.mercell.dp

import io.micrometer.core.instrument.MeterRegistry
import io.micronaut.context.event.ApplicationEventListener
import io.micronaut.runtime.event.annotation.EventListener
import javax.inject.Singleton

@Singleton
class MetricEventListener(val meterRegistry: MeterRegistry) : ApplicationEventListener<MetricEvent> {

    @EventListener
    override fun onApplicationEvent(event: MetricEvent) {
        println( "onApplicationEvent")
        meterRegistry
            .counter(event.category, "name", event.key)
            .increment()
    }
}
