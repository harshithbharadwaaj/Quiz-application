import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {

    Score(String name,int score)
    {
        setBounds(60,150,750,550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        Image i2=i1.getImage().getScaledInstance(300,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i1);
        image.setBounds(0,200,300,220);
        add(image);

        JLabel heading=new JLabel("Thank You");
        heading.setBounds(450,30,1000,45);
        heading.setFont(new Font("Tahoma",Font.PLAIN,24));
        heading.setForeground(Color.GREEN);
        add(heading);

        JLabel finalscore=new JLabel("Your score is  "+score);
        finalscore.setBounds(450,300,350,30);
        finalscore.setFont(new Font("Tahoma",Font.BOLD,24));
        add(finalscore);

        JButton submit=new JButton("Replay");
        submit.setBounds(480,390,120,30);
        submit.setFont(new Font("Tahoma",Font.PLAIN,22));
        submit.setBackground(new Color(30,144,255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
          setVisible(false);
          new Login();
    }
    public static void main(String[]args)
    {
        new Score("User",0);
    }
}
