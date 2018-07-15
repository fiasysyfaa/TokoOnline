package app.tokoonline;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.design.widget.TabLayout;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import app.tokoonline.trans_fragment.Purchase;
import app.tokoonline.trans_fragment.Sales;


public class Trans extends AppCompatActivity {

    private final String[] PAGE_TITLES = new String[] {
            "Pembelian", "Penjualan" };
    private final Fragment[] PAGES = new Fragment[] {
            new Purchase(), new Sales() };

    public static ViewPager viewPager;
    public static TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyPagerAdapter(getFragmentManager()));

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Transaksi");
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    public class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            return PAGES[position];
        }

        @Override
        public int getCount() {
            return PAGES.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return PAGE_TITLES[position];
        }

    }
}
