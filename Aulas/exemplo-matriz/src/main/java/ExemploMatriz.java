import java.util.Scanner;

public class ExemploMatriz {

    public static void showMatrix(int[][] m) {
        for (int line = 0; line < m.length; line++) {
            for (int column = 0;column < m[line].length; column++) {
                System.out.print(m[line][column]+"\t");
            }
            System.out.println();
        }
    }

    public static void showTransposedMatrix(int[][] m) {
        int[][] newMatrix = new int[m[0].length][m.length];
        for (int line = 0; line < m.length; line++) {
            for (int column = 0;column < m[0].length; column++) {
                System.out.println(m[line][column]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] vector = new int[5];

        int[][] matrix = new int[3][4];

        int[][] matrix2 = {{1,2}, {3,4}, {5,6}, {7,8}};

//        for (int line = 0; line < matrix.length; line++) {
//            for (int column = 0;column < matrix[line].length; column++) {
//                System.out.println("Digite o valor de matriz["+line+"]["+column+"]");
//                matrix[line][column] = scan.nextInt();
//            }
//        }

        showTransposedMatrix(matrix2);
        showMatrix(matrix);
        System.out.println();
        showMatrix(matrix2);

    }
}
