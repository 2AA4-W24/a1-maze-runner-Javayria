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

    public static String deCompact(String str){
        StringBuilder result = new StringBuilder();
        int expand = 0; //accounts for numbers such as 100  

        for (char i: str.toCharArray()) {
            if(Character.isDigit(i)){
                expand = 10 * expand + Character.getNumericValue(i);
            }
            else{ 
                while(expand > 0){
                    result.append(i);
                    expand--;
                }
            }
        }
        return result.toString();
    }
}
