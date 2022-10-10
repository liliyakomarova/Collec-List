import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] products = {"Сыр", "Молоко", "Сушки", "Бургер", "Кефир"};
        String[] action = {"1.Добавить", "2.Показать", "3.Удалить", "4.Итого"};
        List<String> list = new LinkedList<>();

        for (int i = 0; i < action.length; i++) {
            System.out.println(action[i]);
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите операцию или введите 'end' для выхода из программы");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            int actionNumber = Integer.parseInt(input) - 1;
            if (actionNumber == 0) {
                System.out.println("Какой продукт Вы хотите добавить? Список: ");
                for (String p : products) {
                    System.out.println(p);
                }
                String inputProduct = scanner.nextLine();
                list.add(inputProduct);
                System.out.println("Общий список продуктов: " + list.size());
            }
            if (actionNumber == 1) {
                System.out.println("Список продуктов: ");
                print(list);
            }
            if (actionNumber == 2) {
                System.out.println("Список продуктов: ");
                print(list);
                System.out.println("Какое количество продукта вы хотите удалить? Введите номер или название продукта");
                String inputRemove = scanner.nextLine();
                list.remove(inputRemove);
                System.out.println("Покупка " + inputRemove + " удалено, список продуктов: ");
                print(list);
                try {
                    int productRemove = Integer.parseInt(inputRemove) - 1;
                    for (int i = 0; i < list.size(); i++) {
                        if (!(list.get(i) != list.get(productRemove))) {
                            String t = list.get(i);
                            list.remove(productRemove);
                            System.out.println("Покупка " + t + " удалено, список продуктов: ");
                        }
                    }
                    print(list);
                } catch (NumberFormatException e) {
                    continue;
                }
            }
            if (actionNumber == 3) {
                System.out.println("Введите текст для поиска: ");
                String inputSearch = scanner.nextLine();
                System.out.println("Найдено: ");
                for (int i = 0; i < list.size(); i++) {
                    String puchaceToLowerCase = list.get(i).toLowerCase();
                    String inputSurchToLowerCase = inputSearch.toLowerCase();
                    if (puchaceToLowerCase.contains(inputSurchToLowerCase)) {
                        System.out.println(puchaceToLowerCase);
                    }
                }
            }
        }
    }
    private static void print(List<String> list) {
        for (var i : list) {
            System.out.println(i);
        }
    }
}