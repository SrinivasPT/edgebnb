package com.edge.shared.domain.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.*;

@MappedSuperclass
public  class AbstractAggregateRoot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
