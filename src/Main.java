import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int command = scanner.nextInt();

            if (command == 1) {
                MonthlyReport.getReport();
            } else if (command == 2) {
                YearlyReport.getReport();
            } else if (command == 3) {
                if (MonthlyReport.getIsViewed() && YearlyReport.getIsViewed()) {
                    Common.compareReports();
                } else {
                    System.out.println("Вы не считали отчеты!");
                }
            } else if (command == 4) {
                MonthlyReport.getMostValue(ItemInfo.expenseInMonth);
                MonthlyReport.getMostValue(ItemInfo.profitInMonth);
            } else if (command == 5) {
                YearlyReport.getFullYearReport();
            } else if (command == 0) {
                return;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }

    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Выход");
    }

}



