package CapstonesTesting;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

//*************Created by SRINIVAS TALLA****************

public class SendFileEmail {
	
	      public static void main(String [] args) {
	    	 
	      String[] to = {"srinivas.talla@iil.co.uk"};
	      
	      String from = "srinivas.talla@iil.co.uk";
	      
	      String[] cc = {"srinivas.talla@iil.co.uk"};
	      
	      String[] bcc = {"srinivas.talla@iil.co.uk"};
	      
	      String host = "crumail";
	      
	      Properties properties = System.getProperties();
	      
	      properties.setProperty("mail.smtp.host", host);
	      
	      Session session = Session.getDefaultInstance(properties);

	      try{
	       
	         MimeMessage message = new MimeMessage(session);
	         
	         message.setFrom(new InternetAddress(from));
	         
	         for(int i=0; i<to.length; i++){
	        	 message.addRecipient(Message.RecipientType.TO,new 
	             InternetAddress(to[i]));
	             }
	         
	         for(int i=0;i<cc.length;i++){
	        	 message.addRecipient(Message.RecipientType.CC, new
	        	 InternetAddress(cc[i]));
	        	 }

	         for(int i=0;i<bcc.length;i++){
	        	 message.addRecipient(Message.RecipientType.BCC, new
	        	 InternetAddress(bcc[i]));
	        	 }

	         message.setSubject("TestNG Test Reports!");

	         BodyPart messageBodyPart = new MimeBodyPart();

	         messageBodyPart.setText("Hello There, "
	         		+ "Please find the attached file for the Test Reports! "
	         		+ "(Note: Please open the file in any Web Browser to see the reports)");

	         Multipart multipart = new MimeMultipart();
	         multipart.addBodyPart(messageBodyPart);
	         messageBodyPart = new MimeBodyPart();
	         String filename = "W:\\Eclipse Projects\\project\\test-output\\emailable-report.html";
	         DataSource source = new FileDataSource(filename);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName(filename);
	         multipart.addBodyPart(messageBodyPart);
	         message.setContent(multipart );
	         Transport.send(message);
	         System.out.println("Sent Test Reports successfully....");
	         }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	   }
}
	     



