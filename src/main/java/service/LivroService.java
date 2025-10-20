package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import resources.entitys.LivroEntity;
import resources.repository.LivroRepository;

public class LivroService {

    @Autowired
    private LivroRepository repository;

    public void Create(LivroEntity livro) {
        repository.saveAndFlush(livro);
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
