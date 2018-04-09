package no.stoerholt.samples

data class Book(
        val isbn: String = generateId(),
        val title: String,
        val author: String,
        val publisher: String
) {constructor(
        title: String,
        author: String,
        publisher: String)
        : this(generateId(), title, author, publisher)}
