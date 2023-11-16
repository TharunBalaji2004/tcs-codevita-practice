
import java.util.*;

public class BrideHunting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] matrix = new int[rows][cols];

        for (int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        sc.close();

        findBride(matrix, rows, cols);
    }

    private static void findBride(int[][] matrix, int rows, int cols) {
        int maxi = 0;
        int[] selectedBrides = new int[2];
        selectedBrides[0] = 99999;
        selectedBrides[1] = 99999;

        List<int[]> directions = new ArrayList<>();
        directions.add(new int[]{0,-1});
        directions.add(new int[]{0,1});
        directions.add(new int[]{1,0});
        directions.add(new int[]{-1,0});
        directions.add(new int[]{-1,-1});
        directions.add(new int[]{-1,1});
        directions.add(new int[]{1,1});
        directions.add(new int[]{1,-1});

        for (int i=0; i< rows;i++) {
            for (int j=0;j<cols;j++) {
                if (i == 0 && j ==0) continue;
                else if (matrix[i][j] == 1){
                    int qualities = 0;
                    for (int[] d: directions) {
                        if (valid(i + d[0], j + d[1], matrix, rows, cols)) qualities++;
                    }
                    
                    if (qualities > maxi) {
                        maxi = qualities;
                        selectedBrides[0] = i + 1;
                        selectedBrides[1] = j + 1;
                    } else if (qualities == maxi) {
                        int currdist = distance(selectedBrides[0], selectedBrides[1]);
                        int newdist = distance(i, j);

                        if (newdist < currdist) {
                            selectedBrides[0] = i;
                            selectedBrides[1] = j; 
                        }
                    }
                }
            }
        }

        System.out.println(selectedBrides[0] + " " + selectedBrides[1] + " " + maxi);
    }

    private static boolean valid(int i, int j, int[][] matrix, int rows, int cols) {
        if ((i >= 0 && i < rows) && (j >= 0 && j < cols)) {
            if (matrix[i][j] == 1) return true;
        }

        return false;
    }

    private static int distance(int x1, int y1) {
        return (int)Math.sqrt(x1*x1 + y1*y1);
    }
}
