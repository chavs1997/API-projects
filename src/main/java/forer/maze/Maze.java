package forer.maze;

import java.util.Random;
import java.util.Stack;

public class Maze {

    public Cell[][] mazeGrid;
    public Stack<Cell> visitedCells = new Stack();
    Random rand = new Random();
    int size;


    public Maze(int size) {
        this.size = size;
        mazeGrid = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                mazeGrid[i][j] = new Cell(i, j);
            }
        }
        generateMaze();
    }

    private void generateMaze() {
        int row = rand.nextInt(size);
        int col = rand.nextInt(size);
        Cell current = mazeGrid[row][col];
        current.setVisited(true);
        do {
            current = removeWalls(current);
        } while (!visitedCells.isEmpty());

    }

    private Cell removeWalls(Cell current) {
        Cell neighbor = chooseNeighbor(current.getRow(), current.getCol());
        if (neighbor != null) {
            visitedCells.push(current);
            if (current.getRow() > neighbor.getRow()) {
                neighbor.setSWall(false);
                current.setNWall(false);
                current = neighbor;
                current.setVisited(true);
            } else if (current.getCol() < neighbor.getCol()) {
                current.setEWall(false);
                neighbor.setWWall(false);
                current = neighbor;
                current.setVisited(true);
            } else if (current.getRow() < neighbor.getRow()) {
                neighbor.setNWall(false);
                current.setSWall(false);
                current = neighbor;
                current.setVisited(true);
            } else {
                neighbor.setEWall(false);
                current.setWWall(false);
                current = neighbor;
                current.setVisited(true);
            }
        } else {
            current = visitedCells.pop();
        }
        return current;
    }

    private Cell chooseNeighbor(int row, int col) {

        Cell neighbor = null;
        char[] directions = availableDirections(row, col);
        while (directions != null) {
            char neighborLoc = directions[rand.nextInt(directions.length)];
            switch (neighborLoc) {
                case 'N':
                    if (!mazeGrid[row - 1][col].isVisited()) {
                        neighbor = mazeGrid[row - 1][col];
                        directions = null;
                    } else {
                        if (directions.length > 1) {
                            char[] oldDirections = directions.clone();
                            directions = new char[oldDirections.length - 1];
                            int count = 0;
                            for (char dir : oldDirections) {
                                if (dir != 'N') {
                                    directions[count] = dir;
                                    count++;
                                }
                            }
                        } else {
                            directions = null;
                        }
                    }
                    break;
                case 'E':
                    if (!mazeGrid[row][col + 1].isVisited()) {
                        neighbor = mazeGrid[row][col + 1];
                        directions = null;
                    } else {
                        if (directions.length > 1) {
                            char[] oldDirections = directions.clone();
                            directions = new char[oldDirections.length - 1];
                            int count = 0;
                            for (char dir : oldDirections) {
                                if (dir != 'E') {
                                    directions[count] = dir;
                                    count++;
                                }
                            }
                        } else {
                            directions = null;
                        }
                    }
                    break;
                case 'S':
                    if (!mazeGrid[row + 1][col].isVisited()) {
                        neighbor = mazeGrid[row + 1][col];
                        directions = null;
                    } else {
                        if (directions.length > 1) {
                            char[] oldDirections = directions.clone();
                            directions = new char[oldDirections.length - 1];
                            int count = 0;
                            for (char dir : oldDirections) {
                                if (dir != 'S') {
                                    directions[count] = dir;
                                    count++;
                                }
                            }
                        } else {
                            directions = null;
                        }
                    }
                    break;
                case 'W':
                    if (!mazeGrid[row][col - 1].isVisited()) {
                        neighbor = mazeGrid[row][col - 1];
                        directions = null;
                    } else {
                        if (directions.length > 1) {
                            char[] oldDirections = directions.clone();
                            directions = new char[oldDirections.length - 1];
                            int count = 0;
                            for (char dir : oldDirections) {
                                if (dir != 'W') {
                                    directions[count] = dir;
                                    count++;
                                }
                            }
                        } else {
                            directions = null;
                        }
                    }
                    break;

            }

        }
        return neighbor;
    }

    private char[] availableDirections(int row, int col) {
        char[] directions;

        if (row == 0 && col == 0) {
            directions = new char[2];
            directions[0] = 'E';
            directions[1] = 'S';
        } else if (row == 0 && col == size - 1) {
            directions = new char[2];
            directions[0] = 'S';
            directions[1] = 'W';
        } else if (row == size - 1 && col == size - 1) {
            directions = new char[2];
            directions[0] = 'W';
            directions[1] = 'N';
        } else if (row == size - 1 && col == 0) {
            directions = new char[2];
            directions[0] = 'E';
            directions[1] = 'N';
        } else if (row == 0) {
            directions = new char[3];
            directions[0] = 'E';
            directions[1] = 'S';
            directions[2] = 'W';
        } else if (col == 0) {
            directions = new char[3];
            directions[0] = 'E';
            directions[1] = 'S';
            directions[2] = 'N';

        } else if (row == size - 1) {
            directions = new char[3];
            directions[0] = 'E';
            directions[1] = 'W';
            directions[2] = 'N';
        } else if (col == size - 1) {
            directions = new char[3];
            directions[0] = 'W';
            directions[1] = 'S';
            directions[2] = 'N';

        } else {
            directions = new char[4];
            directions[0] = 'N';
            directions[1] = 'E';
            directions[2] = 'S';
            directions[3] = 'W';
        }
        return directions;
    }


    public Cell getCell(int row, int col) {
        return mazeGrid[row][col];
    }
}