package beans;

import java.util.LinkedList;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * This is a container for quests.
 * @author Nathan
 */
@XmlRootElement(name = "QuestLog")
public class QuestLog {
	
	
	private LinkedList<Quest> quests;
	
	/**
	 * Gets the list of quests, and verifies the list's existence.
	 */
	public LinkedList<Quest> getQuests() {
		
		if(quests == null)
		{
			quests = new LinkedList<Quest>();
		}
		
		return quests;
	}
	
	/**
	 * Sets the list of quests.
	 */
	public void setQuests(LinkedList<Quest> quests) {
	
		this.quests = quests;
	}
}
