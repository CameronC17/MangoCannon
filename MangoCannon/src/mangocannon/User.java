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
    private String fieldName;
    private String secondName;
    //I added this password variable as their wasn't one...
    private String password;
    private long uniqueId;
    private int AccessLevel;
    
    String getPassword() {
        return password;
    }
}
