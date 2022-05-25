public class PersonRunner {
    public static void main(String[] args) {
        PersonSaver personSaver = new PersonSaver();
        personSaver.printWordList();
        personSaver.addNewAccount("devan", "ng");
        personSaver.scanListIntoData();


    }
}