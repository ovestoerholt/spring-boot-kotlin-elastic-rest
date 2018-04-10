package no.stoerholt.samples

import org.apache.http.HttpHost
import org.elasticsearch.action.get.GetRequest
import org.elasticsearch.action.get.GetResponse
import org.elasticsearch.action.search.SearchRequest
import org.elasticsearch.action.search.SearchResponse
import org.elasticsearch.action.update.UpdateRequest
import org.elasticsearch.action.update.UpdateResponse
import org.elasticsearch.client.RestClient
import org.elasticsearch.client.RestHighLevelClient
import org.elasticsearch.search.SearchHit
import org.springframework.stereotype.Repository

@Repository
class BookElasticRepo {


    var client = RestHighLevelClient(
            RestClient.builder(
                    HttpHost("localhost", 9200, "http")))

    fun getBookById(id: String): Book {

        val getRequest = GetRequest("books", "book", id)

        // Optional arguments
        //getRequest.fetchSourceContext()

        val response: GetResponse = client.get(getRequest)
        return response.sourceAsMap.toBook()

        //return response.toBook()
    }

    fun insertBook(book: Book): Boolean {
        val request: UpdateRequest = book.fromBook()
        request.docAsUpsert(true)
        val updateResponse: UpdateResponse = client.update(request)

        if (updateResponse.getResult().name.equals("CREATED")) return true
        return false
    }

    fun search(): List<Book> {
        val request = SearchRequest("books")
        request.types("book")

        val searchResponse: SearchResponse = client.search(request)
        val bookList: MutableList<Book> = ArrayList()

        for (hit: SearchHit in searchResponse.hits.hits.iterator()) {
            bookList.add(hit.sourceAsMap.toBook())
        }

        return bookList
    }

}