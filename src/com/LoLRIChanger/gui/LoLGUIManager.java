package com.LoLRIChanger.gui;

import java.awt.Desktop.Action;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.LoLRIChanger.io.*;

public class LoLGUIManager {
	
	private LoLFileWriter fileWriter;
	private LoLFileReader fileReader;
	private LoLListHandler handler;
	private String path;
	public boolean pathValid = false;
	private int gameMode;
	
	public LoLGUIManager(){
		handler = new LoLListHandler();
	}
	
	public void setPath(String s){
		path = s;
	}
	
	public void setMode(int i){
		gameMode=i;
	}
	
	public String getItemId(String name){
		return handler.getItemID(name);
	}
	
	public String getChampId(String name){
		return handler.getChampID(name);
	}
	
	public Object[] getItemNames(){
		return handler.getINames();
	}
	
	public Object[] getChampNames(){
		return handler.getCNames();
	}
	
	public boolean pathLegit(){
		try{
			if(path.contains("\\RADS\\solutions\\")&&path.endsWith("\\deploy\\DATA")/*contains("\\deploy\\DATA")*/){
				fileReader = new LoLFileReader(path);
				pathValid=true;
				return true;
			}
			else{
				pathValid = false;
				return false;
			}
		}
		catch(Exception e){
			return false;
		}
	}
	
	public void writeItemsToFile(String cName,String[] i,int mode){
		if(i[1].equals(i[0])&&i[2].equals(i[1])&& i[3].equals(i[2])&&i[4].equals(i[3])&&i[5].equals(i[4])){
			if(JOptionPane.showConfirmDialog(null,"Are you sure you want to add these items?", "They're all the same!",JOptionPane.YES_NO_OPTION)==0)
			{
				java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
				if(desktop.isSupported(Action.BROWSE)){
					String trololo = "http://trololololololololololo.com/";
					try{
						java.net.URI uri = new java.net.URI(trololo);
						desktop.browse(uri);
					}
					catch(Exception e){
						JOptionPane.showMessageDialog(null, "You trolling?");
					}
					String[] items = new String[6];
					items[0] = "RecItem1="+i[0];
					items[1] = "RecItem2="+i[1];
					items[2] = "RecItem3="+i[2];
					items[3] = "RecItem4="+i[3];
					items[4] = "RecItem5="+i[4];
					items[5] = "RecItem6="+i[5];
					fileWriter = new LoLFileWriter(cName,path,mode);
					fileWriter.writeFile(items);
					JOptionPane.showMessageDialog(null, "Troll Item Set saved successfully!", "Great success!", JOptionPane.PLAIN_MESSAGE);
				}
				else{
					String[] items = new String[6];
					items[0] = "RecItem1="+i[0];
					items[1] = "RecItem2="+i[1];
					items[2] = "RecItem3="+i[2];
					items[3] = "RecItem4="+i[3];
					items[4] = "RecItem5="+i[4];
					items[5] = "RecItem6="+i[5];
					fileWriter = new LoLFileWriter(cName,path,mode);
					fileWriter.writeFile(items);
					JOptionPane.showMessageDialog(null, "Troll Item Set saved successfully!", "Great success!", JOptionPane.PLAIN_MESSAGE);
				}
			}
		}
		
		else{
				String[] items = new String[6];
				items[0] = "RecItem1="+i[0];
				items[1] = "RecItem2="+i[1];
				items[2] = "RecItem3="+i[2];
				items[3] = "RecItem4="+i[3];
				items[4] = "RecItem5="+i[4];
				items[5] = "RecItem6="+i[5];
				fileWriter = new LoLFileWriter(cName,path,mode);
				fileWriter.writeFile(items);
				JOptionPane.showMessageDialog(null, "Item Set saved successfully!", "Great success!", JOptionPane.PLAIN_MESSAGE);
		}
	
		
	}
	public boolean usedPreviously(String name,int gameMode){
		return fileReader.fileExists(name, gameMode);
	}
	public int[] itemIndexes(String name){
		int[] indexes = new int[6];
		ArrayList<String> names = getPrevItems(name,gameMode);
		for(int i=0;i<names.size();i++){
			if(names.get(i)!=""){
				indexes[i]=handler.getItemIndex(names.get(i));
			}
			else{
				indexes[i]=-1;
			}
		}
		return indexes;
	}
	private ArrayList<String> getPrevItems(String name,int mode){
		return fileReader.getItemsOnFile(name, mode);
	}
	
	public boolean deleteChampFiles(String name,int mode){
		fileWriter=new LoLFileWriter(name,path,mode);
		return fileWriter.deleteFile(name, mode);
	}
}
