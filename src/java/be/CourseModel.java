package be;

import javafx.beans.property.SimpleStringProperty;

/**
 * @Author Philip E. Zadeh
 */

public class CourseModel {
    private SimpleStringProperty courseName, courseAttendance;

    public CourseModel(String courseName, String courseAttendance)
    {
        this.courseName = new SimpleStringProperty(courseName);
        this.courseAttendance = new SimpleStringProperty(courseAttendance);
    }

    public String getCourseName()
    {
        return this.courseName.get();
    }

    public String getCourseAttendance()
    {
        return this.courseAttendance.get();
    }

    public void setCourseName(String courseName)
    {
        this.courseName.set(courseName);
    }

    public void setCourseAttendance(String courseAttendance)
    {
        this.courseAttendance.set(courseAttendance);
    }

}
