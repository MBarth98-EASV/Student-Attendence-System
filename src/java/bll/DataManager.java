/**
 * @Author Philip E. Zadeh
 */

package bll;

import be.User;
import component.CourseEntity;
import dal.DataMock;
import util.EnumCourseStatus;

import java.util.List;

public class DataManager {

    DataMock data = null;
    private static DataManager instance = null;

    /**
     *  Singleton pattern. Ensures there is no more than a single instance of this class at a time.
     */
    public static DataManager getInstance()
    {
        if (instance == null)
        {
            instance = new DataManager();
        }

        return instance;
    }

    public void changeCourseStatus(CourseEntity course, EnumCourseStatus status){
        if (course != null){
        data.updateCourseStatus(course, status);
        }
    }



    public List<CourseEntity> getUserCourses() {
        return data.getUserCourses(getUser());
    }

    public DataManager()
    {
        data = new DataMock();
    }

    public String getUserLogin()
    {
        return data.userLogin();
    }

    public String getUserPassword()
    {
        return data.userPassword();
    }

    public User getUser()
    {
        return data.User();
    }

    public int getAbsenceTotal()
    {
        return data.totalAbsence();
    }

    public int getAttendanceTotal()
    {
        return data.totalAttendance();
    }

    public int getAbsenceWeek()
    {
        return data.weekAbsence();
    }

    public int getAttendanceWeek()
    {
        return data.weekAttendance();
    }

    public int getAttendanceMonth()
    {
    return data.monthAttendance();
    }

    public int getAbsenceMonth()
    {
        return data.monthAbsence();
    }

    public int getAbsenceYear()
    {
        return data.yearAbsence();
    }

    public int getAttendanceYear()
    {
        return data.yearAttendance();
    }

    public int percent(int a, int b)
    {
        float result = 0;
        float total = a + b;

        result = a / total * 100;

        return (int)result;
    }
}
