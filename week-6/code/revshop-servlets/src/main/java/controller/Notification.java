package controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;


public class Notification{
	
	public static void sendNotification() throws FileNotFoundException, IOException {
		
		Properties props = new Properties();
				 
		props.load(new FileReader("C:/jfs/training-notes-week-5/revshop-servlets/src/main/resources/mail.properties"));
	    String to = "krishnagopika1701@gmail.com";
	    
	    String username = props.getProperty("username");
	    String password = props.getProperty("password");
	    String from = props.getProperty("from"); 
	      
	      Authenticator authenticator = new Authenticator() {
	    	  protected PasswordAuthentication getPasswordAuthentication() {
	    	  return new PasswordAuthentication(username, password);
	    	  }
	    	  };
		Session session = Session.getInstance(props, authenticator);  
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(from));
		
	    //set To email field
	    message.setRecipients(Message.RecipientType.TO,
	               InternetAddress.parse(to));
	    //set email subject field
	    message.setSubject("RevShop Order Placed");
	    //set the content of the email message
	    message.setText("Order Placed for Ambrane Power Bank");
	    //send the email message
	    Transport.send(message);
	    System.out.println("Email Message Sent Successfully");
		}
	    catch (MessagingException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		sendNotification();
	}

}
