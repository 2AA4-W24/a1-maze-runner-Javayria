package ca.mcmaster.se2aa4.mazerunner;

//placeholder for the Navigate class as of now AND DO THE RIGHT HAND RULE PLS
public class Explorer {
    private Maze maze;
    public Position position;
    public Location location;
    public Direction facingDirection;


    public Explorer(Maze maze){
        this.maze = maze;
        this.position = new Position(maze.WEST_ENTRY, Direction.EAST);
        this.facingDirection = Direction.EAST;
        this.location = position.getLocation();
        }

    public void moveForward(){
        position.updateCoordinates();
        System.out.println("F");
        System.out.println(this.position.toString());
    } 
    
    //please implement better
    public void turnRight(){
        if(facingDirection == Direction.NORTH){
            this.facingDirection = Direction.EAST;
        }
        else if(facingDirection == Direction.SOUTH){
            this.facingDirection = Direction.WEST;
        }
        else if(facingDirection == Direction.WEST){
            this.facingDirection = Direction.NORTH;
        }
        else{
            this.facingDirection = Direction.SOUTH;
        }
        System.out.println("R");
    }

    public void turnLeft(){

        if(facingDirection == Direction.NORTH){
            this.facingDirection = Direction.WEST;
        }
        else if(facingDirection == Direction.SOUTH){
            this.facingDirection = Direction.EAST;
        }
        else if(facingDirection == Direction.WEST){
            this.facingDirection = Direction.SOUTH;
        }
        else{
            this.facingDirection = Direction.NORTH;
        }
        System.out.println("L");
    }
    
}
