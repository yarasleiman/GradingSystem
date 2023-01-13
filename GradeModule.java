
public class GradeModule {
    public static void GradesMenus() {
        while (true) {
            App.clearScreen("***** GRADING SYSTEM / GRADES ****");

            System.out.println("LIST OF GRADES (LATEST 10)");

            System.out.printf("%-25s | %-5s | %-9s | %-13s | %8s %n",
                    "SUBJECT", "YEAR", "SECTION", "STUDENT NO.", "GRADE");

            for (int i = 0; i < App.listGrades.size(); i++) {
                Grade g = App.listGrades.get(i);

                String year = "";
                String section = "";

                for (int j = 0; j < App.listStudents.size(); j++) {
                    Student s = App.listStudents.get(j);
                    if (s.getNumber() == g.getstudNumber()) {
                        year = s.getYear();
                        section = s.getSection();
                        break;
                    }
                }

                String subjTitle = App.getCompleteTitle(g.getSubject());

                System.out.printf("%-15s | %-5s | %-9s | %-13s | %8s %n",
                        subjTitle, year,
                        section, g.getstudNumber(), g.getGrade());

            }

            System.out.println("\nMENUS ");
            System.out.println(" 1. Add ");
            System.out.println(" 2. Edit ");
            System.out.println(" 3. Delete ");
            System.out.println(" 0. Back ");

            System.out.print("Select: ");
            String menu2 = App.kb.next();

            switch (menu2) {
                case "0":
                    return;
                case "1":
                    GradeAdd();
                    break;
                case "2":
                    GradeEdit();
                    break;
                case "3":
                    GradeDelete();
                    break;
            }
        }
    }

    private static void GradeAdd() {
        App.clearScreen("GRADING SYSTEM / GRADES / ADD");
        System.out.print("Subject (S, T, E or M): ");
        String sub = App.kb.next();
        System.out.print("Student Number: ");
        int studNum = App.kb.nextInt();
        System.out.print("Grade: ");
        String grade = App.kb.next();
        System.out.print("Save (Y or N): ");
        String s = App.kb.next();

        if (s.equals("Y")) {
            Grade g = new Grade(sub, grade, studNum);
            App.listGrades.add(g);
            System.out.println("Successfully registerted. " + App.listGrades.size());
        }

        App.kb.nextLine();
    }

    private static void GradeEdit() {
        App.clearScreen(" GRADING SYSTEM / GRADES / EDIT ");

        System.out.print("Enter the Subject (S, T, E or M): ");
        String sub = App.kb.next();

        System.out.print("Enter the Student Number: ");
        int studNum = App.kb.nextInt();

        Grade G = null;
        for (int i = 0; i < App.listGrades.size(); i++) {
            Grade g = App.listGrades.get(i);
            if (g.getSubject().equals(sub) && g.getstudNumber() == studNum) {
                G = g;
            }
        }

        if (G == null) {
            System.out.println("Grade was not found ");
            App.kb.next();
            return;
        }

        System.out.print("Grade: " + G.getGrade());
        String grade = App.kb.next();
        System.out.print("Save (Y or N): ");
        String decision = App.kb.next();

        if (decision.equals("Y") || decision.equals("y")) {
            G.setGrade(grade);
            System.out.println("Successfully updated. ");
        }
        App.kb.next();
    }

    public static void GradeDelete() {
        App.clearScreen(" GRADING SYSTEM / GRADES / DELETE");
        System.out.print("Enter the Subject (S, T, E or M): ");
        String sub = App.kb.next();
        System.out.print("Enter the Student Number: ");
        int studNum = App.kb.nextInt();
        System.out.print("Continue Delete (Y or N): ");
        String d = App.kb.next();

        if (d.equals("Y") || d.equals("y")) {
            int G = -1;
            for (int i = 0; i < App.listGrades.size(); i++) {
                if (studNum == App.listGrades.get(i).getstudNumber()
                        && App.listGrades.get(i).getSubject().equals(sub)) {
                    G = i;
                    break;
                }
            }

            if (G == -1) {
                System.out.println("Not found");
                App.kb.next("\r\n");
                return;
            } else {
                App.listGrades.remove(G);
                System.out.println("Deleted " + G);
                App.kb.next();
            }
        }
    }

}
