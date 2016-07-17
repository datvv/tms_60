package framgiavn.project02.web.dao;

import java.util.List;

import framgiavn.project02.web.model.Course;
import framgiavn.project02.web.model.Subject;

/**
 * @author nguyenanhvan
 *
 */
public interface CourseDAO {

	public List<Subject> getSubjectList(Integer courseId) throws Exception;

	public Course findCourseById(Integer courseId) throws Exception;

	public void addAndSaveCourse(Course course) throws Exception;

	public void deleteCourse(Course course) throws Exception;

}
