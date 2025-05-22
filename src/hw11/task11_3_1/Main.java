package hw11.task11_3_1;
public class Main {
    public static void main(String[] args) {
        String fileName = "youtubevideo.ogg";

        VideoFile videoFile = new VideoFile(fileName,
                new Buffer("Byte buffer of video"),
                new Buffer("Byte buffer of audio"));

        videoFile.play(new MPEG4CompressionCodec());

        VideoConversionFacade facade = new VideoConversionFacade();
        VideoFile convertedFile = facade.convert(videoFile, new MPEG4CompressionCodec());

        convertedFile.play(new MPEG4CompressionCodec());
    }
}