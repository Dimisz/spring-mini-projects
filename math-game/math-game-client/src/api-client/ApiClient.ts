class ApiClient {
  static SERVER_URL = "http://localhost:8080";
  static GET_CHALLENGE = "/challenges/random";
  static POST_RESULT = "/attempts";
  static challenge(): Promise<Response> {
    return fetch(ApiClient.SERVER_URL + ApiClient.GET_CHALLENGE);
  }
  static sendGuess(user: User): Promise<Response> {
    return fetch(ApiClient.SERVER_URL + ApiClient.POST_RESULT,
      {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(
          {
            userAlias: user.user,
            factorA: user.a,
            factorB: user.b,
            guess: user.guess
          }
        )
      });
  }
}

export default ApiClient;