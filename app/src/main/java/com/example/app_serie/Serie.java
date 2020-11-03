package com.example.app_serie;

public class Serie {
    private String titre;
    private String resume;
    private String duree;
    private String premiereDiffusion;
    private String image;
    private long id;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getPremiereDiffusion() {
        return premiereDiffusion;
    }

    public void setPremiereDiffusion(String premiereDiffusion) {
        this.premiereDiffusion = premiereDiffusion;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Serie(String name, String resume, String duree, String premiereDiffusion, String image, long Id){
        this.titre =name;
        this.resume = resume;
        this.duree =duree;
        this.premiereDiffusion = premiereDiffusion;
        this.image = image;
        id=Id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
