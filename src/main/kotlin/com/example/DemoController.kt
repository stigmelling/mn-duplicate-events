package com.example

import com.mercell.dp.MetricEvent
import io.micronaut.context.event.ApplicationEventPublisher
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/")
class DemoController(val eventPublisher: ApplicationEventPublisher) {

    @Get("/")
    fun test(): String{
        eventPublisher.publishEvent( MetricEvent("aCategory", "aKey"))
        return "Check /prometheus"
    }
}