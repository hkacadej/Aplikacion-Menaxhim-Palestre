package kacadej.henri.sistemmenaxhimipalester.services.implementations;

import jdk.jfr.Timestamp;
import kacadej.henri.sistemmenaxhimipalester.entity.Abonent;
import kacadej.henri.sistemmenaxhimipalester.repository.AbonentRepository;
import kacadej.henri.sistemmenaxhimipalester.services.AbonentService;
import org.springframework.stereotype.Service;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class AbonentServiceImplementation implements AbonentService {

    private AbonentRepository abonentRepository;

    public AbonentServiceImplementation(AbonentRepository abonentRepository) {
        this.abonentRepository = abonentRepository;
    }

    @Override
    public List<Abonent> getAllAbonents() {
        return abonentRepository.findAll();
    }

   @Override
    public List<Abonent> getAbonentNoSubscription() {

        return abonentRepository.findByDataEPerfundimit(LocalDate.now());
    }

    @Override
    public Abonent getAbonentById(Long id) {
        return abonentRepository.findById(id).get();
    }

    @Override
    public void fshijAbonent(Long id) {
        abonentRepository.deleteById(id);
    }

    @Override
    public void rinovoAbonim(Long id) {
       Abonent abonent = abonentRepository.findById(id).get();
       LocalDate localDate= abonent.getDataEPerfundimit();
       abonent.setDataEPerfundimit(localDate.plusDays(31));
       abonentRepository.save(abonent);
    }

    @Override
    public void shtoAbonent(Abonent abonent) {
        abonent.setDataEFillimit(LocalDate.now());
        abonent.setDataEPerfundimit(LocalDate.now().plusDays(31));
        abonentRepository.save(abonent);
    }

    @Override
    public List<Abonent> kerkoAbonent(String string) {
        if(string.contains(" ")) {
            String emri = string.split(" ")[0];
            String mbiemri = (string.split(" ")[1].isEmpty()) ? " " : string.split(" ")[1];
            return abonentRepository.findByFirstNameOrLastName(emri, mbiemri);
        }
        return abonentRepository.findByFirstNameOrLastName(string,string);
    }

    @Override
    public Abonent updateAbonentin(Abonent abonent, Long id) {
        Abonent existingAbonent = abonentRepository.findById(id).get();
        existingAbonent.setEmail(abonent.getEmail());
        existingAbonent.setFirstName(abonent.getFirstName());
        existingAbonent.setLastName(abonent.getLastName());
        existingAbonent.setGjinia(abonent.getGjinia());
        existingAbonent.setMosha(abonent.getMosha());
        existingAbonent.setPesha(abonent.getPesha());
        abonentRepository.save(existingAbonent);
        return existingAbonent;
    }
}
