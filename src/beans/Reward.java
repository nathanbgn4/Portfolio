package beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * This is the object for quest rewards.
 * @author Nathan
 */
@XmlRootElement(name = "Reward")
public class Reward {
	
	private String rewardDescription;
	
	/**
	 * Gets the reward for quests.
	 */
	@XmlElement(name = "rewardDescription")
	public String getRewardDescription() {
		return rewardDescription;
	}
	/**
	 * Sets the reward description for quests.
	 */
	
	public void setRewardDescription(String rewardDescription) {
		
		this.rewardDescription = rewardDescription;
	}
	
}
