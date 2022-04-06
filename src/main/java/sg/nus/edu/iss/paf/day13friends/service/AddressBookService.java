package sg.nus.edu.iss.paf.day13friends.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.nus.edu.iss.paf.day13friends.exception.AddressBookException;
import sg.nus.edu.iss.paf.day13friends.model.Friend;
import sg.nus.edu.iss.paf.day13friends.repository.AddressBookRepo;

@Service
public class AddressBookService {

    @Autowired
    private AddressBookRepo aRepo;

    public boolean addFriend(Friend f) throws AddressBookException { 
        if (aRepo.getFriendByID(f.getEmail()).isPresent()) {
            throw new AddressBookException("Friend with email already exists: '" + f.getEmail() +"'");
        }
        return aRepo.insertFriend(f);
    }

    
}
