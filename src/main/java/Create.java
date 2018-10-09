import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Create extends JFrame{
    public JPanel Main;
    private JPanel left;
    private JPanel right;
    private JPanel bottom;
    private JLabel lblBefore;
    private JLabel lblCarID;
    private JLabel lblCarRegistration;
    private JLabel lblSold;
    private JLabel lblAfter;
    private JTextField tfBefore;
    private JTextField tfCarId;
    private JTextField tfCarRewgistration;
    private JTextField tfSold;
    private JTextField tfAfter;
    private JButton btnCreate;


    public Create() {
        super();

        tfBefore.setText(String.valueOf(CouchCRUD.listAllDocs()));
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Car car = new Car();

                car.set_id(tfCarId.getText());
                car.set_rev(null);
                car.setSold(Boolean.valueOf(tfSold.getText()));
                car.setRegistration(tfCarRewgistration.getText());

                CouchCRUD.postToCouch(car);//carData.get(0),carData.get(1)
                tfAfter.setText(String.valueOf(CouchCRUD.listAllDocs()));

            }
        });

    }
    public static void main(String args[])
    {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Create");
                frame.setContentPane(new Create().Main); //
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
//                frame.setSize(350, 350);
                frame.setVisible(true);
            }
        });

    }
}
