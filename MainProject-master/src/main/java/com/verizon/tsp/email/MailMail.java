package com.verizon.tsp.email;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;  
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;  

public class MailMail{  
    private MailSender mailSender;  
   
    public void setMailSender(MailSender mailSender) {  
        this.mailSender = mailSender;  
    }    
    
    public void sendMail(String from, String[] to, String subject, String msg) {  
        //creating message  
     SimpleMailMessage message = new SimpleMailMessage();  
         message.setFrom(from);  
     message.setTo(to);//passing array of recipients  
     message.setSubject(subject);  
     message.setText(msg);  
        //sending message  
     mailSender.send(message);     
 }  
 } 