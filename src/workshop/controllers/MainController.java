package workshop.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.scene.control.cell.PropertyValueFactory;
import workshop.database.*;

@SuppressWarnings("All")

public class MainController {

    @FXML
    private TableView<Workers> workersTable;

    @FXML
    private TableView<Products> productsTable;

    @FXML
    private TableView<Users> usersTable;

    @FXML
    private TableColumn<Products, String> weekTab;

    @FXML
    private TableColumn<Products, String> pPriceTab;

    @FXML
    private TableColumn<Products, String> pProductTab;

    @FXML
    private TableColumn<Products, String> onMonTab;

    @FXML
    private TableColumn<Products, String> onTueTab;

    @FXML
    private TableColumn<Products, String> onWedTab;

    @FXML
    private TableColumn<Products, String> onThuTab;

    @FXML
    private TableColumn<Products, String> onFriTab;

    @FXML
    private TableColumn<Products, String> onSatTab;

    @FXML
    private TableColumn<Products, String> onSunTab;

    @FXML
    private TextField productNameField;

    @FXML
    private TextField productPriceField;

    @FXML
    private TextField onMonField;

    @FXML
    private TextField onTueField;

    @FXML
    private TextField onWedField;

    @FXML
    private TextField onThuField;

    @FXML
    private TextField onFriField;

    @FXML
    private TextField onSatField;

    @FXML
    private TextField onSunField;

    @FXML
    private TableColumn<Workers, String> wIDTab;

    @FXML
    private TableColumn<Workers, String> wSurnameTab;

    @FXML
    private TableColumn<Workers, String> wNameTab;

    @FXML
    private TableColumn<Workers, String> wPatronymicTab;

    @FXML
    private TableColumn<Workers, String> workshopName;

    @FXML
    private TextField wSurnameField;

    @FXML
    private TextField wNameField;

    @FXML
    private TextField wPatronymicField;

    @FXML
    private TextField workshopNameField;

    @FXML
    private TextField workerSearchField;

    @FXML
    private TextField productSearchField;

    @FXML
    private Button findID;

    @FXML
    private Button findName;

    @FXML
    private Button userAddBtn;

    @FXML
    private Button userUpdateBtn;

    @FXML
    private Button userDeleteBtn;

    @FXML
    private TextField userSearchField;

    @FXML
    private TextField userIdField;

    @FXML
    private TextField userLoginField;

    @FXML
    private TextField userPasswordField;

    @FXML
    private TextField userAccessKeyField;

    @FXML
    private TableColumn<Users, String> userIdTab;

    @FXML
    private TableColumn<Users, String> userLoginTab;

    @FXML
    private TableColumn<Users, String> userPasswordTab;

    @FXML
    private TableColumn<Users, String> userAccessKeyTab;


    private ObservableList<Workers> workersDB = FXCollections.observableArrayList();
    private ObservableList<Products> productsDB = FXCollections.observableArrayList();
    private ObservableList<Users> usersDB = FXCollections.observableArrayList();

    DatabaseHandler databaseHandler = new DatabaseHandler();

    @FXML
    void initialize() {
        updateWorkersTable();
        updateProductsTable();
        updateUsersTable();
    }


    @FXML
    void addWorker(ActionEvent event) {
        String surname = wSurnameField.getText();
        String name = wNameField.getText();
        String patronymic = wPatronymicField.getText();
        String WorkshopName = workshopNameField.getText();

        databaseHandler.addWorker(surname, name, patronymic, WorkshopName);

        updateWorkersTable();
    }

    @FXML
    void addProduct(ActionEvent event) {

        String productName = productNameField.getText();
        String productPrice = productPriceField.getText();
        String amountOnMon = onMonField.getText();
        String amountOnTue = onTueField.getText();
        String amountOnWed = onWedField.getText();
        String amountOnThu = onThuField.getText();
        String amountOnFri = onFriField.getText();
        String amountOnSat = onSatField.getText();
        String amountOnSun = onSunField.getText();

        databaseHandler.addProduct(productName, productPrice, amountOnMon,
                amountOnTue, amountOnWed, amountOnThu, amountOnFri,
                amountOnSat, amountOnSun);

        updateProductsTable();
    }

    @FXML
    void addUser(ActionEvent event) {
        String userID = userIdField.getText();
        String login = userLoginField.getText();
        String password = userPasswordField.getText();
        String accessKey = userAccessKeyField.getText();

        databaseHandler.addUser(userID, login, password, accessKey);

        updateUsersTable();
    }

    @FXML
    void updateWorker(ActionEvent event) {
        Workers worker = new Workers();
        worker = workersTable.getSelectionModel().getSelectedItem();
        try {
            if (worker != null) {
                String id = worker.getWorker_ID();

                String surname = (worker.getSurname() == null) ? (surname = worker.getSurname()) : (wSurnameField.getText());
                String name = (worker.getName() == null ) ? (name = worker.getName()) : (wNameField.getText());
                String patronymic = (worker.getPatronymic() == null) ? (patronymic = worker.getPatronymic()) : (wPatronymicField.getText());
                String WorkshopName = (worker.getWorkshopName() == null) ? (WorkshopName = worker.getWorkshopName()) : (workshopNameField.getText());

                databaseHandler.updateWorker(id, surname, name, patronymic, WorkshopName);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        updateWorkersTable();
    }

    @FXML
    void updateProduct(ActionEvent event) {
        Products product = new Products();
        product = productsTable.getSelectionModel().getSelectedItem();
        try {
            if (product != null) {
                String id = product.getProduct_ID();

                String name = (product.getName() == null) ? (name = product.getName()) : (productNameField.getText());
                String price = (product.getPrice() == null ) ? (price = product.getName()) : (productPriceField.getText());
                String onMon = (product.getAmountOnMonday() == null) ? (onMon = product.getAmountOnMonday()) : (onMonField.getText());
                String onTue = (product.getAmountOnTuesday() == null) ? (onTue = product.getAmountOnTuesday()) : (onTueField.getText());
                String onWed = (product.getAmountOnWednesday() == null) ? (onWed = product.getAmountOnWednesday()) : (onWedField.getText());
                String onThu = (product.getAmountOnThursday() == null ) ? (onThu = product.getAmountOnThursday()) : (onThuField.getText());
                String onFri = (product.getAmountOnFriday() == null) ? (onFri = product.getAmountOnFriday()) : (onFriField.getText());
                String onSat = (product.getAmountOnSaturday() == null) ? (onSat = product.getAmountOnSaturday()) : (onSatField.getText());
                String onSun = (product.getAmountOnSunday() == null) ? (onSun = product.getAmountOnSunday()) : (onSunField.getText());

                databaseHandler.updateProduct(id, name, price, onMon, onTue, onWed, onThu, onFri, onSat, onSun);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        updateProductsTable();
    }

    @FXML
    void updateUser(ActionEvent event) {
        Users user = new Users();
        user = usersTable.getSelectionModel().getSelectedItem();
        try {
            if (user != null) {
                String id = user.getUserID();

                String login = (user.getLogin() == null) ? (login = user.getLogin()) : (userLoginField.getText());
                String password = (user.getPassword() == null ) ? (password = user.getPassword()) : (userPasswordField.getText());
                String accessKey = (user.getAccessKey() == null) ? (accessKey = user.getAccessKey()) : (userAccessKeyField.getText());

                databaseHandler.updateUser(id, login, password, accessKey);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        updateUsersTable();
    }

    @FXML
    void deleteWorker(ActionEvent event) {
        Workers worker = new Workers();
        worker = workersTable.getSelectionModel().getSelectedItem();
        try {
            if (worker != null) {
                String id = worker.getWorker_ID();
                databaseHandler.deleteWorker(id);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        updateWorkersTable();
    }

    @FXML
    void deleteProduct(ActionEvent event) {
        Products product = new Products();
        product = productsTable.getSelectionModel().getSelectedItem();
        try {
            if (product != null) {
                String id = product.getProduct_ID();
                databaseHandler.deleteProduct(id);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        updateProductsTable();
    }

    @FXML
    void deleteUser(ActionEvent event) {
        Users users = new Users();
        users = usersTable.getSelectionModel().getSelectedItem();
        try {
            if (users != null) {
                String id = users.getUserID();
                databaseHandler.deleteUser(id);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        updateUsersTable();
    }

    @FXML
    void findID(ActionEvent event) {
        String search = workerSearchField.getText();

        if (search.equals("")) {
            updateWorkersTable();
        } else {
            wIDTab.setCellValueFactory(new PropertyValueFactory<>("worker_ID"));
            wSurnameTab.setCellValueFactory(new PropertyValueFactory<>("surname"));
            wNameTab.setCellValueFactory(new PropertyValueFactory<>("name"));
            wPatronymicTab.setCellValueFactory(new PropertyValueFactory<>("patronymic"));
            workshopName.setCellValueFactory(new PropertyValueFactory<>("workshopName"));

            workersDB = databaseHandler.findWorker(search);
            workersTable.setItems(workersDB);
        }

    }

    @FXML
    void findName(ActionEvent event) {
        String search = productSearchField.getText();

        if (search.equals("")) {
            updateProductsTable();
        } else {
            weekTab.setCellValueFactory(new PropertyValueFactory<>("product_ID"));
            pPriceTab.setCellValueFactory(new PropertyValueFactory<>("price"));
            pProductTab.setCellValueFactory(new PropertyValueFactory<>("name"));
            onMonTab.setCellValueFactory(new PropertyValueFactory<>("amountOnMonday"));
            onTueTab.setCellValueFactory(new PropertyValueFactory<>("amountOnTuesday"));
            onWedTab.setCellValueFactory(new PropertyValueFactory<>("amountOnWednesday"));
            onThuTab.setCellValueFactory(new PropertyValueFactory<>("amountOnThursday"));
            onFriTab.setCellValueFactory(new PropertyValueFactory<>("amountOnFriday"));
            onSatTab.setCellValueFactory(new PropertyValueFactory<>("amountOnSaturday"));
            onSunTab.setCellValueFactory(new PropertyValueFactory<>("amountOnSunday"));

            productsDB = databaseHandler.findProduct(search);
            productsTable.setItems(productsDB);
        }

    }

    @FXML
    void findUserID(ActionEvent event) {
        String search = userSearchField.getText();

        if (search.equals("")) {
            updateUsersTable();
        } else {
            userIdTab.setCellValueFactory(new PropertyValueFactory<>("userID"));
            userLoginTab.setCellValueFactory(new PropertyValueFactory<>("login"));
            userPasswordTab.setCellValueFactory(new PropertyValueFactory<>("password"));
            userAccessKeyTab.setCellValueFactory(new PropertyValueFactory<>("accessKey"));

            usersDB = databaseHandler.findUser(search);
            usersTable.setItems(usersDB);
        }

    }

    //Методы обновления таблиц

    public void updateWorkersTable() {
        wIDTab.setCellValueFactory(new PropertyValueFactory<>("worker_ID"));
        wSurnameTab.setCellValueFactory(new PropertyValueFactory<>("surname"));
        wNameTab.setCellValueFactory(new PropertyValueFactory<>("name"));
        wPatronymicTab.setCellValueFactory(new PropertyValueFactory<>("patronymic"));
        workshopName.setCellValueFactory(new PropertyValueFactory<>("workshopName"));

        workersDB = databaseHandler.getWorkers();
        workersTable.setItems(workersDB);
    }

    public void updateProductsTable() {
        weekTab.setCellValueFactory(new PropertyValueFactory<>("product_ID"));
        pPriceTab.setCellValueFactory(new PropertyValueFactory<>("price"));
        pProductTab.setCellValueFactory(new PropertyValueFactory<>("name"));
        onMonTab.setCellValueFactory(new PropertyValueFactory<>("amountOnMonday"));
        onTueTab.setCellValueFactory(new PropertyValueFactory<>("amountOnTuesday"));
        onWedTab.setCellValueFactory(new PropertyValueFactory<>("amountOnWednesday"));
        onThuTab.setCellValueFactory(new PropertyValueFactory<>("amountOnThursday"));
        onFriTab.setCellValueFactory(new PropertyValueFactory<>("amountOnFriday"));
        onSatTab.setCellValueFactory(new PropertyValueFactory<>("amountOnSaturday"));
        onSunTab.setCellValueFactory(new PropertyValueFactory<>("amountOnSunday"));

        productsDB = databaseHandler.getProducts();
        productsTable.setItems(productsDB);
    }

    public void updateUsersTable() {
        userIdTab.setCellValueFactory(new PropertyValueFactory<>("userID"));
        userLoginTab.setCellValueFactory(new PropertyValueFactory<>("login"));
        userPasswordTab.setCellValueFactory(new PropertyValueFactory<>("password"));
        userAccessKeyTab.setCellValueFactory(new PropertyValueFactory<>("accessKey"));

        usersDB = databaseHandler.getUsers();
        usersTable.setItems(usersDB);
    }

}
