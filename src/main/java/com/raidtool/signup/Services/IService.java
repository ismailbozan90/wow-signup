package com.raidtool.signup.Services;

import java.util.List;

public interface IService<T> {

    List<T> get();

    T getById(long id);

    void add(T t);

    void update(T t);

    void delete(T t);

}
