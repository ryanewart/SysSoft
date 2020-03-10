/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weathersystem;

import java.io.*;
/**
 *
 * @author Tom
 */
public class UserLogin implements Serializable 
{
    private String username;
    private String password; 

    public UserLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public boolean equals(UserLogin login)
    {
        return (this.username.equals(login.username) && this.password.equals(login.password));
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
