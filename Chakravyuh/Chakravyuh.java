package Chakravyuh;
import java.util.*;

public class Chakravyuh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    

        int t = sc.nextInt();
    
        while (t-- > 0) {
            int n = sc.nextInt();

            chakravyuh(n);  
        }

        sc.close(); 
    }

    private static void chakravyuh(int n) {
        int[][] matrix = new int[n][n];
        List<int[]> powerPoints = new ArrayList<>();    
        powerPoints.add(new int[]{0, 0});

        int startRow = 0;
        int startCol = 0;
        int endRow = n-1;
        int endCol = n-1;
        int count = 1;  

        while(startCol <= endCol && startRow <= endRow){
            for(int i=startCol; i<=endCol; i++)
               matrix[startRow][i] = count++;
            startRow++;

            for(int i=startRow; i<=endRow; i++)
                matrix[i][endCol] = count++;
            endCol--;

           
            for(int i=endCol; i>=startCol; i--)
                matrix[endRow][i] = count++;
            endRow--;
            

            for(int i=endRow; i>=startRow; i--)
                matrix[i][startCol] = count++;
            startCol++;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(matrix[i][j] + " ");
                if (matrix[i][j] % 11 == 0){
                    powerPoints.add(new int[]{i, j});
                }
            }    
            System.out.println();
        }

        System.out.println("\nTotal Power points: " + powerPoints.size());    

        for(int[] point : powerPoints){
            System.out.println(point[0] + ", " + point[1]);
        }   

        System.out.println();
    }
}

