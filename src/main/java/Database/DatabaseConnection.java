package Database;

import java.sql.*;

public class DatabaseConnection {

    public static String status = "Não conectou...";

    public DatabaseConnection() {

    }

    public static java.sql.Connection getConexao() throws Exception {
        Connection connection = null;

        String driverName   = "com.mysql.jdbc.Driver";
        String serverName   = "localhost";
        String mydatabase   = "Agenda";
        String url          = "jdbc:mysql://" + serverName + "/" + mydatabase;
        String username     = "root";
        String password     = "admin";

        try {
            Class.forName(driverName).newInstance();

            connection = DriverManager.getConnection(url, username, password);

            if (connection != null) {
                status = ("Status da conexão: Conexão efetuada com sucesso!");
            } else {
                status = ("Status da conexão: Não foi possível realizar a conexão com o banco!");
            }
            return connection;
        } catch (ClassNotFoundException e) {
            throw new Exception("ERRO => " + e.getMessage());
        }catch (SQLException e) {
            throw new Exception("Deu ruim no banco");
        }
    }

    public static String statusConection() {
        return status;
    }

    public static boolean closeConection() {
        try {
            DatabaseConnection.getConexao().close();
            return true;
        } catch (SQLException e) {
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static java.sql.Connection openConection() {
        closeConection();
        try {
            return DatabaseConnection.getConexao();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
