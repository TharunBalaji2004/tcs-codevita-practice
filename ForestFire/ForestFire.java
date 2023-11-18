package ForestFire;

import java.util.*;

class ForestFire {
    public static void countTime(char mat[][], int temp[][], int n, int row, int col, int count) {
        if ((row >= n) || (row < 0) || (col < 0) || (col >= n) || (mat[row][col] == 'W')) return;
        if (temp[row][col] != 0 && count >= temp[row][col]) return;
        temp[row][col] = count;
        countTime(mat, temp, n, row + 1, col, count + 1);
        countTime(mat, temp, n, row - 1, col, count + 1);
        countTime(mat, temp, n, row, col + 1, count + 1);
        countTime(mat, temp, n, row, col - 1, count + 1);
        countTime(mat, temp, n, row + 1, col + 1, count + 1);
        countTime(mat, temp, n, row + 1, col - 1, count + 1);
        countTime(mat, temp, n, row - 1, col + 1, count + 1);
        countTime(mat, temp, n, row - 1, col - 1, count + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        char[][] m = new char[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                m[i][j] = sc.next().charAt(0);
            }
        }
        int[][] l = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                l[i][j] = 0;
            }
        }
        countTime(m, l, r, a - 1, b - 1, 1);
        int mm = -1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (mm < l[i][j]) {
                    mm = l[i][j];
                }
            }
        }
        System.out.println(mm);
        sc.close();
    }
}