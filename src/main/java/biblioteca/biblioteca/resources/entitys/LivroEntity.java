package biblioteca.biblioteca.resources.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table (name = "livro")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LivroEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;
    private String autor;
    private String editora;
    private Integer anoLancamento;

}
