package com.southsystem.desafiobackvotos.api.helper;

import java.util.List;

import com.southsystem.desafiobackvotos.entity.ScoreCloseStatus;
import com.southsystem.desafiobackvotos.entity.ScoreVote;

public class ScoreCloseHelper {

    public static long getApprovedVotes(List<ScoreVote> votes) {
        return votes.stream()
                .filter(ScoreVote::isAgreed)
                .count();
    }

    public static long getDenyVotes(List<ScoreVote> votes) {
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

        return null;
    }

    public static boolean isApproved(Long agreed, Long deny) {
        if (agreed > deny) {
            return Boolean.TRUE;
        }

        if (agreed < deny) {
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }
}
