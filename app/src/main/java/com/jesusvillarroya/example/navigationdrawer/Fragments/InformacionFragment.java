package com.jesusvillarroya.example.navigationdrawer.Fragments;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.jesusvillarroya.example.navigationdrawer.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class InformacionFragment extends Fragment implements View.OnClickListener, DialogInterface.OnClickListener {
    private FloatingActionButton floatingActionButton;

    private EditText editText;
    private Switch switchbtn;

    public TextView  textView;



    public InformacionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_informacion, container, false);

        textView = (TextView)view.findViewById(R.id.text);

        floatingActionButton = (FloatingActionButton) view.findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(this);

        // Inflate the layout for this fragment
        return view;
    }

    //FloatingActionButton
    @Override
    public void onClick(View view) {
        //Preparamos el EditText
        //editText = new EditText(getContext());
        //editText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);

        //Preparamos le layout del dialog
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_fragment, null);

        switchbtn = (Switch)dialogView.findViewById(R.id.switch1);
        editText = (EditText)dialogView.findViewById(R.id.editText);



        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Información");
        builder.setMessage("Esto es un mensaje de prueba");

        // builder.setView(editText);
        builder.setView(dialogView);

        builder.setNeutralButton("Great", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getContext(), "Hola holaaaa.....", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setPositiveButton("OK", this);
        builder.setNegativeButton("CANCEL", this);

        builder.show();
        /*AlertDialog dialog = builder.create();
        dialog.show();*/
    }


    @Override
    public void onClick(DialogInterface dialogInterface, int i) {

        if (i == DialogInterface.BUTTON_POSITIVE){
            if(switchbtn.isChecked()) {
                String text = editText.getText().toString();
                textView.setText(text);
            } else {
                textView.setText("No me has activado");
            }
        } else if (i == DialogInterface.BUTTON_NEGATIVE){
            dialogInterface.cancel();
        }
    }
}
