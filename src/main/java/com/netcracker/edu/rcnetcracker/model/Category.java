package com.netcracker.edu.rcnetcracker.model;

public class Category {

    private Long id;
    private String name;
    private Boolean important;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isImportant() {
        return important;
    }

    public void setImportant(Boolean important) {
        this.important = important;
    }
}
