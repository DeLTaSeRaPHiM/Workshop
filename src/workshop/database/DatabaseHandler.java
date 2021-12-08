package workshop.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;
import static workshop.database.Constants.*;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection()
            throws SQLException, ClassNotFoundException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName +
                "?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false";

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    public ObservableList<Workers> getWorkers() {
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement("SELECT * FROM " + WORKERS_TABLE + ";");

            ResultSet result = prSt.executeQuery();
            ObservableList<Workers> list = FXCollections.observableArrayList();
            while (result.next()) { //Получение данных из столбцов базы данных
                Workers workers = new Workers();

                workers.setWorker_ID(result.getString(WORKER_ID));
                workers.setSurname(result.getString(WORKER_SURNAME));
                workers.setName(result.getString(WORKER_NAME));
                workers.setPatronymic(result.getString(WORKER_PATRONYMIC));
                workers.setWorkshopName(result.getString(WORKSHOP_NAME));
                list.add(workers);
            }
            return list;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ObservableList<Products> getProducts() {
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement("SELECT * FROM " + PRODUCTS_TABLE + ";");

            ResultSet result = prSt.executeQuery();
            ObservableList<Products> list = FXCollections.observableArrayList();
            while (result.next()) {
                Products products = new Products("", "", "", "", "", "", "", "", "", "");

                products.setProduct_ID(result.getString(PRODUCT_ID));
                products.setName(result.getString(PRODUCT_NAME));
                products.setPrice(result.getString(PRODUCT_PRICE));
                products.setAmountOnMonday(result.getString(P_AMOUNT_ON_MON));
                products.setAmountOnTuesday(result.getString(P_AMOUNT_ON_TUE));
                products.setAmountOnWednesday(result.getString(P_AMOUNT_ON_WED));
                products.setAmountOnThursday(result.getString(P_AMOUNT_ON_THU));
                products.setAmountOnFriday(result.getString(P_AMOUNT_ON_FRI));
                products.setAmountOnSaturday(result.getString(P_AMOUNT_ON_SAT));
                products.setAmountOnSunday(result.getString(P_AMOUNT_ON_SUN));

                list.add(products);
            }
            return list;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addWorker(String surname, String name, String patronymic, String workshopName) {
        String insert = "INSERT INTO " + WORKERS_TABLE + "(" +
                WORKER_SURNAME + ", " + WORKER_NAME + "," + WORKER_PATRONYMIC + "," +
                WORKSHOP_NAME + ") VALUES(?, ?, ?, ?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, surname);
            prSt.setString(2, name);
            prSt.setString(3, patronymic);
            prSt.setString(4, workshopName);
            System.out.println(prSt);
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addProduct(String productName, String productPrice, String amountOnMon,
                           String amountOnTue, String amountOnWed, String amountOnThu,
                           String amountOnFri, String amountOnSat, String amountOnSun) {
        String insert = "INSERT INTO " + PRODUCTS_TABLE + "(" +
                PRODUCT_NAME + ", " + PRODUCT_PRICE + "," + P_AMOUNT_ON_MON + "," +
                P_AMOUNT_ON_TUE + "," + P_AMOUNT_ON_WED + "," + P_AMOUNT_ON_THU + "," +
                P_AMOUNT_ON_FRI + "," + P_AMOUNT_ON_SAT + "," + P_AMOUNT_ON_SUN +
                ") VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, productName);
            prSt.setString(2, productPrice);
            prSt.setString(3, amountOnMon);
            prSt.setString(4, amountOnTue);
            prSt.setString(5, amountOnWed);
            prSt.setString(6, amountOnThu);
            prSt.setString(7, amountOnFri);
            prSt.setString(8, amountOnSat);
            prSt.setString(9, amountOnSun);

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateWorker(String id, String surname, String name, String patronymic, String workshopName) {
        String update = "UPDATE " + WORKERS_TABLE + " SET " + WORKER_SURNAME +" = ?," +
                WORKER_NAME +"= ?," + WORKER_PATRONYMIC + "= ?," +
                WORKSHOP_NAME + "= ? WHERE " + WORKER_ID + "= ?";
        int ID = Integer.parseInt(id);

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(update);
            prSt.setString(1, surname);
            prSt.setString(2, name);
            prSt.setString(3, patronymic);
            prSt.setString(4, workshopName);
            prSt.setInt(5, ID);

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateProduct(String id, String name, String price, String onMon, String onTue, String onWed,
                              String onThu, String onFri, String onSat, String onSun) {
        String update = "UPDATE " + PRODUCTS_TABLE + " SET " + PRODUCT_NAME +" = ?," +
                PRODUCT_PRICE +"= ?," + P_AMOUNT_ON_MON + "= ?," + P_AMOUNT_ON_TUE + "= ?," +
                P_AMOUNT_ON_WED + "= ?," + P_AMOUNT_ON_THU + "= ?," +
                P_AMOUNT_ON_FRI + "= ?," + P_AMOUNT_ON_SAT + "= ?," +
                P_AMOUNT_ON_SUN + "= ? WHERE " + PRODUCT_ID + "= ?";
        int ID = Integer.parseInt(id);

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(update);
            prSt.setString(1, name);
            prSt.setString(2, price);
            prSt.setString(3, onMon);
            prSt.setString(4, onTue);
            prSt.setString(5, onWed);
            prSt.setString(6, onThu);
            prSt.setString(7, onFri);
            prSt.setString(8, onSat);
            prSt.setString(9, onSun);
            prSt.setInt(10, ID);

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deleteWorker(String id) {
        String delete = "DELETE FROM " + WORKERS_TABLE + " WHERE " + WORKER_ID + "=?;";
        int ID = Integer.parseInt(id);

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(delete);
            prSt.setInt(1, ID);

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(String id) {
        String delete = "DELETE FROM " + PRODUCTS_TABLE + " WHERE " + PRODUCT_ID + "=?;";
        int ID = Integer.parseInt(id);

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(delete);
            prSt.setInt(1, ID);

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
