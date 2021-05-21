package sample;

import javafx.scene.image.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import static javafx.fxml.FXMLLoader.load;

public class EntranceController
{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button loginEnterButton;

    @FXML
    private Button loginSignUpButton;

    @FXML
    private ImageView imageEyePassword;

    @FXML
    private ImageView imageEyeInvisiblePassword;

    @FXML
    private TextField passTextField;

    public void createVisiblePasswordIcon()
    {
        imageEyeInvisiblePassword.setVisible(false);
        passTextField.setVisible(false);
        imageEyePassword.setOnMousePressed(actionEvent -> {
            imageEyePassword.setVisible(false);
            imageEyeInvisiblePassword.setVisible(true);
            passTextField.setText(password_field.getText());
            password_field.setVisible(false);
            passTextField.setVisible(true);
        });

        imageEyeInvisiblePassword.setOnMousePressed(actionEvent -> {
            imageEyeInvisiblePassword.setVisible(false);
            imageEyePassword.setVisible(true);
            passTextField.setVisible(false);
            password_field.setText(passTextField.getText());
            password_field.setVisible(true);
        });
    }

    public void createRegistrationForm()
    {
           loginSignUpButton.setOnAction(actionEvent -> {
               loginSignUpButton.getScene().getWindow().hide();
               FXMLLoader loader = new FXMLLoader();
               loader.setLocation(getClass().getResource("/sample/Registration.fxml"));
               try
               {
                   loader.load();
                   Parent root = loader.getRoot();
                   Stage registerStage = new Stage();
                   registerStage.setScene(new Scene(root));
                   registerStage.setTitle("Cruise booking-ticket system");
                   registerStage.getIcons().add(new Image("/sample/Images/SheepIconApp.png"));
                   registerStage.show();
               }catch (IOException e)
               {
                   e.printStackTrace();
               }
           });
    }

    @FXML
    void initialize()
    {
        createRegistrationForm();
        createVisiblePasswordIcon();
    }
}
