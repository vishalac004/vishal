public class TicTacToe {

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        initializeBoard(board);

        // Game loop
        boolean gameOver = false;
        char currentPlayer = 'X';
        while (!gameOver) {
            printBoard(board);
            makeMove(board, currentPlayer);

            // Check for winner or tie
            gameOver = checkWinner(board) || isBoardFull(board);

            // Switch player turn
            currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
        }

        if (checkWinner(board)) {
            System.out.println("Congratulations! Player " + currentPlayer + " wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    private static void initializeBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '-';
            }
        }
    }

    private static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void makeMove(char[][] board, char player) {
        int row, col;
        do {
            System.out.println("Player " + player + ", enter your move (row, column): ");
            row = scanner.nextInt() - 1; // Adjust for 0-based indexing
            col = scanner.nextInt() - 1;

            if (row < 0 || row >= board.length || col < 0 || col >= board[row].length || board[row][col] != '-') {
                System.out.println("Invalid move. Please try again.");
            }
        } while (row < 0 || row >= board.length || col < 0 || col >= board[row].length || board[row][col] != '-');

        board[row][col] = player;
    }

    private static boolean checkWinner(char[][] board) {
        // Check rows
        for (int i = 0; i < board.length; i++) {
            char symbol = board[i][0];
            if (symbol != '-' && symbol == board[i][1] && symbol == board[i][2]) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < board[0].length; i++) {
            char symbol = board[0][i];
            if (symbol != '-' && symbol == board[1][i] && symbol == board[2][i]) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] != '-' && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            return true;
        }
        if (board[0][2] != '-' && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
            return true;
        }

        return false;
    }

    private static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
