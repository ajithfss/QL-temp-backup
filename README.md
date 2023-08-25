# Selenium Java Automation Framework For  Qlearning Project 

  

This repository contains an automation testing framework built using Selenium and Java. 

The framework is designed to facilitate the automated testing of web applications across different browsers and scenarios.  

It incorporates best practices for test organization, maintainability, and reporting. 

  

## Features 

  

- Cross-browser compatibility testing (Chrome, Firefox, etc.) 

- TestNG integration for efficient test management and parallel execution 

- Page Object Model (POM) design pattern for better test structure and reusability 

- Configuration setup for managing test environment details 

- Extensible structure to easily add new test cases and page objects 

- Reporting using Extent Reports. 

- Maven integration for dependency management and build automation 

  

## Prerequisites 

  

- Java Development Kit (JDK) [Download](https://www.oracle.com/java/technologies/javase-downloads.html) 

- Apache Maven [Download](https://maven.apache.org/download.cgi) 

- WebDriver binaries (e.g., ChromeDriver, GeckoDriver) compatible with your browser versions 

  - Place them in a location accessible by the system's PATH 

  

## Setup and Usage 

  

**Clone the Repository: ** 

   ` 

   git clone https://github.com/ajithfss/QL-temp-backup.git 

  

1.Navigate to the project directory. 

   cd your project directory 

  

2.Update the configuration. 

   Open src/main/java/com/qlearning/uat/config/config.properties and set the desired browser and other configurations. 

  

3.Run sample tests. 

  Open src/test/resources/testng.xml and run the test as testng suite. 

  

Project Structure: 

src/main/java: Contains the framework's core components, utilities, configuration classes, pages and    listeners and test data. 

src/test/resources: Includes separate xml files for each module. 

src/test/java: Houses the actual test scripts following the Page Object Model (POM) design pattern. 

  

Writing Test Scripts: 

Create a new test class in the src/test/java directory. 

Implement the Page Object Model (POM) pattern by creating page classes in the src/main/java/pages directory. 

Use the provided utilities to interact with web elements, such as ElementActions and WebDriverFactory. 

  

Reporting: 

Test execution results are automatically generated using the ExtentReports library. 

Reports are generated in the test-output directory after test execution. 

 

Continuous Integration (CI) Integration: 

This project can be integrated with your preferred CI tool (e.g., Jenkins, CircleCI). 

Set up the CI environment variables and ensure the required dependencies are installed. 
