import cv2

face_cascade = cv2.CascadeClassifier('classifier.xml')

img = cv2.imread('path_to_file')

faces = face_cascade.detectMultiScale(img, 1.1, 4)

for (x, y, w, h) in faces:
    cv2.rectangle(img, (x, y), (x + w, y + h), (255, 0, 0), 2)

cv2.imwrite('path_to_new_image', img)
