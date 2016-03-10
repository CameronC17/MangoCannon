/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mangocannon;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jacobburns
 */
public class UserRegisterTest {
    
    public UserRegisterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addUser method, of class UserRegister.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        UserRegister instance = new UserRegister();
        User theUser = new User("Carlos", "Adams", "carlosa", 5312, 2, "carlos_adams");
        instance.addUser(theUser); 
    }

    /**
     * Test of findUserByIndex method, of class UserRegister.
     */
    @Test
    public void testFindUserByIndex() {
        System.out.println("findUserByIndex");
        int i = 0;
        UserRegister instance = new UserRegister();
        User expResult = new User("Carlos", "Adams", "carlosa", 5312, 2, "carlos_adams");
        instance.addUser(expResult); 
        User result = instance.findUserByIndex(i);
        assertEquals(expResult, result);
    }

    /**
     * Test of login method, of class UserRegister.

     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String username = "carlos_adams";
        String password = "carlosa";
        UserRegister instance = new UserRegister();
        User expResult = new User("Carlos", "Adams", "carlosa", 5312, 2, "carlos_adams");
        instance.addUser(expResult);
        User result = instance.login(username, password);
        assertEquals(expResult, result);
    }
    
}
