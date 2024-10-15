import java.util.Scanner;
public class Panagram{

    public static void main(String [] args){
        Scanner s = new Scanner(System.in);
        String sentence = s.nextLine();
        System.out.println(isPanagram(sentence));
    }
    public static boolean isPanagram(String sentence){
        boolean [] flag = new boolean[26];
        for(char ch : sentence.toCharArray()){
            if(Character.isLetter(ch)){
                ch = Character.toLowerCase(ch);
                flag[ch - 'a'] = true;
            }
        }
    
        for(boolean b : flag){
            if(!b)  return false;
        }
        return true;
    }
}
