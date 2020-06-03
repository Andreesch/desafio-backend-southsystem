package com.southsystem.desafiobackvotos.api.helper;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;

import com.southsystem.desafiobackvotos.entity.ScoreCloseStatus;
import com.southsystem.desafiobackvotos.entity.ScoreVote;

public class ScoreCloseHelper {

    public static long getApprovedVotes(List<ScoreVote> votes) {
        if (Objects.isNull(votes)) {
            return 0l;
        }

        return votes.stream()
                .filter(ScoreVote::isAgreed)
                .count();
    }

    public static long getDenyVotes(List<ScoreVote> votes) {
        if (Objects.isNull(votes)) {
            return 0l;
        }

        return votes.stream()
                .filter(scoreVote -> !scoreVote.isAgreed())
                .count();
    }

    public static ScoreCloseStatus buildStatusByVotes(Long agreed, Long deny) {
        if (agreed > deny) {
            return ScoreCloseStatus.APPROVED;
        }

        if (agreed < deny) {
            return ScoreCloseStatus.DENIED;
        }

        return ScoreCloseStatus.NO_VOTES;
    }

    public static Boolean isApproved(Long agreed, Long deny) {
        if (agreed > deny) {
            return Boolean.TRUE;
        }

        if (agreed < deny) {
            return Boolean.FALSE;
        }

        return null;
    }

    public static long calculateSessionLength(LocalDateTime startAt, LocalDateTime closeAt) {
        return ChronoUnit.MINUTES.between(startAt, closeAt);
    }
}
