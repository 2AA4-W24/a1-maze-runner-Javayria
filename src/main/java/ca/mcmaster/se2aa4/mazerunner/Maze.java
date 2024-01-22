package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Maze {
    private char[][] maze;
    private int h;
    private int w;
    private int entry_i = 0;
    private int entry_j;
    private int exit_i = w-1;
    private int exit_j;
   

    public Maze(String inputFile) {
        try (BufferedReader buff = new BufferedReader(new FileReader(inputFile))) {

            int rows = 0;
            int columns = 0;
            String line;

            //get the rows (height) and columns (width)
            while ((line = buff.readLine()) != null) {
                rows++;
                columns = Math.max(columns, line.length());
            }

            char[][] m = new char[rows][columns];


            // go back to the beginning of the file
            buff.close();
            BufferedReader file = new BufferedReader(new FileReader(inputFile));

            for(int i = 0; i < rows; i++){

              //loop through the columns of each row
              for(int j = 0; j < columns; j++){
                 m[i][j] = (char) file.read();
              }

              //ignore any extra characters 
              file.readLine();
           }
           file.close();

           this.maze = m;
           this.h = rows;
           this.w = columns;

        } catch (FileNotFoundException e){
            System.out.println("Error with reading file.");
        } catch (IOException e){
            System.out.println("Error with reading file.");
        }
    }

    public void printMaze(){
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print((char)maze[i][j]);
            }
            System.out.print("\n");
        }
    }

 



}