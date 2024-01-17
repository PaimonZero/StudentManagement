
package executed;

import controller.StudentManager;
import view.Menu;

public class Main extends Menu{
    StudentManager st = new StudentManager();

    public Main() {
        super("-*-*-*-*-*-*Student Management*-*-*-*-*-*-", 
                new String[] {"Create course", "Add new Student", "Find and Sort",
                                "Update/Delete", "Report", "Exit"});
    }
    
    
    
    public static void main(String[] args) {
        Main executed = new Main();
        executed.run();
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                st.addCourse();
                System.out.println("<<<<===============================================>>>>");
                break;
            case 2:
                st.addStudent();
                System.out.println("<<<<===============================================>>>>");
                break;
            case 3:
                st.findAndSearch();
                System.out.println("<<<<===============================================>>>>");
                break;
            case 4:
                st.updateStudent();
                System.out.println("<<<<===============================================>>>>");
                break;
            case 5:
                st.report();
                System.out.println("<<<<===============================================>>>>");
                break;
            case 6:
                System.out.println("Program closing!");
                System.out.println("<<<<===============================================>>>>");
                break;
            default:
                System.out.println("We don't have that option!");
                System.out.println("<<<<===============================================>>>>");
                break;
        }
    }
}
