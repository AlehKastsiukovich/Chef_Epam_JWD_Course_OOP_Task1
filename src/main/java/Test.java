import by.javatraining.chef.exception.UtilException;
import by.javatraining.chef.util.TxtFileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
        A a = new B();
        B b = (B)a;
        a.name = "Aleh";
        b.id = 5;

        System.out.println(b.toString());

    }
}

class A {
    String name;
}

class B extends A {
    int id;

    public String toString() {
        return name + " " + id;
    }
}