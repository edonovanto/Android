package com.novanto.myunittesting;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class MainViewModelTest {

    private MainViewModel mainViewModel;
    private CubiodModel cubiodModel;

    private final double dummyLength = 12.0;
    private final double dummyWidth = 7.0;
    private final double dummyHeight = 6.0;
    private final double dummyVolume = 504.0;
    private final double dummyCircum = 100.0;
    private final double dummySurface  = 396.0;

    @Before
    public void before(){
        cubiodModel = mock(CubiodModel.class);
        mainViewModel = new MainViewModel(cubiodModel);
    }

    @Test
    public void TestVolume(){
        cubiodModel = new CubiodModel();
        mainViewModel = new MainViewModel(cubiodModel);
        mainViewModel.save(dummyWidth,dummyHeight,dummyLength);
        double volume = mainViewModel.getVolume();
        assertEquals(dummyVolume,volume,0.0001);
    }

    @Test
    public void TestCircumference(){
        cubiodModel = new CubiodModel();
        mainViewModel = new MainViewModel(cubiodModel);
        mainViewModel.save(dummyWidth,dummyHeight,dummyLength);
        double circumference = mainViewModel.getCircumference();
        assertEquals(dummyCircum,circumference,0.0001);
    }

    @Test
    public void tesSurfaceArea() {
        cubiodModel = new CubiodModel();
        mainViewModel = new MainViewModel(cubiodModel);
        mainViewModel.save(dummyWidth, dummyLength, dummyHeight);
        double surface = mainViewModel.getSurface();
        assertEquals(dummySurface, surface, 0.0001);
    }

    @Test
    public void save() {
    }

    @Test
    public void getCircumference() {
    }

    @Test
    public void getVolume() {
    }

    @Test
    public void getSurface() {
    }
}