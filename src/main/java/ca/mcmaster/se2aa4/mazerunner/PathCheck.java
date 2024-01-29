package ca.mcmaster.se2aa4.mazerunner;
//reasoning for making pathcheck seperate class instead of a method for Path is because thats not Path's repsonsibility - it's the explorer's!!!

public class PathCheck implements ExploreMode{
    private String inputPath;
    public String validResult;
    private Maze maze;
    private Position EXIT;
    private Position currPosition;

    public PathCheck(Maze theMaze, String inputPath){
        this.inputPath = inputPath;
        this.maze = theMaze;
        setUp();
    }

    public String verifyPath(){
        if(!walkPath()){ 
            switchStart();
            if(!walkPath()){
                System.out.println(currPosition.toString());
                return "incorrect path";
            }
        }
        return "Correct path";
    }

    private boolean walkPath(){
        String step = "";
        int i = 0;
        while (i < inputPath.length()){
            step = String.valueOf(inputPath.charAt(i));
            if(!step.equals("F") || checkFront()){
                currPosition.move(step);
            }   
            else{
                return false;
            }
            i++;
        }
        return currPosition.equals(EXIT);
    }

    private boolean checkFront(){ 
        try{
            Cell frontCell = maze.cellAt(currPosition.getForwardLocation());  
            return (frontCell.equals(Cell.PASS)); 

        } catch (IndexOutOfBoundsException e) {
            return false;
        } 
    }

    private void switchStart(){
        this.currPosition = new Position(maze.getExit(), Direction.WEST);
        this.EXIT = new Position(maze.getEntry(), Direction.WEST);
    }

    @Override
    public void setUp() {
        this.currPosition = new Position(maze.getEntry(), Direction.EAST);
        this.EXIT = new Position(maze.getExit(), Direction.EAST);
    }

    @Override
    public String explore() {
        return(verifyPath());
    }
}


