package levistudio.com.viettraffic.views.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import levistudio.com.viettraffic.R;
import levistudio.com.viettraffic.views.activities.MainMenuActivity;
import levistudio.com.viettraffic.views.ui.MenuItem;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuItemFragment extends Fragment {

    //private RecyclerView mMenuItemRecycler;

    //private MenuItemAdapter mMenuItemAdapter;
    //private GridLayoutManager mGridLayoutManager;
    @BindView(R.id.item_traffic_jam)
    MenuItem mItemTrafficJam;

    public MenuItemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu_item, container, false);
        ButterKnife.bind(this, view);
        initEvent();
        //setupRecyclerView(view);
        return view;
    }

    private void initEvent() {
        mItemTrafficJam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainMenuActivity activity = (MainMenuActivity)getActivity();
                MenuTrafficJamFragment fragment = new MenuTrafficJamFragment();
                activity.replaceFragment(fragment, true);
            }
        });
    }

}
