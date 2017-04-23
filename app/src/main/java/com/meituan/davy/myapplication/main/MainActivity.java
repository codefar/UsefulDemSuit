package com.meituan.davy.myapplication.main;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.*;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.meituan.davy.myapplication.R;
import com.meituan.davy.myapplication.base.BaseActiivity;
import com.meituan.davy.myapplication.db.DBHelper;
import com.meituan.davy.myapplication.db.entity.User;
import com.meituan.davy.myapplication.db.entity.tomany.DaoSession;
import com.meituan.davy.myapplication.db.entity.toone.CustomerDao;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fi.iki.elonen.NanoHTTPD;

public class MainActivity extends BaseActiivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected int gerLayoutRes() {
        return R.layout.activity_main;
    }
}
