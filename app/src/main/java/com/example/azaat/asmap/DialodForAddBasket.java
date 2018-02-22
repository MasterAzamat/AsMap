package com.example.azaat.asmap;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.content.DialogInterface.OnClickListener;

/**
 * Created by Azaat on 21.02.2018.
 */

public class DialodForAddBasket extends DialogFragment implements OnClickListener {

    final String LOG_TAG = "myLogs";

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder adb = new AlertDialog.Builder(getActivity())
                .setPositiveButton(R.string.YES, (DialogInterface.OnClickListener) this)
                .setNegativeButton(R.string.NO, (DialogInterface.OnClickListener) this)
                .setMessage(R.string.MESSAGE);
        return adb.create();
    }

    public void onClick(DialogInterface dialog, int which) {
        switch (which) {
            case Dialog.BUTTON_POSITIVE:

                break;
            case Dialog.BUTTON_NEGATIVE:

                break;
            case Dialog.BUTTON_NEUTRAL:

                break;
        }
    }

}
