import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;



public class AddressbuchGUI extends JFrame {
  // Anfang Attribute
  private Adressbuch buch;
  private JTextField nameField = new JTextField();
  private JNumberField numberField = new JNumberField();
  private JButton addButton = new JButton();
  private JLabel output = new JLabel();
  private JComboBox<String> jComboBox1 = new JComboBox<String>();
    private DefaultComboBoxModel<String> jComboBox1Model = new DefaultComboBoxModel<String>();
  private JButton detailsButton = new JButton();
  // Ende Attribute
  
  public AddressbuchGUI() { 
    // Frame-Initialisierung
    super();
    this.buch = new Adressbuch();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 231; 
    int frameHeight = 373;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Addressbuch");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    nameField.setBounds(24, 16, 158, 20);
    cp.add(nameField);
    numberField.setBounds(24, 80, 155, 20);
    numberField.setText("");
    cp.add(numberField);
    addButton.setBounds(24, 48, 75, 25);
    addButton.setText("Hinzufuegen");
    addButton.setMargin(new Insets(2, 2, 2, 2));
    addButton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    cp.add(addButton);
    output.setBounds(24, 112, 150, 44);
    output.setText("Kein Kontakt ausgewuehlt ");
    cp.add(output);
    jComboBox1.setModel(jComboBox1Model);
    jComboBox1.setBounds(24, 176, 150, 20);
    cp.add(jComboBox1);
    detailsButton.setBounds(104, 48, 75, 25);
    detailsButton.setText("Details");
    detailsButton.setMargin(new Insets(2, 2, 2, 2));
    detailsButton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton2_ActionPerformed(evt);
      }
    });
    cp.add(detailsButton);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public AddressbuchGUI
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new AddressbuchGUI();
  } // end of main
  
  public void jButton1_ActionPerformed(ActionEvent evt) {
    if(nameField.getText() == "") {
      return;
    }
    else {
      buch.kontaktSortiertHinzufügen(nameField.getText(), numberField.getInt());
      
    }
    this.numberField.clear();
    this.nameField.setText("");

  } // end of jButton1_ActionPerformed

  public void jButton2_ActionPerformed(ActionEvent evt) {
    if (this.nameField.getText() != null || this.nameField.getText() != "") {
      String name = nameField.getText();
      int nummer = buch.nummerAnzeigen(name);
      this.output.setText(String.valueOf(nummer));
    }
  } // end of jButton2_ActionPerformed

  // Ende Methoden
} // end of class AddressbuchGUI
