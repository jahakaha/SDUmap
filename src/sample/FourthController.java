package sample;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

import static sample.Main.roomm;


public class FourthController {


    @FXML
    private Pane EDUCATION_4;

    @FXML
    private Pane BUSINESS_4;

    @FXML
    private Pane ENGINEERING_4;

    @FXML
    private Pane SOCIAL_4;

    @FXML
    private ImageView img;

    @FXML
    private ImageView img_zoom;

    @FXML
    private Pane pane_black;

    @FXML
    private JFXButton btn_main;




    @FXML
    void action_main(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(root, 590, 350);

        Stage stage = new Stage();
        stage.setTitle("SDU MAP");
        stage.setScene(scene);
        stage.getIcons().add(new Image("/res/icon.png"));
        stage.setResizable(false);
        stage.show();

        btn_main.getScene().getWindow().hide();

    }

    @FXML
    void initialize() {


        img_zoom.setOnMouseClicked(event -> {


            if (img_zoom.isVisible()) {
                img_zoom.setVisible(false);
                pane_black.setOpacity(0);
            }


        });


        getLocation(roomm, img);
    }





    private void getLocation (String room, ImageView img) {
        int index = 0;

        String def[] = ROOMS.fourth_floor_name;

        for (int i = 0; i < def.length; i++) {
            if (room.equals(def[i]))
                index = i;
        }

        int x = ROOMS.fourth_floor_x[index];
        int y = ROOMS.fourth_floor_y[index];

        img.setLayoutX(x);
        img.setLayoutY(y);

    }

    @FXML
    void onClicked(MouseEvent event) {
        Pane section = (Pane)event.getSource();

        img_zoom.setVisible(true);
        img_zoom.setImage(new Image("/res/map/" + section.getId() + ".jpg"));
        pane_black.setOpacity(0.7);
    }

}
