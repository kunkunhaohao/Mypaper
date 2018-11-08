package com.sort.bean;


public class VertexNode {
	/**
     * �������
     */
    private int in;
    
    /**
     * �����򣬴洢������Ϣ���±꣩
     */
    private int data;
    
    /**
     * �߱�ͷָ��
     */
    private EdgeNode firstEdge;
    
    
 
    public VertexNode(int in, int data, EdgeNode firstEdge) {
        super();
        this.in = in;
        this.data = data;
        this.firstEdge = firstEdge;
    }
 
    public int getIn() {
        return in;
    }
 
    public void setIn(int in) {
        this.in = in;
    }
 
    public int getData() {
        return data;
    }
 
    public void setData(int data) {
        this.data = data;
    }
 
    public EdgeNode getFirstEdge() {
        return firstEdge;
    }
 
    public void setFirstEdge(EdgeNode firstEdge) {
        this.firstEdge = firstEdge;
    }
    
    
}
