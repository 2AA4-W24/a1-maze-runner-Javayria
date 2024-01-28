package ca.mcmaster.se2aa4.mazerunner;
//reasoning for making pathcheck seperate class instead of a method for Path is because thats not Path's repsonsibility - it's the explorer's!!!

public class PathCheck{
    private String inputPath;
    public String validResult;
    private final Maze maze;
    private Position EXIT;
    private Position currPosition;

    public PathCheck(Maze theMaze, String inputPath){
        this.inputPath = inputPath;
        this.maze = theMaze;
        this.currPosition = new Position(maze.getEntry(), Direction.EAST);
        this.EXIT = new Position(maze.getExit(), Direction.EAST);
    }

    public String verifyPath(){
        if(!walkPath()){ 
            switchStart();
            if(!walkPath()){
                return "incorrect path";
            }
        }
        return "Correct path";
    }

    private boolean walkPath(){
        String step = "";
        for(char next: inputPath.toCharArray()){
            step = String.valueOf(next);

            if(!(step.equals("F"))){
                currPosition.move(step);
            }
            else if(step.equals("F") && (checkFront())){
                currPosition.move(step);
            }
            else{
                return false;
            }
        }
        return currPosition.equals(EXIT);
    }

    private boolean checkFront(){ 
        try{
            Cell frontCell = maze.cellAt(currPosition.getForwardLocation());
            return frontCell.equals(Cell.PASS); 

        } catch (IndexOutOfBoundsException e) {
            return false;
        } 
    }

    private void switchStart(){
        this.currPosition = new Position(maze.getExit(), Direction.WEST);
        this.EXIT = new Position(maze.getEntry(), Direction.WEST);
    }

}


