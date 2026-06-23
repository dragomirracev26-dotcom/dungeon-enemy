import java.util.ArrayList;

public class Dungeon {

    private String name;
    private ArrayList<Enemy> enemies;

    public Dungeon(String name) {
        this.name = name;
        enemies = new ArrayList<>();
    }

    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    public int getRemainingCount() {

        int count = 0;

        for (Enemy enemy : enemies) {
            if (!enemy.isDefeated()) {
                count++;
            }
        }

        return count;
    }

    public void showAllEnemies() {
        for (Enemy enemy : enemies) {
            enemy.showStatus();
        }
    }

    public Enemy findEnemy(String name) {

        for (Enemy enemy : enemies) {
            if (enemy.getName().equalsIgnoreCase(name)) {
                return enemy;
            }
        }

        return null;
    }

    public void attackEnemy(String name, int damage) {

        Enemy enemy = findEnemy(name);

        if (enemy != null) {
            enemy.receiveDamage(damage);
            System.out.println("You dealt " + damage + " damage to " + enemy.getName());
        } else {
            System.out.println("Enemy not found!");
        }
    }

    public boolean isCleared() {
        return getRemainingCount() == 0;
    }
}