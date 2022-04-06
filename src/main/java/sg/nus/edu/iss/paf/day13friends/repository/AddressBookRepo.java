package sg.nus.edu.iss.paf.day13friends.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import static sg.nus.edu.iss.paf.day13friends.repository.Queries.SQL_INSERT_FRIEND;
import static sg.nus.edu.iss.paf.day13friends.repository.Queries.SQL_GET_FRIEND_BY_EMAIL;

import java.util.Optional;

import sg.nus.edu.iss.paf.day13friends.model.Friend;

@Repository
public class AddressBookRepo {

    @Autowired
    private JdbcTemplate jt;

    public boolean insertFriend(Friend f) throws DataAccessException {
        int rows = jt.update(
            SQL_INSERT_FRIEND,
            f.getEmail(),
            f.getName(),
            f.getPhone(),
            f.getStatus(),
            f.getDob(),
            f.getPassphrase()
        );
        return rows == 1;
    }

    public Optional<Friend> getFriendByID(String email) {
        final SqlRowSet rs = jt.queryForRowSet(SQL_GET_FRIEND_BY_EMAIL, email);
        if (rs.next()) {
            return Optional.of(Friend.create(rs));
        }

        return Optional.empty();
    }
    
}
