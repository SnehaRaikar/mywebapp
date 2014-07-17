package mywebapp;

import java.sql.SQLException;

import junit.framework.TestCase;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.tutorial.action.SignupAction;
import com.tutorial.model.User;
import com.tutorial.service.UserService;
import com.tutorial.service.UserServiceImpl;


public class SignupActionTest extends TestCase {
	
	@Mock
	private UserService  userService;
	
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		userService = Mockito.mock(UserServiceImpl.class);
	}
	
	@Test
	public void testExecuteSuccess() {
		SignupAction action = new SignupAction();
		action.setUserService(userService);
		User existingUser = new User();
		existingUser.setName("Test User");
		existingUser.setUsername("Test");
		existingUser.setEmail("test@test.com");
		existingUser.setPassword("test");
		action.setUser(existingUser);
		try {
			Mockito.when(userService.insertUser(existingUser)).thenReturn(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertEquals("SUCCESS", action.execute());
	}
	
	@Test
	public void testExecuteFailure() {
		SignupAction action = new SignupAction();
		action.setUserService(userService);
		action.setUser(null);
		assertEquals("FAILURE", action.execute());
	}
	
	@Test
	public void testExecuteException() {
		SignupAction action = new SignupAction();
		action.setUserService(userService);
		User existingUser = new User();
		existingUser.setName("Test User");
		existingUser.setUsername("Test");
		existingUser.setEmail("test@test.com");
		existingUser.setPassword("test");
		action.setUser(existingUser);
		SQLException e = new SQLException();
		try {
			Mockito.when(userService.insertUser(existingUser)).thenThrow(e);
		} catch (SQLException ex) {
		   assertNotNull(ex);
		   assertTrue(action.hasActionErrors());
		}
	}
	
	@Test
	public void testValidationPass() {
		SignupAction action = new SignupAction();
		action.setUserService(userService);
		User existingUser = new User();
		existingUser.setName("Test User");
		existingUser.setUsername("Test");
		existingUser.setEmail("test@test.com");
		existingUser.setPassword("test");
		existingUser.setConfirmPassword("test");
		action.setUser(existingUser);
		action.validate();	
		assertFalse(action.hasActionErrors());
	}
	
	@Test
	public void testValidationFailForName() {
		SignupAction action = new SignupAction();
		action.setUserService(userService);
		User existingUser = new User();
		action.setUser(existingUser);
		action.validate();	
		assertTrue(action.hasActionErrors());
	}
	
	@Test
	public void testValidationFailForEmail() {
		SignupAction action = new SignupAction();
		action.setUserService(userService);
		User existingUser = new User();
		existingUser.setName("Test User");
		action.setUser(existingUser);
		action.validate();	
		assertTrue(action.hasActionErrors());
	}

	@Test
	public void testValidationFailForUsername() {
		SignupAction action = new SignupAction();
		action.setUserService(userService);
		User existingUser = new User();
		existingUser.setName("Test User");
		existingUser.setEmail("test@test.com");
		action.setUser(existingUser);
		action.validate();	
		assertTrue(action.hasActionErrors());
	}
	
	@Test
	public void testValidationFailForPassword() {
		SignupAction action = new SignupAction();
		action.setUserService(userService);
		User existingUser = new User();
		existingUser.setName("Test User");
		existingUser.setEmail("test@test.com");
		existingUser.setUsername("Test");
		action.setUser(existingUser);
		action.validate();	
		assertTrue(action.hasActionErrors());
	}
	
	@Test
	public void testValidationFailForConfirmPassword() {
		SignupAction action = new SignupAction();
		action.setUserService(userService);
		User existingUser = new User();
		existingUser.setName("Test User");
		existingUser.setEmail("test@test.com");
		existingUser.setUsername("Test");
		existingUser.setPassword("test");
		action.setUser(existingUser);
		action.validate();	
		assertTrue(action.hasActionErrors());
	}
	
	@Test
	public void testValidationFailIfPasswordsDoNotMatch() {
		SignupAction action = new SignupAction();
		action.setUserService(userService);
		User existingUser = new User();
		existingUser.setName("Test User");
		existingUser.setEmail("test@test.com");
		existingUser.setUsername("Test");
		existingUser.setPassword("test");
		existingUser.setConfirmPassword("test1");
		action.setUser(existingUser);
		action.validate();	
		assertTrue(action.hasActionErrors());
	}
}
