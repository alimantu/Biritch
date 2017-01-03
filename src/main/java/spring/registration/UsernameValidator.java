package spring.registration;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameValidator implements ConstraintValidator<ValidUsername, String> {

    @Override
    public void initialize(ValidUsername constraintAnnotation) {}

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        return username.length() >= 5;
    }
}
