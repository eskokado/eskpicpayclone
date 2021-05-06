package br.com.dio.eskpicpayclone.models;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class EntityBase {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
