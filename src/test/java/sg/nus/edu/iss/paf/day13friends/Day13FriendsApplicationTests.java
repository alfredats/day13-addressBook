package sg.nus.edu.iss.paf.day13friends;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sg.nus.edu.iss.paf.day13friends.service.AddressBookService;

@SpringBootTest
class Day13FriendsApplicationTests {

	@Autowired
	private AddressBookService aSvc;

	@Test
	void contextLoads() {
	}

	@BeforeAll
	void createTestData() {

	}
		
	@AfterAll
	void deleteTestData() {

	}

	@Test
	void addFriend_shouldNotUpdate() {
		
	}

}
