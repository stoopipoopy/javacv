package org.example.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

import java.io.ByteArrayInputStream;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class cameraController {

    @FXML
    private Button button;
    @FXML
    private CheckBox grayscale;
    @FXML
    private ImageView currentFrame;
    @FXML
    private CheckBox logo;

    private final VideoCapture capture = new VideoCapture(0);
    private ScheduledExecutorService timer;
    private Mat logoImage;
    @FXML
    protected void onCameraButtonClicked() {
        Runnable frameGrabber = new Runnable() {
            @Override
            public void run() {

            }
        };
        this.timer = Executors.newSingleThreadScheduledExecutor();
        this.timer.scheduleAtFixedRate(frameGrabber, 0, 33, TimeUnit.MILLISECONDS);
        if(this.capture.isOpened()) {

            Mat frame = new Mat();
            this.capture.read(frame);
            if(grayscale.isSelected()) {
                Imgproc.cvtColor(frame, frame, Imgproc.COLOR_RGB2GRAY);
            }
            MatOfByte buffer = new MatOfByte();
            Imgcodecs.imencode(".png", frame, buffer);
            currentFrame.setImage(new Image(new ByteArrayInputStream(buffer.toArray())));
        } else{
            System.out.println("Camera not opened");
        }
    }


    @FXML
    protected void onLogoEnabled(){
        if(logo.isSelected()) {
            this.logoImage = Imgcodecs.imread("/resources/org/example/javafx/images/0Artboard_53x.png");
        }
    }
}