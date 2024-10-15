import java.util.Scanner;
public class SumOfMultiples{
    public static void main(String [] args){
        Scanner s = new Scanner(System.in);
        int level = s.nextInt();
        int numberOfMagicalItems = s.nextInt();
        int [] magicalItems = new int [numberOfMagicalItems];
        for(int i = 0; i < numberOfMagicalItems; i++){
            magicalItems[i] = s.nextInt();
        }
        System.out.println(sumOfMultiples(level, magicalItems));
    }

    public static int sumOfMultiples(int level, int [] magicalItems){
        int result = 0;
        for(int i = 1; i < level; i++){
            boolean flag = false;
            for(int item : magicalItems){
                if(i % item == 0){   
                    flag = true;
                    break;
                }
            }
            if(flag)    result += i;
        }
        return result;
    }
} 