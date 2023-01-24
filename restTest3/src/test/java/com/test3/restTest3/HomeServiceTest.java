package com.test3.restTest3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class HomeServiceTest {
    @MockBean
    HomeRepository homeRepository;
    @Test
    public void testShouldAddNewHome() {
        HomeService homeService = new HomeService(homeRepository);
        when(homeRepository.save(any(Home.class))).thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        Home home = new Home("addr1");
        Home home1 = homeService.addHome(home);
        assertEquals(home1, home);

        verify(homeRepository).save(any(Home.class));
    }
}