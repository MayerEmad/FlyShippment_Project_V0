package adapters_and_items;

import android.util.Log;

import com.example.flyshippment_project.R;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Repository
{
   private static String url_str="https://www.google.com/search?q=image+android+icon&rlz=1C1SQJL_enEG885EG886&sxsrf=ALeKk01Kp-pc61LA3u83kz3-fF67dMJ2uA:1585194208862&tbm=isch&source=iu&ictx=1&fir=sQrcLTHQuYfkcM%253A%252CW7hykagGRJvEtM%252C_&vet=1&usg=AI4_-kRbE8sjsGylf3q73oDjXTd2F4aclw&sa=X&ved=2ahUKEwis_N_NnLfoAhWgAWMBHeFYDoYQ9QEwAHoECAUQGg#imgrc=4XV1rXN4EKf2BM";

   /* String prodImage,profileImage;
    String prodName,counteryFrom,counteryTo,lastDate,profileName;
    double reward,weight,itemsNumber,rate;   */
    private static final List<ShipmentItem> ShipmentList = new ArrayList<ShipmentItem>() {{
        add(new ShipmentItem(url_str,8.40,5,"mobile","NewYork","Cairo","10/4/2020",
                            16.50,url_str,"Mayer Emad",3.5));
        add(new ShipmentItem(url_str,20.5,1,"bag","London","Alexandria","1/4/2020",
                            200.99,url_str,"Mero Gamed",2.5));
        add(new ShipmentItem(url_str,3.00,2,"Computer","Assuit","Tokyo","29/3/2020",
                             5.20,url_str,"7mada Mshakel",3.5));
    }};

    public static List<ShipmentItem> getShipments() {
        return ShipmentList;
    }

    private static final List<ShipmentItem> TripList = new ArrayList<ShipmentItem>() {{
        add(new ShipmentItem(url_str,8.40,5,"Trip1","Cairo","NewYork","10/4/2020",
                16.50,url_str,"Mayer Emad",3.5));
        add(new ShipmentItem(url_str,20.5,1,"Trip2","London","Alexandria","1/4/2020",
                200.99,url_str,"Mero Gamed",2.5));
        add(new ShipmentItem(url_str,3.00,2,"Trip3","Assuit","Tokyo","29/3/2020",
                5.20,url_str,"7mada Mshakel",3.5));
    }};

    public static List<ShipmentItem> getTrips() {
        return TripList;
    }
}

