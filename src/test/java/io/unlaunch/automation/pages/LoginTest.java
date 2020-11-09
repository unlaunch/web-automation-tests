/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.unlaunch.automation.pages;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author ghauri
 */
public class LoginTest {

    // UMER: This is wrong. It should go after Registration. Currently, JUnit 5 can't put order on classes so all
    // tests will have to live in the same class.
    // Order: Registration -> Logout -> Login
    /**
     * Test of doLogin method, of class Login.
     */
    @Test
    public void testDoLogin() throws InterruptedException {
        Login loginPage = new Login();
        loginPage.doLogin();
        boolean loggedIn = loginPage.isLoggedIn();
        assertTrue(loggedIn);
    }
    
}
