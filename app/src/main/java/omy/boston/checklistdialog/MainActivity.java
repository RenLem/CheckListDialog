package omy.boston.checklistdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import omy.boston.checklistdialog.CheckListDialog.CheckListDialog;

public class MainActivity extends AppCompatActivity {

    TextView odabranaOpcija;
    Button odaberi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        odabranaOpcija = (TextView) findViewById(R.id.textView);
        odaberi = (Button) findViewById(R.id.button);

        odaberi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckListDialog cld = new CheckListDialog();
                cld.show(getFragmentManager(), "Odaberi jezike:");
                odabranaOpcija.setText("");
            }
        });
    }

    public void setTextField(String itam){
        odabranaOpcija.setText(itam);
    }

    public String getTextField(){
        return odabranaOpcija.getText().toString();
    }
}
