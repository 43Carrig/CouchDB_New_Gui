import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Update extends JFrame{
    public JPanel Main;
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

    public Update() {
        tfBefore.setText(String.valueOf(CouchCRUD.listAllDocs()));

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                CouchCRUD.putCarDetails(tfCarId.getText(), tfCarRev.getText(),tfCarRegistration.getText(), Boolean.valueOf(tfIsSold.getText()));
                tfAfter.setText(String.valueOf(CouchCRUD.listAllDocs()));
            }
        });
    }

    public static void main(String args[])
    {
        JFrame frame = new JFrame("Update");
        frame.setContentPane(new Update().Main); //
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
