package com.example.demo.Controller;

import com.example.demo.Service.UsuarioService;
import com.example.demo.model.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @PostMapping
    public Usuario salvar(@RequestBody Usuario usuario){
        return usuarioService.salvar(usuario);
    }

    @GetMapping("/{id}")
    public Usuario recuperar(@PathVariable Long id){
        return usuarioService.recuperar(id);
    }

    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Long id, @RequestBody Usuario usuario){
        return usuarioService.atualizar(id, usuario);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id){
        return usuarioService.deletar(id);
    }

    @GetMapping
    public List<Usuario> listar(){
        return  usuarioService.listar();
    }
}
