import java.io.*;
import java.util.ArrayList;

public class PersonSaver {
    private final ArrayList<Person> personList;
    File f;

    public PersonSaver() {
        personList = new ArrayList<>();
         f = new File("src/person.data");
        scanDataIntoList();

    }



    public void scanDataIntoList() {
        try {


            FileReader fileReader = new FileReader(f);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {

                String[] peopleFromCSV = line.split(",");

                String name = peopleFromCSV[0];
                String password = peopleFromCSV[1];

                Person nextPerson = new Person(name, password);

                personList.add(nextPerson);
            }
            bufferedReader.close();
        } catch (IOException exception) {
            // Print out the exception that occurred
            System.out.println("Unable to access " + exception.getMessage());
        }
    }

    public void scanListIntoData() {
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

                f.createNewFile(); // this method will create the file if it does not exist; if it does exist, it does nothing
                FileWriter fw = new FileWriter(f.getAbsoluteFile(), true);
                fw.write(person.getName() + ",");
                fw.write(person.getPassword() + "\n");
                fw.close();

            } catch (IOException e) {
                System.out.println("Unable to create file");
                System.out.println(e.getMessage());
            }

        }

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
            if(personList.get(i).getName().equals(name) && personList.get(i).getPassword().equals(password))
            {
                return true;
            }
        }
        return false;
    }

    public void addNewAccount(String name, String password)
    {
        personList.add(new Person(name, password));
        scanListIntoData();
    }

    public String returnNameInList(int idx)
    {
        return personList.get(idx).getName();
    }

    public String returnPasswordInList(int idx)
    {
        return personList.get(idx).getPassword();
    }

    public void removeAccount(int idx)
    {
        personList.remove(idx);
        scanListIntoData();
    }


}


