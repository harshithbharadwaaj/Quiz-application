import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Instructions extends JFrame implements ActionListener{

    String name;
    JButton start,back;
    Instructions(String name)
    {
        this.name=name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading=new JLabel("Welcome "+name+" to Quiz Buzzz");
        heading.setBounds(50,20,700,30);
        heading.setFont(new Font("Serif",Font.BOLD,23));
        heading.setForeground(Color.BLACK);
        add(heading);

        JLabel Instructions=new JLabel("Welcome "+name+" to Quiz Buzzz");
        Instructions.setBounds(90,90,700,350);
        Instructions.setFont(new Font("Tahoma",Font.BOLD,18));
        Instructions.setText(
                "<html>"+
                        "1.Read the questions properly"+"<br><br>"+
                "2.No multiple option selection for the given questions"+"<br><br>"+
                        "3.Chill out by giving the exam"+"<br><br>"+
                        "4.Good Luck"+"<br><br>"+
                        "<html>"

        );
        add(Instructions);

        back=new JButton("Back");
        back.setBounds(250,500,100,25);
        back.setBackground(new Color(30,144,254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        start=new JButton("Start");
        start.setBounds(400,500,100,25);
        start.setBackground(new Color(30,144,254));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);

        setSize(800,650);
        setLocation(350,100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==start)
        {
              setVisible(false);
               new Quiz(name);
        }
        else {
            setVisible(false);
            new Login();
        }
    }
    public static void main(String[]args)
    {
         new Instructions("User");
    }
}
