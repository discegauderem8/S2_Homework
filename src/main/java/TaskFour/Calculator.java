package TaskFour;

import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class Calculator {
    private static Logger logger = Logger.getLogger("basic logger");

    public static void main(String args[]) throws Exception {

        FileHandler fh = new FileHandler("calclog.xml");
        logger.addHandler(fh);
        XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(xml);
        logger.addHandler(new ConsoleHandler());
        logger.setUseParentHandlers(false);

        System.out.println(calculator());

    }

    private static int calculator() {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение с 2 одноразрядными цифрами: ");
        String str = iScanner.nextLine();
        iScanner.close();

        char delimiter = str.charAt(1); //разделитель
        int a = ((int) (str.charAt(0)));
        int b = ((int) (str.charAt(2)));

        if (delimiter == '-') {
            logger.info("Вычисление успешно завершено"); //LOGGER(и все остальное) ДОЛЖНО БЫТЬ ПЕРЕД RETURN! иначе будет ошибка "недостижимый код"
            return a - b;
        } else if (delimiter == '+') {
            logger.info("Вычисление успешно завершено");
            return a + b;
        } else if (delimiter == '*') {
            logger.info("Вычисление успешно завершено");
            return a * b;
        } else {
            logger.info("Вычисление успешно завершено");
            return a / b;
        }
    }
}

