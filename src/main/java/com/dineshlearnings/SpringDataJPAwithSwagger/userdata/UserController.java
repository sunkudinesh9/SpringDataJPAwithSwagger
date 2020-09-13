package com.dineshlearnings.SpringDataJPAwithSwagger.userdata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user_data/")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/*")
	public List<UsersTable> getUsers() {
		return userService.getUsers();
	}

	@PostMapping(value = "/*")
	public UsersTable addUser(@RequestBody UsersTable user) {
		return userService.addUser(user);
	}

	@PutMapping("/update/{firstname}/{address}")
	public void updateAddressByFirstName(@RequestParam("firstname") String firstName,
			@RequestParam("address") String address) {
		userService.updateAddressByFirstName(firstName, address);
	}

	@GetMapping("/{emailid}")
	public UsersTable getUserByEmailID(@RequestParam("emailid") String emailID) {
		return userService.getUserByEmail(emailID);
	}

	@GetMapping("/sort/{sortingdata}")
	public List<UsersTable> getAllUsersInSortingOrder(@RequestParam("sortingdata") String sortingData) {
		return userService.getUsersInSortingOrder(sortingData);
	}

	@GetMapping("/pages/{noofpages}/{noofelements}")
	public Page<UsersTable> getAllUsersInPages(@RequestParam("noofpages") int noOfPages,
			@RequestParam("noofelements") int noOfElements) {
		return userService.getUsersInPages(noOfPages, noOfElements);
	}
	
	@GetMapping("/{phonenumber}")
	public UsersTable getUserByPhonenumber(@RequestParam("phonenumber") Long phoneNumber) {
		return userService.getUserByPhonenumber(phoneNumber);
	}
}
