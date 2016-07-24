package levistudio.com.viettraffic.views.activities;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import levistudio.com.viettraffic.R;
import levistudio.com.viettraffic.views.fragments.MenuItemFragment;

public class MainMenuActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_item);
        ButterKnife.bind(this);

        setupActionbar();
        startMenuItemFragment();
    }

    private void setupActionbar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Drawable icon = ContextCompat.getDrawable(MainMenuActivity.this, R.drawable.ic_close);
        mToolbar.setNavigationIcon(icon);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void startMenuItemFragment() {
        Fragment addPostFragment = new MenuItemFragment();
        replaceFragment(addPostFragment, true);
    }

    public void replaceFragment(Fragment fragment, boolean isAddToBackStack) {
        String tag = fragment.getClass().getSimpleName();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right);
        transaction.replace(R.id.container, fragment, tag);
        if (isAddToBackStack) {
            transaction.addToBackStack(tag);
        }
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();
        if (count == 0) {
            super.onBackPressed();
            //additional code
        } else {
            getSupportFragmentManager().popBackStack();
        }
    }
}
