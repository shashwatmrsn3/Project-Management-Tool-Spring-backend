package com.home.ppmtool.validator;


import com.home.ppmtool.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator  implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {
        User user = (User) object;
        if(user.getPassword().length()<6){
            errors.rejectValue("password","length","password must be atleast 6 characters");

        }

        if(!user.getPassword().equals(user.getConfirmedPassword())){
            errors.rejectValue("password","match","passwords must match");
        }

    }
}
