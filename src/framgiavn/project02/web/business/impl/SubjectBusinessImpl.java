/**
 * Jul 9, 2016, SubjectBusinessImpl.java, datvv
 */
package framgiavn.project02.web.business.impl;

import framgiavn.project02.web.business.SubjectBusiness;
import framgiavn.project02.web.dao.SubjectDAO;
import framgiavn.project02.web.model.Subject;
import framgiavn.project02.web.ulti.Logit2;

/**
 * @author datvv
 *
 */
public class SubjectBusinessImpl implements SubjectBusiness {

	private SubjectDAO subjectDAO;
	private static final Logit2 log = Logit2.getInstance(SubjectBusinessImpl.class);

	@Override
	public Subject getSubjectByUserSubjectId(int subjectId) {
		try {
			return getSubjectDAO().getSubjectByUserSubjectId(subjectId);
		} catch (Exception e) {
			log.error("get subject failed ",e);
		}
		return null;
	}

	public SubjectDAO getSubjectDAO() {
		return subjectDAO;
	}

	public void setSubjectDAO(SubjectDAO subjectDAO) {
		this.subjectDAO = subjectDAO;
	}

}
