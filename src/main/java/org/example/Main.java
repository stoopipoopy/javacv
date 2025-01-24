package org.example;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.opencv.opencv_java;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.osgi.OpenCVInterface;

public class Main {
    public static void main(String[] args) {
        Loader.load(opencv_java.class);
        Mat mat = Mat.eye(3,3, CvType.CV_8UC1);
        System.out.println(mat.dump());
    }
}