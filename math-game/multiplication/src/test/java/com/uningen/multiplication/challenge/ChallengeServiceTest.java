package com.uningen.multiplication.challenge;

import com.uningen.multiplication.user.AppUser;
import com.uningen.multiplication.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ChallengeServiceTest {
    private ChallengeService challengeService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private ChallengeAttemptRepository challengeAttemptRepository;

    @BeforeEach
    public void setUp(){
        challengeService = new ChallengeServiceImpl(
                userRepository, challengeAttemptRepository
        );
//        given(challengeAttemptRepository.save(any()))
//                .will(returnsFirstArg());
    }
    @Test
    public void checkCorrectAttemptTest(){
        // given
        given(challengeAttemptRepository.save(any()))
                .will(returnsFirstArg());
        ChallengeAttemptDTO attemptDTO =
                new ChallengeAttemptDTO(50, 60, "john_doe", 3000);
        // when
        ChallengeAttempt resultAttempt =
                challengeService.verifyAttempt(attemptDTO);
        // then
        then(resultAttempt.isCorrect()).isTrue();

        verify(userRepository).save(new AppUser("john_doe"));
        verify(challengeAttemptRepository).save(resultAttempt);
    }

    @Test
    public void checkExistingUserTest(){
        // given
        AppUser existingAppUser = new AppUser("john_doe");
        given(challengeAttemptRepository.save(any()))
                .will(returnsFirstArg());
        given(userRepository.findByAlias("john_doe"))
                .willReturn(Optional.of(existingAppUser));
        ChallengeAttemptDTO attemptDTO =
                new ChallengeAttemptDTO(50, 60, "john_doe", 5000);

        // when
        ChallengeAttempt resultAttempt =
                challengeService.verifyAttempt(attemptDTO);

        // then
        then(resultAttempt.isCorrect()).isFalse();
        then(resultAttempt).isEqualTo(existingAppUser);
        verify(userRepository, never()).save(any());
        verify(challengeAttemptRepository).save(resultAttempt);
    }

    @Test
    public void checkWrongAttemptTest(){
        // given
        given(challengeAttemptRepository.save(any()))
                .will(returnsFirstArg());
        ChallengeAttemptDTO attemptDTO =
                new ChallengeAttemptDTO(50, 60, "john_doe", 5000);
        // when
        ChallengeAttempt resultAttempt =
                challengeService.verifyAttempt(attemptDTO);
        // then
        then(resultAttempt.isCorrect()).isFalse();
        verify(userRepository).save(new AppUser("john_doe"));
        verify(challengeAttemptRepository).save(resultAttempt);
    }

    @Test
    public void retrieveStatsTest(){
        // given
        AppUser appUser = new AppUser("john_doe");
        ChallengeAttempt attempt1 = new ChallengeAttempt(1L, appUser, 50, 60, 3010, false);
        ChallengeAttempt attempt2 = new ChallengeAttempt(2L, appUser, 50, 60, 3051, false);
        List<ChallengeAttempt> lastAttempts = List.of(attempt1, attempt2);

        given(challengeAttemptRepository.findTop10ByAppUserAliasOrderByIdDesc("john_doe"))
                .willReturn(lastAttempts);

        // when
        List<ChallengeAttempt> latestAttemptsResult =
                challengeService.getStatsForUser("john_doe");

        // then
        then(latestAttemptsResult).isEqualTo(lastAttempts);
    }
}
