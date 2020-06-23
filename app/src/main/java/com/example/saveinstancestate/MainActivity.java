package com.example.saveinstancestate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String name="undefined";

    final static String nameVariableKey="NAME_VARIABLE";
    final static String textViewTextKey="TEXTVIEW_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //сохранение состояния
    @Override
    protected void onSaveInstanceState(Bundle outState){
        outState.putString(nameVariableKey, name);
        TextView nameView=findViewById(R.id.nameView);
        outState.putString(textViewTextKey, nameView.getText().toString());
        super.onSaveInstanceState(outState);
    }

    //получение ранее сохраненного состояния
    @Override
    protected void onRestoreInstanceState(Bundle saveInstanceState){
        super.onRestoreInstanceState(saveInstanceState);

        name=saveInstanceState.getString(nameVariableKey);
        String textViewText=saveInstanceState.getString(textViewTextKey);
        TextView nameView=findViewById(R.id.nameView);
        nameView.setText(textViewText);
    }

        public void saveName(View view){
            EditText nameBox=findViewById(R.id.nameBox);
            name=nameBox.getText().toString();
    }

    public void getName(View view){
        TextView nameText=findViewById(R.id.nameBox);
        nameText.setText(name);
    }
}
