package ca.mcmaster.se2aa4.mazerunner;

public class Position{

    protected Location coordinates;
    protected Direction direction;
    
    public Position(Location location, Direction dir){
        this.coordinates = location; 
        this.direction = dir;
    }

    public boolean equals(Position position){
        return ((coordinates.equals(position.coordinates)) && (direction == position.direction));
    }
    
    protected Location getForwardLocation(){
        Location next;
        if(direction == Direction.NORTH){
            next = coordinates.getNorth();
        }
        else if(direction == Direction.SOUTH){
            next = coordinates.getSouth();
        }
        else if(direction == Direction.EAST){
            next = coordinates.getEast();
        }else{
            next = coordinates.getWest();
        }
        
        return next;   
    }

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

    protected void moveForward(){
        Location newCoords = getForwardLocation();
        this.coordinates.x = newCoords.x;
        this.coordinates.y = newCoords.y;
    }

    protected void moveRightForward(){ //PERHAPS ADD LEFT FORWARD
        turnRight(); 
        moveForward();
    }
     
    protected void turnRight(){
        direction = direction.yourRight();
    }

    protected void turnLeft(){
        direction = direction.yourLeft();
    }

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
