package com.udemy.quiz.model;

public class Results {
	
	private String username;
	private int q1, q2, q3;
	private int score = 0;
	
	public Results() {
    }
	
	public Results(String username, int q1, int q2, int q3){
		this.username = username;
		this.q1 = q1;
		this.q2 = q2;
		this.q3 = q3;
	}
	
	public String getUserName() {
		return username;
	}
	
	public void setUserName(String username) {
		this.username = username;
	}
    
    public int getQ1() {
        return q1;
    }
    
    public void setQ1(int q1) {
    	this.q1 = q1;
    }
    
    public int getQ2() {
        return q2;
    }
    
    public void setQ2(int q2) {
    	this.q2 = q2;
    }
    
    public int getQ3() {
        return q3;
    }
    
    public void setQ3(int q3) {
    	this.q3 = q3;
    }
    
    public int getScore() {
        return score;
    }
    
    public void setScore(int score) {
    	this.score = score;
    }
}
