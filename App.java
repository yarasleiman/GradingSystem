
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static Scanner kb = new Scanner(System.in);
    public static ArrayList<Student> listStudents = new ArrayList<>();
    public static ArrayList<Grade> listGrades = new ArrayList<>();

    public static void clearScreen(String title) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println(title.toUpperCase());
    }

    public static String getCompleteTitle(String subjectcode) {
        switch (subjectcode) {
            case "S":
                return "Science";
            case "T":
                return "Technology";
            case "E":
                return "Engineering";
            default: // M
                return "Math";
        }
    }
}
