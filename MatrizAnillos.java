import java.util.Random;
import java.util.Scanner;

public class MatrizAnillos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Ingresa la dimensión de la matriz (d): ");
        int d = scanner.nextInt();

        int[][] matriz = new int[d][d];
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < d; j++) {
                matriz[i][j] = random.nextInt(201) - 100;
            }
        }

        System.out.println("Matriz generada:");
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < d; j++) {
                System.out.printf("%4d", matriz[i][j]);
            }
            System.out.println();
        }

        System.out.print("Ingresa el número del anillo (k): ");
        int k = scanner.nextInt();

        if (k < 1 || k > (d + 1) / 2) {
            System.out.println("El anillo k no es válido para la matriz de dimensión " + d);
        } else {
            int suma = 0;

            int inicio = k - 1;
            int fin = d - k;

            for (int j = inicio; j <= fin; j++) {
                suma += matriz[inicio][j];
            }

            for (int i = inicio + 1; i <= fin; i++) {
                suma += matriz[i][fin];
            }

            for (int j = fin - 1; j >= inicio; j--) {
                suma += matriz[fin][j];
            }

            for (int i = fin - 1; i > inicio; i--) {
                suma += matriz[i][inicio];
            }

            System.out.println("La suma de los elementos del anillo " + k + " es: " + suma);
        }

        scanner.close();
    }
}
