package main.entity;

import java.io.IOException;

public class WrongPersonException extends IOException {
    WrongPersonException(String line){
        System.err.println("Данные внутри "+line+" в Person не соответствуют требованиям! Исправьте, пожалуйста, данное поле");
    }
}
