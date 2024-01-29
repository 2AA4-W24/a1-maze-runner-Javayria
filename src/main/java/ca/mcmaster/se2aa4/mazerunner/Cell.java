package ca.mcmaster.se2aa4.mazerunner;

/*
 * Type Cell represented as a WALL or PASS
 */
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
    return(this == cell);
   }

    @Override
    public String toString() { return "" + character; }
    
}
