package com.example.demo.validator;

import com.example.demo.entity.User;
import com.example.demo.validator.annotation.ValidUserId;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Valid;

public class ValidUserIdValidator implements ConstraintValidator<ValidUserId, User> {
    @Override
    public boolean isValid(User user, ConstraintValidatorContext context){
        if(user==null){
            return true;
        }
        return user.getId()!=null;
    }
}
