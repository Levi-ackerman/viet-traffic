package levistudio.com.viettraffic.views.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import levistudio.com.viettraffic.R;

/**
 * Created by Levi on 7/24/2016.
 */

public class MenuItem extends LinearLayout {
    private static final String TAG = "MenuItem";

    private ImageView imgIcon;
    private TextView textTitle;

    public MenuItem(Context context) {
        super(context);
    }

    public MenuItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public MenuItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        Log.d(TAG, "init");
        inflate(context, R.layout.menu_item, this);
        imgIcon = (ImageView) findViewById(R.id.img_icon);
        textTitle = (TextView) findViewById(R.id.text_title);
        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MenuItem);
            try {
                int drawableId = typedArray.getResourceId(R.styleable.MenuItem_iconId, 0);
                String title = typedArray.getString(R.styleable.MenuItem_title);
                int iconWidth = (int)typedArray.getDimension(R.styleable.MenuItem_iconWidth, 0);
                int iconHeight = (int)typedArray.getDimension(R.styleable.MenuItem_iconHeight, 0);
                if(drawableId > 0){
                    imgIcon.setImageResource(drawableId);
                    if(iconWidth > 0 && iconHeight > 0){
                        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)
                                imgIcon .getLayoutParams();
                        params.width = iconWidth;
                        params.height = iconHeight;
                        imgIcon.setLayoutParams(params);
                    }
                }
                if(title != null){
                    textTitle.setText(title);
                }
            } finally {
                typedArray.recycle();
            }
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
