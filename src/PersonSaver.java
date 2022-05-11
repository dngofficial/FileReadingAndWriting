import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PersonSaver
{
    public PersonSaver() { }

    public void load()
    {
        // try loading data from the file "person.data";
        // if the file isn't found, that means this is the first
        // time running the program and it hasn't been created yet
        // (in which case, an exception is thrown and the "catch"
        // block is executed)
        try {
            File f = new File("src/person.data");
            Scanner s = new Scanner(f); // a Scanner can be initialized with a File object (rather than System.in)
            int line = 1;
            String name = "";
            String hobby = "";

            // reading from the file line by line
            while (s.hasNextLine()) {
                String data = s.nextLine();
                if (line == 1) {
                    name = data;
                }
                if (line == 2) {
                    hobby = data;
                }
                line++;
            }
            s.close(); // close scanner

            Person p =  new Person(name, hobby);
            update(p);

            System.out.println("Good bye!");
        }
        // if the file doesn't exist, an Exception gets generated
        // and "thrown" and "caught" below; this calls the helper method
        // which creates a new Person object and asks them for
        // a name and hobby; when the person gets saved,
        // the file gets created (so the next time the program runs,
        // the file exists and can be loaded!)
        catch (FileNotFoundException e) {
            System.out.println("file doesn't exist yet! exception message: " + e.getMessage());

            // let's create a person and save to file so that it does exist
            createPerson();
        }
    }

    // private helper method
    private void update(Person person) {
        System.out.println(person.greet());
        System.out.println("Would you like to update any information? Select an option");
        System.out.println("1: Change my name");
        System.out.println("2: Change my hobby");
        System.out.println("3: Change both hobby and name");
        System.out.println("4: Exit");
        Scanner s = new Scanner(System.in);
        System.out.print("Enter your option: ");
        String option = s.nextLine();

        if (option.equals("1") || option.equals("3")) {
            String n = "";
            System.out.print("Enter your new name: ");
            n = s.nextLine();
            person.setName(n);
        }
        if (option.equals("2") || option.equals("3")) {
            String h = "";
            System.out.print("Enter your new hobby: ");
            h = s.nextLine();
            person.setHobby(h);
        }
        if (!option.equals("4"))
        {
            person.save();  // calls the save() method in the Person class which saves to file
        }
        s.close();
    }

    // private helper method; only called the first time
    // the program is run and the file doesn't yet exist
    private void createPerson()
    {
        Person p = new Person();
        System.out.println(p.greet());
        System.out.print("What is your name? ");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        System.out.print("What is your hobby? ");
        String hobby = in.nextLine();
        p.setName(name);
        p.setHobby(hobby);
        p.save();
    }
}
