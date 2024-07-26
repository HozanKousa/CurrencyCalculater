module sample.currencycalculater {
    requires javafx.controls;
    requires javafx.fxml;


    opens sample.currencycalculater to javafx.fxml;
    exports sample.currencycalculater;
    exports sample.currencycalculater.Controllers;
    opens sample.currencycalculater.Controllers to javafx.fxml;
    exports sample.currencycalculater.Models;
    opens sample.currencycalculater.Models to javafx.fxml;
}