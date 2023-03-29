package controller;

import model.Model;
import view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Controller {

    private static final BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

    private static final ExecutorService executors = Executors.newCachedThreadPool();

    private static final Model model = new Model();
    private static final View view = new View();


    public void execute() throws IOException, InterruptedException {
        view.greeting();
        try {
            int x = view.vertical();
            int y = view.horizon();
            model.createWorld(x,y);
        }
        catch (IOException e){
            view.error();
        }
        view.printStatus(model.getCells());

        while (true){
            String input = buff.readLine();
            if(input.equals("exit")){
                executors.shutdown();
                break;
            }
            executors.invokeAll(model.getMultiEatList());
            executors.invokeAll(model.getMultiMovs());
            view.printStatus(model.getCells());
        }

    }







}
