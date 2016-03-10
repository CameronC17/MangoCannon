/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mangocannon;

/**
 *
 * @author Tom Hanson
 */
public class User {
    private String firstName;
    private String secondName;
    private String password;
    private long uniqueId;
    private int AccessLevel;
    private String username;
    
    /**
     * user constructor takes all relevant info and creates a new user
     * @param theFirstName
     * @param theSecondName
     * @param thePassword
     * @param theUniqueId
     * @param theAccessLevel
     * @param theUsername 
     */
    public User(String theFirstName, String theSecondName, String thePassword, long theUniqueId, int theAccessLevel, String theUsername){
        this.firstName = theFirstName;
        this.secondName = theSecondName;
        this.password = thePassword;
        this.uniqueId = theUniqueId;
        this.AccessLevel = theAccessLevel;
        this.username = theUsername;
        
    }
    
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
        return AccessLevel;
    }
    
    void setAccessLevel(int theAccessLevel){
        this.AccessLevel = theAccessLevel;
    }
    
    
}
