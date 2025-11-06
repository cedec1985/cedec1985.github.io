package classes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


public class BlackjackUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private static BufferedImage image;
	private int nouvelleLargeur;
	private int nouvelleHauteur;
    JMenuBar mainMenuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("Fichier");
    JMenuItem newMenuItem = new JMenuItem("Nouvelle partie");
    JMenuItem exitMenuItem = new JMenuItem("Quitter");
    JTextField dealerTextField = new JTextField();
    JTextField playerTextField = new JTextField();   
    JLabel winningsLabel = new JLabel();
    JPanel statsBorder = new JPanel();
    JTextField winningsTextField = new JTextField();                            //image du dos de la carte
    private final JLabel[] dealerLabels = new JLabel[6];
    private final JLabel[] playerLabels = new JLabel[6];
    private final JLabel dealerScoreLabel, playerScoreLabel, statusLabel;
    private final JLabel statsLabel=new JLabel();
    private final JLabel label = new JLabel();
    private final JPanel gamePicture = new JPanel();
    private final JPanel dealerLabel = new JPanel();
    private final JPanel playerLabel = new JPanel();
    private final JButton hitButton = new JButton();
    private final JButton standButton = new JButton();
    private final JButton restartButton = new JButton();
    private final Deck deck;
    private final List<Card> playerHand = new ArrayList<>();
    private final List<Card> dealerHand = new ArrayList<>();
    Border raisedbevel = BorderFactory.createRaisedBevelBorder();
    Border loweredbevel = BorderFactory.createLoweredBevelBorder();
    private Image background;  // image de fond
    private Image cardImage;   // image principale (Blackjack)

    // Statistiques
    private int wins = 0;
    private int losses = 0;
    private int ties = 0;
        
    public BlackjackUI(){  
        
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gridConstraints;
        gamePicture.setSize(800, 800);
 
        //String inImg = "src/classes/Blackjack.jpg";
        //String outImg = "src/classes/test_1200x628.jpg";
        //int width = 250;
		//int height = 620;
		//BlackjackUI.changeSize(inImg, outImg, width, height);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        gridConstraints.gridwidth = 6;
        gridConstraints.insets = new Insets(10, 10, 10, 10);
        // Récupération de l'icône depuis l'enum Icons
        Icon icon = Icons.BLACKJACK;
        
        // Création d’un label pour afficher l’image
        JLabel logo = new JLabel(icon);
        //gamePicture.add(logo);
        getContentPane().add(logo,gridConstraints);
        getContentPane().add(gamePicture,gridConstraints);
        
        //getContentPane().add(BlackjackUI.changeSize(inImg, outImg, nouvelleLargeur, nouvelleHauteur),gridConstraints);
        
        // Ajout du label à la fenêtre
        setTitle("jeu du Blackjack");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(192, 192, 255));
        setResizable(true);
		
        deck = new Deck();
      
        // Menu
        setJMenuBar(mainMenuBar);
        mainMenuBar.add(fileMenu);
        fileMenu.add(newMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);
        newMenuItem.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        newMenuItemActionPerformed(e);
}
});
        exitMenuItem.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        exitMenuItemActionPerformed(e);
}
});

dealerLabel.setFont(new Font("Arial", Font.BOLD, 14)); 
gridConstraints = new GridBagConstraints(); 
gridConstraints.gridx = -1;
gridConstraints.gridy = 1;
gridConstraints.gridwidth = 6;
gridConstraints.insets = new Insets(10, 10, 10, 0);
getContentPane().add(dealerLabel, gridConstraints);
dealerTextField.setPreferredSize(new Dimension(130, 30));
dealerTextField.setFont(new Font("Comic Sans MS", Font.PLAIN, 14)); 
dealerTextField.setBackground(new Color(255, 255, 128));
dealerTextField.setText("cartes du dealer");   
dealerTextField.setForeground(Color.BLUE);
dealerTextField.setEditable(true);
gridConstraints = new GridBagConstraints();
gridConstraints.gridx = 12;
gridConstraints.gridy = 1;
gridConstraints.gridwidth = 2;
gridConstraints.insets = new Insets(10, 10, 10, 10);
getContentPane().add(dealerTextField, gridConstraints);

for (int i = 0; i < 6; i++)
{
dealerLabels[i] = new JLabel();
dealerLabels[i].setPreferredSize(new Dimension(60, 100));
dealerLabels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
gridConstraints = new GridBagConstraints(); 
gridConstraints.gridx = i;
gridConstraints.gridy = 1;
gridConstraints.insets = new Insets(10, 10, 10, 0); 
getContentPane().add(dealerLabels[i], gridConstraints); 
}

playerLabel.setFont(new Font("Arial", Font.BOLD, 14));
gridConstraints = new GridBagConstraints(); 
gridConstraints.gridx = 4;
gridConstraints.gridy = 3;
gridConstraints.gridwidth = 6;
gridConstraints.anchor = GridBagConstraints.WEST;
gridConstraints.insets = new Insets(10, 10, 10, 0);
getContentPane().add(playerLabel, gridConstraints);
playerTextField.setPreferredSize(new Dimension(130, 30));
playerTextField.setFont(new Font("Comic Sans MS", Font.PLAIN, 14)); 
playerTextField.setBackground(new Color(255, 255, 128));
playerTextField.setText("cartes du joueur");
playerTextField.setForeground(Color.BLUE);
playerTextField.setEditable(true);
gridConstraints = new GridBagConstraints(); 
gridConstraints.gridx = 12;
gridConstraints.gridy = 4;
gridConstraints.gridwidth = 2;
gridConstraints.insets = new Insets(10, 10, 10, 10);
getContentPane().add(playerTextField, gridConstraints); 
for (int i =0; i < 6; i++)
{
playerLabels[i] = new JLabel();
playerLabels[i].setPreferredSize(new Dimension(60, 100));
playerLabels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
gridConstraints = new GridBagConstraints();
gridConstraints.gridx = i;
gridConstraints.gridy = 4;
gridConstraints.insets = new Insets(10, 10, 10, 0); 
getContentPane().add(playerLabels[i], gridConstraints); 
}
        // Panels pour dealer et joueur
        // --- PANNEAUX ---

        // Scores
        gridConstraints = new GridBagConstraints(); 
        gridConstraints.gridx = 7;
        gridConstraints.gridy = 1;
        gridConstraints.gridwidth = 2;
        gridConstraints.insets = new Insets(10, 10, 10, 10);
        dealerScoreLabel = new JLabel("Score dealer : ?");
        dealerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(dealerScoreLabel,gridConstraints);
        
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 7;
        gridConstraints.gridy = 4;
        gridConstraints.gridwidth = 2;
        gridConstraints.insets = new Insets(10, 10, 10, 10);
        playerScoreLabel = new JLabel("Score joueur : 0");
        playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(playerScoreLabel,gridConstraints);

        // Statistiques
        gridConstraints = new GridBagConstraints(); 
        gridConstraints.gridx = 3;
        gridConstraints.gridy = 8;
        gridConstraints.gridwidth = 8;
        gridConstraints.insets = new Insets(20,20,20,20);
        statsBorder.setSize(new Dimension(350,350));
        statsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        statsLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        statsLabel.setPreferredSize(new Dimension(300,300));
        statsBorder.add(createImageBorder(),gridConstraints);
        getContentPane().add(statsBorder,gridConstraints);
      
        
        // Statut du jeu
        gridConstraints = new GridBagConstraints(); 
        gridConstraints.gridx = -2;
        gridConstraints.gridy = 0;
        gridConstraints.gridwidth = 4;
        gridConstraints.insets = new Insets(10, 10, 10, 10);
        statusLabel = new JLabel("Bienvenue au Blackjack !");
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        statusLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        getContentPane().add(statusLabel, gridConstraints);
     

        // Événements
        hitButton.addActionListener(e -> hit());
        hitButton.setText("Tirer");
        hitButton.setFont(new Font("Arial", Font.BOLD, 14));
        gridConstraints = new GridBagConstraints(); 
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 6;
        gridConstraints.insets = new Insets(10, 0, 10, 0);
        getContentPane().add(hitButton, gridConstraints);
        
        standButton.addActionListener(e -> stand()); 
        standButton.setText("Garder");
        standButton.setFont(new Font("Arial", Font.BOLD, 14));
        gridConstraints = new GridBagConstraints(); 
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 6;
        gridConstraints.insets = new Insets(10, 0, 10, 0);
        getContentPane().add(standButton, gridConstraints);

        restartButton.addActionListener(e -> restartGame());
        restartButton.setText("Partager");
        restartButton.setFont(new Font("Arial", Font.BOLD, 14));
        gridConstraints = new GridBagConstraints(); 
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 6;
        gridConstraints.insets = new Insets(10, 0, 10, 0);
        getContentPane().add(restartButton, gridConstraints);

pack();

Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
setBounds((int) (0.5*(screenSize.width - getWidth())), (int) (0.5* (screenSize.height - getHeight())),
getWidth(), getHeight()); 

        distributeInitialCards();
        newMenuItem.doClick();
        setVisible(true);
    }

	// ---------------------
    // LOGIQUE DU JEU
    // ---------------------

    private void distributeInitialCards() {
        playerHand.clear();
        dealerHand.clear();

        // Effacer les anciennes cartes
        for (int i = 0; i < 6; i++) {
            playerLabels[i].setIcon(null);
            dealerLabels[i].setIcon(null);
        }

        // Distribuer 2 cartes chacun
        playerHand.add(deck.drawCard());
        playerHand.add(deck.drawCard());
        dealerHand.add(deck.drawCard());
        dealerHand.add(deck.drawCard());

        updateHandsDisplay(false);
        updateScoreLabels(false);
        statusLabel.setText("À vous de jouer !");
    }

    private void updateHandsDisplay(boolean showDealerAll) {
        for (int i = 0; i < playerHand.size(); i++) {
            playerLabels[i].setIcon(playerHand.get(i).getImage());
        }

        for (int i = 0; i < dealerHand.size(); i++) {
            if (i == 0 || showDealerAll) {
                dealerLabels[i].setIcon(dealerHand.get(i).getImage());
            } else {
                dealerLabels[i].setIcon(new ImageIcon("classes/Blackjack copy.jpg")); // dos de carte
            }
        }
    }

    private void updateScoreLabels(boolean showDealerAll) {
        int playerScore = calculateScore(playerHand);
        int dealerScore = calculateScore(dealerHand);

        playerScoreLabel.setText("Score joueur : " + playerScore);
        dealerScoreLabel.setText("Score dealer : " + (showDealerAll ? dealerScore : "?"));
    }

    private void hit() {
        if (playerHand.size() < 6) {
            playerHand.add(deck.drawCard());
            updateHandsDisplay(false);
            updateScoreLabels(false);

            int score = calculateScore(playerHand);
            if (score > 21) {
                losses++;
                endRound("💥 Vous avez dépassé 21 ! Vous perdez 😢");
            }
        }
    }

    private void stand() {
        // Le dealer tire jusqu’à 17 ou plus
        while (calculateScore(dealerHand) < 17) {
            dealerHand.add(deck.drawCard());
        }

        updateHandsDisplay(true);
        updateScoreLabels(true);

        int playerScore = calculateScore(playerHand);
        int dealerScore = calculateScore(dealerHand);

        if (dealerScore > 21 || playerScore > dealerScore) {
            wins++;
            endRound(" Vous gagnez ! (" + playerScore + " contre " + dealerScore + ")");
        } else if (dealerScore == playerScore) {
            ties++;
            endRound(" Égalité (" + playerScore + ")");
        } else {
            losses++;
            endRound(" Le dealer gagne (" + dealerScore + " contre " + playerScore + ")");
        }
    }

    private void restartGame() {
        playerHand.clear();
        dealerHand.clear();
        deck.shuffle();
        distributeInitialCards();
        hitButton.setEnabled(true);
        standButton.setEnabled(true);
        statusLabel.setText("Nouvelle manche ! À vous de jouer.");
        updateStats();
    }

    private void endRound(String message) {
        updateHandsDisplay(true);
        updateScoreLabels(true);
        statusLabel.setText(message);
        hitButton.setEnabled(false);
        standButton.setEnabled(false);
        updateStats();
    }

    private void updateStats() {
        label.setText(getStatsText());
    }

    private String getStatsText() {
        return "<html><center>"
             + "<b>Statistiques </b><br>"
             + "Victoires : " + wins + "<br>"
             + "Défaites : " + losses + "<br>"
             + "Égalités : " + ties
             + "</center></html>";
    }
    // 🔹 Fonction pour créer un JLabel stylisé avec bordure et police agrandie
     private JLabel createImageBorder() {
    	 
        // Style du texte
        label.setFont(new Font("Arial", Font.BOLD, 18));
        Border blueline = BorderFactory.createLineBorder(Color.green);

      //Titled borders
        TitledBorder title;
        title = BorderFactory.createTitledBorder(
                               blueline, "statistiques");
        title.setTitleJustification(TitledBorder.TOP);
        label.setBorder(title);

        // Fond blanc (optionnel, mais joli avec une bordure)
        label.setOpaque(true);
        label.setBackground(Color.YELLOW);
        label.setLabelFor(statusLabel);
        updateStats();
        getContentPane().add(label);

        return label;
    }

    private int calculateScore(List<Card> hand) {
        int total = 0;
        int aceCount = 0;

        for (Card c : hand) {
            total += c.getValue();
            if (c.getRank().equals("A")) aceCount++;
        }

        while (total > 21 && aceCount > 0) {
            total -= 10;
            aceCount--;
        }

        return total;
    }
    private void newMenuItemActionPerformed(ActionEvent e) {
      restartGame();
    }
    @SuppressWarnings("unused")
    private void exitForm(WindowEvent evt) {
      System.exit(0);
   }
   private void exitMenuItemActionPerformed(ActionEvent e) {
      System.exit(0);
}
   public static void changeSize(String inImg, String outImg, int w, int h)
	   throws IOException 
	   {
	        // lit l'image d'entrée
	        File f = new File(inImg);
	        BufferedImage inputImage = ImageIO.read(f);
	   
	        // crée l'image de sortie
	        BufferedImage img = new BufferedImage(w, h, inputImage.getType());
	   
	        // balancer l'image d'entrée à l'image de sortie
	        Graphics2D g = img.createGraphics();
	        g.drawImage(inputImage, 0, 0, w, h, null);
	        g.dispose();
	   
	        // extrait l'extension du fichier de sortie
	        String name = outImg.substring(outImg.lastIndexOf(".") + 1);
	   
	        // écrit dans le fichier de sortie
	        ImageIO.write(img, name, new File(outImg));
}
   
    public static void main(String[] args) {
    	
        SwingUtilities.invokeLater(() -> {
	
			BlackjackUI game = 	new BlackjackUI();
			  game.setVisible(true);
			
		});
    }
}
