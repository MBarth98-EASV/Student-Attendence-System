package be;

import component.CourseEntity;

import java.util.List;

public class User {

    private int userID;
    private String name;
    private List<CourseEntity> courses;

    public User(String name, int userID){
        this.name = name;
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CourseEntity> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseEntity> courses) {
        this.courses = courses;
    }
}
