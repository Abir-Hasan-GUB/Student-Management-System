
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author abir_hasan
 */
public class Student extends JFrame implements ActionListener {

    private Container c;
    private JLabel titleLabel, fnLabel, lnLabel, phoneLabel, gpaLabel;
    private JTextField fnTf, lnTf, phoneTf, gpaTf;
    private JButton addButton, updateButton, deleteButton, clearButton,Logout;
    private Font f, f1, f2;
    private JTable table;
    private DefaultTableModel model;
    private JScrollPane scroll;
    private String[] columns = {"First name", "Last name", "Phone number", "GPA"};
    private String[] rows = new String[4];
    private Cursor cursor;

    Student() {
        initComponants();
    }

    public void initComponants() {
        this.setSize(765, 690);
        this.setLocationRelativeTo(null);
        this.setTitle("Student Table @Abir Hasan");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        f = new Font("Arial", Font.BOLD, 18);
        f1 = new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 18);
        f2 = new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT + Font.BOLD, 18);

        cursor = new Cursor(Cursor.HAND_CURSOR);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.LIGHT_GRAY);
        // Label, textField, Button Create Here.
        
        //LogOut
        Logout = new JButton("LogOut");
        Logout.setBounds(550, 150, 100, 30);
        Logout.setFont(f2);
        Logout.setCursor(cursor);
        Logout.setForeground(Color.RED);
        c.add(Logout);
        
        //title label
        titleLabel = new JLabel("Student Registration");
        titleLabel.setFont(f);
        titleLabel.setBounds(280, 10, 250, 50);
        c.add(titleLabel);

//        first name...
        fnLabel = new JLabel("First Name ");
        fnLabel.setBounds(10, 80, 140, 30);
        fnLabel.setFont(f);
        c.add(fnLabel);

        fnTf = new JTextField();
        fnTf.setBounds(110, 80, 200, 30);
        fnTf.setFont(f1);
        c.add(fnTf);

        addButton = new JButton("Add");
        addButton.setBounds(400, 80, 100, 30);
        addButton.setFont(f2);
        addButton.setForeground(Color.BLUE);
        addButton.setCursor(cursor);
        c.add(addButton);

        //Last Name
        lnLabel = new JLabel("Last Name ");
        lnLabel.setBounds(10, 130, 150, 30);
        lnLabel.setFont(f);
        c.add(lnLabel);

        lnTf = new JTextField();
        lnTf.setBounds(110, 130, 200, 30);
        lnTf.setFont(f1);
        c.add(lnTf);

        updateButton = new JButton("Update");
        updateButton.setBounds(400, 130, 100, 30);
        updateButton.setFont(f2);
        updateButton.setForeground(Color.orange);
        updateButton.setCursor(cursor);
        c.add(updateButton);

        //Phone...
        phoneLabel = new JLabel("Phone ");
        phoneLabel.setBounds(10, 180, 150, 30);
        phoneLabel.setFont(f);
        c.add(phoneLabel);

        phoneTf = new JTextField();
        phoneTf.setBounds(110, 180, 200, 30);
        phoneTf.setFont(f1);
        c.add(phoneTf);
        deleteButton = new JButton("Delete");
        deleteButton.setBounds(400, 180, 100, 30);
        deleteButton.setFont(f2);
        deleteButton.setForeground(Color.RED);
        deleteButton.setCursor(cursor);
        c.add(deleteButton);

        //GPA...
        gpaLabel = new JLabel("GPA ");
        gpaLabel.setBounds(10, 230, 150, 30);
        gpaLabel.setFont(f);
        c.add(gpaLabel);

        gpaTf = new JTextField();
        gpaTf.setBounds(110, 230, 200, 30);
        gpaTf.setFont(f1);
        c.add(gpaTf);

        clearButton = new JButton("Clear");
        clearButton.setBounds(400, 230, 100, 30);
        clearButton.setFont(f2);
        clearButton.setCursor(cursor);
        clearButton.setForeground(Color.MAGENTA);
        c.add(clearButton);

        // table Create..
        table = new JTable();

        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.setFont(f1);
        table.setBackground(Color.white);
        table.setRowHeight(30);
        table.setSelectionBackground(Color.GREEN);

        //Scroll Pane add
        scroll = new JScrollPane(table);
        scroll.setBounds(10, 360, 740, 265);
        c.add(scroll);

        //ActionListener//
        addButton.addActionListener(this);
        Logout.addActionListener(this);
        clearButton.addActionListener(this);
        deleteButton.addActionListener(this);
        updateButton.addActionListener(this);

        //Add Mouse Listenr for updadte data
        table.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                int numberOfRow = table.getSelectedRow();

                //get value when i clecked a row/
                String f_name = model.getValueAt(numberOfRow, 0).toString();
                String l_name = model.getValueAt(numberOfRow, 1).toString();
                String phone = model.getValueAt(numberOfRow, 2).toString();
                String gpa = model.getValueAt(numberOfRow, 3).toString();

                //now receved value set to all specific text field.
                fnTf.setText(f_name);
                lnTf.setText(l_name);
                phoneTf.setText(phone);
                gpaTf.setText(gpa);

            }

        });

    }

    // Action Listener
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            //data add in row

            rows[0] = fnTf.getText();
            rows[1] = lnTf.getText();
            rows[2] = phoneTf.getText();
            rows[3] = gpaTf.getText();

            if (rows[0].isEmpty() || rows[1].isEmpty() || rows[2].isEmpty() || rows[3].isEmpty()) {
                JOptionPane.showMessageDialog(null, "Plese Fill up all Column..", "Warning!!!", JOptionPane.WARNING_MESSAGE);
            } else {

                model.addRow(rows);
                //after add auto clear all textField
                fnTf.setText("");
                lnTf.setText("");
                phoneTf.setText("");
                gpaTf.setText("");
            }

        } else if (e.getSource() == clearButton) {
            //clear all text..

            fnTf.setText("");
            lnTf.setText("");
            phoneTf.setText("");
            gpaTf.setText("");
        } //for delete button
        else if (e.getSource() == deleteButton) {

            int numberOfRow = table.getSelectedRow(); // get row number

            if (numberOfRow >= 0) { // row valu doesn't "<0" or "negetive"//
                model.removeRow(numberOfRow); // pass row index number

                //delete previous screend data
                fnTf.setText("");
                lnTf.setText("");
                phoneTf.setText("");
                gpaTf.setText("");
            } else { // warning if dosen't select any row or not exist any row.
                JOptionPane.showMessageDialog(null, "No row is Selected or No row exist in Table!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } // Update button //
        else if (e.getSource() == updateButton) {
            int numberOfRow = table.getSelectedRow();

            String f_name = fnTf.getText();
            String l_name = lnTf.getText();
            String phone = phoneTf.getText();
            String gpa = gpaTf.getText();

            //check any row is empty or not..
            if (f_name.isEmpty() || l_name.isEmpty() || phone.isEmpty() || gpa.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No Data For Update..", "Warning !!", JOptionPane.WARNING_MESSAGE);
            } else {

                // Now set all get value in textFeld
                model.setValueAt(f_name, numberOfRow, 0);
                model.setValueAt(l_name, numberOfRow, 1);
                model.setValueAt(phone, numberOfRow, 2);
                model.setValueAt(gpa, numberOfRow, 3);

                //clear previous data
                fnTf.setText("");
                lnTf.setText("");
                phoneTf.setText("");
                gpaTf.setText("");

            }

        }
        
        else if (e.getSource() == Logout) {
            int option = JOptionPane.showConfirmDialog(null,"Do You Exit ?","Warning!",JOptionPane.YES_NO_OPTION);
            
            if (option == JOptionPane.YES_OPTION) {
            LoginFrame frame = new LoginFrame();
            frame.setVisible(true);
            dispose();
                
            }
            else{
//               No required work here...
            }
        }
    }

    public static void main(String[] args) {
        Student frame = new Student();
        frame.setVisible(true);
    }

}
