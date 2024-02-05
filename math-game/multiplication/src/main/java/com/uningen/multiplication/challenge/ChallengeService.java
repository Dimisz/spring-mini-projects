package com.uningen.multiplication.challenge;

public interface ChallengeService {
    /**
     * Verifies if the attempt coming from presentation layer
     * is correct or not
     * @return the resulting ChallengeAttempt object
     */
    ChallengeAttempt verifyAttempt(ChallengeAttemptDTO resultAttempt);
}
