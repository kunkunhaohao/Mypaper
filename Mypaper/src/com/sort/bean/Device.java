package com.sort.bean;

public class Device {
	//���豸��id
	private int id;
	//���豸��ж�ط����ķ��ã�Ҳ����ʱ��
	private float localcost;
	
	private String name;
	
	
	
	
	
	public Device(int id, float localcost ,String name) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.localcost = localcost;
		this.name = name;
	}



	public String getNameString() {
		return name;
	}



	public void setNameString(String nameString) {
		this.name = nameString;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public float getLocalcost() {
		return localcost;
	}



	public void setLocalcost(float localcost) {
		this.localcost = localcost;
	}
	
	
}
