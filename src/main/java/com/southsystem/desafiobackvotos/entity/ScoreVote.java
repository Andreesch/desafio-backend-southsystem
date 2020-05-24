package com.southsystem.desafiobackvotos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "SCORE_VOTES")
public class ScoreVote {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    @Column(name = "AGREED", nullable = false)
    private Boolean agreed;

    @Column(name = "NAME", nullable = false)
    private String name;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "SCORE_ID", referencedColumnName = "ID", nullable = false, updatable = false,
            foreignKey = @ForeignKey(name = "FK_SCORE_VOTES_SCORE_ID"))
    private Score score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ASSOCIATE_ID", referencedColumnName = "ID", nullable = false, updatable = false,
            foreignKey = @ForeignKey(name = "FK_SCORE_VOTES_ASSOCIATE_ID"))
    private Associate associate;

    public String getId() {
        return id;
    }

    public ScoreVote setId(String id) {
        this.id = id;
        return this;
    }

    public Boolean getAgreed() {
        return agreed;
    }

    public ScoreVote setAgreed(Boolean agreed) {
        this.agreed = agreed;
        return this;
    }

    public String getName() {
        return name;
    }

    public ScoreVote setName(String name) {
        this.name = name;
        return this;
    }

    public Score getScore() {
        return score;
    }

    public ScoreVote setScore(Score score) {
        this.score = score;
        return this;
    }

    public Associate getAssociate() {
        return associate;
    }

    public ScoreVote setAssociate(Associate associate) {
        this.associate = associate;
        return this;
    }
}
