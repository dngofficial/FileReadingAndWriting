import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonSaver {
    private final ArrayList<Person> personList;
    File f;

    public PersonSaver() {
        personList = new ArrayList<>();
         f = new File("src/person.data");
        scanDataIntoList();

    }

    public void load()
    {
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
            person.setPassword(h);
        }
        if (!option.equals("4")) {
            person.save();  // calls the save() method in the Person class which saves to file
        }
        s.close();
    }

    // private helper method; only called the first time
    // the program is run and the file doesn't yet exist
    private void createPerson() {
        Person p = new Person();
        System.out.println(p.greet());
        System.out.print("What is your name? ");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        System.out.print("What is your hobby? ");
        String hobby = in.nextLine();
        p.setName(name);
        p.setPassword(hobby);
        p.save();
    }

    public void scanDataIntoList() {
        try {


            FileReader fileReader = new FileReader(f);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                // import all cells for a single row as an array of Strings,
                // then convert to ints as needed
                String[] peopleFromCSV = line.split(",");

                // pull out the data for this cereal
                String name = peopleFromCSV[0];
                String password = peopleFromCSV[1];

                // create Cereal object to store values
                Person nextPerson = new Person(name, password);

                // adding Cereal object to the arraylist
                personList.add(nextPerson);
            }
            bufferedReader.close();
        } catch (IOException exception) {
            // Print out the exception that occurred
            System.out.println("Unable to access " + exception.getMessage());
        }
    }

    public void scanListIntoData() {
        int counter = 1;
        try {
            f.createNewFile();
            FileWriter fw = new FileWriter(f);
            fw.write("");
            fw.close();
        }
        catch (IOException e){
            System.out.println("Unable to create file");
            System.out.println(e.getMessage());
        }



        for (Person person : personList) {
            try {
                System.out.print(counter);

                f.createNewFile(); // this method will create the file if it does not exist; if it does exist, it does nothing
                FileWriter fw = new FileWriter(f.getAbsoluteFile(), true);
                fw.write(person.getName() + ",");
                fw.write(person.getPassword() + "\n");
                fw.close();

            } catch (IOException e) {
                System.out.println("Unable to create file");
                System.out.println(e.getMessage());
            }
            counter++;

        }

    }

    public ArrayList getPersonList()
    {
        return personList;
    }
    
    public int findIdxOfNameInPersonList(String name)
    {
        for (int i = 0; i < personList.size(); i++)
        {
            if(personList.get(i).getName().equals(name))
            {
                return i;
            }
        }
        return -1;
    }

    public void changeNameOfUserInList(int idx, String newName)
    {
        personList.get(idx).setName(newName);
        scanListIntoData();
    }

    public void changePasswordOfUserInList(int idx, String newPass)
    {
        personList.get(idx).setPassword(newPass);
        scanListIntoData();
    }

    public boolean checkIfValidAccount(String name, String password)
    {
        for (int i = 0; i < personList.size(); i++)
        {
            if(personList.get(i).getName().equals(name) || personList.get(i).getPassword().equals(password))
            {
                return true;
            }
        }
        return false;
    }

    public void addNewAccount(String name, String password)
    {
        personList.add(new Person(name, password));
        printWordList();
        scanListIntoData();
    }


    public void printWordList() {
        System.out.println(personList.size());
        System.out.println(personList.toString());
    }
}


