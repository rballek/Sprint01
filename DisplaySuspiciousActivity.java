import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DisplaySuspiciousActivity implements DisplayBehavior{

    /*
    Creates/display the behavior of window(how it looks/fields of user input)
    Contains all the user input which we will use to create the email to be sent out
     */
    public void display(){
        JFrame frame = new JFrame("Campus Security");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocation(430, 100);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.add(panel);

        JLabel lbl0 = new JLabel("threat level");
        lbl0.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lbl0);


        String[] threatLevel = {"select", "low", "moderate", "high", "extreme"};
        final JComboBox<String> cb0 = new JComboBox<String>(threatLevel);
        cb0.setMaximumSize(cb0.getPreferredSize());
        cb0.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(cb0);



        JLabel lbl1 = new JLabel("Number of possible suspects in group");
        lbl1.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lbl1);


        String[] weatherConditions = {"select", "one", "two", "three", "four",
                "five"};
        final JComboBox<String> cb1 = new JComboBox<String>(weatherConditions);
        cb1.setMaximumSize(cb1.getPreferredSize());
        cb1.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(cb1);

        JLabel lbl2 = new JLabel("Action require");
        lbl2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lbl2);

        String[] actionRequired = {"select", "get away from the area", "no action requiered"};
        final JComboBox<String> cb2 = new JComboBox<String>(actionRequired);
        cb2.setMaximumSize(cb2.getPreferredSize());
        cb2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(cb2);


        JLabel lbl3 = new JLabel("Possible crime");
        lbl3.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lbl3);


        String[] weatherSeverity = {"select", "loitering", "destruction", "disruptive", "arson"};
        final JComboBox<String> cb3 = new JComboBox<String>(weatherSeverity);
        cb3.setMaximumSize(cb3.getPreferredSize());
        cb3.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(cb3);

        JLabel lbl4 = new JLabel("Comments");
        lbl4.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lbl4);

        JTextField field1 = new JTextField();
        field1.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(field1);

        JButton btn = new JButton("OK");
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(btn);

        frame.setVisible(true);

        /*
        TODO
        adding action listener for button "ok"
        to generate an email based off of all the input they entered
        structure will vary depending on the type of incident and other thing
         */

        btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                String threatLevel = (String)cb0.getSelectedItem();
                String amountOfPeople = (String)cb1.getSelectedItem();
                String ActionRequiered = (String)cb2.getSelectedItem();
                String possibleCrime = (String)cb3.getSelectedItem();
                String comments =  field1.getText();
                System.out.println();
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
                    FileWriter myWriter = new FileWriter("myTemplateSuspiciousActivity" + ".txt");
                    myWriter.write("All,\n");
                    myWriter.write("    Occurrence Date and Time:           \n");
                    myWriter.write("    Threat level:   " + threatLevel + "\n");
                    myWriter.write("    Amount of suspects:              " + amountOfPeople+ "\n");
                    myWriter.write("    Possible Crime: "+ possibleCrime + "\n");
                    myWriter.write("    Recommended course of action:   " + ActionRequiered + "\n");
                    myWriter.write("    Comments: "+ comments + "\n");
                    myWriter.close();
                    System.out.println("Successfully wrote to the file.");
                } catch (IOException t) {
                    System.out.println("An error occurred.");
                    t.printStackTrace();
                }
                //function to display a message based on the officers' input
                //{type of alert}: blbala
                //{another field}: balabl
                //{threat level}: high
                //comment box: in
                //frame1.dispose();
            }
        });
    }

}
