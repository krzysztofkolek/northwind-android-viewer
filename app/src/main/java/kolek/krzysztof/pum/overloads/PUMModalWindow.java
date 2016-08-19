package kolek.krzysztof.pum.overloads;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

import java.util.Dictionary;
import java.util.List;

import kolek.krzysztof.pum.interfaces.IModalAction;
import kolek.krzysztof.pum.interfaces.IModalData;
import kolek.krzysztof.pum.models.Customer1;

/**
 * Created by Krzys on 01-11-15.
 */
public class PUMModalWindow<T> {

    public PUMModalWindow(Context context, Customer1 data)
    {
        Dialog d = new AlertDialog.Builder(context,AlertDialog.THEME_HOLO_LIGHT)
                .setTitle("Create New")
                .setNegativeButton("Cancel", null)
                .setItems(data.FormatedData(), new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dlg, int position)
                    {
                    }
                })
                .create();
        d.show();
    }
}
