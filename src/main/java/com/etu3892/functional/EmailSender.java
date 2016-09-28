package com.etu3892.functional;


import com.etu3892.db.Entities.User;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSender {
    private String username;
    private String password;
    private Properties properties;
    final String FROM_EMAIL = "sp.noreply@ro.ru";

    public EmailSender(String username, String password) {
        this.username = username;
        this.password = password;

        properties = new Properties();
        properties.put("mail.smtp.host", "smtp.rambler.ru");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
    }

    private void sendEmail (String subj, String text, String to){
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subj);
            message.setText(text);
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void confirmRegistration(String to, String username){
        EmailSender sender = new EmailSender("sp.noreply@ro.ru","amngr51");
        String message = "Congratulations, "+username+"!\n" + "And welcome to Sports Predictor!";
        sender.sendEmail("Registration successful",message, to);
    }

    public static void forgotPassword(User user){
        EmailSender sender = new EmailSender("sp.noreply@ro.ru","amngr51");
        String message = "Hello, "+user.getUsername()+"!\n" + "Your password: "+user.getPassword();
        sender.sendEmail("Your password",message, user.getEmail());
    }

}
