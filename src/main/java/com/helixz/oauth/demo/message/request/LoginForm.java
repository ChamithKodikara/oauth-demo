package com.helixz.oauth.demo.message.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginForm {

    @NotNull
    @Size(min = 3, max = 60)
    private String login;

    @NotNull
    @Size(min = 3, max = 60)
    private String passw;
}