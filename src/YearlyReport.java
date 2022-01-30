import java.util.ArrayList;
import java.util.List;


public class YearlyReport {

    private static final String pathToFile = "./resources/y.2021.csv";

    private static boolean isViewed;
    public static boolean getIsViewed() {
        return isViewed;
    }
    public static void setIsViewed(boolean isViewed) {
        YearlyReport.isViewed = isViewed;
    }

    static ArrayList<Integer> calculateMoneyPerMonthsByCategory(String category) {

        ArrayList<Integer> monthlyAmount = new ArrayList<>();

        List<String> fullYearReport = DataParse.getAllLines(pathToFile);

        for (int i = 1; i < fullYearReport.size(); i++) {
            String[] arr = DataParse.getLines(fullYearReport, i);
            ItemInfo.month = arr[0];
            ItemInfo.amount = Integer.parseInt(arr[1]);
            ItemInfo.isExpense = arr[2];

            for (int j = 1; j <= i; j++) {
                if (ItemInfo.month.equals("0" + j)) {
                    if (ItemInfo.isExpense.equals(category)) {
                        monthlyAmount.add(ItemInfo.amount);
                    }
                }
            }

        }
        return monthlyAmount;
    }

    static void getFullYearReport() {

        ArrayList<Integer> listOfExpense = new ArrayList<>();
        ArrayList<Integer> listOfProfit = new ArrayList<>();
        ArrayList<Integer> listOfProfitPerMonth = new ArrayList<>();

        int amountOfExpense = 0;
        int numberOfExpenseMonths = 0;
        int amountOfProfit = 0;
        int numberOfProfitMonths = 0;
        int averageExpense;
        int averageProfit;
        String year = "";

        List<String> fullYearReport = DataParse.getAllLines(pathToFile);

        for (int i = 1; i < fullYearReport.size(); i++) {
            String[] arr = DataParse.getLines(fullYearReport, i);
            ItemInfo.amount = Integer.parseInt(arr[1]);
            ItemInfo.isExpense = arr[2];

            if (ItemInfo.isExpense.equals("true")) {
                amountOfExpense += ItemInfo.amount;
                listOfExpense.add(ItemInfo.amount);
                numberOfExpenseMonths = arr.length;
            } else if (ItemInfo.isExpense.equals("false")) {
                amountOfProfit += ItemInfo.amount;
                listOfProfit.add(ItemInfo.amount);
                numberOfProfitMonths = arr.length;
            }
        }

        year = pathToFile.substring(14, 18);

        averageExpense = amountOfExpense / numberOfExpenseMonths;
        averageProfit = amountOfProfit / numberOfProfitMonths;

        System.out.println("Рассматриваемый год: " + year);

        for (int k = 0; k < listOfExpense.size(); k++) {
            listOfProfitPerMonth.add(listOfProfit.get(k) - listOfExpense.get(k));
            System.out.println("Прибыль за " + (k + 1) + "-й месяц составляет " + listOfProfitPerMonth.get(k) + " рублей.");
        }

        System.out.println("Средний расход за все месяцы в году составляет " + averageExpense + " рублей.");
        System.out.println("Средний доход за все месяцы в году составляет " + averageProfit + " рублей.");
    }

    static void getReport() {
        System.out.println(DataParse.readFile(pathToFile));
        YearlyReport.setIsViewed(true);
    }
}