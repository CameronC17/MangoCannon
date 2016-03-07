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
    
    User findUserByIndex(int i) {
        return this.get(i);
    }
    
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
