# Problem Title: AskCampus — Rule-Based College FAQ Chatbot

**Problem ID:** CP-100

## Team Members

1. **Name:** Dhanush N Ragi | **USN:** 1AT24CS054
2. **Name:** Anil L | **USN:** 1AT24CS019

**Track:** Java

## How to Run the Program

**Prerequisites:**

* Java Development Kit (JDK) installed.
* A terminal or command prompt.

**Steps:**

1. Clone or download this repository.

2. Open the project folder in your terminal.

3. Compile the program:

   ```bash
   javac Main.java
   ```

4. Execute the program:

   ```bash
   java Main
   ```

## Features Implemented

* Maintain a knowledge base of college FAQs containing questions, answers, and keywords.
* Match user questions to the best answer using keyword overlap.
* Display a fallback response when no suitable answer is found.
* Log unanswered questions for future review.
* Allow an administrator to add new questions and answers.

## Sample Run

**Input:**

```text
========== ASK CAMPUS ==========
1. Ask a Question
2. View FAQ Categories
3. Search FAQs
4. View All FAQs
5. Admin: Add New FAQ
6. View Unanswered Questions
7. Exit

Enter your choice: 1
Enter your question: When are the exams?

```

**Output:**

```text
A matching FAQ was found!

Answer: Please check the official college
notice board for examination dates.
```
