package biblioteca.biblioteca.resources.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import biblioteca.biblioteca.resources.entitys.LivroEntity;

public interface LivroRepository extends JpaRepository<LivroEntity, Integer> {
}
