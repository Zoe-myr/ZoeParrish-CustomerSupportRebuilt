package com.example.zoeparrishcustomersupport.site;

import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;

@Validated
public interface GenericRepository<I extends Serializable,E extends Serializable> {


    @NonNull
    Iterable<E>getAll();
    E get(@NonNull I id);
    void add(@NonNull E entity);
    void update(@NonNull E entity);
    void delete(@NonNull E entity);
    void deleteById(@NonNull I id);

}
