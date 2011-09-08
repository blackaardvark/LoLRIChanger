package com.LoLRIChanger.io;

public class LoLItem {
	
	private String itemName;
	private String itemID;
	
	public LoLItem(String name,String id){
		itemName = name;
		itemID = id;
	}

	public String getItemName() {
		return itemName;
	}

	public String getItemID() {
		return itemID;
	}
	
	
}
