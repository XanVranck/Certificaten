package be.jasper.infrastructure;

import be.jasper.CertificatenRestApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CertificatenRestApplication.class)
@Transactional
@ActiveProfiles("test")
@DirtiesContext(classMode = AFTER_EACH_TEST_METHOD)
public abstract class SpringIntegrationTest {

}
