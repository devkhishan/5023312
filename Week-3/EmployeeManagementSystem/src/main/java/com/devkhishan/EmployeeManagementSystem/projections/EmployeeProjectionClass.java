package com.devkhishan.EmployeeManagementSystem.projections;

public class EmployeeProjectionClass
{
    private final Long id;
    private final String name;

    public EmployeeProjectionClass(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
