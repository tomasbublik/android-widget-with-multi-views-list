package cz.bublik.testwidgetapp.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import cz.bublik.testwidgetapp.R;
import cz.bublik.testwidgetapp.widget.model.DataModel;

import static cz.bublik.testwidgetapp.widget.AppWidget.VARIANT;
import static cz.bublik.testwidgetapp.widget.AppWidget.VARIANT_A;
import static cz.bublik.testwidgetapp.widget.Utils.dataModelIsNotEmpty;
import static cz.bublik.testwidgetapp.widget.Utils.loadDataModelFromSharedPreferences;
import static cz.bublik.testwidgetapp.widget.Utils.loadLastPage;

public class ItemsWidgetService extends RemoteViewsService {

    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new StackRemoteViewsFactory(this.getApplicationContext(), intent);
    }
}

class StackRemoteViewsFactory implements RemoteViewsService.RemoteViewsFactory {
    private static final String TAG = "StackRemoteViewsFactory";
    private Context mContext;
    private String chosenVariant = VARIANT_A;
    private DataModel dataModel;
    private DataModel.Page shownPage;

    StackRemoteViewsFactory(Context context, Intent intent) {
        mContext = context;
        chosenVariant = intent.getStringExtra(VARIANT);
    }

    public void onCreate() {
        Log.d(TAG, "onCreate");
        dataModel = loadDataModelFromSharedPreferences(mContext);
        if (dataModelIsNotEmpty(dataModel)) {
            // Show the first page
            shownPage = dataModel.getPages().get(0);
        }
    }

    public void onDestroy() {
        // In onDestroy() you should tear down anything that was setup for your data source,
        // eg. cursors, connections, etc.
    }

    public int getCount() {
        return (shownPage == null || shownPage.getItems().isEmpty()) ? 0 : (chosenVariant.equals(VARIANT_A) ? shownPage.getItems().size() : getItemsCountForAnotherVariant());
    }

    private int getItemsCountForAnotherVariant() {
        return (shownPage.getItems().size() % 2 == 0) ? (shownPage.getItems().size() / 2) : (shownPage.getItems().size() / 2) + 1;
    }

    public RemoteViews getViewAt(int position) {
        return createRemoteViewsForVariantFromShownPage(position);
    }

    private RemoteViews createRemoteViewsForVariantFromShownPage(int position) {
        if (shownPage == null) {
            shownPage = dataModel.getPages().get(0);
        }
        RemoteViews remoteViews;
        if (chosenVariant.equals(VARIANT_A)) {
            remoteViews = new RemoteViews(mContext.getPackageName(), R.layout.widget_item);

            remoteViews.setTextViewText(R.id.widget_item_text, shownPage.getItems().get(position).getItemTitle());
            remoteViews.setTextViewText(R.id.widget_item_text_small, shownPage.getItems().get(position).getItemSubTitle());
            remoteViews.setImageViewResource(R.id.widget_item_image, R.drawable.btn_green);

            if (!shownPage.getItems().get(position).isActive()) {
                remoteViews.setTextColor(R.id.widget_item_text, Color.GRAY);
                remoteViews.setTextColor(R.id.widget_item_text_small, Color.GRAY);
            } else {
                remoteViews.setTextColor(R.id.widget_item_text, Color.BLACK);
                remoteViews.setTextColor(R.id.widget_item_text_small, Color.BLACK);
            }

        } else {
            remoteViews = new RemoteViews(mContext.getPackageName(), R.layout.widget_item_doubled);

            if (shownPage.getItems().size() > (position * 2)) {
                remoteViews.setTextViewText(R.id.widget_item_text_1, shownPage.getItems().get(position * 2).getItemTitle());
                remoteViews.setTextViewText(R.id.widget_item_text_small_1, shownPage.getItems().get(position * 2).getItemSubTitle());
                remoteViews.setImageViewResource(R.id.widget_item_image_1, R.drawable.btn_green);

                if (!shownPage.getItems().get(position * 2).isActive()) {
                    remoteViews.setTextColor(R.id.widget_item_text_1, Color.GRAY);
                    remoteViews.setTextColor(R.id.widget_item_text_small_1, Color.GRAY);
                } else {
                    remoteViews.setTextColor(R.id.widget_item_text_1, Color.BLACK);
                    remoteViews.setTextColor(R.id.widget_item_text_small_1, Color.BLACK);
                }
            }

            if (shownPage.getItems().size() > (position * 2) + 1) {
                remoteViews.setTextViewText(R.id.widget_item_text_2, shownPage.getItems().get((position * 2) + 1).getItemTitle());
                remoteViews.setTextViewText(R.id.widget_item_text_small_2, shownPage.getItems().get((position * 2) + 1).getItemSubTitle());
                remoteViews.setImageViewResource(R.id.widget_item_image_2, R.drawable.btn_green);
                remoteViews.setViewVisibility(R.id.widget_item_image_2, View.VISIBLE);

                if (!shownPage.getItems().get((position * 2) + 1).isActive()) {
                    remoteViews.setTextColor(R.id.widget_item_text_2, Color.GRAY);
                    remoteViews.setTextColor(R.id.widget_item_text_small_2, Color.GRAY);
                } else {
                    remoteViews.setTextColor(R.id.widget_item_text_2, Color.BLACK);
                    remoteViews.setTextColor(R.id.widget_item_text_small_2, Color.BLACK);
                }

            } else {
                remoteViews.setTextViewText(R.id.widget_item_text_2, "");
                remoteViews.setTextViewText(R.id.widget_item_text_small_2, "");
                remoteViews.setViewVisibility(R.id.widget_item_image_2, View.INVISIBLE);
            }
        }

        return remoteViews;
    }

    public RemoteViews getLoadingView() {
        // You can create a custom loading view (for instance when getViewAt() is slow.) If you
        // return null here, you will get the default loading view.
        return null;
    }

    public int getViewTypeCount() {
        return 1;
    }

    public long getItemId(int position) {
        return position;
    }

    public boolean hasStableIds() {
        return true;
    }

    public void onDataSetChanged() {
        Log.d(TAG, "onDataSetChanged");

        shownPage = loadLastPage(dataModel, mContext);
    }

    public static final String TEST_JSON = "{\n" +
            "  \"pages\": [\n" +
            "    {\n" +
            "      \"placeName\": \"Home\",\n" +
            "      \"items\": [\n" +
            "        {\n" +
            "          \"itemIconId\": \"3\",\n" +
            "          \"itemTitle\": \"This is cheap\",\n" +
            "          \"itemSubTitle\": \"Now active\",\n" +
            "          \"active\": true\n" +
            "        },\n" +
            "        {\n" +
            "          \"itemIconId\": \"2\",\n" +
            "          \"itemTitle\": \"Car charger\",\n" +
            "          \"itemSubTitle\": \"Now till 11:30\",\n" +
            "          \"active\": true\n" +
            "        },\n" +
            "        {\n" +
            "          \"itemIconId\": \"11\",\n" +
            "          \"itemTitle\": \"Boiler heat\",\n" +
            "          \"itemSubTitle\": \"Inactive\",\n" +
            "          \"active\": false\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"placeName\": \"School\",\n" +
            "      \"items\": [\n" +
            "        {\n" +
            "          \"itemIconId\": \"3\",\n" +
            "          \"itemTitle\": \"This is cheap\",\n" +
            "          \"itemSubTitle\": \"Now active\",\n" +
            "          \"active\": true\n" +
            "        },\n" +
            "        {\n" +
            "          \"itemIconId\": \"2\",\n" +
            "          \"itemTitle\": \"Car charger\",\n" +
            "          \"itemSubTitle\": \"Now till 11:30\",\n" +
            "          \"active\": true\n" +
            "        },\n" +
            "        {\n" +
            "          \"itemIconId\": \"11\",\n" +
            "          \"itemTitle\": \"Boiler heat\",\n" +
            "          \"itemSubTitle\": \"Inactive\",\n" +
            "          \"active\": false\n" +
            "        },\n" +
            "        {\n" +
            "          \"itemIconId\": \"6\",\n" +
            "          \"itemTitle\": \"Another heat\",\n" +
            "          \"itemSubTitle\": \"Inactive\",\n" +
            "          \"active\": false\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"placeName\": \"Multi-items\",\n" +
            "      \"items\": [\n" +
            "        {\n" +
            "          \"itemIconId\": \"3\",\n" +
            "          \"itemTitle\": \"This is cheap\",\n" +
            "          \"itemSubTitle\": \"Now active\",\n" +
            "          \"active\": true\n" +
            "        },\n" +
            "        {\n" +
            "          \"itemIconId\": \"2\",\n" +
            "          \"itemTitle\": \"Car charger\",\n" +
            "          \"itemSubTitle\": \"Now till 11:30\",\n" +
            "          \"active\": true\n" +
            "        },\n" +
            "        {\n" +
            "          \"itemIconId\": \"11\",\n" +
            "          \"itemTitle\": \"Boiler heat\",\n" +
            "          \"itemSubTitle\": \"Inactive\",\n" +
            "          \"active\": false\n" +
            "        },\n" +
            "        {\n" +
            "          \"itemIconId\": \"6\",\n" +
            "          \"itemTitle\": \"Another heat\",\n" +
            "          \"itemSubTitle\": \"Inactive\",\n" +
            "          \"active\": false\n" +
            "        },\n" +
            "        {\n" +
            "          \"itemIconId\": \"3\",\n" +
            "          \"itemTitle\": \"This is cheap\",\n" +
            "          \"itemSubTitle\": \"Now active\",\n" +
            "          \"active\": true\n" +
            "        },\n" +
            "        {\n" +
            "          \"itemIconId\": \"2\",\n" +
            "          \"itemTitle\": \"Car charger\",\n" +
            "          \"itemSubTitle\": \"Now till 11:30\",\n" +
            "          \"active\": true\n" +
            "        },\n" +
            "        {\n" +
            "          \"itemIconId\": \"11\",\n" +
            "          \"itemTitle\": \"Boiler heat\",\n" +
            "          \"itemSubTitle\": \"Inactive\",\n" +
            "          \"active\": false\n" +
            "        },\n" +
            "        {\n" +
            "          \"itemIconId\": \"6\",\n" +
            "          \"itemTitle\": \"Another heat\",\n" +
            "          \"itemSubTitle\": \"Inactive\",\n" +
            "          \"active\": false\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  ]\n" +
            "}";
}