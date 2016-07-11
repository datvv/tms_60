/**
 * Jul 9, 2016, UserSubjectDAO.java, datvv
 */
package framgiavn.project02.web.dao;

import framgiavn.project02.web.model.UserSubject;

/**
 * @author datvv
 *
 */
public interface UserSubjectDAO {

	public UserSubject getUserSubjectByUserSubjectId(int userSubjectId) throws Exception;

	public UserSubject getUserSubjectByUserSubjectCourse(int userId, int subjectId, int courseId) throws Exception;
}
