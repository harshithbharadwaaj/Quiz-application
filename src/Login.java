import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    JButton rules,back;
    JTextField tfname;

    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
        JLabel image=new JLabel(i1);
        image.setBounds(0,0,600,500);
        add(image);

        JLabel heading=new JLabel("Quiz Buzzzz");
        heading.setBounds(830,20,300,45);
        heading.setFont(new Font("Serif",Font.BOLD,20));
        heading.setForeground(Color.BLACK);
        add(heading);

        JLabel name=new JLabel("Enter your name");
        name.setBounds(830,150,300,45);
        name.setFont(new Font("Cursive",Font.BOLD,16));
        name.setForeground(Color.black);
        add(name);

        tfname=new JTextField();
        tfname.setBounds(800,200,200,35);
        name.setFont(new Font("Times New Roman",Font.BOLD,16));
        add(tfname);

        rules=new JButton("Instructions");
        rules.setBounds(750,270,120,25);
        rules.setBackground(new Color(30,144,254));
        rules.setForeground(Color.WHITE);
        rules.addActionListener(this);
        add(rules);

        back=new JButton("Back");
        back.setBounds(940,270,120,25);
        back.setBackground(new Color(30,144,254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(1200,500);
        setLocation(200,150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==rules)
        {
              String name=tfname.getText();
              setVisible(false);
              new Instructions(name);
        }
        else if(ae.getSource()==back)
        {
             setVisible(false);
        }
    }

    public static void main(String[]args)
    {
        new Login();
    }
}
