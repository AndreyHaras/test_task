package com.haulmont.test_task.dao.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class CreditRepositoryTest extends Activeprofile {
    @Autowired
    private CreditRepository creditRepository;


}