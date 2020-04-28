package JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = getDimension(scanner.nextLine());
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] galaxy = new int[rows][cols];

        int starValue = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                galaxy[row][col] = starValue++;
            }
        }

        String command = scanner.nextLine();
        long sumOfStars = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] playerCoordinates = getDimension(command);
            int[] evilCoordinates = getDimension(scanner.nextLine());
            int evilRow = evilCoordinates[0];
            int evilCol = evilCoordinates[1];

            while (evilRow >= 0 && evilCol >= 0) {
                if (evilRow < galaxy.length && evilCol < galaxy[0].length) {
                    galaxy[evilRow][evilCol] = 0;
                }
                evilRow--;
                evilCol--;
            }

            int playerRow = playerCoordinates[0];
            int playerCol = playerCoordinates[1];

            while (playerRow >= 0 && playerCol < galaxy[0].length) {
                if (playerRow < galaxy.length && playerCol >= 0) {
                    sumOfStars += galaxy[playerRow][playerCol];
                }

                playerCol++;
                playerRow--;
            }

            command = scanner.nextLine();
        }

        System.out.println(sumOfStars);

    }

    private static int[] getDimension(String s) {
        return Arrays.stream(s.split("\\s")).mapToInt(Integer::parseInt).toArray();
    }
}
