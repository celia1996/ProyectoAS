package Model;

public class DataAccess {

    String usuario;
    String password;
    public static DataAccess[] usuarios = {new DataAccess("Celia", "1234"),
        new DataAccess("Angelo", "1234"), new DataAccess("Cris", "1234")};

    public DataAccess(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static DataAccess[] getUsuarios() {
        return usuarios;
    }

    public static void setUsuarios(DataAccess[] usuarios) {
        DataAccess.usuarios = usuarios;
    }

    public static boolean Validation(String user, String password) {
        for (DataAccess aux : usuarios) {
            if (aux.getUsuario().equals(user)) {
                if (aux.getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }
}
