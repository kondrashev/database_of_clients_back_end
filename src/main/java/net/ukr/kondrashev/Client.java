package net.ukr.kondrashev;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Client")
@NoArgsConstructor
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue
    private long id;

    private String firstName;
    private String surName;
    private String phone;

    public Client(String firstName, String surName, String phone) {
        this.firstName = firstName;
        this.surName = surName;
        this.phone = phone;
    }
}
