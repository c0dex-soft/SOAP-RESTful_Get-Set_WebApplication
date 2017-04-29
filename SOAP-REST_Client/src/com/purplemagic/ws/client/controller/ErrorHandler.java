package com.purplemagic.ws.client.controller;

import javax.persistence.NonUniqueResultException;
import javax.xml.ws.soap.SOAPFaultException;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

	@ExceptionHandler(DataAccessException.class)
	public String handleDatabaseException (DataAccessException ex, Model model) {
		ex.printStackTrace();
		return "error";
	}
	
	// Hvatanje izuzetka u slucaju da se korisnik sa trazenim ID-jem ne nalazi u bazi
	@ExceptionHandler(NonUniqueResultException.class)
	public String handleEmptyResult(NonUniqueResultException ex, Model model) {
		ex.printStackTrace();
		ex.getMessage();
		model.addAttribute("title", "Customer with this ID doesn't exist in persistence storage");
		model.addAttribute("errormessage", ex);
		model.addAttribute("errorcode", ex.getStackTrace());
		return "errorpage";
	}
	
	
	@ExceptionHandler(SOAPFaultException.class)
	public String handleUpdateNonexistentUser(SOAPFaultException ex, Model model) {
		ex.printStackTrace();
		ex.getMessage();
		model.addAttribute("title", "You are trying to update customer who doesn't exist");
		model.addAttribute("errormessage", ex);
		model.addAttribute("errorcode", ex.getStackTrace());
		return "errorpage";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String handleInvalidInput(IllegalArgumentException ex, Model model) {
		ex.printStackTrace();
		ex.getMessage();
		model.addAttribute("title", "Mandatory fields aren't passed in");
		model.addAttribute("errormessage", ex.getMessage());
		model.addAttribute("errorcode", ex.getStackTrace());
		return "errorpage";
	}
	
	@ExceptionHandler(Exception.class)
	public String handleGenericException(Exception ex, Model model) {
		ex.printStackTrace();
		ex.getMessage();
		model.addAttribute("title", "Generic Error");
		model.addAttribute("errormessage", ex);
		model.addAttribute("errorcode", ex.getStackTrace());
		return "errorpage";
	}
	
}
