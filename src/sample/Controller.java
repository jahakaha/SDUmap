package sample;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import static sample.Main.roomm;

public class Controller {

    @FXML
    private Pane pane_main;

    @FXML
    private JFXTextField text;

    @FXML
    private JFXButton btn_enter;

    private Parent root = null;

    private int floor_id = 1;



    @FXML
    void enter(ActionEvent event) throws IOException {


        roomm = room_name(text.getText());


        Parent root = FXMLLoader.load(getClass().getResource("first_floor.fxml"));
        switch (floor_id) {

            case 2:
                root = FXMLLoader.load(getClass().getResource("second_floor.fxml"));
                break;

            case 3:
                root = FXMLLoader.load(getClass().getResource("third_floor.fxml"));
                break;

            case 4:
                root = FXMLLoader.load(getClass().getResource("fourth_floor.fxml"));
                break;

            default:
                break;
        }


        Scene scene = new Scene(root);

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.getIcons().add(new Image("/res/icon.png"));
        stage.show();


        btn_enter.getScene().getWindow().hide();
    }

    @FXML
    void initialize() {

        text.setStyle("-fx-text-inner-color: #009fed;");
        text.textProperty().addListener((ov, oldValue, newValue) -> {
            text.setText(newValue.toUpperCase());
        });

    }

    
    
    private String room_name (String x) {


        if (x.contains("QUIT") || x.contains("Q"))
            System.exit(0);

        if (x.contains("LIBRARY")) {
            if (x.contains("1")) {
                x = "SCIENTIFIC LIBRARY";
            }
            if (x.contains("2")) {
                x = "READING ROOM";
            }
        }
        else if (x.contains("LECTURE ROOM"))
            x = "D205";

        else if (x.contains("COURTROOM")) {
            x = "D105";
        }

        else if (x.contains("DEPARTMENT")) {
            if (x.contains("IT"))
                x =  "D107";
            else if (x.contains("MAINTENANCE"))
                x =  "B203";
            else if (x.contains("PR") || x.contains("MARKETING"))
                x =  "B202";
        }

        else if (x.contains("SERVICE CENTER")) {
            x =  "D109";
        }

        else if (x.contains("LAB")) {
            if(x.contains("PHIL")) x = "E108";
            else if(x.contains("LAW")) x = "D108";
            else if(x.contains("EN3")) x = "F105";
            else if(x.contains("EN2")) x = "F107";
            else if(x.contains("EN1")) x = "F108";
            else if(x.contains("ECO")) x = "G108";
            else if (x.contains("CHIP")) x = "F205";
            else if (x.contains("PHYS")) x = "F305";
            else if(x.contains("CHEMISTRY")) x = "G114";
            else if(x.contains("BIOLOGY")) x = "E2";
        }


        else if (x.contains("DEANERY")) {
            if(x.contains("SOCIAL")) x = "DEANERY SOCIAL";
            else if(x.contains("EDUCATION")) x = "DEANERY EDUCATION";
            else if(x.contains("ENGINEERING")) x = "DEANERY ENGINEERING";
            else if(x.contains("BUSINESS")) x = "DEANERY BUSINESS";
        }

        else if (x.contains("S1") || x.contains("SDU MEDIA")) {
            x = "G219";
        }
        else if (x.contains("S2")) {
            x = "G218";
        }


        else if (x.contains("INTERNATIONAL RELATIONS")) {
            x =  "E109";
        }

        else if (x.contains("D118") || x.contains("D117")) {
            x =  "A1";
        }
        else if (x.contains("D116") || x.contains("D115")) {
            x =  "B1";
        }
        else if (x.contains("D114") || x.contains("D113")) {
            x =  "C1";
        }
        else if (x.contains("E116") || x.contains("E117")) {
            x =  "D1";
        }
        else if (x.contains("D218") || x.contains("D219")) {
            x =  "A2";
        }
        else if (x.contains("D216") || x.contains("D217")) {
            x =  "B2";
        }
        else if (x.contains("D214") || x.contains("D215")) {
            x +=  "C2";
        }
        else if (x.contains("E221") || x.contains("E220")) {
            x =  "D2";
        }
        else if (x.contains("MED") || x.contains("+") || x.contains("MEDIC") || x.contains("DOCTOR")) {
            x =  "CLINIC";
        }

        // floor check
        for (int i = 0; i < ROOMS.first_floor_room.length; i++) {
            if (x.contains(ROOMS.first_floor_room[i])) {
                floor_id = 1;
                return ROOMS.first_floor_room[i];
            }
        }
        for (int i = 0; i < ROOMS.second_floor_name.length; i++) {
            if (x.contains(ROOMS.second_floor_name[i])) {
                floor_id = 2;
                return ROOMS.second_floor_name[i];
            }
        }
        for (int i = 0; i < ROOMS.third_floor_name.length; i++) {
            if (x.contains(ROOMS.third_floor_name[i])) {
                floor_id = 3;
                return ROOMS.third_floor_name[i];
            }
        }
        for (int i = 0; i < ROOMS.fourth_floor_name.length; i++) {
            if (x.contains(ROOMS.fourth_floor_name[i])) {
                floor_id = 4;
                return ROOMS.fourth_floor_name[i];
            }
        }


        return ROOMS.first_floor_room[0];
    }





}
