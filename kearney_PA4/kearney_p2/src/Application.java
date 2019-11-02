public class Application {
    public static void main(String[] args) {
        DuplicateCounter duplicateRemover = new DuplicateCounter();

        duplicateRemover.count("problem1.txt");
        duplicateRemover.write("unique_words.txt");

    }
}
