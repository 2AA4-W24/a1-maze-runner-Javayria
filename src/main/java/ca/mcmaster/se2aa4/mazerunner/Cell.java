package ca.mcmaster.se2aa4.mazerunner;

//represents what type of cell it is within the maze grid
public enum Cell {
    WALL('#'), PASS(' ');

    private final char character;

    Cell(char character) {
        this.character = character;
    }

    public char getCharacter(){
        return character;
    }

    public boolean equals(Cell cell){
        return(character == cell.getCharacter());
   }

    @Override
    public String toString() { return "" + character; }
    
}
