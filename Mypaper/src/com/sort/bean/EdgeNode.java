package com.sort.bean;

public class EdgeNode {
	/**
     * 邻接点域，存储该顶点对应的下标
     */
    private int adjvex;
    
    /**
     * 用于存储权值，对于非网图可以不需要
     */
    private int weight;
    
    /**
     * 链域，指向下一个邻接点
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
