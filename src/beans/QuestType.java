package beans;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * Enum that Determines what type quests must be
 */
@XmlEnum(String.class)
public enum QuestType {

	 MAIN,
	 SIDE,
	 SUB;
	
}
