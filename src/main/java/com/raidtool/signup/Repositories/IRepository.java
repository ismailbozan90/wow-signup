package com.raidtool.signup.Repositories;

import java.util.List;

public interface IRepository<T> {

    List<T> get();

    T getById(int id);

    void add(T t);
    void update(T t);
    void delete(T t);


}
