package tk.cavinc.connexion.ui.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

import tk.cavinc.connexion.R;
import tk.cavinc.connexion.data.managers.DataManager;

/**
 * Created by cav on 04.05.20.
 */

public class WarningMeetMeDialog extends DialogFragment {
    private DataManager mDataManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataManager = DataManager.getInstance();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.warningmeetme_dialog,null);


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(v).setTitle("Уведомление")
                .setPositiveButton(R.string.dialog_close, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

        return builder.create();
    }
}
