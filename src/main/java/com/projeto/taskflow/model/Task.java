package com.projeto.taskflow.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

// Entidade que representa uma tarefa no sistema de gerenciamento de tarefas

@Entity
@Table(name = "tasks")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Task {

    // Identificador único da tarefa, gerado automaticamente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Título da tarefa, não pode ser nulo
    @Column(nullable = false)
    private String title;

    private String description;

    // Prioridade da tarefa, representada por um enum, armazenada como string no banco de dados
    @Enumerated(EnumType.STRING)
    private Priority priority;
    
    // Status da tarefa, representada por um enum, armazenada como string no banco de dados
    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now(); // Define a data de criação como o momento atual
        this.status = status.PENDING; // Define o status padrão como PENDING
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
