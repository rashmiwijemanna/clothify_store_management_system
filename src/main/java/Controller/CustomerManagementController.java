package Controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerManagementController implements Initializable {


    @FXML
    private MediaView mediaView;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String videoPath=getClass().getResource("/image/CLOTHIFY.mp4").toExternalForm();

        Media media=new Media(videoPath);
        MediaPlayer mediaPlayer=new MediaPlayer(media);


        mediaPlayer.setOnReady(() -> {
            mediaView.setMediaPlayer(mediaPlayer);
            mediaPlayer.play();
        });

        mediaPlayer.setAutoPlay(true);
//        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaView.setMediaPlayer(mediaPlayer);
//        mediaView.setPreserveRatio(true);
//
//        // Bind MediaView after scene is loaded to avoid null parent
//        mediaView.sceneProperty().addListener((obs, oldScene, newScene) -> {
//            if (newScene != null) {
//                mediaView.fitWidthProperty().bind(newScene.widthProperty());
//                mediaView.fitHeightProperty().bind(newScene.heightProperty());
//            }
//        });

    }



    @FXML
    private JFXTextField cusAddress;

    @FXML
    private JFXTextField cusCity;

    @FXML
    private DatePicker cusDOB;

    @FXML
    private JFXTextField cusId;

    @FXML
    private JFXTextField cusName;

    @FXML
    private JFXTextField cusPostal;

    @FXML
    private JFXTextField cusProvince;

    @FXML
    private JFXTextField cusSalary;

    @FXML
    private JFXComboBox<?> cusTitle;

    @FXML
    void addBtn(ActionEvent event) {

    }

}
