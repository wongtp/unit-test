/*
 * Copyleft
 */
package com.wongtp.unit.test.mariadb4j;

import ch.vorburger.mariadb4j.DBConfiguration;
import ch.vorburger.mariadb4j.DBConfigurationBuilder;
import ch.vorburger.mariadb4j.junit.MariaDB4jRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author wongtp
 * @date 2024-06-21
 */
public class MariaDb4jJunitTest {

    @Rule
    public MariaDB4jRule dbRule = new MariaDB4jRule(buildDbConfig(), "", "unit_test_demo.schema.sql");

    @Test
    public void testMariaDB4j() throws SQLException {
        Connection conn = DriverManager.getConnection(dbRule.getURL(), "root", "");
        Assert.assertEquals(3306, dbRule.getDBConfiguration().getPort());
    }

    private static DBConfiguration buildDbConfig() {
        DBConfigurationBuilder configBuilder = DBConfigurationBuilder.newBuilder();
        configBuilder.setPort(3306);
        // Linux下必须以 root 用户启动，否则在某些场景下可能会报错
        if (!configBuilder._getArgs().contains("--user=root")) {
            configBuilder.addArg("--user=root");
        }
        return configBuilder.build();
    }
}