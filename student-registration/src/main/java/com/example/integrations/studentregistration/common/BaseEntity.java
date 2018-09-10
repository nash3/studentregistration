package com.example.integrations.studentregistration.common;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity extends AuditedEntity{
    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
