
package entitys;

public class User {
    public int user_id;
    public String email;
    public String name;
    public String father_last_name;
    public String mother_last_name;
    public int rol_id;
    public String rol_name;

    public User() {
    }

    public User(int user_id, String email, String name, String father_last_name, String mother_last_name, int rol_id, String rol_name) {
        this.user_id = user_id;
        this.email = email;
        this.name = name;
        this.father_last_name = father_last_name;
        this.mother_last_name = mother_last_name;
        this.rol_id = rol_id;
        this.rol_name = rol_name;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getFather_last_name() {
        return father_last_name;
    }

    public String getMother_last_name() {
        return mother_last_name;
    }

    public int getRol_id() {
        return rol_id;
    }

    public String getRol_name() {
        return rol_name;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFather_last_name(String father_last_name) {
        this.father_last_name = father_last_name;
    }

    public void setMother_last_name(String mother_last_name) {
        this.mother_last_name = mother_last_name;
    }

    public void setRol_id(int rol_id) {
        this.rol_id = rol_id;
    }

    public void setRol_name(String rol_name) {
        this.rol_name = rol_name;
    }
}
