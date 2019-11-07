package crud.aya.test.com.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import crud.aya.test.com.R;

public class MainFargment extends Fragment {

    private NavigationGraph mainViewModel;

    public MainFargment mainFargment(){return  new MainFargment();}

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_first, container, false);
        }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        View.OnClickListener s = Navigation.createNavigateOnClickListener(R.id.action_fargment_main_to_secondFragment);
        Button button = (Button) view.findViewById(R.id.b_frist_fragment);
        button.setOnClickListener(s);
        }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        Button button = (Button) getView().findViewById(R.id.b_frist_fragment);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(MainFargmentDirections.actionFargmentMainToSecondFragment());
            }
        });

    }
}


