package com.relativecoding.newsapp.ui.divyaMarathi;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.relativecoding.newsapp.R;
import com.relativecoding.newsapp.ui.WebViewController;

public class DivyaMarathiFragment extends Fragment {

    private DivyaMarathiViewModel divyaMarathiViewModel;

    WebView webView;
    SwipeRefreshLayout swipeRefreshLayout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        divyaMarathiViewModel =
                new ViewModelProvider(this).get(DivyaMarathiViewModel.class);
        View root = inflater.inflate(R.layout.fragment_divya_marathi, container, false);

        webView = root.findViewById(R.id.wvDivyaMarathi);
        webView.loadUrl("https://divyamarathi.bhaskar.com/");
        webView.setWebViewClient(new WebViewController());

        swipeRefreshLayout=root.findViewById(R.id.refreshDivyaMarathi);

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