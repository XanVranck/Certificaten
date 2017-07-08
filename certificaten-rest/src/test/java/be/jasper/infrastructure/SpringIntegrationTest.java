package be.jasper.infrastructure;

import be.jasper.CertificatenRestApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CertificatenRestApplication.class)
@Transactional
@ActiveProfiles("test")
public abstract class SpringIntegrationTest {

}
