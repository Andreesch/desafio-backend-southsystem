package com.southsystem.desafiobackvotos.service.vo;

import java.time.LocalDateTime;

public class ScoreCloseMessageVO {

    private LocalDateTime closeAt;

    private Long agreedResult;

    private Long denyResult;

    private boolean isApproved;

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

    public boolean isApproved() {
        return isApproved;
    }

    public ScoreCloseMessageVO setApproved(boolean approved) {
        isApproved = approved;
        return this;
    }
}
