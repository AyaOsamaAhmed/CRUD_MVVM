package crud.aya.test.com.Fragment;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import crud.aya.test.com.R;

public class NavigationGraph extends AppCompatActivity implements SecondFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_graph);
        setTitle("Navigation Graph");
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
