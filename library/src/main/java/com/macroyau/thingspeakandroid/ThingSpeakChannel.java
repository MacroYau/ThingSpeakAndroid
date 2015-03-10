package com.macroyau.thingspeakandroid;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.macroyau.thingspeakandroid.model.ChannelFeed;
import com.macroyau.thingspeakandroid.model.Feed;
import com.macroyau.thingspeakandroid.model.StatusUpdates;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;

/***
 * Java representation of a ThingSpeak Channel.
 *
 * @author Macro Yau
 */
public class ThingSpeakChannel {

    /***
     * Listener for Channel feed update events.
     */
    public interface ChannelFeedUpdateListener {

        /***
         * The specific Channel feed is updated.
         *
         * @param channelId The ID of this specific Channel.
         * @param channelName The name of this specific Channel.
         * @param channelFeed The specific Channel feed.
         */
        void onChannelFeedUpdated(long channelId, String channelName, ChannelFeed channelFeed);

    }

    /***
     * Listener for feed entry update events.
     */
    public interface FeedEntryUpdateListener {

        /***
         * The specific feed entry is updated.
         *
         * @param channelId The ID of this specific Channel.
         * @param entryId The ID of this specific feed entry.
         * @param feed The feed entry.
         */
        void onFeedUpdated(long channelId, long entryId, Feed feed);

    }

    /***
     * Listener for Channel field feed update events.
     */
    public interface ChannelFieldFeedUpdateListener {

        /***
         * The specific Channel field feed is updated.
         *
         * @param channelId The ID of this specific Channel.
         * @param fieldId The ID of this specific field.
         * @param channelFieldFeed The Channel field feed.
         */
        void onChannelFieldFeedUpdated(long channelId, int fieldId, ChannelFeed channelFieldFeed);

    }

    /***
     * Listener for Channel status update events.
     */
    public interface ChannelStatusUpdateListener {

        /***
         * The specific Channel status is updated.
         *
         * @param channelId The ID of this specific Channel.
         * @param statusUpdates The status updates.
         */
        void onChannelStatusUpdated(long channelId, StatusUpdates statusUpdates);

    }

    private static final String THINGSPEAK_API = "https://api.thingspeak.com";
    private static final String REQUEST_PARAMS_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private ChannelFeedUpdateListener mChannelFeedUpdateListener;
    private FeedEntryUpdateListener mFeedUpdateListener;
    private ChannelFieldFeedUpdateListener mChannelFieldFeedUpdateListener;
    private ChannelStatusUpdateListener mChannelStatusUpdateListener;

    private ThingSpeakService mService;

    private long mChannelId;
    private String mReadApiKey;
    private int mResults = 100;
    private int mDays = -1;
    private String mTimezone;
    private Date mStartDate, mEndDate;
    private String mTimescale;

    /***
     * Constructor for public Channels.
     *
     * @param channelId The ID of this specific Channel.
     */
    public ThingSpeakChannel(long channelId) {
        this(channelId, null);
    }

    /***
     * Constructor for private Channels.
     *
     * @param channelId The ID of this specific Channel.
     * @param readApiKey The Read API Key for this specific Channel.
     */
    public ThingSpeakChannel(long channelId, String readApiKey) {
        this.mChannelId = channelId;
        this.mReadApiKey = readApiKey;

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(THINGSPEAK_API)
                .setConverter(new GsonConverter(gson))
                .build();

        mService = restAdapter.create(ThingSpeakService.class);
    }

    /***
     * Set the {@link com.macroyau.thingspeakandroid.ThingSpeakChannel.ChannelFeedUpdateListener} to use.
     *
     * @param listener The listener.
     */
    public void setChannelFeedUpdateListener(ChannelFeedUpdateListener listener) {
        this.mChannelFeedUpdateListener = listener;
    }

    /***
     * Set the {@link com.macroyau.thingspeakandroid.ThingSpeakChannel.FeedEntryUpdateListener} to use.
     *
     * @param listener The listener.
     */
    public void setFeedUpdateListener(FeedEntryUpdateListener listener) {
        this.mFeedUpdateListener = listener;
    }

    /***
     * Set the {@link com.macroyau.thingspeakandroid.ThingSpeakChannel.ChannelFieldFeedUpdateListener} to use.
     *
     * @param listener The listener.
     */
    public void setChannelFieldFeedUpdateListener(ChannelFieldFeedUpdateListener listener) {
        this.mChannelFieldFeedUpdateListener = listener;
    }

    /***
     * Set the {@link com.macroyau.thingspeakandroid.ThingSpeakChannel.ChannelStatusUpdateListener} to use.
     *
     * @param listener The listener.
     */
    public void setChannelStatusUpdateListener(ChannelStatusUpdateListener listener) {
        this.mChannelStatusUpdateListener = listener;
    }

    /***
     * Set the Read API Key for a private channel.
     *
     * @param readApiKey The Read API Key for this specific Channel.
     */
    public void setReadApiKey(String readApiKey) {
        this.mReadApiKey = readApiKey;
    }

    /***
     * Set the timezone for all requests in this specific Channel.
     *
     * @param timezone A valid timezone identifier (https://thingspeak.com/docs#timezones).
     */
    public void setTimezone(String timezone) {
        this.mTimezone = timezone;
    }

    /***
     * Set the number of feed entries to be retrieved for all requests in this specific Channel.
     *
     * @param results The number of entries.
     */
    public void setNumberOfEntries(int results) {
        this.mResults = results;
    }

    /***
     * Set the number of 24-hour periods before now to include in feed entries to be retrieved for all requests in this specific Channel.
     *
     * @param days The number of 24-hour periods before now.
     */
    public void setDaysToInclude(int days) {
        this.mDays = days;
    }

    /***
     * Set the start date of feed entries for all requests in this specific Channel.
     *
     * @param start The start date.
     */
    public void setStartDate(Date start) {
        this.mStartDate = start;
    }

    /***
     * Set the end date of feed entries for all requests in this specific Channel.
     *
     * @param end The end date.
     */
    public void setEndDate(Date end) {
        this.mEndDate = end;
    }

    /***
     * Set the timescale of feed entries, i.e. get first value in the specific many minutes, for all requests in this specific Channel. Valid values include 10, 15, 20, 30, 60, 240, 720, 1440, 9999 (daily).
     *
     * @param timescale A valid timescale value.
     */
    public void setTimescale(int timescale) {
        if (validateTimescale(timescale)) {
            if (timescale == 9999)
                mTimescale = "daily";
            else
                mTimescale = Integer.toString(timescale);
        }
    }

    private boolean validateTimescale(int timescale) {
        return (timescale == 10 || timescale == 15 || timescale == 20 ||
                timescale == 30 || timescale == 60 || timescale == 240 ||
                timescale == 720 || timescale == 1440 || timescale == 9999);
    }

    private Map<String, String> getEntryRequestParams() {
        final DateFormat df = new SimpleDateFormat(REQUEST_PARAMS_DATE_FORMAT);
        Map<String, String> params = new HashMap<>();

        if (mReadApiKey != null)
            params.put("api_key", mReadApiKey);
        if (mTimezone != null)
            params.put("timezone", mTimezone);

        return params;
    }

    private Map<String, String> getChannelRequestParams() {
        final DateFormat df = new SimpleDateFormat(REQUEST_PARAMS_DATE_FORMAT);
        Map<String, String> params = new HashMap<>();

        if (mReadApiKey != null)
            params.put("api_key", mReadApiKey);
        params.put("results", Integer.toString(mResults));
        if (mDays != -1)
            params.put("days", Integer.toString(mDays));
        if (mStartDate != null)
            params.put("start", df.format(mStartDate));
        if (mEndDate != null)
            params.put("end", df.format(mEndDate));
        if (mTimezone != null)
            params.put("timezone", mTimezone);
        if (mTimescale != null)
            params.put("timescale", mTimescale);

        return params;
    }

    /***
     * Return the configured ThingSpeakService instance for direct REST API operations of this specific Channel.
     *
     * @return The configured ThingSpeakService instance.
     */
    public ThingSpeakService getService() {
        return mService;
    }

    /***
     * Return the ID of this specific Channel.
     *
     * @return The ID of this specific Channel.
     */
    public long getChannelId() {
        return mChannelId;
    }

    /***
     * Retrieve the Channel Feed of this specific Channel asynchronously.
     */
    public void loadChannelFeed() {
        mService.getChannelFeed(mChannelId, getChannelRequestParams(), new Callback<ChannelFeed>() {
            @Override
            public void success(ChannelFeed channelFeed, Response response) {
                if (mChannelFeedUpdateListener != null) {
                    mChannelFeedUpdateListener.onChannelFeedUpdated(mChannelId, channelFeed.getChannel().getName(), channelFeed);
                }
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    /***
     * Retrieve the last entry in this specific Channel Feed asynchronously.
     */
    public void loadLastEntryInChannelFeed() {
        mService.getLastEntryInChannelFeed(mChannelId, getEntryRequestParams(), new Callback<Feed>() {
            @Override
            public void success(Feed feed, Response response) {
                if (mFeedUpdateListener != null) {
                    mFeedUpdateListener.onFeedUpdated(mChannelId, feed.getEntryId(), feed);
                }
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    /***
     * Retrieve a specific entry in this specific Channel Feed asynchronously.
     *
     * @param entryId The ID of a feed entry.
     */
    public void loadSpecificEntryInChannelFeed(final long entryId) {
        mService.getSpecificEntryInChannelFeed(mChannelId, entryId, getEntryRequestParams(), new Callback<Feed>() {
            @Override
            public void success(Feed feed, Response response) {
                if (mFeedUpdateListener != null) {
                    mFeedUpdateListener.onFeedUpdated(mChannelId, entryId, feed);
                }
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    /***
     * Retrieve a specific field feed of this specific Channel asynchronously.
     *
     * @param fieldId The ID of a field.
     */
    public void loadChannelFieldFeed(final int fieldId) {
        if (fieldId < 1 || fieldId > 8)
            return;

        mService.getChannelFieldFeed(mChannelId, fieldId, getChannelRequestParams(), new Callback<ChannelFeed>() {
            @Override
            public void success(ChannelFeed channelFeed, Response response) {
                if (mChannelFieldFeedUpdateListener != null) {
                    mChannelFieldFeedUpdateListener.onChannelFieldFeedUpdated(mChannelId, fieldId, channelFeed);
                }
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    /***
     * Retrieve the status updates of this specific Channel asynchronously.
     */
    public void loadStatusUpdates() {
        mService.getStatusUpdates(mChannelId, getEntryRequestParams(), new Callback<StatusUpdates>() {
            @Override
            public void success(StatusUpdates statusUpdates, Response response) {
                if (mChannelStatusUpdateListener != null) {
                    mChannelStatusUpdateListener.onChannelStatusUpdated(mChannelId, statusUpdates);
                }
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

}
