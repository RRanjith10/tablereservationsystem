package com.mindtree.table.reservation.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender sender;

    public void sendEmail(Long billTotal, String bookeduserMailId, String userName, String bookedhname,
        String bookedusertableSelected, String bookedmenuSelected, int bookedpersonCount) throws Exception {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setTo(bookeduserMailId);
        // dynamic mail text which gives complete details about booking
        String mailText = "<html><body><h2>Table booked - Confirmation</h2><br><br><h3>Here the details of the booking</h3><br><table><tr><td>Customer Name</td>"
            + userName
            + "<td></td></tr><tr><td>Hotel Details</td>"
            + bookedhname
            + "<td></td></tr><tr><td>Booked Table</td><td>"
            + bookedusertableSelected
            + "</td></tr><tr><td>No. of persons</td><td>"
            + bookedpersonCount
            + "</td></tr><tr><td>Total Paid (in Rs.)</td><td>"
            + billTotal
            + "</td></tr></table><br><h4>Thank you for using Bright Creek!!! Happy dining!!!</h4></body></html>";
        helper.setText(mailText, true);
        helper.setSubject("Confirmation of table reservation");
        sender.send(message);
    }

}
