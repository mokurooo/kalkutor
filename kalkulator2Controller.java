package kalkulator2Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class kalkulator2Controller {

    @FXML
    private TextField display;

    private double angkaPertama = 0;
    private String operator = "";

    @FXML
    void handleNumber(ActionEvent event) {
        Button button = (Button) event.getSource();
        display.appendText(button.getText());
    }

    @FXML
    void handleOperator(ActionEvent event) {

        if (display.getText().isEmpty()) {
            return;
        }

        Button button = (Button) event.getSource();

        angkaPertama = Double.parseDouble(display.getText());
        operator = button.getText();

        display.clear();
    }

     @FXML
    void handleEqual(ActionEvent event) {

        if (display.getText().isEmpty() || operator.isEmpty()) {
            return;
        }

        double angkaKedua = Double.parseDouble(display.getText());
        double hasil = 0;

        switch (operator) {
            case "+":
                hasil = angkaPertama + angkaKedua;
                break;

            case "-":
                hasil = angkaPertama - angkaKedua;
                break;

            case "*":
                hasil = angkaPertama * angkaKedua;
                break;

            case "/":
                if (angkaKedua == 0) {
                    display.setText("Error");
                    operator = "";
                    return;
                }
                hasil = angkaPertama / angkaKedua;
                break;
        }

        display.setText(String.valueOf(hasil));
        operator = "";
    }

    @FXML
void handleClear(ActionEvent event) {
    display.clear();
    angkaPertama = 0;
    operator = "";
}
    }
