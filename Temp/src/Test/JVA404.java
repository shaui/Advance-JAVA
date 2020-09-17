package Test;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class JVA404 extends JFrame {

  Container c = null;

  public JVA404(String title) {  //©w¸qJVA404Ãþ§Oªº«Øºc¤l

    super(title);
    c = this.getContentPane();
    c.setLayout(new BorderLayout());

    final JTextArea t = new JTextArea();
    t.setLineWrap(true);

    JScrollPane s = new JScrollPane(t);
    c.add(s, BorderLayout.CENTER);

    final JFileChooser fc = new JFileChooser();

    JMenuBar mb;
    JMenu fmi;    //ÀÉ®×
    JMenuItem nmi;  //¶}·sÀÉ®×
    JMenuItem omi;  //¶}±ÒÂÂÀÉ
    JMenuItem smi;  //Àx¦sÀÉ®×
    JMenuItem exmi;  //Â÷¶}

    JMenu emi;    //½s¿è
    JMenuItem cmi;  //½Æ»s
    JMenuItem pmi;  //¶K¤W
    JMenuItem cutmi;  //°Å¤U

    mb = new JMenuBar();
    mb.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
    setJMenuBar(mb);

    fmi = new JMenu("ÀÉ®×");


    //«Ø¥ß¡u¶}·sÀÉ®×¡v¥\¯à¡A©w¸q¨Æ¥ó¡A¨Ã¥[¤J¿ï³æ¤¤
    nmi = new JMenuItem("¶}·sÀÉ®×");

    nmi.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        t.setText("");
      }
    });

    fmi.add(nmi);


    //«Ø¥ß¡u¶}±ÒÂÂÀÉ¡v¥\¯à¡A©w¸q¨Æ¥ó¡A¨Ã¥[¤J¿ï³æ¤¤
    omi = new JMenuItem("¶}±ÒÂÂÀÉ");

   omi.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent ae){
         int yesornot = fc.showOpenDialog(JVA404.this);
         if(yesornot == JFileChooser.APPROVE_OPTION){
            try{
               String line;
               File f = fc.getSelectedFile();
               BufferedReader br = new BufferedReader(new FileReader(f.getAbsolutePath()));
               t.setText(br.readLine());
               while( (line = br.readLine()) != null){
                  t.append("\n" + line);
               }
               br.close();
            }catch(IOException ioe){
            }
         }
      }
   });

    fmi.add(omi);


    //«Ø¥ß¡uÀx¦sÀÉ®×¡v¥\¯à¡A©w¸q¨Æ¥ó¡A¨Ã¥[¤J¿ï³æ¤¤
    smi = new JMenuItem("Àx¦sÀÉ®×");

     //
     //##########################################################
     // ½Ð¦b¦¹³B¥[¤J¡uÀx¦sÀÉ®×¡vªº³B²zµ{§Ç
     //##########################################################
     //
   smi.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent ae){
         try{
            int op;
            op = fc.showSaveDialog(JVA404.this);
            if(op == JFileChooser.APPROVE_OPTION){
               File f = fc.getSelectedFile();
               BufferedWriter bw = new BufferedWriter(new FileWriter(f.getAbsolutePath() ));
               String lines[] = t.getText().split("\n");
               for(int i = 0 ; i<lines.length ; i++){
                  bw.write(lines[i]);
                  bw.newLine();
               }
               bw.close();
            }
         }catch(IOException ioe){
            ioe.printStackTrace();
         }
       
      }
   });

    fmi.add(smi);

    fmi.addSeparator();

    //«Ø¥ß¡uÂ÷¶}¡v¥\¯à¡A©w¸q¨Æ¥ó¡A¨Ã¥[¤J¿ï³æ¤¤
    exmi = new JMenuItem("Â÷¶}");

    exmi.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
          System.exit(0);
      }
    });

    fmi.add(exmi);

    mb.add(fmi);

    emi = new JMenu("½s¿è");

   //«Ø¥ß¡u½Æ»s¡v¥\¯à¡A©w¸q¨Æ¥ó¡A¨Ã¥[¤J¿ï³æ¤¤
    cmi = new JMenuItem("½Æ»s");

      //
      //##########################################################
      // ½Ð¦b¦¹³B¥[¤J¡u½Æ»s¡vªº³B²zµ{§Ç
      //##########################################################
      //
   cmi.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent ae){
         t.copy();
      }
   });

    emi.add(cmi);

   //«Ø¥ß¡u¶K¤W¡v¥\¯à¡A©w¸q¨Æ¥ó¡A¨Ã¥[¤J¿ï³æ¤¤
    pmi = new JMenuItem("¶K¤W");

      //
      //##########################################################
      // ½Ð¦b¦¹³B¥[¤J¡u¶K¤W¡vªº³B²zµ{§Ç
      //##########################################################
      //
   pmi.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent ae){
         t.paste();
      }
   });

    emi.add(pmi);

   //«Ø¥ß¡u°Å¤U¡v¥\¯à¡A©w¸q¨Æ¥ó¡A¨Ã¥[¤J¿ï³æ¤¤
    cutmi = new JMenuItem("°Å¤U");

      //
      //##########################################################
      // ½Ð¦b¦¹³B¥[¤J¡u°Å¤U¡vªº³B²zµ{§Ç
      //##########################################################
      //
   cutmi.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent ae){
         t.cut();
      }
   });

    emi.add(cutmi);

    mb.add(emi);

    //©w¸q®Ø¬[¡]µøµ¡¡^Ãö³¬®Éªº³B²z
    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    try {
      UIManager.setLookAndFeel("com.sun.swing.plaf.gtk.GTKLookAndFeel");
      SwingUtilities.updateComponentTreeUI(this);

    } catch (Exception e) {   }

    this.setSize(400, 250);
    this.setVisible(true);
  }

  public static void main(String s[]) {
    //«Ø¥ßJVA404Ãþ§Oªº¹êÅé¬
    JVA404 App = new JVA404("Â²©ö°O¨Æ¥»");
  }
}
