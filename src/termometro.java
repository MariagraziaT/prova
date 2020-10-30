
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class termometro extends JFrame{
    private JLabel label1,label2,label3;
    private JTextField text1;
    private JButton jb1;
    int a=0;

    public termometro() {
        super("termometro ");
       
        setLayout( new FlowLayout());
        // crea un oggetto label
        label1=new JLabel("... ");
        label1.setToolTipText("...");
        add(label1);
        

        // label con icona !!
        Icon ic=new ImageIcon("01qs.png");
        label2=new JLabel("valore in kelvin");
        label2.setIcon(ic);
        label2.setToolTipText("questa è una label con icona");
        label2.setForeground(Color.BLUE);

        add(label2);

        label3=new JLabel("Inserire valore in Celsius");
        add(label3);
        
        text1=new JTextField(20);  //10 car
        add(text1);
        jb1=new JButton("Converti");
        add(jb1);
 
        GestoreTesto gt=new GestoreTesto();
        text1.addActionListener(gt);
        jb1.addActionListener(gt);

        setSize(400,300);
        setVisible(true);
        // comportamento default 
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }


    public static void main(String a[])
    {
        termometro g=new termometro();

        // aggiunge la gestione della chiusura

/*        g.addWindowListener(new WindowAdapter(){ 
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            }
        );*/
    }


// classe interna per la gestione degli eventi
// La piu semplice

private class GestoreTesto implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        String s;
        s="";
        if (e.getSource()==text1)
        {
            a=Integer.parseInt(text1.getText());
            s="text1" + e.getActionCommand();
            JOptionPane.showMessageDialog(null,s);
           
            
        }
        
        if (e.getSource()==jb1)
        {
            System.out.println(a);
            String s1=(""+(a+273));
            
            label1.setText(s1);            
        }

    }
}


}  



