import java.util.OptionalInt;

public class PersonBuilder{
    private String name;
    private String surname;
    private OptionalInt age;
    private String address;

    public Person build() {
        Person person;
        if (surname == null || name == null)
            throw new IllegalStateException("введите значение");
        if (age.isPresent()) {
            person = new Person(name, surname,  age.getAsInt());
        } else {
            person = new Person(name, surname);
        }
        if (address != null) {
            person.setAddress(address);
        }
        return person;
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) throw new IllegalArgumentException("неверный возраст");
        this.age = OptionalInt.of(age);
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }
}
