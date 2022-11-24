package dtos;

public class DogfactDTO {

    private String[] facts;
    private String url = "https://dog-api.kinduff.com/api/facts";

    public DogfactDTO(String[] facts, String url) {
        this.facts = facts;
        this.url = url;
    }

    public DogfactDTO() {
    }

    public String[] getFacts() {
        return facts;
    }

    public void setFacts(String[] fact) {
        this.facts = fact;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
