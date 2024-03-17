package core;

import java.util.Collection;
import java.util.Scanner;

public class View {
    String filename;
    Collection<String> words;

    public View(String filename) {
        this.filename = filename;
        Repository repository = new Repository(this.filename);
        try {
            this.words = repository.getWords();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        Analyzer analyzer = new Analyzer(this.words);
        while (true) {
            int action = getOperator();
            if (action < 4) {
                analyzer.analyze(action);
                System.out.println("--------------------------------");
            } else if (action == 4) {
                break;
            } else {
                System.out.println("Вы ввели некорректное значение!");
            }
        }
    }

    private int getOperator() {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        sb.append("Введите число от 1 до 4: \n");
        sb.append("1: Посчитать количество слов\n");
        sb.append("2: Найти самое длинное слово\n");
        sb.append("3: Посчитать частоту слов в тексте\n");
        sb.append("4: выход\n");
        System.out.println(sb);
        try {
            int act = Integer.parseInt(in.nextLine());
            return act;
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели не число");
            return getOperator();
        }


    }
}