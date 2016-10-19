package beans;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *This is the object for quest requirements
 * @author Nathan
 */
@XmlRootElement(name = "Requirement")
public class Requirement {
	
	
	private String requirementDescription;
	
	/**
	 * Gets the requirements for the quest.
	 */
	@XmlElement(name = "requirementDescription")
	public String getRequirementDescription() {
		return requirementDescription;
	}
	/**
	 * Sets the requirements for the quest.
	 */
	
	public void setRequirementDescription(String requirementDescription) {
		
		this.requirementDescription = requirementDescription;
	}
}
