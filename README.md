# 🛠️ Automation Framework 🛠️

Welcome to the **Amazon Automation Framework**! This project is built using a structured **Page Object Model (POM)** to automate the **Amazon** website. The framework covers essential flows including **Login**, **Dashboard Navigation**, **Product Details**, **Shopping Cart**, and **Order Review**.

---

## 📂 Project Structure

The framework is organized using the **Page Object Model (POM)** pattern for clarity and scalability. Here's the breakdown:

- **src**
  - **main**
    - **java**
  - **test**
    - **java**
      - **BaseTest**
        - `Base_Test.java` - Base setup and teardown methods
      - **CommonUtilities**
        - `ExcelUtility.java` - Utility for handling Excel files
        - `Extent_Reports.java` - Configurations for Extent Reports
        - `TakeScreenshot.java` - Utility for capturing screenshots
        - `TestUtils.java` - Miscellaneous utilities
      - **Configurations**
        - `config.properties` - Configuration properties
      - **Database_Connectivity**
        - `MySQLConnector.java` - Database connection helper
      - **Listeners**
        - `Event_Listners.java` - Event listeners for reporting
        - `Test_Listners.java` - Test listeners for enhanced reporting
      - **Pages**
        - `DashboardPage.java` - Page Object for Dashboard page
        - `LoginPage.java` - Page Object for Login page
        - `ProductDetailsPage.java` - Page Object for Product Details page
        - `ShoppingCardPage.java` - Page Object for Shopping Cart page
        - `YourOrdersPage.java` - Page Object for Your Orders page
      - **ScreenRecording**
        - `CaptureVideo.java` - Class to start video recording
        - `ScreenRecorderUtil.java` - Utility for handling screen recording
      - **Tests**
        - `DashboardPageTest.java` - Test for Dashboard functionality
        - `LoginPageTest.java` - Test for Login functionality
        - `ProductDetailsPageTest.java` - Test for Product Details functionality
        - `ShoppingCardPageTest.java` - Test for Shopping Cart functionality
        - `YourOrdersPageTest.java` - Test for Orders functionality

---

## 🌐 Pages Automated

- **Login Page**: Automates login functionality using credentials.
- **Dashboard Page**: Verifies dashboard elements and navigation.
- **Product Details Page**: Selects product details and adds items to the cart.
- **Shopping Cart Page**: Verifies cart items and performs checkout actions.
- **Your Orders Page**: Checks order history and recent purchases.

---

## 🛠️ Tools & Technologies

- **Java** ☕
- **Selenium WebDriver** 🖱️
- **TestNG** 🧪
- **Maven** 📦
- **Extent Reports** 📄

---

## 🚀 Getting Started

### Prerequisites

- **Java (JDK 8+)**
- **Maven**
- **TestNG plugin for IDE** (optional)
