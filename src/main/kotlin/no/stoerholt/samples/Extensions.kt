package no.stoerholt.samples

import org.elasticsearch.action.get.GetResponse

fun GetResponse.toBook(): Book {

    val isbn = this.source.get("isbn")
    val title = this.source.get("title")
    val author = this.source.get("author")
    val publisher = this.source.get("publisher")

    return Book(isbn.toString(), title.toString(), author.toString(), publisher.toString())
}