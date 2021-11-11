import java.util.*;
import java.io.*;

public class Battleship {
    public static void main(String[] args) {

        System.out.println();
        System.out.println("Welcome to Battleship!");

        Scanner scanner = new Scanner(System.in);

        char[][] player1Grid = playerSetup(scanner, 1);
        printBattleShip(player1Grid);
        for (int i = 0; i < 101; i++)
        {
            System.out.println();
        }

        char[][] player2Grid = playerSetup(scanner, 2);
        printBattleShip(player2Grid);
        for (int i = 0; i < 101; i++)
        {
            System.out.println();
        }

        char[][] player1LocationBoard = createBlankGrid();
        char[][] player2LocationBoard = createBlankGrid();

        int playerTurn = 1;
        int waitingPlayer = 2;
        boolean gameOver = false;
        char[][] targetBoard = player2Grid;
        char[][] referenceBoard = player1LocationBoard;

        do{
            System.out.println();
            System.out.println("Player " + playerTurn + ", enter hit row/column:");
            int row = scanner.nextInt();
            int column = scanner.nextInt();

            if (row < 0 || row > 4 || column < 0 || column > 4) {
                System.out.println("Invalid coordinates. Choose different coordinates.");
                continue;
            }  else if (targetBoard[row][column] == 'O' || targetBoard[row][column] == 'X') {
                System.out.println("You already fired on this spot. Choose different coordinates.");
                continue;
            }  else if (targetBoard[row][column] == '@') {
                System.out.println("PLAYER " + playerTurn + " HIT PLAYER " + waitingPlayer + "'s SHIP!");
                targetBoard[row][column] = 'X';
                referenceBoard[row][column] = 'X';
                printBattleShip(referenceBoard);
            } else if (targetBoard[row][column] == '-') {
                System.out.println("PLAYER " + playerTurn + " MISSED!");
                referenceBoard[row][column] = 'O';
                targetBoard[row][column] = 'O';
                printBattleShip(referenceBoard);
            }

            gameOver = checkGameEnd(targetBoard, gameOver);

            if(gameOver == false) {
                if (playerTurn == 1) {
                    waitingPlayer = 1;
                    playerTurn = 2;
                    targetBoard = player1Grid;
                    referenceBoard = player2LocationBoard;
                }else if (playerTurn == 2) {
                    waitingPlayer = 2;
                    playerTurn = 1;
                    targetBoard = player2Grid;
                    referenceBoard = player1LocationBoard;
                }
            }

        } while (gameOver == false);
        System.out.println("PLAYER " + playerTurn + " WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!");
        System.out.println("Final boards:");
        printBattleShip(player1Grid);
        printBattleShip(player2Grid);
        return;
    }

    private static boolean checkGameEnd(char[][] board, boolean gameOver) {
        gameOver = true;
        for(int i = 0; i < board[0].length; i++) {
            for(int j = 0; j < board[1].length; j++) {
                {
                    if(board[i][j] == '@'){
                        gameOver = false;
                    }
                }
            }
        }
        return gameOver;
    }

    private static char[][] createBlankGrid() {

        char[][] blankGrid = new char[5][5];
        for(int i = 0; i < blankGrid[0].length; i++) {
            for(int j = 0; j < blankGrid[1].length; j++) {
                {
                    blankGrid[i][j] = '-';
                }
            }
        }
        return blankGrid;
    }

    private static char[][] playerSetup(Scanner scanner, int playerNumber) {

        char[][] playerGrid = createBlankGrid();
        System.out.println();
        System.out.println(("PLAYER " + playerNumber + ", ENTER YOUR SHIPS' COORDINATES"));
        {
            for(int i = 0; i < 5; i++)
            {
                boolean coordinateEntered = false;

                while(coordinateEntered == false)
                {
                    System.out.println("Enter ship " + (i+1) + " location:");
                    int row = scanner.nextInt();
                    int column = scanner.nextInt();

                    if (row < 0 || row > 4 || column < 0 || column > 4) {
                        System.out.println("Invalid coordinates. Choose different coordinates.");
                        continue;
                    } else if (playerGrid[row][column] == '@') {
                        System.out.println("You already have a ship there. Choose different coordinates.");
                        continue;
                    } else {
                        playerGrid[row][column] = '@';
                        coordinateEntered = true;             
                    }
                }   
            }
        }
        return playerGrid;
    }

    // Use this method to print game boards to the console.
	private static void printBattleShip(char[][] player) {
		System.out.print("  ");
		for (int row = -1; row < 5; row++) {
			if (row > -1) {
				System.out.print(row + " ");
			}
			for (int column = 0; column < 5; column++) {
				if (row == -1) {
					System.out.print(column + " ");
				} else {
					System.out.print(player[row][column] + " ");
				}
			}
			System.out.println("");
		}
    }
}
