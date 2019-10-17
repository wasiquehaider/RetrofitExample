package com.example.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
    }

    public void getTodos(View view){
        Call<List<Todo>> call = apiInterface.getTodos();
        call.enqueue(new Callback<List<Todo>>() {
            @Override
            public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {
                Log.e(TAG,"on Response: " + response.body());
            }

            @Override
            public void onFailure(Call<List<Todo>> call, Throwable t) {
                Log.e(TAG,"on Failure: " + t.getLocalizedMessage());
            }
        });
    }
    public void getTodosUsingRoutePrarameters(View view){
        Call<Todo> todoCall = apiInterface.getTodo(3);
        todoCall.enqueue(new Callback<Todo>() {
            @Override
            public void onResponse(Call<Todo> call, Response<Todo> response) {
                Log.e(TAG,"on Response: " + response.body());
            }

            @Override
            public void onFailure(Call<Todo> call, Throwable t) {
                Log.e(TAG,"on Failure: " + t.getLocalizedMessage());
            }
        });

    }
    public void getTodosUsingQuery(View view){
        Call<Todo> listCall = apiInterface.getTodosUsingQuery(2,false);
        listCall.enqueue(new Callback<Todo>() {
            @Override
            public void onResponse(Call<Todo> call, Response<Todo> response) {
                Log.e(TAG,"on Response: " + response.body());
            }

            @Override
            public void onFailure(Call<Todo> call, Throwable t) {
                Log.e(TAG,"on Failure: " + t.getLocalizedMessage());
            }
        });
    }
    public void postTodo(View view){
        Todo todo = new Todo(3,"Get me Popcorn",false);
        Call<Todo> postCall = apiInterface.postTodo(todo);
        postCall.enqueue(new Callback<Todo>() {
            @Override
            public void onResponse(Call<Todo> call, Response<Todo> response) {
                Log.e(TAG,"on Response: " + response.body());
            }

            @Override
            public void onFailure(Call<Todo> call, Throwable t) {
                Log.e(TAG,"on Failure: " + t.getLocalizedMessage());
            }
        });
    }
}
