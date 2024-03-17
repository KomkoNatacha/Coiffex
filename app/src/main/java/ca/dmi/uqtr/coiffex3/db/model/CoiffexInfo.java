package ca.dmi.uqtr.coiffex3.db.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//classe qui représentera notre table dans la base de données
@Entity(tableName = "coiffexinfos")
public class CoiffexInfo {


    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "lastname")
    private String lastname;


    @ColumnInfo(name = "email")
    private String email;

   @ColumnInfo(name = "number")
    private String number;

   @ColumnInfo(name = "password")
    private String password;

    @ColumnInfo(name = "cnfrmpassword")
    private String cnfrmpassword;
    @ColumnInfo(name = "role")
    private String role;

    public CoiffexInfo(){}


    public CoiffexInfo( String name,String lastname, String email, String number, String password, String cnfrmpassword , String role) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.number = number;
        this.password = password;
        this.cnfrmpassword = cnfrmpassword;
        this.role = role;
    }


    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCnfrmpassword() {
        return cnfrmpassword;
    }

    public void setCnfrmpassword(String cnfrmpassword) {
        this.cnfrmpassword = cnfrmpassword;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}

