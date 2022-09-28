package com.app.services;

import com.app.pojos.EmailDetails;

public interface EmailService {
	
    String sendSimpleMail(EmailDetails details);

}
