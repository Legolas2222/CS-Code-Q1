import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Eine I/O-Klasse. Die Klasse bietet Methoden für die Bereiche <ul> <li>I/O für das DOS-Fenster</li> <li>O für Pop-Up-Fenster aus einem Frame/ JFrame</li>
 * <li>I/O für das Dateisystem (Speichern von Objekten)</li> <li>O für WAV-Dateien</li> </ul>
 *
 * @version 2.0.1 vom 01.12.2014
 * @author Markus Minklai
 */
public class EinAusgabe {

  static BufferedReader ein; // Objekt zum Lesen der Tastatureingabe

  /**
   * Ein Fenster-Pop-Up wird erzeugt.
   *
   * @param pFrame Die Instanz, die das Pop-Up aufruft
   * @param pNachricht Die Nachricht, die gegeben werden soll.
   * @param pTitel Titel des Pop-Ups.
   * @param pTyp Als Typ stehen zu Auswahl: <ul> <li>Fehler</li>
   * <li>Information</li> <li>Warnung</li> <li>Frage</li> </ul>
   */
  static public void nachricht(JFrame pFrame, String pNachricht, String pTitel, String pTyp) {
    String lTyp = pTyp.toLowerCase(Locale.getDefault());
    int optionType = JOptionPane.ERROR_MESSAGE;
    if (lTyp.compareTo("information") == 0) {
      optionType = JOptionPane.INFORMATION_MESSAGE;
    } else if (lTyp.compareTo("warnung") == 0) {
      optionType = JOptionPane.WARNING_MESSAGE;
    } else if (lTyp.compareTo("frage") == 0) {
      optionType = JOptionPane.QUESTION_MESSAGE;
    }
    JOptionPane.showMessageDialog(pFrame, pNachricht, pTitel, optionType);
  }

  /**
   * Schreibe das Objekt in die angegebene Datei.
   *
   * @param pObjekt Das Objekt welches gespeichert werden soll.
   * @param pDateiname Das Name der Datei, in der das Objekt gespeichert werden soll.
   */
  static public void schreibeDatei(Object pObjekt, String pDateiname) {
    ObjectOutputStream out = null;
    try {
      FileOutputStream fos = new FileOutputStream(pDateiname);
      out = new ObjectOutputStream(fos);
      out.writeObject(pObjekt);
    } catch (FileNotFoundException ex) {
      Logger.getLogger(EinAusgabe.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(EinAusgabe.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      if (out != null) {
        try {
          out.close();
        } catch (IOException ex) {
          Logger.getLogger(EinAusgabe.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }
  }

  /**
   * Liest das Objekt aus der angegebenen Datei ein.
   *
   * @param pDateiname Das Name der Datei, in der das Objekt gespeichert ist.
   * @return Die Datei als Object
   */
  static public Object liesDatei(String pDateiname) {
    Object lObject = null;
    ObjectInputStream in = null;
    try {
      FileInputStream fis = new FileInputStream(pDateiname);
      in = new ObjectInputStream(fis);
      lObject = in.readObject();
      in.close();
      return lObject;
    } catch (FileNotFoundException ex) {
      Logger.getLogger(EinAusgabe.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException | ClassNotFoundException ex) {
      Logger.getLogger(EinAusgabe.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      if (in != null) {
        try {
          in.close();
        } catch (IOException ex) {
          Logger.getLogger(EinAusgabe.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }
    return lObject;
  }

  /**
   * Spielt eine WAV-Datei ab
   *
   * @param pDateiname Vollständiger Pfad und Name der Datei. \ mit \\ angeben.
   */
  static public void spieleWAVDatei(String pDateiname) {
    AudioInputStream ais = null;
    float gain = 1;
    try {
      ais = AudioSystem.getAudioInputStream(new File(pDateiname));
      AudioFormat format = ais.getFormat();
      if ((format.getEncoding() == AudioFormat.Encoding.ULAW) || (format.getEncoding() == AudioFormat.Encoding.ALAW)) {
        AudioFormat tmp = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, format.getSampleRate(), format.getSampleSizeInBits() * 2, format.getChannels(), format.getFrameSize() * 2, format.getFrameRate(), true);
        ais = AudioSystem.getAudioInputStream(tmp, ais);
        format = tmp;
      }
      DataLine.Info info = new DataLine.Info(Clip.class, format, ((int) ais.getFrameLength() * format.getFrameSize()));
      try (Clip clip = (Clip) AudioSystem.getLine(info)) {
        clip.open(ais);

        //MASTER_GAIN einstellen
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(gain);

        // Clip abspielen
        clip.start();
        while (true) {
          Thread.sleep(100);

          if (!clip.isRunning()) {
            break;
          }
        }
        clip.stop(); // Hammer Time
        clip.close();
      }
    } catch (LineUnavailableException | IOException | InterruptedException | UnsupportedAudioFileException ex) {
      Logger.getLogger(EinAusgabe.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      try {
        if (ais != null) {
          ais.close();
        }
      } catch (IOException ex) {
        Logger.getLogger(EinAusgabe.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
}
