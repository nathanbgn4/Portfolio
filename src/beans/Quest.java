package beans;

import java.util.LinkedList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
/**
 * This is a container for quest information
 * @author Nathan
 */
@XmlRootElement(name = "Quest")
public class Quest {
	
	private String questName;
	private String questOrigin;
	private String questDescription;
	
	//private Enum<QuestType> questtype;
	
	private LinkedList<Task> tasks;
	
	
	private LinkedList<Reward> rewards;
	
	/**
	 * Gets the name of the quest.
	 */
	@XmlElement(name = "questName")
	public String getQuestName() {
		return questName;
	}
	
	/**
	 * Sets the name of the quest.
	 */
	public void setQuestName(String questName) {
		this.questName = questName;
	}
	
	/**
	 * Gets the origin of the quest.
	 */
	@XmlElement(name = "questOrigin")
	public String getQuestOrigin() {
		
		return questOrigin;
	}
	
	/**
	 * Sets the origin of the quest.
	 */
	public void setQuestOrigin(String questOrigin) {
		
		this.questOrigin = questOrigin;
	}
	
	/**
	 * Gets the description of the quest
	 */
	@XmlElement(name = "questDescription")
	public String getQuestDescription() {
		
		return questDescription;
	}
	/**
	 * Sets the description of the quest.
	 */
	public void setQuestDescription(String questDescription) {
		
		this.questDescription = questDescription;
	}
	
	/**
	 * Gets the list of quest tasks.
	 */
	public LinkedList<Task> getTasks() {
		
		if(tasks == null)
		{
			tasks = new LinkedList<Task>();
		}
		
		
		return tasks;
	}
	/**
	 * Sets the list of quest tasks.
	 */
	public void setTasks(LinkedList<Task> tasks) {
		
		this.tasks = tasks;
	}
	/**
	 * Gets list of quest rewards.
	 */
	public LinkedList<Reward> getRewards() {

		if(rewards == null)
		{
			rewards = new LinkedList<Reward>();
		}
		
		return rewards;
	}
	/**
	 * Sets list of quest rewards.
	 */
	public void setRewards(LinkedList<Reward> rewards) {
	
		this.rewards = rewards;
	}
	
	/**
	 * Adds a task to the list.
	 */
	public void addTask(Task task)
	{
		
		getTasks().add(task);
	}
	/**
	 * Removes a task from the list.
	 */
	public void removeTask(Task task)
	{
	
		getTasks().remove(task);
	}
	/**
	 * Adds a reward to the list.
	 */
	public void addReward(Reward reward)
	{
	
		getRewards().add(reward);
	}
	/**
	 * Removes a reward from the list.
	 */
	public void removeReward(Reward reward)
	{
		
		getRewards().remove(reward);
	}
	

}
