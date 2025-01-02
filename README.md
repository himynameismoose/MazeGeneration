# MazeGeneration

A JavaFX application that generates mazes using graph-based algorithms and solves them with Depth-First Search (DFS) and Breadth-First Search (BFS).

---

## Table of Contents

- [Features](#features)
- [Demo](#demo)
- [Installation](#installation)
- [Usage](#usage)
- [Technologies Used](#technologies-used)

---

## Features

- Generate random mazes using graph-based algorithms.
- Solve mazes using:
  - Depth-First Search (DFS)
  - Breadth-First Search (BFS)
- Visual representation of maze generation and solving processes.

---

## Demo

![MazeGeneration Demo](https://github.com/himynameismoose/MazeGeneration/blob/master/src/img/dfs_solve.png)
![MazeGeneration Demo](https://github.com/himynameismoose/MazeGeneration/blob/master/src/img/bfs_solve.png)

---

## Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/himynameismoose/MazeGeneration.git

2. Navigate to the project directory:
   ```bash
   cd MazeGeneration
3. Ensure you have Java and JavaFx installed:
   * Java Development Kit (JDK) 8 or higher is required.
   * JavaFX SDK is configured properly.
4. Compile and run the application
   * Using an IDE:
     * Import the project.
     * Configure JavaFX libraries.
     * Run the `MazeUICompleted` class.
   * Using command line:
     ```bash
     javac --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml -d bin src/*.java
     java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml -cp bin Main
     ```
     Replace /path/to/javafx-sdk with the actual path to your JavaFX SDK.

---

## Usage

1. Launch the application.
2. Generate a maze:
   * Choose the desired maze size.
   * Click on the "Generate Maze" button.
3. Solve the maze:
   * Click on "Solve with BFS!" or "Solve with DFS!" button.
4. Visualize:
   * Watch the maze generation and solving animations.

---

## Technologies Used

  * Programming Language: Java
  * GUI Framework: JavaFX
  * Algorithms:
      * Depth-First Search (DFS)
      * Breadth-First Search (BFS)
  * Data Structures: Graphs, Union-Find

---

## Contributing

Contributions are welcome! To contribute:
1. Fork the repository.
2. Create a new branch.
   ```bash
   git checkout -b feature-name
   ```
3. Make your changes.
4. Commit your changes.
   ```bash
   git commit -m "Add feature-name"
   ```
5. Push to your branch:
   ```bash
   git push origin feature-name
   ```
6. Open a Pull Request.
