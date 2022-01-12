package matrix;

import java.util.ArrayList;
import java.util.List;

/*Matrix Layer Rotation
https://www.hackerrank.com/challenges/matrix-rotation-algo/problem?isFullScreen=false
54. Spiral Matrix
https://leetcode.com/problems/spiral-matrix/
https://www.youtube.com/watch?v=acGcfh4JJiI
*/
public class MatrixLayerRotation {
	public static void matrixRotation(List<List<Integer>> matrix, int r) {
		// Write your code here
		int row = matrix.size();
		int col = matrix.get(0).size();

		List<List<Integer>> mat = new ArrayList<>();
		// number of layers
		int layers = Math.min(row, col) / 2;

		// print layer by layer
		for (int i = 0; i < layers; i++) {
			List<Integer> temp = new ArrayList<>();
			// top row(leave col-1 th element i.e the last element)
			for (int j = i; j < col - 1 - i; j++) {
				temp.add(matrix.get(i).get(j));
			}

			// right column(leave row-1 th element i.e the last element)
			for (int j = i; j < row - 1 - i; j++) {
				temp.add(matrix.get(j).get(col - 1 - i));
			}

			// bottom row in rev order(leave 0th element i.e the first element)
			for (int j = col - 1 - i; j > i; j--) {
				temp.add(matrix.get(row - 1 - i).get(j));
			}

			// left col in rev order(leave 0th element i.e the first element)
			for (int j = row - 1 - i; j > i; j--) {
				temp.add(matrix.get(j).get(i));
			}
			mat.add(temp);
		}

		// rotate elements and place it in original matrix
		for (int i = 0; i < layers; i++) {
			List<Integer> layer = mat.get(i);
			int size = layer.size();
			int idx = r % size;

			// assign the new rotated elements
			for (int j = i; j < col - 1 - i; j++) {
				matrix.get(i).set(j, layer.get(idx));
				idx = (idx + 1) % size;
			}

			for (int j = i; j < row - 1 - i; j++) {
				matrix.get(j).set(col - 1 - i, layer.get(idx));
				idx = (idx + 1) % size;
			}

			for (int j = col - 1 - i; j > i; j--) {
				matrix.get(row - 1 - i).set(j, layer.get(idx));
				idx = (idx + 1) % size;
			}

			for (int j = row - 1 - i; j > i; j--) {
				matrix.get(j).set(i, layer.get(idx));
				idx = (idx + 1) % size;
			}
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(matrix.get(i).get(j) + " ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		/*
		   1  2  3  4      2  3  4 10    3  4 10 16    4 10 16 22
    7  8  9 10      1  9 15 16    2 15 21 22    3 21 20 28
    13 14 15 16 ->  7  8 21 22 -> 1  9 20 28 -> 2 15 14 27 ->
    19 20 21 22    13 14 20 28    7  8 14 27    1  9  8 26
    25 26 27 28    19 25 26 27    13 19 25 26   7 13 19 25

    10 16 22 28    16 22 28 27    22 28 27 26    28 27 26 25
     4 20 14 27    10 14  8 26    16  8  9 25    22  9 15 19
     3 21  8 26 ->  4 20  9 25 -> 10 14 15 19 -> 16  8 21 13
     2 15  9 25     3 21 15 19     4 20 21 13    10 14 20  7
     1  7 13 19     2  1  7 13     3  2  1  7     4  3  2  1
		 */

	}

}
