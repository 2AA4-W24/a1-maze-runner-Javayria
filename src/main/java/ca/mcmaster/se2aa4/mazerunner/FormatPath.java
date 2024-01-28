package ca.mcmaster.se2aa4.mazerunner;

public class FormatPath { 

    public static String readable(String str){
        StringBuilder result = new StringBuilder(str);
        char[] array = str.toCharArray();

        for (int i = 0; i < array.length; i++){
            if(array[i] == 'F'){
                result.insert(i+1, " ");
            }
        }
        return result.toString();
    }

    public static String compact(String str){
        char[] array = str.toCharArray();
        String result = "";
        int num = 1; //to include the first character
        char prev =  array[0];

        for (int i = 1; i < array.length; i++){
            char curr = array[i];
            if(prev == curr){
                num++;
            } else if (num == 1){
                result += prev;
            } else {
                result += Integer.toString(num);
                result += prev;
                num = 1;
            }
            prev = curr;
        }

        //last iteration
        if(num>1){
            result += Integer.toString(num);
        }
        result += prev;
        return readable(result);
    }

    public static String deCompact(String str){
        String result = "";
        int expand = 0; //accounts for numbers such as 100  

        for (char i: str.toCharArray()) {
            if(Character.isDigit(i)){
                expand = 10*expand*Character.getNumericValue(i);
            }
            else{
                while(expand > 0){
                    result += i;
                    expand--;
                }
                expand = 0;
            }
        }
        return result;
    }
}
