package com.udemy.quiz.dao;

import java.util.List;

import com.udemy.quiz.model.Results;

public interface ResultsDAO {

	 public void submit(Results results);
	 public List<Results> list();
	 public List<Results> list(String username);
}
