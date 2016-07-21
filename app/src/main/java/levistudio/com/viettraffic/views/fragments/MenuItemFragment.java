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


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuItemFragment extends Fragment {

    //private RecyclerView mMenuItemRecycler;

    //private MenuItemAdapter mMenuItemAdapter;
    //private GridLayoutManager mGridLayoutManager;
    @BindView(R.id.view_item_1)
    View mViewItem1;

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
        mViewItem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainMenuActivity activity = (MainMenuActivity)getActivity();
                MenuTrafficJamFragment fragment = new MenuTrafficJamFragment();
                activity.replaceFragment(fragment, true);
            }
        });
    }

    /*private void setupRecyclerView(View view) {
        mMenuItemRecycler = (RecyclerView) view.findViewById(R.id.recycler_menu_item);
        mGridLayoutManager = new GridLayoutManager(getActivity(),2);
        mMenuItemRecycler.setLayoutManager(mGridLayoutManager);
        mMenuItemRecycler.addItemDecoration(new SimpleDividerItemDecoration(getActivity(), 16));
        mMenuItemRecycler.setAlpha(0);

        mMenuItemAdapter = new MenuItemAdapter(this);
        mMenuItemRecycler.setAdapter(mMenuItemAdapter);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                int startPos = mGridLayoutManager.findFirstVisibleItemPosition();
                int endPos = mGridLayoutManager.findLastVisibleItemPosition();
                View itemView;
                for(int i = startPos; i <= endPos; i++){
                    itemView = mMenuItemRecycler.findViewHolderForAdapterPosition(i).itemView;
                    itemView.setAlpha(0);
                    // Setting animations: slide and alpha 0 to 1
                    PropertyValuesHolder slide = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, 150, 0);
                    PropertyValuesHolder alpha = PropertyValuesHolder.ofFloat(View.ALPHA, 0, 1);
                    ObjectAnimator a = ObjectAnimator.ofPropertyValuesHolder(itemView, slide, alpha);
                    a.setDuration(300);
                    // It will set delay. As loop progress it will increment
                    // And it will look like items are appearing one by one.
                    // Not all at a time
                    a.setStartDelay(i * 200);
                    a.setInterpolator(new DecelerateInterpolator());
                    a.start();
                }
                mMenuItemRecycler.setAlpha(1);
            }
        }, 50);
    }*/

}
