package pt.com.altice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.http.HttpException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import pt.com.altice.service.AlticeService;
import pt.com.altice.service.impl.AlticeServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(
  webEnvironment = SpringBootTest.WebEnvironment.MOCK,
  classes = AlticeRecruitment.class)
@AutoConfigureMockMvc
@TestPropertySource(
  locations = "classpath:bootstrap.yml")
public class AlticeServiceTestCase extends ServiceIntegrationTestBase {
    

    //@Spy
    //@InjectMocks
    @Autowired
    private AlticeService alticeService;// = new AlticeServiceImpl();
    
    @Mock
    private AlticeService self = new AlticeServiceImpl();
    

    
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testUntil9() throws HttpException {
        /*
        ReflectionTestUtils.setField(alticeService, "self", self);
        
        when(self.getAlticciNumber(0)).thenReturn(alticeService.getAlticciNumber(0));
        when(self.getAlticciNumber(1)).thenReturn(alticeService.getAlticciNumber(1));
        when(self.getAlticciNumber(2)).thenReturn(1);
        when(self.getAlticciNumber(3)).thenReturn(1);
        when(self.getAlticciNumber(4)).thenReturn(2);
        when(self.getAlticciNumber(5)).thenReturn(2);
        when(self.getAlticciNumber(6)).thenReturn(3);
        when(self.getAlticciNumber(7)).thenReturn(4);
        when(self.getAlticciNumber(8)).thenReturn(5);
        when(self.getAlticciNumber(9)).thenReturn(7);
        when(self.getAlticciNumber(10)).thenReturn(9);
        */
        
        assertEquals(0, (int)alticeService.getAlticciNumber(0)) ;
        assertEquals(1, (int)alticeService.getAlticciNumber(1)) ;
        assertEquals(1, (int)alticeService.getAlticciNumber(2)) ;
        assertEquals(1, (int)alticeService.getAlticciNumber(3)) ;
        assertEquals(2, (int)alticeService.getAlticciNumber(4)) ;
        assertEquals(2, (int)alticeService.getAlticciNumber(5)) ;
        assertEquals(3, (int)alticeService.getAlticciNumber(6)) ;
        assertEquals(4, (int)alticeService.getAlticciNumber(7)) ;
        assertEquals(5, (int)alticeService.getAlticciNumber(8)) ;        
        assertEquals(7, (int)alticeService.getAlticciNumber(9)) ;
        assertEquals(9, (int)alticeService.getAlticciNumber(10)) ;
    }
    
    @Test
    public void testError() throws HttpException {
        int i = 0;
        
        try {
            alticeService.getAlticciNumber(71);
        }catch(BusinessException ex) {
            i = 1;
        }
        
        assertEquals(i, 1);
    }
    
}
