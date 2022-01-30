import java.util.ArrayList;

public class Common {

    static void compareReports() {

        ArrayList<Integer> monthsExpenseReport = MonthlyReport.calculateMoneyPerMonthsByCategory(ItemInfo.expenseInMonth);
        ArrayList<Integer> monthsProfitReport = MonthlyReport.calculateMoneyPerMonthsByCategory(ItemInfo.profitInMonth);
        ArrayList<Integer> yearExpenseReport = YearlyReport.calculateMoneyPerMonthsByCategory(ItemInfo.expenseInYear);
        ArrayList<Integer> yearProfitReport = YearlyReport.calculateMoneyPerMonthsByCategory(ItemInfo.profitInYear);

        for (int i = 0; i < monthsExpenseReport.size(); i++) {
            if (!monthsExpenseReport.get(i).equals(yearExpenseReport.get(i))) {
                if (!monthsProfitReport.get(i).equals(yearProfitReport.get(i))) {
                    System.out.println("В отчетах " + (i + 1) + "-го месяца обнаружено несоответствие.");
                } else {
                    System.out.println("Все отчеты успешно прошли сверку.");
                }
            }
        }
    }

}
