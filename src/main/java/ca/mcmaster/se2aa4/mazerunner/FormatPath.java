package ca.mcmaster.se2aa4.mazerunner;

public class FormatPath { 

    public static String compact(String str){
        StringBuilder result = new StringBuilder();
        char[] array = str.toCharArray();

        int num = 1; //to include the first character
        char prev =  array[0];

        for (int i = 1; i < array.length; i++){
            char curr = array[i];
            if(prev == curr){
                num++;
            } else {
                if(num == 1){
                    result.append(prev).append(' ');
                }
                else{
                    result.append(num).append(prev).append(' ');
                }
                num = 1;
            }
            prev = curr;

        }
        //last iteration
        if(num>1){
            result.append(num);
        }
        return result.append(prev).toString();
    }

    public static String deCompact(String path){
        boolean toCompress = false;
        for (char i : path.toCharArray()) {
            if (Character.isDigit(i)) {
               toCompress = true;
            }
        }
        if(toCompress){
            return processPath(path);
        } else{
            return path;
        }
    }

    public static String processPath(String str){
        StringBuilder result = new StringBuilder();  

        for (int i = 0; i < str.length(); i++) {
            char step = str.charAt(i);
            if(Character.isLetter(step)){
                result.append(step);
            }
            else{ 
                int expand = Character.getNumericValue(step);; //starts the new decompression
                char prev = str.charAt(i+1);
                while(expand > 1){
                    result.append(prev);
                    expand--;
                }
            }
        }

        return result.toString();
    }
}
