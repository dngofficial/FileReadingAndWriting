import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class Person {
    private String name;
    private String hobby;

    public Person() {
        name = "";
        hobby = "";
    }

    public Person(String name, String hobby) {


        this.name = name;
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public String getHobby() {
        return hobby;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String greet() {
        if (name.equals("") && hobby.equals("")) {
            return "Hello! Please introduce yourself!";
        }
        else {
            return "Name: " + name + "\n" + "Hobby: " + hobby;
        }
    }

    // This method saves the Person object's state to a file
    // (this "persisting it" so it can be loaded the next time
    // the program is run)
    public void save() {
        try {
            File f = new File("src/person.data");
            f.createNewFile(); // this method will create the file if it does not exist; if it does exist, it does nothing
            FileWriter fw = new FileWriter("src/person.data");
            fw.write(name + "\n");
            fw.write(hobby);
            fw.close();
            System.out.println("Data saved!");
        }
        catch (IOException e) {
            System.out.println("Unable to create file");
            System.out.println(e.getMessage());
        }
    }
}