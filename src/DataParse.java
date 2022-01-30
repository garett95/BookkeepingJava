import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class DataParse {

    static String[] getLines (List<String> reportsList, int numOfLine) {
        return reportsList.get(numOfLine).split(",");
    }

    static String[] getSumOfGoods (List<String> reportsList, int numOfLine, String category) {

        int sum = 0;
        String name = "";

        String[] arr = reportsList.get(numOfLine).split(",");
        ItemInfo.name = arr[0];
        ItemInfo.isExpense = arr[1];
        ItemInfo.quantity = Integer.parseInt(arr[2]);
        ItemInfo.sumOfOne = Integer.parseInt(arr[3]);

        if (ItemInfo.isExpense.equals(category)) {
            sum += ItemInfo.quantity * ItemInfo.sumOfOne;
            name = ItemInfo.name;
        }
        return new String[] {String.valueOf(sum), name};
    }

    static List<String> getAllLines(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Невозможно прочитать файл " + getFileName(path) + " с отчетом. Возможно, файл не находится в  директории " + getDirectoryName(path));
            return Collections.EMPTY_LIST;
        }
    }

    static String readFile(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            e.printStackTrace();
            return "Невозможно прочитать файл " + getFileName(path) + " с отчетом. Возможно, файл не находится в  директории " + getDirectoryName(path);
        }
    }

    static String getFileName(String path) {
        return path.substring(12, 20);
    }

    static String getDirectoryName(String path) {
        return path.substring(0, 10);
    }
}



