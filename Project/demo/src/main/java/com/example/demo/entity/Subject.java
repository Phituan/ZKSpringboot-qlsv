package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class Subject {
    @Id
    private String id;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private Student student;
    private String name;

    public Subject(String id, Student student, String name) {
        this.id = id;
        this.student = student;
        this.name = name;
    }

    public Subject() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
