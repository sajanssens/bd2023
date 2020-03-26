package unittesting.mocking.simple;

public class Brutus {
    Hellor hello = new Hellor();

    public String bruter() {
        return hello.hello();
    }

    public void setHello(Hellor hello) {
        this.hello = hello;
    }
}
