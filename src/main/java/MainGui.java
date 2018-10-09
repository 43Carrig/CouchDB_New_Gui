import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGui extends JFrame{

    private JPanel MainPanel;
    private JButton createButton;
    private JButton readButton;
    private JButton updateButton;
    private JButton deleteButton;


    public MainGui() {

        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Create");
                frame.setContentPane(new Create().Main); //
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
//                frame.setSize(350, 350);
                frame.setVisible(true);



//

            }
        });
        readButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Read DATA");
                frame.setContentPane(new Read().Main); //
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
//        frame.setSize(300, 1000);
                frame.setVisible(true);
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Update");
                frame.setContentPane(new Update().Main); //
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setSize(300, 300);
                frame.setVisible(true);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Delete");
                frame.setContentPane(new Delete().Main);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
//        frame.setSize(300, 300);
                frame.setVisible(true);

            }
        });
    }

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                JFrame frame = new JFrame("MainGui");
                frame.setContentPane(new MainGui().MainPanel); //
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setSize(350, 350);
                frame.setVisible(true);

            }
        });

    }
}
