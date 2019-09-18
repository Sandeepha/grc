$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/UX014784/eclipse-workspace/GRC/src/test/resources/features/GRC_Smoke.feature");
formatter.feature({
  "line": 1,
  "name": "Smoke Testing",
  "description": "",
  "id": "smoke-testing",
  "keyword": "Feature"
});
formatter.before({
  "duration": 53520046,
  "error_message": "java.lang.ExceptionInInitializerError\r\n\tat com.sc.stepdefination.CucumberSetup.setUp(CucumberSetup.java:35)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:40)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:34)\r\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:60)\r\n\tat cucumber.runtime.Runtime.runHookIfTagsMatch(Runtime.java:224)\r\n\tat cucumber.runtime.Runtime.runHooks(Runtime.java:212)\r\n\tat cucumber.runtime.Runtime.runBeforeHooks(Runtime.java:202)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:40)\r\n\tat cucumber.runtime.model.CucumberFeature.run(CucumberFeature.java:165)\r\n\tat cucumber.api.testng.TestNGCucumberRunner.runCucumber(TestNGCucumberRunner.java:63)\r\n\tat com.sc.testrunner.TestNGRunnerNew.feature(TestNGRunnerNew.java:45)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:108)\r\n\tat org.testng.internal.Invoker.invokeMethod(Invoker.java:661)\r\n\tat org.testng.internal.Invoker.invokeTestMethod(Invoker.java:869)\r\n\tat org.testng.internal.Invoker.invokeTestMethods(Invoker.java:1193)\r\n\tat org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:126)\r\n\tat org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:109)\r\n\tat org.testng.TestRunner.privateRun(TestRunner.java:744)\r\n\tat org.testng.TestRunner.run(TestRunner.java:602)\r\n\tat org.testng.SuiteRunner.runTest(SuiteRunner.java:380)\r\n\tat org.testng.SuiteRunner.runSequentially(SuiteRunner.java:375)\r\n\tat org.testng.SuiteRunner.privateRun(SuiteRunner.java:340)\r\n\tat org.testng.SuiteRunner.run(SuiteRunner.java:289)\r\n\tat org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52)\r\n\tat org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:86)\r\n\tat org.testng.TestNG.runSuitesSequentially(TestNG.java:1301)\r\n\tat org.testng.TestNG.runSuitesLocally(TestNG.java:1226)\r\n\tat org.testng.TestNG.runSuites(TestNG.java:1144)\r\n\tat org.testng.TestNG.run(TestNG.java:1115)\r\n\tat org.testng.remote.AbstractRemoteTestNG.run(AbstractRemoteTestNG.java:115)\r\n\tat org.testng.remote.RemoteTestNG.initAndRun(RemoteTestNG.java:251)\r\n\tat org.testng.remote.RemoteTestNG.main(RemoteTestNG.java:77)\r\nCaused by: java.util.NoSuchElementException: \u0027global.driver.wait\u0027 doesn\u0027t map to an existing object\r\n\tat org.apache.commons.configuration.AbstractConfiguration.getInt(AbstractConfiguration.java:816)\r\n\tat com.framework.config.PropertiesRepository.getInt(PropertiesRepository.java:66)\r\n\tat com.framework.config.GlobalProperties.\u003cclinit\u003e(GlobalProperties.java:25)\r\n\t... 41 more\r\n",
  "status": "failed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "I have application URL",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I login with valid credentials",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "I should be able to see home page",
  "keyword": "Then "
});
formatter.match({
  "location": "BaseStepDefination.iHaveValidApplicationUR()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "BaseStepDefination.iLoginwithvalidcredentials()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "BaseStepDefination.iShouldbeabletoseethehomepage()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 67,
  "name": "Create order form",
  "description": "",
  "id": "smoke-testing;create-order-form",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 66,
      "name": "@Accounts"
    }
  ]
});
formatter.step({
  "line": 68,
  "name": "I login as a GRC users",
  "keyword": "Given "
});
formatter.step({
  "line": 69,
  "name": "I will click on Accounts tab",
  "keyword": "When "
});
formatter.step({
  "line": 70,
  "name": "I will search for the existing account from the list",
  "keyword": "And "
});
formatter.step({
  "line": 71,
  "name": "I go to the opportunites related list",
  "keyword": "And "
});
formatter.step({
  "line": 72,
  "name": "I click on the new sale opportunity",
  "keyword": "And "
});
formatter.step({
  "line": 73,
  "name": "I create a new opportunity with all the mandatory details",
  "keyword": "And "
});
formatter.step({
  "line": 74,
  "name": "I will create GRC pricebook",
  "keyword": "And "
});
formatter.step({
  "line": 75,
  "name": "I will add the products",
  "keyword": "And "
});
formatter.step({
  "line": 76,
  "name": "I will add Primary contact in contact roles Opty page",
  "keyword": "And "
});
formatter.step({
  "line": 77,
  "name": "I will go to quotes realted tab in oty page",
  "keyword": "And "
});
formatter.step({
  "line": 78,
  "name": "I will create new quote",
  "keyword": "And "
});
formatter.step({
  "line": 79,
  "name": "I will submit the quote for Approval",
  "keyword": "And "
});
formatter.step({
  "line": 80,
  "name": "I will get the GAM user and login",
  "keyword": "And "
});
formatter.step({
  "line": 81,
  "name": "I will approve the Quote",
  "keyword": "Then "
});
formatter.step({
  "line": 82,
  "name": "I login as a GRC user",
  "keyword": "And "
});
formatter.step({
  "line": 83,
  "name": "I will approve as CA user",
  "keyword": "And "
});
formatter.match({
  "location": "BaseStepDefination.iLoginasaprofileuser()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "BaseStepDefination.iWillclickonAccountstab()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "AccountStepDefination.iWillsearchfortheexistingaccountfromlist()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "AccountStepDefination.iGotoopportunitestab()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "AccountStepDefination.iClickonnewsaleopportunity()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "OpportunitiesStepDefination.iCreateanewopty()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "OpportunitiesStepDefination.iWillCreatenewGRCPricebook()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "OpportunitiesStepDefination.addProducts()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "OpportunitiesStepDefination.iWillAddPrimarycontactinContactRoles()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "OpportunitiesStepDefination.iWillGotoQuotesrelatedtab()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "QuotePageStepDefination.iWillcreateanewQuote()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "QuotePageStepDefination.submitQuoteForApproval()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "QuotePageStepDefination.loginAsGamApprover()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ChatterStepDefination.clickAcceptBtnInChatterPage()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "BaseStepDefination.iLoginasaprofileuser1()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "QuotePageStepDefination.approveCA()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 4681017,
  "error_message": "java.lang.NullPointerException\r\n\tat com.sc.stepdefination.CucumberSetup.takeScreenShots(CucumberSetup.java:68)\r\n\tat com.sc.stepdefination.CucumberSetup.tearDown(CucumberSetup.java:45)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:40)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:34)\r\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:60)\r\n\tat cucumber.runtime.Runtime.runHookIfTagsMatch(Runtime.java:224)\r\n\tat cucumber.runtime.Runtime.runHooks(Runtime.java:212)\r\n\tat cucumber.runtime.Runtime.runAfterHooks(Runtime.java:206)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:46)\r\n\tat cucumber.runtime.model.CucumberFeature.run(CucumberFeature.java:165)\r\n\tat cucumber.api.testng.TestNGCucumberRunner.runCucumber(TestNGCucumberRunner.java:63)\r\n\tat com.sc.testrunner.TestNGRunnerNew.feature(TestNGRunnerNew.java:45)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:108)\r\n\tat org.testng.internal.Invoker.invokeMethod(Invoker.java:661)\r\n\tat org.testng.internal.Invoker.invokeTestMethod(Invoker.java:869)\r\n\tat org.testng.internal.Invoker.invokeTestMethods(Invoker.java:1193)\r\n\tat org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:126)\r\n\tat org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:109)\r\n\tat org.testng.TestRunner.privateRun(TestRunner.java:744)\r\n\tat org.testng.TestRunner.run(TestRunner.java:602)\r\n\tat org.testng.SuiteRunner.runTest(SuiteRunner.java:380)\r\n\tat org.testng.SuiteRunner.runSequentially(SuiteRunner.java:375)\r\n\tat org.testng.SuiteRunner.privateRun(SuiteRunner.java:340)\r\n\tat org.testng.SuiteRunner.run(SuiteRunner.java:289)\r\n\tat org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52)\r\n\tat org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:86)\r\n\tat org.testng.TestNG.runSuitesSequentially(TestNG.java:1301)\r\n\tat org.testng.TestNG.runSuitesLocally(TestNG.java:1226)\r\n\tat org.testng.TestNG.runSuites(TestNG.java:1144)\r\n\tat org.testng.TestNG.run(TestNG.java:1115)\r\n\tat org.testng.remote.AbstractRemoteTestNG.run(AbstractRemoteTestNG.java:115)\r\n\tat org.testng.remote.RemoteTestNG.initAndRun(RemoteTestNG.java:251)\r\n\tat org.testng.remote.RemoteTestNG.main(RemoteTestNG.java:77)\r\n",
  "status": "failed"
});
});