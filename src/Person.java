import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class Person {
    private String name;
    private String password;

    public Person() {
        name = "";
        password = "";
    }

    public Person(String name, String hobby) {


        this.name = name;
        this.password = hobby;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void save() {
        try {
            File f = new File("src/person.data");
            f.createNewFile(); // this method will create the file if it does not exist; if it does exist, it does nothing
            FileWriter fw = new FileWriter("src/person.data");
            fw.write(name + ",");
            fw.write(password);
            fw.close();
            System.out.println("Data saved!");
        }
        catch (IOException e) {
            System.out.println("Unable to create file");
            System.out.println(e.getMessage());
        }
    }

    public String toString()
    {
        return "Name: " + name + "\n" + "Password: " + password +"\n -----------------\n";
    }


}