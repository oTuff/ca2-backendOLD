package dtos;

public class ChuckDTO {
    String id;
    String value;
    String url;

    public ChuckDTO(String id, String joke, String url) {
        this.id = id;
        this.value = joke;
        this.url = url;
    }

    public String getValue() {
        return value;
    }

    public String getSource() {
        return url;
    }
}
