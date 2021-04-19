package com.example.ingli.Service;

import java.util.List;

public interface CrudService<T> {

    List<T> getAll();

    void create(T object);

    void delete(Long id);

}
