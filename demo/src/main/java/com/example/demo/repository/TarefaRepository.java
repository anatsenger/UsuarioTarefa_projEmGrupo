package com.example.demo.repository;

import com.example.demo.model.Tarefa;
import com.example.demo.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TarefaRepository extends CrudRepository<Tarefa, Long> {
    List<Tarefa> findByResponsavel(Usuario usuario);
}
