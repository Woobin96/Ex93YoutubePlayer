package com.wooeun18.ex93youtubeplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

public class MainActivity extends AppCompatActivity {

    YouTubePlayerFragment youTubeFragment;
    YouTubePlayerFragment youTubeFragment2;

    YouTubeThumbnailView youTubeThumbnailView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //xml 에 있는 유튜브플레이프레그먼트 참조 [안드로이드x 말고 기본으로]
        FragmentManager fragmentManager= getFragmentManager();
        youTubeFragment= (YouTubePlayerFragment) fragmentManager.findFragmentById(R.id.youtubeFragment);

        //첫번째 파라미터 : 아무의미없이 식별자 . <- 이 이름이 같으면 Player 가 같은뷰라고 생각해서 같은 내용 보여줌
        youTubeFragment.initialize("first", new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                //유튜브 비디오의 id 를 지정 (url 아님)
                youTubePlayer.cueVideo("WV71udxouKU");//로딩이 완료 되어도 자동실행 되지는 않음 .
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(MainActivity.this, "실패", Toast.LENGTH_SHORT).show();
            }
        });

        youTubeFragment2= (YouTubePlayerFragment)fragmentManager.findFragmentById(R.id.youtubeFragment2);
        youTubeFragment2.initialize("second", new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("U_IBqleJRns"); //로딩되면 바로 재생
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });

        youTubeThumbnailView= findViewById(R.id.youtubeThumb);
        youTubeThumbnailView.initialize("thumb", new YouTubeThumbnailView.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader youTubeThumbnailLoader) {
                youTubeThumbnailLoader.setVideo("MwYq4vAH7bI");
            }

            @Override
            public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });

    }
}

















