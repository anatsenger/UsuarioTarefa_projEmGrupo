package com.example.demo.Controller;

import com.example.demo.Service.TarefaService;
import com.example.demo.model.Tarefa;

import com.example.demo.model.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public Tarefa salvar(@RequestBody Tarefa tarefa){
        return tarefaService.salvar(tarefa);
    }

    @PutMapping("/{id}")
    public Tarefa atualizar(@PathVariable Long id, @RequestBody Tarefa tarefa){
        return tarefaService.atualizar(id, tarefa);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id){
        return tarefaService.deletar(id);
    }

    @GetMapping
    public List<Tarefa> listar(){
        return tarefaService.listar();
    }

    @GetMapping("/{id}")
    public List<Tarefa> listarPorResponsavel(@PathVariable Usuario usuario){
        return tarefaService.listarPorUsuario(usuario);
    }
}
