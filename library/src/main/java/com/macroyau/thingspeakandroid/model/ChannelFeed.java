package com.macroyau.thingspeakandroid.model;

import java.util.List;

/***
 * Data model of a ThingSpeak Channel feed. Refer to https://thingspeak.com/docs/channels#get_feed for details.
 *
 * @author Macro Yau
 */
public class ChannelFeed {

    private Channel channel;
    private List<Feed> feeds;

    /***
     * Get the basic information of the Channel.
     *
     * @return the Channel
     */
    public Channel getChannel() {
        return channel;
    }

    /***
     * Get the feed entries of the Channel.
     *
     * @return the feed entries
     */
    public List<Feed> getFeeds() {
        return feeds;
    }

}
