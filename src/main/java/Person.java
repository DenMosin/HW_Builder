import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age;
    protected String adress;

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);

    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.empty();
    }

    public boolean hasAge() {
        return age.isPresent();
    }

    public boolean hasAddress() {
        if (adress == null) return false;
        return true;
    }

    public String getName() {

        return name;
    }

    public String getSurname() {

        return surname;
    }

    public OptionalInt getAge() {

        return age;
    }

    public String getAddress() {

        return adress;
    }

    public void setAddress(String address) {

        this.adress = address;
    }

    public void happyBirthday() {
        this.age = OptionalInt.of(age.getAsInt() + 1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, OptionalInt.of(0), adress);
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(this.surname)
                .setAddress(this.adress)
                .setAge(0);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + (age.isPresent()?age.getAsInt():age) +
                ", adress='" + adress + '\'' +
                '}';
    }
}





