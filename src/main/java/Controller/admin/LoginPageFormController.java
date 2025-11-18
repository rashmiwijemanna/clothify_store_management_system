package Controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginPageFormController implements Initializable {
    Stage stage=new Stage();
    @FXML
    private MediaView mediaView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        String videoPath=getClass().getResource("/image/loginanimate.mp4").toExternalForm();

        Media media=new Media(videoPath);
        MediaPlayer mediaPlayer=new MediaPlayer(media);

        mediaPlayer.setOnReady(() -> {
            mediaView.setMediaPlayer(mediaPlayer);
            mediaPlayer.play();
        });

        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

        mediaView.setMediaPlayer(mediaPlayer);
        mediaView.setPreserveRatio(true);


    }



    public void loginBtn(ActionEvent actionEvent) {
    }

    public void loginBtnEmployee(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/LoginEmp.fxml"))));
        stage.show();

    }
}
