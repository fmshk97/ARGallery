# AR Gallery
AR Gallery is an Android app and like gallery for photos and videos on a phone, AR Gallery is a gallery for 3D models. Model once uploaded in gallery can be rendered and viewed using phone's camera in live scene. AR Gallery also allow users to take photos of the rendered camera scene.
* Download APK and try out AR Gallery here: [ARGallery.v1.0.apk](https://drive.google.com/open?id=1LJcBocMHAqsB8dgVeRLFR2hEUYUI072T)
* **Note:** Not all Android devices support AR. Check out list of supported devices here: [Supported devices list](https://developers.google.com/ar/discover/supported-devices)
* After installing AR Gallery, you can download a sample model and try uploading in AR Gallery from here: [Sample Sceneform model](https://drive.google.com/open?id=1709ohy0XhYJca04T2D0Do6dEfOkIouWA)

## Features
1. Upload 3D Sceneform models (.sfb format) to AR Gallery
2. Models once uploaded will be stored in AR Gallery and can be accessed easily
3. Render uploaded 3D model in real time scene
4. Capture and save photo of rendered scene

## Limitations
Currently, AR Gallery support models only with **.sfb** extension. 
To convert .OBJ, .FBX, .glTF files to .sfb format using Sceneform plugin, follow this link: https://developers.google.com/ar/develop/java/sceneform/import-assets

## Technical details
* AR Gallery uses Google's [Sceneform SDK](https://developers.google.com/ar/develop/java/sceneform) to render Sceneform models (.sfb extension) in real time scene.
* AR Gallery is Sereverless. There is no server involved in the backend and hence, no internet required. Uploaded models are stored on the device itself under root directory in ARGallery folder.
* AR Gallery requires only Camera and Storage permissions.

## References
* Sceneform SDK overview: https://developers.google.com/ar/develop/java/sceneform
* Building Apps with Sceneform SDK tutorial: https://www.youtube.com/watch?v=jzaMMV6w_OE
* Introduction to Sceneform on Codelabs: https://codelabs.developers.google.com/codelabs/sceneform-intro
* Sample projects using Sceneform SDK (provided by Google): https://developers.google.com/ar/develop/java/sceneform/samples
