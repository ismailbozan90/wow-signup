package com.raidtool.signup.Service;

import java.util.List;

public interface IService<T> {

    List<T> get();

    T getById(int id);

    void add(T t);
    void update(T t);
    void delete(T t);

}
