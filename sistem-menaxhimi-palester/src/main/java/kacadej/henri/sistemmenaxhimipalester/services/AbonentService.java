package kacadej.henri.sistemmenaxhimipalester.services;

import kacadej.henri.sistemmenaxhimipalester.entity.Abonent;

import java.util.List;

public interface AbonentService {

    List<Abonent> getAllAbonents();

    List<Abonent> getAbonentNoSubscription();
    Abonent getAbonentById(Long id);

    void fshijAbonent(Long id);
    void rinovoAbonim(Long id);
    void shtoAbonent(Abonent abonent);

    List<Abonent> kerkoAbonent(String string);

    Abonent updateAbonentin(Abonent abonent, Long id);
}
