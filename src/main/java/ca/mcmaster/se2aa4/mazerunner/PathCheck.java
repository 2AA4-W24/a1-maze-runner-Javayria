package ca.mcmaster.se2aa4.mazerunner;

/*
 * Check if a given path is valid for a maze
 */
public class PathCheck implements ExploreMode{

    private Maze maze;
    private String inputPath;
    public String validResult;
    
    private Position EXIT;
    private Position currPosition;

    /*
     * Create a pathChecker that will follow a given path 
     * @param theMaze to traverse
     * @param inputPath to check
     */
    public PathCheck(Maze theMaze, String inputPath){
        this.inputPath = inputPath;
        setUp(theMaze);
    }

    /*
     * Set up the maze, currPostion, and exit instance variables
     */
    @Override
    public void setUp(Maze theMaze) {
        this.maze = theMaze;
        this.currPosition = new Position(maze.getEntry(), Direction.EAST);
        this.EXIT = new Position(maze.getExit(), Direction.EAST);
    }

    /*
     * Solve the path -try to walk the path from West to East entrance first, then try from East to West
     * @return String "correct path" if inputPath is valid, otherwise return "incorrect path" 
     */
    @Override
    public String explore() {
        if(!walkPath()){ 
            switchStart();
            if(!walkPath()){
                return "incorrect path";
            }
        }
        return "correct path";
    }

    /*
     * Follow the path step by step
     * @return false if tries to walk off the grid or end position is not exit, otherwise true
     */
    private boolean walkPath(){
        String step = "";
        int i = 0;
        while (i < inputPath.length()){
            step = String.valueOf(inputPath.charAt(i));
            if(!step.equals("F") || maze.checkFront(currPosition)){
                currPosition.move(step);
            }   
            else{
                return false;
            }
            i++;
        }
        return currPosition.equals(EXIT);
    }
     
    /*
     * Start at the Eastern_Entry facing WEST
     */
    private void switchStart(){
        this.currPosition = new Position(maze.getExit(), Direction.WEST);
        this.EXIT = new Position(maze.getEntry(), Direction.WEST);
    }

}


