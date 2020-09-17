package paintComponent;

// Fig. 12.34: PaintPanel.java
// Adapter class used to implement event handlers.
import java.awt.Point;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.JPanel;

public class PaintPanel extends JPanel 
{
   // list Point references
   private final ArrayList<Point> points = new ArrayList<>(); 
   Point p = new Point();

   // set up GUI and register mouse event handler
   public PaintPanel()
   {
      // handle frame mouse motion event
      addMouseMotionListener(
         new MouseMotionAdapter() // anonymous inner class
         {  
            // store drag coordinates and repaint
            @Override
            public void mouseDragged(MouseEvent event)
            {
               //points.add(event.getPoint());
            	p = event.getPoint(); 
               repaint(); // repaint JFrame
            } 
         } 
      ); 
   }

   // draw ovals in a 4-by-4 bounding box at specified locations on window
   @Override
   public void paintComponent(Graphics g) /*畫背景*/
   {
      //super.paintComponent(g); // 在此是用JPanel的paintComponent，因為我們沒寫JPanel的paintComponent所以他會把畫面重繪成空白，就等同於清除介面

      // draw all 
      //for (Point point : points)
         g.fillOval(p.x, p.y, 4, 4);
   } 
} // end class PaintPanel


/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/