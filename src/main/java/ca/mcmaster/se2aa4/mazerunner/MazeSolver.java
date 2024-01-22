package ca.mcmaster.se2aa4.mazerunner;

public class MazeSolver {
    private final Maze maze;
    private String compPath;
    private String direction;
    private Position enter;
    private Position current;
    private Position exit;
    

    public MazeSolver(Maze theMaze){
        this.maze = theMaze;
        this.enter = theMaze.enter;
        this.exit = theMaze.exit;  
    }

    public void setInitialDirection(){
        if(enter.x == 0){
            this.direction = "E";
        }
        else{
            this.direction = "F";
        }
    }


    public char stepForward(){
        if(direction.equals("N")){
            current.y--;
        }
        else if(direction.equals("S")){
            current.y++;
        }
        else if(direction.equals("E")){
            current.x++;
        }
        else{
            current.x--;
        }

        char step = 'F';
        return step;  
    }

    public void solve(){
        SolveMethod method = new SolveMethod();


    }
        
    public String traverseMaze(){

        String result = "doesn't have one...yet";
        return result;
    }
}
