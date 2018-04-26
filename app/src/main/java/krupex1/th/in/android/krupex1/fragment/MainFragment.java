package krupex1.th.in.android.krupex1.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import krupex1.th.in.android.krupex1.R;
import krupex1.th.in.android.krupex1.utility.GetAllData;
import krupex1.th.in.android.krupex1.utility.MyAlert;
import krupex1.th.in.android.krupex1.utility.Myconstant;

public class MainFragment extends Fragment {

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // register control


        registerControl();
//        Login controll
        loginControll();
    }  // main metod

    private void loginControll() {
        Button button = getView().findViewById(R.id.btnLogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText userEditText = getView().findViewById(R.id.edtUser);
                EditText passwordEditText = getView().findViewById(R.id.edtPassword);


                String userString = userEditText.getText().toString().trim();
                String passwordString = passwordEditText.getText().toString().trim();

                if (userString.isEmpty() || passwordString.isEmpty()) {
                    MyAlert myAlert = new MyAlert(getActivity());
                    myAlert.normalDialog("Have space",
                            "please Fill Ever blank");

                } else {
//                nospace
                    Myconstant myconstant = new Myconstant();
                    boolean b = true;
                    String truePass = null, nameUser = null;
                    MyAlert myAlert = new MyAlert(getActivity());

                    try {
                        GetAllData getAllData = new GetAllData(getActivity());
                        getAllData.execute(myconstant.getUrlGetAllUser());
                        String jsonSting = getAllData.get();
                        Log.d("26AprilV1", "Json ==>" + jsonSting);

                        JSONArray jsonArray = new JSONArray(jsonSting);

                        for (int i = 0; i < jsonArray.length(); i += 1) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            if (userString.equals(jsonObject.getString("User"))) {
                                b = false;
                                truePass = jsonObject.getString("Password");

                                nameUser = jsonObject.getString("Name");

                            }
                        }
                        if (b) {
                            myAlert.normalDialog("user fail",
                                    "No user");

                        } else if (passwordString.equals(truePass)) {
                            Toast.makeText(getActivity(),"สวัสดีครับคุณ "+ nameUser,
                                    Toast.LENGTH_SHORT).show();

                            getActivity().getSupportFragmentManager()
                                    .beginTransaction()
                                    .replace(R.id.contenMainFragment,new ServiceFragment())
                                    .commit();



                        } else {
                            myAlert.normalDialog("Passw9ord fail",
                                    "please try again");

                        }


                        } catch(Exception e){
                            e.printStackTrace();

                        }
                    }


                }
            });
        }

        private void registerControl () {
            TextView textView = getView().findViewById(R.id.txtRegister);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Replat frgament
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.contenMainFragment, new RegisterFlagment())
                            .addToBackStack(null)
                            .commit();

                }
            });
        }

        @Nullable
        @Override
        public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup
        container, @Nullable Bundle savedInstanceState){
            View view = inflater.inflate(R.layout.fragment_main, container, false);
            return view;
        }
    }


//main class

