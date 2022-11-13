package entities;

import java.util.Objects;
import java.util.Scanner;

public class Student {
    private Integer register;

    public Student(Integer register) {
        this.register = register;
    }

    public Integer getRegister() {
        return register;
    }

    public void setRegister(Integer register) {
        this.register = register;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return register.equals(student.register);
    }

    @Override
    public int hashCode() {
        return Objects.hash(register);
    }

}
