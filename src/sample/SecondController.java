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


public class SecondController {


    @FXML
    private Pane RED_HALL_2;

    @FXML
    private Pane EXIT_2;

    @FXML
    private Pane BOCHKA_2;

    @FXML
    private Pane SOCIAL_2;

    @FXML
    private Pane EDUCATION_2;

    @FXML
    private Pane ENGINEERING_2;

    @FXML
    private Pane BUSINESS_2;

    @FXML
    private Pane RED_CATERING_2;

    @FXML
    private Pane E_2;

    @FXML
    private Pane AC_CATERING_2;

    @FXML
    private ImageView img;

    @FXML
    private Pane pane_black;

    @FXML
    private ImageView img_zoom;

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

        String def[] = ROOMS.second_floor_name;

        for (int i = 0; i < def.length; i++) {
            if (room.equals(def[i]))
                index = i;
        }

        int x = ROOMS.second_floor_x[index];
        int y = ROOMS.second_floor_y[index];

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
