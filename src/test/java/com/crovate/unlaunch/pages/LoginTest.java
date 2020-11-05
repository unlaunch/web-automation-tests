/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crovate.unlaunch.pages;

import com.crovate.unlaunch.Browser;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;



/**
 *
 * @author ghauri
 */
public class LoginTest {
    
    public LoginTest() {
    }

    // This method will remove when other testcases are introduced.
    @AfterClass
    public static void close() {
        Browser.close();
    }
    /**
     * Test of doLogin method, of class Login.
     */
    @Test
    public void testDoLogin() throws InterruptedException {
        Login loginPage = new Login();
        loginPage.doLogin();
        boolean loggedIn = loginPage.isLoggedIn();
        Assert.assertTrue(loggedIn);
    }
    
}
