package levistudio.com.viettraffic.views.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import levistudio.com.viettraffic.R;
import levistudio.com.viettraffic.views.adapters.viewholder.CategoryViewHolder;

/**
 * Created by Levi on 7/14/2016.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {

    private String[] mCategoryList;
    private int[] mCategoryIconList = new int[]{
            R.drawable.ic_traffic_jam,
            R.drawable.ic_police,
            R.drawable.ic_accident,
            R.drawable.ic_traffic_jam,
            R.drawable.ic_police,
            R.drawable.ic_accident,
            R.drawable.ic_traffic_jam,
            R.drawable.ic_police,
            R.drawable.ic_accident
    };

    public CategoryAdapter(Context context) {
        mCategoryList = context.getResources().getStringArray(R.array.list_post_category);
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item_layout, parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        String title = mCategoryList[position];
        holder.bind(position, title);
    }

    @Override
    public int getItemCount() {
        return 9;
    }
}
