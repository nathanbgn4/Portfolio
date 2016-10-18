package ui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import beans.Quest;
import beans.QuestLog;
import data.QuestLogIO;
import java.awt.Font;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.awt.GridBagConstraints;

public class QuestLogPanel extends JPanel {
	QuestLogApp logapp;
	
	
	private static final long serialVersionUID = 2627844123933090046L;
	
	private Hashtable<String, Quest> questmapping = new Hashtable<String, Quest>();
	private JTree tree;	
	
	/**
	 * Creates a panel to hold quest information.
	 */
	public QuestLogPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{1.0};
		gridBagLayout.rowWeights = new double[]{1.0};
		setLayout(gridBagLayout);
		
		tree = new JTree();			
		tree.removeAll();
		
		
		
		
		GridBagConstraints gbc_tree = new GridBagConstraints();
		gbc_tree.fill = GridBagConstraints.BOTH;
		gbc_tree.gridx = 0;
		gbc_tree.gridy = 0;
		add(tree, gbc_tree);

	}
	/**
	 * Loads the information from Questlog.xml into the JTree
	 * 
	 */
	public void loadQuestLog(QuestLog questlog, QuestDetailsPanel detailspanel)
	{
		
		MutableTreeNode rootnode = new DefaultMutableTreeNode("Quest Log");		
		DefaultTreeModel treemodel = new DefaultTreeModel(rootnode);
		
		tree.setModel(treemodel);
		
		
		for(Quest quest : questlog.getQuests())
		{
			DefaultMutableTreeNode treenode = new DefaultMutableTreeNode(quest.getQuestName());
			treemodel.insertNodeInto(treenode, rootnode, 0);
			questmapping.put(quest.getQuestName(), quest);
		}
		
		tree.addTreeSelectionListener(new TreeSelectionListener() {
		    public void valueChanged(TreeSelectionEvent e) {
		        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
		        	
		        if (node == null) {return;}

		        Quest selected_quest = questmapping.get((String) node.getUserObject());

		        if(selected_quest != null)
		        {
			        detailspanel.displayQuestInfo(selected_quest);
		        }
		    }
		});
		
	}
	
	
}
