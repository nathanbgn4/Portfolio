package beans;

import java.util.LinkedList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * This is a container for task information
 * @author Nathan
 */
@XmlRootElement(name = "Task")
public class Task {
	
	
	private String taskDescription;
	
	private LinkedList<Requirement> requirements;
	
	
	/**
	 * Gets the description of the task.
	 */
	@XmlElement(name = "taskDescription")
	public String getTaskDescription() {
		return taskDescription;
	}
	/**
	 * Sets the description of the task.
	 */
	
	public void setTaskDescription(String taskDescription) {
		
		this.taskDescription = taskDescription;
	}
	/**
	 * Gets the list of requirements for the task.
	 */
	public LinkedList<Requirement> getRequirements() {
	
		
		if(requirements == null)
		{
			requirements = new LinkedList<Requirement>();
		}
		
		return requirements;
	}
	/**
	 * Sets the list of requirements for the task.
	 */
	
	public void setRequirements(LinkedList<Requirement> requirements) {
		
		this.requirements = requirements;
	}
	/**
	 * Adds a requirement to the task.
	 */
	public void addRequirement(Requirement requirement)
	{
		
		getRequirements().add(requirement);
	}
	/**
	 * Removes a requirement to the task.
	 */
	public void removeRequirement(Requirement requirement)
	{
		
		getRequirements().remove(requirement);
	}
}
