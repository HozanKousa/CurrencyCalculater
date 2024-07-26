package sample.currencycalculater.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.currencycalculater.CurrencyCalculaterApp;
import sample.currencycalculater.Models.Model;
import sample.currencycalculater.Models.UpdateModel;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class FirstController implements Initializable {
    private ObservableList<String> listOfCurrencies = FXCollections.observableArrayList("$","€","SYRL","TRL", "MAD","CHF");
    @FXML
    private TextField firstField, secondField;
    @FXML
    private ComboBox first, second;
    DecimalFormat formatter= new DecimalFormat("0.00");
    Model model;
    UpdateModel updateModel;

    public void setModel(Model model) {
        this.model = model;
    }

    public void setUpdateModel(UpdateModel updateModel) {
        this.updateModel = updateModel;
    }

    public Model getModel() {
        return model;
    }

    public void calculate(){
       if (isNumber()){
           initModel();
           model.calculate();
           initView();
       }
    }

    public void reset(){
        model.reset();
        initView();
    }

    private void initView(){
        firstField.setText(model.getAmount()+"");
        secondField.setText(formatter.format(model.getResult()));
        first.setValue(model.getFirst());
        second.setValue(model.getSecond());
    }
    private void initModel(){
        model.setAmount(Double.parseDouble(firstField.getText()));
        model.setFirst(first.getValue().toString());
        model.setSecond(second.getValue().toString());
    }

    public boolean isNumber(){
        try{
            Double.parseDouble(firstField.getText());
            return true;
        }catch (Exception e){
            System.err.println("Invalid input");
            return false;
        }
    }

    public void close(){
        javafx.application.Platform.exit();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        first.setItems(listOfCurrencies);
        second.setItems(listOfCurrencies);
        first.setValue(listOfCurrencies.get(0));
        second.setValue(listOfCurrencies.get(1));
        firstField.setPromptText("0.0");
        secondField.setPromptText("0.0");
    }
    public void update() throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(CurrencyCalculaterApp.class.getResource("update-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450,600);
        Stage stage = new Stage();
        stage.setTitle("Update Currencies");
        stage.setScene(scene);
        stage.show();


        UpdateController updateController = fxmlLoader.getController();
        updateController.setUpdateModel(updateModel);
        updateController.setCurrentStage(stage);
        updateController.setModel(model);
        updateController.initTextFields();
    }
    public void initModelValues(){
        model.setEuroToDollar(updateModel.getEuroToDollar());
        model.setSyrlToDollar(updateModel.getSyrlToDollar());
        model.setTrlToDollar(updateModel.getTrlToDollar());
        model.setMadToDollar(updateModel.getMadToDollar());
        model.setChfToDollar(updateModel.getChfToDollar());
    }
}
