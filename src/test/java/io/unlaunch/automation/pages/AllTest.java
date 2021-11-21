/*
 * To change this license header, choose License Headers Settings Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template Settings the editor.
 */
package io.unlaunch.automation.pages;

import io.unlaunch.automation.Browser;
import io.unlaunch.automation.pages.featureflags.Configuration;
import io.unlaunch.automation.pages.featureflags.Targeting;
import io.unlaunch.automation.pages.featureflags.Variation;
import io.unlaunch.automation.pages.settings.Members;
import io.unlaunch.automation.pages.settings.Projects;
import io.unlaunch.automation.sdk.EvaluateFeatureFlag;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AllTest {

    private Registration registration = new Registration();
    private Authentication authentication = new Authentication();
    private FeatureFlags featureFlags = new FeatureFlags();
    private Tutorial tutorial = new Tutorial();
    private Targeting targeting = new Targeting();
    private Attributes attributes = new Attributes();
    private Variation variation = new Variation();
    private Configuration configuration = new Configuration();
    private io.unlaunch.automation.pages.featureflags.Settings settings = new io.unlaunch.automation.pages.featureflags.Settings();
    private Members users = new Members();
    private Sidebar sidebar = new Sidebar();
    private Projects projects = new Projects();
    private EvaluateFeatureFlag eval = new EvaluateFeatureFlag();
    private static String sdkKey;

    @BeforeAll
    public static void init() {
        Browser.driver.manage().deleteAllCookies();
        Browser.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        Browser.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @BeforeEach
    public void sleepBeforeEachTest() {
        Browser.sleep(1);
    }

    @Test
    @Order(10)
    public void testFillNewRegistrationForm() throws IOException{
        registration.deleteUserBeforeRegister();
        registration.register();
    }

    @Test
    @Order(20)
    public void testRegisterOtp() {
        registration.otp();
    }

    @Test
    @Order(30)
    public void testRegisterCompany() {
        registration.company();
    }

    @Test
    @Order(40)
    public void testRegisterProject() {
        registration.createFirstProject();
    }

    @Test
    @Order(50)
    public void testRegisterSkipMembers() {
        registration.skipMembers();
    }

    @Test
    @Order(60)
    public void tutorialSuccess() {
        tutorial.apiEventReceived();
    }

    /*
    @Test
    @Order(70)
    public void testVerifySuccessfulLogin() {
        registration.verifySuccessfulLogin();
    }
     */

    @Test
    @Order(80)
    public void testLogout() {
        authentication.logout();
    }

    @Test
    @Order(90)
    public void testVerifyLogout() {
        Assertions.assertTrue(authentication.verifyLogout() == true);
    }

    @Test
    @Order(100)
    public void testLogin() {
        authentication.login(Browser.emailAddress, "Orca123");
    }

    @Test
    @Order(110)
    public void testIsLoggedIn() {
        registration.verifySuccessfulLogin();
    }

    @Test
    @Order(120)
    public void testCreateFeatureFlag() {
        featureFlags.createFeatureFlag("test-archive-flag","test-archive-flag", 2);
    }

    @Test
    @Order(130)
    public void testSDKReturnedDefaultVariation() {
        sdkKey = EvaluateFeatureFlag.getSdkKey();

        Assertions.assertTrue( sdkKey != null && !sdkKey.isEmpty(), "SDK key cannot be null");

        EvaluateFeatureFlag.initializeClient(sdkKey);
        
        String var = eval.evalInactiveFlagReturnsDefaultVariation();
        
        WebElement e = Browser.fluentWait((WebDriver d) -> d.findElement(By.className("__at_link_feature_list")));
        Browser.click(e);
        
        Browser.sleep(2);
        WebElement flagLink = Browser.driver.findElement(By.linkText("test-archive-flag"));
        Browser.fluentWait((WebDriver t) -> flagLink);
        flagLink.click();
        
        Browser.sleep(2);
        WebElement defaultVar = Browser.driver.findElement(By.className("__at_select_offvariation"));
        Browser.fluentWait((WebDriver t) -> defaultVar);
        String varText = defaultVar.getText();
        
        Assertions.assertEquals(varText, var);
        
    }

    @Test
    @Order(140)
    public void testArchiveFlag() {
        featureFlags.archiveFlag();
    }

    @Test
    @Order(150)
    public void testSDKReturnedControlVariation() {
        Assertions.assertTrue( sdkKey != null && !sdkKey.isEmpty(), "SDK key cannot be null: " + sdkKey);

        EvaluateFeatureFlag.initializeClient(sdkKey);
        
        String var = eval.evalFlagReturnsControlVariation();
        Assertions.assertEquals("control", var);
    }

    @Test
    @Order(160)
    public void testdeleteFlag() {
        featureFlags.deleteFlag();
    }

    @Test
    @Order(170)
    public void testSDKAfterDeleteFlagReturnedControlVariation() {
        EvaluateFeatureFlag.initializeClient(sdkKey);
        
        String var = eval.evalFlagReturnsControlVariation();
        Assertions.assertEquals("control", var);
    }

    @Test
    @Order(180)
    public void testCreateFlagWith3Variations() {
        featureFlags.createFeatureFlag("test-flag", "test-flag", 3);
    }

    @Test
    @Order(190)
    public void testAddWhiteList() {
        targeting.addWhitelist();
    }

    @Test
    @Order(200)
    public void testClearWhiteList() {
        targeting.removeWhiteList();
    }

    @Test
    @Order(210)
    public void testAdd50UsersToOnVariation() {
        targeting.addWhitelistToOn();
    }

    @Test
    @Order(220)
    public void testSDKWhiteListForOnVariation() {
        EvaluateFeatureFlag.initializeClient(sdkKey);
        
        String var = eval.evalWhiteListForOnVariation();
        Assertions.assertEquals("on", var);
    }

    @Test
    @Order(230)
    public void testAdd25UsersToOffVariation() {
        targeting.addWhitelistToOff();
    }

    @Test
    @Order(240)
    public void testSDKWhiteListForOffVariation() {
        EvaluateFeatureFlag.initializeClient(sdkKey);
        
        String var = eval.evalWhiteListForOffVariation();
        Assertions.assertEquals("off", var);
    }

    @Test
    @Order(250)
    public void testSDKUsingRandomUserIdReturnedDefaultRule() {
        EvaluateFeatureFlag.initializeClient(sdkKey);
        
        String var = eval.evalWhiteListWithRandomUser();
        
        WebElement defaultRule = Browser.driver.findElement(By.className("__at_select_default"));
        Browser.fluentWait((WebDriver t) -> defaultRule);
        String value = defaultRule.getText();
        
        Assertions.assertEquals(value, var);
    }

    @Test
    @Order(260)
    public void testDefaultRulePercentageRollout() {
        targeting.setDefaultRulePercentageRollout("33", "33", "34");
    }

    @Test
    @Order(270)
    public void testSDKEvalFlagUsingDefaultPR() {
        EvaluateFeatureFlag.initializeClient(sdkKey);
        
        boolean var = eval.evalDefaultRulePercentageRollout();
        Assertions.assertTrue(var);
    }

    @Test
    @Order(280)
    public void testDefaultRulePercentageRolloutAgain() {
        targeting.setDefaultRulePercentageRollout("98", "1", "1");
    }

    @Test
    @Order(290)
    public void testDefaultRuleToGrayVariation() {
        targeting.setDefaultRule("gray");
    }

    @Test
    @Order(300)
    public void testDefaultRuleToOnVariation() {
        targeting.setDefaultRule("on");
    }

    @Test
    @Order(310)
    public void testDefaultRuleToOffVariation() {
        targeting.setDefaultRule("off");
    }

    @Test
    @Order(320)
    public void testDefaultVariationToOnVar() {
        targeting.setDefaultVariation("on");
    }

    
    @Test
    @Order(330)
    public void testDefaultVariationToOffVar() {
        targeting.setDefaultVariation("off");
    }

    
    @Test
    @Order(340)
    public void testDefaultVariationToGrayVar() {
        targeting.setDefaultVariation("gray");
    }

    @Test
    @Order(350)
    public void testCreateNumberAttribute() {
        attributes.createAttribute("ltv", "Number");
    }

    @Test
    @Order(360)
    public void testCreateStringAttribute() {
        attributes.createAttribute("device", "String");
    }

    @Test
    @Order(370)
    public void testCreateBooleanAttribute() {
        attributes.createAttribute("paid", "Boolean");
    }

    @Test
    @Order(380)
    public void testAddTargettingRuleForString() {

        WebElement e = Browser.fluentWait((WebDriver d) -> d.findElement(By.className("__at_link_feature_list")));
        Browser.click(e);

        e = Browser.fluentWait((WebDriver d) -> d.findElement(By.linkText("test-flag")));
        Browser.click(e);

        targeting.addTargettingRule("device", "String", "ABCS", 1);
    }

    @Test
    @Order(390)
    public void testSDKEvalFlagTarettingRuleForString() {
        EvaluateFeatureFlag.initializeClient(sdkKey);
        String var = eval.evalTargetingRuleForString();
        Assertions.assertEquals("on", var);
    }
    
    @Test
    @Order(400)
    public void testAddPercentageRolloutTargettingRuleForString() {

        WebElement e = Browser.fluentWait((WebDriver d) -> d.findElement(By.className("__at_link_feature_list")));
        Browser.click(e);

        e = Browser.fluentWait((WebDriver d) -> d.findElement(By.linkText("test-flag")));
        Browser.click(e);

        targeting.setTargetingRulePercentageRollout("30", "30", "40");
    }

    @Test
    @Order(410)
    public void testAddTargettingRuleForInt() {
        WebElement e = Browser.fluentWait((WebDriver d) -> d.findElement(By.className("__at_link_feature_list")));
        Browser.click(e);

        e = Browser.fluentWait((WebDriver d) -> d.findElement(By.linkText("test-flag")));
        Browser.click(e);
        
        targeting.addTargettingRule("ltv", "Number", "123", 2);
    }

    @Test
    @Order(420)
    public void testSDKEvalFlagTarettingRuleForInt() {
        EvaluateFeatureFlag.initializeClient(sdkKey);
        String var = eval.evalTargetingRuleForInteger();
        Assertions.assertEquals("on", var);
    }

    @Test
    @Order(430)
    public void testAddTargettingRuleForBoolean() {
        WebElement e = Browser.fluentWait((WebDriver d) -> d.findElement(By.className("__at_link_feature_list")));
        Browser.click(e);

        e = Browser.fluentWait((WebDriver d) -> d.findElement(By.linkText("test-flag")));
        Browser.click(e);
        
        targeting.addTargettingRule("paid", "Boolean", "true", 3);
    }

    @Test
    @Order(440)
    public void testSDKEvalFlagTarettingRuleForBoolean() {
        EvaluateFeatureFlag.initializeClient(sdkKey);
        String var = eval.evalTargetingRuleForBoolean();
        Assertions.assertEquals("on", var);
    }

    @Test
    @Order(450)
    public void testDelTargettingRuleForInt() {
        WebElement e = Browser.fluentWait((WebDriver d) -> d.findElement(By.className("__at_link_feature_list")));
        Browser.click(e);

        e = Browser.fluentWait((WebDriver d) -> d.findElement(By.linkText("test-flag")));
        Browser.click(e);
        
        targeting.delTargettingRule(2);
    }

    @Test
    @Order(460)
    public void testCreateFeatureFlagForVariationPage() {
        featureFlags.createFeatureFlag("test-flag-2-var", "test-flag-2-var", 2);
    }

    @Test
    @Order(470)
    public void testAddVariation() {
        variation.addVariation();
    }

    @Test
    @Order(480)
    public void testCreateFeatureFlagForConf() {
        featureFlags.createFeatureFlag("test-flag-3-conf", "test-flag-3-conf", 3);
    }

    @Test
    @Order(490)
    public void testAddVariantConfigurations() {
        configuration.addConfiguration();
    }

    @Test
    @Order(500)
    public void testSDKEvalVariantConfigs() {
        Assertions.assertTrue( sdkKey != null && !sdkKey.isEmpty(), "SDK key cannot be null: " + sdkKey);

        EvaluateFeatureFlag.initializeClient(sdkKey);

        Map<String, String> map = eval.evalVariantConfigurations();

        Assertions.assertTrue(map != null && map.size() > 0);

        String val = map.get("a110");
        Assertions.assertEquals("898", val);
    }

    @Test
    @Order(510)
    public void testCreateFeatureFlagForSettings() {
        featureFlags.createFeatureFlag("test-flag-4-settings", "test-flag-4-settings", 4);
    }

    @Test
    @Order(520)
    public void testChangeFlagName() {
        settings.changeFlagName();
    }

    @Test
    @Order(530)
    public void testChangeFlagDescription() {
        settings.changeFlagDescription();
    }

    @Test
    @Order(540)
    public void testSetFlagToClientSide() {
        settings.setFlagToClientSide();
    }

    @Test
    @Order(550)
    public void testAddMember() {
        users.addMember();
    }

    @Test
    @Order(560)
    public void testChangeEnv() {
        sidebar.changeEnviroment();
    }

    @Test
    @Order(570)
    public void testCreateProject() {
        projects.createProject("Selenium Automation Testing");
    }

    @Test
    @Order(580)
    public void testCreateProject2() {
        projects.createProject("Selenium Testing");
    }

    @Test
    @Order(590)
    public void testDeleteProject() {
        projects.deleteProject();
    }

    @AfterAll
    public static void finish() {
        // Comment this if you want to leave the browser open
        Browser.driver.quit();
        EvaluateFeatureFlag.close();
    }
}
