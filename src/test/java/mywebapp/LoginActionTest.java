package mywebapp;

import junit.framework.TestCase;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.tutorial.action.LoginAction;
import com.tutorial.model.User;
import com.tutorial.service.UserService;
import com.tutorial.service.UserServiceImpl;


public class LoginActionTest extends TestCase {
	
	@Mock
	private UserService  userService;
	
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		userService = Mockito.mock(UserServiceImpl.class);
	}
	
	@Test
	public void testSucessfulLogin() {
		LoginAction action = new LoginAction();
		action.setUsername("test");
		action.setPassword("test");
		action.setUserService(userService);
		User existingUser = new User();
		existingUser.setName("Test User");
		existingUser.setUsername("Test");
		existingUser.setEmail("test@test.com");
		existingUser.setPassword("test");
		Mockito.when(userService.getUserByUserName("test")).thenReturn(existingUser);
		assertEquals("SUCCESS", action.execute());
	}
	
	@Test
	public void testUnsccessfulLogin() {
		LoginAction action = new LoginAction();
		action.setUsername("test");
		action.setPassword("test");
		action.setUserService(userService);
		Mockito.when(userService.getUserByUserName("test")).thenReturn(null);
		assertEquals("FAILURE", action.execute());
	}

	@Test
	public void testIncorrectPasswordLogin() {
		LoginAction action = new LoginAction();
		action.setUsername("test");
		action.setPassword("test");
		action.setUserService(userService);
		User existingUser = new User();
		existingUser.setName("Test User");
		existingUser.setUsername("Test");
		existingUser.setEmail("test@test.com");
		existingUser.setPassword("Test");
		Mockito.when(userService.getUserByUserName("test")).thenReturn(existingUser);
		assertEquals("FAILURE", action.execute());
	}
}
