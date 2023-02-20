package com.driver;

import static com.google.common.net.HostSpecifier.isValid;

public class Email {

    protected String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        if(oldPassword.equals(password)) {
            if (isValid(newPassword)) {
                System.out.println("Password Changed Successfully!");
                this.password = newPassword;
            }
            else {
                System.out.println("The Password is not valid!");
            }
        }
        else{
            System.out.println("The given password does not match current password!");
        }
    }
    public static  boolean isValid(String passw){
        boolean isUppercase = false;
        boolean isLowercase = false;
        boolean isSpecial = false;
        boolean isdigit = false;
        String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
        if(passw.length()<8) return false;

        for(int i=0;i<passw.length();i++){
            if(passw.charAt(i)>='A' && passw.charAt(i)<='Z') isUppercase = true;

            if(passw.charAt(i)>='1' && passw.charAt(i)<='9') isdigit = true;

            if(passw.charAt(i)>='a' && passw.charAt(i)<='z') isLowercase = true;

            if(specialCharactersString.contains(String.valueOf(passw.charAt(i)))) isSpecial = true;

        }
        return isdigit && isSpecial && isUppercase && isLowercase;
    }
}
