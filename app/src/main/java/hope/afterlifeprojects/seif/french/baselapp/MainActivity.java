package hope.afterlifeprojects.seif.french.baselapp;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements MovieItemClickListner {

    private List<Slide> lstSlides;
    private ViewPager sliderpager;
    private TabLayout indicator ;
    private RecyclerView MoviesRV;
    List<Movie>lstMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sliderpager = findViewById(R.id.slider_pager);
        indicator = findViewById(R.id.indicator);
        MoviesRV = findViewById(R.id.Rv_movies);

        lstSlides = new ArrayList<>();
        lstSlides.add(new Slide(R.drawable.bslone,"Vitenam \nAdd more here"));
        lstSlides.add(new Slide(R.drawable.bsltwo,"Georgia \nAdd more here"));
        lstSlides.add(new Slide(R.drawable.bslone,"Vitenam \nAdd more here"));
        lstSlides.add(new Slide(R.drawable.bsltwo,"Georgia \nAdd more here"));

        SliderPagerAdapter adapter = new SliderPagerAdapter(this,lstSlides);
        sliderpager.setAdapter(adapter);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate( new MainActivity.SliderTimer(),4000,6000);

        indicator.setupWithViewPager(sliderpager,true);

        lstMovies = new ArrayList<>();
        lstMovies.add(new Movie("Showreal",R.drawable.thumone,R.drawable.thecover));
        lstMovies.add(new Movie("Nabq",R.drawable.nabq,R.drawable.thecover));
        lstMovies.add(new Movie("Showreal",R.drawable.thumonetwo));
        lstMovies.add(new Movie("Nabq",R.drawable.nabq));
        lstMovies.add(new Movie("Nabq",R.drawable.nabq));
        lstMovies.add(new Movie("Nabq",R.drawable.nabq));
        lstMovies.add(new Movie("seif","seif"));

        FirebaseDatabase firebaseDatabase =FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        DatabaseReference first = databaseReference.child("uploads");



        MovieAdapter movieAdapter = new MovieAdapter(this,lstMovies,this);
        MoviesRV.setAdapter(movieAdapter);
        MoviesRV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));


    }

    @Override
    public void onMovieClick(Movie movie, ImageView movieImageView) {

        Intent intent = new Intent(this,MovieDetailActivity.class);
        intent.putExtra("title",movie.getTitle());
        intent.putExtra("imgUrl",movie.getThumbnail());
        intent.putExtra("imgCover",movie.getCoverPhoto());


        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,movieImageView,"sharedName");

        startActivity(intent,options.toBundle());

    }

    class SliderTimer extends TimerTask {

        @Override
        public void run() {

            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if (sliderpager.getCurrentItem()<lstSlides.size()-1){
                        sliderpager.setCurrentItem(sliderpager.getCurrentItem()+1);

                    }
                    else
                        sliderpager.setCurrentItem(0);
                }
            });
        }
    }
}
