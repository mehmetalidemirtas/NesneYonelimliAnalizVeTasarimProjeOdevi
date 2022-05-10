package Database;

public class User {
    private String _username;
    private String _password;

    public String getKullaniciAdi() {
        return _username;
    }
    public void SetKullaniciAdi(String username) {
        _username = username;
    }
    public String getParola() {
        return _password;
    }
    public void SetParola(String password) {
        _password = password;
    }
    public User() {
        _username = ""; _password = "";
    }
}