package com.udemy.quiz.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.udemy.quiz.dao.QuestionDAO;
import com.udemy.quiz.model.Question;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class QuestionDAOImpl implements QuestionDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public QuestionDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	@Override
    public List<Question> list() {
		
		String sql = "SELECT * FROM questions";
        List<Question> listQuestion = jdbcTemplate.query(sql, new RowMapper<Question>() {
        
	        @Override
	        public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Question aQuestion = new Question();
	 
	            aQuestion.setID(rs.getInt("Question_ID"));
	            aQuestion.setQuestion(rs.getString("Question"));
	            aQuestion.setAnswerOne(rs.getString("Answer_One"));
	            aQuestion.setAnswerTwo(rs.getString("Answer_Two"));
	            aQuestion.setAnswerThree(rs.getString("Answer_Three"));
	            aQuestion.setCorrectAnswer(rs.getInt("Correct_Answer"));
	            
	            return aQuestion;
	        }
	    });
        return listQuestion;
    }
}
