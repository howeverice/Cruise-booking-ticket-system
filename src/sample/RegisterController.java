package sample;

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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class RegisterController
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
    private Button loginRegistrButton;

    @FXML
    private PasswordField confirmPassword_field;

    @FXML
    private TextField firstname_field;

    @FXML
    private TextField lastname_field;

    @FXML
    private ImageView imageEyePassword;

    @FXML
    private ImageView imageEyeInvisiblePassword;

    @FXML
    private ImageView imageEyeConfPassword;

    @FXML
    private ImageView imageEyeInvisibleConfPassword;

    @FXML
    private TextField passTextField;

    @FXML
    private TextField confirmPassTextField;

    @FXML
    private Button loginBackUpButton;

    public void createBackForm()
    {
        loginBackUpButton.setOnAction(actionEvent -> {
            loginBackUpButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/MainMenu.fxml"));
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

    public void createVisibleConfPasswordIcon()
    {
        imageEyeInvisibleConfPassword.setVisible(false);
        confirmPassTextField.setVisible(false);
        imageEyeConfPassword.setOnMousePressed(actionEvent -> {
            imageEyeConfPassword.setVisible(false);
            imageEyeInvisibleConfPassword.setVisible(true);
            confirmPassTextField.setText(confirmPassword_field.getText());
            confirmPassword_field.setVisible(false);
            confirmPassTextField.setVisible(true);
        });

        imageEyeInvisibleConfPassword.setOnMousePressed(actionEvent -> {
            imageEyeInvisibleConfPassword.setVisible(false);
            imageEyeConfPassword.setVisible(true);
            confirmPassTextField.setVisible(false);
            confirmPassword_field.setText(confirmPassTextField.getText());
            confirmPassword_field.setVisible(true);
        });
    }

    @FXML
    void initialize()
    {
        createBackForm();
        createVisiblePasswordIcon();
        createVisibleConfPasswordIcon();
    }
}
