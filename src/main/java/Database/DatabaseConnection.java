package Database;
import Model.MyException;

import java.sql.*;
/*import java.sql.DriverManager;
import java.sql.SQLException;*/

public class DatabaseConnection {

    public static String status = "Não conectou...";

    public DatabaseConnection() {

    }

    public static java.sql.Connection getConexao() throws Exception {
        Connection connection = null;

        System.out.println("Chegou aqui 1");

        String driverName   = "com.mysql.jdbc.Driver";
        String serverName   = "localhost";
        String mydatabase   = "Agenda";
        String url          = "jdbc:mysql://localhost:3306/Agenda";
        String username     = "root";
        String password     = "admin";

        System.out.println("Chegou aqui 2");

        try {
            System.out.println("Chegou aqui 3");

            Class.forName(driverName);

            System.out.println("Chegou aqui 4");

            connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                status = ("Status da conexão: Conexão efetuada com sucesso!");
            } else {
                status = ("Status da conexão: Não foi possível realizar a conexão com o banco!");
            }
            return connection;
        } catch (ClassNotFoundException e) {  //Driver não encontrado
            //throw new MyException("O driver expecificado não foi encontrado.");
            System.out.println("ERRO => " + e.getMessage());
            throw new Exception("ERRO => " + e.getMessage());
        }catch (SQLException e) {
            throw new Exception("");
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
