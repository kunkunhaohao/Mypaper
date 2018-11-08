package com.sort.bean;

public class EdgeNode {
	/**
     * �ڽӵ��򣬴洢�ö����Ӧ���±�
     */
    private int adjvex;
    
    /**
     * ���ڴ洢Ȩֵ�����ڷ���ͼ���Բ���Ҫ
     */
    private int weight;
    
    /**
     * ����ָ����һ���ڽӵ�
     */
    private EdgeNode next;
    
    
 
    public EdgeNode(int adjvex, int weight, EdgeNode next) {
        super();
        this.adjvex = adjvex;
        this.weight = weight;
        this.next = next;
    }
 
    public int getAdjvex() {
        return adjvex;
    }
 
    public void setAdjvex(int adjvex) {
        this.adjvex = adjvex;
    }
 
    public int getWeight() {
        return weight;
    }
 
    public void setWeight(int weight) {
        this.weight = weight;
    }
 
    public EdgeNode getNext() {
        return next;
    }
 
    public void setNext(EdgeNode next) {
        this.next = next;
    }
}
