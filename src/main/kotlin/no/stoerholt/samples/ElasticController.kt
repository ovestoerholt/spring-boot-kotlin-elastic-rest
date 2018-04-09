package no.stoerholt.samples

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/books")
class ElasticController {

    @Autowired
    lateinit var elasticRepo: ElasticRepo;

    //@GetMapping("/{id}")
    fun getDummyBook(@PathVariable id: String): ResponseEntity<Book> {

        val book: Book = Book("Harry Hole", "Jo Nesbø", "Cappelen")
        return ResponseEntity.ok(book)
    }

    @GetMapping("/{id}")
    fun getBookById(@PathVariable id: String): ResponseEntity<Book> {

        val book: Book = elasticRepo.getBookById(id)


        return ResponseEntity.ok(book)
    }
};