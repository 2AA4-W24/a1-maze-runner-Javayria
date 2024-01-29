package ca.mcmaster.se2aa4.mazerunner;

/*
 * Stores and updates the relative position of an object within the maze  
 */
public class Position{

    /*
     * Position is the combination of a Location object and Direction type
     */
    protected Location coordinates;
    protected Direction direction;
    
    public Position(Location location, Direction dir){
        this.coordinates = location; 
        this.direction = dir;
    }

    public boolean equals(Position position){
        return ((coordinates.equals(position.coordinates)) && (direction == position.direction));
    }
    
    /*
     * Accesses the coordinates of front Cell depending on facing direction
     * @return Location coordinates of front Cell
     */
    protected Location getForwardLocation(){
        if(direction == Direction.NORTH){
            return new Location(coordinates.getNorth());
        }
        else if(direction == Direction.SOUTH){
            return new Location(coordinates.getSouth());
        }
        else if(direction == Direction.EAST){
            return new Location(coordinates.getEast());

        }else{
            return new Location(coordinates.getWest());
        }
    }

    /*
     * Updates position according to given step
     */
    protected void move(String step){

        if(step.equals("F")){
            moveForward();
        }
        else if(step.equals("R")){
            turnRight();
        }
        else if(step.equals("L")){
            turnLeft();
        }
        else if(step.equals("RF")){
            moveRightForward();
        }
        else if(step.equals("RR")){
            turnAround();
        }
    }

    /*
     * Update coordinates to those of front Cell 
     */
    protected void moveForward(){
        this.coordinates = new Location(getForwardLocation());
    }

    /*
     * Update direction to relative rightand moves forward
     */
    protected void moveRightForward(){ 
        turnRight(); 
        moveForward();
    }
     
    /*
     * Update direction to relative right
     */
    protected void turnRight(){
        direction = direction.yourRight();
    }

    /*
     * Update direction to relative left
     */
    protected void turnLeft(){
        direction = direction.yourLeft();
    }

    /*
     * Performs a U-turn and updates to opposite of facing direction
     */
    protected void turnAround(){
        direction = direction.oppositeDirection();
    }

    @Override
    public String toString() {
        return "Position: (" +
         "location=" + coordinates + 
            ", direction= " + direction + 
            ")";
    }
}
