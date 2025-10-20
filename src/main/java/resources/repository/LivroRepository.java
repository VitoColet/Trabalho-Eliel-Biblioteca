package resources.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import resources.entitys.LivroEntity;

public interface LivroRepository extends JpaRepository<LivroEntity, Integer> {
}
