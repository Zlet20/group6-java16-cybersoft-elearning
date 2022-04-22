package  com.group6.java16.cybersoft.user.validation.validator; 

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.group6.java16.cybersoft.user.repository.ELUserRepository;
import com.group6.java16.cybersoft.user.validation.annotation.UniqueEmail;

import org.springframework.beans.factory.annotation.Autowired;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
	private String message;
	
	@Autowired
	private ELUserRepository repository;
	
	@Override
	public void initialize(UniqueEmail uniqueEmail) {
		message = uniqueEmail.message();
	}
	
	
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {

		if(!repository.existsByEmail(email)) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(message)
		.addConstraintViolation()
		.disableDefaultConstraintViolation();
		return false;
	}

}
