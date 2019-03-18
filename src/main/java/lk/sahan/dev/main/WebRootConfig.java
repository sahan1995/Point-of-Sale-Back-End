package lk.sahan.dev.main;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({JPAConfig.class,CustomConfiguration.class,WebSecurityConfig.class})

public class WebRootConfig {
}
