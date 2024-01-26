package ca.mcmaster.se2aa4.mazerunner;

public class Position{
    private Location coordinates;
    private Direction direction;
    
    public Position(Location location){
        this.coordinates = location; 
        this.direction = Direction.NORTH;//PLACEHOLDERRRRRR
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
    
    @Override
    public String toString() {
        return "Position: (" +
         "location=" + coordinates + 
            ", direction= " + direction + 
            ")";
    }
}
