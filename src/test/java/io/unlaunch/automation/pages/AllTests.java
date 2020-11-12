/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.unlaunch.automation.pages;

import io.unlaunch.automation.Browser;
import io.unlaunch.automation.pages.featuerflag.Targeting;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AllTests {

    private Registration registration = new Registration();
    private Authentication authentication = new Authentication();
    private FeatureFlags featureFlags = new FeatureFlags();
    private Targeting targeting = new Targeting();
    private Attributes attributes = new Attributes();

    @BeforeAll
    public static void init() {
        Browser.driver.manage().window().maximize();
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
        featureFlags.createFeatureFlag("test-archive-flag","test-archive-flag", 2);
    }
    
    @Test
    @Order(11)
    public void testArchiveFlag() {
        featureFlags.archiveFlag();
    }
    
    @Test
    @Order(12)
    public void testCreateFlagWith3Variations() {
        featureFlags.createFeatureFlag("test-flag", "test-flag", 3);
    }
    
    @Test
    @Order(13)
    public void testAddWhiteList() {
        targeting.addWhitelist();
    }
    
    @Test
    @Order(14)
    public void testclearWhiteList() {
        targeting.removeWhiteList();
    }
    
    @Test
    @Order(15)
    public void testAdd50UsersToOnVariation() {
        targeting.addWhitelistToOn();
    }
    
    @Test
    @Order(16)
    public void testAdd25UsersToOffVariation() {
        targeting.addWhitelistToOff();
    }
    
    @Test
    @Order(17)
    public void testDefaultRulePercentageRollout() {
        targeting.setDefaultRulePercentageRollout("33", "33", "34");
    }
    
    @Test
    @Order(18)
    public void testDefaultRulePercentageRolloutAgain() {
        targeting.setDefaultRulePercentageRollout("98", "1", "1");
    }
   
    @Test
    @Order(19)
    public void testDefaultRuleToGrayVariation() {
        targeting.setDefaultRule("gray");
    }
   
    @Test
    @Order(20)
    public void testDefaultRuleToOnVariation() {
        targeting.setDefaultRule("on");
    }
    
    @Test
    @Order(21)
    public void testDefaultRuleToOffVariation() {
        targeting.setDefaultRule("off");
    }
    
    @Test
    @Order(22)
    public void testDefaultVariationToOnVar() {
        targeting.setDefaultRule("on");
    }
    
    
    @Test
    @Order(23)
    public void testDefaultVariationToOffVar() {
        targeting.setDefaultRule("off");
    }
    
    
    @Test
    @Order(24)
    public void testDefaultVariationToGrayVar() {
        targeting.setDefaultRule("gray");
    }
    
    @Test
    @Order(25)
    public void testCreateNumberAttribute() {
        attributes.createAttribute("ltv", "Number");
    }
    
    @Test
    @Order(26)
    public void testCreateStringAttribute() {
        attributes.createAttribute("device", "String");
    }
    
    @Test
    @Order(27)
    public void testCreateBooleanAttribute() {
        attributes.createAttribute("paid", "Boolean");
    }
    
    

    @AfterAll
    public static void finish() {
        // Comment this if you want to leave the browser open
        Browser.quit();
    }

}
