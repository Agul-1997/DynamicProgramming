package wildcardpatternmatching;

import java.util.Scanner;

/**
 *
 * @author Agul Krishnan
 */
public class WildCardPatternMatching {
    
    static boolean wildCard(String s, String p){
        boolean[][] arr = new boolean[s.length() + 1][p.length() + 1];
        arr[0][0] = true;
        for(int i = 1; i < arr[0].length; i++){
            if(p.charAt(i - 1) == '*')
                arr[0][i] = arr[0][i - 1];
        }
        for(int i = 1; i < arr.length; i++){
            for(int j = 1; j < arr[i].length; j++){
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
                    arr[i][j] = arr[i - 1][j - 1];
                else if(p.charAt(j - 1) == '*')
                    arr[i][j] = arr[i - 1][j] || arr[i][j - 1];
            }
        }
        return arr[s.length()][p.length()];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the pattern:");
        String p = sc.next();
        System.out.println("Enter the string:");
        String s = sc.next();
        if(wildCard(s, p))
            System.out.println("The string and the pattern match.");
        else
            System.out.println("The string and the pattern does not match.");
    }
    
}
