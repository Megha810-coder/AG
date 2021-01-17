package com.spcl.erp.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

@WebServlet("/mail")
public class MailApp extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Model model = null;
		response.setContentType("text/jsp;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String to = request.getParameter("to");
        String subject = request.getParameter("subject");
        String message =  request.getParameter("message");
        String user = request.getParameter("gmailuser");
        String pass = request.getParameter("gmailpass");
        SendMail.send(to,subject, message, user, pass);
		/*
		 * String Message="Mail send successfully";
		 * 
		 * request.setAttribute("Message", Message);
		 * 
		 * RequestDispatcher dispatcher =
		 * getServletContext().getRequestDispatcher("urlString");
		 * dispatcher.forward(request, response);
		 */
        out.println("Mail send Successfully");
        }
	
}













