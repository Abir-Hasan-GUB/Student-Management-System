
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author abirh
 */
public class LoginFrame extends JFrame {

    Container c;
    private JLabel userLabel, passLabel,login;
    private JTextField tf;
    private JPasswordField pf;
    private JButton loginButton, clearButton;
    private Font f,f1;
    private Cursor cursor;
    
    LoginFrame() {
       
        initComponants();

    }

    void initComponants() {
        
        setVisible(true);
        setBounds(500, 200, 400, 300);
        setTitle("Login Here @Abir Hasan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        cursor = new Cursor(Cursor.HAND_CURSOR);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.LIGHT_GRAY);

        f = new Font("Aral", Font.BOLD, 16);
        f1 = new Font("Times New Roman", Font.BOLD, 25);
        
        
        login = new JLabel("Login Here");
        login.setBounds(150, 5, 150, 30);
        login.setForeground(Color.red);
        login.setFont(f1);
        c.add(login);
        
        
        userLabel = new JLabel("Username: ");
        userLabel.setFont(f);
        userLabel.setBounds(50, 50, 150, 50);
        userLabel.setToolTipText("abir");
        c.add(userLabel);

        tf = new JTextField();
        tf.setBounds(170, 50, 200, 50);
        tf.setBackground(Color.white);
        tf.setForeground(Color.blue);
        tf.setFont(f);
        tf.setToolTipText("abir");
        c.add(tf);

        passLabel = new JLabel("Password: ");
        passLabel.setBounds(50, 120, 150, 50);
        passLabel.setFont(f);
        passLabel.setToolTipText("2247");
        c.add(passLabel);

        pf = new JPasswordField();
        pf.setBounds(170, 120, 200, 50);
        pf.setBackground(Color.white);
        pf.setForeground(Color.blue);
        pf.setToolTipText("2247");
        pf.setFont(f);
        c.add(pf);

        loginButton = new JButton("Login");
        loginButton.setBounds(170, 190, 90, 50);
        loginButton.setFont(f);
        loginButton.setForeground(Color.BLUE);
        c.add(loginButton);
        loginButton.setCursor(cursor);

        clearButton = new JButton("Clear");
        clearButton.setBounds(280, 190, 90, 50);
        clearButton.setFont(f);
        clearButton.setCursor(cursor);
        clearButton.setForeground(Color.RED);
        c.add(clearButton);

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf.setText("");  // set empty charecter for clear
                pf.setText("");  // set empty charecter for clear
            }
        });

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userName = tf.getText();
                String password = pf.getText();

                if (userName.equals("abir") && password.equals("2247")) {
                    tf.setText("");  // set empty charecter for clear
                    pf.setText("");  // set empty charecter for clear
                    JOptionPane.showMessageDialog(null, "Login Sucessfull.!!","Welcome..!!",JOptionPane.INFORMATION_MESSAGE);
                    dispose(); // for off parents frame.
                    Student st = new Student(); // create obj anothers frame class
                    st.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "Password or UserName Incorrect..!", "Warning !", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }

    public static void main(String[] args) {
        LoginFrame frame = new LoginFrame();
    }
}
