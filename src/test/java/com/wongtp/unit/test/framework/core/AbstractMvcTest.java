/*
 * Copyleft
 */
package com.wongtp.unit.test.framework.core;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;

/**
 * @author wongtp
 * @date 2024-05-29
 */
@AutoConfigureMockMvc
public abstract class AbstractMvcTest extends AbstractSpringBootTest {

    @Resource
    protected MockMvc mockMvc;
}
