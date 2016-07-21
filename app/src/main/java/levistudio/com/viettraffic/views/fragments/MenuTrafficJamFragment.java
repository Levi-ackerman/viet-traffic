package levistudio.com.viettraffic.views.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import levistudio.com.viettraffic.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuTrafficJamFragment extends Fragment {


    public MenuTrafficJamFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_traffic_jam, container, false);
    }

}
