package forer.maze;

import java.util.Random;

public class Maze {

    private int[][] start;
    private int[][] end;
    private boolean[][] grid;
    private int length;
    Random rand;
    private boolean current;
    private boolean neighbor;
    private int[] neighborLoc = new int[2];
    private int startCount = 0;
    private int endCount = 0;

    public Maze(int length) {
        this.length = length;
        grid = new boolean[length][length];
        start = new int[length * length][2];
        end = new int[length * length][2];
        end[length * length - 1][0] = -99;
        rand = new Random();
        int x = rand.nextInt(length);
        int y = rand.nextInt(length);

        solve(x, y);

    }


    public int getEnd(int x, int y) {
        return end[x][y];
    }

    public int getStart(int x, int y) {
        return start[x][y];
    }


    private void solve(int x, int y) {
        current = grid[x][y];
        current = true;

        neighborLoc = chooseNeighbor(x, y);
        neighbor = grid[neighborLoc[0]][neighborLoc[1]];
        if (!neighbor) {
            start[startCount][0] = x;
            start[startCount][1] = y;
            end[endCount][0] = neighborLoc[0];
            end[endCount][1] = neighborLoc[1];
            startCount++;
            endCount++;
        }
        if (end[(length * length) - 1][0] == -99) {
            solve(neighborLoc[0], neighborLoc[1]);
        }
    }

    private int[] chooseNeighbor(int x, int y) {
        int[] chosenNeighbor = new int[2];
        char[] directions = {'N', 'S', 'E', 'W'};
        do {
            char dir = directions[rand.nextInt(4)];
            switch (dir) {
                case 'N':
                    chosenNeighbor[0] = x;
                    chosenNeighbor[1] = y + 1;
                    break;
                case 'S':
                    chosenNeighbor[0] = x;
                    chosenNeighbor[1] = y - 1;
                    break;
                case 'E':
                    chosenNeighbor[0] = x + 1;
                    chosenNeighbor[1] = y;
                    break;
                case 'W':
                    chosenNeighbor[0] = x - 1;
                    chosenNeighbor[1] = y;
                    break;
            }
        }
        while (chosenNeighbor[0] < 0 || chosenNeighbor[1] < 0 || chosenNeighbor[0] > length || chosenNeighbor[1] > length);
        return chosenNeighbor;
    }
}
