package tw.com.jeff.config;

import java.util.*;


import javax.activation.*;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class TESTEmail
{
   public static void main(String [] args) {
	   InternetAddress[] address = null ;
	    String mailServer = "smtp.gmail.com";
	    String From = "Jeff4208@gmail.com";
	    String To = "655011abc@gmail.com";
	    String error="";
	    String Subject  = "To Touring 驗證";
	    UUID uuid  =  UUID.randomUUID(); 
	    String messageText  = "";
	    String messageText1  = "點此連結來啟用您的新帳戶<br>"+"<a href='https://tw.yahoo.com'>"+uuid+"</a>";
	    
	    try {
	      Properties props = System.getProperties();
	      props.put("mail.host",mailServer);
	      props.put("mail.transport.protocol","smtp");
	      props.put("mail.smtp.auth", "true");
	       props.put("mail.smtp.socketFactory.port", "587");
	       props.put("mail.smtp.socketFactory.class", "javax.net.SocketFactory");
	       props.put("mail.smtp.auth", "true");
	       props.put("mail.smtp.port", "587");
	       props.put("mail.smtp.ssl.enable", "false");
	       props.put("mail.smtp.starttls.enable", "true");
	       props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	      
	      //建立認證物件
	       Authenticator auth = new javax.mail.Authenticator() {   
	      String userName="Jeff4208@gmail.com"; 
	      String password = "jeff11592105";
	      protected PasswordAuthentication getPasswordAuthentication(){   
	        return new PasswordAuthentication(userName, password);   
	        }   
	      };   
	       
	      Session mailSession = javax.mail.Session.getInstance(props,auth); 
	      mailSession.setDebug(false);
	 
	      MimeMessage msg = new MimeMessage(mailSession);
	      
	      msg.setFrom(new InternetAddress(From));
	      
	      address = InternetAddress.parse(To,false);
	 
	      msg.setRecipients(Message.RecipientType.TO, address);
	      msg.setSubject(Subject,"Big5"); 
	      msg.setSentDate(new Date());   
//	      msg.setText(messageText, "UTF-8"); 
	      msg.setContent(messageText1, "text/html;charset=UTF-8");
	      Transport.send(msg);
	      System.out.println("成功傳送");
	      error="email.jsp?error=sucess";
	    }
	    catch (MessagingException mex) {
	      System.out.println("發生錯誤，例外物件的型別為[");
	      System.out.println(mex.toString()); 
	      System.out.println("]");
	      error="email.jsp?error="+"mex.toString()";
	    } 
	   
	  }
      
   }
