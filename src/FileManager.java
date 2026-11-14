
import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private static final String FAQ_FILE = "data/faqs.txt";
    private static final String UNANSWERED_FILE =
            "data/unanswered.txt";

    public static ArrayList<FAQ> loadFAQs() {

        ArrayList<FAQ> faqs = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(
                    new FileReader(FAQ_FILE));

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split("\\|", 5);

                if (data.length == 5) {

                    FAQ faq = new FAQ(
                            Integer.parseInt(data[0]),
                            data[1],
                            data[2],
                            data[3],
                            data[4]
                    );

                    faqs.add(faq);
                }
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error loading FAQs.");
        }

        return faqs;
    }

    public static void saveFAQs(ArrayList<FAQ> faqs) {

        try {
            File folder = new File("data");
            folder.mkdirs();

            BufferedWriter bw = new BufferedWriter(
                    new FileWriter(FAQ_FILE));

            for (FAQ faq : faqs) {
                bw.write(faq.toFileLine());
                bw.newLine();
            }

            bw.close();

        } catch (IOException e) {
            System.out.println("Error saving FAQs.");
        }
    }

    public static void logUnanswered(String question) {

        try {
            File folder = new File("data");
            folder.mkdirs();

            BufferedWriter bw = new BufferedWriter(
                    new FileWriter(UNANSWERED_FILE, true));

            bw.write(question);
            bw.newLine();

            bw.close();

        } catch (IOException e) {
            System.out.println("Error logging question.");
        }
    }

    public static void showUnanswered() {

        try {
            BufferedReader br = new BufferedReader(
                    new FileReader(UNANSWERED_FILE));

            String line;

            System.out.println("\nUnanswered Questions:");

            while ((line = br.readLine()) != null) {
                System.out.println("- " + line);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("No unanswered questions yet.");
        }
    }
}
