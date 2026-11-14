public class FAQ {
    private int id;
    private String question;
    private String answer;
    private String keywords;
    private String category;

    public FAQ(int id, String question, String answer, String keywords, String category) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.keywords = keywords;
        this.category = category;
    }

    public int getId() { return id; }
    public String getQuestion() { return question; }
    public String getAnswer() { return answer; }
    public String getKeywords() { return keywords; }
    public String getCategory() { return category; }

    // Convert one FAQ into a line that can be saved in a file.
    public String toFileLine() {
        return id + "|" + question + "|" + answer + "|" + keywords + "|" + category;
    }

    public void display() {
        System.out.println("FAQ ID: " + id);
        System.out.println("Question: " + question);
        System.out.println("Answer: " + answer);
        System.out.println("Keywords: " + keywords);
        System.out.println("Category: " + category);
        System.out.println("--------------------------------");
    }
}
