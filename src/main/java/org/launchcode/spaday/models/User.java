package org.launchcode.spaday.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

public class User {
    @NotBlank(message="Username required")
    @Size(min=5, max=15)
    private String username;

    @Email(message="Please provide valid email")
    private String email;

    @NotBlank(message="Password required")
    @Size(min=6)
    private String password;

    @Null(message="Password do not match")
    private String verifyPassword;


    public User() {

    }

    public User(String username, String email, String password, String verifyPassword) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        this.verifyPassword = verifyPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }

    private void checkPassword (){
        if(!this.password.equals(this.verifyPassword)
                && !this.password.isEmpty()
                && getVerifyPassword() != null) {
            verifyPassword = null;
        }
    }

}

