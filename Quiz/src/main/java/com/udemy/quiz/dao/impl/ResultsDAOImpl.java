package com.udemy.quiz.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.udemy.quiz.dao.ResultsDAO;
import com.udemy.quiz.model.Question;
import com.udemy.quiz.model.Results;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class ResultsDAOImpl implements ResultsDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public ResultsDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	@Override
    public void submit(Results results) {

		String sql = "INSERT INTO quizresults (username, Q1, Q2, Q3)"
            + " VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sql, results.getUserName(), results.getQ1(), results.getQ2(), results.getQ3());
	}
	
	@Override
    public List<Results> list() {
		
		String sql = "SELECT * FROM quizresults";
        List<Results> listResults = jdbcTemplate.query(sql, new RowMapper<Results>() {
        
	        @Override
	        public Results mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	Results aResult = new Results();
	 
	        	aResult.setUserName(rs.getString("USERNAME"));
	        	aResult.setQ1(rs.getInt("Q1"));
	        	aResult.setQ2(rs.getInt("Q2"));
	        	aResult.setQ3(rs.getInt("Q3"));
	            
	            return aResult;
	        }
	    });
        return listResults;
    }
	
	@Override
    public List<Results> list(String username) {
		
		String sql = "SELECT * FROM quizresults WHERE username="+username;
        List<Results> listResults = jdbcTemplate.query(sql, new RowMapper<Results>() {
        
	        @Override
	        public Results mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	Results aResult = new Results();
	 
	        	aResult.setUserName(rs.getString("USERNAME"));
	        	aResult.setQ1(rs.getInt("Q1"));
	        	aResult.setQ2(rs.getInt("Q2"));
	        	aResult.setQ3(rs.getInt("Q3"));
	            
	            return aResult;
	        }
	    });
        return listResults;
    }
}