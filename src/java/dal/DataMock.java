/**
 * @Author Philip E. Zadeh
 */

package dal;

import be.CourseModel;
import component.CourseEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
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
        CourseEntity course2 = new CourseEntity(null,0, 15, 12, 00, "Playtime", "Room 12", EnumCourseStatus.NOT_STARTED);
        CourseEntity course4 = new CourseEntity(null,13, 10, 14, 00, "SCO 1", "Room 15K", EnumCourseStatus.PARTIAL);
        CourseEntity course5 = new CourseEntity(null,14, 00, 9, 15, "DBOS 1", "Room 8", EnumCourseStatus.ATTENDED);
        CourseEntity course6 = new CourseEntity(null,15, 15, 16, 15, "ITO", "Room 99", EnumCourseStatus.ATTENDED);

        CourseEntity course7 = new CourseEntity(LocalDate.now().minusDays(1),8, 15, 9, 15, "AI", "Room 50C", EnumCourseStatus.ABSENT);
        CourseEntity course8 = new CourseEntity(LocalDate.now().minusDays(1),0, 15, 12, 00, "Playtime", "Room 1E2", EnumCourseStatus.NOT_STARTED);
        CourseEntity course10 = new CourseEntity(LocalDate.now().minusDays(1),13, 10, 14, 00, "C#", "Room 15KA", EnumCourseStatus.PARTIAL);
        CourseEntity course11 = new CourseEntity(LocalDate.now().minusDays(1),14, 00, 9, 15, "Life", "Room 8E", EnumCourseStatus.ATTENDED);
        CourseEntity course12 = new CourseEntity(LocalDate.now().minusDays(1),15, 15, 16, 15, "Ugh", "Room C9", EnumCourseStatus.ATTENDED);

        CourseEntity course13 = new CourseEntity(LocalDate.now().plusDays(1),8, 15, 9, 15, "CO2", "Room 305C", EnumCourseStatus.ABSENT);
        CourseEntity course14 = new CourseEntity(LocalDate.now().plusDays(1),9, 15, 12, 00, "Playtime", "Room 121", EnumCourseStatus.NOT_STARTED);
        CourseEntity course15 = new CourseEntity(LocalDate.now().plusDays(1),12, 00, 13, 10, "H2O", "Room 53", EnumCourseStatus.NOT_STARTED);
        CourseEntity course16 = new CourseEntity(LocalDate.now().plusDays(1),13, 10, 14, 00, "SCO3", "Room 15fK", EnumCourseStatus.PARTIAL);
        CourseEntity course17 = new CourseEntity(LocalDate.now().plusDays(1),14, 00, 9, 15, "MAT2", "Room 81", EnumCourseStatus.ATTENDED);
        CourseEntity course18 = new CourseEntity(LocalDate.now().plusDays(1),15, 15, 16, 15, "VR1", "Room 99F", EnumCourseStatus.ATTENDED);

        CourseEntity course19 = new CourseEntity(LocalDate.now().plusDays(2),8, 15, 9, 15, "SCO", "Room 30C", EnumCourseStatus.ABSENT);
        CourseEntity course20 = new CourseEntity(LocalDate.now().plusDays(2),9, 15, 12, 00, "Playtime", "Room 12", EnumCourseStatus.NOT_STARTED);
        CourseEntity course22 = new CourseEntity(LocalDate.now().plusDays(2),13, 10, 14, 00, "SCO 1", "Room 15K", EnumCourseStatus.PARTIAL);
        CourseEntity course23 = new CourseEntity(LocalDate.now().plusDays(2),14, 00, 9, 15, "DBOS 1", "Room 8", EnumCourseStatus.ATTENDED);
        CourseEntity course24 = new CourseEntity(LocalDate.now().plusDays(2),15, 15, 16, 15, "ITO", "Room 99", EnumCourseStatus.ATTENDED);
        allStudentCourses.add(course1);
        allStudentCourses.add(course2);
        allStudentCourses.add(course4);
        allStudentCourses.add(course5);
        allStudentCourses.add(course6);

        allStudentCourses.add(course7);
        allStudentCourses.add(course8);
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
        CourseEntity tCourse1 = new CourseEntity(LocalDate.now().plusDays(1),8, 15, 9, 15, "SCO", "Room 305C", EnumCourseStatus.GENERATE_QR);
        CourseEntity tCourse2 = new CourseEntity(LocalDate.now().plusDays(1),9, 15, 12, 00, "SDE", "Room 121", EnumCourseStatus.GENERATE_QR);
        CourseEntity tCourse3 = new CourseEntity(LocalDate.now().plusDays(1),12, 00, 13, 10, "ITO", "Room 53", EnumCourseStatus.GENERATE_QR);
        allTeacherCourses = new ArrayList<>();
        allStudentCourses.add(tCourse1);
        allStudentCourses.add(tCourse2);
        allStudentCourses.add(tCourse3);
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


    public XYChart.Series barChartAttendance()
    {

    XYChart.Series attendance = new XYChart.Series();


    attendance.getData().add(new XYChart.Data<>(70, "January"));
    attendance.getData().add(new XYChart.Data<>(40, "February"));
    attendance.getData().add(new XYChart.Data<>(45, "March"));
    attendance.getData().add(new XYChart.Data<>(80, "April"));
    attendance.getData().add(new XYChart.Data<>(91, "May"));
    attendance.getData().add(new XYChart.Data<>(95, "June"));
    attendance.getData().add(new XYChart.Data<>(100, "July"));
    attendance.getData().add(new XYChart.Data<>(100, "August"));
    attendance.getData().add(new XYChart.Data<>(100, "September"));
    attendance.getData().add(new XYChart.Data<>(100, "October"));
    attendance.getData().add(new XYChart.Data<>(97, "November"));
    attendance.getData().add(new XYChart.Data<>(95, "December"));

    return attendance;
    }

    public XYChart.Series barChartAbsence()
    {
        XYChart.Series absence = new XYChart.Series();
        absence.getData().add(new XYChart.Data<>(30, "January"));
        absence.getData().add(new XYChart.Data<>(60, "February"));
        absence.getData().add(new XYChart.Data<>(55, "March"));
        absence.getData().add(new XYChart.Data<>(20, "April"));
        absence.getData().add(new XYChart.Data<>(9, "May"));
        absence.getData().add(new XYChart.Data<>(5, "June"));
        absence.getData().add(new XYChart.Data<>(0, "July"));
        absence.getData().add(new XYChart.Data<>(0, "August"));
        absence.getData().add(new XYChart.Data<>(0, "September"));
        absence.getData().add(new XYChart.Data<>(0, "October"));
        absence.getData().add(new XYChart.Data<>(3, "November"));
        absence.getData().add(new XYChart.Data<>(5, "December"));

        return absence;
    }

    public ObservableList<CourseModel> TableViewCourses()
    {
        ObservableList<CourseModel> courses = FXCollections.observableArrayList();

        courses.add(new CourseModel("SCO", "97%"));
        courses.add(new CourseModel("SDE", "81%"));
        courses.add(new CourseModel("ITO", "32%"));
        courses.add(new CourseModel("DBOS", "95%"));
        courses.add(new CourseModel("MEANING OF LIFE", "42%"));

        return courses;
    }

}
