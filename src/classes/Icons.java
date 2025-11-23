package classes;

import java.awt.Color;

import java.awt.Component;
import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public enum Icons implements Icon {
   BLACKJACK("src/classes/blackjack.png");

   private ImageIcon icon;

   private Icons(String name) {
      this.icon = getIcon(name);
   }

   private static ImageIcon getIcon(String name) {
      return new ImageIcon(Icons.class.getResource(name));
   }
   
   public void paintIcon(Component c, Graphics g, int x, int y) {
      int offsetX = x + 10;
      int offsetY = y + 5;
      this.icon.paintIcon(c, g, offsetX, offsetY);
      g.setColor(Color.RED);
      g.drawRect(offsetX, offsetY, this.icon.getIconWidth(), this.icon.getIconHeight());
   }

   public int getIconWidth() {
      return this.icon.getIconWidth() + 10;
   }

   public int getIconHeight() {
      return this.icon.getIconHeight() + 5;
   }

   public ImageIcon getImageIcon() {
      return this.icon;
   }

}
