package com.udemy.quiz.controller;
 
import java.io.IOException;
import java.security.Principal;
import java.util.List;

import com.udemy.quiz.dao.QuestionDAO;
import com.udemy.quiz.dao.ResultsDAO;
import com.udemy.quiz.model.Question;
import com.udemy.quiz.model.Results;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	
	@Autowired
    private QuestionDAO questionDAO;
	
	@Autowired
	private ResultsDAO resultsDAO;
	

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String welcomePage(Model model) {
		model.addAttribute("title", "Welcome");
		model.addAttribute("message", "This is welcome page!");
		return "welcomePage";
	}
 
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(Model model) {
		return "adminPage";
	}
	
	@RequestMapping(value = "/quizPage")
	public ModelAndView listQuestion(ModelAndView model) throws IOException{
		
		Results results = new Results();
		model.addObject("results", results);
		
		List<Question> listQuestion = questionDAO.list();
	    model.addObject("listQuestion", listQuestion);
	    model.setViewName("quizPage");
		
		return model;
	}
	
	@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	   public String userInfo(Model model, Principal principal) {
	 
	       // After user login successfully.
	       String userName = principal.getName();
	 
	       System.out.println("User Name: "+ userName);
	 
	       return "userInfoPage";
	}
	
	@RequestMapping(value = "/scores", method = RequestMethod.GET)
	public ModelAndView userInfo(ModelAndView model, Principal principal) {
		
		// After user login successfully.
		String userName = principal.getName();
		List<Results> listResults = resultsDAO.list();
		List<Question> listQuestion = questionDAO.list();
		
		int count=0;
		
		for (Results result : listResults){
	
			for (Question question : listQuestion){
				count++;
				if(count == 1 && result.getQ1() == question.getCorrectAnswer()){
					
					result.setScore(result.getScore()+1);
				}
				if(count == 2 && result.getQ2() == question.getCorrectAnswer()){
					
					result.setScore(result.getScore()+1);
				}
				if(count == 3 && result.getQ3() == question.getCorrectAnswer()){
					
					result.setScore(result.getScore()+1);
				}

			}
			count=0;
		}
		
		model.addObject("listResults", listResults);
		
		System.out.println("User Name: "+ userName);
 
		return model;
	}
	
	@RequestMapping(value = "/submitAnswers", method = RequestMethod.POST)
	public ModelAndView submitAnswers(@ModelAttribute Results results, Principal principal) {
		

		results.setUserName(principal.getName());
	    resultsDAO.submit(results);
	    return new ModelAndView("redirect:/");
	    
	}
 
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model ) {
      
		return "loginPage";
	}
 
	@RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
	public String logoutSuccessfulPage(Model model) {
		model.addAttribute("title", "Logout");
		return "logoutSuccessfulPage";
	}
 
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(Model model, Principal principal) {
        
		if (principal != null) {
			model.addAttribute("message", "Hi " + principal.getName()
				+ "<br> You do not have permission to access this page!");
		} else {
			model.addAttribute("msg",
					"You do not have permission to access this page!");
		}
		return "403Page";
	}
}