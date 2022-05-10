package Database;
import DependencyInversion.BasariliBaglanti;
import DependencyInversion.BasarisizBaglanti;
import DependencyInversion.IBaglantiMesaji;
import DependencyInversion.MesajGoster;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class UserManager extends User implements IUserDatabase {
    private final String url = "jdbc:postgresql://localhost:5432/akillicihaz";
    private final String user = "postgres";
    private final String password = "Alidem8118";
    IBaglantiMesaji basariliMesaji = new BasariliBaglanti();
    IBaglantiMesaji basarisizMesaji = new BasarisizBaglanti();
    MesajGoster basariliMesajGoster = new MesajGoster(basariliMesaji);
    MesajGoster basarisizMesajGoster = new MesajGoster(basarisizMesaji);

    public Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            basariliMesajGoster.mesajGoster();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
    public UserManager() {
    }
    @Override
    public boolean kullaniciDogrula(String username, String password) {
        try {
            Connection conn = this.connect();
            if (conn != null) {
                String getUsers = "Select * From public.\"User\"";
                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(getUsers);
                conn.close();
                boolean dogrula = false;
                while (result.next()) {
                    if (result.getString("username").equals(username) && result.getString("password").equals(password)){
                        dogrula = true;
                    }
                }
                if (dogrula) {
                    System.out.println("Arayüze Hoşgeldiniz");
                    return true;
                }else {
                    System.out.println("Arayüze giriş yapamadınız...!\n");
                    return false;
                }
            }
            else {
                basarisizMesajGoster.mesajGoster();
                return false;
            }
        }
        catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}