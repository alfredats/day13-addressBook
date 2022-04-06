package sg.nus.edu.iss.paf.day13friends.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Friend {
    private String email;
    private String name;
    private String phone;
    private String status;
    private String dob;
    private String passphrase;

    public Friend() {}
    public Friend(String email, String name, String phone, String status, String dob, String passphrase) {
        this.setEmail(email);
        this.setName(name);
        this.setPhone(phone);
        this.setStatus(status);
        this.setDob(dob);
        this.setPassphrase(passphrase);
    }

    public static Friend create(SqlRowSet row) {
        Friend f = new Friend();
        f.setEmail(row.getString("email"));
        f.setName(row.getString("name"));
        f.setPhone(row.getString("phone"));
        f.setStatus(row.getString("status"));
        f.setDob(row.getString("dob"));
        return f;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return String return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return String return the dob
     */
    public String getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     * @return String return the passphrase
     */
    public String getPassphrase() {
        return passphrase;
    }

    /**
     * @param passphrase the passphrase to set
     */
    public void setPassphrase(String passphrase) {
        this.passphrase = passphrase;
    }

    @Override
    public String toString() {
        return "Friend [dob=" + dob + ", email=" + email + ", name=" + name + ", passphrase=" + passphrase + ", phone="
                + phone + ", status=" + status + "]";
    }



}
