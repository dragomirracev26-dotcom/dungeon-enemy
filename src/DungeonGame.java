import java.util.Random;
import java.util.Scanner;

public class DungeonGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        Dungeon dungeon = new Dungeon("Dark Cave");

        dungeon.addEnemy(new Enemy("Goblin", 30, 5));
        dungeon.addEnemy(new Enemy("Skeleton", 40, 8));
        dungeon.addEnemy(new Enemy("Dragon", 100, 20));

        int choice;

        do {

            System.out.println("\n=== DUNGEON MENU ===");
            System.out.println("1. Show remaining enemies");
            System.out.println("2. Show all enemies info");
            System.out.println("3. Attack an enemy");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("Remaining enemies: "
                            + dungeon.getRemainingCount());
                    break;

                case 2:
                    dungeon.showAllEnemies();
                    break;

                case 3:
                    System.out.print("Enter enemy name: ");
                    String enemyName = scanner.nextLine();

                    int damage = random.nextInt(16) + 5;

                    System.out.println("Attack damage: " + damage);

                    dungeon.attackEnemy(enemyName, damage);

                    if (dungeon.isCleared()) {
                        System.out.println("Dungeon Cleared!");
                    }

                    break;

                case 4:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option!");
            }

        } while (choice != 4);

        scanner.close();
    }
}