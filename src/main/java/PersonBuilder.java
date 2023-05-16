public class PersonBuilder{
    private String name;
    private String surname;
    private int age;
    private String address;

    public Person build() {
        Person person;
        if (surname == null || name == null)
            throw new IllegalStateException("введите значение");
        if (age > 0) {
            person = new Person(name, surname, age);
        } else {
            person = new Person(name, surname);
        }
        person.setAddress(address);
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
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }
}
