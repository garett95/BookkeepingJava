import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class MonthlyReport {

    private static boolean isViewed;
    public static boolean getIsViewed() {
        return isViewed;
    }
    public static void setIsViewed(boolean isViewed) {
        MonthlyReport.isViewed = isViewed;
    }

    static ArrayList<Integer> calculateMoneyPerMonthsByCategory(String category) {

        ArrayList<Integer> monthlyAmount = new ArrayList<>();
        int sum = 0;

        for (int i = 1; i <= 3; i++) {
            List<String> monthReports = DataParse.getAllLines("./resources/m.20210" + i + ".csv");

            for (int j = 1; j < monthReports.size(); j++) {
                String[] price = DataParse.getSumOfGoods(monthReports, j, category);
                ItemInfo.sum = Integer.parseInt(price[0]);
                sum += ItemInfo.sum;
            }

            monthlyAmount.add(sum);
        }
        return monthlyAmount;
    }

    static void getMostValue(String category) {

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 1; i <= 3; i++) {

            String name = "";
            int sum = 0;
            int maxSum = 0;

            List<String> monthReports = DataParse.getAllLines("./resources/m.20210" + i + ".csv");

            for (int j = 1; j < monthReports.size(); j++) {
                String[] price = DataParse.getSumOfGoods(monthReports, j, category);
                ItemInfo.preSum = Integer.parseInt(price[0]);
                ItemInfo.name = price[1];

                if (ItemInfo.preSum > sum) {
                    sum = ItemInfo.preSum;
                    name = ItemInfo.name;
                }
            }

            if (sum > maxSum) {
                maxSum = sum;
            }

            map.put(name, maxSum);
            System.out.println("Самый " + ((category.equals("TRUE") ? "затратный" : "прибыльный")) + " товар за " + i + "-й месяц: " + name + " на сумму " + maxSum + " рублей.");
            map.clear();
        }
    }

    static void getReport() {

        for (int i = 1; i <= 3; i++) {
            System.out.println(DataParse.readFile("./resources/m.20210" + i + ".csv"));
        }
        MonthlyReport.setIsViewed(true);
    }
}




