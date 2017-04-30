package com.udemy.quiz.model;

public class Question{
	
	private int questionid;
	private String question;
    private String answerOne;
    private String answerTwo;
    private String answerThree;
    private int correctAnswer;
	
    public Question() {
    }
    
    public Question(String question, String answerOne, String answerTwo, String answerThree, int correctAnswer){
    	this.question = question;
    	this.answerOne = answerOne;
    	this.answerTwo = answerTwo;
    	this.answerThree = answerThree;
    	this.correctAnswer = correctAnswer;
    }
    
    public int getID() {
		return questionid;
	}

	public void setID(int questionid) {
		this.questionid = questionid;
	}
    
    public String getQuestion() {
        return question;
    }
    
    public void setQuestion(String question) {
        this.question = question;
    }
    
    public String getAnswerOne() {
        return answerOne;
    }
    
    public void setAnswerOne(String answerOne) {
        this.answerOne = answerOne;
    }
    
    public String getAnswerTwo() {
        return answerTwo;
    }
    
    public void setAnswerTwo(String answerTwo) {
        this.answerTwo = answerTwo;
    }
    
    public String getAnswerThree() {
        return answerThree;
    }
    
    public void setAnswerThree(String answerThree) {
        this.answerThree = answerThree;
    }
    
    public int getCorrectAnswer() {
        return correctAnswer;
    }
    
    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
