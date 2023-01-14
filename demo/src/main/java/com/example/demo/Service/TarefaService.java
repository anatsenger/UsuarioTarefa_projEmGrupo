package com.example.demo.Service;

import com.example.demo.Repository.TarefaRepository;
import com.example.demo.model.Tarefa;
import com.example.demo.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {
    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public Tarefa salvar(Tarefa tarefa){
        return  tarefaRepository.save(tarefa);
    }

    public Tarefa recuperar(Long id){
        return tarefaRepository.findById(id).orElse(null);
    }

    public Tarefa atualizar(Long id, Tarefa tarefa){
        Tarefa tarefaEncontrada = recuperar(id);
        if(tarefaEncontrada == null){
            throw new IllegalArgumentException("Usuario não encontrado");
        }
        tarefa.setId(id);
        return tarefaRepository.save(tarefa);
    }

    public String deletar(Long id){
        Tarefa tarefaEncontrada = recuperar(id);
        if(tarefaEncontrada == null){
            throw new IllegalArgumentException("Usuario não encontrado");
        }
        tarefaRepository.delete(tarefaEncontrada);
        return "Tarefa deletada";
    }

    public List<Tarefa> listar(){
        return (List<Tarefa>) tarefaRepository.findAll();
    }

    public List<Tarefa> listarUsuario(Usuario usuario){
        return tarefaRepository.findByResponsavel(usuario);
    }
}
