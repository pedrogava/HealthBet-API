package service;
import com.github.healthbet.api.model.User;
import com.github.healthbet.api.repository.UserRepository;
import com.github.healthbet.api.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllUsers() {
        // Arrange: cria uma lista simulada de usuários
        User user1 = new User();
        user1.setId(1L);
        user1.setName("Pedro");

        User user2 = new User();
        user2.setId(2L);
        user2.setName("Maria");

        when(userRepository.findAll()).thenReturn(List.of(user1, user2));

        // Act: chama o metodos que queremos testar
        List<User> result = userService.findAll();

        // Assert: verifica o comportamento esperado
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Pedro", result.get(0).getName());
        assertEquals("Maria", result.get(1).getName());

        // Verifica se o repositório foi chamado uma única vez
        verify(userRepository, times(1)).findAll();
    }
}