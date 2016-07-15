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

}
