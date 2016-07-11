/**
 * Jul 7, 2016, TaskDAO.java, vuvandat
 */
package framgiavn.project02.web.dao;

import java.util.List;
import framgiavn.project02.web.model.*;

/**
 * @author vuvandat
 *
 */
public interface TaskDAO {
	
	public List<Task> getTasksBySubjectId(int subjectId) throws Exception;
}
