package com.uningen.multiplication.challenge;

import java.util.List;

public interface ChallengeService {
    /**
     * Verifies if the attempt coming from presentation layer
     * is correct or not
     * @return the resulting ChallengeAttempt object
     */
    ChallengeAttempt verifyAttempt(ChallengeAttemptDTO resultAttempt);

    /**
     * Gets the statistics for a given user
     * @param userAlias
     * @return a list of the last 10 {@link ChallengeAttempt}
     * objects created by the user
     */
    List<ChallengeAttempt> getStatsForUser(String userAlias);
}
