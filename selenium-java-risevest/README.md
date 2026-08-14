# Risevest Web Automation

Selenium WebDriver automation project built with **Java**, **TestNG** and **Maven** for functional web application testing.

## Overview

This project demonstrates a structured approach to UI test automation, including reusable test setup, functional test cases, TestNG suite execution and automated reporting.

## Tech Stack

- Java
- Selenium WebDriver 4.23.0
- TestNG 7.7.1
- Maven
- WebDriverManager
- ReportNG
- Apache POI
- Log4j

## Test Coverage

The suite contains **9 automated test cases** covering login, wallet and plan-related workflows.

## Project Structure

```text
selenium-java-risevest/
├── src/
│   └── test/
│       ├── java/
│       │   ├── BaseTest/
│       │   ├── TestCases/
│       │   └── Utilities/
│       └── resources/
│           ├── Configfiles/
│           └── TestRunner/
│               └── testng.xml
├── pom.xml
└── README.md
```

## How to Run

### Prerequisites

- JDK installed and configured
- Maven installed
- Git

### Run the suite

```bash
mvn test
```

For the valid-login scenario, provide credentials through environment variables rather than storing them in source code:

```bash
TEST_EMAIL=your-test-email TEST_PASSWORD=your-test-password mvn test
```

The TestNG suite is located at `src/test/resources/TestRunner/testng.xml`.

## Automation Practices Demonstrated

- Selenium WebDriver UI automation
- TestNG test organization and suite execution
- Reusable test setup
- Externalized locators and configuration
- Maven dependency management
- WebDriverManager for browser drivers
- Soft assertions for negative scenarios
- Automated test reporting
- Secure handling of test credentials through environment variables

## Notes

Generated build output, test reports and IDE-specific files are intentionally excluded from the portfolio source. See the repository `.gitignore` for the exclusions.
