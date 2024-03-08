package dev.epicpixel.ha.ms.service.base

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class MsServiceApplication

fun main(args: Array<String>) {
	runApplication<MsServiceApplication>(*args)
}
