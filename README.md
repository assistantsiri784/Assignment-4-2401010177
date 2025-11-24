

# 📚 City Library Digital Management System

A Java-based console application that digitizes the operations of a city library.
This project demonstrates **File Handling**, **Java Collections Framework**, **Comparable/Comparator**, and **Generics** in a real-world scenario.

---

## 🚀 Features

### 📘 Book Management

* Add new books
* Store details such as title, author, category, and issue status
* Sort books using Comparable (by title)

### 👤 Member Management

* Add new members
* Maintain issued books as a list
* Store member-specific details such as name and email

### 🔁 Transaction Management

* Issue a book to a member
* Return a book
* Track which books are issued and to whom

### 🔍 Search & Sort

* Search books by:

  * Title
  * Author
  * Category
* Sort books by title (Comparable)

### 💾 File Persistence

Uses **text-based file handling** to store data permanently:

* `books.txt` → Stores all book records
* `members.txt` → Stores all member records

---

## 🧰 Technologies Used

* **Java 8+**
* **Collections Framework**

  * Map, List, Set
* **File Handling**

  * BufferedReader / BufferedWriter
  * FileReader / FileWriter
* **OOP Concepts**

  * Encapsulation
  * Class Design
  * Method Abstraction

---

## 📂 Project Structure

```
Book.java
Member.java
LibraryManager.java
LibraryApp.java   (main class)
books.txt
members.txt
```

Each class is responsible for a specific functionality:

* **Book** → Represents a book and implements Comparable
* **Member** → Stores member details and issued books
* **LibraryManager** → Core logic for add/search/issue/return
* **LibraryApp** → User interface + menu

---

## ▶️ How to Run

1. Clone/download this repository
2. Open terminal inside the project folder
3. Compile all Java files:

```
javac *.java
```

4. Run the application:

```
java LibraryApp
```

---

## ✨ Learning Outcomes

This project helps you understand:

✔ How to design classes for a real-world system
✔ How to use Java’s File Handling API for persistent storage
✔ How to manage dynamic data using Collections Framework
✔ How to implement sorting using Comparable / Comparator
✔ How to integrate I/O operations with collections

---

## 📌 Future Enhancements (Optional)

* Add binary file handling using serialization
* Implement a waiting list using Queue
* Add graphical user interface (GUI)
* Add admin login system
* Add advanced sorting (author/category with Comparator)

