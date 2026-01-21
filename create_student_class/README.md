# Student Class (Java)

This project implements a simple `Student` class to practice core object-oriented programming concepts in Java, including classes, objects, fields, constructors, and method overriding. Each `Student` object represents an individual student with private fields such as name, student ID, GPA, and major.

The constructor initializes all fields and uses setter-style validation logic to ensure the object starts in a valid state. Input values are normalized and constrained where appropriate: names are trimmed and must meet a minimum length, GPA values are capped within a valid range, and a missing or blank major defaults to `"Undeclared"`.

The `toString()` method is overridden to provide a clear, human-readable description of a student object. The `equals()` and `hashCode()` methods are also overridden to define logical equality between students, with student ID used as the primary identifier.
