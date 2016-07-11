/**
 * Jul 15, 2016, SubjectScreenBusiness.java, datvv
 */
package framgiavn.project02.web.business;

import java.util.List;
import framgiavn.project02.web.model.Activity;
import framgiavn.project02.web.model.Task;
import framgiavn.project02.web.model.UserSubject;

/**
 * @author datvv
 *
 */
public interface SubjectScreenBusiness {
	
	public UserSubject getUserSubjectByUserSubjectId(int userSubjectId);
	
	public UserSubject getUserSubjectByUserSubjectCourse(int userId, int subjectId, int courseId);
	
	public List<Activity> editTaskStatus(int userId, List<Task> taskList, UserSubject userSubject);
}
