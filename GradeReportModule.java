
import java.util.Scanner;

public class GradeReportModule {
    static Scanner kb = new Scanner(System.in);

    public static void MainMenus() {
        System.out.println("GRADE REPORT");
        kb.next();
    }
     /****** vGR */
     public static void GradeReportMainMenus() {
        App.clearScreen("***** GRADING SYSTEM / GRADE REPORT *****");

        System.out.println("Enter the Student Number:");
        int studNum = App.kb.nextInt();


        System.out.println("-----------------------------------");
        System.out.println("***      GRADE REPORT CARD      *** ");
        System.out.println("----------------------------------- ");

        Student studentSearched = null;
        for(int i = 0; i < App.listStudents.size(); i++){
            if( studNum == App.listStudents.get(i).getNumber()){
                studentSearched = App.listStudents.get(i);
                break;
            }
        }
        if( studentSearched == null){
            System.out.println("Student not found");
            App.kb.next();
            return;
        }
        
        System.out.println("\nStudent No.: " + studentSearched.getNumber());
        System.out.println("Name       : " + studentSearched.getName() );
        System.out.println("Year       : " + studentSearched.getYear());
        System.out.println("Section    : " + studentSearched.getSection());

        System.out.println("\n----------------------- ");
        System.out.printf("%-15s | %-10s %n", "SUBJECT", "GRADE");
        System.out.println("----------------------- ");

        float total = 0;
        int n = 0;
        for(int i = 0; i < App.listGrades.size(); i++){
            if(App.listGrades.get(i).getstudNumber() == studNum) {
                Grade g = App.listGrades.get(i);
                String subjTitle = App.getCompleteTitle(g.getSubject());
                System.out.printf(" %-15s | %-10s %n", subjTitle , g.getGrade());
                n++;
                total += Float.parseFloat(g.getGrade());
            }
        }
        
        System.out.println("----------------------- ");
        System.out.printf(" %-15s | %-10s %n", "GA" , total/n);

        App.kb.next();
    }
}
