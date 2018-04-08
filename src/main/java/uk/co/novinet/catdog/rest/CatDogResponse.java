package uk.co.novinet.catdog.rest;

public class CatDogResponse {
    private double certainty;
    private String classification;

    public CatDogResponse(double certainty, String classification) {
        this.certainty = certainty;
        this.classification = classification;
    }

    public double getCertainty() {
        return certainty;
    }

    public void setCertainty(double certainty) {
        this.certainty = certainty;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }
}
