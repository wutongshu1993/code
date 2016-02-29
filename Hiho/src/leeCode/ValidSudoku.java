package leeCode;

import java.util.Arrays;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		int len = board.length;
		// 比较行是否有相同的
		for (int i = 0; i < len; i++) {
			char[] temp = new char[len];
			for (int j = 0; j < len; j++) {
				temp[j] = board[i][j];
			}
			if (hasEqual(temp))
				return false;
		}
		// 比较列是否有相同的
		for (int i = 0; i < len; i++) {
			char[] temp = new char[len];
			for (int j = 0; j < len; j++) {
				temp[j] = board[j][i];
			}
			if (hasEqual(temp))
				return false;
		}
		// 判断九宫格内是否有相同的
		for (int n = 0; n < len; n = n + 3) {
			for (int m = 0; m < len; m = m + 3) {
				char[] temp = new char[len];
				int k = 0;
				for (int i = n; i < n + 3; i++) {
					for (int j = m; j < m + 3; j++) {
						temp[k++] = board[i][j];
					}
					
				}
				if (hasEqual(temp))
					return false;
			}
		}
		return true;
	}

	public boolean hasEqual(char[] c) {
		Arrays.sort(c);
		for (int i = 0; i < c.length - 1; i++) {
			if (c[i] == c[i + 1] && c[i] != '.') {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args){
		char[][] cs = new char[][]{{'.','8','7','6','5','4','3','2','1'},
				{'2','.','.','.','.','.','.','.','.'},
				{'3','.','.','.','.','.','.','.','.'},
				{'4','.','.','.','.','.','.','.','.'},
				{'5','.','.','.','.','.','.','.','.'},
				{'6','.','.','.','.','.','.','.','.'},
				{'7','.','.','.','.','.','.','.','.'},
				{'8','.','.','.','.','.','.','.','.'},
				{'9','.','.','.','.','.','.','.','.'},
				};
		System.out.println(new ValidSudoku().isValidSudoku(cs));
	}
}

