package com.learning.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "course")
public class Course {

    @NotNull
    @Id
    Long id;
    @NotNull
    String name;
    @NotNull
    @Enumerated(EnumType.STRING)
    CourseType courseType;
    @NotNull
    Double grade;

    public Course(){

    }

    public Course(@NotNull Long id, @NotNull String name, @NotNull CourseType courseType, @NotNull Double grade) {
        this.id = id;
        this.name = name;
        this.courseType = courseType;
        this.grade = grade;
    }

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

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}
