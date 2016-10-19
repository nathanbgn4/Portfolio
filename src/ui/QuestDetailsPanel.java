package ui;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import beans.Quest;
import beans.QuestLog;
import beans.Requirement;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.BufferedReader;
import java.util.LinkedList;

public class QuestDetailsPanel extends JPanel {
	private JTextArea infoarea;
	
	private static final long serialVersionUID = 3477428804427487322L;

	/**
	 * Create the panel.
	 */
	public QuestDetailsPanel() {
		

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{1.0};
		gridBagLayout.rowWeights = new double[]{1.0};
		setLayout(gridBagLayout);
		
		infoarea = new JTextArea();
		infoarea.setBackground(new Color(154, 205, 50));
		
		GridBagConstraints gbc_infoarea = new GridBagConstraints();
		gbc_infoarea.fill = GridBagConstraints.BOTH;
		gbc_infoarea.gridx = 0;
		gbc_infoarea.gridy = 0;
		add(infoarea, gbc_infoarea);
		
		
		
	}

	
	public void displayQuestInfo(Quest quest)
	{
		infoarea.setText("");
		
		infoarea.append(quest.getQuestName());
		infoarea.append("\n");
		infoarea.append("Received From: "+quest.getQuestOrigin());
		infoarea.append("\n\nDetails:\n");
		infoarea.append(quest.getQuestDescription());
		infoarea.append("\n\nTasks:\n");
		for(int i=0;i<quest.getTasks().size();i++)
		{
			infoarea.append((i+1)+". "+quest.getTasks().get(i).getTaskDescription());
			infoarea.append("\n");
			
			LinkedList<Requirement> task_reqs = quest.getTasks().get(i).getRequirements();
			for(int j=0; j< task_reqs.size();j++)
			{
				infoarea.append("\t"+(j+1)+". "+task_reqs.get(j).getRequirementDescription());
				infoarea.append("\n");
			}
				
				
		}
		
		
		
		//TODO
		//display all quest information
		//need to append text, settext will overwrite current text.
		//need to lookup escape characters for tabs and etc.
	}
	
	
	
	
	
	
	
	
	
	
	
}
