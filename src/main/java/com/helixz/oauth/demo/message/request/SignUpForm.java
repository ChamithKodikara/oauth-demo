package com.helixz.oauth.demo.message.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Date;

@Data
public class SignUpForm {

    @NotNull
    @Size(min = 3, max = 60)
    private String name;

    @Size(min = 0, max = 60)
    private String email;

    @NotNull
    @Size(min = 3, max = 60)
    private String password;

    @NotNull
    @Size(min = 3, max = 12)
    private String phone;

    @NotNull
    private Date birthdate;

    @NotNull
    private boolean gender;
}