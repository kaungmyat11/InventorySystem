package inventorySystem.view;

import javafx.stage.Stage;

import java.util.ArrayList;

public class ViewFactory {

    private ArrayList<Stage> activeStages;

    public ViewFactory() {
        activeStages = new ArrayList<Stage>();
    }

    public void showLoginWindow() {
        System.out.println("Display Login Window");


    }
}
