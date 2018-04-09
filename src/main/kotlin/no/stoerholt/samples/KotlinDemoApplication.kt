package no.stoerholt.samples

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

fun main(args: Array<String>) {
    SpringApplication.run(KotlinDemoApplication::class.java, *args)
}

@SpringBootApplication
class KotlinDemoApplication {
    // public is default for classes in Kotlin

}