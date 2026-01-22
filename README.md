![Java](https://img.shields.io/badge/Java-17-blue)
![Course](https://img.shields.io/badge/Course-ESINF-green)
# Java Collections Framework — Practical & Laboratory Exercises

## Context and Objective

This project was developed in the context of the **Estruturas de Informação (ESINF)** course and focuses on the **practical application of the Java Collections Framework (JCF)**.

The main objective is to consolidate knowledge about:
- Lists
- Sets
- Maps
- Iterators
- Comparators
- Equality and hashing
- Appropriate data structure selection

All exercises were implemented based on the official practical and laboratory guides provided in class.

---

## What Was Implemented

The project is divided into **two main parts**, corresponding to the **Practical Classes** and the **Laboratory Classes**.

---

## Part 1 — Practical Class: Java Collections Framework

### Football World Cup Winners

**Objective:**  
Transform a list of `(year → country)` pairs into a structure that groups:
- each country
- the list of years in which it won the World Cup (sorted in descending order)

**Key concepts used:**
- `List<Map.Entry<>>`
- `Map<String, List<Integer>>`
- `Comparator`
- Sorting collections

---

### Simple Moving Average (SMA)

**Objective:**  
Compute the Simple Moving Average of a numerical series stored in a `LinkedList`, given a fixed period.

**Key concepts used:**
- `LinkedList`
- Sequential access
- Sliding window logic
- Integer arithmetic

---

### XHTML Tag Validator

**Objective:**  
Validate a sequence of XHTML tags, ensuring:
- all opened tags are closed
- tags are closed in the correct order (last opened, first closed)

**Key concepts used:**
- LIFO (Last In, First Out) behavior
- `LinkedList` used as a `Deque`
- Stack-like logic without using the deprecated `Stack` class

---

### Email Message Analysis (Server)

**Objective:**  
Given a server with sent messages, compute:
- how many messages each sender sent
- to each individual recipient

**Important detail:**  
A single message sent to multiple recipients counts as **one message per recipient**.

**Key concepts used:**
- Nested Maps (`Map<String, Map<String, Integer>>`)
- Iteration over collections
- Aggregation and counting logic

---

## Part 2 — Laboratory Class: Maps and Sets (Supermarket Case Study)

This part models a **supermarket system** using Maps and Sets.

### ✔ Core Data Structure

```
Map<Invoice, Set<Product>>
```

This structure enables:
- grouping products by invoice
- efficient lookup and aggregation
- safe handling of duplicates

---

### Implemented Features

- Equality, comparison and hashing for `Invoice` and `Product`
- Parsing raw textual invoice data into structured objects
- Counting products per invoice
- Filtering invoices between dates
- Computing total sales of a specific product
- Converting invoice-based maps into product-based maps

---

## Data Structures and Design Choices

Throughout the project, careful attention was paid to **choosing the right structure for each problem**:

| Problem | Structure Used | Reason |
|------|---------------|--------|
| Grouping data | `Map` | Key-value association |
| Unique elements | `Set` | Avoid duplicates |
| Ordered data | `List` / `LinkedList` | Maintain insertion order |
| Nested aggregation | `Map of Maps` | Multi-level grouping |
| LIFO behavior | `LinkedList (Deque)` | Stack semantics |

---

## Testing Strategy

Each exercise includes:
- A dedicated `main` method
- Multiple test scenarios
- Edge cases (multiple recipients, repeated elements, empty structures)

The tests were designed to **validate logic**, not just syntax.

---

## Learning Outcomes

By completing this project, the following competencies were reinforced:

- Understanding when and why to use each collection
- Designing clean and readable collection-based algorithms
- Applying theoretical concepts to real-world-like problems
- Writing defensive and testable code
- Reasoning about data structures, not just implementing them


---

## Final Notes

This project is not just a collection of solved exercises —  
it is a **practical demonstration of structured reasoning using Java Collections**, aligned with academic best practices and real-world programming principles.
