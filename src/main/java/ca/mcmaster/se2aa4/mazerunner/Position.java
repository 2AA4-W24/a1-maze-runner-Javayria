package ca.mcmaster.se2aa4.mazerunner;

public class Position{
    private Location coordinates;
    private Direction direction;
    
    public Position(Location location, Direction dir){
        this.coordinates = location; 
        this.direction = dir;
    }

    public boolean equals(Position position){
        return ((this.coordinates == position.coordinates) && (this.direction == position.direction));
    }
    
    public Direction getDirection(){
        return direction;
    }

    public Location getLocation(){
        return coordinates;
    }

    public void updateCoordinates(){
        Location newCoords = getForwardLocation();
        this.coordinates.x = newCoords.x;
        this.coordinates.y = newCoords.y;
    }

    public Location getForwardLocation(){
        Location next;
        if(this.direction == Direction.NORTH){
            next = coordinates.getNorth();
        }
        else if(this.direction == Direction.SOUTH){
            next = coordinates.getSouth();
        }
        else if(this.direction == Direction.EAST){
            next = coordinates.getEast();
        }else{
            next = coordinates.getWest();
        }
        return next;
       
    }

    
    @Override
    public String toString() {
        return "Position: (" +
         "location=" + coordinates + 
            ", direction= " + direction + 
            ")";
    }
}
