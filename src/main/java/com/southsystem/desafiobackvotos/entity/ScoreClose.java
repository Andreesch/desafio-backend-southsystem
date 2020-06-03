package com.southsystem.desafiobackvotos.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "SCORE_CLOSED")
public class ScoreClose {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    @Column(name = "CLOSE_AT", nullable = false)
    private LocalDateTime closeAt;

    @Column(name = "AGREED_RESULT", nullable = false)
    private Long agreedResult;

    @Column(name = "DENY_RESULT", nullable = false)
    private Long denyResult;

    @Enumerated(EnumType.STRING)
    @Column(name = "SCORE_CLOSE_STATUS", nullable = false)
    private ScoreCloseStatus scoreCloseStatus;

    @OneToOne(optional = false)
    @MapsId
    @JoinColumn(name = "SCORE_CLOSE_SCORE_ID", referencedColumnName = "ID")
    private Score score;

    public String getId() {
        return id;
    }

    public ScoreClose setId(String id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getCloseAt() {
        return closeAt;
    }

    public ScoreClose setCloseAt(LocalDateTime closeAt) {
        this.closeAt = closeAt;
        return this;
    }

    public Long getAgreedResult() {
        return agreedResult;
    }

    public ScoreClose setAgreedResult(Long agreedResult) {
        this.agreedResult = agreedResult;
        return this;
    }

    public Long getDenyResult() {
        return denyResult;
    }

    public ScoreClose setDenyResult(Long denyResult) {
        this.denyResult = denyResult;
        return this;
    }

    public ScoreCloseStatus getScoreCloseStatus() {
        return scoreCloseStatus;
    }

    public ScoreClose setScoreCloseStatus(ScoreCloseStatus scoreCloseStatus) {
        this.scoreCloseStatus = scoreCloseStatus;
        return this;
    }

    public Score getScore() {
        return score;
    }

    public ScoreClose setScore(Score score) {
        this.score = score;
        return this;
    }
}
