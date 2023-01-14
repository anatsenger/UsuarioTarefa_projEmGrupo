package com.example.demo.Service;

import com.example.demo.Repository.UsuarioRepository;
import com.example.demo.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvar(Usuario usuario){
        return  usuarioRepository.save(usuario);
    }

    public Usuario recuperar(Long id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario atualizar(Long id, Usuario usuario){
        Usuario usuarioEncontrado = recuperar(id);
        if(usuarioEncontrado == null){
            throw new IllegalArgumentException("Usuario não encontrado");
        }
        usuario.setId(id);
        return usuarioRepository.save(usuario);
    }

    public String deletar(Long id){
        Usuario usuarioEncontrado = recuperar(id);
        if(usuarioEncontrado == null){
            throw new IllegalArgumentException("Usuario não encontrado");
        }
        usuarioRepository.delete(usuarioEncontrado);
        return "Usuário deletado";
    }

    public List<Usuario> listar(){
        return (List<Usuario>) usuarioRepository.findAll();
    }
}
