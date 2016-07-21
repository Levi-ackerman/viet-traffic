package levistudio.com.viettraffic.common;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import levistudio.com.viettraffic.App;
import levistudio.com.viettraffic.R;

/**
 * Created by Levi on 7/14/2016.
 */

public class GlideUtils {

    public static void loadImage(String url, ImageView imageView) {
        Glide.with(App.getInstance())
                .load(url)
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }

    public static void loadImage(int imgId, ImageView imageView) {
        Glide.with(App.getInstance())
                .load(imgId)
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }
}
