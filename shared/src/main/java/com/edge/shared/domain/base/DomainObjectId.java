package com.edge.shared.domain.base;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.lang.NonNull;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

public abstract class DomainObjectId implements ValueObject {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonCreator
    protected DomainObjectId() {

    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DomainObjectId that = (DomainObjectId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "DomainObjectId{" +
                "id=" + id +
                '}';
    }
}
