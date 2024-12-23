package day05;

import java.util.Objects;

public class Person {
        String name;

        String adress;

        String isVip;

        static int count=0;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(adress, person.adress) && Objects.equals(isVip, person.isVip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, adress, isVip);
    }
}

