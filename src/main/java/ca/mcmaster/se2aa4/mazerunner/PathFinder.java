package ca.mcmaster.se2aa4.mazerunner;

/*
 * Finds a path from entry to exit of a given maze
 */
public class PathFinder implements ExploreMode{
    private Maze maze;
    public String path = "";
    private Position current;
    private Position EXIT;
 

    public PathFinder(Maze theMaze){
        setUp(theMaze);
    }

    /*
     * Implements the Right Hand Rule to solve a maze
     * @returns the factorized String path
     */
    private String RightHandRule(){
        String step = "";
        do{
            if(maze.checkRight(current)){
                step = "RF";  
            } 
            else if(maze.checkFront(current)){
                step = "F";
            } 
            else if(maze.checkLeft(current)){
                step = "L"; 
            }
            else{
                step = "RR";
            }
            current.move(step);
            path += step;

        } while(!isAtExit());
        return FormatPath.compact(path);
    }

    /*
     * Check if current position is at EXIT
     */
    private boolean isAtExit(){
        return current.equals(EXIT);
    }

    /*
     * Implemented methods of ExploreMaze interface
     */
    @Override
    public void setUp(Maze theMaze) {
        this.maze = theMaze;
        this.current= new Position(maze.getEntry(), Direction.EAST);
        this.EXIT = new Position(maze.getExit(), Direction.EAST);
    }

    @Override
    public String explore() {
        return RightHandRule();
    }

}
