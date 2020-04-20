package unittesting.slides.mocking.all.inject;

public class PersonService {
    private PersonDao personDao;

    public String sayHello() {
        return personDao.hello();
    }

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }
}
