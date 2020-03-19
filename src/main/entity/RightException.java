package main.entity;

public class RightException extends Exception{
    RightException(String arg){
        System.err.println(arg);
        System.exit(0);
    }
}