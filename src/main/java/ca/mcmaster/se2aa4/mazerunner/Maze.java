package ca.mcmaster.se2aa4.mazerunner;

public class Maze {
    private Cell[][] maze;
    private int h;
    private int w;
    Position enter = new Position(0,0);
    Position exit = new Position(0,0);

    public Maze(String inputFile){
        MazeLoader loader = new MazeLoader();
        this.maze = loader.generate(inputFile);
    }

    public void leftEntry(){
        enter.x = 0;
        enter.y = 2;
    }

    public void rightEntry(){
        exit.x = this.w-1;
        exit.y = 2;
    }

    public Cell cellAt(int x, int y) { return maze[y][x]; }


    public void printMaze(){
        int rows = maze.length;
        int columns = maze[0].length;
        System.out.println("rows: "+ rows);
        System.out.println("columns: "+ columns);
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.print("\n"); 
        }
    }
}