package com.raidtool.signup.Service;

import com.raidtool.signup.DataAcces.IDataAccess;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GeneralService<T> implements IService<T> {

    private final IDataAccess<T> dataAccess;

    public GeneralService(IDataAccess<T> dataAccess) {
        this.dataAccess = dataAccess;
    }

    @Override
    public List<T> get() {
        return dataAccess.get();
    }

    @Override
    public T getById(int id) {
        return dataAccess.getById(id);
    }

    @Override
    public void add(T t) {
        dataAccess.add(t);
    }

    @Override
    public void update(T t) {
        dataAccess.update(t);
    }

    @Override
    public void delete(T t) {
        dataAccess.delete(t);
    }
}
