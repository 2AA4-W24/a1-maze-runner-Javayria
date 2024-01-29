package ca.mcmaster.se2aa4.mazerunner;

/*
*Stores the Maze along with its data 
*/
public class Maze {

    /*
     * A Cell in Cell[][] is referenced vy [row][column]
     */
    private final Cell[][] maze; 
    private final int width;
    private final int height;
    private final Location EAST_ENTRY;
    private final Location WEST_ENTRY;

    public Maze(String inputFile){

        /*
         * Get Cell[][] from MazeLoader and set all maze attributes
         */
        MazeLoader loader = new MazeLoader();
        this.maze = loader.generate(inputFile);
        this.height = setHeight();
        this.width = setWidth(); 
        this.EAST_ENTRY = setEastEntry();
        this.WEST_ENTRY = setWestEntry();
    }
    
    
    private int setHeight(){
        int height = maze.length;
        return height;
    }

    private int setWidth(){
        int width = maze[0].length;
        return width;
    }
    
    /*
     * Search the last column of Maze for EastEntry
     * @return Location of EastEntry
     */
    private Location setEastEntry(){

        for(int i = 0; i < height; i++){
            Cell cell = maze[i][width-1];
            if(cell.equals(Cell.PASS)){
                return new Location(i,width-1);
            }
        }
        return new Location(0,0); //invalid point
    }

    /*
     * Search the first column of Maze for WestEntry
     * @return Location of WestEntry
     */
    private Location setWestEntry(){
        for(int i = 0; i < height; i++){
            Cell cell = maze[i][0];
            if(cell.equals(Cell.PASS)){

                return new Location(i,0);
            }
        }
        return new Location(0,0);
    }

    /*
     * Public accessors to get locations for both entrances
     */
    public Location getEntry(){
        return WEST_ENTRY;
    }

    public Location getExit(){
        return EAST_ENTRY;
    }

    /*
     * Check if Cell in front of current position is valid
     * @return true if Cell is PASS, false if WALL
     */
    public boolean checkFront(Position current){ 
        try{
            Cell frontCell = cellAt(current.getForwardLocation());  
            return (frontCell.equals(Cell.PASS)); 

        } catch (IndexOutOfBoundsException e) {
            return false;
        } 
    }

     /*
     * Check if Cell to the right of current position is valid
     * @return true if Cell is PASS, false if WALL
     */
    public boolean checkRight(Position current){
        current.turnRight();
        boolean look = checkFront(current);   
        current.turnLeft();
        return look;            
    }

    /*
     * Check if Cell to the left of current position is valid
     * @return true if Cell is PASS, false if WALL
     */
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