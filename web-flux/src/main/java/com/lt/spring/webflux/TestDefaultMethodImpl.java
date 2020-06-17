package com.lt.spring.webflux;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TestDefaultMethodImpl implements TestDefaultMethod {
    public static void main(String[] args) {
        /*new TestDefaultMethodImpl()
                .print();
        String[] strings = new File("/").list((dir,name)->{
            if (dir.isDirectory()) {
                System.out.println("=>>>>>>"+dir.getName());
            }
            System.out.println(name);
            return name.contains(".old");
        });
        System.out.println("====================");
        for (String string : strings) {
            System.out.println(string);
        }*/

        String[] strs = new String[]{"123", "321", "456", "654"};
        Stream.of(strs).flatMap(s -> new TestDefaultMethodImpl().testStream(s)).forEach(System.out::println);

    }

    public Stream testStream(String s) {
        List<Character> characterList = new ArrayList();
        for (char c : s.toCharArray()) {
            characterList.add(c);
        }
        return characterList.stream();
    }
}
