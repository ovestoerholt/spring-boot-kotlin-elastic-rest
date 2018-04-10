package no.stoerholt.samples

import org.elasticsearch.action.update.UpdateRequest
import java.util.*


fun Map<String, Any>.toBook(): Book {
    val isbn = this.get("isbn")
    val title = this.get("title")
    val author = this.get("author")
    val publisher = this.get("publisher")

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