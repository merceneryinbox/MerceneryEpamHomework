package homework.epam.mod1;
//Задание 5. Двумерные массивы
//        Получить матрицу:

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 */
public class EpamSE01HWTask4Matrix2D {
	public static void main(String[] args) {
		System.out.println("Input 2Dimensions Matrix size: \n");
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int     size     = Integer.parseInt(br.readLine());
			int[][] matrix2D = new int[size][size];
			m2DFullFiller(matrix2D, size);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * @param inputAr
	 * @param size
	 */
	public static void m2DFullFiller(int[][] inputAr, int size) {
		int[][] resultAr = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i + j == size - 1 | i == j) {
					System.out.print(1 + " ");
				} else {
					System.out.print(0 + " ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}
