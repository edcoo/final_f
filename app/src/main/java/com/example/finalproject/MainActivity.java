package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;


public class MainActivity extends AppCompatActivity {
    GoogleSignInClient mGoogleSignInClient;
    ActivityResultLauncher<Intent> signInLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // הגדר את אפשרויות Google Sign-In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(
                GoogleSignInOptions.DEFAULT_SIGN_IN
        ).requestEmail().requestIdToken("336778821042-gc1pnldsb9hhc83en8gu30qsjtev3osp.apps.googleusercontent.com").build();

        mGoogleSignInClient = GoogleSignIn.getClient(getApplicationContext(), gso);

        signInLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(result.getData());
                        handleSignInData(task);
                    }
        });

        RecyclerView rv = findViewById(R.id.rv);
        rv.setHasFixedSize(false);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 1);
        rv.setLayoutManager(layoutManager);

        CardAdapter adapter = new CardAdapter();
        rv.setAdapter(adapter);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                signInLauncher.launch(signInIntent);
            }
        });


    }

    private void handleSignInData(Task<GoogleSignInAccount> task) {
        GoogleSignInAccount account= null;
        try {
            account = task.getResult(ApiException.class);
            Toast.makeText(this, "Welcome " + account.getDisplayName(), Toast.LENGTH_LONG).show();
        } catch (ApiException e) {
            Toast.makeText(this, "Sign in failed: " + e.getStatusCode(), Toast.LENGTH_LONG).show();
        }
    }
}
