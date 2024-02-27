package tw.com.jeff.config;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	
	public void Sendemail(String master,String joinId,String tripname,String mastername,Integer needid) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date5 = new Date();
    	String A5 =format.format(date5);
    	System.out.println("intofunction="+A5);
		   InternetAddress[] address = null ;
		    String mailServer = "smtp.gmail.com";
		    String From = "Jeff4208@gmail.com";
		    String To = master;
		    String error="";
		    String Subject  = "【To Touring】 報名通知";
//		    UUID uuid  =  UUID.randomUUID(); 
		   
		    String messageText  = 	mastername+"您好：<br>"+
		    						"<label style='font-weight:700;font-size:15px;'>"+joinId+"</label>" + "\t報名了您主辦的" +
		    						"『<label style='font-weight:700;font-size:15px;'>"+tripname +"』</label><br>"+
		    						"<a href='http://localhost:8080/FinalProject/Detail/"+needid+"'>前往查看詳細資訊</a>";
		    try {
		    	
		    	Date date = new Date();
		    	String A =format.format(date);
		    	System.out.println("CodeStart="+A);
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
		       SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		    	Date date1 = new Date();
		    	String A1 =format1.format(date1);
		    	System.out.println("認證物件開始="+A1);
		      //建立認證物件
		       Authenticator auth = new javax.mail.Authenticator() {   
		      String userName="Jeff4208@gmail.com"; 
		      String password = "jeff11592105";
		      protected PasswordAuthentication getPasswordAuthentication(){   
		    	  Date date2 = new Date();
		    	  String A2 =format1.format(date2);
		    	  System.out.println("認證物件finish="+A2);
		        return new PasswordAuthentication(userName, password);   
		        }   
		      };   
		      Date date3 = new Date();
	    	  String A3 =format1.format(date3);
	    	  System.out.println("Session="+A3);
		      Session mailSession = javax.mail.Session.getInstance(props,auth); 
		      mailSession.setDebug(false);
		 
		      MimeMessage msg = new MimeMessage(mailSession);
		      
		      msg.setFrom(new InternetAddress(From));
		      
		      address = InternetAddress.parse(To,false);
		 
		      msg.setRecipients(Message.RecipientType.TO, address);
		      msg.setSubject(Subject,"Big5"); 
		      msg.setSentDate(new Date());   
//		      msg.setText(messageText, "UTF-8"); 
		      msg.setContent(messageText, "text/html;charset=UTF-8");
		      Transport.send(msg);
		      Date date4 = new Date();
	    	  String A4 =format1.format(date4);
	    	  System.out.println("Send="+A4);
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
