package ca.mcmaster.se2aa4.mazerunner;

public class PathFinder implements ExploreMode{
    private Maze maze;
    public String path = "";
    private Position current;
    private Position EXIT;

    public PathFinder(Maze theMaze){
        setUp(theMaze);
    }

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

    private boolean isAtExit(){
        return current.equals(EXIT);
    }

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
