package com.universitybullshit;

//import com.universitybullshit.controller.HabitatController;
//import com.universitybullshit.model.Habitat;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

import com.universitybullshit.view.MainFrame;
public class Main {
    public static void main(String[] args) {
        MainFrame.mainMenu();
        ForkJoinPool.commonPool().awaitQuiescence(5, TimeUnit.SECONDS);
    }
}