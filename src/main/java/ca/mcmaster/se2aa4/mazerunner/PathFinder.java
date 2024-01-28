package ca.mcmaster.se2aa4.mazerunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PathFinder{
    private Maze maze;
    public String path = "";
    private Position current;
    private final Position ENTRY;
    private final Position EXIT;

    public PathFinder(Maze theMaze){
        this.maze = theMaze;
        this.ENTRY= new Position(maze.getEntry(), Direction.EAST);
        System.out.println("Starting At: " + ENTRY.toString());
        this.EXIT = new Position(maze.getExit(), Direction.EAST);
    }

    public void RightHandRule(){
        current = ENTRY;
        String step = "";
        do{
            if(checkRight()){
                step = "RF";  
            } 
            else if(checkFront()){
                step = "F";
            } 
            else if(checkLeft()){
                step = "L"; 
            }
            else{
                step = "RR";
            }
            current.move(step);
            path += step;

        } while(!isAtExit());

        System.out.println("Computed Path: " + path);
        System.out.println("Finished at: " + current.toString());
    }

    private boolean isAtExit(){
        return current.equals(EXIT);
    }

    private boolean checkFront(){
        try{
            Cell frontCell = maze.cellAt(current.getForwardLocation());
            return frontCell.equals(Cell.PASS); 
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    private boolean checkRight(){
        current.turnRight();
        boolean look = checkFront();   
        current.turnLeft();
        return look;            
    }

    private boolean checkLeft(){
        current.turnLeft();
        boolean look = checkFront();   
        current.turnRight();
        return look;       
    }

}
