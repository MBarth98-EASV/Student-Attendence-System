/**
 * @Author Philip E. Zadeh
 */

package bll;

import be.User;
import component.CourseEntity;
import dal.DataMock;

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

    public int getTotalAbsence()
    {
        return data.absence();
    }

    public int getTotalAttendence()
    {
        return data.attendance();
    }

}
