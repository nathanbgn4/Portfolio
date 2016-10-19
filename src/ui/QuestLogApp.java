package ui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import ui.QuestDetailsPanel;
import ui.QuestLogPanel;
import ui.TitlePanel;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import beans.Quest;
import beans.QuestLog;
import beans.QuestType;
import data.QuestLogIO;

import java.awt.event.KeyEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.awt.event.InputEvent;
import javax.swing.BoxLayout;
import javax.swing.JFileChooser;

public class QuestLogApp {
	public static String FILEPATH;
	private JFrame frmQuestLogger;
	private QuestLog mainquestlog;
	private QuestLogPanel questlogpanel;
	private QuestDetailsPanel questdetailspanel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuestLogApp window = new QuestLogApp();
					window.frmQuestLogger.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public QuestLogApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmQuestLogger = new JFrame();
		frmQuestLogger.setTitle("Quest Logger");
		frmQuestLogger.setBounds(100, 100, 801, 593);
		frmQuestLogger.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmQuestLogger.getContentPane().setLayout(new MigLayout("", "[grow][][][][][][][][][grow]", "[grow][grow][][][][grow]"));
		
		
		//add title panel
		TitlePanel titlepanel = new TitlePanel();
		questlogpanel = new QuestLogPanel();
	    questdetailspanel = new QuestDetailsPanel();
		
		JPanel questlogholder = new JPanel();
		questlogholder.setLayout(new BoxLayout(questlogholder, BoxLayout.X_AXIS));
		
		
		
		
		
		
		frmQuestLogger.setJMenuBar(buildMenuBar());
		
		
		
		
		
		
		frmQuestLogger.getContentPane().add(titlepanel, "cell 0 0 10 1,alignx center,aligny center");
		frmQuestLogger.getContentPane().add(questlogholder, "cell 0 1 10 5,grow");
		
		questlogholder.add(questlogpanel);
		questlogholder.add(questdetailspanel);
		
	}

	/**
	 * Builder for menu bar and menu items
	 */
	private JMenuBar buildMenuBar()
	{
		JMenuBar menuBar = new JMenuBar();
		JMenu file_menu = new JMenu("File");
		JMenu actions_menu = new JMenu("Actions");
		
		
		
		JMenuItem exitmenuitem = new JMenuItem("Exit");
		exitmenuitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		exitmenuitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		
		JMenuItem createmenuitem = new JMenuItem("Create");
		createmenuitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		createmenuitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JMenuItem deletemenuitem = new JMenuItem("Delete");
		deletemenuitem.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent arg0)
					{
						
					}
				});
		deletemenuitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));
		
		JMenuItem savemenuitem = new JMenuItem("Save");
		savemenuitem.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent arg0)
					{
						SaveQuest();
					}
				});
		savemenuitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		
		JMenuItem loadmenuitem = new JMenuItem("Load");
		loadmenuitem.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent arg0)
					{
						LoadQuest();
					}
				});
		
		
		/**
		 * Shortcut key for menu items
		 */
		loadmenuitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
		
		menuBar.add(file_menu);
		menuBar.add(actions_menu);
		
		actions_menu.add(createmenuitem);
		actions_menu.add(deletemenuitem);
		
		file_menu.add(loadmenuitem);
		file_menu.add(savemenuitem);
		file_menu.add(new JSeparator());
		file_menu.add(exitmenuitem);
		
		return menuBar;
	}
	
	
	//make two private methods for save and load, call them inside menu item action listener
	//save should save questlog to file
	//load should load the file into the questlog object

	/**
	 * Opens the file chooser for saving the quest xml
	 */
	private void SaveQuest()
	{
		JFileChooser filechooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("XML Files", "xml");
		File selectedfile = null;
		
		
		filechooser.setFileFilter(filter);
		filechooser.setCurrentDirectory(new java.io.File("C:/Users/Nathan/Desktop"));
		filechooser.setDialogTitle("Save quest where?");
		filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		if(filechooser.showSaveDialog(frmQuestLogger) == JFileChooser.APPROVE_OPTION)
		{
			
			LocalDateTime timestamp = LocalDateTime.now();
			
			selectedfile = filechooser.getSelectedFile();
			
			
			QuestLogIO.FILEPATH = selectedfile.getPath() + "\\Questlog_"+timestamp.getMonthValue()+timestamp.getDayOfMonth()+timestamp.getYear();
			QuestLogIO.FILEPATH += "_"+timestamp.getHour()+timestamp.getMinute()+timestamp.getSecond()+".xml";
			
			try
			{
				QuestLogIO.writeQuestLogToXML(mainquestlog);
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(frmQuestLogger, "Can not save an empty quest log", "Save Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	/**
	 * uses JFileChooser to load quest xml file
	 */
	public void LoadQuest()
	{
		JFileChooser filechooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("XML Files", "xml");
		File selectedfile = null;
		
		filechooser.setFileFilter(filter);
		filechooser.setCurrentDirectory(new java.io.File("C:/test/"));
		filechooser.setDialogTitle("Open which quest?");
		filechooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		if(filechooser.showOpenDialog(frmQuestLogger) == JFileChooser.APPROVE_OPTION)
		{
			selectedfile = filechooser.getSelectedFile();
			QuestLogIO.FILEPATH = selectedfile.getPath();
			
			try
			{
				mainquestlog = QuestLogIO.readQuestLogXML();
				loadQuestToTree();
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(frmQuestLogger, e.toString(), "Load Error", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
		
		
	}
	
	/**
	 * sends quest information to the quest log panel
	 */
	public void loadQuestToTree()
	{
		questlogpanel.loadQuestLog(mainquestlog, questdetailspanel);
	}
	
}
