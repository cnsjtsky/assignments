 ADS Assignment 4
Name: Abdysadykov Daniyar
Group: IT - 2504
 Graph Traversal and Representation System
 Project Overview

This project demonstrates graph representation and traversal algorithms in Java.

The graph is implemented using an adjacency list structure.

The project includes:
- Breadth-First Search (BFS)
- Depth-First Search (DFS)

The program also measures traversal execution time using System.nanoTime().
 Graph Structure

The graph consists of:
- Vertices (nodes)
- Edges (connections between vertices)

The graph is represented using an adjacency list.

Adjacency list stores neighbors of every vertex and is memory efficient for sparse graphs.


 Classes Description

 Vertex.java

Represents a graph vertex.

Contains:
- id field
- constructor
- getter
- toString()

 Edge.java

Represents a connection between two vertices.

Contains:
- source vertex
- destination vertex
- constructor
- getters
- toString()

 Graph.java

Main graph structure.

Implements:
- adjacency list
- addVertex()
- addEdge()
- printGraph()
- bfs()
- dfs()


### Experiment.java

Responsible for:
- running traversal algorithms
- measuring execution time
- testing graphs of different sizes


### Main.java

Starts the program and runs experiments.

# Algorithms

## Breadth-First Search (BFS)

BFS explores the graph level by level.

It uses a Queue data structure.

Steps:
1. Start from selected vertex
2. Visit neighbors
3. Add neighbors to queue
4. Continue until queue becomes empty

Time Complexity:
O(V + E)

Where:
- V = number of vertices
- E = number of edges

Use cases:
- shortest path
- social networks
- web crawling


# Depth-First Search (DFS)

DFS explores as deep as possible before backtracking.

It uses recursion (stack behavior).

Steps:
1. Visit current vertex
2. Move to unvisited neighbor
3. Continue deeply
4. Backtrack when needed

Time Complexity:
O(V + E)

Use cases:
- path finding
- cycle detection
- maze solving


# Experimental Results

Graphs tested:
- 10 vertices
- 30 vertices
- 100 vertices

Example results:

| Graph Size | BFS Time | DFS Time |
|---|---|---|
| 10 | 1718700 ns | 526700 ns |
| 30 | 1705300 ns | 1005400 ns |
| 100 | 4611600 ns | 3844200 ns |


# Analysis

As graph size increased, traversal time also increased.

Both BFS and DFS showed complexity close to O(V + E), because each vertex and edge is visited once.

BFS and DFS produced similar traversal order because the graph structure was mostly linear.

BFS is preferred when shortest path or level-order traversal is needed.

DFS is useful for deep exploration and recursive traversal.

One limitation of DFS is possible stack overflow on very deep graphs because of recursion.


# Screenshots

- graph structure
- <img width="268" height="349" alt="image" src="https://github.com/user-attachments/assets/0fccfa4b-9fbd-4a41-84f5-f27b468ac8f3" />

- BFS traversal
- DFS traversal
- <img width="1802" height="682" alt="image" src="https://github.com/user-attachments/assets/15b2175d-5783-4dbd-87e4-2883b3a7972a" />

# Reflection

During this assignment I learned how graphs are represented using adjacency lists and how traversal algorithms work.

I better understood the difference between BFS and DFS, especially how BFS uses a queue while DFS uses recursion.

The most challenging part was understanding graph traversal logic and recursion in DFS.
