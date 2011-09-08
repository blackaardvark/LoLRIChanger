package com.LoLRIChanger.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URL;
import java.util.prefs.Preferences;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.Font;

public class LRIChangerGUI {

	private JFrame frmLolItemChanger;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private LoLGUIManager manager;
	private Preferences prefs;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					LRIChangerGUI window = new LRIChangerGUI();
					window.frmLolItemChanger.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LRIChangerGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		prefs = Preferences.userRoot();
		manager = new LoLGUIManager();
		if(prefs.get("path", "")!=""){
			manager.setPath(prefs.get("path",""));
		}
		Object[] cNames = manager.getChampNames();
		Object[] iNames = manager.getItemNames();
		frmLolItemChanger = new JFrame();
		frmLolItemChanger.setTitle("LoL Item Changer");
		frmLolItemChanger.setBounds(100, 100, 687, 366);
		frmLolItemChanger.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{607, 0};
		gridBagLayout.rowHeights = new int[]{598, -129, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		frmLolItemChanger.getContentPane().setLayout(gridBagLayout);
		
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setLayout(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		frmLolItemChanger.getContentPane().add(panel, gbc_panel);
		
		panel_1 = new JPanel();
		panel_1.setForeground(Color.YELLOW);
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 0, 692, 235);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		final JLabel lblUnchecked = new JLabel("UNCHECKED");
		lblUnchecked.setBounds(77, 62, 127, 14);
		panel_1.add(lblUnchecked);
		if(manager.pathLegit()){
			lblUnchecked.setText("VALID PATH");
			lblUnchecked.setForeground(Color.GREEN);
		}
		
		final JButton btnBrowse = new JButton("Set Path");
		btnBrowse.setBounds(311, 7, 118, 23);
		panel_1.add(btnBrowse);
		
		JLabel lblSetThePath = new JLabel("Set the path to LoL files (ends with \"\\deploy\\DATA\\\") :");
		lblSetThePath.setForeground(Color.WHITE);
		lblSetThePath.setBounds(20, 11, 286, 14);
		panel_1.add(lblSetThePath);
		
		final JLabel item1 = new JLabel("Item 1");
		item1.setBounds(30, 171, 64, 54);
		panel_1.add(item1);
		
		final JLabel item2 = new JLabel("Item 2");
		item2.setBounds(140, 171, 64, 54);
		panel_1.add(item2);
		
		final JLabel item3 = new JLabel("Item 3");
		item3.setBounds(255, 171, 64, 54);
		panel_1.add(item3);
		
		final JLabel item4 = new JLabel("Item 4");
		item4.setBounds(364, 171, 64, 54);
		panel_1.add(item4);
		
		final JLabel item5 = new JLabel("Item 5");
		item5.setBounds(475, 171, 64, 54);
		panel_1.add(item5);
		
		final JLabel item6 = new JLabel("Item 6");
		item6.setBounds(589, 171, 64, 54);
		panel_1.add(item6);
		
		final JComboBox comboBox = new JComboBox(cNames);
		comboBox.setBounds(20, 118, 162, 22);
		comboBox.setSelectedIndex(-1);
		panel_1.add(comboBox);
		
		JLabel lblChampSelect = new JLabel("Champ Select:");
		lblChampSelect.setForeground(Color.WHITE);
		lblChampSelect.setBounds(25, 102, 157, 14);
		panel_1.add(lblChampSelect);
		
		final JLabel champLabel = new JLabel("");
		champLabel.setBounds(192, 62, 100, 98);
		panel_1.add(champLabel);
		
		JLabel lblCurrentPath = new JLabel("Current Path:");
		lblCurrentPath.setForeground(Color.WHITE);
		lblCurrentPath.setBounds(30, 33, 87, 14);
		panel_1.add(lblCurrentPath);
		
		final JLabel pathDisplay = new JLabel("---NO PATH SET!!---");
		pathDisplay.setFont(new Font("Tahoma", Font.BOLD, 12));
		pathDisplay.setForeground(Color.YELLOW);
		pathDisplay.setBounds(116, 33, 235, 14);
		if(prefs.get("path", "")!=""){
			pathDisplay.setText(prefs.get("path",""));
		}
		panel_1.add(pathDisplay);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(0, 240, 692, 100);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		final JComboBox comboBox_1 = new JComboBox(iNames);
		comboBox_1.setBounds(10, 0, 102, 22);
		comboBox_1.setSelectedIndex(-1);
		panel_2.add(comboBox_1);
		
		final JComboBox comboBox_2 = new JComboBox(iNames);
		comboBox_2.setBounds(122, 0, 102, 22);
		comboBox_2.setSelectedIndex(-1);
		panel_2.add(comboBox_2);
		
		final JComboBox comboBox_3 = new JComboBox(iNames);
		comboBox_3.setBounds(234, 0, 102, 22);
		comboBox_3.setSelectedIndex(-1);
		panel_2.add(comboBox_3);
		
		final JComboBox comboBox_4 = new JComboBox(iNames);
		comboBox_4.setBounds(346, 0, 102, 22);
		comboBox_4.setSelectedIndex(-1);
		panel_2.add(comboBox_4);
		
		final JComboBox comboBox_5 = new JComboBox(iNames);
		comboBox_5.setBounds(458, 0, 102, 22);
		comboBox_5.setSelectedIndex(-1);
		panel_2.add(comboBox_5);
		
		final JComboBox comboBox_6 = new JComboBox(iNames);
		comboBox_6.setBounds(570, 0, 102, 22);
		comboBox_6.setSelectedIndex(-1);
		panel_2.add(comboBox_6);
		
		final JButton btnClear = new JButton("Clear");
		btnClear.setBounds(469, 66, 91, 23);
		panel_2.add(btnClear);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(570, 66, 91, 23);
		panel_2.add(btnSave);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(363, 66, 91, 23);
		panel_2.add(btnDelete);
		
		//SETTING ACTIONLISTENERS
		
		//Save button
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					if(manager.pathLegit() && comboBox.getSelectedIndex()!=-1){
						String[] items = new String[6];
						items[0] = manager.getItemId((String)comboBox_1.getSelectedItem());
						items[1] = manager.getItemId((String)comboBox_2.getSelectedItem());
						items[2] = manager.getItemId((String)comboBox_3.getSelectedItem());
						items[3] = manager.getItemId((String)comboBox_4.getSelectedItem());
						items[4] = manager.getItemId((String)comboBox_5.getSelectedItem());
						items[5] = manager.getItemId((String)comboBox_6.getSelectedItem());
						manager.writeItemsToFile((String)comboBox.getSelectedItem(),items, 0);
					}
				}
				catch(NullPointerException ex){
					//Display a dialog box with path error info.
					JOptionPane.showMessageDialog(panel, "Your path appears to be incorrect. \n","Path Error",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		//Clear Button
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_1.setSelectedIndex(-1);
				comboBox_2.setSelectedIndex(-1);
				comboBox_3.setSelectedIndex(-1);
				comboBox_4.setSelectedIndex(-1);
				comboBox_5.setSelectedIndex(-1);
				comboBox_6.setSelectedIndex(-1);
			}
		});
		//Browse for path button.
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(prefs.get("path", "0")!="0"){
					
					JFileChooser chooser = new JFileChooser(prefs.get("path", "C:\\"));
					chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					int returnVal = chooser.showOpenDialog(btnBrowse);
					if(returnVal==JFileChooser.APPROVE_OPTION){
						File f =  chooser.getSelectedFile();
						manager.setPath(f.getAbsolutePath());
						if(manager.pathLegit()){
							Preferences prefs = Preferences.userRoot();
							prefs.put("path", f.getAbsolutePath());
							pathDisplay.setText(f.getAbsolutePath());
							lblUnchecked.setText("VALID PATH");
							lblUnchecked.setForeground(Color.green);
						}
						else{
							lblUnchecked.setText("PATH ERROR");
							lblUnchecked.setForeground(Color.red);
						}
					}
				}
				else
				{
					JFileChooser chooser = new JFileChooser("C:\\");
					chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					int returnVal = chooser.showOpenDialog(btnBrowse);
					if(returnVal==JFileChooser.APPROVE_OPTION){
						File f =  chooser.getSelectedFile();
						manager.setPath(f.getAbsolutePath());
						if(manager.pathLegit()){
							Preferences prefs = Preferences.userRoot();
							prefs.put("path", f.getAbsolutePath());
							pathDisplay.setText(f.getAbsolutePath());
							lblUnchecked.setText("VALID PATH");
							lblUnchecked.setForeground(Color.green);
						}
						else{
							lblUnchecked.setText("PATH ERROR");
							lblUnchecked.setForeground(Color.red);
						}
					}
					
				}
			}
		});
		//Delete button
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex()!=-1){
					if(manager.deleteChampFiles((String)comboBox.getSelectedItem(), 0)){
						JOptionPane.showMessageDialog(null, "File deleted");
						btnClear.doClick();
					}
					else{
						JOptionPane.showMessageDialog(null, "Failed to delete file");
					}
				}
			}
		});
		//Champ Select ComboBox
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String champSelected = (String)comboBox.getSelectedItem();
				URL imgURL = ClassLoader.getSystemResource("resources/images/champImages/"+manager.getChampId(champSelected)+".jpg");
				ImageIcon champImage = new ImageIcon(imgURL);
				champLabel.setIcon(champImage);
				if(manager.pathValid){
					if(manager.usedPreviously(champSelected, 0)){
						int[] indexes = manager.itemIndexes(champSelected);
						comboBox_1.setSelectedIndex(indexes[0]);
						comboBox_2.setSelectedIndex(indexes[1]);
						comboBox_3.setSelectedIndex(indexes[2]);
						comboBox_4.setSelectedIndex(indexes[3]);
						comboBox_5.setSelectedIndex(indexes[4]);
						comboBox_6.setSelectedIndex(indexes[5]);
					}
					else{
						comboBox_1.setSelectedIndex(-1);
						comboBox_2.setSelectedIndex(-1);
						comboBox_3.setSelectedIndex(-1);
						comboBox_4.setSelectedIndex(-1);
						comboBox_5.setSelectedIndex(-1);
						comboBox_6.setSelectedIndex(-1);
					}
				}
			}
		});
		//Item1 ComboBox
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_1.getSelectedIndex()==-1){
					item1.setIcon(null);
				}
				else{
					String itemName = (String)comboBox_1.getSelectedItem();
					URL imgURL = ClassLoader.getSystemResource("resources/images/"+manager.getItemId(itemName)+".gif");
					ImageIcon itemImage = new ImageIcon(imgURL);
					item1.setIcon(itemImage);
				}
			}
		});
		comboBox_1.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if(evt.getSource()==btnClear){
					item1.setIcon(null);
				}
			}
		});
		//Item2 ComboBox
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_2.getSelectedIndex()==-1){
					item2.setIcon(null);
				}
				else{
					String itemName = (String)comboBox_2.getSelectedItem();
					URL imgURL = ClassLoader.getSystemResource("resources/images/"+manager.getItemId(itemName)+".gif");
					ImageIcon itemImage = new ImageIcon(imgURL);
					item2.setIcon(itemImage);
				}
			}
		});
		comboBox_2.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if(evt.getSource()==btnClear){
					item2.setIcon(null);
				}
			}
		});
		//Item3 ComboBox
		comboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_3.getSelectedIndex()==-1){
					item3.setIcon(null);
				}
				else{
					String itemName = (String)comboBox_3.getSelectedItem();
					URL imgURL = ClassLoader.getSystemResource("resources/images/"+manager.getItemId(itemName)+".gif");
					ImageIcon itemImage = new ImageIcon(imgURL);
					item3.setIcon(itemImage);
				}
			}
		});
		comboBox_3.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if(evt.getSource()==btnClear){
					item3.setIcon(null);
				}
			}
		});
		//Item4 ComboBox
		comboBox_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_4.getSelectedIndex()==-1){
					item4.setIcon(null);
				}
				else{
					String itemName = (String)comboBox_4.getSelectedItem();
					URL imgURL = ClassLoader.getSystemResource("resources/images/"+manager.getItemId(itemName)+".gif");
					ImageIcon itemImage = new ImageIcon(imgURL);
					item4.setIcon(itemImage);
				}
			}
		});
		comboBox_4.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if(evt.getSource()==btnClear){
					item4.setIcon(null);
				}
			}
		});
		//Item5 ComboBox
		comboBox_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_5.getSelectedIndex()==-1){
					item5.setIcon(null);
				}
				else{
					String itemName = (String)comboBox_5.getSelectedItem();
					URL imgURL = ClassLoader.getSystemResource("resources/images/"+manager.getItemId(itemName)+".gif");
					ImageIcon itemImage = new ImageIcon(imgURL);
					item5.setIcon(itemImage);
				}
			}
		});
		comboBox_5.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if(evt.getSource()==btnClear){
					item5.setIcon(null);
				}
			}
		});
		//Item6 ComboBox
		comboBox_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_6.getSelectedIndex()==-1){
					item6.setIcon(null);
				}
				else{
					String itemName = (String)comboBox_6.getSelectedItem();
					URL imgURL = ClassLoader.getSystemResource("resources/images/"+manager.getItemId(itemName)+".gif");
					ImageIcon itemImage = new ImageIcon(imgURL);
					item6.setIcon(itemImage);
				}
			}
		});
		comboBox_6.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if(evt.getSource()==btnClear){
					item6.setIcon(null);
				}
			}
		});
	}
}
