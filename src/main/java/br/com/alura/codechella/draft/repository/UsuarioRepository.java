package br.com.alura.codechella.draft.repository;

import br.com.alura.codechella.draft.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
