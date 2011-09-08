package com.LoLRIChanger.io;
/**
 * 
 */
import java.io.*;
/**
 * @author Sam
 *
 */
public class LoLFileWriter {

	private String path;
	private String classic = "RecItemsCLASSIC.ini";
	private String dominion = "RecItemsODIN.ini";
	private File workingFile;
	private File champFolder;
	private static String[] itemList;
	
	public LoLFileWriter(String champName,String p,int gameMode){
		setPath(p);
		champFolder = new File(path+"\\Characters\\"+champName+"\\");
		File classicFile = new File(path+"\\Characters\\"+champName+"\\"+classic);
		File dominionFile = new File(path+"\\Characters\\"+champName+"\\"+dominion);
		
		if(gameMode==0 && classicFile.exists()){
			workingFile = classicFile;
		}
		else if(gameMode==0 && !classicFile.exists()){
			if(!champFolder.exists()){
				try {
					champFolder.mkdirs();
					classicFile.createNewFile();
					workingFile = classicFile;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				try {
					classicFile.createNewFile();
					workingFile = classicFile;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		else if(gameMode==1 && dominionFile.exists()){
			workingFile = dominionFile;
		}
		else if(gameMode==1 && !dominionFile.exists()){
			if(!champFolder.exists()){
				try {
					champFolder.mkdirs();
					dominionFile.createNewFile();
					workingFile = dominionFile;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				try{
					dominionFile.createNewFile();
					workingFile = dominionFile;
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			
		}
		else{
			System.out.printf("Something wrong with the file checking");
		}
	}
	public void setList(String[] s){
		itemList = s;
	}
	private void setPath(String p){
		path = p;
	}
	public void writeFile(String[] s){
		itemList = s;
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(workingFile));
			if(workingFile.canWrite()){
				writer.write("[ItemSet1]");
				writer.newLine();
				writer.write("SetName=Set1");
				writer.newLine();
				for(int i=0;i<itemList.length;i++){
					writer.write(itemList[i]);
					writer.newLine();
				}
				writer.flush();
				writer.close();
			}
			else{
				System.out.printf("ERROR IN WRITING ITEM SETS");
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
	}
	public boolean deleteFile(String name, int mode){
		if(mode==0){
			if(workingFile.exists()){
				try{
					workingFile.delete();
					champFolder.delete();
					return true;
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			return false;
		}
		return false;
	}
	
	
}
