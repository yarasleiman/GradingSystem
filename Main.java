package GradingSystem;

public class Main {
    public static void main(String[] args) {
        MainMenus();
    }

    private static void MainMenus() {
        while (true) {
            App.clearScreen("GRADING System");
            System.out.println("MENUS");
            System.out.println("1. Students ");
            System.out.println("2. Grades ");
            System.out.println("3. Grade Report ");
            System.out.println("0. Exit ");

            System.out.print("Select: ");
            String menu = App.kb.next();

            switch (menu) {
                case "1":
                    StudentsModule.StudentsMain();
                    break;
                case "2":
                    GradeModule.GradesMenus();
                    break;
                case "3":
                    GradeReportModule.GradeReportMainMenus();
                    break;
                case "0":
                    System.exit(0);
            }
        }
    }
}
