package minimumedit;

import java.util.Scanner;

/**
 *
 * @author Agul Krishnan
 */
public class MinimumEdit {
    
    static int minEdit(String str1, String str2){
        int[][] arr = new int[str1.length() + 1][str2.length() + 1];
        arr[0][0] = 0;
        for(int i = 1; i < arr.length; i++)
            arr[i][0] = i;
        for(int i = 1; i < arr[0].length; i++)
            arr[0][i] = i;
        for(int i = 1; i < arr.length; i++){
            for(int j = 1; j < arr[i].length; j++){
                if(str1.charAt(i - 1) == str2.charAt(j - 1))
                    arr[i][j] = arr[i - 1][j - 1];
                else
                    arr[i][j] = 1 + Math.min(Math.min(arr[i][j - 1], arr[i - 1][j - 1]), arr[i - 1][j]);
            }
        }
        return arr[str1.length()][str2.length()];
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two strings:");
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.printf("The number of steps to make %s to %s is %d.\n", str1, str2, minEdit(str1, str2));
    }
    
}
