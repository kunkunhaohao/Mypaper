package com.sort.pro;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.sort.bean.EdgeNode;
import com.sort.bean.VertexNode;

public class MyTopoMe {
	
	public MyTopoMe(List<VertexNode> vexList) {
		this.vexList = vexList;
	}
	
	//卸载顺序
	public List<List<Integer>> list3 = new ArrayList<List<Integer>>();
    /**
     * 顶点数组
     */
    private List<VertexNode> vexList;
    //建栈存储入度为0的顶点
    
    /**
     * 创建图（邻接表）
     */
    //拓扑排序
    public List<List<Integer>> topologicalSort() {

        //统计输出顶点数
        
        //建栈存储入度为0的顶点,存放拓扑排序的顺序
        Stack<Integer> stack = new Stack<>();
        //
        List<Integer> list = new ArrayList<Integer>();
        //存放每个阶段的入度为零的点
        List<Integer> list2 = new ArrayList<Integer>();
        //List<List<Integer>> list3 = new ArrayList<List<Integer>>();
        
        //统计入度数（录入也可以，但是示例图的v9的度应为2，示例图中误写为1，导致查了半天bug，自动统计入度数看来也是有必要的）
        for (int i = 0;i < vexList.size(); i++) {
            vexList.get(i).setIn(0);
        }
        for (int i = 0;i < vexList.size(); i++) {
            
            EdgeNode edge = vexList.get(i).getFirstEdge();
            while (edge != null) {
                VertexNode vex = vexList.get(edge.getAdjvex());
                vex.setIn(vex.getIn() + 1);
                edge = edge.getNext();
            }
        }
        
        //将入度为0 的顶点入栈
        for (int i = 0;i < vexList.size(); i++) {
            if (vexList.get(i).getIn() == 0) {
                stack.push(i);
                list.add(i);
            }
        }
          
    	do {
    		list3.add(list);
			for (int i = 0; i < list.size(); i++) {
				int vexIndex = list.get(i);
				//System.out.println(vexIndex + "  ");
			
				EdgeNode edge = vexList.get(vexIndex).getFirstEdge();
				while (edge != null) {
		             int adjvex = edge.getAdjvex();
		                
		             VertexNode vex = vexList.get(adjvex);
		                
		             //将此 顶点的入度减一
		             vex.setIn(vex.getIn() - 1);
		             //此顶点的入度为零则入栈，以便于下次循环输出
		             if (vex.getIn() == 0) {
		                 stack.push(adjvex);
		                 list2.add(adjvex);
		  
		                    
		              }
		             edge = edge.getNext(); 
		         }
			}
			//list.clear();
			list = new ArrayList<Integer>();
			for (int j = 0; j < list2.size(); j++) {
					list.add(list2.get(j));
				}
			list2.clear();
			
		} while (!(list.isEmpty()&&list2.isEmpty()));   
    	
    	
    	 if (stack.size()!= vexList.size())
             System.out.println("false");
         else
             System.out.println("true");
    	 
    	return list3;
    }	

}