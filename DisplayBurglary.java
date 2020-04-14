import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class DisplayBurglary implements DisplayBehavior {

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

        JLabel lbl = new JLabel("Threat Level");
        lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lbl);


        String[] weatherConditions = {"select", "low", "moderate", "high", "extreme"};
        final JComboBox<String> cb = new JComboBox<String>(weatherConditions);
        cb.setMaximumSize(cb.getPreferredSize());
        cb.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(cb);


        JLabel lbl2 = new JLabel("Weapon");
        lbl2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lbl2);


        String[] weatherSeverity = {"select", "firearm", "knife", "unarmed", "club"};
        final JComboBox<String> cb2 = new JComboBox<String>(weatherSeverity);
        cb2.setMaximumSize(cb2.getPreferredSize());
        cb2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(cb2);

        JLabel lbl3 = new JLabel("Action require");
        lbl3.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lbl3);

        String[] actionRequired = {"select", "get away from the area", "no action requiered"};
        final JComboBox<String> cb3 = new JComboBox<String>(actionRequired);
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
                String threatLevel = (String)cb.getSelectedItem();
                String weapon = (String)cb2.getSelectedItem();
                String ActionRequiered = (String)cb3.getSelectedItem();
                String comments =  (String)field1.getText();
                System.out.println();
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
                    myWriter.write("    Recommended course of action:   " + ActionRequiered + "\n");
                    myWriter.write("    Comments: "+ comments);
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
