package org.springframework.samples.escalade.model;



public class escaladeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 	super() sert à appeler un constructeur de la classe parente d'une classe.
		Ceci est rendu nécessaire lorsque qu'on déclare une classe étendant une autre classe, 
		et que celle-ci ne possède pas de constructeur avec les mêmes arguments.
	 */
	public escaladeException() {
		super();
	}
	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public escaladeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param message
	 * @param cause
	 */
	public escaladeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param message
	 */
	public escaladeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param cause
	 */
	public escaladeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	
}
