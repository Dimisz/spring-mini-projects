package com.uningen.multiplication.challenge;

import com.uningen.multiplication.user.AppUser;
import com.uningen.multiplication.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ChallengeServiceImpl implements ChallengeService{
    private final UserRepository userRepository;
    private final ChallengeAttemptRepository challengeAttemptRepository;
    @Override
    public ChallengeAttempt verifyAttempt(ChallengeAttemptDTO attemptDTO) {
        // check if user with that alias exists
        // otherwise create a new user
        AppUser appUser = userRepository.findByAlias(attemptDTO.getAlias())
                .orElseGet(() -> {
                    log.info("Creating new user with alias {}",
                            attemptDTO.getAlias());
                    return userRepository.save(
                            new AppUser(attemptDTO.getAlias())
                    );
                });

        // check if attempt is correct
        boolean isCorrect = attemptDTO.getGuess() ==
                attemptDTO.getFactorA() * attemptDTO.getFactorB();
        // builds domain object
        ChallengeAttempt challengeAttempt =
                new ChallengeAttempt(
                        null,
                        appUser,
                        attemptDTO.getFactorA(),
                        attemptDTO.getFactorB(),
                        attemptDTO.getGuess(),
                        isCorrect
                );
        // stores the attempt
        ChallengeAttempt storedAttempt =
                challengeAttemptRepository.save(challengeAttempt);

        return storedAttempt;
    }

    @Override
    public List<ChallengeAttempt> getStatsForUser(String userAlias) {
        List<ChallengeAttempt> attempts =
             challengeAttemptRepository.findTop10ByAppUserAliasOrderByIdDesc(userAlias);
        System.out.println(attempts);
        return attempts;
    }
}
