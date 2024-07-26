package sample.currencycalculater;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.currencycalculater.Controllers.FirstController;
import sample.currencycalculater.Models.Model;
import sample.currencycalculater.Models.UpdateModel;

import java.io.IOException;

public class CurrencyCalculaterApp extends Application {
    FirstController controller;
    Model model;
    UpdateModel um;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CurrencyCalculaterApp.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 800);
        stage.setTitle("Currency Calculater");
        stage.setScene(scene);
        //hide close and minimize menu
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();

        model = new Model();
        um=new UpdateModel();
        controller = fxmlLoader.getController();
        controller.setModel(model);
        controller.setUpdateModel(um);
        controller.initModelValues();
    }
    public static void main(String[] args) {
        launch();
    }
}
