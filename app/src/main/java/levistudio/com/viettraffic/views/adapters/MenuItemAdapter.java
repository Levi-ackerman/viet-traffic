package levistudio.com.viettraffic.views.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import levistudio.com.viettraffic.R;
import levistudio.com.viettraffic.views.adapters.viewholder.MenuItemViewHolder;
import levistudio.com.viettraffic.views.adapters.viewholder.OnMenuItemClickListener;


/**
 * Created by VyTK1 on 7/15/2016.
 */

public class MenuItemAdapter extends RecyclerView.Adapter<MenuItemViewHolder> {

    private OnMenuItemClickListener mOnMenuItemClickListener;

    public MenuItemAdapter(OnMenuItemClickListener onMenuItemClickListener) {
        mOnMenuItemClickListener = onMenuItemClickListener;
    }

    @Override
    public MenuItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item, parent,
                false);
        return new MenuItemViewHolder(view, mOnMenuItemClickListener);
    }

    @Override
    public void onBindViewHolder(MenuItemViewHolder holder, int position) {
        holder.bind();
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
