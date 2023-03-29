package view;

import model.Cell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class View {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public void printStatus(Cell[][] cells){
        for(int i = 0; i<cells.length; i++){
            System.out.println();
            for(int j = 0; j < cells[i].length; j++){
                System.out.print("|");
                cells[i][j].print();
                System.out.print("|");
            }
        }
    }


    public void greeting(){
        System.out.println("Добро пожаловать в наш заповедник! Прочитайте, пожалуйста, несколько правил перед посещением:\n"+
                "1. Зверей не кормить, они прекрасно кушают сами\n"+
                "2. Зверей не трогать, перемещаются они тоже сами\n"+
                "3. Для симуляции хода просто нажмите enter\n"+
                "4. Если хотите завершить симуляцию - введите \"exit\"");
    }

    public int horizon() throws IOException {
        System.out.println("Введите ширину заповедника");
        return Integer.parseInt(bufferedReader.readLine());
    }

    public int vertical() throws IOException {
        System.out.println("Введите высоту заповедника");
        return Integer.parseInt(bufferedReader.readLine());
    }
    public void error(){
        System.out.println("Что - то пошло не так, мы вынужды завершить приложение");
    }

}

