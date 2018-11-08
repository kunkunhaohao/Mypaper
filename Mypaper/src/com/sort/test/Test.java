package com.sort.test;

import java.util.ArrayList;
import java.util.List;


import com.sort.bean.EdgeNode;
import com.sort.bean.VertexNode;
import com.sort.pro.MyTopoMe;


public class Test {

	public static void main(String[] args) {
		List<VertexNode> vexList = new ArrayList<VertexNode>();
		
		VertexNode c0 = new VertexNode(0, 0, null);
		EdgeNode c0e2 = new EdgeNode(2, 0, null);
		c0.setFirstEdge(c0e2);
		
		VertexNode c1 = new VertexNode(0, 1, null);
		EdgeNode c1e2 = new EdgeNode(2, 0, null);
		EdgeNode c1e12 = new EdgeNode(12, 0, null);
		c1.setFirstEdge(c1e2);
		c1e2.setNext(c1e12);
		
		VertexNode c2 = new VertexNode(0, 2, null);
		EdgeNode c2e6 = new EdgeNode(6, 0, null);
		c2.setFirstEdge(c2e6);
		
	
		VertexNode c3 = new VertexNode(0, 3, null);
		EdgeNode c3e4 = new EdgeNode(4, 0, null);
		c3.setFirstEdge(c3e4);
		
		VertexNode c4 = new VertexNode(0, 4, null);
		EdgeNode c4e5 = new EdgeNode(5, 0, null);
		c4.setFirstEdge(c4e5);
		
		VertexNode c5 = new VertexNode(0, 5, null);
		EdgeNode c5e14 = new EdgeNode(14, 0, null);
		c5.setFirstEdge(c5e14);
		
		VertexNode c6 = new VertexNode(0, 6, null);
		EdgeNode c6e9 = new EdgeNode(9, 0, null);
		EdgeNode c6e10 = new EdgeNode(10, 0, null);
		EdgeNode c6e11 = new EdgeNode(11, 0, null);
		c6.setFirstEdge(c6e9);
		c6e9.setNext(c6e10);
		c6e10.setNext(c6e11);
		
		VertexNode c7 = new VertexNode(0, 7, null);
		EdgeNode c7e8 = new EdgeNode(8, 0, null);
		c7.setFirstEdge(c7e8);
		
		VertexNode c8 = new VertexNode(0, 8, null);
		EdgeNode c8e9 = new EdgeNode(9, 0, null);
		EdgeNode c8e10 = new EdgeNode(10, 0, null);
		c8.setFirstEdge(c8e9);
		c8e9.setNext(c8e10);
		
		VertexNode c9 = new VertexNode(0, 9, null);
		EdgeNode c9e10 = new EdgeNode(13, 0, null);
		c9.setFirstEdge(c9e10);
		
		VertexNode c10 = new VertexNode(0, 10, null);
		VertexNode c11 = new VertexNode(0, 11, null);
		VertexNode c12 = new VertexNode(0, 12, null);
		VertexNode c13 = new VertexNode(0, 13, null);
		VertexNode c14 = new VertexNode(0, 14, null);
		vexList.add(c0);
		vexList.add(c1);
		vexList.add(c2);
		vexList.add(c3);
		vexList.add(c4);
		vexList.add(c5);
		vexList.add(c6);
		vexList.add(c7);
		vexList.add(c8);
		vexList.add(c9);
		vexList.add(c10);
		vexList.add(c11);
		vexList.add(c12);
		vexList.add(c13);
		vexList.add(c14);
		
        MyTopoMe myTopoMe = new MyTopoMe(vexList);
        List<List<Integer>> list = myTopoMe.topologicalSort();
        for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).size(); j++) {
				System.out.print(list.get(i).get(j)+"  ");
			}
			System.out.println();
			
		}

	}

}
