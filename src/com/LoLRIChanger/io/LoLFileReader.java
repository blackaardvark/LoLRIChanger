package com.LoLRIChanger.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;



public class LoLFileReader {
	
	private String path;
	private File classicFile;
	private File domFile;
	private Logger log;
	
	public LoLFileReader(String p){
		path = p;
		log = Logger.getLogger("global");
	}
	
	public boolean fileExists(String cName,int mode){
		File cFile = new File(path+"\\Characters\\"+cName+"\\RecItemsCLASSIC.ini");
		File dFile = new File(path+"\\Characters\\"+cName+"\\RecItemsODIN.ini");
		if(mode == 0 && cFile.exists()){
			classicFile = cFile;
			return true;
		}
		else if(mode==1 && dFile.exists()){
			domFile = dFile;
			return true;
		}
		else
			return false;
	}
	
	public ArrayList<String> getItemsOnFile(String name, int mode){
		if(fileExists(name,mode) && mode == 0){
			try {
				ArrayList<String> existingItems = new ArrayList<String>();
				BufferedReader read = new BufferedReader(new FileReader(classicFile));
				while(read.ready()){
					String s = read.readLine();
					if(!s.contains("[ItemSet1]") && !s.contains("SetName=Set1") && !s.isEmpty()){
						existingItems.add(s.substring(s.indexOf("=")+1));
					}
				}
				read.close();
				return existingItems;
			} 
			catch (FileNotFoundException e) {
				log.fine("Somehow the file to read does not exist");
				e.printStackTrace();
			} 
			catch (IOException e) {
				log.fine("Reader reached end of file");
				e.printStackTrace();
			}
		}
		else if(fileExists(name,mode) && mode == 1){
			try {
				ArrayList<String> existingItems = new ArrayList<String>();
				BufferedReader read = new BufferedReader(new FileReader(domFile));
				while(read.ready()){
					String s = read.readLine();
					if(!s.contains("[ItemSet]") && !s.contains("SetName")){
						existingItems.add(s.substring(s.indexOf("=")+1));
					}
				}
				read.close();
				return existingItems;
			} 
			catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}
