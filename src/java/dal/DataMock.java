/**
 * @Author Philip E. Zadeh
 */

package dal;

import be.User;
import component.CourseEntity;
import util.EnumCourseStatus;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DataMock {

    public String userLogin()
        {
            return "JohnDoe420";
        }

    public String userPassword()
        {
            return "Password";
        }

    public User User()
      {
          return new User("John Doe", -1);
      }

      public List<CourseEntity> getUserCourses(User user) {
          LocalDateTime.now();
          CourseEntity course1 = new CourseEntity(null,8, 15, 9, 15, "SCO", "Room 30C", EnumCourseStatus.ABSENT);
          CourseEntity course2 = new CourseEntity(null,0, 15, 12, 00, "Playtime", "Room 12", EnumCourseStatus.NOT_STARTED);
          CourseEntity course3 = new CourseEntity(null,12, 00, 13, 10, "SDE", "Room 5", EnumCourseStatus.NONE);
          CourseEntity course4 = new CourseEntity(null,13, 10, 14, 00, "SCO 1", "Room 15K", EnumCourseStatus.PARTIAL);
          CourseEntity course5 = new CourseEntity(null,14, 00, 9, 15, "DBOS 1", "Room 8", EnumCourseStatus.ATTENDED);
          CourseEntity course6 = new CourseEntity(null,15, 15, 16, 15, "ITO", "Room 99", EnumCourseStatus.ATTENDED);

          ArrayList<CourseEntity> courseEntityList = new ArrayList<>();
          courseEntityList.add(course1);
          courseEntityList.add(course2);
          courseEntityList.add(course3);
          courseEntityList.add(course4);
          courseEntityList.add(course5);
          courseEntityList.add(course6);

          user.setCourses(courseEntityList);

          return courseEntityList;
      }

      public int totalAttendance()
    {
        return 1565;
    }

    public int totalAbsence()
    {
        return 74;
    }

    public int weekAttendance()
    {
        return 7;
    }

    public int weekAbsence()
    {
        return 2;
    }

    public int monthAttendance()
    {
        return 34;
    }

    public int monthAbsence()
    {
        return 6;
    }

    public int yearAttendance()
    {
        return 554;
    }

    public int yearAbsence()
    {
        return 44;
    }
}
