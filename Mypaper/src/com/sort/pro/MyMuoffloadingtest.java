package com.sort.pro;

import java.util.ArrayList;
import java.util.List;

import com.sort.bean.Device;

public class MyMuoffloadingtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> list2 = new ArrayList<Integer>();
		List<Integer> list3 = new ArrayList<Integer>();
		List<Integer> list4 = new ArrayList<Integer>();
		List<Integer> list5 = new ArrayList<Integer>();
		List<Integer> list6 = new ArrayList<Integer>();

		list2.add(0);
		list2.add(1);
		list2.add(3);
		list2.add(7);
		
		list3.add(2);
		list3.add(12);
		list3.add(4);
		list3.add(8);
		
		list4.add(6);
		list4.add(5);
		
		list5.add(9);
		list5.add(10);
		list5.add(11);
		list5.add(14);
		
		list6.add(13);
		//list2.add(3);
		list.add(list2);
		list.add(list3);
		list.add(list4);
		list.add(list5);
		list.add(list6);
		
		Device[] device = {new Device(0, 0,"l0"),new Device(1, 0 ,"r1"),new Device(2, 0, "r2"),new Device(3, 0 ,"r3")};
		float[][] comp = {{(float) 9.8,(float) 3.4,(float) 4.4,(float) 3.3},
						  {(float) 9.7,(float) 3.3,(float) 4.2,(float) 3.2},
						  {(float) 9.9,(float) 3.5,(float) 4.4,(float) 3.4},
						  {(float) 9.6,(float) 3.2,(float) 4.1,(float) 3.1},
						  {(float) 6.0,(float) 2.0,(float) 2.4,(float) 2.1},
						  {(float) 3.4,(float) 1.2,(float) 1.4,(float) 1.2},
						  {(float) 6.2,(float) 2.1,(float) 2.4,(float) 2.1},
						  {(float) 6.4,(float) 2.2,(float) 2.5,(float) 2.3},
						  {(float) 3.0,(float) 1.0,(float) 1.2,(float) 1.0},
						  {(float) 3.3,(float) 1.2,(float) 1.4,(float) 1.2},
						  {(float) 3.2,(float) 1.1,(float) 1.3,(float) 1.1},
						  {(float) 6.4,(float) 2.2,(float) 2.5,(float) 2.3},
						  {(float) 9.8,(float) 3.4,(float) 4.3,(float) 3.3},
						  {(float) 9.6,(float) 3.2,(float) 4.1,(float) 3.1},
						  {(float) 6.7,(float) 3.4,(float) 2.8,(float) 2.5},
						  };
		float[] comm = {0,(float) 0.8,(float) 0.6,(float) 0.9};
		
		MyMuOffloading myMuOffloading = new MyMuOffloading(list, device, comp, comm);
		myMuOffloading.compuncomm();
		int[][] outmx = myMuOffloading.distri();
		for (int i = 0; i < outmx.length; i++) {
			for (int j = 0; j < outmx[0].length; j++) {
				System.out.print(outmx[i][j] +"  ");
			}
			System.out.println();
		}
		
		/*float costall = 
		
		System.out.println(costall);*/
	}

}
