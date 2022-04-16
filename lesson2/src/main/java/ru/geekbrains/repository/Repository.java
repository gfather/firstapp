package ru.geekbrains.repository;

import java.util.List;

public interface Repository<T> {

    void create(T obj);

    T selectById(int id);

    List<T> selectAll();


    int delete(int id);
}
