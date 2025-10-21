package biblioteca.biblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import biblioteca.biblioteca.resources.entitys.LivroEntity;
import biblioteca.biblioteca.resources.repository.LivroRepository;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    public void Create(LivroEntity livro) {
        repository.save(livro);
    }

    public LivroEntity Find(Integer id){
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Erro")
        );
    }
    
    public void Update(Integer id, LivroEntity novasInfosLivro){
        LivroEntity livroReserva = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Livro não encontrado.\n")
        );
        
        LivroEntity novoLivro = LivroEntity.builder()
                .id(id)
                .titulo(novasInfosLivro.getTitulo().isEmpty() ? livroReserva.getTitulo() : novasInfosLivro.getTitulo())
                .autor(novasInfosLivro.getAutor().isEmpty() ? livroReserva.getAutor() : novasInfosLivro.getAutor())
                .editora(novasInfosLivro.getEditora().isEmpty() ? livroReserva.getEditora() : novasInfosLivro.getEditora())
                .anoLancamento(novasInfosLivro.getAnoLancamento() == null ? livroReserva.getAnoLancamento() : novasInfosLivro.getAnoLancamento())
                .build();

        repository.save(novoLivro);
    }

}
