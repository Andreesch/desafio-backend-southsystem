package com.southsystem.desafiobackvotos.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ASSOCIATES")
public class Associate {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "FEDERAL_IDENTIFICATION", nullable = false, length = 11)
    private String federalIdentification;

    @OrderBy("id ASC")
    @OneToMany(mappedBy = "associate", cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private List<ScoreVote> scoreVotes;

    public String getId() {
        return id;
    }

    public Associate setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Associate setName(String name) {
        this.name = name;
        return this;
    }

    public String getFederalIdentification() {
        return federalIdentification;
    }

    public Associate setFederalIdentification(String federalIdentification) {
        this.federalIdentification = federalIdentification;
        return this;
    }
}
