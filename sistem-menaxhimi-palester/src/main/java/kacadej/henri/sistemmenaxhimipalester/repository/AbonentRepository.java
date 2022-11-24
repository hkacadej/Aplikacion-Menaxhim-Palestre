package kacadej.henri.sistemmenaxhimipalester.repository;

import kacadej.henri.sistemmenaxhimipalester.entity.Abonent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDate;
import java.util.List;

public interface AbonentRepository extends JpaRepository<Abonent,Long> {
    List<Abonent> findByDataEPerfundimit(LocalDate date);
    List<Abonent> findByFirstNameOrLastName(String string1,String string);

}
