package adapters_and_items;


public class ShipmentItem {

    private String str;
    private int ImageId = NO_IMAGE_PROVIDED;

    /**
     * Constant value that represents no image was provided for this word
     */
    private static final int NO_IMAGE_PROVIDED = -1;

    // constructor
    public ShipmentItem(String x, int imageid) {
        ImageId=imageid;
        str=x;
    }

    // To Print -> alt+insert
    /*@Override
    public String toString() {
        return "Word{" +
                "EnglishTranslation='" + EnglishTranslation + '\'' +
                ", MiwokTranslation='" + MiwokTranslation + '\'' +
                ", ImageId=" + ImageId +
                ", mAudioResourceId=" + mAudioResourceId +
                '}';
    }*/

    // Get the default translation of the word.
    public String getstr() {
        return str;
    }

    public int getImageId() { return ImageId; }

    public boolean hasImage() {
        return ImageId != NO_IMAGE_PROVIDED;
    }

}