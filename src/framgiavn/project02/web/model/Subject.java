/**
 * Jul 7, 2016, Subject.java, vuvandat
 */
package framgiavn.project02.web.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author vuvandat
 *
 */
public class Subject implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private Date startDate;
	private Date endDate;
	private String instruction;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the instruction
	 */
	public String getInstruction() {
		return instruction;
	}

	/**
	 * @param instruction the instruction to set
	 */
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

}
