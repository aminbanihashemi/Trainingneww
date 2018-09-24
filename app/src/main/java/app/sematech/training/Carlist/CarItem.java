package app.sematech.training.Carlist;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created by abanihashemi on 8/5/2018.
 */

public class CarItem implements Serializable {

    private String cName;
    private String cModel;
    private String cColor;
    private int cImage;

    public CarItem(String cName, String cModel, String cColor,int cImage) {

        this.cName = cName;
        this.cModel = cModel;
        this.cColor = cColor;
        this.cImage = cImage;
    }

    public int getcImage() {
        return cImage;
    }

    public void setcImage(int cImage) {
        this.cImage = cImage;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcModel() {
        return cModel;
    }

    public void setcModel(String cModel) {
        this.cModel = cModel;
    }

    public String getcColor() {
        return cColor;
    }

    public void setcColor(String cColor) {
        this.cColor = cColor;
    }
}
