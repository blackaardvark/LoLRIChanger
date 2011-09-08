package com.LoLRIChanger.io;

import java.io.InputStream;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class LoLListHandler {
	
	private LinkedHashMap<String,String> itemMap;
	private LinkedHashMap<String,String> champMap;
	//private File items;
	//private File champs;
	public Logger log;
	
	public LoLListHandler(){
		
		try {
			/*URL itemsURL=ClassLoader.getSystemResource("resources/Items");
			URL champsURL=ClassLoader.getSystemResource("resources/Champs");
			items = new File(itemsURL.getPath());
			champs = new File(champsURL.getPath());*/
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		itemMap = new LinkedHashMap<String,String>();
		champMap = new LinkedHashMap<String,String>();
		log = Logger.getLogger("global");
		readFiles();
	}
	
	private void readFiles(){
		
		InputStream itemsIn = ClassLoader.getSystemResourceAsStream("resources/Items");
		InputStream champsIn = ClassLoader.getSystemResourceAsStream("resources/Champs");
		try {
			String fileString = new Scanner(itemsIn).useDelimiter("\\A").next();
			String text = fileString.replaceAll("\\r\\n|\\r|\\n", "_");
			List<String> itemsList = Arrays.asList(text.split("_"));
			for(int i=0;i<itemsList.size();i++){
				parseItemString(itemsList.get(i));
			}
			String fileString1 = new Scanner(champsIn).useDelimiter("\\A").next();
			String text1 = fileString1.replaceAll("\\r\\n|\\r|\\n", "_");
			List<String> champList = Arrays.asList(text1.split("_"));
			for(int i=0;i<champList.size();i++){
				parseChampString(champList.get(i));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*try {
			BufferedReader itemReader = new BufferedReader(new FileReader(items));
			while (itemReader.ready()){
				parseItemString(itemReader.readLine());
			}
			itemReader.close();
			BufferedReader champReader = new BufferedReader(new FileReader(champs));
			while (champReader.ready()){
				parseChampString(champReader.readLine());
			}
			champReader.close();
		} 
		catch (FileNotFoundException e) {
			log.log(Level.CONFIG, "Cannot read the item list file", items);
			e.printStackTrace();
		} 
		catch (IOException e) {
			log.log(Level.FINE, "Reached end of item list file", items);
			e.printStackTrace();
		}*/
	}
	
	private void parseChampString(String s) {
		if(s!=null && s!=""){
			int i = s.indexOf("-");
			String name = s.substring(0,i); 
			String id = s.substring(i+1);
			champMap.put(name,id);
		}
	}

	private void parseItemString(String s){
		if(s!=null && s!=""){
			int i = s.indexOf("-", 4);
			String name = s.substring(i+1); 
			String id = s.substring(0,i);
			itemMap.put(name,id);
		}
	}
	
	public LinkedHashMap<String,String> getItemMap(){
		return itemMap;
	}
	
	public Object[] getINames(){
		return (Object[])itemMap.keySet().toArray();
	}
	public int getItemIndex(String s){
		Object[] ids = itemMap.values().toArray();
		for(int i=0;i<ids.length;i++){
			String t = (String)ids[i];
			if(t.compareTo(s)==0)
				return i;
		}
		return -1;
	}
	public Object[] getCNames(){
		return (Object[])champMap.keySet().toArray();
	}
	public String getItemID(String i){
		if(i!=""&&i!=null){
			return itemMap.get(i);
		}
		else
			return "";
	}
	public String getChampID(String i){
		return champMap.get(i);
	}
}
