package ru.job4j.puzzle;

public class Win {
    public static boolean check_row(int[][] board, int row) {
        boolean rsl = true;
        for (int i = 0; i < board[row].length; i++) {
            if (board[row][i] != 1) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    public static boolean check_clm(int[][] board, int clm) {
        boolean rsl = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i][clm] != 1) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    public static boolean check(int[][] board) {
        boolean rsl = false;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == 1 && (check_row(board, i) || check_clm(board, i))) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }
}
