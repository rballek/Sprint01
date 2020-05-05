import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SaveSuspiciousActivity implements SaveBehavior{
    @Override
    public void save() {

    }

    @Override
    public void save(String threatLevel, String weapon, String actionRequired, String comments) {

    }

    public void save(String threatLevel, String amountOfPeople, String ActionRequiered, String possibleCrime, String comments) {
        try {
            File mytemplate = new File("myTemplateSuspiciousActivity" + ".txt");

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
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            FileWriter myWriter = new FileWriter("myTemplateSuspiciousActivity" + ".txt");
            myWriter.write("All,\n");
            myWriter.write("    Occurrence Date and Time: " + dtf.format(now) + "\n");
            myWriter.write("    Threat level: " + threatLevel + "\n");
            myWriter.write("    Amount of suspects: " + amountOfPeople+ "\n");
            myWriter.write("    Possible Crime: "+ ActionRequiered + "\n");
            myWriter.write("    Recommended course of action: " + possibleCrime + "\n");
            myWriter.write("    Comments: " + comments + "\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException t) {
            System.out.println("An error occurred.");
            t.printStackTrace();
        }
    }

    @Override
    public void save(String weatherConditions, String weatherSeverity, String comments) {

    }
}
