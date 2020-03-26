package adapters_and_items;


import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class ShipmentItem {

    private static final int NO_IMAGE_PROVIDED = -1;  //TODO (Edit) put a customn photo

    private String product_name,countery_from,countery_to,profile_name,last_date;
    private double user_rate,reward,weight,items_number;
    private String product_image_url,profile_image_url;
    private int ImageId = NO_IMAGE_PROVIDED;


    // constructor
    public ShipmentItem(String prodimgUrl,double prodWeight,double itemsNum, String name, String from,String to,String date,
                        double money,String profUrl,String profName, double rate)
    {
        product_image_url=prodimgUrl;
        weight=prodWeight;
        items_number=itemsNum;
        product_name=name;
        countery_from=from;
        countery_to=to;
        last_date=date;
        reward=money;
        profile_image_url=profUrl;
        profile_name=profName;
        user_rate=rate;
    }

    //TODO (Edit)will return Bitmap
    public URL getProduct_image_url() {
        URL url = null;
        try {
            url = new URL(product_image_url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
    public String getWeight(){
        return  Double.toString(weight*items_number)+"Kg";
    }
    public String getProduct_name() {
        return product_name;
    }
    public String getCountery_from() {
        return countery_from;
    }
    public String getCountery_to() {
        return countery_to;
    }
    public String getProfile_name() {
        return profile_name;
    }
    public String getLast_date() {
        return last_date;
    }
    public float getUserRate() {
        return (float)user_rate;
    }
    public String getReward() {
        return "reward $"+Double.toString(reward);
    }
    //TODO (Edit)will return Bitmap
    public URL getProfile_image_url() {
        URL url = null;
        try {
            url = new URL(profile_image_url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }




    /*public boolean hasImage() {
        return ImageId != NO_IMAGE_PROVIDED;
    }*/

}