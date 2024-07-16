package com.example.kartgp.controller;

import com.example.kartgp.bean.*;
import com.example.kartgp.controller_app.LeadBoardControllerApp;
import com.example.kartgp.controller_app.SubscriptionControllerApp;
import com.example.kartgp.controller_app.TournamentControllerApp;
import com.example.kartgp.controller_app.UserControllerApp;
import com.example.kartgp.utilities.DataList;
import com.example.kartgp.utilities.FileGeneretor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    //region properties

    @FXML
    private AnchorPane driver_leadboard;

    @FXML
    private TextArea driver_name_lead;

    @FXML
    private TableColumn<LeadBoardBean, String> driver_name_leadbooard;

    @FXML
    private TableColumn<LeadBoardBean, Integer> driver_number_race_leadbooard;

    @FXML
    private TableColumn<LeadBoardBean, Integer> driver_point_leadbooard;

    @FXML
    private TableView<LeadBoardBean> driver_table_leadbooard;

    @FXML
    private TextField driver_name_confirm;
    @FXML
    private Spinner<Integer> driver_id_confirm;
    @FXML
    private TextField driver_tournament_confirm;
    @FXML
    private Spinner<Integer> driver_tournament_id_confirm;

    @FXML
    private Spinner<Integer> driver_point_confirm;

    @FXML
    private Button backToHomeFromRefereeDetail;

    @FXML
    private TableColumn referee_detail_confirm;

    @FXML
    private TableColumn<SubscriptionBean, String> referee_detail_driver;

    @FXML
    private TableColumn<SubscriptionBean, Integer> referee_detail_driver_id;

    @FXML
    private TextArea referee_detail_name;

    @FXML
    private TableColumn<SubscriptionBean, Integer> referee_detail_point;

    @FXML
    private TableColumn<SubscriptionBean, String> referee_detail_tournament;

    @FXML
    private TableColumn<SubscriptionBean, Integer> referee_detail_tournamentId;

    @FXML
    private AnchorPane referee_detail_view;

    @FXML
    private TableView<SubscriptionBean> table;

    @FXML
    public TableColumn referee_detail;

    @FXML
    public TableColumn<MyTournament, Integer> referee_cost;

    @FXML
    public TableColumn<MyTournament, LocalDate> referee_date;

    @FXML
    public TableColumn<MyTournament, String> referee_location;

    @FXML
    private TextArea referee_name;

    @FXML
    private AnchorPane referee_page;

    @FXML
    public TableView<MyTournament> referee_table;

    @FXML
    public TableColumn<MyTournament, Integer> referee_tournament_id;

    @FXML
    public TableColumn<MyTournament, String> referee_tournament_name;

    @FXML
    private AnchorPane driver_my_subscription;

    @FXML
    public TableColumn<MyTournament, Integer> driver_my_subscription_cost;

    @FXML
    public TableColumn<MyTournament, LocalDate> driver_my_subscription_date;

    @FXML
    public TableColumn<MyTournament, Integer> driver_my_subscription_id;

    @FXML
    public TableColumn<MyTournament, String> driver_my_subscription_location;

    @FXML
    public TextArea driver_my_subscription_name;

    @FXML
    public TableView<MyTournament> driver_my_subscription_table;

    @FXML
    public TableColumn<MyTournament, String> driver_my_subscription_tournament_name;

    @FXML
    private AnchorPane view_all_tournament;

    @FXML
    public TableView<MyTournament> table_all_tournament;

    @FXML
    public TableColumn<MyTournament, Integer> view_all_tournament_cost;

    @FXML
    public TableColumn<MyTournament, LocalDate> view_all_tournament_date;

    @FXML
    public TableColumn<MyTournament, Integer> view_all_tournament_id;

    @FXML
    public TableColumn<MyTournament, String> view_all_tournament_location;

    @FXML
    public TableColumn<MyTournament, String> view_all_tournament_name;

    @FXML
    public TableColumn<MyTournament, String> view_all_action;

    @FXML
    private TextArea driver_name1;

    @FXML
    private AnchorPane driver_page;

    @FXML
    private TextArea driver_name;

    @FXML
    public TableColumn view_my_tournament_button;

    @FXML
    public TableView<MyTournament> table_my_tournament;

    @FXML
    public TableColumn<MyTournament, Integer> view_my_tournament_id;

    @FXML
    public TableColumn<MyTournament, String> view_my_tournament_name;

    @FXML
    public TableColumn<MyTournament, String> view_my_tournament_location;

    @FXML
    public TableColumn<MyTournament, LocalDate> view_my_tournament_date;

    @FXML
    private AnchorPane view_my_tournament;

    @FXML
    private TextArea admin_name_tournament;

    @FXML
    private AnchorPane admin_form;

    @FXML
    private AnchorPane admin_create_tournament;

    @FXML
    private TextArea admin_name;

    @FXML
    private AnchorPane admin_page;

    @FXML
    private AnchorPane login_form;

    @FXML
    private TextArea admin_name1;

    @FXML
    private TextField login_username;

    @FXML
    private PasswordField login_password;

    @FXML
    private Button login_btn;

    @FXML
    private ComboBox<String> login_role;

    @FXML
    private TextField admin_username;

    @FXML
    private PasswordField admin_password;

    @FXML
    private Button admin_signupBtn;

    @FXML
    private Hyperlink admin_signin;

    @FXML
    private PasswordField admin_confirm_password;

    @FXML
    private AnchorPane driver_form;

    @FXML
    private TextField driver_username;

    @FXML
    private PasswordField driver_password;

    @FXML
    private Button driver_signupBtn;

    @FXML
    private Hyperlink driver_signin;

    @FXML
    private PasswordField driver_confirm_password;

    @FXML
    private AnchorPane refree_form;

    @FXML
    private TextField refree_username;

    @FXML
    private PasswordField refree_password;

    @FXML
    private Button refree_signupBtn;

    @FXML
    private Hyperlink refree_signin;

    @FXML
    private PasswordField refree_confirm_password;

    @FXML
    private TextField tournament_name;

    @FXML
    private TextField tournament_location;

    @FXML
    private DatePicker tournament_date;

    @FXML
    private Spinner<Integer> tournament_cost;

    @FXML
    private Spinner<Integer> tournament_number;

    private UserBean userGlobal;
    //endregion

    //region methods

    //region login signing

    @FXML
    public void logout(){
        login_form.setVisible(true);
        admin_page.setVisible(false);
        driver_page.setVisible(false);
        referee_page.setVisible(false);
    }

    @FXML
    public void login() {
        try {
            UserBean userBean = new UserBean();
            userBean.setUsername(login_username.getText());
            userBean.setPassword(login_password.getText());
            userBean.checkField(userBean.getUsername(), userBean.getPassword());
            UserControllerApp.login(userBean);
            userGlobal = userBean;

            if(userBean.getRole().equals("Admin")) {
                admin_page.setVisible(true);
                login_form.setVisible(false);
                admin_name.setText(userBean.getUsername());
            }

            if(userBean.getRole().equals("Driver")) {
                driver_page.setVisible(true);
                login_form.setVisible(false);
                driver_name.setText(userBean.getUsername());
            }

            if(userBean.getRole().equals("Referee")) {
                login_form.setVisible(false);
                goToRefereePage();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void switchForm() {
        switch (login_role.getSelectionModel().getSelectedItem()) {
            case "Admin" -> {
                admin_form.setVisible(true);
                refree_form.setVisible(false);
                driver_form.setVisible(false);
                login_form.setVisible(false);
            }
            case "Driver" -> {
                admin_form.setVisible(false);
                refree_form.setVisible(false);
                driver_form.setVisible(true);
                login_form.setVisible(false);
            }
            case "Referee" -> {
                refree_form.setVisible(true);
                driver_form.setVisible(false);
                refree_form.setVisible(true);
                login_form.setVisible(false);
            }
        }
    }

    @FXML
    public void signinForm() {
        login_form.setVisible(true);
        admin_form.setVisible(false);
        refree_form.setVisible(false);
        driver_form.setVisible(false);
    }

    @FXML
    public void signup() {
        try {
            UserBean userBean = new UserBean();
            if (admin_form.isVisible()) {
                setVisibleOfSigning(userBean, admin_username, admin_password, admin_confirm_password);
            }
            else if (refree_form.isVisible()) {
                setVisibleOfSigning(userBean, refree_username, refree_password, refree_confirm_password);
            }
            else if (driver_form.isVisible()) {
                setVisibleOfSigning(userBean, driver_username, driver_password, driver_confirm_password);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //endregion

    //region Admin

    @FXML
    public void createTournamentForm() {
        admin_page.setVisible(false);
        admin_create_tournament.setVisible(true);
        admin_name1.setText(userGlobal.getUsername());

    }

    @FXML
    public void viewMyTournamentForm(ActionEvent actionEvent) throws Exception {
        String location = "location";
        admin_page.setVisible(false);
        admin_create_tournament.setVisible(false);
        view_my_tournament.setVisible(true);
        admin_name_tournament.setText(userGlobal.getUsername());
        view_my_tournament_id.setCellValueFactory(new PropertyValueFactory<MyTournament, Integer>("id"));
        view_my_tournament_name.setCellValueFactory(new  PropertyValueFactory<MyTournament, String>("name"));
        view_my_tournament_location.setCellValueFactory(new  PropertyValueFactory<MyTournament, String>(location));
        view_my_tournament_date.setCellValueFactory(new  PropertyValueFactory<MyTournament, LocalDate>("date"));
        var listMtTournament = TournamentControllerApp.getAllByAdminIdTournaments(userGlobal.getId());
        ObservableList<MyTournament> list = FXCollections.observableArrayList(listMtTournament);
        table_my_tournament.setItems(list);

        Callback<TableColumn<MyTournament, String >, TableCell<MyTournament, String>> cellFactory =(param) ->{
            final TableCell<MyTournament, String> cell = new TableCell<MyTournament, String>(){
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
            return cell;
        };

        view_my_tournament_button.setCellFactory(cellFactory);
    }

    @FXML
    public void backToHomeFromCreate() {
        admin_create_tournament.setVisible(false);
        admin_page.setVisible(true);
    }

    @FXML
    public void backToHomeFromMytournament(){
        view_my_tournament.setVisible(false);
        admin_page.setVisible(true);
    }
    @FXML
    public void createTournament() throws Exception {

        TournamentBean tournamentBean = new TournamentBean();
        tournamentBean.setName(tournament_name.getText());
        tournamentBean.setLocation(tournament_location.getText());
        tournamentBean.setCost(tournament_cost.getValue());
        tournamentBean.setNumber(tournament_number.getValue());
        tournamentBean.setDate(tournament_date.getValue());
        tournamentBean.checkField(tournamentBean.getName(), tournamentBean.getLocation(), tournamentBean.getDate(), tournamentBean.getCost(), tournamentBean.getNumber());

        TournamentControllerApp.createTournament(userGlobal, tournamentBean);

        System.out.print("You have successfully created tournament " + tournament_name.getText());
    }

    //endregion

    //region Driver

    @FXML
    public void joinTournament() throws Exception {
        String location = "location";
        driver_page.setVisible(false);
        view_all_tournament.setVisible(true);
        driver_name1.setText(userGlobal.getUsername());
        view_all_tournament_id.setCellValueFactory(new PropertyValueFactory<MyTournament, Integer>("id"));
        view_all_tournament_name.setCellValueFactory(new PropertyValueFactory<MyTournament, String>("name"));
        view_all_tournament_location.setCellValueFactory(new  PropertyValueFactory<MyTournament, String>(location));
        view_all_tournament_date.setCellValueFactory(new PropertyValueFactory<MyTournament, LocalDate>("date"));
        view_all_tournament_cost.setCellValueFactory(new PropertyValueFactory<MyTournament, Integer>("cost"));
        var listMtTournament = TournamentControllerApp.GetAllTournaments();
        ObservableList<MyTournament> list = FXCollections.observableArrayList(listMtTournament);
        table_all_tournament.setItems(list);

        Callback<TableColumn<MyTournament, String >, TableCell<MyTournament, String>> cellFactory =(param) ->{
            final TableCell<MyTournament, String> cell = new TableCell<MyTournament, String>(){
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
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        });
                        setGraphic(payAndSubButton);
                    }
                }

            };
            return cell;
        };

        view_all_action.setCellFactory(cellFactory);

    }

    @FXML
    public void viewLeaderBoard(ActionEvent actionEvent) throws SQLException {
        driver_page.setVisible(false);
        driver_name_lead.setText(userGlobal.getUsername());
        driver_leadboard.setVisible(true);
        driver_name_leadbooard.setCellValueFactory(new PropertyValueFactory<LeadBoardBean, String>("driver"));
        driver_number_race_leadbooard.setCellValueFactory(new PropertyValueFactory<LeadBoardBean, Integer>("numberRace"));
        driver_point_leadbooard.setCellValueFactory(new  PropertyValueFactory<LeadBoardBean, Integer>("totalPoint"));
        var leadBoard = LeadBoardControllerApp.getLeadBoard();
        ObservableList<LeadBoardBean> list = FXCollections.observableArrayList(leadBoard);
        driver_table_leadbooard.setItems(list);
    }

    @FXML
    public void viewMySubscription() throws SQLException {
        String location = "location";
        driver_page.setVisible(false);
        driver_my_subscription.setVisible(true);
        driver_my_subscription_name.setText(userGlobal.getUsername());
        driver_my_subscription_id.setCellValueFactory(new PropertyValueFactory<MyTournament, Integer>("id"));
        driver_my_subscription_tournament_name.setCellValueFactory(new PropertyValueFactory<MyTournament, String>("name"));
        driver_my_subscription_location.setCellValueFactory(new  PropertyValueFactory<MyTournament, String>(location));
        driver_my_subscription_date.setCellValueFactory(new PropertyValueFactory<MyTournament, LocalDate>("date"));
        driver_my_subscription_cost.setCellValueFactory(new PropertyValueFactory<MyTournament, Integer>("cost"));
        var listMtTournament = SubscriptionControllerApp.getAllSubscriptionsByUser(userGlobal.getId());
        ObservableList<MyTournament> list = FXCollections.observableArrayList(listMtTournament);
        driver_my_subscription_table.setItems(list);

    }

    @FXML
    public void backToHomeFromLeadBoard(){
        driver_leadboard.setVisible(false);
        driver_page.setVisible(true);
    }

    @FXML
    public void backToHomeFromAllTournament() {
        view_all_tournament.setVisible(false);
        driver_page.setVisible(true);
    }

    @FXML
    public void backToHomeFromSubscriptionTable(){
        driver_my_subscription.setVisible(false);
        driver_page.setVisible(true);
    }

    //endregion

    //region Referee

    private void goToRefereePage() throws Exception {
        String location = "location";
        referee_page.setVisible(true);
        referee_name.setText(userGlobal.getUsername());
        referee_tournament_id.setCellValueFactory(new PropertyValueFactory<MyTournament, Integer>("id"));
        referee_tournament_name.setCellValueFactory(new  PropertyValueFactory<MyTournament, String>("name"));
        referee_location.setCellValueFactory(new  PropertyValueFactory<MyTournament, String>(location));
        referee_date.setCellValueFactory(new  PropertyValueFactory<MyTournament, LocalDate>("date"));
        referee_cost.setCellValueFactory(new  PropertyValueFactory<MyTournament, Integer>("cost"));
        var listMtTournament = TournamentControllerApp.GetAllTournaments();
        ObservableList<MyTournament> list = FXCollections.observableArrayList(listMtTournament);
        referee_table.setItems(list);

        Callback<TableColumn<MyTournament, String >, TableCell<MyTournament, String>> cellFactory =(param) ->{
            final TableCell<MyTournament, String> cell = new TableCell<MyTournament, String>(){
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
            return cell;
        };

        referee_detail.setCellFactory(cellFactory);
    }

    private void detail(int id) throws SQLException {
        referee_page.setVisible(false);
        referee_detail_view.setVisible(true);
        referee_detail_name.setText(userGlobal.getUsername());
        referee_detail_driver_id.setCellValueFactory(new PropertyValueFactory<SubscriptionBean, Integer>("idDriver"));
        referee_detail_driver.setCellValueFactory(new  PropertyValueFactory<SubscriptionBean, String>("driver"));
        referee_detail_tournament.setCellValueFactory(new  PropertyValueFactory<SubscriptionBean, String>("tournament"));
        referee_detail_tournamentId.setCellValueFactory(new  PropertyValueFactory<SubscriptionBean, Integer>("idTournament"));
        referee_detail_point.setCellValueFactory(new  PropertyValueFactory<SubscriptionBean, Integer>("point"));
        var listMtTournament = SubscriptionControllerApp.GetTournamentSubscription(id);
        ObservableList<SubscriptionBean> list = FXCollections.observableArrayList(listMtTournament);
        table.setItems(list);

        Callback<TableColumn<SubscriptionBean, String >, TableCell<SubscriptionBean, String>> cellFactory =(param) ->{
            final TableCell<SubscriptionBean, String> cell = new TableCell<SubscriptionBean, String>(){
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
            return cell;
        };

        referee_detail_confirm.setCellFactory(cellFactory);
    }
    @FXML
    public void backToHomeFromRefereeDetail(){
        referee_detail_view.setVisible(false);
        referee_page.setVisible(true);
    }

    @FXML
    public void confirm() throws SQLException {
        var driver = driver_name_confirm.getText();
        var driverId = driver_id_confirm.getValue();
        var tournament = driver_tournament_confirm.getText();
        var tournamentId = driver_tournament_id_confirm.getValue();
        var point = driver_point_confirm.getValue();

        new SubscriptionBean(driverId, tournamentId, point, driver, tournament);
        SubscriptionControllerApp.updateSubscription(point, driverId, tournamentId);

        driver_name_confirm.setText("");
        driver_id_confirm.getValueFactory().setValue(0);
        driver_tournament_id_confirm.getValueFactory().setValue(0);
        driver_point_confirm.getValueFactory().setValue(0);
        driver_tournament_confirm.setText("");

        detail(tournamentId);
    }
    //endregion

    //endregion

    //region private methods

    private void confirmVote(SubscriptionBean subscription) throws SQLException {
        driver_name_confirm.setText(subscription.getDriver());
        driver_tournament_confirm.setText(subscription.getTournament());
        driver_id_confirm.getValueFactory().setValue(subscription.getIdDriver());
        driver_id_confirm.setEditable(false);
        driver_tournament_id_confirm.getValueFactory().setValue(subscription.getIdTournament());
        driver_id_confirm.setEditable(false);
        driver_point_confirm.getValueFactory().setValue(subscription.getPoint());
    }

    private void payAndSubscription(MyTournament myTournament) throws Exception {
        TournamentBean tournamentBean = new TournamentBean(myTournament.getId(), myTournament.getName());
        SubscriptionControllerApp.payAndSubscription(userGlobal, tournamentBean);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Pay and Subscription done");
        alert.show();
    }

    private void download(MyTournament tournament) throws SQLException {
        var driverList = SubscriptionControllerApp.GetTournamentSubscription(tournament.getId());
        FileGeneretor.generateFile(tournament.getName(), driverList.toString());
        System.out.println("File created successfully!");
    }

    private void setRoleList() {
        List<String> ListRole = new ArrayList<>(Arrays.asList(DataList.role));

        ObservableList<String> listData = FXCollections.observableArrayList(ListRole);
        login_role.setItems(listData);
    }

    private void setVisibleOfSigning(UserBean userBean, TextField adminUsername, PasswordField adminPassword, PasswordField adminConfirmPassword) throws Exception {
        userBean.setUsername(adminUsername.getText());
        userBean.setPassword(adminPassword.getText());
        userBean.SetCheckPassword(adminConfirmPassword.getText());
        userBean.setRole(login_role.getValue());
        userBean.checkIfPassIsEqual(userBean.getPassword(), userBean.getCheckPassword());
        Boolean check = UserControllerApp.signing(userBean);
        if(check) {
            admin_form.setVisible(false);
            login_form.setVisible(true);
        }
    }

    //endregion
    
    //region override

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setRoleList();
        SpinnerValueFactory<Integer> spinner = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,1000,1);
        tournament_cost.setValueFactory(spinner);

        SpinnerValueFactory<Integer> spinner2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100,1);
        tournament_number.setValueFactory(spinner2);

        SpinnerValueFactory<Integer> spinner3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10000, 0);
        driver_point_confirm.setValueFactory(spinner3);

        SpinnerValueFactory<Integer> spinner4 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,1000000000, 0);
        driver_tournament_id_confirm.setValueFactory(spinner4);

        SpinnerValueFactory<Integer> spinner5 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,1000000000, 0);
        driver_id_confirm.setValueFactory(spinner5);


    }

    //endregion
}