package com.southsystem.desafiobackvotos.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "SCORE")
public class Score {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "SUBJECT", nullable = false)
    private String subject;

    @Column(name = "SESSION_LENGTH", nullable = true)
    private Long sessionLength;

    @Enumerated(EnumType.STRING)
    @Column(name = "SCORE_STATUS", nullable = true)
    private ScoreStatus scoreStatus;

    @Column(name = "OPEN_AT", nullable = true)
    private LocalDateTime openAt;

    @Column(name = "CLOSE_AT", nullable = true)
    private LocalDateTime closeAt;

    @OrderBy("name ASC")
    @OneToMany(mappedBy = "score", cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private List<ScoreVote> scoreVotes;

    @OneToOne
    private ScoreClose scoreClose;

    public String getId() {
        return id;
    }

    public Score setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Score setName(String name) {
        this.name = name;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public Score setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public Long getSessionLength() {
        return sessionLength;
    }

    public Score setSessionLength(Long sessionLength) {
        this.sessionLength = sessionLength;
        return this;
    }

    public ScoreStatus getScoreStatus() {
        return scoreStatus;
    }

    public Score setScoreStatus(ScoreStatus scoreStatus) {
        this.scoreStatus = scoreStatus;
        return this;
    }

    public LocalDateTime getOpenAt() {
        return openAt;
    }

    public Score setOpenAt(LocalDateTime openAt) {
        this.openAt = openAt;
        return this;
    }

    public LocalDateTime getCloseAt() {
        return closeAt;
    }

    public Score setCloseAt(LocalDateTime closeAt) {
        this.closeAt = closeAt;
        return this;
    }

    public List<ScoreVote> getScoreVotes() {
        return scoreVotes;
    }

    public Score setScoreVotes(List<ScoreVote> scoreVotes) {
        this.scoreVotes = scoreVotes;
        return this;
    }

    public ScoreClose getScoreClose() {
        return scoreClose;
    }

    public Score setScoreClose(ScoreClose scoreClose) {
        this.scoreClose = scoreClose;
        return this;
    }
}
