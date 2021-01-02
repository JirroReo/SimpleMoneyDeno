package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Arrays;
import java.util.Objects;
import java.util.ResourceBundle;


public class Controller implements Initializable{

    static int[] denominations = new int[12];
    // [1000, 500, 200, 100, 40, 20, 10, 05, 01, 0.50, 0.25, 0.01]

    public static double denote (double amount, double deno){
        while(amount>=deno){
            amount -= deno;
            if (deno == 1000) denominations[0]++;
            else if (deno == 500) denominations[1]++;
            else if (deno == 200) denominations[2]++;
            else if (deno == 100) denominations[3]++;
            else if (deno == 50) denominations[4]++;
            else if (deno == 20) denominations[5]++;
            else if (deno == 10) denominations[6]++;
            else if (deno == 5) denominations[7]++;
            else if (deno == 1) denominations[8]++;
            else if (deno == 0.50) denominations[9]++;
            else if (deno == 0.25) denominations[10]++;
            else if (deno == 0.01) denominations[11]++;
        }
        return amount;
    }

    @FXML
    private ImageView ImageBG;

    @FXML
    private JFXButton exitButton;

    public void exitButtonOnAction(ActionEvent event){
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private Label errorlabel;

    @FXML
    private JFXButton goButton;
    @FXML
    private JFXButton resetButton;

    @FXML
    private JFXTextField userInputField;

    @FXML
    private Label onetlabel;
    @FXML
    private Label fivehlabel;
    @FXML
    private Label twohlabel;
    @FXML
    private Label onehlabel;
    @FXML
    private Label fiftylabel;
    @FXML
    private Label twentylabel;
    @FXML
    private Label tenlabel;
    @FXML
    private Label fivelabel;
    @FXML
    private Label onelabel;
    @FXML
    private Label fiftyclabel;
    @FXML
    private Label twofiveclabel;
    @FXML
    private Label oneclabel;

    public void resetButtonOnAction(ActionEvent event){
        Arrays.fill(denominations, 0);
        denominationsShow();
    }

    String text;
    public void goButtonOnAction(ActionEvent event){
        text = userInputField.getText().replaceAll("[^\\d.]", "");
        boolean numeric = true;
        try {
            Double num = Double.parseDouble(userInputField.getText());
        } catch (NumberFormatException e) {
            numeric = false;
        }
        if(userInputField.getText().isBlank()|| !numeric){
            errorlabel.setText("INPUT IS INVALID!");
        }else{
            Arrays.fill(denominations, 0);
            errorlabel.setText(" ");
            denote(denote(denote(denote(denote(denote(denote(denote(denote(denote(denote
                            (denote(Double.parseDouble(text), 1000), 500), 200), 100), 50),
                    20), 10), 5), 1), 0.50), 0.25), 0.01);
        }

        denominationsShow();
    }

    public void denominationsShow(){
        onetlabel.setText(String.valueOf(denominations[0]));
        fivehlabel.setText(String.valueOf(denominations[1]));
        twohlabel.setText(String.valueOf(denominations[2]));
        onehlabel.setText(String.valueOf(denominations[3]));
        fiftylabel.setText(String.valueOf(denominations[4]));
        twentylabel.setText(String.valueOf(denominations[5]));
        tenlabel.setText(String.valueOf(denominations[6]));
        fivelabel.setText(String.valueOf(denominations[7]));
        onelabel.setText(String.valueOf(denominations[8]));
        fiftyclabel.setText(String.valueOf(denominations[9]));
        twofiveclabel.setText(String.valueOf(denominations[10]));
        oneclabel.setText(String.valueOf(denominations[11]));
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //File ImageBGFile = new File("src/img/Stripe BG.png");
        //Image ImageBGImage = new Image(ImageBGFile.toURI().toString());
        //ImageBG.setImage(ImageBGImage);

        Image img = new Image(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("src/img/1245.png")));
        ImageBG.setImage(img);
    }
}
