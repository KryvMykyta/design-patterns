package hw11.task11_3_1;
/**
 * Кодек для стиснення відео формату MPEG4
 */
public class MPEG4CompressionCodec implements Codec {

    @Override
    public String type() {
        return "mp4";
    }
}
