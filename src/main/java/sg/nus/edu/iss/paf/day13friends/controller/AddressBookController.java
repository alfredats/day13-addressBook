package sg.nus.edu.iss.paf.day13friends.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sg.nus.edu.iss.paf.day13friends.model.Friend;
import sg.nus.edu.iss.paf.day13friends.service.AddressBookService;

@Controller
@RequestMapping(path = "/")
public class AddressBookController {
    private static Logger logger = LoggerFactory.getLogger(AddressBookController.class);
    
    @Autowired
    private AddressBookService aSvc;
    
    @GetMapping(path = {"/", "index.html"})
    ModelAndView indexResource() {
        ModelAndView mav = new ModelAndView("index.html");
        mav.addObject("newFriend", new Friend());
        mav.addObject("allFriends", null);
        return mav;
    }
    
    @PostMapping(path="/addFriend")
    ModelAndView friendResource(
        @ModelAttribute Friend f
    ) {
        // Friend f = new Friend(email, name, phone, status, dob, passphrase);
        logger.info(f.toString());

        if (aSvc.addFriend(f)) {
            return indexResource();
        }

        return new ModelAndView("error.html");

    }

    // ModelAndView indexResource( ) {
    //     final ModelAndView mav = new ModelAndView("index.html");
    //     mav.addObject("newFriend", new Friend());
    //     return mav;
    // }

}
