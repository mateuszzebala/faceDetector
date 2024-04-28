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
        CascadeClassifier classifier = new CascadeClassifier(xmlFile);

        MatOfRect faceDetections = new MatOfRect();
        classifier.detectMultiScale(src, faceDetections);

        System.out.printf("Detected %s faces", faceDetections.toArray().length);

        for (Rect rect : faceDetections.toArray()) {
            Imgproc.rectangle(
                src,
                new Point(rect.x, rect.y),
                new Point(rect.x + rect.width, rect.y + rect.height),
                new Scalar(0, 0, 255),
                3
            );
        }

        Imgcodecs.imwrite("path_to_new_image", src);

    }
}
