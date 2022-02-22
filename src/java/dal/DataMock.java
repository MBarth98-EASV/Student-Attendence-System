/**
 * @Author Philip E. Zadeh
 */

package dal;

import component.CourseEntity;
import util.EnumCourseStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataMock {

    List<CourseEntity> allCourses;

    public DataMock() {
    allCourses = new ArrayList<>();
        CourseEntity course1 = new CourseEntity(null,8, 15, 9, 15, "SCO", "Room 30C", EnumCourseStatus.ABSENT);
        CourseEntity course2 = new CourseEntity(null,0, 15, 12, 00, "Playtime", "Room 12", EnumCourseStatus.NOT_STARTED);
        CourseEntity course3 = new CourseEntity(null,12, 00, 13, 10, "SDE", "Room 5", EnumCourseStatus.NONE);
        CourseEntity course4 = new CourseEntity(null,13, 10, 14, 00, "SCO 1", "Room 15K", EnumCourseStatus.PARTIAL);
        CourseEntity course5 = new CourseEntity(null,14, 00, 9, 15, "DBOS 1", "Room 8", EnumCourseStatus.ATTENDED);
        CourseEntity course6 = new CourseEntity(null,15, 15, 16, 15, "ITO", "Room 99", EnumCourseStatus.ATTENDED);

        CourseEntity course7 = new CourseEntity(LocalDate.now().minusDays(1),8, 15, 9, 15, "AI", "Room 50C", EnumCourseStatus.ABSENT);
        CourseEntity course8 = new CourseEntity(LocalDate.now().minusDays(1),0, 15, 12, 00, "Playtime", "Room 1E2", EnumCourseStatus.NOT_STARTED);
        CourseEntity course9 = new CourseEntity(LocalDate.now().minusDays(1),12, 00, 13, 10, "JAVA", "Room 5G", EnumCourseStatus.NONE);
        CourseEntity course10 = new CourseEntity(LocalDate.now().minusDays(1),13, 10, 14, 00, "C#", "Room 15KA", EnumCourseStatus.PARTIAL);
        CourseEntity course11 = new CourseEntity(LocalDate.now().minusDays(1),14, 00, 9, 15, "Life", "Room 8E", EnumCourseStatus.ATTENDED);
        CourseEntity course12 = new CourseEntity(LocalDate.now().minusDays(1),15, 15, 16, 15, "Ugh", "Room C9", EnumCourseStatus.ATTENDED);

        CourseEntity course13 = new CourseEntity(LocalDate.now().plusDays(1),8, 15, 9, 15, "CO2", "Room 305C", EnumCourseStatus.ABSENT);
        CourseEntity course14 = new CourseEntity(LocalDate.now().plusDays(1),0, 15, 12, 00, "Playtime", "Room 121", EnumCourseStatus.NOT_STARTED);
        CourseEntity course15 = new CourseEntity(LocalDate.now().plusDays(1),12, 00, 13, 10, "H2O", "Room 53", EnumCourseStatus.NONE);
        CourseEntity course16 = new CourseEntity(LocalDate.now().plusDays(1),13, 10, 14, 00, "SCO3", "Room 15fK", EnumCourseStatus.PARTIAL);
        CourseEntity course17 = new CourseEntity(LocalDate.now().plusDays(1),14, 00, 9, 15, "MAT2", "Room 81", EnumCourseStatus.ATTENDED);
        CourseEntity course18 = new CourseEntity(LocalDate.now().plusDays(1),15, 15, 16, 15, "VR1", "Room 99F", EnumCourseStatus.ATTENDED);
        allCourses.add(course1);
        allCourses.add(course2);
        allCourses.add(course3);
        allCourses.add(course4);
        allCourses.add(course5);
        allCourses.add(course6);

        allCourses.add(course7);
        allCourses.add(course8);
        allCourses.add(course9);
        allCourses.add(course10);
        allCourses.add(course11);
        allCourses.add(course12);

        allCourses.add(course13);
        allCourses.add(course14);
        allCourses.add(course15);
        allCourses.add(course16);
        allCourses.add(course17);
        allCourses.add(course18);

    }

    public String userLogin()
        {
            return "JohnDoe420";
        }

    public String userPassword()
        {
            return "Password";
        }


      public List<CourseEntity> getCourses(LocalDate day) {
            ArrayList<CourseEntity> returnList = new ArrayList<>();
          for (CourseEntity course : allCourses) {
              if (course.getDate().isEqual(day)){
                  returnList.add(course);
              }
          }
        return returnList;
      }

      public int totalAttendance()
    {
        return 1565;
    }

    public void updateCourseStatus(CourseEntity course, EnumCourseStatus status){
        course.setStatus(status);
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
