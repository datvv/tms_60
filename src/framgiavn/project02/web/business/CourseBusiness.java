package framgiavn.project02.web.business;

import java.util.List;
import java.util.Map;
import java.util.Set;
import framgiavn.project02.web.model.Course;
import framgiavn.project02.web.model.Subject;
import framgiavn.project02.web.model.User;

/**
 * @author nguyenanhvan
 *
 */
public interface CourseBusiness {

	public Course findCourseById(Integer courseId) throws Exception;

	public List<Subject> getSubjectList(Integer courseId) throws Exception;

	public void retrieveCourseDetail(Integer courseId) throws Exception;

	public void addAndSave(Course course) throws Exception;

	public void deleteCourse(int courseId) throws Exception;

	public void addUserCourse(int courseId, List<Integer> choseUsers) throws Exception;

	public Map<String, Map<Course, Set<? extends Object>>> showCourseDetail(int courseId) throws Exception;

	public List<User> getUsersExternalCourse(int courseId) throws Exception;

}
