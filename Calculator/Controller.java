package Calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller {

    @FXML
    private Text output;

    private double number1 = 0;
    private String operator = "";
    private boolean start = true;

    private Model model = new Model();

    @FXML
    private void processNumpad(ActionEvent event) {
        if (start) {
            output.setText("");
            start = false;
        }
        String value = ((Button)event.getSource()).getText();
        //System.out.println(value);
        if(value.equals("AC"))
            output.setText("");
        else if(value.equals("pi"))
            output.setText("3.141592653589");
        else if(value.equals("e"))
            output.setText("2.71828182845");
        else
            output.setText(output.getText()+value);
    }

    @FXML
    private void processOperator1(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();

        if (!"=".equals(value)) {
            if (!operator.isEmpty())
                return;

            operator = value;
            number1 = Double.parseDouble(output.getText());
            if(value.equals("log"))
                output.setText("log("+number1+")");
            else if(value.equals("ln"))
                output.setText("ln("+number1+")");
            else if(value.equals("sqrt"))
                output.setText("sqrt("+number1+")");
            else if(value.equals("+/-"))
                output.setText("neg("+number1+")");
            else if(value.equals("1/x"))
                output.setText("1/"+number1);
            else
                output.setText("");
        }
        else {
            if (operator.isEmpty())
                return;
            if(operator.equals("log")||operator.equals("ln")||operator.equals("sqrt")||operator.equals("+/-")||operator.equals("1/x"))
                output.setText(String.valueOf(model.calculate1(number1,operator)));
            else    
                output.setText(String.valueOf(model.calculate(number1,Double.parseDouble(output.getText()), operator)));
            operator = "";
            start = true;
        }
    }
    // @FXML
    // private void processOperator2(ActionEvent event){
    //     String value=((Button)event.getSource()).getText();
    //     operator=value;
    //     output.setText(String.valueOf(model.calculate1(Double.parseDouble(output.getText()),operator)));
    //     start=false;
    // }
}