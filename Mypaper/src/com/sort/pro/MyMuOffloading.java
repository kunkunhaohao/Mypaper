package com.sort.pro;

import java.util.ArrayList;
import java.util.List;

import com.sort.bean.Device;

public class MyMuOffloading {
	private List<List<Integer>> list;
	private Device[] device;
	private float[][] comp;
	private float[] comm;
	
	public MyMuOffloading(List<List<Integer>> list,Device[] device,float[][] comp, float[] comm) {
		// TODO Auto-generated constructor stub
		this.list = list;
		this.device = device;
		this.comp = comp;
		this.comm = comm;
	}
	
	//将通信数组每项加到计算矩阵中
	public float[][] compuncomm() {
		// TODO Auto-generated method stub
		for (int i = 0; i < comp.length; i++) {
			for (int j = 0; j < comp[0].length; j++) {
				comp[i][j] = comp[i][j] + comm[j];
			}
		}
		return comp;
	}
	
	//将拓扑排序好的列表分配给不同的设备 outmax为方法设备调用矩阵
	public int[][]  distri(){
		//输出的方法调用矩阵
		int[][] outmx = new int[comp.length][device.length];
		//总的消耗的时间
		float costall = 0;
		
		for (int i = 0; i < list.size(); i++) {
			//将已经有方法在该设备上卸载的设备放在该数组中
			ArrayList<Integer> a=new ArrayList<Integer>();
			//代表已有方法的设备上卸载的该方法的设备id
			int z = 0;
			//代表该方法在空闲的设备执行时延最小的设备id
			int y = 0 ;
			//遍历每个阶段的方法列表	
			for (int j = 0; j < list.get(i).size(); j++){
				/*遍历一下所有未有方法卸载的设备，
				 * 在这些设备中，找出该放在卸载的最小时延的设备
				 */				
				float b = 1000;
				int k = 0;
				while ((k < device.length ) ) {
					//计算出已有方法占据的设备上卸载该方法的总体时延（不空闲设备）
					if (a.contains(k)) {
						k++;
						continue;
						
					}
					//找出方法最低时间卸载设备(空闲设备)	
					if (comp[list.get(i).get(j)][device[k].getId()] < b) {
						//获得未有方法卸载的设备上最小的卸载时间
						b=comp[list.get(i).get(j)][device[k].getId()];
						y = k;
						//device[k].setLocalcost(device[k].getLocalcost() + b);
					}
					k++;
				}
				
				//device[y].setLocalcost(comp[list.get(i).get(j)][y]);
				float c = 1000;
				k = 0; 
				while ((k < device.length )) {
					if (a.contains(k) && (device[k].getLocalcost()+comp[list.get(i).get(j)][device[k].getId()]) < c) {
						//获得已有方法卸载的设备上最小的卸载时间
						c=(device[k].getLocalcost()+comp[list.get(i).get(j)][device[k].getId()]);
						z = k;
					}
					k++;
				}
				//device[z].setLocalcost(device[z].getLocalcost()+comp[list.get(i).get(j)][device[z].getId()]);
				
				if (b > c) {
					outmx[list.get(i).get(j)][z] = 1;
					device[z].setLocalcost(device[z].getLocalcost()+comp[list.get(i).get(j)][device[z].getId()]);
				}
				else {
					outmx[list.get(i).get(j)][y] = 1;
					device[y].setLocalcost(comp[list.get(i).get(j)][y]);
				}
				a.add(y);
				
			}
			float costmid = 0;
			for (int j = 0; j < device.length; j++) {
				if (device[j].getLocalcost() > costmid) {
					costmid = device[j].getLocalcost();
				}
			}
			costall += costmid;
			
			a.clear();
			for (int j = 0; j < device.length; j++) {
				device[j].setLocalcost(0);
			}

		}
		//输出总的消耗的时间费用
		System.out.println(costall);
		return outmx;
	}
	
	/*public float costall(int[][] call, float[][] comp) {
		
		return 0;
	}*/
}
