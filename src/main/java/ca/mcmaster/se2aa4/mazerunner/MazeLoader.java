package ca.mcmaster.se2aa4.mazerunner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MazeLoader {   
    private List<String> lines = new ArrayList<>();
    private String input;
  
    public Cell[][] generate(String inputFile) {
        this.input = inputFile;
        readFile();
        //fil by Cell[columns][rows]
        Cell[][] theGrid = new Cell[lines.size()][lines.get(0).length()];
        fillCells(theGrid);
        return theGrid;
    }

    private void readFile(){
        try (BufferedReader buff = new BufferedReader(new FileReader(input))) {
            String line;
            while ((line = buff.readLine()) != null) {
                this.lines.add(line);
            }
            
        } catch (FileNotFoundException e){
            System.out.println("Error with reading file.");
        } catch (IOException e){
            System.out.println("Error with reading file.");
        }
    }

    private void fillCells(Cell[][] grid){
        
        for(int i = 0; i < grid.length; i++){  //loop through rows
            String line = lines.get(i);
            
            if(line.isEmpty()){
                line = new String(new char[grid[0].length]).replace('\0', ' ');
            }

            for(int j = 0; j < grid[0].length; j++){ //loop through columns
                try{
                    char symbol = line.charAt(j);
                    if(symbol == '#'){
                        grid[i][j] = Cell.WALL;
                        }
                    else{
                        grid[i][j] = Cell.PASS;
                    }
                } catch (Exception e){
                    grid[i][j] = Cell.PASS;
                } 
            }
        }
    }
}
