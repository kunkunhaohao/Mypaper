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
	
	//��ͨ������ÿ��ӵ����������
	public float[][] compuncomm() {
		// TODO Auto-generated method stub
		for (int i = 0; i < comp.length; i++) {
			for (int j = 0; j < comp[0].length; j++) {
				comp[i][j] = comp[i][j] + comm[j];
			}
		}
		return comp;
	}
	
	//����������õ��б�������ͬ���豸 outmaxΪ�����豸���þ���
	public int[][]  distri(){
		//����ķ������þ���
		int[][] outmx = new int[comp.length][device.length];
		//�ܵ����ĵ�ʱ��
		float costall = 0;
		
		for (int i = 0; i < list.size(); i++) {
			//���Ѿ��з����ڸ��豸��ж�ص��豸���ڸ�������
			ArrayList<Integer> a=new ArrayList<Integer>();
			//�������з������豸��ж�صĸ÷������豸id
			int z = 0;
			//����÷����ڿ��е��豸ִ��ʱ����С���豸id
			int y = 0 ;
			//����ÿ���׶εķ����б�	
			for (int j = 0; j < list.get(i).size(); j++){
				/*����һ������δ�з���ж�ص��豸��
				 * ����Щ�豸�У��ҳ��÷���ж�ص���Сʱ�ӵ��豸
				 */				
				float b = 1000;
				int k = 0;
				while ((k < device.length ) ) {
					//��������з���ռ�ݵ��豸��ж�ظ÷���������ʱ�ӣ��������豸��
					if (a.contains(k)) {
						k++;
						continue;
						
					}
					//�ҳ��������ʱ��ж���豸(�����豸)	
					if (comp[list.get(i).get(j)][device[k].getId()] < b) {
						//���δ�з���ж�ص��豸����С��ж��ʱ��
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
						//������з���ж�ص��豸����С��ж��ʱ��
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
		//����ܵ����ĵ�ʱ�����
		System.out.println(costall);
		return outmx;
	}
	
	/*public float costall(int[][] call, float[][] comp) {
		
		return 0;
	}*/
}
