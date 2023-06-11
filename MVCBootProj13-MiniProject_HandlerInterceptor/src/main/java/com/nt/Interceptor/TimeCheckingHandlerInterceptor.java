package com.nt.Interceptor;

import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class TimeCheckingHandlerInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws Exception {
		System.out.println("TimeCheckingHandlerInterceptor.preHandle()");
		if(req.getServletPath().equalsIgnoreCase("/"))
			return true;
		//get system date and time
		LocalDateTime ldt=LocalDateTime.now();
		//get hour
		int hour=ldt.getHour();
		//check the time
		if(hour<9 || hour>17) {
			RequestDispatcher rd=req.getRequestDispatcher("/timeout.jsp");
			rd.forward(req, res);
			return false;
		}
		return true;
	}

}
