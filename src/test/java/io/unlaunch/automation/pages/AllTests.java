/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.unlaunch.automation.pages;

import io.unlaunch.automation.Browser;
import io.unlaunch.automation.pages.featuerflag.Configuration;
import io.unlaunch.automation.pages.featuerflag.Targeting;
import io.unlaunch.automation.pages.featuerflag.Variation;
import io.unlaunch.automation.pages.featuerflag.Settings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AllTests {

    private Registration registration = new Registration();
    private Authentication authentication = new Authentication();
    private FeatureFlags featureFlags = new FeatureFlags();
    private Targeting targeting = new Targeting();
    private Attributes attributes = new Attributes();
    private Variation variation = new Variation();
    private Configuration configuration = new Configuration();
    private Settings settings = new Settings();

    @BeforeAll
    public static void init() {
//        Browser.driver.manage().window().maximize();
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
    @Order(8)
    public void testVerifyLogout() {
        Assertions.assertTrue(authentication.verifyLogout() == true);  
    }
    
    @Test
    @Order(9)
    public void testLogin() {
        authentication.login(Browser.emailAddress, "Orca123");
    }

    @Test
    @Order(10)
    public void testIsLoggedIn() {
        registration.verifySuccessfullLogin();
    }
    
    @Test
    @Order(11)
    public void testCreateFeatureFlag() {
        featureFlags.createFeatureFlag("test-archive-flag","test-archive-flag", 2);
    }
    
    @Test
    @Order(12)
    public void testArchiveFlag() {
        featureFlags.archiveFlag();
    }
    
    @Test
    @Order(13)
    public void testCreateFlagWith3Variations() {
        featureFlags.createFeatureFlag("test-flag", "test-flag", 3);
    }
    
    @Test
    @Order(14)
    public void testAddWhiteList() {
        targeting.addWhitelist();
    }
    
    @Test
    @Order(15)
    public void testclearWhiteList() {
        targeting.removeWhiteList();
    }
    
    @Test
    @Order(16)
    public void testAdd50UsersToOnVariation() {
        targeting.addWhitelistToOn();
    }
    
    @Test
    @Order(17)
    public void testAdd25UsersToOffVariation() {
        targeting.addWhitelistToOff();
    }
    
    @Test
    @Order(18)
    public void testDefaultRulePercentageRollout() {
        targeting.setDefaultRulePercentageRollout("33", "33", "34");
    }
    
    @Test
    @Order(19)
    public void testDefaultRulePercentageRolloutAgain() {
        targeting.setDefaultRulePercentageRollout("98", "1", "1");
    }
   
    @Test
    @Order(20)
    public void testDefaultRuleToGrayVariation() {
        targeting.setDefaultRule("gray");
    }
   
    @Test
    @Order(21)
    public void testDefaultRuleToOnVariation() {
        targeting.setDefaultRule("on");
    }
    
    @Test
    @Order(22)
    public void testDefaultRuleToOffVariation() {
        targeting.setDefaultRule("off");
    }
    
    @Test
    @Order(23)
    public void testDefaultVariationToOnVar() {
        targeting.setDefaultVariation("on");
    }
    
    
    @Test
    @Order(24)
    public void testDefaultVariationToOffVar() {
        targeting.setDefaultVariation("off");
    }
    
    
    @Test
    @Order(25)
    public void testDefaultVariationToGrayVar() {
        targeting.setDefaultVariation("gray");
    }
    
    @Test
    @Order(26)
    public void testCreateNumberAttribute() {
        attributes.createAttribute("ltv", "Number");
    }
    
    @Test
    @Order(27)
    public void testCreateStringAttribute() {
        attributes.createAttribute("device", "String");
    }
    
    @Test
    @Order(28)
    public void testCreateBooleanAttribute() {
        attributes.createAttribute("paid", "Boolean");
    }
    
    @Test
    @Order(29)
    public void testAddTargettingRuleForString() {
        Browser.sleep(2);
        Browser.driver.findElement(By.linkText("Feature Flags")).click();

        Browser.sleep(3);
        Browser.driver.findElement(By.linkText("test-flag")).click();

        targeting.addTargettingRule("device","String","ABCS",1);
    }
    
    @Test
    @Order(30)
    public void testAddTargettingRuleForInt() {
        targeting.addTargettingRule("ltv","Number","123",2);
    }
    
    @Test
    @Order(31)
    public void testAddTargettingRuleForBoolean() {
        targeting.addTargettingRule("paid","Boolean","true",3);
    }
     
    @Test
    @Order(32)
    public void testDelTargettingRuleForInt() {
        targeting.delTargettingRule(2);
    }
    
    @Test
    @Order(33)
    public void testCreateFeatureFlagForVariationPage() {
        featureFlags.createFeatureFlag("test-flag-2-var", "test-flag-2-var", 2);
    }

    @Test
    @Order(34)
    public void testAddVariation() {
        variation.addVariation();
    }
    
    @Test
    @Order(35)
    public void testCreateFeatureFlagForConf() {
        featureFlags.createFeatureFlag("test-flag-3-conf", "test-flag-3-conf", 3);
    }
    
    @Test
    @Order(36)
    public void testAddVariantConfigurations() {
        configuration.addConfiguration();
    }
    
    @Test
    @Order(37)
    public void testCreateFeatureFlagForSettings() {
        featureFlags.createFeatureFlag("test-flag-4-settings", "test-flag-4-settings", 4);
    }
    
    @Test
    @Order(38)
    public void testChangeFlagName() {
        settings.changeFlagName();
    }
    
    @Test
    @Order(39)
    public void testChangeFlagDescription() {
        settings.changeFlagDescription();
    }
    
    @Test
    @Order(40)
    public void testSetFlagToClientSide() {
        settings.setFlagToClientSide();
    }
    
    @AfterAll
    public static void finish() {
        // Comment this if you want to leave the browser open
        Browser.quit();
    }

}
