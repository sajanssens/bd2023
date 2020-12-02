package com.example;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class StudentService {

    @Inject
    private StudentDao studentDao;

    @PostConstruct
    public void post() {
        System.out.println("Postconstruct DatabaseManager");
    }

    // @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void save() throws Exception {
        studentDao.saveStudent1Valid();
        studentDao.saveStudent2TooLongNameSameTransaction();
    }

    // @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void save12() throws Exception {
        studentDao.saveStudent12();
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

}
