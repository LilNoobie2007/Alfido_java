Task 3: Collections & Exception Handling
This folder contains the implementation of advanced data structures and runtime error-management protocols as part of my third internship milestone. The project demonstrates how to build fault-tolerant backend applications.

📁 Files in this Task
LibrarySystem.java: 
A Central Library Management System designed to handle dynamic cataloging, unique category logging, and synchronized data tracking across multiple frameworks.

🛠️ Key Technical Concepts Applied
 - The Collections Framework: Utilized ArrayList for sequential storage, HashMap for high-speed resource mapping, and HashSet to eliminate duplicate entries automatically.
 - Custom Exception Architecture: Implemented a domain-specific InvalidBookException class to gracefully manage runtime conflicts like duplicate registrations or missing asset queries.
 - Defensive Programming: Wrapped active code components inside robust try-catch structures to isolate potential input format failures or logic errors.
 - Resource Management: Employed the finally block to guarantee terminal session cleanup and secure data stream closure regardless of execution paths.

🚀 How to Run
Navigate to the task3 directory.

Compile the file:
javac LibrarySystem.java

Execute the program:
java LibrarySystem
