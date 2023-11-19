package edu.hw7.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.jetbrains.annotations.Nullable;

//Версия сразу с ReadWriteLock - без нее был Object lock, и synchronized(lock), не подумал что надо оставить
public class LocalPersonDatabase implements PersonDatabase {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final List<Person> persons = new ArrayList<>();

    @Override
    public int getDatabaseLength() {
        lock.readLock().lock();
        var result = persons.size();
        lock.readLock().unlock();
        return result;
    }

    @Override
    public void add(Person person) {
        lock.writeLock().lock();
        persons.add(person);
        lock.writeLock().unlock();
    }

    @Override
    public void delete(int id) {
        lock.writeLock().lock();
        try {
            persons.removeIf(person -> person.id() == id);
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Nullable
    @Override
    public Person findByName(String name) {
        lock.readLock().lock();
        Person result;
        try {
            result = persons.parallelStream()
                .filter(person -> Objects.equals(person.name(), name))
                .findFirst()
                .orElse(null);
        } finally {
            lock.readLock().unlock();
        }
        return result;
    }

    @Nullable
    @Override
    public Person findByAddress(String address) {
        lock.readLock().lock();
        Person result;
        try {
            result = persons.parallelStream()
                .filter(person -> Objects.equals(person.address(), address))
                .findFirst()
                .orElse(null);
        } finally {
            lock.readLock().unlock();
        }
        return result;
    }

    @Nullable
    @Override
    public Person findByPhone(String phone) {
        lock.readLock().lock();
        Person result;
        try {
            result = persons.parallelStream()
                .filter(person -> Objects.equals(person.phoneNumber(), phone))
                .findFirst()
                .orElse(null);
        } finally {
            lock.readLock().unlock();
        }
        return result;
    }
}
