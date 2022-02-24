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

    List<CourseEntity> allStudentCourses;
    List<CourseEntity> allTeacherCourses;

    public DataMock() {
    allStudentCourses = new ArrayList<>();
        CourseEntity course1 = new CourseEntity(null,8, 15, 9, 15, "SCO", "Room 30C", EnumCourseStatus.ABSENT);
<<<<<<< HEAD
        CourseEntity course2 = new CourseEntity(null,0, 15, 12, 00, "Playtime", "Room 12", EnumCourseStatus.NOT_STARTED);
        CourseEntity course4 = new CourseEntity(null,13, 10, 14, 00, "SCO 1", "Room 15K", EnumCourseStatus.PARTIAL);
        CourseEntity course5 = new CourseEntity(null,14, 00, 9, 15, "DBOS 1", "Room 8", EnumCourseStatus.ATTENDED);
        CourseEntity course6 = new CourseEntity(null,15, 15, 16, 15, "ITO", "Room 99", EnumCourseStatus.ATTENDED);

        CourseEntity course7 = new CourseEntity(LocalDate.now().minusDays(1),8, 15, 9, 15, "AI", "Room 50C", EnumCourseStatus.ABSENT);
        CourseEntity course8 = new CourseEntity(LocalDate.now().minusDays(1),0, 15, 12, 00, "Playtime", "Room 1E2", EnumCourseStatus.NOT_STARTED);
=======
        CourseEntity course2 = new CourseEntity(null,9, 15, 12, 00, "UIX", "Room 12", EnumCourseStatus.ABSENT);
        CourseEntity course3 = new CourseEntity(null,12, 00, 13, 10, "SDE", "Room 5", EnumCourseStatus.PARTIAL);
        CourseEntity course4 = new CourseEntity(null,13, 10, 14, 00, "SCO", "Room 15K", EnumCourseStatus.ATTENDED);
        CourseEntity course5 = new CourseEntity(null,14, 00, 9, 15, "DBOS", "Room 8", EnumCourseStatus.ABSENT);
        CourseEntity course6 = new CourseEntity(null,15, 15, 16, 15, "ITO", "Room 99", EnumCourseStatus.NOT_STARTED);

        CourseEntity course7 = new CourseEntity(LocalDate.now().minusDays(1),8, 15, 9, 15, "AI", "Room 50C", EnumCourseStatus.ABSENT);
        CourseEntity course8 = new CourseEntity(LocalDate.now().minusDays(1),9, 15, 12, 00, "Playtime", "Room 1E2", EnumCourseStatus.NOT_STARTED);
        CourseEntity course9 = new CourseEntity(LocalDate.now().minusDays(1),12, 00, 13, 10, "JAVA", "Room 5G", EnumCourseStatus.NONE);
>>>>>>> ee3b3ddf8880bbdc1326c644d574e8ae9411c3de
        CourseEntity course10 = new CourseEntity(LocalDate.now().minusDays(1),13, 10, 14, 00, "C#", "Room 15KA", EnumCourseStatus.PARTIAL);
        CourseEntity course11 = new CourseEntity(LocalDate.now().minusDays(1),14, 00, 9, 15, "Life", "Room 8E", EnumCourseStatus.ATTENDED);
        CourseEntity course12 = new CourseEntity(LocalDate.now().minusDays(1),15, 15, 16, 15, "Ugh", "Room C9", EnumCourseStatus.ATTENDED);

        CourseEntity course13 = new CourseEntity(LocalDate.now().plusDays(1),8, 15, 9, 15, "CO2", "Room 305C", EnumCourseStatus.ABSENT);
        CourseEntity course14 = new CourseEntity(LocalDate.now().plusDays(1),9, 15, 12, 00, "Playtime", "Room 121", EnumCourseStatus.NOT_STARTED);
        CourseEntity course15 = new CourseEntity(LocalDate.now().plusDays(1),12, 00, 13, 10, "H2O", "Room 53", EnumCourseStatus.NOT_STARTED);
        CourseEntity course16 = new CourseEntity(LocalDate.now().plusDays(1),13, 10, 14, 00, "SCO3", "Room 15fK", EnumCourseStatus.PARTIAL);
        CourseEntity course17 = new CourseEntity(LocalDate.now().plusDays(1),14, 00, 9, 15, "MAT2", "Room 81", EnumCourseStatus.ATTENDED);
        CourseEntity course18 = new CourseEntity(LocalDate.now().plusDays(1),15, 15, 16, 15, "VR1", "Room 99F", EnumCourseStatus.ATTENDED);
<<<<<<< HEAD
        allCourses.add(course1);
        allCourses.add(course2);
        allCourses.add(course4);
        allCourses.add(course5);
        allCourses.add(course6);

        allCourses.add(course7);
        allCourses.add(course8);
        allCourses.add(course10);
        allCourses.add(course11);
        allCourses.add(course12);

        allCourses.add(course13);
        allCourses.add(course14);
        allCourses.add(course15);
        allCourses.add(course16);
        allCourses.add(course17);
        allCourses.add(course18);
=======

        CourseEntity course19 = new CourseEntity(LocalDate.now().plusDays(2),8, 15, 9, 15, "SCO", "Room 30C", EnumCourseStatus.ABSENT);
        CourseEntity course20 = new CourseEntity(LocalDate.now().plusDays(2),9, 15, 12, 00, "Playtime", "Room 12", EnumCourseStatus.NOT_STARTED);
        CourseEntity course21 = new CourseEntity(LocalDate.now().plusDays(2),12, 00, 13, 10, "SDE", "Room 5", EnumCourseStatus.NONE);
        CourseEntity course22 = new CourseEntity(LocalDate.now().plusDays(2),13, 10, 14, 00, "SCO 1", "Room 15K", EnumCourseStatus.PARTIAL);
        CourseEntity course23 = new CourseEntity(LocalDate.now().plusDays(2),14, 00, 9, 15, "DBOS 1", "Room 8", EnumCourseStatus.ATTENDED);
        CourseEntity course24 = new CourseEntity(LocalDate.now().plusDays(2),15, 15, 16, 15, "ITO", "Room 99", EnumCourseStatus.ATTENDED);
        allStudentCourses.add(course1);
        allStudentCourses.add(course2);
        allStudentCourses.add(course3);
        allStudentCourses.add(course4);
        allStudentCourses.add(course5);
        allStudentCourses.add(course6);

        allStudentCourses.add(course7);
        allStudentCourses.add(course8);
        allStudentCourses.add(course9);
        allStudentCourses.add(course10);
        allStudentCourses.add(course11);
        allStudentCourses.add(course12);

        allStudentCourses.add(course13);
        allStudentCourses.add(course14);
        allStudentCourses.add(course15);
        allStudentCourses.add(course16);
        allStudentCourses.add(course17);
        allStudentCourses.add(course18);

        // TEACHER
        CourseEntity tCourse1 = new CourseEntity(LocalDate.now().plusDays(1),8, 15, 9, 15, "SCO", "Room 305C", null);
        CourseEntity tCourse2 = new CourseEntity(LocalDate.now().plusDays(1),9, 15, 12, 00, "SDE", "Room 121", null);
        CourseEntity tCourse3 = new CourseEntity(LocalDate.now().plusDays(1),12, 00, 13, 10, "ITO", "Room 53", null);
        allTeacherCourses = new ArrayList<>();
        allStudentCourses.add(tCourse1);
        allStudentCourses.add(tCourse2);
        allStudentCourses.add(tCourse3);
>>>>>>> ee3b3ddf8880bbdc1326c644d574e8ae9411c3de

    }

    public String userLogin()
        {
            return "JohnDoe420";
        }

    public String userPassword()
        {
            return "Password";
        }

    public List<CourseEntity> getAllTeacherCourses() {
        return allTeacherCourses;
    }

    public List<CourseEntity> getUserCourses(LocalDate day) {
            ArrayList<CourseEntity> returnList = new ArrayList<>();
          for (CourseEntity course : allStudentCourses) {
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
