package ui;

import utils.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculator implements ActionListener{
    private JFrame frame;
    private JPanel displayPanel,buttonPanel;
    private JLabel displayLabel,resultLabel;
    private JButton button0,button1,button2,button3,button4,button5,button6,button7,button8,button9;
    private JButton buttonSum,buttonDiff,buttonMul,buttonDiv,buttonPow,buttonOpen,buttonClose,buttonDot,buttonEQ,buttonAC;
    
    private Font buttonFont,inUseFont,notInUseFont;
    private StringBuilder calBuffer;

    public Calculator(){
        frame=new JFrame("Calculator");
        displayPanel=new JPanel();
        buttonPanel=new JPanel();

        buttonFont=new Font("o",40,40);
        inUseFont=new Font("o",75,75);
        notInUseFont=new Font("o",40,40);
        
        (displayLabel=new JLabel("0")).setSize(150,600);
        displayLabel.setFont(inUseFont);
        
        (resultLabel=new JLabel("0")).setSize(100,600);
        resultLabel.setFont(notInUseFont);
        
        (button0=new JButton("0")).setSize(150,100);
        button0.setFont(buttonFont);
        button0.addActionListener((ActionListener) this);
        (button1=new JButton("1")).setSize(150,100);
        button1.setFont(buttonFont);
        button1.addActionListener((ActionListener) this);
        (button2=new JButton("2")).setSize(150,100);
        button2.setFont(buttonFont);
        button2.addActionListener((ActionListener) this);
        (button3=new JButton("3")).setSize(150,100);
        button3.setFont(buttonFont);
        button3.addActionListener((ActionListener) this);
        (button4=new JButton("4")).setSize(150,100);
        button4.setFont(buttonFont);
        button4.addActionListener((ActionListener) this);
        (button5=new JButton("5")).setSize(150,100);
        button5.setFont(buttonFont);
        button5.addActionListener((ActionListener) this);
        (button6=new JButton("6")).setSize(150,100);
        button6.setFont(buttonFont);
        button6.addActionListener((ActionListener) this);
        (button7=new JButton("7")).setSize(150,100);
        button7.setFont(buttonFont);
        button7.addActionListener((ActionListener) this);
        (button8=new JButton("8")).setSize(150,100);
        button8.setFont(buttonFont);
        button8.addActionListener((ActionListener) this);
        (button9=new JButton("9")).setSize(150,100);
        button9.setFont(buttonFont);
        button9.addActionListener((ActionListener) this);
        
        (buttonOpen=new JButton("(")).setSize(150,100);
        buttonOpen.setFont(buttonFont);
        buttonOpen.addActionListener((ActionListener) this);
        (buttonClose=new JButton(")")).setSize(150,100);
        buttonClose.setFont(buttonFont);
        buttonClose.addActionListener((ActionListener) this);
        (buttonPow=new JButton("^")).setSize(150,100);
        buttonPow.setFont(buttonFont);
        buttonPow.addActionListener((ActionListener) this);
        (buttonDiv=new JButton("/")).setSize(150,100);
        buttonDiv.setFont(buttonFont);
        buttonDiv.addActionListener((ActionListener) this);
        (buttonMul=new JButton("x")).setSize(150,100);
        buttonMul.setFont(buttonFont);
        buttonMul.addActionListener((ActionListener) this);
        (buttonDiff=new JButton("-")).setSize(150,100);
        buttonDiff.setFont(buttonFont);
        buttonDiff.addActionListener((ActionListener) this);
        (buttonSum=new JButton("+")).setSize(150,100);
        buttonSum.setFont(buttonFont);
        buttonSum.addActionListener((ActionListener) this);
        (buttonEQ=new JButton("=")).setSize(150,100);
        buttonEQ.setFont(buttonFont);
        buttonEQ.addActionListener((ActionListener) this);
        (buttonDot=new JButton(".")).setSize(150,100);
        buttonDot.setFont(buttonFont);
        buttonDot.addActionListener((ActionListener) this);
        (buttonAC=new JButton("AC")).setSize(150,100);
        buttonAC.setFont(buttonFont);
        buttonAC.addActionListener((ActionListener) this);

        calBuffer=new StringBuilder();

        displayPanel.setLayout(new GridLayout(2,1));
        displayPanel.add(displayLabel);
        displayPanel.add(resultLabel);

        buttonPanel.setLayout(new GridLayout(5,4));
        buttonPanel.add(buttonOpen);
        buttonPanel.add(buttonClose);
        buttonPanel.add(buttonPow);
        buttonPanel.add(buttonDiv);
        buttonPanel.add(button7);
        buttonPanel.add(button8);
        buttonPanel.add(button9);
        buttonPanel.add(buttonMul);
        buttonPanel.add(button4);
        buttonPanel.add(button5);
        buttonPanel.add(button6);
        buttonPanel.add(buttonDiff);
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(buttonSum);
        buttonPanel.add(buttonAC);
        buttonPanel.add(button0);
        buttonPanel.add(buttonDot);
        buttonPanel.add(buttonEQ);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocation(450,50);
        frame.setSize(600,750);
        frame.setResizable(false);
        frame.setLayout(new GridLayout(2,1));
        frame.add(displayPanel);
        frame.add(buttonPanel);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==button0)
            calBuffer.append("0");
        else if(e.getSource()==button1)
            calBuffer.append("1");
        else if(e.getSource()==button2)
            calBuffer.append("2");
        else if(e.getSource()==button3)
            calBuffer.append("3");
        else if(e.getSource()==button4)
            calBuffer.append("4");
        else if(e.getSource()==button5)
            calBuffer.append("5");
        else if(e.getSource()==button6)
            calBuffer.append("6");
        else if(e.getSource()==button7)
            calBuffer.append("7");
        else if(e.getSource()==button8)
            calBuffer.append("8");
        else if(e.getSource()==button9)
            calBuffer.append("9");
        else if(e.getSource()==buttonSum)
            calBuffer.append("+");
        else if(e.getSource()==buttonDiff)
            calBuffer.append("-");
        else if(e.getSource()==buttonMul)
            calBuffer.append("x");
        else if(e.getSource()==buttonDiv)
            calBuffer.append("/");
        else if(e.getSource()==buttonPow)
            calBuffer.append("^");
        else if(e.getSource()==buttonOpen)
            calBuffer.append("(");
        else if(e.getSource()==buttonClose)
            calBuffer.append(")");
        else if(e.getSource()==buttonDot)
            calBuffer.append(".");
        else if(e.getSource()==buttonAC){
            calBuffer.setLength(0);
            displayLabel.setText("0");
            resultLabel.setFont(notInUseFont);
            displayLabel.setFont(inUseFont);
            resultLabel.setText("0");
            return;
        }
        else{
            Calculations c=new Calculations();
            try{
                Float val=c.calculate(calBuffer.toString());
                resultLabel.setText(val.toString());
                resultLabel.setFont(inUseFont);
                displayLabel.setFont(notInUseFont);
            }
            catch(CalculationException exception){
                exception.displayError(resultLabel);
            }
        }
        //resultLabel.setText(calBuffer.toString()+"  k");
        displayLabel.setText(calBuffer.toString());
    }
    
}