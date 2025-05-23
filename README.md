# 🖋📝 S1.07.Annotations.Lv2

## 📂 Custom Annotation and Manual JSON Serialization

### 🧾 Exercise Description
The goal of this exercise is to practice creating and using custom annotations in Java. You'll create a custom annotation @JsonSerializable that takes a directory path as a parameter, and then serialize objects of annotated classes into a JSON file without using any external libraries.

This is done using reflection and file writing to manually convert the object fields into a simple JSON format.

### ✅ Requirements
Level 2 – Exercise 1

Create a custom annotation @JsonSerializable(directory = "...") that defines where the resulting JSON file will be saved.

Create a class (e.g. Person) annotated with @JsonSerializable.

Implement a class JsonSerializer that:

Uses reflection to read the fields of the object.

Converts them into JSON format manually.

Saves the output in the specified directory.

Test the functionality using a Main class.

### 🔨 Methods and Classes Implemented

```
// JsonSerializable.java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface JsonSerializable {
    String directory();
}

// Person.java
@JsonSerializable(directory = "output")
public class Person {
    private String name;
    private int age;
}

// JsonSerializer.java
public static void serialize(Object obj)

// Main.java
public static void main(String[] args)
```

### 💻 Technologies Used
Java 17 or higher (Java 24 in your case)

IntelliJ IDEA (Community Edition)

No third-party libraries used

### 📋 Prerequisites
Java JDK 17+ installed

IntelliJ IDEA Community Edition

Git (optional, for version control)

### 🛠️ Installation and Setup
Install Required Tools

Java JDK 17 or higher

IntelliJ IDEA Community Edition

Clone the Repository (Optional)

```
git clone https://github.com/ArnauAsole/S1.07.Annotations.Lv2.git
cd S1.07.Annotations.Lv2/
```

Open the Project in IntelliJ
Go to File → Open and select the root folder of the project.

### ▶️ Running the Project
To run the program:

Open Main.java

Right-click the file and select Run

The program will:

Create an output/ directory (if it doesn’t exist)

Serialize the Person object into a Person.json file in that directory

Print the file path to the console

Example output:
```
{
  "name": "Anna",
  "age": 25
}
```

### 🌐 Deployment
This is a simple, local, console-based Java project meant for educational use. No deployment required.

### 🤝 Acknowledgements
Special thanks to the contributors: Arnau, Adrià, Ignasi, Ana, Alejandro, Marc and Marina.
