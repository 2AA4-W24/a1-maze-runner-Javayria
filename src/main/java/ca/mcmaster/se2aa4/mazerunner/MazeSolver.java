package ca.mcmaster.se2aa4.mazerunner;

public class MazeSolver {
    private final Maze maze;
    public String compPath = "";
    private String direction;
    private Position enter;
    private Position current;
    private Position exit;
    

    public MazeSolver(Maze theMaze){
        this.maze = theMaze;
        setInitialDirection(); 
    }

    public void setInitialDirection(){
        if(enter.x == 0){
            this.direction = "E";
        }
        else{
            this.direction = "F";
        }
    }

    public String stepForward(){
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

        String step = "F";
        return step;  
    }

    public void solve(){
        //condition to make the next step
        current = enter;
        String step;
        while(!endReached()){
            step = stepForward();
            this.compPath = this.compPath + step;
        }
    }
        
    public boolean endReached(){
        if((current.x == exit.x) && (current.y == exit.y)){
            return true;
        } 
        else{
            return false;
        }
    }
}
