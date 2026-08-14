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

The suite contains **9 automated test cases** covering key web application workflows.

## Project Structure

```text
Risevest_Auto/
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

### Run the tests

From the project root, run:

```bash
mvn test
```

The TestNG suite can also be executed using the `testng.xml` file under `src/test/resources/TestRunner`.

## Test Execution & Reporting

The project is configured for TestNG execution and includes test-output generated from previous test runs. The suite is designed to execute the automated test cases together through the TestNG runner.

## Automation Practices Demonstrated

- Selenium WebDriver UI automation
- TestNG test organization and suite execution
- Reusable test setup
- Externalized test resources
- Maven dependency management
- WebDriverManager for browser driver setup
- Automated test reporting
- Logging with Log4j

## Notes

Build output and IDE-specific files should not be committed to the repository. The repository includes a root `.gitignore` to prevent these files from being added in future commits.
