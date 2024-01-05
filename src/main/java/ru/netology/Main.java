package ru.netology;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        Scanner scanner = new Scanner(System.in);
        Optional<Integer> size = Optional.empty();
        Optional<Integer> max = Optional.empty();
        Optional<Integer> f = Optional.empty();
        List<Integer> list = new ArrayList<>();
        List<Integer> resultList;
        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");
        while (true) {
            System.out.println("Введите размер списка: ");
            try {
                size = Optional.ofNullable(Integer.parseInt(scanner.nextLine()));
            } catch (Exception e) {
                logger.log("Введено некорретное значение");
            }
            if (size.isPresent() && size.get() <= 0) {
                logger.log("Значение должно быть больше 0");
            } else if (!size.isEmpty()) {
                break;
            }
        }
        while (true) {
            System.out.println("Введите верхнюю границу для значений: ");
            try {
                max = Optional.ofNullable(Integer.parseInt(scanner.nextLine()));
            } catch (Exception e) {
                logger.log("Введено некорретное значение");
            }
            if (max.isPresent() && max.get() <= 0) {
                logger.log("Значение должно быть больше 0");
            } else if (!max.isEmpty()) {
                break;
            }
        }
        logger.log("Создаём и наполняем список");
        Random random = new Random();
        for (int i = 0; i < size.get(); i++) {
            list.add(random.nextInt(max.get()));
        }
        System.out.print("Вот случайный список: ");
        list.stream().forEach(x -> System.out.print(x + " "));
        System.out.println();
        logger.log("Просим пользователя ввести входные данные для фильтрации");
        while (true) {
            System.out.println("Введите порог для фильтра: ");
            try {
                f = Optional.ofNullable(Integer.parseInt(scanner.nextLine()));
            } catch (Exception e) {
                logger.log("Введено некорретное значение");
            }
            if (f.isPresent() && f.get() <= 0) {
                logger.log("Значение должно быть больше 0");
            } else if (!f.isEmpty()) {
                break;
            }
        }
        logger.log("Запускаем фильтрацию");
        Filter filter = new Filter(f.get());
        logger.log("Выводим результат на экран");
        resultList = filter.filterOut(list);
        System.out.print("Отфильтрованный список: ");
        resultList.stream().forEach(x -> System.out.print(x + " "));
        logger.log("Завершаем программу");
    }
}