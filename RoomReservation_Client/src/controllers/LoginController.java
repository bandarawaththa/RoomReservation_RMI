package controllers;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import connector.ProxyHandler;
import dtos.UserDTO;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import service.custom.UserService;
import startUp.Main;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public static Stage reservationStage;
    private static UserService userService = ProxyHandler.getInstance().getUserService();
    public static String userName;
    private UserDTO userDTO;

    @FXML
    private Label lblWelcome;

    @FXML
    private JFXTextField txtUName;

    @FXML
    private JFXComboBox<String> cmbUID;

    @FXML
    private JFXPasswordField txtPW;

    @FXML
    private Button btnExit;

    @FXML
    private Button btnLogin;

    @FXML
    private Hyperlink lblForgot;

    @FXML
    void ExitMouseEntered(MouseEvent event) {
        ScaleTransition scaleT =new ScaleTransition(Duration.millis(400), btnExit);
        scaleT.setToX(1.2);
        scaleT.setToY(1.2);
        scaleT.play();
        DropShadow glow = new DropShadow();
        glow.setColor(Color.DARKRED);
        glow.setWidth(20);
        glow.setHeight(20);
        glow.setRadius(20);
        btnExit.setEffect(glow);
    }

    @FXML
    void ExitMouseExited(MouseEvent event) {
        ScaleTransition scaleT =new ScaleTransition(Duration.millis(400), btnExit);
        scaleT.setToX(1);
        scaleT.setToY(1);
        scaleT.play();
        btnExit.setEffect(null);
    }

    @FXML
    void LoginMouseEntered(MouseEvent event) {
        ScaleTransition scaleT =new ScaleTransition(Duration.millis(400), btnLogin);
        scaleT.setToX(1.2);
        scaleT.setToY(1.2);
        scaleT.play();
        DropShadow glow = new DropShadow();
        glow.setColor(Color.DARKBLUE);
        glow.setWidth(20);
        glow.setHeight(20);
        glow.setRadius(20);
        btnLogin.setEffect(glow);
    }

    @FXML
    void LoginMouseExited(MouseEvent event) {
        ScaleTransition scaleT =new ScaleTransition(Duration.millis(400), btnLogin);
        scaleT.setToX(1);
        scaleT.setToY(1);
        scaleT.play();
        btnLogin.setEffect(null);
    }

    @FXML
    void btnExitAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void btnLoginAction(ActionEvent event) {
        login();
    }

    @FXML
    void cmbUIDAction(ActionEvent event) {
        UserDTO dto = new UserDTO();
        dto.setUName(cmbUID.getSelectionModel().getSelectedItem());
        searchUser(dto);
        txtUName.setText(cmbUID.getSelectionModel().getSelectedItem());
    }

    void login () {
        userName = txtUName.getText();
        if (null == userDTO){
            new Alert(Alert.AlertType.INFORMATION,"Invalid UserName entry ... ! \n please try again", ButtonType.CLOSE).show();
        } else {
            if (txtPW.getText().equalsIgnoreCase(userDTO.getPW())){
                URL url = null;
                try {
                    url = new File("RoomReservation_Client/assets/xmls/Reservation.fxml").toURI().toURL();
                    Parent root = FXMLLoader.load(url);
                    Scene scene = new Scene(root);
                    scene.addEventFilter(KeyEvent.KEY_PRESSED, (KeyEvent event) -> {
                        if ( event.getCode() == KeyCode.F6) {
                            URL url2 = null;
                            try {
                                url2 = new File("RoomReservation_Client/assets/xmls/Login.fxml").toURI().toURL();
                                Parent root2 = FXMLLoader.load(url2);
                                Scene scene2 = new Scene(root2);
                                Main.stage.setScene(scene2);
                                Main.stage.centerOnScreen();
                                Main.stage.setTitle("Login");
                                Main.stage.show();
                                reservationStage.close();
                            } catch (IOException e) {
                                new Alert(Alert.AlertType.INFORMATION,e.getMessage(), ButtonType.CLOSE).show();
                            }
                        }
                    });
                    reservationStage = new Stage();
                    reservationStage.setScene(scene);
                    reservationStage.setMaximized(true);
                    reservationStage.setTitle("Room Reservation _ Client Application");
                    reservationStage.show();
                    Main.stage.close();
                } catch (IOException e) {
                    new Alert(Alert.AlertType.INFORMATION,e.getMessage(), ButtonType.CLOSE).show();
                }
            } else {
                new Alert(Alert.AlertType.INFORMATION,"Invalid password entry ... ! \n please try again", ButtonType.CLOSE).show();
                lblForgot.setTextFill(Paint.valueOf("red"));
                txtPW.setText("");
            }
        }
    }

    @FXML
    void lblForgotAction(ActionEvent event) {
        new Alert(Alert.AlertType.INFORMATION,"no functions decided yet ... !", ButtonType.CLOSE).show();
    }

    @FXML
    void txtPWAction(ActionEvent event) {
        login();
    }

    @FXML
    void txtUNameAction(ActionEvent event) {
        UserDTO dto = new UserDTO();
        dto.setUName(txtUName.getText());
        searchUser(dto);
    }

    void searchUser (UserDTO dto){
        try {
            userDTO = userService.searchUser(dto.getUName());
            if (userDTO != null) {
                txtPW.setDisable(false);
                btnLogin.setDisable(false);
                txtPW.requestFocus();
                lblWelcome.setTextFill(Color.BLUE);
                lblWelcome.setText("Hello " + userDTO.getUName() + ".. !");
                cmbUID.getSelectionModel().select(dto.getUName());
            } else {
                new Alert(Alert.AlertType.INFORMATION,"No user account found ... ! \n please try again", ButtonType.CLOSE).show();
                txtUName.setText("");
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.INFORMATION,e.getMessage(), ButtonType.CLOSE).show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<UserDTO> allUsers = null;
        try {
            allUsers = userService.getAllUsers();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            new Alert(Alert.AlertType.INFORMATION,e.getMessage(), ButtonType.CLOSE).show();
        }
        for (UserDTO user :
                allUsers) {
            cmbUID.getItems().add(user.getUName());
        }
    }
}