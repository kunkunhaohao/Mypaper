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
	
	//ж��˳��
	public List<List<Integer>> list3 = new ArrayList<List<Integer>>();
    /**
     * ��������
     */
    private List<VertexNode> vexList;
    //��ջ�洢���Ϊ0�Ķ���
    
    /**
     * ����ͼ���ڽӱ�
     */
    //��������
    public List<List<Integer>> topologicalSort() {

        //ͳ�����������
        
        //��ջ�洢���Ϊ0�Ķ���,������������˳��
        Stack<Integer> stack = new Stack<>();
        //
        List<Integer> list = new ArrayList<Integer>();
        //���ÿ���׶ε����Ϊ��ĵ�
        List<Integer> list2 = new ArrayList<Integer>();
        //List<List<Integer>> list3 = new ArrayList<List<Integer>>();
        
        //ͳ���������¼��Ҳ���ԣ�����ʾ��ͼ��v9�Ķ�ӦΪ2��ʾ��ͼ����дΪ1�����²��˰���bug���Զ�ͳ�����������Ҳ���б�Ҫ�ģ�
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
        
        //�����Ϊ0 �Ķ�����ջ
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
		                
		             //���� �������ȼ�һ
		             vex.setIn(vex.getIn() - 1);
		             //�˶�������Ϊ������ջ���Ա����´�ѭ�����
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