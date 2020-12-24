package com.example.demo.entity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String fullName;
    private int gender;
    private String dateOfBirth;
    private String address;
    @OneToMany(mappedBy = "student", cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private Set<Scores> scores;
    @OneToMany(mappedBy = "student", cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private Set<Subject> subject;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "class_id")
    private ClassSv classSv;
    private long deletedAt;
    private long createdAt;
    private long updatedAt;
    private int status;

    public Student() {
        this.createdAt = Calendar.getInstance().getTimeInMillis();
        this.updatedAt = Calendar.getInstance().getTimeInMillis();
        this.status = Status.ACTIVE.getValue();
        this.id = Calendar.getInstance().getTimeInMillis();
    }

    public Student(long id, String fullName, int gender, String dateOfBirth, String address, Set<Scores> scores, Set<Subject> subject, ClassSv classSv, long deletedAt, long createdAt, long updatedAt, int status) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.scores = scores;
        this.subject = subject;
        this.classSv = classSv;
        this.deletedAt = deletedAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
    }

    public ClassSv getClassSv() {
        return classSv;
    }

    public void setClassSv(ClassSv classSv) {
        this.classSv = classSv;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public Set<Scores> getScores() {
        return scores;
    }

    public void setScores(Set<Scores> scores) {
        this.scores = scores;
    }

    public Set<Subject> getSubject() {
        return subject;
    }

    public void setSubject(Set<Subject> subject) {
        this.subject = subject;
    }


    public long getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(long deletedAt) {
        this.deletedAt = deletedAt;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public enum Status {
        ACTIVE(1), UNACTIVE(0), DELETE(-1);

        int value;

        Status(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static Status findByValue(int value) {
            for (Status status : Status.values()) {
                if (status.getValue() == value) {
                    return status;
                }
            }
            return null;
        }
    }
    public enum Gender {
        BOY(1),
        GIRL(2),
        OTHER(0);
        int value;

        Gender(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static Gender findByValue(int value) {
            for (Gender gender : Gender.values()) {
                if (gender.getValue() == value) {
                    return gender;
                }
            }
            return null;
        }
    }


}
