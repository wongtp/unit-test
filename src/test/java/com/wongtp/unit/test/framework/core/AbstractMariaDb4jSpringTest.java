/*
 * Copyleft
 */
package com.wongtp.unit.test.framework.core;

import ch.vorburger.exec.ManagedProcessException;
import ch.vorburger.mariadb4j.springframework.MariaDB4jSpringService;
import com.wongtp.unit.test.framework.core.AbstractMariaDb4jSpringTest.BeanConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

/**
 * @author wongtp
 * @date 2024-06-21
 */
@Import(BeanConfiguration.class)
@ActiveProfiles("sit")
public class AbstractMariaDb4jSpringTest extends AbstractSpringBootTest {

    @TestConfiguration
    public static class BeanConfiguration {

        @Bean
        @ConfigurationProperties
        public static MariaDB4jSpringService mariaDB4j() {
            return new DefaultMariaDB4jSpringService();
        }
    }

    public static class DefaultMariaDB4jSpringService extends MariaDB4jSpringService {

        @Override
        public void start() {
            try {
                super.start();
                getDB().source("unit_test_demo.schema.sql");
            } catch (ManagedProcessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}