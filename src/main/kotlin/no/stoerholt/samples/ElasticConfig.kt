package no.stoerholt.samples

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

@Configuration
class ElasticConfig(
        @Value("\${elasticsearch.hostname}") val hostname: String = "localhost",
        @Value("\${elasticsearch.port}") val port: Int = 9200,
        @Value("\${elasticsearch.scheme}") val scheme: String = "http") {
}