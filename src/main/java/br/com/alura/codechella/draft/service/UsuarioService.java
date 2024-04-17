package br.com.alura.codechella.draft.service;

import br.com.alura.codechella.draft.model.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario cadastrarUsuario(Usuario usuario);

    List<Usuario> listarTodos();
}
