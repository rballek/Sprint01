import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayWeatherAlert implements DisplayBehavior {

    public void display() {
        JFrame frame1 = new JFrame("Campus Security");
        frame1.setVisible(true);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(500, 500);
        frame1.setLocation(430, 100);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame1.add(panel);

        JLabel lbl = new JLabel("Select the type of weather");
        lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lbl);


        String[] weatherConditions = {"select", "Snow", "High Winds", "Flooding", "Heavy Rain",
                "Other"};
        final JComboBox<String> cb = new JComboBox<String>(weatherConditions);
        cb.setMaximumSize(cb.getPreferredSize());
        cb.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(cb);


        JLabel lbl2 = new JLabel("Severity of the weather");
        lbl2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lbl2);


        String[] weatherSeverity = {"select", "low", "moderate", "high", "extreme"};
        final JComboBox<String> cb2 = new JComboBox<String>(weatherSeverity);
        cb2.setMaximumSize(cb2.getPreferredSize());
        cb2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(cb2);

        JButton btn = new JButton("OK");
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(btn);

        frame1.setVisible(true);

                /*
        adding action listener for button "ok"
        to close current window and open GUIMap()
         */

        btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //frame1.dispose();
                //call a function to generate the template
            }
        });
    }
}
