package dtos;

public class CombinedJokeDTO {
    String joke1;
    String source1 = "https://api.chucknorris.io/jokes/random";
    String joke2;
    String source2 = "https://icanhazdadjoke.com";

    public CombinedJokeDTO(ChuckDTO chuckDTO, DadDTO dadDTO) {
        this.joke1 = chuckDTO.getValue();
        this.joke2 = dadDTO.getJoke();
    }
}
