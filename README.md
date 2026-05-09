 ADS Assignment 3
Name: Abdysadykov Daniyar
Group: IT - 2504
Sorting and Searching Algorithm Analysis System
About the Project
This project was created for the Algorithms and Data Structures course.

The purpose of the assignment was to implement and compare different sorting and searching algorithms, measure their execution time, and analyze their performance on arrays of different sizes.

In this project I implemented:

Selection Sort
Quick Sort
Binary Search

The program also measures execution time using System.nanoTime().
Algorithms Used
Selection Sort
Selection Sort is a basic sorting algorithm.

It works by repeatedly finding the minimum element and placing it in the correct position.

Characteristics:

simple algorithm

easy to understand

works slower on large arrays

time complexity: O(n²)

Quick Sort
Quick Sort is an advanced recursive sorting algorithm.

It chooses a pivot element, divides the array into smaller parts, and recursively sorts them.

Characteristics:

much faster on large arrays

recursive algorithm

average complexity: O(n log n)

Binary Search
Binary Search is a searching algorithm that works only on sorted arrays.

It repeatedly checks the middle element and removes half of the remaining search area.

Characteristics:

very fast searching

requires sorted array

complexity: O(log n)

Program Structure
The project contains four classes.

Main.java
Responsible for:

generating arrays

running experiments

measuring execution time

displaying results

SelectionSort.java
Contains implementation of Selection Sort.

QuickSort.java
Contains implementation of Quick Sort.

BinarySearch.java
Contains implementation of Binary Search.

Array Sizes Tested
The algorithms were tested on arrays of different sizes:

10 elements

100 elements

1000 elements

Both random and sorted arrays were used.

Performance Measurement
Execution time was measured using:
System.nanoTime()
The output displays the execution time in nanoseconds.
Example output:
Array Size: 1000
Selection Sort: 7355400 ns
Quick Sort: 767400 ns
Binary Search Index: 500
Binary Search Time: 3200 ns
The results showed that:

Selection Sort becomes much slower as array size increases.

Quick Sort performs significantly faster on large arrays.

Binary Search is extremely fast because it reduces the search space by half each step.

The experimental results match theoretical Big O complexity.

## Screenshots
<img width="1919" height="702" alt="image" src="https://github.com/user-attachments/assets/737095c7-056a-479c-81bd-ce5b7c0322db" />
<img width="1883" height="124" alt="image" src="https://github.com/user-attachments/assets/68da53de-038e-4503-86f3-3f1770318ed9" />
<img width="1303" height="166" alt="image" src="https://github.com/user-attachments/assets/b3838159-fffa-4ae8-b789-2ee078f1798f" />


The algorithms behaved differently depending on the input type.

Selection Sort showed similar behavior on both random and sorted arrays because it still checks all elements.

Quick Sort performed better on random arrays in most cases. The performance depends on pivot selection.

Binary Search only works correctly on sorted arrays because it repeatedly divides the search area in half.
## Reflection

During this assignment I better understood how algorithm efficiency changes with input size.

At first, Selection Sort seemed fast on small arrays, but on larger arrays Quick Sort became much more efficient.

I also understood why Binary Search is considered one of the fastest searching algorithms and why sorted data is important for it.

The main challenge was understanding recursion in Quick Sort and comparing execution times correctly.
