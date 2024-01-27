package ca.mcmaster.se2aa4.mazerunner;

public class MazeSolver{
    private final Maze maze;
    public String compPath = "";
    private String direction;
    private Position current;
    private Position EXIT;

    //half of the Maze
    public MazeSolver(Maze theMaze){
        this.maze = theMaze;
        this.current = new Position(theMaze.getEntry(), Direction.EAST);
        this.EXIT = new Position(theMaze.getExit(), Direction.EAST);
    }

    public void traverse(){
        while(!isAtExit()){


        }
    }

    private void updatePath(){

    }

    private void move(){

    }

    private boolean isAtExit(){
        return current.equals(EXIT);
    }

    
    //ALGORITHIM
    public String RightHandRule(){
        if(explorer.checkRight()){
            return "R";
        } 
        else if(explorer.checkFront()){
            return "F";
        } 
        else if(explorer.checkLeft()){
            return "L";
        }
        else{
            return "RR";
        }
    }

    private boolean checkFront(){
        Location front = position.getForwardLocation();
        Cell frontCell = maze.cellAt(front);
        return frontCell.equals(Cell.PASS);        
    }

    private boolean checkFront(){
        Location front = position.getForwardLocation();
        Cell frontCell = maze.cellAt(front);
        return frontCell.equals(Cell.PASS);        
    }

    private boolean checkFront(){
        Location front = position.getForwardLocation();
        Cell frontCell = maze.cellAt(front);
        return frontCell.equals(Cell.PASS);        
    }

    public void turnAround(){

    }


    /*public boolean endReached(){
        if((current.x == exit.x) && (current.y == exit.y)){
            return true;
        } 
        else{
            return false;
        }
     }*/
}
