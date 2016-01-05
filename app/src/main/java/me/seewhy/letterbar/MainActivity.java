package me.seewhy.letterbar;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private LetterBar mLetterBar;
    private TextView mTextView;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initData();
    }

    private void initViews() {
        mLetterBar = (LetterBar) findViewById(R.id.letterBar);
        mTextView = (TextView) findViewById(R.id.text);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    }

    private void initData() {

        List<BannerModel> models = new ArrayList<>();
        models.add(new BannerModel("A", "2"));
        models.add(new BannerModel("A", "2"));
        models.add(new BannerModel("A", "2"));
        models.add(new BannerModel("A", "2"));
        models.add(new BannerModel("B", "2"));
        models.add(new BannerModel("B", "2"));
        models.add(new BannerModel("B", "2"));
        models.add(new BannerModel("B", "2"));
        models.add(new BannerModel("C", "2"));
        models.add(new BannerModel("D", "2"));
        models.add(new BannerModel("D", "2"));
        models.add(new BannerModel("E", "2"));


        models.add(new BannerModel("C", "2"));
        models.add(new BannerModel("D", "2"));
        models.add(new BannerModel("D", "2"));
        models.add(new BannerModel("E", "2"));
        models.add(new BannerModel("R", "2"));
        models.add(new BannerModel("H", "2"));
        models.add(new BannerModel("Z", "2"));
        models.add(new BannerModel("Y", "2"));
        models.add(new BannerModel("F", "2"));
        models.add(new BannerModel("D", "2"));
        models.add(new BannerModel("Y", "2"));
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        final BannerAdapter bannerAdapter = new BannerAdapter(this, models);
        final SectionedRecyclerAdapter recyclerAdapter = new SectionedRecyclerAdapter(this, R.layout.title_item, R.id.tvName, bannerAdapter);
        mRecyclerView.setAdapter(recyclerAdapter);

        mLetterBar.setOnLetterSelectListener(new LetterBar.OnLetterSelectListener() {
            @Override
            public void onLetterSelect(int position, String letter, boolean confirm) {
                if (confirm) {
                    mTextView.setVisibility(View.GONE);
                } else {
                    mTextView.setVisibility(View.VISIBLE);
                    mTextView.setText(letter + position);
                }
                Integer sectionPosition = bannerAdapter.getSectionPosition(position);
                if (sectionPosition != null)
                    linearLayoutManager.scrollToPositionWithOffset(sectionPosition, 0);
            }
        });
    }

}