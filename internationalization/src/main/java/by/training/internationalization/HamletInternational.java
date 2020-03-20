package by.training.internationalization;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class HamletInternational {
    public static void main(String[ ] args) {
        for (int i = 0; i < 3; i++) {
            System.out.println("1 — английский \n2 — белорусский \n любой — русский ");
            char ic = 0;
            try {
                ic = (char) System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String country = "";
            String language = "";
            switch (ic) {
                case '1':
                    country = "en";
                    language = "EN";
                    break;
                case '2':
                    country = "by";
                    language = "BY";
                    break;
            }
            Locale current = new Locale(language, country);
            ResourceBundle rb = ResourceBundle.getBundle("property.text", current);
            String s1 = rb.getString("str1");
            System.out.println(s1);
            String s2 = rb.getString("str2");
            System.out.println(s2);
        }
    }
}
