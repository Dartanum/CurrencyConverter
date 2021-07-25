import java.util.Scanner;

public class Tests {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите количество дисков: ");
        int n = input.nextInt();

        // Найти решение с помощью рекурсии
        System.out.println("Алгоритм:");
        moveDisks(n, 'A', 'B', 'C');
    }

    /**
     * Находит решение для перемещения n дисков
     * с fromTower на toTower с помощью auxTower
     */
    public static void moveDisks(int n, char fromTower,
                                 char toTower, char auxTower) {
        if (n == 1) // простой случай
            System.out.println("Переместите диск " + n + " с " +
                    fromTower + " на " + toTower);
        else {
            moveDisks(n - 1, fromTower, auxTower, toTower);
            System.out.println("Переместите диск " + n + " с " +
                    fromTower + " на " + toTower);
            moveDisks(n - 1, auxTower, toTower, fromTower);
        }
    }
}
