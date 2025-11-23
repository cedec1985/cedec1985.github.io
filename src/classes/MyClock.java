package classes;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;

public class MyClock extends JPanel {
    private static final long serialVersionUID = 1L;
    private JLabel horloge;

    public MyClock() {
        setLayout(new BorderLayout());
        horloge = new JLabel();
        horloge.setHorizontalAlignment(JLabel.CENTER);
        horloge.setFont(UIManager.getFont("Label.font").deriveFont(Font.ITALIC, 40f));

        // Affichage initial
        horloge.setText(DateFormat.getDateTimeInstance().format(new Date()));
        add(horloge, BorderLayout.CENTER);

        // Timer Swing (mise à jour toutes les secondes)
        Timer t = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                horloge.setText(DateFormat.getDateTimeInstance().format(new Date()));
            }
        });
        t.setRepeats(true);
        t.start();
    }
}
