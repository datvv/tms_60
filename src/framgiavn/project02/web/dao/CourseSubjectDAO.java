/**
 * Jul 20, 2016, CourseSubject.java, datvv
 */
package framgiavn.project02.web.dao;

import framgiavn.project02.web.model.CourseSubject;

/**
 * @author datvv
 *
 */
public interface CourseSubjectDAO {

	public CourseSubject getCourseSubjectByCourseIdAndSubjectId(int courseId, int subjectId) throws Exception;
}
