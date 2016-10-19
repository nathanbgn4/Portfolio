package ui;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitlePanel extends JPanel {

	private static final long serialVersionUID = 687374560146464147L;

	/**
	 * 
	 */
	public TitlePanel() {
		JLabel lblQuestLogger = new JLabel("Quest Logger");
		JLabel lblADungeonMasters = new JLabel("A Dungeon Master's quest tracking utility");
		
		lblQuestLogger.setFont(new Font("Times New Romans", Font.BOLD, 34));
		lblADungeonMasters.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		add(lblQuestLogger);
		add(lblADungeonMasters);
		
		
		
	}

}
