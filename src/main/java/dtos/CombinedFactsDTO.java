package dtos;

public class CombinedFactsDTO {
    String[] catFact;
    String[] dogFact;
    String catURL;
    String dogURL;

    public CombinedFactsDTO(CatfactDTO catfactDTO, DogfactDTO dogfactDTO) {
        this.catFact = catfactDTO.getData();
        this.dogFact = dogfactDTO.getFacts();
        this.catURL = catfactDTO.getUrl();
        this.dogURL = dogfactDTO.getUrl();
    }
}
