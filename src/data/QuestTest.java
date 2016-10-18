package data;

import java.io.File;

import beans.QuestLog;
import beans.Requirement;
import beans.Reward;
import beans.Quest;
import beans.Task;
public class QuestTest {
	
	
	public static void main(String[] args)
	{
		//make the quest log
		//make the quests
		//make the tasks for the quests
		//make the requirements for the tasks
		//make the rewards for the quest
		
		QuestLog questlog = new QuestLog();
		Quest quest1 = new Quest();	
		
		
			Task task1 = new Task();
			Task task2 = new Task();
			Task task3 = new Task();		
			
			Requirement requirement1 = new Requirement();
			Requirement requirement2 = new Requirement();
			Requirement requirement3 = new Requirement();
			
			Reward reward1 = new Reward();
		
			quest1.setQuestName("Save the princess");
			quest1.setQuestOrigin("The King");
			quest1.setQuestDescription("The princess has been kidnapped by a tribe of bandits.  You must find and rescue her");
			
			task1.setTaskDescription("Find out which bandit tribe took her");
			task2.setTaskDescription("Find the bandit camp");
			task3.setTaskDescription("Kill all bandits and rescue the princess");
		
			requirement1.setRequirementDescription("Don't be Detected by the bandits");
			requirement2.setRequirementDescription("Don't get lost in the forest");
			requirement3.setRequirementDescription("Don't accidentally kill the wrong tribe");
			
			reward1.setRewardDescription("Gae-Bolg");
			
			quest1.addTask(task1);
			quest1.addTask(task2);
			quest1.addTask(task3);
			quest1.addReward(reward1);
			task3.addRequirement(requirement1);
			task1.addRequirement(requirement3);
			task2.addRequirement(requirement2);
			
			
		Quest quest2 = new Quest();
			
			Task task4 = new Task();
			Task task5 = new Task();
			Task task6 = new Task();
		
			Requirement requirement4 = new Requirement();
			Requirement requirement5 = new Requirement();
			Requirement requirement6 = new Requirement();
		
			Reward reward2 = new Reward();
		
			quest2.setQuestName("Slay the heretics");
			quest2.setQuestOrigin("The Emperor God of Mankind");
			quest2.setQuestDescription("The Emperor demands the heretics pay for their blasphemy in blood. Glass the planet");
		
			task4.setTaskDescription("Find the glass cannon controls");
			task5.setTaskDescription("Fire the glass cannon onto the planet");
			task6.setTaskDescription("Relish in the screams of the heretics");
		
			requirement4.setRequirementDescription("Don't get lost on the ship.");
			requirement5.setRequirementDescription("Don't miss the planet.");
			requirement6.setRequirementDescription("Also shout for the emperor.");
			
			reward2.setRewardDescription("+5.2 million heretics added to kill count. The Emperor is proud!");
			
			quest2.addTask(task4);
			quest2.addTask(task5);
			quest2.addTask(task6);
			quest2.addReward(reward2);
			
			task4.addRequirement(requirement4);
			task5.addRequirement(requirement5);
			task6.addRequirement(requirement6);
		
			questlog.getQuests().add(quest1);
			questlog.getQuests().add(quest2);
			
			try
			{
				QuestLogIO.FILEPATH = "C:\\test\\questtest.xml";
				QuestLogIO.writeQuestLogToXML(questlog);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		
	}
	
}
