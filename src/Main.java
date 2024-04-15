import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner;
    static DinnerConstructor dinnerConstructor;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        dinnerConstructor = new DinnerConstructor();


        while(true) {
            printMenu();
            String command = scanner.nextLine();
            switch (command) {
                case "1":
                    addNewDinner();
                    break;
                case "2":
                    generateList();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Введена неверная команда");
            }
        }

    }

    private static void printMenu() {
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать списоб блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDinner() {
        System.out.println("Введите тип блюда:");

        String category = scanner.nextLine();

        System.out.println("Введите название блюда:");
        String dish = scanner.nextLine();
        dinnerConstructor.setDinner(category, dish);
    }

    public static void generateList() {
        System.out.println("Введите количество комбо, которое необходимо сгенерировать");
        int count = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Вводите типы блюд, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");

        ArrayList<String> dishTypesList = new ArrayList<>();
        String dishItem = scanner.nextLine();

        while (!dishItem.isEmpty()) {
            if (dinnerConstructor.hasCategory(dishItem)) {
                dishTypesList.add(dishItem);
            } else {
                System.out.println("Вы ввели несуществующий тип блюда");
            }
            dishItem = scanner.nextLine();
        }

        //проходимся циклом, по количеству комбо который необходимо сгенерировать
        for(int i = 0; i < count; i++) {
            System.out.println("Комбо " + (i + 1));
            System.out.println(dinnerConstructor.getDinnerCombo(dishTypesList));
        }
    }
}