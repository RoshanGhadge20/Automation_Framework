🛠️ Amazon Automation Framework
Welcome to the Amazon Automation Framework! This project is built using a structured Page Object Model (POM) to automate the Amazon website. The framework covers essential flows including Login, Dashboard Navigation, Product Details, Shopping Cart, and Order Review.

📂 Project Structure
The framework is organized using the Page Object Model (POM) pattern for clarity and scalability. Here's the breakdown:
📁 src
 ├── 📂 main
 │    └── 📂 java
 │    
 └── 📂 test
     └── 📂 java
          ├── 📂 BaseTest
          │    └── Base_Test.java
          ├── 📂 CommonUtilities
          │    ├── ExcelUtility.java
          │    ├── Extent_Reports.java
          │    ├── TakeScreenshot.java
          │    └── TestUtils.java
          ├── 📂 Configurations
          │    └── config.properties
          ├── 📂 Database_Connectivity
          │    └── MySQLConnector.java
          ├── 📂 Listners
          │    ├── Event_Listners.java
          │    └── Test_Listners.java
          ├── 📂 Pages
          │    ├── DashboardPage.java
          │    ├── LoginPage.java
          │    ├── ProductDetailsPage.java
          │    ├── ShoppingCardPage.java
          │    └── YourOrdersPage.java
          └── 📂 ScreenRecording
          │    ├── CaptureVideo.java
          │     └── ScreenRecorderUtil.java
          └── 📂 Tests
                ├── DashboardPageTest.java
                ├── LoginPageTest.java
                ├── ProductDetailsPageTest.java
                ├── ShoppingCardPageTest.java
                └── YourOrdersPageTest.java
 
🌐 Pages Automated
Login Page: Automates login functionality using credentials.
Dashboard Page: Verifies dashboard elements and navigation.
Product Details Page: Selects product details and adds items to the cart.
Shopping Cart Page: Verifies cart items and performs checkout actions.
Your Orders Page: Checks order history and recent purchases.

🛠️ Tools & Technologies
Java ☕
Selenium WebDriver 🖱️
TestNG 🧪
Maven 📦
Extent Reports 📄

🚀 Getting Started
Prerequisites
Java (JDK 8+)
Maven
TestNG plugin for IDE (optional)

