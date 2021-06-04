package com.nobel.backwardsClock.Threads;

import com.nobel.backwardsClock.Exceptions.AppException;

import java.util.Scanner;

public class InterruptThread extends Thread {
    public void run() {
        try{
            System.out.println("Press Enter to stop clock");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
        } catch(AppException e){
            e.getMessage();
        }

    }
}
