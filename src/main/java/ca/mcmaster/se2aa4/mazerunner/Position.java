package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Position{
    private static final Logger logger = LogManager.getLogger();

    private Location coordinates;
    private Direction direction;
    
    public Position(Location location, Direction dir){
        this.coordinates = location; 
        this.direction = dir;
    }

    public boolean equals(Position position){
        return ((coordinates.equals(position.coordinates)) && (direction == position.direction));
    }
    
    public Direction getDirection(){
        return direction;
    }

    public Location getLocation(){
        return coordinates;
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

    public String moveForward(){
        Location newCoords = getForwardLocation();
        this.coordinates.x = newCoords.x;
        this.coordinates.y = newCoords.y;
        return "F";
    }

    public String moveRightForward(){
        turnRight();
        moveForward();
        return "RF";
    }

    public String turnRight(){
        direction = direction.yourRight();
        return "R";
    }

    public String turnLeft(){
        direction = direction.yourLeft();
        return "L";
    }

    public String turnAround(){
        direction = direction.oppositeDirection();
        return "RR";
    }

    @Override
    public String toString() {
        return "Position: (" +
         "location=" + coordinates + 
            ", direction= " + direction + 
            ")";
    }
}
