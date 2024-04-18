package br.com.alura.codechella.zcodedraft.service;

import br.com.alura.codechella.zcodedraft.model.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario cadastrarUsuario(Usuario usuario);

    List<Usuario> listarTodos();
}
