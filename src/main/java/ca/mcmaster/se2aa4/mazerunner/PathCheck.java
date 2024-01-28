package ca.mcmaster.se2aa4.mazerunner;
//reasoning for making pathcheck seperate class instead of a method for Path is because thats not Path's repsonsibility - it's the explorer's!!!

public class PathCheck{
    private String inputPath;
    private boolean validResult;
    private Maze maze;
    private Position current;
    private Position EXIT;
    private int next;

    public PathCheck(Maze theMaze, String inputPath){
        this.inputPath = inputPath;
        this.maze = theMaze;
        this.current = new Position(maze.getEntry(), Direction.EAST);
        System.out.println("NEW ENTRY POINT: " + maze.getEntry().toString());
        this.EXIT = new Position(maze.getExit(), Direction.EAST);
        System.out.println("CURRENT STARTING POINT: " + EXIT.toString());
        System.out.println(walkPath()); 
    }

    //read step, check if its valid, follow step, check if you are at exit (yes, then done!) - otherwise keep going!

    public String walkPath(){
        String step = "";
        for(char next: inputPath.toCharArray()){
            step = String.valueOf(next);
            System.out.println(step);

            if(!(step.equals("F"))){
                current.move(step);
                System.out.println(step);
            }
            else if(step.equals("F") && (checkFront())){
                current.move(step);
                System.out.println(step);

            }
            else{
               return "incorrect";
            }
        }
        System.out.println(current.coordinates.toString());

        if(current.equals(EXIT)){
            return("correct");
        }else{
            return("incorrect");
        }
    }

    private boolean checkFront(){ //put it in maze?
        System.out.println((current.getForwardLocation()).toString());
        Cell frontCell = maze.cellAt(current.getForwardLocation());
        System.out.println(frontCell.toString());
        return frontCell.equals(Cell.PASS); 
    }
 
}


