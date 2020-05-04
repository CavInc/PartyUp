package tk.cavinc.connexion.ui.helpers;

import tk.cavinc.connexion.data.models.UserModel;

/**
 * Created by cav on 04.05.20.
 */

public interface StreamItemClickListener {
    void onItemClick(int position);
    void onItemClick(UserModel model);
}
