//TestListener.java

package com.demo.listener;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.demo.utility.JiraCreateIssue;
import com.demo.utility.JiraServiceProvider;


public class TestListener implements ITestListener {

    @Override

    public void onTestStart(ITestResult result) {

        // TODO Auto-generated method stub


    }


    @Override

    public void onTestSuccess(ITestResult result) {

        // TODO Auto-generated method stub


    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed");
        JiraCreateIssue jiraCreateIssue = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(JiraCreateIssue.class);
        boolean isLogIssue = jiraCreateIssue.isCreateIssue();
        System.out.println(isLogIssue);
        if (isLogIssue) {
            System.out.println("is ticket ready for jira: " + isLogIssue);
            JiraServiceProvider jiraSp = new JiraServiceProvider("https://zenbyzenith.atlassian.net",
                    "abiodun_oyawale@zenbyzenith.com", "QREPPGNbKWT3QrKAr3Ra3419","ZENZ");
            String issueDescription = "Failure Reason from automation Testing\n\n" +result.getThrowable().getMessage()

                + "\n";

//        issueDescription.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));
        issueDescription.concat(ExceptionUtils.getMessage(result.getThrowable()));

        String issueSummary = result.getMethod().getConstructorOrMethod().getMethod().getName()

 + " Failed in Automation Testing";

    jiraSp.createJiraIssue("Bug", issueSummary, issueDescription, "Automated Testing");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
    }



    @Override

    public void onFinish(ITestContext context) {

        // TODO Auto-generated method stub


    }




}
