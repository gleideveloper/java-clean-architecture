package br.com.alura.codechella.zcodedraft.repository;

import br.com.alura.codechella.zcodedraft.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
