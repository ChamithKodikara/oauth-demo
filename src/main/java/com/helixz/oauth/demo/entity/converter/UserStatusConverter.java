package com.helixz.oauth.demo.entity.converter;

import com.helixz.oauth.demo.enums.UserStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author Chamith
 */
@Converter(autoApply = true)
public class UserStatusConverter implements AttributeConverter<UserStatus, String> {

    @Override
    public String convertToDatabaseColumn(UserStatus attribute) {
        return attribute.getValue();
    }

    @Override
    public UserStatus convertToEntityAttribute(String dbData) {
        return UserStatus.getEnum(dbData);
    }

}

