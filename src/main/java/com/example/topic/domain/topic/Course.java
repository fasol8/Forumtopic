package com.example.topic.domain.topic;

import jakarta.persistence.*;

@Table(name = "course")
@Entity(name = "Course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_course")
    private int idCourse;
    private String name;
    private String category;

    public Course() {}

    public Course(CourseData courseData) {
        this.idCourse=courseData.getIdCourse();
        this.name = courseData.getName();
        this.category = courseData.getCategory();
    }

    // Getters y setters
    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
