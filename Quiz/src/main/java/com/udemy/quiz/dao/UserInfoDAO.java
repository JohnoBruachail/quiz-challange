package com.udemy.quiz.dao;
 
import java.util.List;
 
import com.udemy.quiz.model.UserInfo;
 
public interface UserInfoDAO {
     
    public UserInfo findUserInfo(String userName);
    
    // [USER,AMIN,..]
    public List<String> getUserRoles(String userName);
     
}