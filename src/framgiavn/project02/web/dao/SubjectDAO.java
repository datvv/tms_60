/**
 * Jul 9, 2016, SubjectDAO.java, datvv
 */
package framgiavn.project02.web.dao;

import framgiavn.project02.web.model.Subject;

/**
 * @author datvv
 *
 */
public interface SubjectDAO {
	
	public Subject getSubjectByUserSubjectId(int subjectId) throws Exception;
}
