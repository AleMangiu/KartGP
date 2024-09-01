package com.example.kartgp.controller;

import com.example.kartgp.bean.*;
import com.example.kartgp.controller_app.LeadBoardControllerApp;
import com.example.kartgp.controller_app.SubscriptionControllerApp;
import com.example.kartgp.controller_app.TournamentControllerApp;
import com.example.kartgp.controller_app.UserControllerApp;
import com.example.kartgp.entity.Subscription;
import com.example.kartgp.entity.Tournament;
import com.example.kartgp.exception.DuplicateReceiptException;
import com.example.kartgp.exception.ReceiptNotFoundException;
import com.example.kartgp.utilities.FileGenerator;
import com.opencsv.exceptions.CsvValidationException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class MainController implements Initializable {

    //region properties

    private static final String LOCATION = "location";
    private static final String ROLE_1 = "Admin";
    private static final String ROLE_2 = "Driver";
    private static final String ROLE_3 = "Referee";

    @FXML
    private AnchorPane driverLeadboard;

    @FXML
    private TextArea driverNameLead;

    @FXML
    private TableColumn<LeadBoardBean, String> driverNameLeadbooard;

    @FXML
    private TableColumn<LeadBoardBean, Integer> driverNumberRaceLeadbooard;

    @FXML
    private TableColumn<LeadBoardBean, Integer> driverPointLeadbooard;

    @FXML
    private TableView<LeadBoardBean> driverTableLeadbooard;

    @FXML
    private TextField driverNameConfirm;
    @FXML
    private Spinner<Integer> driverIdConfirm;
    @FXML
    private TextField driverTournamentConfirm;
    @FXML
    private Spinner<Integer> driverTournamentIdConfirm;

    @FXML
    private Spinner<Integer> driverPointConfirm;

    @FXML
    private Button backToHomeFromRefereeDetail;

    @FXML
    private TableColumn refereeDetailConfirm;

    @FXML
    private TableColumn<SubscriptionBean, String> refereeDetailDriver;

    @FXML
    private TableColumn<SubscriptionBean, Integer> refereeDetailDriverId;

    @FXML
    private TextArea refereeDetailName;

    @FXML
    private TableColumn<SubscriptionBean, Integer> refereeDetailPoint;

    @FXML
    private TableColumn<SubscriptionBean, String> refereeDetailTournament;

    @FXML
    private TableColumn<SubscriptionBean, Integer> refereeDetailTournamentId;

    @FXML
    private AnchorPane refereeDetailView;

    @FXML
    private TableView<SubscriptionBean> table;

    @FXML
    public TableColumn refereeDetail;

    @FXML
    public TableColumn<MyTournament, Integer> refereeCost;

    @FXML
    public TableColumn<MyTournament, LocalDate> refereeDate;

    @FXML
    public TableColumn<MyTournament, String> refereeLocation;

    @FXML
    private TextArea refereeName;

    @FXML
    private AnchorPane refereePage;

    @FXML
    public TableView<MyTournament> refereeTable;

    @FXML
    public TableColumn<MyTournament, Integer> refereeTournamentId;

    @FXML
    public TableColumn<MyTournament, String> refereeTournamentName;

    @FXML
    private AnchorPane driverMySubscription;

    @FXML
    public TableColumn<MyTournament, Integer> driverMySubscriptionCost;

    @FXML
    public TableColumn<MyTournament, LocalDate> driverMySubscriptionDate;

    @FXML
    public TableColumn<MyTournament, Integer> driverMySubscriptionId;

    @FXML
    public TableColumn<MyTournament, String> driverMySubscriptionLocation;

    @FXML
    public TextArea driverMySubscriptionName;

    @FXML
    public TableView<MyTournament> driverMySubscriptionTable;

    @FXML
    public TableColumn<MyTournament, String> driverMySubscriptionTournamentName;

    @FXML
    private AnchorPane viewAllTournament;

    @FXML
    public TableView<MyTournament> tableAllTournament;

    @FXML
    public TableColumn<MyTournament, Integer> viewAllTournamentCost;

    @FXML
    public TableColumn<MyTournament, LocalDate> viewAllTournamentDate;

    @FXML
    public TableColumn<MyTournament, Integer> viewAllTournamentId;

    @FXML
    public TableColumn<MyTournament, String> viewAllTournamentLocation;

    @FXML
    public TableColumn<MyTournament, String> viewAllTournamentName;

    @FXML
    public TableColumn<MyTournament, String> viewAllAction;

    @FXML
    private TextArea driverName1;

    @FXML
    private AnchorPane driverPage;

    @FXML
    private TextArea driverName;

    @FXML
    public TableColumn viewMyTournamentButton;

    @FXML
    public TableView<MyTournament> tableMyTournament;

    @FXML
    public TableColumn<MyTournament, Integer> viewMyTournamentId;

    @FXML
    public TableColumn<MyTournament, String> viewMyTournamentName;

    @FXML
    public TableColumn<MyTournament, String> viewMyTournamentLocation;

    @FXML
    public TableColumn<MyTournament, LocalDate> viewMyTournamentDate;

    @FXML
    private AnchorPane viewMyTournament;

    @FXML
    private TextArea adminNameTournament;

    @FXML
    private AnchorPane adminForm;

    @FXML
    private AnchorPane adminCreateTournament;

    @FXML
    private TextArea adminName;

    @FXML
    private AnchorPane adminPage;

    @FXML
    private AnchorPane loginForm;

    @FXML
    private TextArea adminName1;

    @FXML
    private TextField loginUsername;

    @FXML
    private PasswordField loginPassword;

    @FXML
    private Button loginBtn;

    @FXML
    private ComboBox<String> loginRole;

    @FXML
    private TextField adminUsername;

    @FXML
    private PasswordField adminPassword;

    @FXML
    private Button adminSignupbtn;

    @FXML
    private Hyperlink adminSignin;

    @FXML
    private PasswordField adminConfirmPassword;

    @FXML
    private AnchorPane driverForm;

    @FXML
    private TextField driverUsername;

    @FXML
    private PasswordField driverPassword;

    @FXML
    private Button driverSignupbtn;

    @FXML
    private Hyperlink driverSignin;

    @FXML
    private PasswordField driverConfirmPassword;

    @FXML
    private AnchorPane refreeForm;

    @FXML
    private TextField refreeUsername;

    @FXML
    private PasswordField refreePassword;

    @FXML
    private Button refreeSignupbtn;

    @FXML
    private Hyperlink refreeSignin;

    @FXML
    private PasswordField refreeConfirmPassword;

    @FXML
    private TextField tournamentName;

    @FXML
    private TextField tournamentLocation;

    @FXML
    private DatePicker tournamentDate;

    @FXML
    private Spinner<Integer> tournamentCost;

    @FXML
    private Spinner<Integer> tournamentNumber;

    private UserBean userGlobal;
    //endregion

    //region methods

    //region login signing

    @FXML
    public void logout(){
        loginForm.setVisible(true);
        adminPage.setVisible(false);
        driverPage.setVisible(false);
        refereePage.setVisible(false);
    }

    @FXML
    public void login() {
        try {
            UserBean userBean = new UserBean();
            userBean.setUsername(loginUsername.getText());
            userBean.setPassword(loginPassword.getText());
            userBean.checkField(userBean.getUsername(), userBean.getPassword());
            UserControllerApp.login(userBean);
            userGlobal = userBean;

            if(userBean.getRole().equals(ROLE_1)) {
                adminPage.setVisible(true);
                loginForm.setVisible(false);
                adminName.setText(userBean.getUsername());
            }

            if(userBean.getRole().equals(ROLE_2)) {
                driverPage.setVisible(true);
                loginForm.setVisible(false);
                driverName.setText(userBean.getUsername());
            }

            if(userBean.getRole().equals(ROLE_3)) {
                loginForm.setVisible(false);
                goToRefereePage();
            }

        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    @FXML
    public void switchForm() {
        switch (loginRole.getSelectionModel().getSelectedItem()) {
            case ROLE_1 -> {
                adminForm.setVisible(true);
                refreeForm.setVisible(false);
                driverForm.setVisible(false);
                loginForm.setVisible(false);
            }
            case ROLE_2 -> {
                adminForm.setVisible(false);
                refreeForm.setVisible(false);
                driverForm.setVisible(true);
                loginForm.setVisible(false);
            }
            case ROLE_3 -> {
                refreeForm.setVisible(true);
                driverForm.setVisible(false);
                refreeForm.setVisible(true);
                loginForm.setVisible(false);
            }
        }
    }

    @FXML
    public void signinForm() {
        loginForm.setVisible(true);
        adminForm.setVisible(false);
        refreeForm.setVisible(false);
        driverForm.setVisible(false);
    }

    @FXML
    public void signup() {
        try {
            UserBean userBean = new UserBean();
            if (adminForm.isVisible()) {
                setVisibleOfSigning(userBean, adminUsername, adminPassword, adminConfirmPassword);
            }
            else if (refreeForm.isVisible()) {
                setVisibleOfSigning(userBean, refreeUsername, refreePassword, refreeConfirmPassword);
            }
            else if (driverForm.isVisible()) {
                setVisibleOfSigning(userBean, driverUsername, driverPassword, driverConfirmPassword);
            }

        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    //endregion

    //region Admin

    @FXML
    public void createTournamentForm() {
        adminPage.setVisible(false);
        adminCreateTournament.setVisible(true);
        adminName1.setText(userGlobal.getUsername());

    }

    @FXML
    public void viewMyTournamentForm(ActionEvent actionEvent) throws Exception {
        adminPage.setVisible(false);
        adminCreateTournament.setVisible(false);
        viewMyTournament.setVisible(true);
        adminNameTournament.setText(userGlobal.getUsername());
        viewMyTournamentId.setCellValueFactory(new PropertyValueFactory<MyTournament, Integer>("id"));
        viewMyTournamentName.setCellValueFactory(new  PropertyValueFactory<MyTournament, String>("name"));
        viewMyTournamentLocation.setCellValueFactory(new  PropertyValueFactory<MyTournament, String>(LOCATION));
        viewMyTournamentDate.setCellValueFactory(new  PropertyValueFactory<MyTournament, LocalDate>("date"));
        var listMtTournament = TournamentControllerApp.getAllByAdminIdTournaments(userGlobal.getId());
        ObservableList<MyTournament> list = FXCollections.observableArrayList(listMtTournament);
        tableMyTournament.setItems(list);

        Callback<TableColumn<MyTournament, String >, TableCell<MyTournament, String>> cellFactory =(param) ->{
            return new TableCell<MyTournament, String>(){
                @Override
                public void updateItem(String item, boolean empty){
                    super.updateItem(item, empty);
                    if(empty){
                        setGraphic(null);
                        setText(null);
                    }
                    else {
                        final Button payAndSubButton = new Button("Download");
                        payAndSubButton.setOnAction(event -> {
                            MyTournament myTournament = getTableView().getItems().get(getIndex());
                            try {
                                download(myTournament);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        });
                        setGraphic(payAndSubButton);
                    }
                }

            };
        };

        viewMyTournamentButton.setCellFactory(cellFactory);
    }

    @FXML
    public void backToHomeFromCreate() {
        adminCreateTournament.setVisible(false);
        adminPage.setVisible(true);
    }

    @FXML
    public void backToHomeFromMytournament(){
        viewMyTournament.setVisible(false);
        adminPage.setVisible(true);
    }
    @FXML
    public void createTournament() throws Exception {

        TournamentBean tournamentBean = new TournamentBean();
        tournamentBean.setName(tournamentName.getText());
        tournamentBean.setLocation(tournamentLocation.getText());
        tournamentBean.setCost(tournamentCost.getValue());
        tournamentBean.setNumber(tournamentNumber.getValue());
        tournamentBean.setDate(tournamentDate.getValue());
        tournamentBean.checkField(tournamentBean.getName(), tournamentBean.getLocation(), tournamentBean.getDate(), tournamentBean.getCost(), tournamentBean.getNumber());

        TournamentControllerApp.createTournament(userGlobal, tournamentBean);

    }

    //endregion

    //region Driver

    @FXML
    public void joinTournament() throws Exception {
        driverPage.setVisible(false);
        viewAllTournament.setVisible(true);
        driverName1.setText(userGlobal.getUsername());
        viewAllTournamentId.setCellValueFactory(new PropertyValueFactory<MyTournament, Integer>("id"));
        viewAllTournamentName.setCellValueFactory(new PropertyValueFactory<MyTournament, String>("name"));
        viewAllTournamentLocation.setCellValueFactory(new  PropertyValueFactory<MyTournament, String>(LOCATION));
        viewAllTournamentDate.setCellValueFactory(new PropertyValueFactory<MyTournament, LocalDate>("date"));
        viewAllTournamentCost.setCellValueFactory(new PropertyValueFactory<MyTournament, Integer>("cost"));
        var listMtTournament = TournamentControllerApp.getAllTournaments();
        ObservableList<MyTournament> list = FXCollections.observableArrayList(listMtTournament);
        tableAllTournament.setItems(list);

        Callback<TableColumn<MyTournament, String >, TableCell<MyTournament, String>> cellFactory =(param) ->{
            return new TableCell<MyTournament, String>(){
                @Override
                public void updateItem(String item, boolean empty){
                    super.updateItem(item, empty);
                    if(empty){
                        setGraphic(null);
                        setText(null);
                    }
                    else {
                        final Button payAndSubButton = new Button("PayAndSub");
                        payAndSubButton.setOnAction(event -> {
                            MyTournament myTournament = getTableView().getItems().get(getIndex());
                            try {
                                payAndSubscription(myTournament);
                                ReceiptBean receiptBean = new ReceiptBean();
                                List<SubscriptionBean> subscriptionBeanList = SubscriptionControllerApp.getTournamentSubscription(myTournament.getId());
                                for(SubscriptionBean subscription : subscriptionBeanList) {
                                    receiptBean.setDate(LocalDate.now());
                                    receiptBean.setIdDriver(subscription.getIdDriver());
                                    receiptBean.setIdTournament(subscription.getIdTournament());
                                    SubscriptionControllerApp.createReceipt(receiptBean);
                                }
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        });
                        setGraphic(payAndSubButton);
                    }
                }

            };
        };

        viewAllAction.setCellFactory(cellFactory);

    }

    @FXML
    public void viewLeaderBoard(ActionEvent actionEvent) throws SQLException {
        driverPage.setVisible(false);
        driverNameLead.setText(userGlobal.getUsername());
        driverLeadboard.setVisible(true);
        driverNameLeadbooard.setCellValueFactory(new PropertyValueFactory<LeadBoardBean, String>("driver"));
        driverNumberRaceLeadbooard.setCellValueFactory(new PropertyValueFactory<LeadBoardBean, Integer>("numberRace"));
        driverPointLeadbooard.setCellValueFactory(new  PropertyValueFactory<LeadBoardBean, Integer>("totalPoint"));
        var leadBoard = LeadBoardControllerApp.getLeadBoard();
        ObservableList<LeadBoardBean> list = FXCollections.observableArrayList(leadBoard);
        driverTableLeadbooard.setItems(list);
    }

    @FXML
    public void viewMySubscription() throws SQLException {
        driverPage.setVisible(false);
        driverMySubscription.setVisible(true);
        driverMySubscriptionName.setText(userGlobal.getUsername());
        driverMySubscriptionId.setCellValueFactory(new PropertyValueFactory<MyTournament, Integer>("id"));
        driverMySubscriptionTournamentName.setCellValueFactory(new PropertyValueFactory<MyTournament, String>("name"));
        driverMySubscriptionLocation.setCellValueFactory(new  PropertyValueFactory<MyTournament, String>(LOCATION));
        driverMySubscriptionDate.setCellValueFactory(new PropertyValueFactory<MyTournament, LocalDate>("date"));
        driverMySubscriptionCost.setCellValueFactory(new PropertyValueFactory<MyTournament, Integer>("cost"));
        var listMtTournament = SubscriptionControllerApp.getAllSubscriptionsByUser(userGlobal.getId());
        ObservableList<MyTournament> list = FXCollections.observableArrayList(listMtTournament);
        driverMySubscriptionTable.setItems(list);

    }

    @FXML
    public void backToHomeFromLeadBoard(){
        driverLeadboard.setVisible(false);
        driverPage.setVisible(true);
    }

    @FXML
    public void backToHomeFromAllTournament() {
        viewAllTournament.setVisible(false);
        driverPage.setVisible(true);
    }

    @FXML
    public void backToHomeFromSubscriptionTable(){
        driverMySubscription.setVisible(false);
        driverPage.setVisible(true);
    }

    //endregion

    //region Referee

    private void goToRefereePage() throws Exception {
        refereePage.setVisible(true);
        refereeName.setText(userGlobal.getUsername());
        refereeTournamentId.setCellValueFactory(new PropertyValueFactory<MyTournament, Integer>("id"));
        refereeTournamentName.setCellValueFactory(new  PropertyValueFactory<MyTournament, String>("name"));
        refereeLocation.setCellValueFactory(new  PropertyValueFactory<MyTournament, String>(LOCATION));
        refereeDate.setCellValueFactory(new  PropertyValueFactory<MyTournament, LocalDate>("date"));
        refereeCost.setCellValueFactory(new  PropertyValueFactory<MyTournament, Integer>("cost"));
        var listMtTournament = TournamentControllerApp.getAllTournaments();
        ObservableList<MyTournament> list = FXCollections.observableArrayList(listMtTournament);
        refereeTable.setItems(list);

        Callback<TableColumn<MyTournament, String >, TableCell<MyTournament, String>> cellFactory =(param) ->{
            return new TableCell<MyTournament, String>(){
                @Override
                public void updateItem(String item, boolean empty){
                    super.updateItem(item, empty);
                    if(empty){
                        setGraphic(null);
                        setText(null);
                    }
                    else {
                        final Button payAndSubButton = new Button("Detail");
                        payAndSubButton.setOnAction(event -> {
                            MyTournament myTournament = getTableView().getItems().get(getIndex());
                            try {
                                detail(myTournament.getId());
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        });
                        setGraphic(payAndSubButton);
                    }
                }

            };
        };

        refereeDetail.setCellFactory(cellFactory);
    }

    private void detail(int id) throws SQLException {
        refereePage.setVisible(false);
        refereeDetailView.setVisible(true);
        refereeDetailName.setText(userGlobal.getUsername());
        refereeDetailDriverId.setCellValueFactory(new PropertyValueFactory<SubscriptionBean, Integer>("idDriver"));
        refereeDetailDriver.setCellValueFactory(new  PropertyValueFactory<SubscriptionBean, String>("driver"));
        refereeDetailTournament.setCellValueFactory(new  PropertyValueFactory<SubscriptionBean, String>("tournament"));
        refereeDetailTournamentId.setCellValueFactory(new  PropertyValueFactory<SubscriptionBean, Integer>("idTournament"));
        refereeDetailPoint.setCellValueFactory(new  PropertyValueFactory<SubscriptionBean, Integer>("point"));
        var listMtTournament = SubscriptionControllerApp.getTournamentSubscription(id);
        ObservableList<SubscriptionBean> list = FXCollections.observableArrayList(listMtTournament);
        table.setItems(list);

        Callback<TableColumn<SubscriptionBean, String >, TableCell<SubscriptionBean, String>> cellFactory =(param) ->{
            return new TableCell<SubscriptionBean, String>(){
                @Override
                public void updateItem(String item, boolean empty){
                    super.updateItem(item, empty);
                    if(empty){
                        setGraphic(null);
                        setText(null);
                    }
                    else {
                        final Button confirmVote = new Button("ConfirmVote");
                        confirmVote.setOnAction(event -> {
                            SubscriptionBean subscription = getTableView().getItems().get(getIndex());
                            try {
                                confirmVote(subscription);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        });
                        setGraphic(confirmVote);
                    }
                }

            };
        };

        refereeDetailConfirm.setCellFactory(cellFactory);
    }
    @FXML
    public void backToHomeFromRefereeDetail(){
        refereeDetailView.setVisible(false);
        refereePage.setVisible(true);
    }

    @FXML
    public void confirm() throws SQLException {
        var driver = driverNameConfirm.getText();
        var driverId = driverIdConfirm.getValue();
        var tournament = driverTournamentConfirm.getText();
        var tournamentId = driverTournamentIdConfirm.getValue();
        var point = driverPointConfirm.getValue();

        new SubscriptionBean(driverId, tournamentId, point, driver, tournament);
        SubscriptionControllerApp.updateSubscription(point, driverId, tournamentId);

        driverNameConfirm.setText("");
        driverIdConfirm.getValueFactory().setValue(0);
        driverTournamentIdConfirm.getValueFactory().setValue(0);
        driverPointConfirm.getValueFactory().setValue(0);
        driverTournamentConfirm.setText("");

        detail(tournamentId);
    }
    //endregion

    //endregion

    //region private methods

    public void confirmVote(SubscriptionBean subscription) throws SQLException {
        driverNameConfirm.setText(subscription.getDriver());
        driverTournamentConfirm.setText(subscription.getTournament());
        driverIdConfirm.getValueFactory().setValue(subscription.getIdDriver());
        driverIdConfirm.setEditable(false);
        driverTournamentIdConfirm.getValueFactory().setValue(subscription.getIdTournament());
        driverIdConfirm.setEditable(false);
        driverPointConfirm.getValueFactory().setValue(subscription.getPoint());
    }

    public void payAndSubscription(MyTournament myTournament) throws Exception {
        TournamentBean tournamentBean = new TournamentBean(myTournament.getId(), myTournament.getName());
        SubscriptionControllerApp.payAndSubscription(userGlobal, tournamentBean);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Pay and Subscription done");
        alert.show();
    }

    public void download(MyTournament tournament) throws SQLException, CsvValidationException, ReceiptNotFoundException, IOException, DuplicateReceiptException {
        var driverList = SubscriptionControllerApp.getTournamentSubscription(tournament.getId());
        FileGenerator.generateFile(tournament.getName(), driverList.toString());
        Logger logger = Logger.getLogger(getClass().getName());
        logger.info("File created successfully!");
    }

    private void setRoleList() {
        String[] role = {ROLE_1, ROLE_2, ROLE_3};
        List<String> listRole = new ArrayList<>(Arrays.asList(role));

        ObservableList<String> listData = FXCollections.observableArrayList(listRole);
        loginRole.setItems(listData);
    }

    private void setVisibleOfSigning(UserBean userBean, TextField adminUsername, PasswordField adminPassword, PasswordField adminConfirmPassword) throws Exception {
        userBean.setUsername(adminUsername.getText());
        userBean.setPassword(adminPassword.getText());
        userBean.setCheckPassword(adminConfirmPassword.getText());
        userBean.setRole(loginRole.getValue());
        userBean.checkIfPassIsEqual(userBean.getPassword(), userBean.getCheckPassword());
        boolean check = UserControllerApp.signing(userBean);
        if(check) {
            adminForm.setVisible(false);
            loginForm.setVisible(true);
        }
    }

    //endregion
    
    //region override

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setRoleList();
        SpinnerValueFactory<Integer> spinner = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,1000,1);
        tournamentCost.setValueFactory(spinner);

        SpinnerValueFactory<Integer> spinner2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100,1);
        tournamentNumber.setValueFactory(spinner2);

        SpinnerValueFactory<Integer> spinner3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000, 0);
        driverPointConfirm.setValueFactory(spinner3);

        SpinnerValueFactory<Integer> spinner4 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,1000000000, 0);
        driverTournamentIdConfirm.setValueFactory(spinner4);

        SpinnerValueFactory<Integer> spinner5 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,1000000000, 0);
        driverIdConfirm.setValueFactory(spinner5);


    }

    //endregion
}