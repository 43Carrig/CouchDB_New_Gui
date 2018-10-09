import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Read extends JFrame {
    public JPanel Main;
    private JPanel left;
    private JPanel Right;
    private JPanel Bottom;
    private JLabel lblBefore;
    private JLabel lblGet;
    private JLabel lblID;
    private JLabel lblRev;
    private JLabel lblIsSold;
    private JLabel lblRegistration;
    private JTextField tfBefore;
    private JTextField tfGetById;
    private JTextField tfCarId;
    private JTextField tfCarRev;
    private JTextField tfIsSold;
    private JTextField tfCarRegistration;
    private JButton btnFind;

    public Read() {

        tfBefore.setText(String.valueOf(CouchCRUD.listAllDocs()));

        btnFind.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Car resultText = CouchCRUD.getCarFromId(tfGetById.getText());
                tfCarId.setText(resultText.get_id()); //result.setText(String.valueOf(resultText));
                tfCarRev.setText(resultText.get_rev());
                tfIsSold.setText(String.valueOf(resultText.getSold()));
                tfCarRegistration.setText(resultText.getRegistration());
            }
        });
    }

    public static void main(String args[])
    {
        JFrame frame = new JFrame("Read DATA");
        frame.setContentPane(new Read().Main); //
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
//        frame.setSize(300, 1000);
        frame.setVisible(true);
    }

}
