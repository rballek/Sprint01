import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Component;

        public class Main {

            public static void main(String[] args) {

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

                String[] templates = { "Template 1", "Template 2", "Template 3", "Template 4",
                        "Template 5", "Template 6" };

                final JComboBox<String> cb = new JComboBox<String>(templates);

                cb.setMaximumSize(cb.getPreferredSize());
                cb.setAlignmentX(Component.CENTER_ALIGNMENT);
                panel.add(cb);

                JButton btn = new JButton("OK");
                btn.setAlignmentX(Component.CENTER_ALIGNMENT);
                panel.add(btn);

                frame.setVisible(true);

            }
        }
