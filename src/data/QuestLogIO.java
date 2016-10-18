package data;

import beans.Quest;
import beans.QuestLog;
import beans.Requirement;
import beans.Reward;
import beans.Task;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * this is the utility for JAXB
 * @author Nathan
 */
public class QuestLogIO {
	
	/**
	 * This is the FILEPATH variable used to read and write the given objects.
	 */
	public static String FILEPATH;
	
	/**
	 * This writes the QuestLog to an XML.
	 * @throws IOException 
	 */
	public static void writeQuestLogToXML(QuestLog questLog) throws Exception
	{
			File file = new File(FILEPATH);
			file.createNewFile();
			
			JAXBContext jaxbContext = JAXBContext.newInstance(QuestLog.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			
			jaxbMarshaller.marshal(questLog, file);
	
	}
	
	/**
	 * This reads the QuestLog XML into a QuestLog object.
	 */
	public static QuestLog readQuestLogXML() throws Exception
	{
			File file = new File(FILEPATH);
			JAXBContext jaxbContext = JAXBContext.newInstance(QuestLog.class);
			
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			QuestLog questlog = (QuestLog) jaxbUnmarshaller.unmarshal(file);
			
			return questlog;
			
	}

	/**
	 * This writes the Quest XML.
	 */
	public static void writeQuestToXML(Quest quest)
	{
		try
		{
			File file = new File(FILEPATH);
			file.createNewFile();
			
			JAXBContext jaxbContext = JAXBContext.newInstance(Quest.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			
			jaxbMarshaller.marshal(quest, file);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	/**
	 * This reads the Quest XML into a Quest Object.
	 */
	public static Quest readQuestXMl(Quest quest)
	{
		try
		{
			File file = new File(FILEPATH);
			JAXBContext jaxbContext = JAXBContext.newInstance(Quest.class);
			
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Quest return_quest = (Quest) jaxbUnmarshaller.unmarshal(file);
			
			return return_quest;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	/**
	 * This writes the Task XML.
	 */
	public static void writeTaskToXML(Task task)
	{
		try
		{
			File file = new File(FILEPATH);
			file.createNewFile();
			
			JAXBContext jaxbContext = JAXBContext.newInstance(Task.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			
			jaxbMarshaller.marshal(task, file);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * This reads the Task XML into a Task Object.
	 */
	public static Task readTaskXML(Task task)
	{
		try
		{
			File file = new File(FILEPATH);
			JAXBContext jaxbContext = JAXBContext.newInstance(Task.class);
			
			Unmarshaller JaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Task return_task = (Task) JaxbUnmarshaller.unmarshal(file);
			
			return return_task;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * This writes the Reward XML.
	 */
	public static void writeRewardToXML(Reward reward)
	{
		try
		{
		File file = new File(FILEPATH);
		file.createNewFile();
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Reward.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		
		jaxbMarshaller.marshal(reward, file);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

	/**
	 * This reads the Reward XML into a Reward Object.
	 */
	public static Reward readRewardXML(Reward reward)
	{
		try
		{
			File file = new File(FILEPATH);
			JAXBContext jaxbContext = JAXBContext.newInstance(Reward.class);
			
			Unmarshaller jaxbUnmarshal = jaxbContext.createUnmarshaller();
			Reward return_reward = (Reward) jaxbUnmarshal.unmarshal(file);
			
			return return_reward;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * This writes the Requirement XML.
	 */
	public static void writeRequirementToXML(Requirement requirement)
	{
		try
		{
			File file = new File(FILEPATH);
			file.createNewFile();
			
			JAXBContext jaxbContext = JAXBContext.newInstance(Requirement.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			
			jaxbMarshaller.marshal(requirement, file);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * This reads the Requirement XML into a Requirement Object.
	 */
	public static Requirement readRequirementXML(Requirement requirement)
	{
		try
		{
			File file = new File(FILEPATH);
			JAXBContext jaxbContext = JAXBContext.newInstance(Requirement.class);
			
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Requirement return_requirement = (Requirement) jaxbUnmarshaller.unmarshal(file);
			
			return return_requirement;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}


}

	