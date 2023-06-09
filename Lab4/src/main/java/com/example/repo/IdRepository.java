package com.example.repo;

public interface IdRepository {
    int getLastId();

    void saveLastId(int lastId);
}
