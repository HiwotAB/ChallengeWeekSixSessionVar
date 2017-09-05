package com.hiwotab.roboresumeapplication.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @NotEmpty
    String courseName;
    String courseCreditHr;


    @ManyToMany(mappedBy="teach")
    private Set<Resume> resumeSet;


    public Course()
    {
        resumeSet = new HashSet<Resume>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCreditHr() {
        return courseCreditHr;
    }

    public void setCourseCreditHr(String courseCreditHr) {
        this.courseCreditHr = courseCreditHr;
    }

    public Set<Resume> getResumeSet() {
        return resumeSet;
    }

    public void setResumeSet(Set<Resume> resumeSet) {
        this.resumeSet = resumeSet;
    }

    public void addResume(Resume resume)
    {
        resumeSet.add(resume);
    }
}
