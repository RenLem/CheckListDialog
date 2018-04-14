package omy.boston.checklistdialog.CheckListDialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import omy.boston.checklistdialog.MainActivity;
import omy.boston.checklistdialog.R;

/**
 * Created by LosFrancisco on 13-Jan-17.
 */

public class CheckListDialog extends DialogFragment {
    String [] languageList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        languageList = getResources().getStringArray(R.array.languages_list);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder cekLista = new AlertDialog.Builder(getActivity());
        cekLista.setIcon(android.R.drawable.ic_dialog_alert);
        cekLista.setTitle("The List of languages");
        cekLista.setMultiChoiceItems(R.array.languages_list, null, new DialogInterface.OnMultiChoiceClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int choose, boolean isClicked) {
                MainActivity ma = (MainActivity) getActivity();
                String tekst = ma.getTextField();
                tekst += languageList[choose] + ";";//Dohvati tekst iz tksView i doda odabrane opcije
                ma.setTextField(tekst);//Postavlja tekst u tksView na MainActivitiju
            }
        });

        cekLista.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dismiss();
            }
        });

        AlertDialog stvoren = cekLista.create();
        return stvoren;
    }
}
