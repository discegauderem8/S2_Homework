package TaskTwo;

import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class BubbleSort {
    private static Logger logger = Logger.getLogger("basic logger");

    public static void main(String args[]) throws Exception {

        FileHandler fh = new FileHandler("log.xml");
        logger.addHandler(fh);
        XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(xml);
        logger.setUseParentHandlers(false);


        int[] arr = {1, 3, 5, 7, 2, 4};

        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();

        int temp;
        int count = 1;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    temp = arr[j+1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }

                logger.info("Пройден " + count + " этап сортировки");
                count++;
            }
        }

        for (int item: arr) {
            System.out.print(item + " ");
        }

    }
}
