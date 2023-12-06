import java.util.Scanner;
import java.util.Random;

public class Player {
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    // Getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    // Additional functional methods
    public void increaseScore(int points) {
        this.score += points;
    }

    public void displayPlayerInfo() {
        System.out.println("Player: " + name + ", Score: " + score);
    }
}

public class DiceGame {
    private Player[] players;
    private Scanner scanner;
    private Random random;

    public DiceGame() {
        players = new Player[2];
        scanner = new Scanner(System.in);
        random = new Random();
    }

    public void startGame() {
        createPlayers();
        playGame();
        displayFinalScores();
        scanner.close();
    }

    private void createPlayers() {
        for (int i = 0; i < players.length; i++) {
            System.out.print("Enter player " + (i + 1) + " name: ");
            String playerName = scanner.next();
            players[i] = new Player(playerName);
        }
    }

    private void playGame() {
        boolean gameOver = false;
        while (!gameOver) {
            for (Player player : players) {
                int points = random.nextInt(11); // Generate a random score between 0 and 10
                player.increaseScore(points);
                player.displayPlayerInfo();

                System.out.print("Continue? (yes/no): ");
                String choice = scanner.next();
                if (choice.equalsIgnoreCase("no")) {
                    gameOver = true;
                    break;
                }
            }
        }
    }

    private void displayFinalScores() {
        for (Player player : players) {
            player.displayPlayerInfo();
        }
    }

    public static void main(String[] args) {
        DiceGame game = new DiceGame();
        game.startGame();
    }
}