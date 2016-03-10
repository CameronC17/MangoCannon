/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mangocannon;

import java.util.Vector;

/**
 *
 * @author jacobburns
 */
public class UserRegister extends Vector<User> {
    void addUser(User theUser){
        super.add(theUser);
    }
    
    /**
     * returns the int position of the user account in the list
     * @param i
     * @return 
     */
    User findUserByIndex(int i) {
        return this.get(i);
    }
    
    /**
     * takes a name and password, and then:
     * * First looks to find the exact user name.
     * If found, checks the password against the one supplied
     * If correct, returns the index of the user in the vector, else returns -1
     * @param username
     * @param password
     * @return 
     */
    User login(String username, String password){
        User returnUser = null;
        for (int i = 0; i < this.size(); i++)
        {
            if (this.get(i).getUsername().contentEquals(username))
            {
                if (this.get(i).getPassword().contentEquals(password))
                {
                    returnUser = this.get(i);
                }
            }
        }        
        return returnUser;
    }
    
}
