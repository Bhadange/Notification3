package com.abc.notification3;

import static com.abc.notification3.modal.Constants.TOPIC;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.abc.notification3.api.ApiUtilities;
import com.abc.notification3.modal.PushNotification;
import com.abc.notification3.modal.notificationdata;
import com.google.firebase.messaging.FirebaseMessaging;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText title, message;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.submit);
        title = findViewById(R.id.ET1);
        message = findViewById(R.id.ET2);

        FirebaseMessaging.getInstance().subscribeToTopic(TOPIC);

        button.setOnClickListener(v -> {

            String titleText = title.getText().toString();
            String messageText = message.getText().toString();

            if (!titleText.isEmpty() && !messageText.isEmpty()) {
                PushNotification notification = new PushNotification(new notificationdata(titleText, messageText), TOPIC);
                sendNotification(notification);
            }
        });
    }


            private void sendNotification(PushNotification notification) {
                ApiUtilities.getClient().sendNotification((PushNotification) notification).enqueue(new Callback<PushNotification>() {
                    @Override
                    public void onResponse(Call<PushNotification> call, Response<PushNotification> response) {
                        if (response.isSuccessful())
                            Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<PushNotification> call, Throwable t) {
                        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
