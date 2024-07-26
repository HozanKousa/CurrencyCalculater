package sample.currencycalculater.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.currencycalculater.Models.Model;
import sample.currencycalculater.Models.UpdateModel;

import java.net.URL;
import java.util.ResourceBundle;

public class UpdateController{
    @FXML
    private TextField euro,syrl, trl, mad, chf;
    UpdateModel updateModel;
    Model model ;
    Stage currentStage;
    public void setUpdateModel(UpdateModel updateModel) {
        this.updateModel = updateModel;
    }

    public void setCurrentStage(Stage currentStage) {
        this.currentStage = currentStage;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public UpdateModel getUpdateModel() {
        return updateModel;
    }

    public void update(){
        if (isValid(euro.getText())&&isValid(syrl.getText())&&isValid(trl.getText())&&isValid(mad.getText())&&
        isValid(chf.getText())){
            updateModel.setEuroToDollar(Double.parseDouble(euro.getText()));
            updateModel.setSyrlToDollar(Double.parseDouble(syrl.getText()));
            updateModel.setTrlToDollar(Double.parseDouble(trl.getText()));
            updateModel.setMadToDollar(Double.parseDouble(mad.getText()));
            updateModel.setChfToDollar(Double.parseDouble(chf.getText()));
            initModelValues();
            currentStage.close();


        }else{
            System.err.println("Somthing is wrong!");
        }
    }
    public boolean isValid(String content){
        try{
            Double.parseDouble(content);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public void exit(){
        currentStage.close();
    }
    public void initModelValues(){
        model.setEuroToDollar(updateModel.getEuroToDollar());
        model.setSyrlToDollar(updateModel.getSyrlToDollar());
        model.setTrlToDollar(updateModel.getTrlToDollar());
        model.setMadToDollar(updateModel.getMadToDollar());
        model.setChfToDollar(updateModel.getChfToDollar());
    }
    public void initTextFields(){

        euro.setText(String.format("%.4f", model.getEuroToDollar()).replace(',','.'));
        syrl.setText(String.format("%.4f", model.getSyrlToDollar()).replace(',','.'));
        trl.setText(String.format("%.4f", model.getTrlToDollar()).replace(',','.'));
        mad.setText(String.format("%.4f", model.getMadToDollar()).replace(',','.'));
        chf.setText(String.format("%.4f", model.getChfToDollar()).replace(',','.'));
    }
}
