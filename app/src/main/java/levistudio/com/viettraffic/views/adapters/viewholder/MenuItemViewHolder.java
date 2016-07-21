package levistudio.com.viettraffic.views.adapters.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;

/**
 * Created by VyTK1 on 7/15/2016.
 */

public class MenuItemViewHolder extends RecyclerView.ViewHolder {

    private OnMenuItemClickListener mOnMenuItemClickListener;

    public MenuItemViewHolder(View itemView, OnMenuItemClickListener onMenuItemClickListener) {
        super(itemView);
        this.mOnMenuItemClickListener = onMenuItemClickListener;
    }

    public void bind(){
       itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               mOnMenuItemClickListener.onItemClick();
           }
       });

        /*Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new DecelerateInterpolator()); //add this
        fadeIn.setDuration(1000);
        itemView.setAnimation(fadeIn);*/
    }
}
