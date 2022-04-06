package sg.nus.edu.iss.paf.day13friends.repository;

public interface Queries {
    final String SQL_INSERT_FRIEND ="""
    INSERT bff(
        email,
        name,
        phone,
        status,
        dob,
        passphrase
    ) values 
        (?, ?, ?, ?, ?, SHA1(?));
            """; 
    
    final String SQL_GET_FRIEND_BY_EMAIL = "SELECT * FROM bff where email = ?;";
}
