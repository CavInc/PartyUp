package tk.cavinc.connexion.ui.fragments;


import android.content.Context;
import android.support.v4.app.Fragment;

import tk.cavinc.connexion.data.managers.DataManager;
import tk.cavinc.connexion.ui.helpers.LoadFramentListener;

/**
 * Created by cav on 13.04.20.
 */

public class BaseFragment extends Fragment {
    private LoadFramentListener mLoadFramentListener;
    private DataManager mDataManager;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mLoadFramentListener = (LoadFramentListener) getActivity();
        } catch (Exception e){

        }
        mDataManager = DataManager.getInstance();
    }

    public DataManager getDataManager() {
        return mDataManager;
    }

    public void setLoadFramentListener(Fragment fragment, String string){
        if (mLoadFramentListener != null) {
            mLoadFramentListener.onLoadFragment(fragment,string);
        }
    }
}
