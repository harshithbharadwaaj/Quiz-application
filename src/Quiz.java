import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Quiz extends JFrame implements ActionListener {

    String questions[][]=new String[10][5];
    String answers[][]=new String [10][2];
    String useranswers[][]=new String[10][1];
    JLabel qno,question;
    JRadioButton option1,option2,option3,option4;
    ButtonGroup groupoptions;
    JButton next,submit;
    public static int timer=12;
    public static int ans_given=0;
    public static int count=0;
    public static int score=0;

    String name;


    Quiz(String name)
    {
        this.name=name;
         setBounds(50,0,1300,750);
         getContentPane().setBackground(Color.WHITE);
         setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/quiz.png"));
        JLabel image=new JLabel(i1);
        image.setBounds(60,0,1300,300);
        add(image);

        qno=new JLabel("1.");
        qno.setBounds(100,400,50,27);
        qno.setFont(new Font("Tahoma",Font.PLAIN,22));
        add(qno);

        question=new JLabel("");
        question.setBounds(138,400,700,27);
        question.setFont(new Font("Tahoma",Font.PLAIN,22));
        add(question);

        questions[0][0]="Who is the founder of Tesla ?";
        questions[0][1]="Mark zukerberg";
        questions[0][2]="Elon Musk";
        questions[0][3]="Steve Jobs";
        questions[0][4]="Sundar pichai";

        questions[1][0]="Who is the founder of idly ?";
        questions[1][1]="Mark zukerberg";
        questions[1][2]="Elon Musk";
        questions[1][3]="Steve Jobs";
        questions[1][4]="Sundar pichai";

        questions[2][0]="Who is the founder of Vada ?";
        questions[2][1]="Mark zukerberg";
        questions[2][2]="Elon Musk";
        questions[2][3]="Steve Jobs";
        questions[2][4]="Sundar pichai";

        questions[3][0]="Who is the founder of Dosa ?";
        questions[3][1]="Mark zukerberg";
        questions[3][2]="Elon Musk";
        questions[3][3]="Steve Jobs";
        questions[3][4]="Sundar pichai";

        questions[4][0]="Who is the founder of Puri ?";
        questions[4][1]="Mark zukerberg";
        questions[4][2]="Elon Musk";
        questions[4][3]="Steve Jobs";
        questions[4][4]="Sundar pichai";

        answers[0][1]="Elon Musk";
        answers[1][1]="Steve Jobs";
        answers[2][1]="Mark zukerberg";
        answers[3][1]="Elon Musk";
        answers[4][1]="Sundar pichai";

        option1=new JRadioButton("");
        option1.setBounds(150,460,700,30);
        option1.setBackground(Color.WHITE);
        option1.setFont(new Font("Dialog",Font.PLAIN,20));
        add(option1);

        option2=new JRadioButton("");
        option2.setBounds(150,500,700,30);
        option2.setBackground(Color.WHITE);
        option2.setFont(new Font("Dialog",Font.PLAIN,20));
        add(option2);

        option3=new JRadioButton("");
        option3.setBounds(150,540,700,30);
        option3.setBackground(Color.WHITE);
        option3.setFont(new Font("Dialog",Font.PLAIN,20));
        add(option3);

        option4=new JRadioButton("");
        option4.setBounds(150,580,700,30);
        option4.setBackground(Color.WHITE);
        option4.setFont(new Font("Dialog",Font.PLAIN,20));
        add(option4);

             groupoptions=new ButtonGroup();
             groupoptions.add(option1);
             groupoptions.add(option2);
             groupoptions.add(option3);
             groupoptions.add(option4);

             next=new JButton("Next");
             next.setBounds(1000,520,200,40);
             next.setFont(new Font("Tahoma",Font.PLAIN,22));
             next.setBackground(new Color(30,144,255));
             next.setForeground(Color.WHITE);
             next.addActionListener(this);
             add(next);

             submit=new JButton("Submit");
             submit.setBounds(1000,600,200,40);
             submit.setFont(new Font("Tahoma",Font.PLAIN,22));
             submit.setBackground(new Color(30,144,255));
             submit.setForeground(Color.WHITE);
             submit.addActionListener(this);
             submit.setEnabled(false);
             add(submit);

             start(count);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==next)
        {
        repaint();
        option1.setEnabled(true);
        option2.setEnabled(true);
        option3.setEnabled(true);
        option4.setEnabled(true);

        ans_given=1;
            if(groupoptions.getSelection()==null)
            {
                useranswers[0][0]="";
            }
            else{
                useranswers[count][0]=groupoptions.getSelection().getActionCommand();
            }

            if(count==3)
            {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
        count++;
        start(count);
        }
        else if(ae.getSource()==submit)
       {
           ans_given=1;
           if(groupoptions.getSelection()==null)
           {
               useranswers[count][0]="";
           }
           else {
               useranswers[count][0]=groupoptions.getSelection().getActionCommand();
           }

           for(int i=0;i<useranswers.length;i++)
           {
               if(useranswers[i][0].equals(answers[i][1]))
               {
                   score+=5;
               }
               else {
                   score+=0;
               }
           }
           setVisible(false);
           new Score(name,score);

       }
    }

    public void paint(Graphics g)
    {
        super.paint(g);

        String time="Time left - "+timer+"  sec";  //initially 12 seconds and there to it decreases to 0
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma",Font.BOLD,24));

        if(timer>0)
        {
            g.drawString(time,960,450);
        }
        else {
            g.drawString("Time up!!",960,450);
        }


        timer--;   // the timer decreases from 12 seconds and then decreases second by second

        try
        {
            Thread.sleep(1000);
            repaint();
        }
        catch(Exception e)
        {
             e.printStackTrace();
        }

        if(ans_given==1)
        {
            ans_given=0;
            timer=12;
        }
        else if (timer<0) {
            timer = 12;
            option1.setEnabled(true);
            option2.setEnabled(true);
            option3.setEnabled(true);
            option4.setEnabled(true);

            if (count == 3) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 4)   //submit button
            {
                if(groupoptions.getSelection()==null)
                {
                    useranswers[count][0]="";
                }
                else {
                    useranswers[count][0]=groupoptions.getSelection().getActionCommand();
                }

                for(int i=0;i<useranswers.length;i++)
                {
                    if(useranswers[i][0].equals(answers[i][1]))
                    {
                       score+=5;
                    }
                    else {
                        score+=0;
                    }
                }
                 setVisible(false);
                new Score(name,score);
            }
            else {   //next button

                if (groupoptions.getSelection() == null) {
                    useranswers[0][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count++;  //0  //1   //2
                start(count);

            }
        }

    }
    public void start(int count)
    {
       qno.setText(""+(count+1)+". ");
       question.setText(questions[count][0]);

       option1.setText(questions[count][1]);
       option1.setActionCommand(questions[count][1]);

       option2.setText(questions[count][2]);
       option2.setActionCommand(questions[count][2]);

       option3.setText(questions[count][3]);
       option3.setActionCommand(questions[count][3]);

       option4.setText(questions[count][4]);
       option4.setActionCommand(questions[count][4]);

       groupoptions.clearSelection();
    }

    public static void main(String[]args)
    {
        new Quiz("User");
    }
}
