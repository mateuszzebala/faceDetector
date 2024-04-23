import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class Main {
    public static void main(String[] args) {

        System.loadLibrary( Core.NATIVE_LIBRARY_NAME );

        String file ="path_to_image";
        Mat src = Imgcodecs.imread(file);
        String xmlFile = "classifier.xml";
        CascadeClassifier classifier = new CascadeClassifier(xmlFile); // create instance of cascade classifier

        MatOfRect faceDetections = new MatOfRect(); // create box for faces
        classifier.detectMultiScale(src, faceDetections); // detect faces and paste it into faceDetection

        System.out.printf("Detected %s faces", faceDetections.toArray().length); // print face count

        for (Rect rect : faceDetections.toArray()) { // loop over faces and draw rectangle on image
            Imgproc.rectangle(
                src, // where to draw the box
                new Point(rect.x, rect.y), // bottom left position
                new Point(rect.x + rect.width, rect.y + rect.height), // top right position
                new Scalar(0, 0, 255), // RGB
                3 // thickness
            );
        }

        Imgcodecs.imwrite("path_to_new_image", src); // save new image

    }
}