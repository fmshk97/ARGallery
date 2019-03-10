package com.ar.argallery;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.ar.argallery.adapters.GalleryListAdapter;
import com.ar.argallery.models.GalleryListItem;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.Manifest.permission.CAMERA;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<GalleryListItem> data;
    private Context currentContext;
    private FloatingActionButton uploadButton;
    private Toolbar toolbar;
    private TextView emptyListTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);

        data = new ArrayList<>();
        recyclerView = findViewById(R.id.gallery_recycler_view);
        uploadButton = findViewById(R.id.fab_upload);
        emptyListTextView = findViewById(R.id.empty_list_text);

        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(currentContext, UploadActivity.class);
                startActivity(intent);
            }
        });
        currentContext = this;
        requestPermission();
    }

    @Override
    public void onResume(){
        super.onResume();
        fetchAllModels();
        if (data.isEmpty()) {
            emptyListTextView.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.INVISIBLE);
        }
        else {
            emptyListTextView.setVisibility(View.INVISIBLE);
            recyclerView.setVisibility(View.VISIBLE);
        }
        initializeRecyclerView();
    }

    private void initializeRecyclerView() {
        layoutManager = new GridLayoutManager(this, 3);
        adapter = new GalleryListAdapter(data, currentContext);
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(currentContext, R.dimen.item_offset);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void fetchAllModels() {
        data.clear();
        String thumbnailsPath = Environment.getExternalStorageDirectory() + Constants.THUMBNAILS_DIR;
        File thumbnailsDirectory = new File(thumbnailsPath);
        if (thumbnailsDirectory.exists()) {
            File[] files = thumbnailsDirectory.listFiles();
            for (int i = 0; i < files.length; i++)
            {
                String fileName = files[i].getName().substring(0, files[i].getName().lastIndexOf('.'));
                File modelFile = new File(Environment.getExternalStorageDirectory() + Constants.MODELS_DIR + "/" + fileName + ".sfb");
                if (modelFile.exists()) {
                    GalleryListItem listItem = new GalleryListItem();
                    listItem.modelLocation = Environment.getExternalStorageDirectory() + Constants.MODELS_DIR + "/" + fileName + ".sfb";
                    listItem.thumbnailUri = Uri.fromFile(files[i]);
                    data.add(listItem);
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_about) {
            Intent intent = new Intent(currentContext, AboutActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void requestPermission() {
        ArrayList<String> permissions = new ArrayList<>();
        if (!checkPermission(WRITE_EXTERNAL_STORAGE)) {
            permissions.add(WRITE_EXTERNAL_STORAGE);
        }
        if (!checkPermission(CAMERA)) {
            permissions.add(CAMERA);
        }
        if (!permissions.isEmpty()) {
            ActivityCompat.requestPermissions(this, permissions.toArray(new String[permissions.size()]), Constants.PERMISSION_REQUEST_CODE);
        }
    }

    private boolean checkPermission(String permission) {
        int result = ContextCompat.checkSelfPermission(getApplicationContext(), permission);
        return result == PackageManager.PERMISSION_GRANTED;
    }
}
