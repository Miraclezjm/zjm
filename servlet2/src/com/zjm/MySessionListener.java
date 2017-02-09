package com.zjm;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MySessionListener
 *
 */
@WebListener
public class MySessionListener implements HttpSessionListener {
	

    /**
     * Default constructor. 
     */
    public MySessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent event){
    	ServletContext ctx = event.getSession().getServletContext();
    	Object userObj = event.getSession().getServletContext().getAttribute("user");
    	if(userObj!=null){
    		int user = (Integer)userObj;
    		user++;
    		ctx.setAttribute("user", user);  		
    	}
    	else{
    		ctx.setAttribute("user", 1);
    	}
    	
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent event)  { 
    	ServletContext ctx = event.getSession().getServletContext();
    	Object userObj = event.getSession().getServletContext().getAttribute("user");
    	if(userObj!=null){
    		int user = (Integer)userObj;
    		user--;
    		ctx.setAttribute("user", user);  		
    	}
    	 
    }
    
    
	
}
