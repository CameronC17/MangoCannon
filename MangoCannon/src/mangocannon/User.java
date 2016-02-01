/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mangocannon;

/**
 *
 * @author jacobburns
 */
public class User {
    private String firstName;
    private String secondName;
    private String password;
    private long uniqueId;
    private int AccessLevel;
    private String username;
    
    
    String getFirstName(){
        return firstName;
    }
    
    void setFirstName(String theFirstName){
        this.firstName = theFirstName;
    }
    
    String getSecondName(){
        return secondName;
    }
    
    void setSecondName(String theSecondName){
        this.secondName = theSecondName;
    }
    
    String getPassword() {
        return password;
    }
    
    void setPassword(String thePassword){
        this.password = thePassword;
    }
    
    String getUsername() {
        return username;
    }
    
    void setUsername(String theUsername){
        this.username = theUsername;
    }
    
    long getUniqueId(){
        return uniqueId;
    }
    
    void setUniqueId(long theUniqueId){
        this.uniqueId = theUniqueId;
    }
    
    int getAccessLevel(){
        return accessLevel;
    }
    
    void setAccessLevel(int theAccessLevel){
        this.AccessLevel = theAccessLevel;
    }
    
    
}
