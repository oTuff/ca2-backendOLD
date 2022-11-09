package dtos;

public class DadDTO {
    String id;
    String joke;

    public DadDTO() {
    }

    public DadDTO(String id, String joke) {
        this.id = id;
        this.joke = joke;
    }

    public String getJoke() {
        return joke;
    }
}
