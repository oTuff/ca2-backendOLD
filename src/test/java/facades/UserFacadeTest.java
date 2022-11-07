package facades;

import dtos.UserDTO;
import entities.User;
import org.junit.jupiter.api.*;
import security.errorhandling.AuthenticationException;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserFacadeTest {

    private static EntityManagerFactory emf;
    private static UserFacade facade;
    User user1;
    User user2;
    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = UserFacade.getUserFacade(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
        emf.close();
    }

    @BeforeEach
    void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("User.deleteAllRows").executeUpdate();
            user1 = new User("Oscar", "test");
            user2 = new User("Mark", "test");
            em.persist(user1);
            em.persist(user2);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    void tearDown() {
        //        Remove any data after each test was run
        //        emf.close();
    }

    @Test
    void getVerifiedUser() throws AuthenticationException {
       User actual = facade.getVerifiedUser("Oscar", "test");
       User expected = user1;
       assertEquals(expected,actual);
    }
    @Test
    void wrongPassword() throws AuthenticationException {
        //User actual = facade.getVerifiedUser("Oscar", "test123");
        assertThrows(AuthenticationException.class, ()-> facade.getVerifiedUser("Oscar","test123"));
    }
    @Test
    void wrongUserName() throws AuthenticationException {
    }

    @Test
    void getAllUsers() {
        List<UserDTO> actual = facade.getAllUsers();
        int expected = 2;
        assertEquals(expected, actual.size());
        assertTrue(actual.contains(new UserDTO(user1)));
    }

    @Test
    void getUserById() {
        UserDTO actual = facade.getUserById(user1.getId());
        UserDTO expected = new UserDTO(user1);
        assertEquals(expected,actual);
    }

    @Test
    void updateUser() {
        UserDTO actual = facade.updateUser(user1.getId());
        UserDTO expected = new UserDTO(user1);
        assertEquals(expected,actual);


    }

    @Test
    void deleteUser() {
    }
}
