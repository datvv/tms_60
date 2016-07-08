/**
 * Jul 7, 2016, TaskBusiness.java, datvv
 */
package framgiavn.project02.web.business;

import java.util.HashMap;
import java.util.List;

import framgiavn.project02.web.model.Task;

/**
 * @author datvv
 *
 */
public interface TaskBusiness {
	
	public List<Task> getTasksBySubjectId(int subjectId);
	
	public List<Task> getTasksByUserIdAndSubjectId(int userId, int subjectId);
}
