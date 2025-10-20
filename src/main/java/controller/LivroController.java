package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import resources.entitys.LivroEntity;
import service.LivroService;

@RestController
@RequestMapping("/livro")
public class LivroController {

    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    @GetMapping (value = "/{id}")
    public ResponseEntity<LivroEntity> getRequest(@PathVariable Integer id){
        return ResponseEntity.ok(service.Find(id));
    }

    @PostMapping
    public ResponseEntity<Void> postRequest(@RequestBody LivroEntity livro){
        service.Create(livro);
        return ResponseEntity.ok().build();
    }

    @PutMapping (value = "/{id}")
    public ResponseEntity<Void> putRequest(@PathVariable Integer id, @RequestBody LivroEntity livro){
        service.Update(id, livro);
        return ResponseEntity.ok().build();
    }
}
