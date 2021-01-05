package com.entelgy.demo.testing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.entelgy.demo.dto.DemoDto;
import com.entelgy.demo.service.DemoService;
import com.entelgy.demo.service.Impl.DemoServiceImpl;


@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc(addFilters = false)
public class DemoServiceImplTest {

    @TestConfiguration
    static class DemoServiceImplTestContextConfiguration {
        @Bean
        public DemoService employeeService() {
            return new DemoServiceImpl();
        }
    }

    @Autowired
    private DemoService demoService;

    @BeforeAll
    public static void setUp() throws Exception {

	}
    
    @Test
    public void whenEmailDado_thenDemoServiceEmailEncontrado() {
        String emailTest = "correo11@prueba.com";
        List<DemoDto> lista = demoService.listarComentarios();
        assertThat(lista.get(0).getEmail()).isEqualTo(emailTest);
    }

    
}
