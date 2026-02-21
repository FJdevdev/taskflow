package com.projeto.taskflow.repository;

import com.projeto.taskflow.model.Priority;
import com.projeto.taskflow.model.Status;
import com.projeto.taskflow.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Interface de repositório para a entidade Task, estendendo JpaRepository para fornecer operações CRUD básicas e métodos personalizados para consultas específicas
public interface TaskRepository extends JpaRepository<Task, Long> {

    // Métodos personalizados para buscar tarefas por status, prioridade ou ambos
    List<Task> findByStatus(Status status);
    List<Task> findByPriority(Priority priority);
    List<Task> findByStatusAndPriority(Status status, Priority priority);
}
