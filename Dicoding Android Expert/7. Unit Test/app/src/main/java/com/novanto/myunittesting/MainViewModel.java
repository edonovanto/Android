package com.novanto.myunittesting;

public class MainViewModel {

    private final CubiodModel cubiodModel;

    MainViewModel(CubiodModel cubiodModel){
        this.cubiodModel = cubiodModel;
    }

    void save(double w, double h, double l){
        cubiodModel.save(w, h, l);
    }

    double getCircumference(){
        return cubiodModel.getCircumference();
    }

    double getVolume(){
        return cubiodModel.getVolume();
    }

    double getSurface(){
        return cubiodModel.getVolume();
    }
}
