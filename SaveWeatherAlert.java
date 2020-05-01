import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveWeatherAlert implements SaveBehavior{

    public void save(String weatherConditions, String weatherSeverity, String comments){
        try {
            File mytemplate = new File("myTemplateWeatherAlert" + ".txt");

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
            FileWriter myWriter = new FileWriter("myTemplateWeatherAlert" + ".txt");
            myWriter.write("All,\n");
            myWriter.write("    Occurrence Date and Time:           \n");
            myWriter.write("    weather conditions:   " + weatherConditions + "\n");
            myWriter.write("    weather severity:              " + weatherSeverity + "\n");
            myWriter.write("    Comments: "+ comments + "\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException t) {
            System.out.println("An error occurred.");
            t.printStackTrace();
        }
    }


    public void save() {

    }

    @Override
    public void save(String threatLevel, String weapon, String actionRequired, String comments) {

    }

    @Override
    public void save(String threatLevel, String amountOfPeople, String actionRequiered, String possibleCrime, String comments) {

    }
}
