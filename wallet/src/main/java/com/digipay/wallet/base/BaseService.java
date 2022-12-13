package com.digipay.wallet.base;

import com.digipay.wallet.exceptions.BaseException;
import org.springframework.data.domain.Example;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T extends BaseEntity, ID extends Serializable> {
    T saveOrUpdate(T t) throws BaseException;

    void deleteById(ID id) throws BaseException;

    void deleteEntity(T t) throws BaseException;

    T findById(ID id) throws BaseException;

    List<T> findAll() throws BaseException;

    <S extends T> List<S> findAll(Example<S> example);

}
