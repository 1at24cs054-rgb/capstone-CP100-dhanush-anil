
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<FAQ> faqs = FileManager.loadFAQs();

        Chatbot chatbot = new Chatbot(faqs);

        int choice;

        do {

            System.out.println("\n====== ASK CAMPUS ======");
            System.out.println("1. Ask a Question");
            System.out.println("2. View All FAQs");
            System.out.println("3. View Categories");
            System.out.println("4. Search FAQs");
            System.out.println("5. Admin - Add FAQ");
            System.out.println("6. Admin - View Unanswered");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter your question: ");
                    String question = sc.nextLine();

                    chatbot.askQuestion(question);
                    break;

                case 2:
                    chatbot.showAllFAQs();
                    break;

                case 3:
                    chatbot.showCategories();
                    break;

                case 4:
                    System.out.print("Enter keyword: ");
                    String keyword = sc.nextLine();

                    chatbot.searchFAQs(keyword);
                    break;

                case 5:
                    adminAddFAQ(chatbot, faqs);
                    break;

                case 6:
                    adminLogin();

                    if (adminLoggedIn) {
                        FileManager.showUnanswered();
                    }
                    break;

                case 7:
                    System.out.println("Thank you for using AskCampus!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 7);

        sc.close();
    }

    static boolean adminLoggedIn = false;

    static void adminLogin() {

        System.out.print("Enter admin password: ");
        String password = sc.nextLine();

        if (password.equals("admin123")) {

            System.out.println("Admin login successful!");
            adminLoggedIn = true;

        } else {

            System.out.println("Incorrect password!");
            adminLoggedIn = false;
        }
    }

    static void adminAddFAQ(Chatbot chatbot,
                            ArrayList<FAQ> faqs) {

        adminLogin();

        if (!adminLoggedIn) {
            return;
        }

        System.out.print("Enter question: ");
        String question = sc.nextLine();

        System.out.print("Enter answer: ");
        String answer = sc.nextLine();

        System.out.print("Enter keywords (comma separated): ");
        String keywords = sc.nextLine();

        System.out.print("Enter category: ");
        String category = sc.nextLine();

        int id = faqs.size() + 1;

        FAQ faq = new FAQ(
                id,
                question,
                answer,
                keywords,
                category
        );

        chatbot.addFAQ(faq);
    }
}
