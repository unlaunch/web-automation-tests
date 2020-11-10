/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.unlaunch.automation.pages;

import io.unlaunch.automation.Browser;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AllTests {

    private Registration registration = new Registration();
    private Authentication authentication = new Authentication();
    private FeatureFlags featureFlags = new FeatureFlags();

    @BeforeAll
    public static void init() {
        Browser.driver.manage().deleteAllCookies();
        Browser.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        Browser.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @Test
    @Order(1)
    public void testFillNewRegistrationForm() throws IOException{
        registration.deleteUserBeforeRegister();
        registration.register();
    }

    @Test
    @Order(2)
    public void testRegisterOtp() {
        registration.otp();
    }

    @Test
    @Order(3)
    public void testRegisterCompany() {
        registration.company();
    }

    @Test
    @Order(4)
    public void testRegisterProject() {
        registration.createFirstProject();
    }

    @Test
    @Order(5)
    public void testRegisterSkipMembers() {
        registration.skipMembers();
    }

    @Test
    @Order(6)
    public void testVerifySuccessfulLogin() {
        registration.verifySuccessfullLogin();
    }
    
    @Test
    @Order(7)
    public void testLogout() {
        authentication.logout();
    }
   
    @Test
    @Order(7)
    public void testVerifyLogout() {
        Assertions.assertTrue(authentication.verifyLogout() == true);  
    }
    
    @Test
    @Order(8)
    public void testLogin() {
        authentication.login(Browser.emailAddress, "Orca123");
    }

    @Test
    @Order(9)
    public void testIsLoggedIn() {
        authentication.isLoggedIn();
    }
    
    @Test
    @Order(10)
    public void testCreateFeatureFlag() {
        featureFlags.createFeatureFlag(2);
    }
    
    @Test
    @Order(11)
    public void testArchiveFlag() {
        featureFlags.archiveFlag();
    }
    
    

    @AfterAll
    public static void finish() {
        // Comment this if you want to leave the browser open
        Browser.quit();
    }

}
