package no.stoerholt.samples

import org.apache.http.HttpHost
import org.elasticsearch.action.get.GetRequest
import org.elasticsearch.action.get.GetResponse
import org.elasticsearch.client.RestClient
import org.elasticsearch.client.RestHighLevelClient
import org.springframework.stereotype.Service

@Service
class ElasticRepo {


    var client = RestHighLevelClient(
            RestClient.builder(
                    HttpHost("localhost", 9200, "http")))

    fun getBookById(id: String): Book {

        var getRequest: GetRequest = GetRequest("books", "book", id)

        // Optional arguments
        //getRequest.fetchSourceContext()

        var response: GetResponse = client.get(getRequest)

        return response.toBook()
    }

}