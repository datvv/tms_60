package framgiavn.project02.web.business;

import java.util.List;

import framgiavn.project02.web.model.Course;
import framgiavn.project02.web.model.Subject;

/**
 * @author nguyenanhvan
 *
 */
public interface CourseBusiness {

	public Course findCourseById(Integer courseId) throws Exception;

	public List<Subject> getSubjectList(Integer courseId) throws Exception;

	public void retrieveCourseDetail(Integer courseId) throws Exception;

}
