package com.uningen.multiplication.challenge;

import com.uningen.multiplication.user.AppUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChallengeAttempt {
    /**
     * Identifies the attempt from  a {@link AppUser} to solve a challenge
     */
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "APP_USER_ID")
    private AppUser appUser;
    private int factorA;
    private int factorB;
    private int guess;
    private boolean correct;
}
