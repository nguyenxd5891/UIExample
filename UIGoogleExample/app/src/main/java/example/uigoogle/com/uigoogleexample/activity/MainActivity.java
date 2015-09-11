package example.uigoogle.com.uigoogleexample.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Build;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import example.uigoogle.com.uigoogleexample.R;
import example.uigoogle.com.uigoogleexample.fragment.AppFragment;
import example.uigoogle.com.uigoogleexample.fragment.GameFragment;
import example.uigoogle.com.uigoogleexample.fragment.HomeFragment;
import example.uigoogle.com.uigoogleexample.fragment.NavigationDrawerFragment;
import example.uigoogle.com.uigoogleexample.util.Utils;

public class MainActivity extends AppCompatActivity implements NavigationDrawerFragment.FragmentDrawerListener, SearchView.OnQueryTextListener {
    public static Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private NavigationDrawerFragment drawerFragment;
    private ImageView mIvSearch;
    private AutoCompleteTextView mAutoComplete;
    private ArrayAdapter<String> mAdapter;
    private SearchView searchView = null;
    private final ArrayList<String> suggestionsArray = new ArrayList<String>();
    private final ArrayList<String> datas = new ArrayList<String>();
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TERM = "term";
    private static final String DEFAULT = "default";
    private SuggestAdapter suggestionsAdapter;
    public static int mToolbarHeight;
    public static LinearLayout container1;
    public AppBarLayout appBarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        datas.add("a");
        datas.add("aa");
        datas.add("aaa");
        datas.add("aaaa");
        datas.add("aaaaa");
        datas.add("aaaaa");
        datas.add("b");
        datas.add("bb");
        datas.add("bbb");
        datas.add("bbbb");
        datas.add("c");
        datas.add("cc");
        datas.add("cccc");
        datas.add("ccc");
        datas.add("oranges");
        datas.add("bananas");
        datas.add("pears");
        datas.add("plums");
        //replace actionbar by toolbar
        setSupportActionBar(mToolbar);
        mToolbarHeight = Utils.getToolbarHeight(this);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        View searchview = getLayoutInflater().inflate(R.layout.activity_result, null);
//        mToolbar.addView(searchview);
        appBarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);
        AppBarLayout.LayoutParams toolbarLayoutParams = (AppBarLayout.LayoutParams) mToolbar.getLayoutParams();
        toolbarLayoutParams.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED);
        mToolbar.setLayoutParams(toolbarLayoutParams);
        drawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, mDrawerLayout, mToolbar);
        drawerFragment.setmDrawerListener(this);

//        container1 = (LinearLayout) findViewById(R.id.container1);
        //update select for display
        disPlayView(0);

    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);


        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();

            searchView.setOnQueryTextListener(this);

            final MatrixCursor matrixCursor = getCursor(suggestionsArray);
            suggestionsAdapter = new SuggestAdapter(this, matrixCursor, suggestionsArray);
            searchView.setSuggestionsAdapter(suggestionsAdapter);
            suggestionsAdapter.notifyDataSetChanged();
        }

        // search info app
//        SearchManager searchManager = (SearchManager) MainActivity.this.getSystemService(Context.SEARCH_SERVICE);
//        if (searchView != null) {
//            searchView.setSearchableInfo(searchManager.getSearchableInfo(MainActivity.this.getComponentName()));
//        }
        return true;


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerItemSelect(View v, int position) {
        disPlayView(position);
    }

    private void disPlayView(int position) {
        Fragment fragment = null;
        String title = "Materia Design";
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                title = "Home";
                break;
            case 1:
                fragment = new AppFragment();
                title = "App";
                break;
            case 2:
                fragment = new GameFragment();
                title = "Game";
                break;
        }
        if (fragment != null) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.frContain, fragment);
            ft.commit();
            getSupportActionBar().setTitle(title);
        }
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        suggestionsArray.clear();

        for (int i = 0; i < datas.size(); i++) {

            if (datas.get(i).contains(newText)) {
                suggestionsArray.add(datas.get(i));
            }
        }

        final MatrixCursor matrixCursor = getCursor(suggestionsArray);
        suggestionsAdapter = new SuggestAdapter(this, matrixCursor, suggestionsArray);
        searchView.setSuggestionsAdapter(suggestionsAdapter);
        suggestionsAdapter.notifyDataSetChanged();

        return true;
    }

    private class SuggestAdapter extends CursorAdapter implements View.OnClickListener {

        private final ArrayList<String> mObjects;
        private final LayoutInflater mInflater;
        private TextView tvSearchTerm;

        public SuggestAdapter(final Context ctx, final Cursor cursor, final ArrayList<String> mObjects) {
            super(ctx, cursor, 0);

            this.mObjects = mObjects;
            this.mInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }


        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            final View view = mInflater.inflate(R.layout.list_item_search, parent, false);

            tvSearchTerm = (TextView) view.findViewById(R.id.tvSearchTerm);

            return view;
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            tvSearchTerm = (TextView) view.findViewById(R.id.tvSearchTerm);

            final int position = cursor.getPosition();

            if (cursorInBounds(position)) {

                final String term = mObjects.get(position);
                tvSearchTerm.setText(term);

                view.setTag(position);
                view.setOnClickListener(this);

            } else {
                // Something went wrong
            }
        }

        private boolean cursorInBounds(final int position) {
            return position < mObjects.size();
        }

        @Override
        public void onClick(View v) {
            final int position = (Integer) v.getTag();

            if (cursorInBounds(position)) {

                final String selected = mObjects.get(position);

                Toast.makeText(getApplicationContext(), selected, Toast.LENGTH_SHORT).show();

                // Do something

            } else {
                // Something went wrong
            }
        }
    }

    private MatrixCursor getCursor(final ArrayList<String> suggestions) {

        final String[] columns = new String[]{COLUMN_ID, COLUMN_TERM};
        final Object[] object = new Object[]{0, DEFAULT};

        final MatrixCursor matrixCursor = new MatrixCursor(columns);

        for (int i = 0; i < suggestions.size(); i++) {

            object[0] = i;
            object[1] = suggestions.get(i);

            matrixCursor.addRow(object);
        }

        return matrixCursor;
    }
}
