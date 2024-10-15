import java.util.Scanner;
public class Acronym{
    public static void main(String [] args){
        Scanner s = new Scanner(System.in);
        String word = s.nextLine();
        System.out.println(acronym(word));
    }

    public static String acronym(String s){
        String [] arr = s.split("[ -]");
        StringBuilder result = new StringBuilder();
        for(String str : arr){
            result.append(Character.toUpperCase(str.charAt(0)));
        }
        return result.toString();
    }
}