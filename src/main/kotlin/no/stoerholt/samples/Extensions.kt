package no.stoerholt.samples

import org.elasticsearch.action.get.GetResponse
import org.elasticsearch.action.update.UpdateRequest
import java.util.*


fun GetResponse.toBook(): Book {

    val isbn = this.source.get("isbn")
    val title = this.source.get("title")
    val author = this.source.get("author")
    val publisher = this.source.get("publisher")

    return Book(isbn.toString(), title.toString(), author.toString(), publisher.toString())
}


fun Book.fromBook(): UpdateRequest {
    val jsonMap = HashMap<String, Any>()
    jsonMap["isbn"] = this.isbn
    jsonMap["title"] = this.title
    jsonMap["author"] = this.author
    jsonMap["publisher"] = this.publisher

    return UpdateRequest("books", "book", this.isbn).doc(jsonMap)
}