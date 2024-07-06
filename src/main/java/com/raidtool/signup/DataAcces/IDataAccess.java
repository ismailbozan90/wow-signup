package com.raidtool.signup.DataAcces;

import java.util.List;

public interface IDataAccess<T> {

    List<T> get();

    T getById(int id);

    void add(T t);
    void update(T t);
    void delete(T t);


}
