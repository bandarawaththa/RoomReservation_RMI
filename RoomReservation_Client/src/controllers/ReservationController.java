package controllers;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import connector.ProxyHandler;
import dtos.CustomDTO;
import dtos.CustomerDTO;
import dtos.RoomDTO;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import service.custom.CustomerService;
import service.custom.ReservationService;
import service.custom.RoomService;
import startUp.Main;
import tm.CustomerTM;
import tm.RoomTM;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class ReservationController implements Initializable {
    CustomerService customerService = ProxyHandler.getInstance().getCustomerService();
    RoomService roomService = ProxyHandler.getInstance().getRoomService();
    ReservationService reservationService = ProxyHandler.getInstance().getReservationService();

    @FXML
    private JFXComboBox<Integer> cmbAdults;

    @FXML
    private JFXComboBox<Integer> cmbKids;

    @FXML
    private Label lblWelcome;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;

    @FXML
    private JFXTextField txtNIC;

    @FXML
    private JFXTextField txtUName;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnAdd;

    @FXML
    private TableView<CustomerTM> tblCus;

    @FXML
    private JFXTextField txtRoomNURelease;

    @FXML
    private Label lblReserveDate;

    @FXML
    private JFXTextField txtDaysBooked;

    @FXML
    private JFXCheckBox btnDiscount;

    @FXML
    private JFXTextField txtDiscount;

    @FXML
    private JFXTextField txtPaid;

    @FXML
    private Label lblBalance;

    @FXML
    private Button btnGetPayment;

    @FXML
    private Button btnReleaseRoom;

    @FXML
    private JFXTextField txtRoomNuService;

    @FXML
    private Button btnLock;

    @FXML
    private Button btnUnlock;

    @FXML
    private JFXComboBox<Integer> cmbBeds;

    @FXML
    private JFXComboBox<Integer> cmbFloor;

    @FXML
    private JFXRadioButton btnACRoom;

    @FXML
    private ToggleGroup ac;

    @FXML
    private JFXRadioButton btnNonACRoom;

    @FXML
    private Button btnSearchRoom;

    @FXML
    private JFXRadioButton btnOtherDate;

    @FXML
    private ToggleGroup day;

    @FXML
    private JFXRadioButton btnTodayDay;

    @FXML
    private JFXDatePicker txtReserveDate;

    @FXML
    private JFXDatePicker txtReleaseDate;

    @FXML
    private TableView<RoomTM> tblRoom;

    @FXML
    private VBox paneMeal;

    @FXML
    private Label lblRoomNUMeal;

    @FXML
    private JFXRadioButton btnMeal1;

    @FXML
    private ToggleGroup meal;

    @FXML
    private JFXRadioButton btnMeal2;

    @FXML
    private JFXRadioButton btnFullsetMeal;

    @FXML
    private JFXRadioButton btnRefreshment;

    @FXML
    private Label lblMealPrice;

    @FXML
    private Button btnSelectMeal;

    @FXML
    private Button btnReserveRoom;

    @FXML
    void btnACRoomAction(ActionEvent event) {

    }

    @FXML
    void btnAddAction(ActionEvent event) {
        boolean added = false;
        try {
            added = customerService.addCustomer(new CustomerDTO(txtNIC.getText(), txtUName.getText(), Integer.parseInt(txtContact.getText()), txtAddress.getText()));
        } catch (Exception e) {
            new Alert(Alert.AlertType.INFORMATION,e.getMessage(), ButtonType.CLOSE).show();
        }
        if (added){
            new Alert(Alert.AlertType.CONFIRMATION,"Customer Added Successfully ... !", ButtonType.CLOSE).show();
            CustomerDTO cus = null;
            btnAdd.setDisable(true);
            btnRemove.setDisable(false);
            btnUpdate.setDisable(false);
            cmbBeds.requestFocus();
        } else {
            new Alert(Alert.AlertType.WARNING,"Customer Added Failier ... !", ButtonType.CLOSE).show();
        }
        loadtblCus();
    }

    @FXML
    void btnDiscountAction(ActionEvent event) {

    }

    @FXML
    void btnFullsetMealAction(ActionEvent event) {
        lblMealPrice.setTextFill(Paint.valueOf("blue"));
        final int meal = 500;
        int adultPrice = meal * cmbAdults.getSelectionModel().getSelectedItem();
        int kidPrice = (meal / 2) * cmbKids.getSelectionModel().getSelectedItem();
        lblMealPrice.setText(String.valueOf(adultPrice + kidPrice));
    }

    @FXML
    void btnGetPaymentAction(ActionEvent event) {

    }

    @FXML
    void btnGetPaymentMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnGetPaymentMouseExit(MouseEvent event) {

    }

    @FXML
    void btnLockAction(ActionEvent event) {

    }

    @FXML
    void btnLockMouseEnter(MouseEvent event) {

    }

    @FXML
    void btnLockMouseExt(MouseEvent event) {

    }

    @FXML
    void btnMeal1Action(ActionEvent event) {
        lblMealPrice.setTextFill(Paint.valueOf("blue"));
        final int meal = 200;
        int adultPrice = meal * cmbAdults.getSelectionModel().getSelectedItem();
        int kidPrice = (meal / 2) * cmbKids.getSelectionModel().getSelectedItem();
        lblMealPrice.setText(String.valueOf(adultPrice + kidPrice));
    }

    @FXML
    void btnMeal2Action(ActionEvent event) {
        lblMealPrice.setTextFill(Paint.valueOf("blue"));
        final int meal = 400;
        int adultPrice = meal * cmbAdults.getSelectionModel().getSelectedItem();
        int kidPrice = (meal / 2) * cmbKids.getSelectionModel().getSelectedItem();
        lblMealPrice.setText(String.valueOf(adultPrice + kidPrice));
    }

    @FXML
    void btnNewMouseEntered(MouseEvent event) {
        ScaleTransition scaleT =new ScaleTransition(Duration.millis(400), btnAdd);
        scaleT.setToX(1.2);
        scaleT.setToY(1.2);
        scaleT.play();
        DropShadow glow = new DropShadow();
        glow.setColor(Color.DARKGREEN);
        glow.setWidth(20);
        glow.setHeight(20);
        glow.setRadius(20);
        btnAdd.setEffect(glow);
    }

    @FXML
    void btnNewMouseExited(MouseEvent event) {
        ScaleTransition scaleT =new ScaleTransition(Duration.millis(400), btnAdd);
        scaleT.setToX(1);
        scaleT.setToY(1);
        scaleT.play();
        btnAdd.setEffect(null);
    }

    @FXML
    void btnNonACRoomAction(ActionEvent event) {

    }

    @FXML
    void btnOtherDateAction(ActionEvent event) {
        txtReserveDate.setDisable(false);
        txtReserveDate.requestFocus();
    }

    @FXML
    void btnRefreshmentAction(ActionEvent event) {
        lblMealPrice.setTextFill(Paint.valueOf("blue"));
        lblMealPrice.setText(String.valueOf(0));
    }

    @FXML
    void btnReleaseRoomAction(ActionEvent event) {

    }

    @FXML
    void btnReleaseRoomMouseEnter(MouseEvent event) {

    }

    @FXML
    void btnReleaseRoomMouseExit(MouseEvent event) {

    }

    @FXML
    void btnRemoveAction(ActionEvent event) {
        boolean removed = false;
        try {
            CustomerDTO temp = new CustomerDTO();
            temp.setNic(txtNIC.getText());
            removed = customerService.deleteCustomer(temp);
        } catch (Exception e) {
            new Alert(Alert.AlertType.INFORMATION,e.getMessage(), ButtonType.CLOSE).show();
        }
        if (removed){
            new Alert(Alert.AlertType.CONFIRMATION,"Customer removal success ... !", ButtonType.CLOSE).show();
            resetUI();
        } else {
            new Alert(Alert.AlertType.INFORMATION,"Customer removal failier ... !", ButtonType.CLOSE).show();
        }
    }

    @FXML
    void btnRemoveMouseEntered(MouseEvent event) {
        ScaleTransition scaleT =new ScaleTransition(Duration.millis(400), btnRemove);
        scaleT.setToX(1.2);
        scaleT.setToY(1.2);
        scaleT.play();
        DropShadow glow = new DropShadow();
        glow.setColor(Color.DARKRED);
        glow.setWidth(20);
        glow.setHeight(20);
        glow.setRadius(20);
        btnRemove.setEffect(glow);
    }

    @FXML
    void btnRemoveMouseExited(MouseEvent event) {
        ScaleTransition scaleT =new ScaleTransition(Duration.millis(400), btnRemove);
        scaleT.setToX(1);
        scaleT.setToY(1);
        scaleT.play();
        btnRemove.setEffect(null);
    }

    @FXML
    void btnReserveRoomAction(ActionEvent event) {
        String nic = txtNIC.getText();
        if (null == nic || nic.equalsIgnoreCase("")){
            new Alert(Alert.AlertType.INFORMATION, "Customer selection FAILED \n Please try again", ButtonType.CLOSE).show();
            txtNIC.setText("");
            txtNIC.requestFocus();
        }
        String reserveDate = null;
        if (btnTodayDay.isSelected()){
            reserveDate = lblDate.getText();
        } else {
            LocalDate value = txtReserveDate.getValue();
            reserveDate = value.toString();
        }
        String releaseDate = null;
        try{
            releaseDate = txtReleaseDate.getValue().toString();
        } catch (Exception e){
            new Alert(Alert.AlertType.INFORMATION, "Release Date selection Failed \n Please try again", ButtonType.CLOSE).show();
            txtReleaseDate.requestFocus();
        }
        CustomDTO temp = new CustomDTO();
        temp.setRoomNumber(Integer.parseInt(lblRoomNUMeal.getText()));
        temp.setReleaseDate(releaseDate);
        temp.setReserveDate(reserveDate);
        temp.setCusNIC(nic);
        try {
            boolean added = reservationService.addReservation(temp);
            if (added){
                new Alert(Alert.AlertType.INFORMATION, "Reservation added SUCCESSFULLY", ButtonType.CLOSE).show();
                resetUI();
            }
        } catch (RemoteException | SQLException e) {
            new Alert(Alert.AlertType.INFORMATION,e.getMessage(), ButtonType.CLOSE).show();
        }
    }

    @FXML
    void btnReserveRoomMouseEntered(MouseEvent event) {
        ScaleTransition scaleT =new ScaleTransition(Duration.millis(400), btnReserveRoom);
        scaleT.setToX(1.2);
        scaleT.setToY(1.2);
        scaleT.play();
        DropShadow glow = new DropShadow();
        glow.setColor(Color.DARKGREEN);
        glow.setWidth(20);
        glow.setHeight(20);
        glow.setRadius(20);
        btnReserveRoom.setEffect(glow);
    }

    @FXML
    void btnReserveRoomMouseExit(MouseEvent event) {
        ScaleTransition scaleT =new ScaleTransition(Duration.millis(400), btnReserveRoom);
        scaleT.setToX(1);
        scaleT.setToY(1);
        scaleT.play();
        btnReserveRoom.setEffect(null);
    }

    @FXML
    void btnSearchRoomAction(ActionEvent event) {
        int beds = cmbBeds.getSelectionModel().getSelectedItem();
        int floor = cmbFloor.getSelectionModel().getSelectedItem();
        boolean ac = false;
        if (btnACRoom.isSelected()){
            ac = true;
        }
        String reserveDate = null;
        if (btnTodayDay.isSelected()){
            reserveDate = lblDate.getText();
        } else {
            LocalDate value = txtReserveDate.getValue();
            reserveDate = value.toString();
        }
        String releaseDate = null;
        try{
            releaseDate = txtReleaseDate.getValue().toString();
        } catch (Exception e){
            new Alert(Alert.AlertType.INFORMATION, "Release Date selection Failed \n Please try again", ButtonType.CLOSE).show();
        }
        ArrayList<RoomDTO> result = null;
        try {
            result = roomService.searchAllRooms(beds, ac, reserveDate, releaseDate);
        } catch (Exception e) {
            new Alert(Alert.AlertType.INFORMATION,e.getMessage(), ButtonType.CLOSE).show();
        }
        loadTblRoom(result);
        tblRoom.setDisable(false);
    }

    @FXML
    void btnSearchRoomMouseEnter(MouseEvent event) {
        ScaleTransition scaleT =new ScaleTransition(Duration.millis(400), btnSearchRoom);
        scaleT.setToX(1.2);
        scaleT.setToY(1.2);
        scaleT.play();
        DropShadow glow = new DropShadow();
        glow.setColor(Color.DARKBLUE);
        glow.setWidth(20);
        glow.setHeight(20);
        glow.setRadius(20);
        btnSearchRoom.setEffect(glow);
    }

    @FXML
    void btnSearchRoomMouseExit(MouseEvent event) {
        ScaleTransition scaleT =new ScaleTransition(Duration.millis(400), btnSearchRoom);
        scaleT.setToX(1);
        scaleT.setToY(1);
        scaleT.play();
        btnSearchRoom.setEffect(null);
    }

    @FXML
    void btnSelectMealAction(ActionEvent event) {
        RoomDTO temp = new RoomDTO();
        temp.setRoomNumber(Integer.parseInt(lblRoomNUMeal.getText()));
        RoomDTO room = null;
        try {
            room = roomService.searchRoom(temp);
        } catch (Exception e) {
            new Alert(Alert.AlertType.INFORMATION,e.getMessage(), ButtonType.CLOSE).show();
        }
        double mealPrice = Double.parseDouble(lblMealPrice.getText());
        lblMealPrice.setText(String.valueOf(room.getPrice() + mealPrice));
        lblMealPrice.setTextFill(Paint.valueOf("red"));
        btnReserveRoom.setDisable(false);
    }

    @FXML
    void btnSelectMealMouseEnter(MouseEvent event) {
        ScaleTransition scaleT =new ScaleTransition(Duration.millis(400), btnSelectMeal);
        scaleT.setToX(1.2);
        scaleT.setToY(1.2);
        scaleT.play();
        DropShadow glow = new DropShadow();
        glow.setColor(Color.DARKBLUE);
        glow.setWidth(20);
        glow.setHeight(20);
        glow.setRadius(20);
        btnSelectMeal.setEffect(glow);
    }

    @FXML
    void btnSelectMealMouseExit(MouseEvent event) {
        ScaleTransition scaleT =new ScaleTransition(Duration.millis(400), btnSelectMeal);
        scaleT.setToX(1);
        scaleT.setToY(1);
        scaleT.play();
        btnSelectMeal.setEffect(null);
    }

    @FXML
    void btnTodayDayAction(ActionEvent event) {
        setTimeDate();
        txtReserveDate.setDisable(true);
        txtReleaseDate.requestFocus();
    }

    @FXML
    void btnUnlockAction(ActionEvent event) {

    }

    @FXML
    void btnUnlockMouseEnter(MouseEvent event) {

    }

    @FXML
    void btnUnlockMouseExit(MouseEvent event) {

    }

    @FXML
    void btnUpdateAction(ActionEvent event) {
        boolean updated = false;
        try {
            updated = customerService.updateCustomer(new CustomerDTO(txtNIC.getText(), txtUName.getText(), Integer.parseInt(txtContact.getText()), txtAddress.getText()));
        } catch (Exception e) {
            new Alert(Alert.AlertType.INFORMATION,e.getMessage(), ButtonType.CLOSE).show();
        }
        if (updated){
            new Alert(Alert.AlertType.CONFIRMATION,"Customer update SUCCESS ... !", ButtonType.CLOSE).show();
            loadtblCus();
            cmbBeds.requestFocus();
        } else {
            new Alert(Alert.AlertType.INFORMATION,"Customer update FAILIER ... !", ButtonType.CLOSE).show();
        }
    }

    @FXML
    void btnUpdateMouseEntered(MouseEvent event) {
        ScaleTransition scaleT =new ScaleTransition(Duration.millis(400), btnUpdate);
        scaleT.setToX(1.2);
        scaleT.setToY(1.2);
        scaleT.play();
        DropShadow glow = new DropShadow();
        glow.setColor(Color.DARKBLUE);
        glow.setWidth(20);
        glow.setHeight(20);
        glow.setRadius(20);
        btnUpdate.setEffect(glow);
    }

    @FXML
    void btnUpdateMouseExited(MouseEvent event) {
        ScaleTransition scaleT =new ScaleTransition(Duration.millis(400), btnUpdate);
        scaleT.setToX(1);
        scaleT.setToY(1);
        scaleT.play();
        btnUpdate.setEffect(null);
    }

    @FXML
    void cmbBedsAction(ActionEvent event) {
        btnSearchRoom.requestFocus();
    }

    @FXML
    void cmbAdultsAction(ActionEvent event) {
        lblMealPrice.setTextFill(Paint.valueOf("blue"));
        if (btnMeal1.isSelected()){
            final int meal = 200;
            int adultPrice = meal * cmbAdults.getSelectionModel().getSelectedItem();
            int kidPrice = (meal / 2) * cmbKids.getSelectionModel().getSelectedItem();
            lblMealPrice.setText(String.valueOf(adultPrice + kidPrice));
        } else if (btnMeal2.isSelected()){
            final int meal = 400;
            int adultPrice = meal * cmbAdults.getSelectionModel().getSelectedItem();
            int kidPrice = (meal / 2) * cmbKids.getSelectionModel().getSelectedItem();
            lblMealPrice.setText(String.valueOf(adultPrice + kidPrice));
        } else if (btnFullsetMeal.isSelected()){
            final int meal = 500;
            int adultPrice = meal * cmbAdults.getSelectionModel().getSelectedItem();
            int kidPrice = (meal / 2) * cmbKids.getSelectionModel().getSelectedItem();
            lblMealPrice.setText(String.valueOf(adultPrice + kidPrice));
        } else if (btnRefreshment.isSelected()){
            lblMealPrice.setText(String.valueOf(0));
        }
    }

    @FXML
    void cmbKidsAction(ActionEvent event) {
        lblMealPrice.setTextFill(Paint.valueOf("blue"));
        if (btnMeal1.isSelected()){
            final int meal = 200;
            int adultPrice = meal * cmbAdults.getSelectionModel().getSelectedItem();
            int kidPrice = (meal / 2) * cmbKids.getSelectionModel().getSelectedItem();
            lblMealPrice.setText(String.valueOf(adultPrice + kidPrice));
        } else if (btnMeal2.isSelected()){
            final int meal = 400;
            int adultPrice = meal * cmbAdults.getSelectionModel().getSelectedItem();
            int kidPrice = (meal / 2) * cmbKids.getSelectionModel().getSelectedItem();
            lblMealPrice.setText(String.valueOf(adultPrice + kidPrice));
        } else if (btnFullsetMeal.isSelected()){
            final int meal = 500;
            int adultPrice = meal * cmbAdults.getSelectionModel().getSelectedItem();
            int kidPrice = (meal / 2) * cmbKids.getSelectionModel().getSelectedItem();
            lblMealPrice.setText(String.valueOf(adultPrice + kidPrice));
        } else if (btnRefreshment.isSelected()){
            lblMealPrice.setText(String.valueOf(0));
        }
    }

    @FXML
    void cmbFloorAction(ActionEvent event) {
        btnSearchRoom.requestFocus();
    }

    @FXML
    void lblRoomNUMealAction(MouseEvent event) {

    }

    @FXML
    void lblWelcomeMouseCliecked(MouseEvent event) {
        URL url = null;
        try {
            url = new File("RoomReservation_Client/assets/xmls/Login.fxml").toURI().toURL();
        } catch (MalformedURLException e) {
            new Alert(Alert.AlertType.INFORMATION,e.getMessage(), ButtonType.CLOSE).show();
        }
        try {
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            Main.stage.setScene(scene);
            Main.stage.centerOnScreen();
            Main.stage.setTitle("Login");
            Main.stage.show();
            LoginController.reservationStage.close();
        } catch (IOException e) {
            new Alert(Alert.AlertType.INFORMATION,e.getMessage(), ButtonType.CLOSE).show();
        }
    }

    @FXML
    void lblWelcomeMouseEntered(MouseEvent event) {
        lblWelcome.setTextFill(Paint.valueOf("red"));
    }

    @FXML
    void lblWelcomeMouseExited(MouseEvent event) {
        lblWelcome.setTextFill(Paint.valueOf("blue"));
    }

    @FXML
    void tblRoomMouseClicked(MouseEvent event) {
        RoomDTO room = null;
        try {
            RoomTM tm = tblRoom.getSelectionModel().getSelectedItem();
            RoomDTO temp = new RoomDTO();
            temp.setRoomNumber(tm.getRoomNumber());
            room = roomService.searchRoom(temp);
            paneMeal.setDisable(false);
            lblRoomNUMeal.setText(Integer.toString(room.getRoomNumber()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void tbtUserMouseClicked(MouseEvent event) {
        CustomerDTO cus = null;
        try {
            CustomerTM tm = tblCus.getSelectionModel().getSelectedItem();
            CustomerDTO temp = new CustomerDTO();
            temp.setNic(tm.getNic());
            cus = customerService.searchCustomer(temp);
            btnRemove.setDisable(false);
            btnUpdate.setDisable(false);
            btnAdd.setDisable(true);
            txtUName.setDisable(false);
            txtContact.setDisable(false);
            txtAddress.setDisable(false);
            txtNIC.setText(cus.getNic());
            txtUName.setText(cus.getCustomerName());
            txtContact.setText(Integer.toString(cus.getContact()));
            txtAddress.setText(cus.getAddress());
            cmbBeds.requestFocus();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void txtAddressAction(ActionEvent event) {

    }

    @FXML
    void txtContactAction(ActionEvent event) {
        txtAddress.requestFocus();
    }

    @FXML
    void txtDaysBookedAction(ActionEvent event) {

    }

    @FXML
    void txtDiscountAction(ActionEvent event) {

    }

    @FXML
    void txtNICAction(ActionEvent event) {
        CustomerDTO cus = null;
        CustomerDTO temp = new CustomerDTO();
        temp.setNic(txtNIC.getText());
        try {
            cus = customerService.searchCustomer(temp);
        } catch (Exception e) {
            new Alert(Alert.AlertType.INFORMATION,e.getMessage(), ButtonType.CLOSE).show();
        }
        if (cus != null){
            btnRemove.setDisable(false);
            btnUpdate.setDisable(false);
            btnAdd.setDisable(true);
            txtUName.setDisable(false);
            txtContact.setDisable(false);
            txtAddress.setDisable(false);
            txtUName.setText(cus.getCustomerName());
            txtContact.setText(Integer.toString(cus.getContact()));
            txtAddress.setText(cus.getAddress());
            cmbBeds.requestFocus();
        } else {
            txtUName.setText("");
            txtContact.setText("");
            txtAddress.setText("");
            txtUName.setDisable(false);
            txtContact.setDisable(false);
            txtAddress.setDisable(false);
            btnRemove.setDisable(true);
            btnUpdate.setDisable(true);
            btnAdd.setDisable(false);
            txtUName.requestFocus();
        }
    }

    @FXML
    void txtNICKeyPressed(KeyEvent event) {
        ArrayList<CustomerDTO> allCustomersdto = null;
        try {
            allCustomersdto = customerService.searchAllCustomers(txtNIC.getText());
        } catch (Exception e) {
            new Alert(Alert.AlertType.INFORMATION,e.getMessage(), ButtonType.CLOSE).show();
        }
        ArrayList<CustomerTM> allCus = new ArrayList<>();
        for (CustomerDTO dto :
                allCustomersdto) {
            allCus.add(new CustomerTM(dto.getNic(),dto.getCustomerName(),dto.getContact()));
        }
        tblCus.setItems(FXCollections.observableArrayList(allCus));
    }

    @FXML
    void txtPaidAction(ActionEvent event) {

    }

    @FXML
    void txtReleaseDateAction(ActionEvent event) {

    }

    @FXML
    void txtReserveDateAction(ActionEvent event) {
    }

    @FXML
    void txtRoomNuServiceAction(ActionEvent event) {

    }

    @FXML
    void txtRoomnUReleaseAction(ActionEvent event) {

    }

    @FXML
    void txtUnameAction(ActionEvent event) {
        txtContact.requestFocus();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblWelcome.setText("Welcome " + LoginController.userName + " !");
        tblCus.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("nic"));
        tblCus.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblCus.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("contact"));

        tblRoom.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        tblRoom.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("beds"));
        tblRoom.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("ac"));
        tblRoom.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("floor"));
        tblRoom.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("available"));

        for (int i = 1; i <= 3; i++){
            cmbBeds.getItems().add(i);
            cmbAdults.getItems().add(i);
        }

        for (int i = 1; i <= 6; i++){
            cmbFloor.getItems().add(i);
        }

        for (int i = 0; i <= 5; i++) {
            cmbKids.getItems().add(i);
        }

        setTimeDate();
        resetUI();
    }

    private void loadTblRoom (ArrayList<RoomDTO> allRooms) {
        ArrayList<RoomTM> tm = new ArrayList<>();
        for (RoomDTO dto :
                allRooms) {
            tm.add(new RoomTM(dto.getRoomNumber(), dto.getBeds(), dto.getFloor(), dto.isAc(), dto.isAvailable()));
        }
        tblRoom.setItems(FXCollections.observableArrayList(tm));
    }

    private void resetUI () {
        lblMealPrice.setText(String.valueOf(200));
        loadtblCus();
        ArrayList<RoomDTO> allRooms = null;
        try {
            allRooms = roomService.getAllRooms();
        } catch (Exception e) {
            new Alert(Alert.AlertType.INFORMATION,e.getMessage(), ButtonType.CLOSE).show();
        }
        loadTblRoom(allRooms);
        btnAdd.setDisable(false);
        btnRemove.setDisable(true);
        btnUpdate.setDisable(true);
        txtUName.setDisable(true);
        txtContact.setDisable(true);
        txtAddress.setDisable(true);
        cmbBeds.getSelectionModel().select(0);
        cmbFloor.getSelectionModel().select(0);
        cmbAdults.getSelectionModel().select(0);
        cmbKids.getSelectionModel().select(0);
        txtReserveDate.setDisable(true);
        tblRoom.setDisable(true);
        paneMeal.setDisable(true);
        btnReserveRoom.setDisable(true);
        btnMeal1.setSelected(true);
        lblMealPrice.setTextFill(Paint.valueOf("blue"));
    }

    private void setTimeDate () {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lblDate.setText(new SimpleDateFormat("YYYY-MM-dd").format(new Date()));
                txtReserveDate.setPromptText(new SimpleDateFormat("dd/MM/YYYY").format(new Date()));
                lblTime.setText(new SimpleDateFormat("hh:mm:ss a").format(new Date()));
            }
        }), new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void loadtblCus () {
        ArrayList<CustomerDTO> allCustomersdto = null;
        try {
            allCustomersdto = customerService.getAllCustomers();
        } catch (Exception e) {
            new Alert(Alert.AlertType.INFORMATION,e.getMessage(), ButtonType.CLOSE).show();
        }
        ArrayList<CustomerTM> allCus = new ArrayList<>();
        for (CustomerDTO dto :
                allCustomersdto) {
            allCus.add(new CustomerTM(dto.getNic(),dto.getCustomerName(),dto.getContact()));
        }
        tblCus.setItems(FXCollections.observableArrayList(allCus));
    }
}