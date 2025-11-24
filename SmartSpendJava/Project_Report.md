Project Report: SmartSpend Console

1. Introduction

SmartSpend is a Java-based financial tracker that focuses on simplicity and speed.

2. Functional Requirements

User Management: System verifies credentials against users.txt.

Transaction Logging: System appends records to transactions.csv.

Reporting: System aggregates income vs expenses.

3. Non-Functional Requirements

Persistence: Data survives application restart (File I/O).

Security: Passwords hashed using SHA-256.

Portability: Runs on any machine with Java installed.

Modularity: Code separated into Model, View (Main), and Controller (Service) layers.

4. System Architecture

Models: User, Transaction (Data carriers).

Services: Business logic implementation.

Utils: FileHandler for low-level storage.