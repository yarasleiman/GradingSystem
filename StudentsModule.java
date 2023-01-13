
public class StudentsModule {
    /* STUDENTS *************/

    public static void StudentsMain() {
        while (true) {
            App.clearScreen("GRADING SYSTEM / STUDENTS");

            System.out.println("\nLIST OF STUDENTS ");
            System.out.printf("%-11s | %-25s | %-5s | %-10s %n",
                    "Student No.", "Name",
                    "Year", "Section");
            // System.out.println("Student No. | Name | Year | Section ");
            for (int i = 0; i < App.listStudents.size(); i++) {
                Student s = App.listStudents.get(i);
                System.out.printf("%-11s | %-25s | %-5s | %-10s %n",
                        s.getNumber(), s.getName(),
                        s.getYear(), s.getSection());
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
                    Add();
                    break;
                case "2":
                    Edit();
                    break;
                case "3":
                    Delete();
                    break;
            }
        }
    }

    private static void Add() {
        App.clearScreen("GRADING SYSTEM / STUDENTS / ADD");

        System.out.print("Student Number: ");
        int studNum = App.kb.nextInt();
        System.out.print("Name: ");
        String name = App.kb.next();
        System.out.print("Year: ");
        String year = App.kb.next();
        System.out.print("Section: ");
        String sec = App.kb.next();
        System.out.print("Save (Y or N): ");
        String s = App.kb.next();

        if (s.equals("Y")) {
            Student std = new Student(studNum, name, year, sec);
            App.listStudents.add(std);
            System.out.println("Successfully registerted. " + App.listStudents.size());
        }

        App.kb.nextLine();
    }


    private static void Edit() {
        App.clearScreen("GRADING SYSTEM / STUDENTS / EDIT");

        Student S = null;

        System.out.print("Enter Student Number: ");
        int studNum = App.kb.nextInt();

        for (int i = 0; i < App.listStudents.size(); i++) {
            if (studNum == App.listStudents.get(i).getNumber()) {
                S = App.listStudents.get(i);
                break;
            }
        }

        if (S == null) {
            System.out.println("Student was not found ");
            App.kb.next();
            return;
        }
        System.out.print("Name: " + S.getName());
        String name = App.kb.next();
        System.out.print("Year: " + S.getYear());
        String year = App.kb.next();
        System.out.print("Section: " + S.getSection());
        String sec = App.kb.next();
        System.out.print("Save (Y or N): ");
        String decision = App.kb.next();

        if (decision.equals("Y") || decision.equals("y")) {
            // listStudents.set(1, std);
            S.setName(name);
            S.setYear(year);
            S.setSection(sec);
            System.out.println("Successfully updated. " + S.getNumber());
        }
        App.kb.next();
    }


    private static void Delete() {
        App.clearScreen("GRADING SYSTEM / STUDENTS / DELETE");

        System.out.print("Enter Student Number: ");
        int studNum = App.kb.nextInt();
        System.out.print("Continue Delete (Y or N): ");
        String d = App.kb.next();

        if (d.equals("Y") || d.equals("y")) {
            for (int i = 0; i < App.listStudents.size(); i++) {
                if (studNum == App.listStudents.get(i).getNumber()) {
                    App.listStudents.remove(i);
                    System.out.println("Deleted " + i);
                    App.kb.next();
                    break;
                }
            }
        }
    }


}
