# Automation tests with TestNG

This repository contains TestNG examples to automate the Selenium Webdriver binaries management using WebDriverManager and is built by Maven. These examples are open source, released under the terms of Apache 2.0 License.


There are two automate tests:

Test #1. Open Google. Search for “automation”. Open the first link on search results page. Verify that title contains searched word

Test #2. Open Google. Search for “automation”. Verify that there is expected domain (“testautomationday.com”) on search results  pages (page: 1-5).


# Usage

#1 All necessary parameters for tests are in the config.json

{
  "baseURL": "https://google.com",
  "domain": "testautomationday.com",
  "browser": "chrome",
  "detectedText": "automation"
}

#2 Settings for tests are in the testing.xml

<suite name="Test-class Suite" parallel="classes" thread-count="1" >
<test name="Test-class test" >
    <classes>
        <class name="testCases.FirstTest" />
        <class name="testCases.SecondTest" />
    </classes>
</test>
</suite>

#3 Build and run tests

in the command line go to the folder with project and call maven comand 

mvn clean test

#4 To provide good representation of test execution output using Allure. After succesfull test call maven command in the command line

mvn allure:serve

# About

testProjectEp (Copyright © 2019) is a personal project of Andrey Dorokhin licensed under Apache 2.0 License. Comments, questions and suggestions are always very welcome!
