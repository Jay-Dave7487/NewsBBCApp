package com.relativecoding.newsapp.ui.lokmat;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.relativecoding.newsapp.R;
import com.relativecoding.newsapp.ui.WebViewController;

public class LokmatFragment extends Fragment{

    private LokmatViewModel lokmatViewModel;

    WebView webView;
    SwipeRefreshLayout swipeRefreshLayout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        lokmatViewModel =
                new ViewModelProvider(this).get(LokmatViewModel.class);
        View root = inflater.inflate(R.layout.fragment_lokmat, container, false);
//        final TextView textView = root.findV  iewById(R.id.text_home);
//        lokmatViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        //showNews(root);

        webView=root.findViewById(R.id.wv_lokmat);
        webView.loadUrl("https://m.lokmat.com/");
        webView.setWebViewClient(new WebViewController());

        swipeRefreshLayout=root.findViewById(R.id.lokmatRefresh);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                webView.reload();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.canGoBack();
        webView.setOnKeyListener(new View.OnKeyListener() {

            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK
                        && event.getAction() == MotionEvent.ACTION_UP
                        && webView.canGoBack()) {
                    webView.goBack();
                    return true;
                }
                return false;
            }
        });


        return root;
    }

}