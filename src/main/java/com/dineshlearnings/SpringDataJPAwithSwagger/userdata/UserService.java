package com.dineshlearnings.SpringDataJPAwithSwagger.userdata;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public UsersTable addUser(UsersTable user) {
		return userRepository.save(user);
	}

	public List<UsersTable> getUsers() {
		List<UsersTable> usersList = new ArrayList<UsersTable>();
		userRepository.findAll().forEach(usersList::add);
		return usersList;
	}

	public void updateAddressByFirstName(String firstName, String address) {
		userRepository.updateAddressByFirstName(firstName, address);
	}
	
	public UsersTable getUserByEmail(String emailID) {
		return userRepository.findByEmailID(emailID);
	}
	
	public List<UsersTable> getUsersInSortingOrder(String sortingData){
		return (List<UsersTable>) userRepository.findAll(Sort.by(sortingData));
	}
	
	public Page<UsersTable> getUsersInPages(int noOfPages, int noOfElements){
		return userRepository.findAll(PageRequest.of(noOfPages, noOfElements));
	}
	
	public UsersTable getUserByPhonenumber(Long phonenumber) {
		return userRepository.findByPhoneNumber(phonenumber);
	}
}
