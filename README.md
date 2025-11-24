SmartSpend (Console Edition)

Overview

SmartSpend is a lightweight, pure Java application for personal finance tracking. It runs entirely in the console without external databases.

Features

1. Zero Dependencies: Runs on standard Java JDK.

2. Data Persistence: Saves data to users.txt and transactions.csv.

3. Security: SHA-256 Password Hashing.

4. Analytics: Instant balance calculation.

How to Run

1. Compile:
Open your terminal in the SmartSpendConsole folder and run:

javac -d bin src/com/smartspend/**/*.java


2. Run:

java -cp bin com.smartspend.Main


Usage

1. Register a new account.

2. Login with your credentials.

3. Add Income or Expenses.

4. View your Report.
