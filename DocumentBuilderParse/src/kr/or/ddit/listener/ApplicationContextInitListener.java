package kr.or.ddit.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationContextInitListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce)  { 
    	String param = sce.getServletContext().getInitParameter("testParam");
    	System.out.println(param);
    }
	
    public void contextDestroyed(ServletContextEvent sce)  { 
    	
    }
}
