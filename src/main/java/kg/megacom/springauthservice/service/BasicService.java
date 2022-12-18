package kg.megacom.springauthservice.service;

import java.util.List;

public interface BasicService <T>{
    T save(T t);
    T findById(Long id);
    List<T>findAll();
    T delete(Long id);

}
