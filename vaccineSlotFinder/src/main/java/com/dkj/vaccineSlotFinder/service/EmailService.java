package com.dkj.vaccineSlotFinder.service;

import com.dkj.vaccineSlotFinder.DTO.Center;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    private List<String> availableCenters = new ArrayList<>();
    @Value("${email.to}")
    String to;
    @Value("${email.from}")
    String from;

    public String sendEmail(List<Center> centers)
    {
        centers.forEach(center->{
            availableCenters.add(center.getName());
        });
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setText (String.join(",", availableCenters));
        message.setSubject ("Available Vaccine Centers");
        mailSender.send(message);
        return "Mail Send";
    }

}
