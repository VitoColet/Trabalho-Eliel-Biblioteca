package biblioteca.biblioteca.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import biblioteca.biblioteca.resources.entitys.LivroEntity;
import biblioteca.biblioteca.service.LivroService;

@RestController
@RequestMapping("/livro")
@CrossOrigin
public class LivroController {


    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    @CrossOrigin
    @GetMapping (value = "/{id}")
    public ResponseEntity<LivroEntity> getRequest(@PathVariable Integer id){
        return ResponseEntity.ok(service.Find(id));
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Void> postRequest(@RequestBody LivroEntity livro){
        service.Create(livro);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin
    @PutMapping (value = "/{id}")
    public ResponseEntity<Void> putRequest(@PathVariable Integer id, @RequestBody LivroEntity livro){
        service.Update(id, livro);
        return ResponseEntity.ok().build();
    }
}
