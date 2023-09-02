package tobyspring.helloboot.v17;

import tobyspring.helloboot.Hello;

public interface HelloRepository {
    tobyspring.helloboot.Hello findHello(String name);

    void increaseCount(String name);

    default int countOf(String name) {
        Hello hello = findHello(name);
        return hello == null ? 0 : hello.getCount();
    }
}
