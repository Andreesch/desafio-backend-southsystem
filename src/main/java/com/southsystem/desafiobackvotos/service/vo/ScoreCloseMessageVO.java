package com.southsystem.desafiobackvotos.service.vo;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ScoreCloseMessageVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private LocalDateTime closeAt;

    private Long agreedResult;

    private Long denyResult;

    private Boolean isApproved;

    public LocalDateTime getCloseAt() {
        return closeAt;
    }

    public ScoreCloseMessageVO setCloseAt(LocalDateTime closeAt) {
        this.closeAt = closeAt;
        return this;
    }

    public Long getAgreedResult() {
        return agreedResult;
    }

    public ScoreCloseMessageVO setAgreedResult(Long agreedResult) {
        this.agreedResult = agreedResult;
        return this;
    }

    public Long getDenyResult() {
        return denyResult;
    }

    public ScoreCloseMessageVO setDenyResult(Long denyResult) {
        this.denyResult = denyResult;
        return this;
    }

    public Boolean getApproved() {
        return isApproved;
    }

    public ScoreCloseMessageVO setApproved(Boolean approved) {
        isApproved = approved;
        return this;
    }
}
