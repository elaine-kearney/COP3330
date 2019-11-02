public class Application {
    public static void main(String[] args) {
        DuplicateCounter duplicateRemover = new DuplicateCounter();

        duplicateRemover.count("problem2.txt");
        duplicateRemover.write("unique_word_counts.txt");

    }
}
