package classes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class BlackjackUI extends JFrame {
	
	JPanel horloge = new JPanel();
	JPanel panelZoom = new JPanel();
	private ImagePanel panelImage;
	private static final long serialVersionUID = 1L;
    JMenuBar mainMenuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("Fichier");
    JMenuItem newMenuItem = new JMenuItem("Nouvelle partie");
    JMenuItem rules = new JMenuItem("apprendre à jouer");
    JMenuItem exitMenuItem = new JMenuItem("Quitter");
    JLabel winningsLabel = new JLabel();
    JPanel statsBorder = new JPanel();
    JTextField winningsTextField = new JTextField();                            //image du dos de la carte
    private final JLabel[] dealerLabels = new JLabel[6];
    private final JLabel[] playerLabels = new JLabel[6];
    private final JLabel dealerScoreLabel = new JLabel("Score dealer : ?");
    private final JLabel playerScoreLabel =new JLabel("Score joueur : 0");
    private JLabel statusLabel = new JLabel();
    private final JLabel statsLabel=new JLabel();
    private final JLabel label = new JLabel();
    private final JPanel dealerLabel = new JPanel();
    private final JPanel playerLabel = new JPanel();
    private final JButton hitButton = new JButton();
    private final JButton standButton = new JButton();
    private final JButton restartButton = new JButton();
    private static Deck deck = new Deck();
    private final List<Card> playerHand = new ArrayList<>();
    private final List<Card> dealerHand = new ArrayList<>();
    Border raisedbevel = BorderFactory.createRaisedBevelBorder();
    Border loweredbevel = BorderFactory.createLoweredBevelBorder();
    JButton zoomInButton = new JButton();
    JButton zoomOutButton = new JButton();

    // Statistiques
    private int wins = 0;
    private int losses = 0;
    private int ties = 0;
        
    public BlackjackUI(Deck deck) throws IOException{ 
    	super("Fenêtre avec fond d'écran");
    	//splashscreen
        SplashScreen splash = SplashScreen.getSplashScreen();
        if (splash == null) {
            System.out.println("Aucun SplashScreen trouvé !");
            return;
        }

        Graphics2D g = splash.createGraphics();
        if (g == null) {
            System.out.println("Impossible d'obtenir le contexte graphique du splash.");
            return;
        }

        for (int i = 0; i <= 100; i++) {
            dessinerSplash(g, splash, i, "Chargement... " + i + "%");
            try {
                Thread.sleep(50); // simulation du chargement
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    	
        // Création duJPanel avec l'image de fond
        try {
            panelImage = new ImagePanel("src/classes/table.jpg"); // Remplacez par le chemin de votre image
        } catch (IOException e) {
            e.printStackTrace();
            panelImage = new ImagePanel(); // Un panneau vide en cas d'erreur
        }
        
        // Définir le layout manager pour le panelImage (ex: null pour positionnement absolu)
        panelImage.setLayout(null);
        panelImage.setSize(800,800);
        // Ajout du panelImage au JFrame (ceci doit être fait en dernier)
        setContentPane(panelImage);
        setVisible(true);
        
        // ➕ Ajout du composant horloge au centre
        MyClock clockPanel = new MyClock();
        panelImage.add(clockPanel, BorderLayout.CENTER);
        
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gridConstraints;
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        gridConstraints.gridwidth = 6;
        gridConstraints.insets = new Insets(10, 0, 0, 10);
      /*  // Récupération de l'icône depuis l'enum Icons
        //Icon icon = Icons.BLACKJACK;
        //redimensionnement du logo
         //BufferedImage imageZoom = ImageUtils.redimensionnerImage((File) icon, 300, 200);
         //if(imageZoom != null) {
     	//	JLabel labelimage = new JLabel(new ImageIcon(imageZoom));
     	//	gamePicture.add(labelimage,BorderLayout.CENTER);
     	//} else {
     	//	gamePicture.add(new JLabel("Erreur : image introuvable"));
     	//}
        //setContentPane(gamePicture);
        //setVisible(true);
z
        */
        // ajouter une image redimenssionnée
        JPanel panelimage = new JPanel ();
    	panelimage.setSize(300,400);
    	//redimensionnement
    	BufferedImage image = ImageUtils.redimensionnerImage(new File("src/classes/jeton.jpg"), 300, 200);
    	//Affichage
    	if(image != null) {
    		JLabel labelimage = new JLabel(new ImageIcon(image));
    		panelimage.add(labelimage,BorderLayout.CENTER);
    	} else {
    		panelimage.add(new JLabel("Erreur : image introuvable"));
    	}
    	panelimage.setVisible(true);
    	getContentPane().add(panelimage);
    	// Ajout du label à la fenêtre
        getContentPane().setBackground(new Color(192, 192, 255));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
		this.deck = deck;
		
        deck = new Deck();
      
        // Menu
        setJMenuBar(mainMenuBar);
        mainMenuBar.add(fileMenu);
        fileMenu.add(newMenuItem);
        fileMenu.add(rules);
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
        rules.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        try {
			rulesActionPerformed(e);
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}
        	}
        }); 

gridConstraints = new GridBagConstraints(); 
gridConstraints.gridx = -1;
gridConstraints.gridy = 1;
gridConstraints.gridwidth = 3;
gridConstraints.insets = new Insets(10, 10, 10, 0);
getContentPane().add(dealerLabel, gridConstraints);

for (int i = 0; i < 6; i++)
{
dealerLabels[i] = new JLabel();
dealerLabels[i].setPreferredSize(new Dimension(140, 120));
dealerLabels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
gridConstraints = new GridBagConstraints(); 
gridConstraints.gridx = i;
gridConstraints.gridy = 1;
gridConstraints.insets = new Insets(10, 10, 10, 0); 
getContentPane().add(dealerLabels[i], gridConstraints); 
}
gridConstraints = new GridBagConstraints(); 
gridConstraints.gridx = 4;
gridConstraints.gridy = 3;
gridConstraints.gridwidth = 3;
gridConstraints.insets = new Insets(10, 10, 10, 0);
getContentPane().add(playerLabel, gridConstraints);
for (int i =0; i < 6; i++)
{
playerLabels[i] = new JLabel();
playerLabels[i].setPreferredSize(new Dimension(140, 120));
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
        dealerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dealerScoreLabel.setFont(new Font("Arial",Font.BOLD,14));
        dealerScoreLabel.setForeground(Color.GREEN);
        getContentPane().add(dealerScoreLabel,gridConstraints);
        
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 7;
        gridConstraints.gridy = 4;
        gridConstraints.gridwidth = 2;
        gridConstraints.insets = new Insets(10, 10, 10, 10);
        playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        playerScoreLabel.setFont(new Font("Arial",Font.BOLD,14));
        playerScoreLabel.setForeground(Color.GREEN);
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
        //rules.doClick();
    }

 @SuppressWarnings("serial")
 // Classe pour dessiner l'image de fond
    class ImagePanel extends JPanel {
        private BufferedImage image;

        public ImagePanel(String cheminImage) throws IOException {
            this.image = ImageIO.read(new File(cheminImage));
        }

        // Panneau vide sans image par défaut
        public ImagePanel() {
            this.image = null;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image != null) {
                g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this); // Dessine l'image à la taille du panneau
            }
        }
 }
    
	// ---------------------
    // LOGIQUE DU JEU
    // ---------------------

    private void distributeInitialCards() {
        playerHand.clear();
        dealerHand.clear();

        // Effacer les anciennes cartes et afficher la carte de dos
        for (int i = 0; i < 6; i++) {
            playerLabels[i].setIcon(null);
            dealerLabels[i].setIcon(null);
            String imagePath = "images/carte de dos" + ".JPEG";
            ImageIcon icon = new ImageIcon(imagePath);
            Image scaled = icon.getImage().getScaledInstance(140, 120, java.awt.Image.SCALE_SMOOTH);
            icon = new ImageIcon(scaled);
            playerLabels[i].setIcon(icon);
            dealerLabels[i].setIcon(icon);
        }
        // Distribuer 2 cartes chacun
        playerHand.add(deck.drawCard());
        playerHand.add(deck.drawCard());
        dealerHand.add(deck.drawCard());
        dealerHand.add(deck.drawCard());

        updateHandsDisplay(true);
        updateScoreLabels(true);
        statusLabel.setText("À vous de jouer !");
    }

    private void updateHandsDisplay(boolean showDealerAll) {
        for (int i = 0; i < playerHand.size(); i++) {
            playerLabels[i].setIcon(playerHand.get(i).getImage());
          //if(playerLabels[i] != null) {
          //redimensionnement
         /* BufferedImage imageZoom = ImageUtils.redimensionnerImage(new File(playerLabels[i].toString()), 300, 200);
          Image imageRedimensionnee = imageZoom.getScaledInstance(140,120,Image.SCALE_SMOOTH);
          AffineTransform facteurZoom = new AffineTransform();
          facteurZoom.scale(2, 2);
          AffineTransformOp op = new AffineTransformOp(facteurZoom,AffineTransformOp.TYPE_BILINEAR);
          BufferedImage imageZoomée = op.filter((BufferedImage) imageRedimensionnee, null);
       // Mettre à jour le JLabel
          //playerLabels[i].setIcon(new ImageIcon(imageZoomée));
          panelZoom.setSize(800,800);
          panelZoom.add(playerLabels[i]);
          getContentPane().add(panelZoom);
          getContentPane().add(playerLabels[i],BorderLayout.CENTER);
          panelZoom.setVisible(true);
        }
     // Exemple avec un bouton "Zoom In"
        zoomInButton.addActionListener(e -> {
        	updateHandsDisplay(showDealerAll);
        });
        panelZoom.add(zoomInButton);
        zoomOutButton.addActionListener(e -> {
        //	updateHandsDisplay(showDealerAll);
        });
        panelZoom.add(zoomOutButton);
        
        */
        }
        for (int i = 0; i < dealerHand.size(); i++) {
            if (i == 0 || showDealerAll) {
                dealerLabels[i].setIcon(dealerHand.get(i).getImage());
            } else {
                dealerLabels[i].setIcon(new ImageIcon("classes/carte de dos.JPEG")); // dos de carte
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
        statusLabel.setFont(new Font("Arial",Font.BOLD,18));
        statusLabel.setForeground(Color.RED);
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
            if (c.getRank().equals("A")) 
            	aceCount++;
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
    
	private void rulesActionPerformed(ActionEvent e) throws URISyntaxException {
	  @SuppressWarnings("unused")
	  DisplayWebPage page = new DisplayWebPage();
    }
   private void exitMenuItemActionPerformed(ActionEvent e) {
      System.exit(0);
}
   
   private static void dessinerSplash(Graphics2D g, SplashScreen splash, int progress, String message) {
       if (splash == null) return;

       // Nettoyage de la zone
       g.setComposite(AlphaComposite.Clear);
       g.fillRect(0, 0, splash.getSize().width, splash.getSize().height);
       g.setComposite(AlphaComposite.SrcOver);

       // Couleurs
       g.setColor(Color.WHITE);
       g.setFont(new Font("SansSerif", Font.BOLD, 16));

       // Dessin du texte
       g.drawString(message, 20, splash.getSize().height - 20);

       // Barre de progression
       int barWidth = splash.getSize().width - 40;
       int barHeight = 15;
       int x = 20;
       int y = splash.getSize().height - 15;

       // Contour
       g.setColor(Color.GRAY);
       g.drawRect(x, y, barWidth, barHeight);

       // Remplissage proportionnel
       g.setColor(new Color(70, 130, 180)); // bleu steel
       int filled = (int) (progress * barWidth / 100.0);
       g.fillRect(x + 1, y + 1, filled - 2, barHeight - 2);

       splash.update();
   }
  
    public static void main(String[] args) {
    
        SwingUtilities.invokeLater(() -> {
        	
            try {
                BlackjackUI game = 	new BlackjackUI(deck);
                game.setVisible(true);
            } catch (IOException ex) {
            }
			
		});
    
}}