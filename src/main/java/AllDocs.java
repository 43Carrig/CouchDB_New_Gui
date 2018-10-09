import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AllDocs extends JFrame {
    public JPanel Main;
    private JButton allDocsButton;
    private JLabel allDocsLabel;
    private JButton mapreduceButton;
    private JLabel mapreduceLabel;
    private JPanel left;
    private JPanel right;
    private JPanel bottom;
    private JButton btnUpdate;
    private JTextField tfBefore;
    private JTextField tfCarId;
    private JTextField tfCarRev;
    private JTextField tfIsSold;
    private JTextField tfCarRegistration;
    private JLabel lblBefore;
    private JLabel lblCarId;
    private JLabel lblAfter;
    private JLabel lblCarRegistration;
    private JLabel lblCarIsSold;
    private JLabel lblCarRev;
    private JTextField tfAfter;

    public AllDocs() {

        allDocsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allDocsLabel.setText(String.valueOf(CouchCRUD.listAllDocs()));
            }
        });
    }

    public static void main(String args[])
    {
        JFrame frame = new JFrame("All Docs");
        frame.setContentPane(new AllDocs().Main); //
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

}
