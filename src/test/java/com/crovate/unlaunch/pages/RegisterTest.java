/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crovate.unlaunch.pages;

import com.crovate.unlaunch.Browser;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author ghauri
 */
public class RegisterTest {

    public RegisterTest() {
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
     * Test of doRegsiter method, of class Register.
     */
    @Test
    public void testDoRegsiter() throws IOException {
        Browser.driver.manage().window().maximize();
        Browser.driver.manage().deleteAllCookies();
        Browser.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        Browser.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        Register register = new Register();

        register.deleteUserBeforeRegister();

        register.doRegsiter();

        register.otp();

        register.company();
        
        register.createFirstProject();

        Browser.goTo("https://app.unlaunch.io");

    }

}
