package email;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.MessagingException;
import javax.mail.*;
import java.util.*;

public class JavaMailUtil {
	
	public static void sendMail(String recepirnt) throws Exception {
		System.out.println("preparing to send email");
		
		Properties properties = new Properties();
		
		properties.put("mail.smtp.auth",true);
		properties.put("mail.smtp.starttls.enable",true);
		properties.put("mail.smtp.host","smtp.gmail.com");
		properties.put("mail.smtp.port","587");
		
		String myAcccount="sr.sourabh98@gmail.com";
		String password="8427759992";
		
	Session session=Session.getInstance(properties, new Authenticator(){
		
		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
	
			return new PasswordAuthentication(myAcccount, password);
		}

	});
	String recepient = null;
	Message message = prepareMessage(session,myAcccount, recepient);
		Transport.send(message);
		System.out.println("message send sucess");
	
	}
	private static Message prepareMessage(Session session , String myAccount,String recepient) {
		Message message= new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(myAccount));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient) );
			message.getSubject();
			message.setText("this is forst email");
			return message;
		} catch (Exception e) {
			
			Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE,null,e);
			
		} 
		return null;
		}
		
}

