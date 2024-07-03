package ui;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class CalculationException extends Exception{
    public CalculationException(String errorMsg){
        super(errorMsg);
    }
    public CalculationException(){
    }
    public void displayError(JLabel label){
        label.setText("Invalid Expression");
    }
}
