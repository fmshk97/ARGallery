# AR Gallery
AR Gallery is an Android app and like gallery for photos and videos on a phone, AR Gallery is a gallery for 3D models. It allows user to create collection of 3D object models by uploading them to AR Gallery. Any 3d model in collection can then be viewed in augmented reality on an Android device. It also allow users to take photos of the augmented scene.
* Sounds cool? Download APK and try out AR Gallery here: [ARGallery.v1.0.apk](https://drive.google.com/open?id=11NzOHwf0gIdtf0TZcBSydyvK0n4JYMLb)
* **Note:** Not all Android devices support AR. Check out list of supported devices here: [Supported devices list](https://developers.google.com/ar/discover/supported-devices)
* After installing AR Gallery, you can download a sample model and try uploading in AR Gallery from here: [Sample Sceneform model](https://github.com/fmshk97/ARGallery/tree/master/sample_models)

## Features
* Create a collection of 3D models by uploading them to AR Gallery
* View any 3D model from the collection in augmented reality
* Capture and save photo of augmented scene

## Limitations
* Currently, AR Gallery support models only with **.sfb** extension. However, .OBJ, .FBX, .glTF files can be converted to .sfb format using Sceneform plugin. More here: [Importing Sceneform assets](https://developers.google.com/ar/develop/java/sceneform/import-assets)
* Only one model can be rendered at a time.

## Technical details
* AR Gallery uses Google's [Sceneform SDK](https://developers.google.com/ar/develop/java/sceneform) to render Sceneform models (.sfb extension) in real time scene.
* AR Gallery is Serverless. There is no server involved in the backend and hence, no internet required. Uploaded models are stored on the device itself under root directory in ARGallery folder.
* AR Gallery requires only Camera and Storage permissions.

## References
* Sceneform SDK overview: https://developers.google.com/ar/develop/java/sceneform
* Building Apps with Sceneform SDK tutorial: https://www.youtube.com/watch?v=jzaMMV6w_OE
* Introduction to Sceneform on Codelabs: https://codelabs.developers.google.com/codelabs/sceneform-intro
* Sample projects using Sceneform SDK (provided by Google): https://developers.google.com/ar/develop/java/sceneform/samples

## Screenshot
![AR Gallery](https://github.com/fmshk97/ARGallery/blob/master/Screenshots/01.jpg)    ![Model Upload](https://github.com/fmshk97/ARGallery/blob/master/Screenshots/04.jpg)

![AR Session](https://github.com/fmshk97/ARGallery/blob/master/Screenshots/05.jpg)
