package com.dineshlearnings.SpringDataJPAwithSwagger.userdata;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UsersTable, Integer> {

	@Transactional
	@Modifying
	@Query("update UsersTable u set u.address=?2 where u.firstName=?1")
	public void updateAddressByFirstName(String firstName, String address);

	@Query("select u from UsersTable u where u.emailID=:emailid")
	public UsersTable findByEmailID(@Param("emailid") String emailID);

	@Query(value = "select * from users where phone_number=?1", nativeQuery = true)
	public UsersTable findByPhoneNumber(Long phonenumber);

}
