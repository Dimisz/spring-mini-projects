package com.uningen.multiplication.challenge;

import com.uningen.multiplication.user.User;
import org.springframework.stereotype.Service;

@Service
public class ChallengeServiceImpl implements ChallengeService{
    @Override
    public ChallengeAttempt verifyAttempt(ChallengeAttemptDTO attemptDTO) {
        // check if attempt is correct
        boolean isCorrect = attemptDTO.getGuess() ==
                attemptDTO.getFactorA() * attemptDTO.getFactorB();
        // not using identifiers yet
        User user = new User(null, attemptDTO.getUserAlias());

        // builds the domain object
        ChallengeAttempt challengeAttempt =
                new ChallengeAttempt(
                        null,
                        user,
                        attemptDTO.getFactorA(),
                        attemptDTO.getFactorB(),
                        attemptDTO.getGuess(),
                        isCorrect
                );
        return challengeAttempt;
    }
}
