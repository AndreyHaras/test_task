package com.haulmount.test_task.dao.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CreditRepositoryTest extends Activeprofile {
    @Autowired
    private CreditRepository creditRepository;

}