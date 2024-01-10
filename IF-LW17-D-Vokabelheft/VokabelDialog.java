import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VokabelDialog extends JDialog {

  private Label label1 = new Label();
  protected TextField EdEnglisch = new TextField();
  protected TextField EdDeutsch = new TextField();
  private Label label2 = new Label();
  private JButton btOK = new JButton();
  private JButton btAbbrechen = new JButton();

  public VokabelDialog(Frame owner, String title, boolean modal) {
    // Dialog-Initialisierung
    super(owner, title, modal);
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent evt) {
        dispose();
      }
    });

    int frameWidth = 359; 
    int frameHeight = 305;
    setSize(frameWidth, frameHeight);

    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);

    Panel cp = new Panel(null);
    add(cp);
    // Anfang Komponenten
    label1.setBounds(16, 8, 59, 20);
    label1.setText("Vokabel");
    label1.setFont(new Font("Dialog", Font.BOLD, 13));
    cp.add(label1);
    EdEnglisch.setBounds(16, 32, 209, 24);
    EdEnglisch.setText("");
    EdEnglisch.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(EdEnglisch);
    EdDeutsch.setBounds(16, 88, 209, 24);
    EdDeutsch.setText("");
    EdDeutsch.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(EdDeutsch);
    label2.setBounds(16, 64, 57, 20);
    label2.setText("Deutsch");
    label2.setFont(new Font("Dialog", Font.BOLD, 13));
    cp.add(label2);
    btOK.setBounds(16, 128, 139, 25);
    btOK.setText("OK");
    btOK.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(btOK);
    btOK.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent evt) {
        btOK_ActionPerformed(evt);
      }
    });

    btAbbrechen.setBounds(16, 160, 139, 25);
    btAbbrechen.setText("Lieber doch nicht");
    btAbbrechen.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(btAbbrechen);
    btAbbrechen.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent evt) {
        btAbbrechen_ActionPerformed(evt);
      }
    });

    // Ende Komponenten
    setResizable(false);
    setVisible(true);
  }

  public String getDeutsch() {
    return EdDeutsch.getText();
  }

  public String getEnglisch() {
    return EdEnglisch.getText();
  }

  public void btOK_ActionPerformed(ActionEvent evt) {
    this.dispose();
  }

  public void btAbbrechen_ActionPerformed(ActionEvent evt) {
    EdEnglisch.setText("");
    EdDeutsch.setText("");
    this.dispose();
  }
}
