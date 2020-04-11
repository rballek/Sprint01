import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DisplayFirst implements DisplayBehavior {

    public void display(){
        JFrame frame = new JFrame("Campus Security");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocation(430, 100);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.add(panel);

        JLabel lbl = new JLabel("Select one of the templates and click OK");
        lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lbl);


        String[] templates = {"select", "Weather Alert", "Burglary", "Suspicious Activity", "Template 4",
                "Template 5", "Template 6"};
        final JComboBox<String> cb = new JComboBox<String>(templates);
        cb.setMaximumSize(cb.getPreferredSize());
        cb.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(cb);

        JLabel lbl2 = new JLabel("Do you want to generate a map?");
        lbl2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lbl2);

        String[] Answers = {"select", "Yes", "No"};
        final JComboBox<String> cb1 = new JComboBox<String>(Answers);
        cb1.setMaximumSize(cb.getPreferredSize());
        cb1.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(cb1);

        JButton btn = new JButton("OK");
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(btn);

        frame.setVisible(true);

                /*
        adding action listener for button "ok"
        to close current window and open GUIMap()
         */

        btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                        frame.dispose();
                        //call a function to generate the template
                        String incidentSelected = (String)cb.getSelectedItem();
                        WindowTemplates incidentOption = new WindowTemplates(incidentSelected);


                        }
                });


            }
    }

