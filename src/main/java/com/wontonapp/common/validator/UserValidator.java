package com.wontonapp.common.validator;


import com.wontonapp.model.UserEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import org.springframework.validation.Validator;

public class UserValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return UserEntity.class.equals(clazz);
    }
    @Override
    public void validate(Object obj, Errors e) {

        ValidationUtils.rejectIfEmpty(e, "name", null, "名字不能为空");
        ValidationUtils.rejectIfEmpty(e, "age", null, "年龄不能为空");
        ValidationUtils.rejectIfEmpty(e, "phone", null, "电话不能为空");
    }

}
