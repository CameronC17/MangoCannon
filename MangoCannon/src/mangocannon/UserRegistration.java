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
public class UserRegistration {
    private User users[];
    
    User login(String username, String password){
        for (int i = 0; i < users.length; i++)
        {
            if (users[i].getUsername == username)
            {
                if (users[i].getPassword == password)
                {
                    return users[i];
                }
            }
        }
        //Sudo code for saying user hasnt been found...
        //return no user found!!
    }
    
}
