package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PrivateKey;

public class MainActivity extends AppCompatActivity {
    private static final int picId = 1;
    private static final int CAMERA_PERMISSION_CODE = 100;

    ImageView click_image_id;
    Button camera;
    TextView quote;
    private Button cameraPerm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String[] quotes = {"Every strike brings me closer to the next home run. – Babe Ruth"
                ,"I don’t walk away from things I think are unfinished. – Arnold Schwarzenegger"
                ,"Whether you think you can or you think you can’t, you’re right. –Henry Ford"
                ,"I’ve missed more than 9000 shots in my career. I’ve lost almost 300 games. 26 times I’ve been trusted to take the game winning shot and missed. I’ve failed over and over and over again in my life. And that is why I succeed. –Michael Jordan"
                ,"I didn’t fail the test. I just found 100 ways to do it wrong. –Benjamin Franklin"
                ,"A person who never made a mistake never tried anything new. – Albert Einstein"
                ,"It is never too late to be what you might have been. –George Eliot"
                ,"Twenty years from now you will be more disappointed by the things that you didn’t do than by the ones you did do, so throw off the bowlines, sail away from safe harbor, catch the trade winds in your sails.  Explore, Dream, Discover. –Mark Twain"
                ,"The most common way people give up their power is by thinking they don’t have any. –Alice Walker"
                ,"The mind is everything. What you think you become.  –Buddha"
                ,"Either you run the day, or the day runs you. –Jim Rohn"
                ,"Life shrinks or expands in proportion to one’s courage. –Anais Nin"
                ,"Every strike brings me closer to the next home run. – Babe Ruth"
                ,"I don’t walk away from things I think are unfinished. – Arnold Schwarzenegger"
                ,"Whether you think you can or you think you can’t, you’re right. –Henry Ford"
                ,"I’ve missed more than 9000 shots in my career. I’ve lost almost 300 games. 26 times I’ve been trusted to take the game winning shot and missed. I’ve failed over and over and over again in my life. And that is why I succeed. –Michael Jordan"
                ,"I didn’t fail the test. I just found 100 ways to do it wrong. –Benjamin Franklin"
                ,"A person who never made a mistake never tried anything new. – Albert Einstein"
                ,"It is never too late to be what you might have been. –George Eliot"
                ,"Twenty years from now you will be more disappointed by the things that you didn’t do than by the ones you did do, so throw off the bowlines, sail away from safe harbor, catch the trade winds in your sails.  Explore, Dream, Discover. –Mark Twain"
                ,"The most common way people give up their power is by thinking they don’t have any. –Alice Walker"
                ,"The mind is everything. What you think you become.  –Buddha"
                ,"Either you run the day, or the day runs you. –Jim Rohn"
                ,"When one door of happiness closes, another opens, but often we look so long at the closed door that we do not see the one that has been opened for us. –Helen Keller"
                ,"Everything has beauty, but not everyone can see. –Confucius"
                ,"You only live once, but if you do it right, once is enough. — Mae West"
                ,"Many of life’s failures are people who did not realize how close they were to success when they gave up.– Thomas A. Edison"
                ,"If you want to live a happy life, tie it to a goal, not to people or things.– Albert Einstein"
                ,"Money and success don’t change people; they merely amplify what is already there. — Will Smith"
                ,"Your time is limited, so don’t waste it living someone else’s life. Don’t be trapped by dogma – which is living with the results of other people’s thinking. – Steve Jobs"
                ,"Not how long, but how well you have lived is the main thing. — Seneca"
                ,"If life were predictable it would cease to be life, and be without flavour. – Eleanor Roosevelt"
                ,"The best revenge is massive success. –Frank Sinatra"
                ,"The person who says it cannot be done should not interrupt the person who is doing it. –Chinese Proverb"
                ,"Fall seven times and stand up eight. –Japanese Proverb"
                ,"Never let the fear of striking out keep you from playing the game.– Babe Ruth"
                ,"You can’t use up creativity.  The more you use, the more you have. –Maya Angelou"
                ,"I would rather die of passion than of boredom. –Vincent van Gogh"
                ,"Whatever the mind of man can conceive and believe, it can achieve. –Napoleon Hill"
                ,"Strive not to be a success, but rather to be of value. –Albert Einstein"
                ,"What’s money? A man is a success if he gets up in the morning and goes to bed at night and in between does what he wants to do. –Bob Dylan"
                ,"There are no traffic jams along the extra mile. –Roger Staubach"
                ,"Teach thy tongue to say, “I do not know,” and thous shalt progress. –Maimonides"
                ,"We become what we think about. –Earl Nightingale"
                ,"Winning isn’t everything, but wanting to win is. –Vince Lombardi"
                ,"I am not a product of my circumstances. I am a product of my decisions. –Stephen Covey"
                ,"If you’re offered a seat on a rocket ship, don’t ask what seat! Just get on. –Sheryl Sandberg"
                ,"The whole secret of a successful life is to find out what is one’s destiny to do, and then do it.– Henry Ford"
                ,"Not how long, but how well you have lived is the main thing. — Seneca"
                ,"If life were predictable it would cease to be life, and be without flavour. – Eleanor Roosevelt"
                ,"The best revenge is massive success. –Frank Sinatra"
                ,"The person who says it cannot be done should not interrupt the person who is doing it. –Chinese Proverb"
                ,"Fall seven times and stand up eight. –Japanese Proverb"
                ,"Never let the fear of striking out keep you from playing the game.– Babe Ruth"
                ,"You can’t use up creativity.  The more you use, the more you have. –Maya Angelou"
                ,"I would rather die of passion than of boredom. –Vincent van Gogh"
                ,"Whatever the mind of man can conceive and believe, it can achieve. –Napoleon Hill"
                ,"Strive not to be a success, but rather to be of value. –Albert Einstein"
                ,"What’s money? A man is a success if he gets up in the morning and goes to bed at night and in between does what he wants to do. –Bob Dylan"
                ,"I attribute my success to this: I never gave or took any excuse. –Florence Nightingale"
                ,"There are no traffic jams along the extra mile. –Roger Staubach"
                ,"Teach thy tongue to say, “I do not know,” and thous shalt progress. –Maimonides"
                ,"We become what we think about. –Earl Nightingale"
                ,"Winning isn’t everything, but wanting to win is. –Vince Lombardi"
                ,"I am not a product of my circumstances. I am a product of my decisions. –Stephen Covey"
                ,"If you’re offered a seat on a rocket ship, don’t ask what seat! Just get on. –Sheryl Sandberg"
                ,"The whole secret of a successful life is to find out what is one’s destiny to do, and then do it.– Henry Ford"};
        int randomNum = (int)(Math.random()*quotes.length);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        // By ID we can get each component which id is assigned in XML file get Buttons and imageview.
//        camera = findViewById(R.id.camera);
//        click_image_id = findViewById(R.id.proof);
//        cameraPerm = findViewById(R.id.cameraPer);
//        cameraPerm.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                checkPermission(Manifest.permission.CAMERA, CAMERA_PERMISSION_CODE);
//            }
//        });
//        // Camera_open button is for open the camera and add the setOnClickListener in this button
//        camera.setOnClickListener(v -> {
//            // Create the camera_intent ACTION_IMAGE_CAPTURE it will open the camera for capture the image
//            Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//            // Start the activity with camera_intent, and request pic id
//            startActivityForResult(camera_intent, picId);
//        });
        quote = findViewById(R.id.quote);
        quote.setText(quotes[randomNum]);
//
    }
//    // Function to check and request permission.
//    public void checkPermission(String permission, int requestCode)
//    {
//        if (ContextCompat.checkSelfPermission(MainActivity.this, permission) == PackageManager.PERMISSION_DENIED) {
//
//            // Requesting the permission
//            ActivityCompat.requestPermissions(MainActivity.this, new String[] { permission }, requestCode);
//        }
//        else {
//            Toast.makeText(MainActivity.this, "Permission already granted", Toast.LENGTH_SHORT).show();
//            cameraPerm.setVisibility(View.GONE);
//        }
//    }
//    @Override
//    public void onRequestPermissionsResult(int requestCode,
//                                           @NonNull String[] permissions,
//                                           @NonNull int[] grantResults)
//    {
//        super.onRequestPermissionsResult(requestCode,
//                permissions,
//                grantResults);
//
//        if (requestCode == CAMERA_PERMISSION_CODE) {
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                Toast.makeText(MainActivity.this, "Camera Permission Granted", Toast.LENGTH_SHORT) .show();
//                cameraPerm.setVisibility(View.INVISIBLE);
//            }
//            else {
//                Toast.makeText(MainActivity.this, "Camera Permission Denied", Toast.LENGTH_SHORT) .show();
//            }
//        }
//    }


    static int treeNum = 0;
    public void changeTree (View view) {
        TextView treeCounter = findViewById(R.id.treeCounter);
        treeCounter.setText("Number of trees: " + treeNum++);

    }
    public void changeView(View view){
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);
    }
    public void changeView2(View view){
        Intent intent = new Intent(this,MainActivity4.class);
        startActivity(intent);
    }
    public void changeView3(View view){
        Intent intent = new Intent(this,MainActivity5.class);
        startActivity(intent);
    }

}
