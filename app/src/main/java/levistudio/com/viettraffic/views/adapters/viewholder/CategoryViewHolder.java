package levistudio.com.viettraffic.views.adapters.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import levistudio.com.viettraffic.R;

/**
 * Created by Levi on 7/14/2016.
 */

public class CategoryViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.text_title)
    TextView textTitle;

    public CategoryViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(int position, String title){
        textTitle.setText(title);
    }
}
