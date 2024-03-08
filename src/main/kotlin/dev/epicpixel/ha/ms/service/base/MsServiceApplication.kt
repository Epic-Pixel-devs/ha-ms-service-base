package dev.epicpixel.ha.ms.service.base

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MsGatewayApplication

fun main(args: Array<String>) {
	runApplication<MsGatewayApplication>(*args)
}
