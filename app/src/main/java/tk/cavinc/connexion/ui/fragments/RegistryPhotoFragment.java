package tk.cavinc.connexion.ui.fragments;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;

import tk.cavinc.connexion.R;
import tk.cavinc.connexion.utils.Func;

import static android.app.Activity.RESULT_OK;

/**
 * Created by cav on 25.04.20.
 */

public class RegistryPhotoFragment extends BaseFragment implements View.OnClickListener{

    private static final int REQUEST_CAMERA_PICTURE = 456;
    private ImageView mPhoto;
    private File mPhotoFile;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.registry_photo_fragment, container, false);

        mPhoto = rootView.findViewById(R.id.reg_photo_img);
        rootView.findViewById(R.id.registry_next).setOnClickListener(this);
        rootView.findViewById(R.id.reg_photo_bt).setOnClickListener(this);
        rootView.findViewById(R.id.reg_photo_galery).setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.reg_photo_bt) {
            loadCameraPhoto();
        }
    }

    private void loadCameraPhoto(){
        File storageDir = getDataManager().getAppStoragePath();

        String imageFile = "avatar";

        try {
            mPhotoFile = File.createTempFile(imageFile, ".jpg", storageDir);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Intent captureImage = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            ContentValues values = new ContentValues();
            values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpg");
            Uri fileUri = FileProvider.getUriForFile(getActivity(),
                    getDataManager().getContext().getPackageName() + ".provider", mPhotoFile);

            captureImage.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            captureImage.putExtra(MediaStore.EXTRA_OUTPUT,fileUri);
        } else {
            captureImage.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(mPhotoFile));
        }

        startActivityForResult(captureImage,REQUEST_CAMERA_PICTURE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_CAMERA_PICTURE:
                if (resultCode == RESULT_OK && mPhotoFile !=null){
                    mPhoto.setImageBitmap(Func.getPicSize(mPhotoFile.toString()));
                } else {
                    mPhotoFile = null;
                }
                break;
        }
    }
}
