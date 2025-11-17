package Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginPageFormController implements Initializable {
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
}
