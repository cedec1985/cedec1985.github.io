/**
 * 
 */
package classes;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URISyntaxException;

public class DisplayWebPage extends JFrame {

    private static final long serialVersionUID = 1L;

    public DisplayWebPage() throws URISyntaxException {

        setTitle("Afficher la page web");
        setSize(800, 800);
        //setLocationRelativeTo(null);
        //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JEditorPane editor = new JEditorPane();
        editor.setEditable(false);
        addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent evt) {
        	closeWithMessage();
        }
        });

        try {
        	//Desktop.getDesktop().browse(new URI("https://media.joa.fr/dynmed/2ebe8c84-8fef-4002-bbb5-14eedbc9b379/black-jack-regles-jeu-joa.pdf"));
            editor.setPage("https://www.jackpots.ch/fr/regles-du-jeu/blackjack");
        } catch (IOException e) {
            editor.setContentType("text/html");
            editor.setText("<html>Impossible de charger la page</html>");
        }
        add(new JScrollPane(editor), BorderLayout.CENTER);
        setVisible(true);
    }

    // Méthode pour fermer la fenêtre depuis une autre classe
    public int closeWithMessage() {
        int rep = JOptionPane.showConfirmDialog(
                this,
                "Voulez-vous fermer cette fenêtre ?",
                "Confirmation",
                JOptionPane.YES_NO_CANCEL_OPTION
        );
        if (rep == JOptionPane.YES_OPTION) {
            dispose();
        }
		return rep;
    }

	public void setDefaultCloseOperation(Object closeWithMessage) {
		closeWithMessage();
	}
}

