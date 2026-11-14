
import java.util.ArrayList;

public class Chatbot {

    private ArrayList<FAQ> faqs;

    private final int MINIMUM_SCORE = 1;

    public Chatbot(ArrayList<FAQ> faqs) {
        this.faqs = faqs;
    }

    public void askQuestion(String userQuestion) {

        String[] userWords = userQuestion.toLowerCase()
                .split("[^a-z0-9]+");

        FAQ bestFAQ = null;
        int highestScore = 0;

        for (FAQ faq : faqs) {

            int score = 0;

            String[] keywords = faq.getKeywords()
                    .toLowerCase().split(",");

            for (String keyword : keywords) {

                keyword = keyword.trim();

                for (String word : userWords) {

                    if (word.equals(keyword)) {
                        score++;
                    }
                }
            }

            if (score > highestScore) {
                highestScore = score;
                bestFAQ = faq;
            }
        }

        if (bestFAQ != null &&
                highestScore >= MINIMUM_SCORE) {

            System.out.println("\nChatbot: "
                    + bestFAQ.getAnswer());

        } else {

            System.out.println(
                    "\nChatbot: Sorry, I couldn't understand.");

            FileManager.logUnanswered(userQuestion);
        }
    }

    public void showAllFAQs() {

        System.out.println("\nAvailable FAQs:");

        for (FAQ faq : faqs) {
            faq.display();
        }
    }

    public void showCategories() {

        System.out.println("\nFAQ Categories:");

        for (FAQ faq : faqs) {
            System.out.println("- " + faq.getCategory());
        }
    }

    public void searchFAQs(String keyword) {

        boolean found = false;

        for (FAQ faq : faqs) {

            if (faq.getQuestion().toLowerCase()
                    .contains(keyword.toLowerCase())) {

                faq.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No FAQ found.");
        }
    }

    public void addFAQ(FAQ faq) {

        faqs.add(faq);

        FileManager.saveFAQs(faqs);

        System.out.println("FAQ added successfully!");
    }
}
