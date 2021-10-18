package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Hepler {

    private Hepler() {
    }

    public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

    public static boolean checkNull(JTextField tf, String mss) {
        if (tf.getText().equals("")) {
            JOptionPane.showMessageDialog(null, mss);
            tf.requestFocus();
            return true;
        }
        return false;
    }

    public static boolean checkNumber(JTextField tf, String mss) {
        try {
            double so = Integer.parseInt(tf.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, mss);
            tf.requestFocus();
            return true;
        }
        return false;
    }

    public static boolean checkDate(JTextField tf, String mss) {
        try {
            Date date = SIMPLE_DATE_FORMAT.parse(tf.getText());

        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, mss);
            tf.requestFocus();
            return true;
        }
        return false;
    }

    public static boolean checkSDT(JTextField tf) {
        Pattern ptrn = Pattern.compile("(0/91)?[7-9][0-9]{9}");

        Matcher match = ptrn.matcher(tf.getText());
//returns a boolean value  
        return (match.find() && match.group().equals(tf.getText()));
    }
    public static boolean checkMail(String email) {
      String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
      return email.matches(regex);
   }
}

