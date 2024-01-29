package ca.mcmaster.se2aa4.mazerunner;

//stores the Maze as an entity along with its data (immutable class)
public class Maze {
    private final Cell[][] maze; //DEFINED [ROWS][COLUMNS]
    private final int width;
    private final int height;

    //Create a class for enterances and store their Location (Position + Direction)
    private final Location EAST_ENTRY;
    private final Location WEST_ENTRY;

    public Maze(String inputFile){
        MazeLoader loader = new MazeLoader();
        //perform a deep copy of the maze
        this.maze = loader.generate(inputFile);
        this.height = setHeight();
        this.width = setWidth(); 
        this.EAST_ENTRY = setEastEntry();
        this.WEST_ENTRY = setWestEntry();
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
    
    private Location setEastEntry(){

        for(int i = 0; i < height; i++){
            Cell cell = maze[i][width-1];
            if(cell.equals(Cell.PASS)){
                return new Location(i,width-1);
            }
        }
        return new Location(0,0); //invalid point
    }

    private Location setWestEntry(){
        for(int i = 0; i < height; i++){
            Cell cell = maze[i][0];
            if(cell.equals(Cell.PASS)){

                return new Location(i,0);
            }
        }
        return new Location(0,0);
    }

    public Location getEntry(){
        return WEST_ENTRY;
    }

    public Location getExit(){
        return EAST_ENTRY;
    }

    public boolean checkFront(Position current){ 
        try{
            Cell frontCell = cellAt(current.getForwardLocation());  
            return (frontCell.equals(Cell.PASS)); 

        } catch (IndexOutOfBoundsException e) {
            return false;
        } 
    }

    public boolean checkRight(Position current){
        current.turnRight();
        boolean look = checkFront(current);   
        current.turnLeft();
        return look;            
    }

    public boolean checkLeft(Position current){
        current.turnLeft();
        boolean look = checkFront(current);   
        current.turnRight();
        return look;       
    }

    private Cell cellAt(Location location) { 
        return this.maze[location.getX()][location.getY()]; 
    }

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