package ca.mcmaster.se2aa4.mazerunner;

//stores the Maze as an entity along with its data (immutable class)
public class Maze {
    private final Cell[][] maze;
    private final int width;
    private final int height;

    //Create a class for enterances and store their Location (Position + Direction)
    Location EAST_ENTRY;
    Location WEST_ENTRY;

    public Maze(String inputFile){
        MazeLoader loader = new MazeLoader();
        //perform a deep copy of the maze
        this.maze = loader.generate(inputFile);
        this.height = setHeight();
        this.width = setWidth(); 
        setEastEntry();
        setWestEntry();
    }
    
    //make this immutable
    private int setHeight(){
        int height = maze.length;
        return height;
    }

    private int setWidth(){
        int width = maze[0].length;
        return width;
    }
    
    //hide in its own class later using Position (MATCH INDEX AND POSITION)
    private void setEastEntry(){
        for(int i = 0; i < height; i++){
            Cell cell = maze[i][width-1];
            if(cell.equals(Cell.PASS)){
                this.EAST_ENTRY = new Location(i,width-1);
            }
        }
        System.out.println("East Entrance: " + EAST_ENTRY.toString());
    }

    private void setWestEntry(){
        for(int i = 0; i < height; i++){
            Cell cell = maze[i][0];
            if(cell.equals(Cell.PASS)){
                this.WEST_ENTRY = new Location(i,0);
            }
        }
        System.out.println("West Entrance: " + WEST_ENTRY.toString());
    }

    public Cell cellAt(Location location) { return this.maze[location.x][location.y]; }

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