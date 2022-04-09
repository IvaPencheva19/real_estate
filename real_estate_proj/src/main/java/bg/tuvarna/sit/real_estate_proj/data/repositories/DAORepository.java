package bg.tuvarna.sit.real_estate_proj.data.repositories;

import java.util.List;

    public interface DAORepository<T> {
        void save(T obj);
        void update(T obj);
        void delete(T obj);
        T getById(int id);


    }

