package kacadej.henri.sistemmenaxhimipalester.entity;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "abonentet")
public class Abonent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name",nullable = false)
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @Column
    private Integer mosha;
    @Column
    private Integer pesha;

    @Column
    private Character gjinia;

    @Column(name = "email")
    private String email;
    @Column
    private LocalDate dataEFillimit;
    @Column
    private LocalDate dataEPerfundimit;

    public Abonent() {
    }

    public Abonent(String firstName, String lastName, Integer mosha, Integer pesha, Character gjinia, String email, LocalDate dataEFillimit, LocalDate dataEPerfundimit) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mosha = mosha;
        this.pesha = pesha;
        this.gjinia = gjinia;
        this.email = email;
        this.dataEFillimit = dataEFillimit;
        this.dataEPerfundimit = dataEPerfundimit;
    }

    public Integer getMosha() {
        return mosha;
    }

    public void setMosha(Integer mosha) {
        this.mosha = mosha;
    }

    public Integer getPesha() {
        return pesha;
    }

    public void setPesha(Integer pesha) {
        this.pesha = pesha;
    }

    public Character getGjinia() {
        return gjinia;
    }

    public void setGjinia(Character gjinia) {
        this.gjinia = gjinia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataEFillimit() {
        return dataEFillimit;
    }

    public void setDataEFillimit(LocalDate dataEFillimit) {
        this.dataEFillimit = dataEFillimit;
    }

    public LocalDate getDataEPerfundimit() {
        return dataEPerfundimit;
    }

    public void setDataEPerfundimit(LocalDate dataEPerfundimit) {
        this.dataEPerfundimit = dataEPerfundimit;
    }
}
