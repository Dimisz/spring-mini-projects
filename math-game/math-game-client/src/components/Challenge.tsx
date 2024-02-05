import { useEffect, useState } from 'react';
import ApiClient from '../api-client/ApiClient';

const initialState: Challenge = {
  a: 0,
  b: 0,
  user: '',
  message: '',
  guess: 0,
};

const ChallengeComponent = () => {
  const [challenge, setChallenge] = useState<Challenge>(initialState);

  const getNewChallenge: () => void = () => {
    ApiClient.challenge()
      .then((res) => res.json())
      .then((data) => {
        // console.log(data);
        setChallenge({
          ...challenge,
          a: data.factorA,
          b: data.factorB,
          message: '',
        });
      })
      .catch((er) =>
        setChallenge({
          ...challenge,
          message: er.message || 'Could not connect to server',
        })
      );
  };

  useEffect(() => {
    getNewChallenge();
  }, []);

  const handleChangeUsername: React.ChangeEventHandler<HTMLInputElement> = (
    event
  ): void => {
    if (event.target) {
      setChallenge({
        ...challenge,
        user: event.target.value,
      });
    }
  };

  const handleUserGuessChange: React.ChangeEventHandler<HTMLInputElement> = (
    event
  ) => {
    if (event.target) {
      setChallenge({
        ...challenge,
        guess: Number(event.target.value) || 0,
      });
    }
  };

  const handleSubmitResult = (event: React.SyntheticEvent) => {
    event.preventDefault();
    // console.log(challenge);
    ApiClient.sendGuess(challenge)
      .then((res) => res.json())
      .then((data) => {
        if (data.correct) {
          setChallenge({
            ...challenge,
            message: 'Congratulations! Your guess is correct!',
          });
        } else {
          setChallenge({
            ...challenge,
            message: `Oops! Your guess ${data.resultAttempt} is wrong. But keep playing!`,
          });
        }
      })
      .catch((er) =>
        setChallenge({
          ...challenge,
          message: er.message || 'Server error',
        })
      );
  };

  return (
    <div>
      <div>
        <h3>Your new challenge is</h3>
        <h1>
          {challenge.a} x {challenge.b}
        </h1>
      </div>
      <form onSubmit={handleSubmitResult}>
        <label>
          Your alias:
          <input
            type="text"
            maxLength={12}
            name="user"
            value={challenge.user}
            onChange={handleChangeUsername}
          />
        </label>
        <br />
        <label>
          Your Guess:
          <input
            type="number"
            min="0"
            name="guess"
            value={challenge.guess}
            onChange={handleUserGuessChange}
          />
        </label>
        <br />
        <button type="submit">Submit</button>
      </form>
      <h4>{challenge.message}</h4>
    </div>
  );
};

export default ChallengeComponent;
