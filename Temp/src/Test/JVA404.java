package Test;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class JVA404 extends JFrame {

  Container c = null;

  public JVA404(String title) {  //�w�qJVA404���O���غc�l

    super(title);
    c = this.getContentPane();
    c.setLayout(new BorderLayout());

    final JTextArea t = new JTextArea();
    t.setLineWrap(true);

    JScrollPane s = new JScrollPane(t);
    c.add(s, BorderLayout.CENTER);

    final JFileChooser fc = new JFileChooser();

    JMenuBar mb;
    JMenu fmi;    //�ɮ�
    JMenuItem nmi;  //�}�s�ɮ�
    JMenuItem omi;  //�}������
    JMenuItem smi;  //�x�s�ɮ�
    JMenuItem exmi;  //���}

    JMenu emi;    //�s��
    JMenuItem cmi;  //�ƻs
    JMenuItem pmi;  //�K�W
    JMenuItem cutmi;  //�ŤU

    mb = new JMenuBar();
    mb.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
    setJMenuBar(mb);

    fmi = new JMenu("�ɮ�");


    //�إߡu�}�s�ɮסv�\��A�w�q�ƥ�A�å[�J��椤
    nmi = new JMenuItem("�}�s�ɮ�");

    nmi.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        t.setText("");
      }
    });

    fmi.add(nmi);


    //�إߡu�}�����ɡv�\��A�w�q�ƥ�A�å[�J��椤
    omi = new JMenuItem("�}������");

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


    //�إߡu�x�s�ɮסv�\��A�w�q�ƥ�A�å[�J��椤
    smi = new JMenuItem("�x�s�ɮ�");

     //
     //##########################################################
     // �Цb���B�[�J�u�x�s�ɮסv���B�z�{��
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

    //�إߡu���}�v�\��A�w�q�ƥ�A�å[�J��椤
    exmi = new JMenuItem("���}");

    exmi.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
          System.exit(0);
      }
    });

    fmi.add(exmi);

    mb.add(fmi);

    emi = new JMenu("�s��");

   //�إߡu�ƻs�v�\��A�w�q�ƥ�A�å[�J��椤
    cmi = new JMenuItem("�ƻs");

      //
      //##########################################################
      // �Цb���B�[�J�u�ƻs�v���B�z�{��
      //##########################################################
      //
   cmi.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent ae){
         t.copy();
      }
   });

    emi.add(cmi);

   //�إߡu�K�W�v�\��A�w�q�ƥ�A�å[�J��椤
    pmi = new JMenuItem("�K�W");

      //
      //##########################################################
      // �Цb���B�[�J�u�K�W�v���B�z�{��
      //##########################################################
      //
   pmi.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent ae){
         t.paste();
      }
   });

    emi.add(pmi);

   //�إߡu�ŤU�v�\��A�w�q�ƥ�A�å[�J��椤
    cutmi = new JMenuItem("�ŤU");

      //
      //##########################################################
      // �Цb���B�[�J�u�ŤU�v���B�z�{��
      //##########################################################
      //
   cutmi.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent ae){
         t.cut();
      }
   });

    emi.add(cutmi);

    mb.add(emi);

    //�w�q�ج[�]�����^�����ɪ��B�z
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
    //�إ�JVA404���O�����鐬
    JVA404 App = new JVA404("²���O�ƥ�");
  }
}
