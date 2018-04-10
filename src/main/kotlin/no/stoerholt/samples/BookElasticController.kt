package no.stoerholt.samples

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/books")
class BookElasticController {

    @Autowired
    lateinit var bookElasticService: BookElasticService;

    @GetMapping("/{id}")
    fun getBookById(@PathVariable id: String): ResponseEntity<Book> {

        val book = bookElasticService.getBookById(id)
        return ResponseEntity.ok(book)
    }


    @PostMapping("/")
    fun insertBook(@RequestBody book: Book): ResponseEntity<Book>? {
        // TODO - bad request
        if (bookElasticService.insertBook(book)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(book)
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(book)
        }
    }
}