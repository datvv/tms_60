/**
 * Jul 21, 2016, CourseSubjectBusiness.java, datvv
 */
package framgiavn.project02.web.business;

import framgiavn.project02.web.model.CourseSubject;

/**
 * @author datvv
 *
 */
public interface CourseSubjectBusiness {

	public CourseSubject getCourseSubjectByCourseIdAndSubjectId(int courseId, int subjectId) throws Exception;
}
