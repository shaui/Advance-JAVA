package Test;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class JVA404 extends JFrame {

  Container c = null;

  public JVA404(String title) {  //定義JVA404類別的建構子

    super(title);
    c = this.getContentPane();
    c.setLayout(new BorderLayout());

    final JTextArea t = new JTextArea();
    t.setLineWrap(true);

    JScrollPane s = new JScrollPane(t);
    c.add(s, BorderLayout.CENTER);

    final JFileChooser fc = new JFileChooser();

    JMenuBar mb;
    JMenu fmi;    //檔案
    JMenuItem nmi;  //開新檔案
    JMenuItem omi;  //開啟舊檔
    JMenuItem smi;  //儲存檔案
    JMenuItem exmi;  //離開

    JMenu emi;    //編輯
    JMenuItem cmi;  //複製
    JMenuItem pmi;  //貼上
    JMenuItem cutmi;  //剪下

    mb = new JMenuBar();
    mb.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
    setJMenuBar(mb);

    fmi = new JMenu("檔案");


    //建立「開新檔案」功能，定義事件，並加入選單中
    nmi = new JMenuItem("開新檔案");

    nmi.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        t.setText("");
      }
    });

    fmi.add(nmi);


    //建立「開啟舊檔」功能，定義事件，並加入選單中
    omi = new JMenuItem("開啟舊檔");

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


    //建立「儲存檔案」功能，定義事件，並加入選單中
    smi = new JMenuItem("儲存檔案");

     //
     //##########################################################
     // 請在此處加入「儲存檔案」的處理程序
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

    //建立「離開」功能，定義事件，並加入選單中
    exmi = new JMenuItem("離開");

    exmi.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
          System.exit(0);
      }
    });

    fmi.add(exmi);

    mb.add(fmi);

    emi = new JMenu("編輯");

   //建立「複製」功能，定義事件，並加入選單中
    cmi = new JMenuItem("複製");

      //
      //##########################################################
      // 請在此處加入「複製」的處理程序
      //##########################################################
      //
   cmi.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent ae){
         t.copy();
      }
   });

    emi.add(cmi);

   //建立「貼上」功能，定義事件，並加入選單中
    pmi = new JMenuItem("貼上");

      //
      //##########################################################
      // 請在此處加入「貼上」的處理程序
      //##########################################################
      //
   pmi.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent ae){
         t.paste();
      }
   });

    emi.add(pmi);

   //建立「剪下」功能，定義事件，並加入選單中
    cutmi = new JMenuItem("剪下");

      //
      //##########################################################
      // 請在此處加入「剪下」的處理程序
      //##########################################################
      //
   cutmi.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent ae){
         t.cut();
      }
   });

    emi.add(cutmi);

    mb.add(emi);

    //定義框架（視窗）關閉時的處理
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
    //建立JVA404類別的實體��
    JVA404 App = new JVA404("簡易記事本");
  }
}
