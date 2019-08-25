package Vehicle.Repository.Impl;

public interface IRespository<T, Id>{

    T create(T t);
    T update(T t);
    void delete(Id id);
    T read(Id id);

}
