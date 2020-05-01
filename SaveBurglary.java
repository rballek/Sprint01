import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveBurglary implements SaveBehavior{

    public void save(String threatLevel, String weapon, String ActionRequired, String comments) {
        try {
            File mytemplate = new File("myTemplateBurglary" + ".txt");

            if (mytemplate.createNewFile()) {
                System.out.println("File created: " + mytemplate.getName());
            } else {
                System.out.println("File already exists.");
            }

        } catch (IOException E) {
            System.out.println("An error occurred.");
            E.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter("myTemplateBurglary" + ".txt");
            myWriter.write("All,\n");
            myWriter.write("    Occurrence Date and Time:           \n");
            myWriter.write("    Threat level:   " + threatLevel + "\n");
            myWriter.write("    weapon:         " + weapon + "\n");
            myWriter.write("    Recommended course of action:   " + ActionRequired + "\n");
            myWriter.write("    Comments: "+ comments);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException t) {
            System.out.println("An error occurred.");
            t.printStackTrace();
        }
    }

    @Override
    public void save(String threatLevel, String amountOfPeople, String actionRequiered, String possibleCrime, String comments) {

    }

    @Override
    public void save(String weatherConditions, String weatherSeverity, String comments) {

    }

    @Override
    public void save() {

    }
}
