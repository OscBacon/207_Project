package sample;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import controllers.Restaurant;

public class Controller {

    @FXML
    private ChoiceBox sampleID;

    @FXML
    private Button loginButton;


    public void init(Restaurant restaurant){
        sampleID.setItems(FXCollections.observableArrayList(restaurant.getWaiterNameList()));
        sampleID.getItems().addAll(restaurant.getWaiterNameList());

    }

    public boolean validLogin() {
        //If the user login button clicking is valid, you return true.
        return true;
    }



}
