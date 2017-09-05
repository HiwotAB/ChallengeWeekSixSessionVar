package com.hiwotab.roboresumeapplication.model;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    @Size(min=2, max = 30)
    private String firstname;

    @NotEmpty
    @Size(min=2, max = 30)
    private String lastname;

    @NotEmpty
    @Email
    private String email;

    @OneToMany(mappedBy = "resume",cascade= CascadeType.ALL,fetch=FetchType.EAGER)
    public Set<EduAchievements> eduAchievementsSet;

    @OneToMany(mappedBy = "resume",cascade= CascadeType.ALL,fetch=FetchType.EAGER)
    public Set<Skills> skillsSet;

    @OneToMany(mappedBy = "resume",cascade= CascadeType.ALL,fetch=FetchType.EAGER)
    public Set<WorkExperiences> workExperiencesSet;

    @ManyToMany()
    private Set<Course> teach;

    //constructor for resume and  initialize an empty set of education, skill and exp
    public Resume(){
        this.eduAchievementsSet= new HashSet<EduAchievements>();
        this.skillsSet=new HashSet<Skills>();
        this.workExperiencesSet=new HashSet<WorkExperiences>();
        this.teach = new HashSet<Course>();
    }
    public Set<EduAchievements> getEduAchievementsSet() {
        return eduAchievementsSet;
    }

    public void setEduAchievementsSet(Set<EduAchievements> eduAchievementsSet) {
        this.eduAchievementsSet = eduAchievementsSet;
    }

    public Set<Skills> getSkillsSet() {
        return skillsSet;
    }

    public void setSkillsSet(Set<Skills> skillsSet) {
        this.skillsSet = skillsSet;
    }

    public Set<WorkExperiences> getWorkExperiencesSet() {
        return workExperiencesSet;
    }

    public void setWorkExperiencesSet(Set<WorkExperiences> workExperiencesSet) {
        this.workExperiencesSet = workExperiencesSet;
    }

    public Set<Course> getTeach() {
        return teach;
    }

    public void setTeach(Set<Course> teach) {
        this.teach = teach;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {return firstname; }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addEduAchievements(EduAchievements eduAchievements){
        eduAchievements.setResume(this);
        this.eduAchievementsSet.add(eduAchievements);
    }
    public void addSkills(Skills skills){
        skills.setResume(this);
        this.skillsSet.add(skills);
    }
    public void addWorkExperiences(WorkExperiences workExperiences){
        workExperiences.setResume(this);
        this.workExperiencesSet.add(workExperiences);
    }
    public void addCourse(Course course)
    {
        this.teach.add(course);
    }

}
