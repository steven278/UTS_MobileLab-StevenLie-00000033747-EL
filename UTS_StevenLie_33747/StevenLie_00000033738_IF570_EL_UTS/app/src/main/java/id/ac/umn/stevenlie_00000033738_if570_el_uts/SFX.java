package id.ac.umn.stevenlie_00000033738_if570_el_uts;

import java.io.Serializable;
import android.net.Uri;

public class SFX implements Serializable {
    private String title;
    private String genre;
//    private int photo;
    private String audioURI;

    public SFX(String title, String genre, String audioURI) {
        this.title = title;
        this.genre = genre;
        this.audioURI = audioURI;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

//    public int getPhoto() {
//        return photo;
//    }

//    public void setPhoto(int photo) {
//        this.photo = photo;
//    }

    public void setAudioURI(String audioURI){
        this.audioURI = audioURI;
    }
    public String getAudioURI(){
        return this.audioURI;
    }
}
