package cis642.aphidcounter.util;

import android.graphics.Bitmap;
import android.util.Log;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by japshvincent on 12/2/2014.
 */
public class AphidCounter {
    private Mat processedImage;

    public AphidCounter(Mat processedImage){
        setProcessedImage(processedImage);
    }
    public void setProcessedImage(Mat processedImage){
        this.processedImage = processedImage;
    }
    public Mat getProcessedImage(){
        return processedImage;
    }
    public int countAphid(){
        if(processedImage == null){
            return 0;
        }
        Mat hierarchy = processedImage.clone();
        Imgproc.findContours ( processedImage, contours, hierarchy, Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_SIMPLE );

        return contours.size();
    }
    private  List<MatOfPoint> contours = new ArrayList<MatOfPoint>();

}
