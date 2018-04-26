package krupex1.th.in.android.krupex1.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import krupex1.th.in.android.krupex1.R;
import krupex1.th.in.android.krupex1.utility.FoodAdapter;
import krupex1.th.in.android.krupex1.utility.GetAllData;
import krupex1.th.in.android.krupex1.utility.Myconstant;

public class ServiceFragment extends Fragment {
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//      Create lit viw
        createLitViw();


    }

    private void createLitViw() {
        ListView listView = getView().findViewById(R.id.listViewFood);
        Myconstant myconstant = new Myconstant();
        try {
            GetAllData getAllData = new GetAllData(getActivity());
            getAllData.execute(myconstant.getUrlAllFood());


            String jsonString = getAllData.get();

            JSONArray jsonArray = new JSONArray(jsonString);
            String[] foodStrings = new  String[jsonArray.length()];
            String[] priceStrings = new  String[jsonArray.length()];
            String[] detailStrings = new  String[jsonArray.length()];
            String[] imageStrings = new  String[jsonArray.length()];
            for (int i=0; i<jsonArray.length(); i+=1){
                JSONObject jsonObject = jsonArray.getJSONObject(i);


                foodStrings[i] = jsonObject.getString("NameFood");
                priceStrings[i] = jsonObject.getString("Price");
                detailStrings[i] = jsonObject.getString("Detail");
                imageStrings[i] = jsonObject.getString("ImagePath");

            }
            FoodAdapter foodAdapter = new FoodAdapter(getActivity(),
                    imageStrings, foodStrings, priceStrings, detailStrings);
            listView.setAdapter(foodAdapter);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    main metod

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_service, container, false);
        return view;
    }
}
