package edu.purdue.rteoyiiw.urglobalappapi19;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    //Animation animTranslate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //animTranslate = AnimationUtils.loadAnimation(this, R.anim.translate);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        addListenerAboutButton();
        addListenerEventButton();
        addListenerNotiDemo();
        addListenerRegisterButton();
        addListenerUpcomingEventLayout();
        addListenerBannerButton();
    }


    private void addNotification() {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.sample_notification)
                        .setContentTitle("UR Global Ski Trip!")
                        .setContentText("Make the most out of winter by learning how to ski. Feb. 11th. Saturday");

        Intent notificationIntent = new Intent(this, EventDetail1Activity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.about) {
            // Handle the camera action
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        }else if(id == R.id.event){
            Intent intent = new Intent(MainActivity.this, EventActivity.class);
            startActivity(intent);
        }else if(id == R.id.regi) {
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
        }else if(id == R.id.home) {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            }
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void addListenerAboutButton() {
        Button button;
        button = (Button) findViewById(R.id.aboutButton);
                button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
                //arg0.startAnimation(animTranslate);
            }
        });

    }

    public void addListenerEventButton(){
        Button button;
        button = (Button)findViewById(R.id.eventButton);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0){
                Intent intent = new Intent(MainActivity.this, EventActivity.class);
                startActivity(intent);
                //arg0.startAnimation(animTranslate);
            }
        });
    }

    public void addListenerRegisterButton(){
        Button button;
        button = (Button)findViewById(R.id.regiButton);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0){
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                //arg0.startAnimation(animTranslate);
            }
        });
    }
    public void addListenerNotiDemo(){
        Button button;
        button = (Button)findViewById(R.id.notiDemo);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                addNotification();
            }
        });
    }

    public void addListenerUpcomingEventLayout(){
        LinearLayout header = (LinearLayout) findViewById(R.id.upcoming_event);
        header.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, EventDetail1Activity.class);
                startActivity(intent);
            }
        });
    }

    public void addListenerBannerButton(){
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        LinearLayout header = (LinearLayout) headerView.findViewById(R.id.banner_button);
        header.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0) {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }
            }
        });
    }

}
