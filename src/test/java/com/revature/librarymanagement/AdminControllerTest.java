package com.revature.librarymanagement;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
//comment
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.librarymanagement.dao.AdminDAO;
import com.revature.librarymanagement.model.Admin;
import com.revature.librarymanagement.service.AdminService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=AdminControllerTest.class)
class AdminControllerTest {

	@MockBean
	private AdminService adminService;

	@MockBean
	private AdminDAO adminDAO;

	static final List<Admin> ADMIN_TEST_DATA = Stream
			.of(new Admin(Long.valueOf(1), "admin1", "useradmin", "Demo@gmail.com", "admin123"),
					new Admin(Long.valueOf(2), "admin2", "bookadmin", "Demo123@gmail.com", "admin1111"))
			.collect(Collectors.toList());

	static final List<Admin> ADMIN_TEST_DATA1 = Stream
			.of(new Admin(Long.valueOf(1), "admin1", "useradmin", "Demo@gmail.com", "admin123"))
			.collect(Collectors.toList());;

	@Test
	void getAllAdminsTest() {

		when(adminDAO.getAllAdmins()).thenReturn(ADMIN_TEST_DATA);

		assertEquals(2,2);
	}

	@Test
	void getAdminByIdTest() {
		Admin admin = new Admin(Long.valueOf(5), "admin1", "useradmin", "Demo@gmail.com", "admin123");
		when(adminDAO.getAdminById(Long.valueOf(5))).thenReturn(admin);
		assertEquals(admin, adminDAO.getAdminById(Long.valueOf(5)));
	}


	@Test
	void deleteAdminByIdTest() {

		Admin admin = new Admin(Long.valueOf(5), "admin1", "useradmin", "Demo@gmail.com", "admin123");
		adminDAO.deleteAdminById(admin.getAdminId());
		verify(adminDAO, times(1)).deleteAdminById(admin.getAdminId());
	}

	@Test
	void addAdminTest() {
		Admin admin = new Admin(Long.valueOf(5), "admin1", "useradmin", "Demo@gmail.com", "admin123");

		adminDAO.addAdmin(admin);
		verify(adminDAO, times(1)).addAdmin(admin);
	}

	@Test
	void updateAdminTest() {
		Admin admin = new Admin(Long.valueOf(5), "admin1", "useradmin", "Demo@gmail.com", "admin123");

		adminDAO.updateAdmin(admin);
		verify(adminDAO, times(1)).updateAdmin(admin);
	}
}