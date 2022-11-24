package dtos;

public class CatfactDTO {

    private String[] data;
    private String url = "https://meowfacts.herokuapp.com/";

    public CatfactDTO(String[] data, String url) {
        this.data = data;
        this.url = url;
    }

    public CatfactDTO() {
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
