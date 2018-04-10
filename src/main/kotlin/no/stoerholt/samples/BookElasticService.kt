package no.stoerholt.samples

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BookElasticService {

    @Autowired
    lateinit var bookElasticRepo: BookElasticRepo

    fun getBookById(id: String): Book {
        return bookElasticRepo.getBookById(id)
    }

    fun insertBook(book: Book): Boolean {
        return bookElasticRepo.insertBook(book)
    }

    fun search(): List<Book> {
        return bookElasticRepo.search()
    }
}
