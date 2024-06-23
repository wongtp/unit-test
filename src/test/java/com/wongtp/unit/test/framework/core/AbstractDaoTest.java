/*
 * Copyleft
 */
package com.wongtp.unit.test.framework.core;

import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wongtp
 * @date 2024-05-29
 */
@Transactional
@Rollback
public abstract class AbstractDaoTest extends AbstractSpringBootTest {

}
