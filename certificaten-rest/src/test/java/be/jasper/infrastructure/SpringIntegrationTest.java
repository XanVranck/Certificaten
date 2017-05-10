package be.jasper.infrastructure;

import be.jasper.CertificatenRestApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CertificatenRestApplication.class)
@Transactional
@ActiveProfiles("dev")
public class SpringIntegrationTest {

    @Test
    public void trueIsTrue() throws Exception {
        assertThat(true).isEqualTo(true);
    }
}
