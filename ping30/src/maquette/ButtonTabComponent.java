package maquette;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
 
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.plaf.basic.BasicButtonUI;
 
public class ButtonTabComponent extends JPanel{
    private final JTabbedPane pane;
 
    public ButtonTabComponent(final JTabbedPane pane) {
       super(new FlowLayout(FlowLayout.LEFT, 0, 0));
      
       if(pane == null)
           throw new NullPointerException("pane can not be null");
       this.pane = pane;
      
     
       setOpaque(false);
      
       JLabel label = new JLabel(){
         
           @Override
           public String getText() {
              int i = pane.indexOfTabComponent(ButtonTabComponent.this);
              if(i != -1)
                  return pane.getTitleAt(i);
              return null;
           }
       };
      
       label.setBorder(BorderFactory.createEmptyBorder(0,0,0,5));
       add(label);
       JButton button = new TabButton();
       add(button);
       setBorder(BorderFactory.createEmptyBorder(2,0,0,0));
    }
   
    private class TabButton extends JButton implements ActionListener{
       public TabButton() {
           final int size = 17;
           setPreferredSize(new Dimension(size,size));
           setToolTipText("fermer");
           setUI(new BasicButtonUI());
           setContentAreaFilled(false);
           setFocusable(false);
           setBorder(BorderFactory.createEtchedBorder());
           setBorderPainted(false);
          
           addActionListener(TabButton.this);
           addMouseListener(mouseListener);
          
       }
 
       @Override
       protected void paintComponent(Graphics g) {
           super.paintComponent(g);
          
           Graphics2D g2 = (Graphics2D) g.create();
           g2.setStroke(new BasicStroke(2));
           g2.setColor(Color.BLACK);
           if(getModel().isRollover())
              g2.setColor(Color.PINK);
           int delta = 6;
           g2.drawLine(delta, delta, getWidth() - delta - 1, getHeight() - delta - 1);
            g2.drawLine(getWidth() - delta - 1, delta, delta, getHeight() - delta - 1);
            g2.dispose();
       }
 
       @Override
       public void actionPerformed(ActionEvent arg0) {
           int i = pane.indexOfTabComponent(ButtonTabComponent.this);
           if(i != -1)
              pane.remove(i);
       }
      
       private final MouseListener mouseListener = new MouseAdapter() {
           @Override
           public void mouseEntered(MouseEvent event) {
              Component c = event.getComponent();
              if(c instanceof AbstractButton)
                  ((AbstractButton)c).setBorderPainted(true);
           }
          
           @Override
           public void mouseExited(MouseEvent event) {
              Component c = event.getComponent();
              if(c instanceof AbstractButton)
                  ((AbstractButton)c).setBorderPainted(false);
           }
          
       };
      
    }
   
}