package levistudio.com.viettraffic.views.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import levistudio.com.viettraffic.R;

/**
 * Created by Levi on 7/20/2016.
 */

public class CustomTableLayout extends ViewGroup {
    private static final String TAG = "CustomTableLayout";

    private int column;
    private int row;

    public CustomTableLayout(Context context) {
        super(context);
    }

    public CustomTableLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CustomTableLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        Log.d(TAG, "init");
        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomTableLayout, 0, 0);
            try {
                this.row = typedArray.getInt(R.styleable.CustomTableLayout_row, 0);
                this.column = typedArray.getInt(R.styleable.CustomTableLayout_column, 0);
            } finally {
                typedArray.recycle();
            }
        }
    }

    @Override
    protected void onLayout(boolean b, int left, int top, int right, int bottom) {
        if (row <= 0 || column <= 0) {
            return;
        }
        int numOfItem = row * column;
        int width = right - left;
        int height = bottom - top;
        int withPerItem = width/column;
        int heightPerItem = height/row;

        View view;
        for (int i = 0, m = 0, n = 0; i < numOfItem; i++) {
            view = getChildAt(i);
            if(i != 0 && i % column == 0){
                m = 0;
                n++;
            }
            view.layout(m*withPerItem, n*heightPerItem, (m + 1)*withPerItem, (n + 1)*heightPerItem);
            m++;
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int realWidth = getMeasuredWidth();
        int realHeight = getMeasuredHeight();

        int wSpec = MeasureSpec.makeMeasureSpec(realWidth / column, MeasureSpec.EXACTLY);
        int hSpec = MeasureSpec.makeMeasureSpec(realHeight / row, MeasureSpec.EXACTLY);

        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() == View.GONE) {
                continue;
            }

            child.measure(wSpec, hSpec);
        }

    }
}
