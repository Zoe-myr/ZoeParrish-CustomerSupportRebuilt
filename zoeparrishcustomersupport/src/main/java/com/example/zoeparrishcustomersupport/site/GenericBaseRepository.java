package com.example.zoeparrishcustomersupport.site;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class GenericBaseRepository<I extends Serializable,E extends Serializable> implements  GenericRepository<I,E> {
    protected final Class<I> idClass;
    protected final Class<E> entityClass;

    public GenericBaseRepository(){
        Type genericSuperCalss = this.getClass().getGenericSuperclass();
        while (!(genericSuperCalss instanceof ParameterizedType)){
            if (!(genericSuperCalss instanceof ParameterizedType)) {
                throw new IllegalStateException("unable to determine type arguments");
            }
            if (genericSuperCalss== GenericBaseRepository.class){
                throw new IllegalStateException("no peramiterized generic superclass found");
            }

            genericSuperCalss = ((Class)genericSuperCalss).getGenericSuperclass();

        }

        ParameterizedType type = (ParameterizedType) genericSuperCalss;
        Type[] arguments = type.getActualTypeArguments();
        idClass = (Class<I>)arguments[0];
        entityClass = (Class<E>)arguments[1];

    }

}
