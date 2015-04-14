package com.macroyau.thingspeakandroid;

import com.macroyau.thingspeakandroid.model.TalkBackCommand;

import java.util.List;

import retrofit.Callback;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.Query;

/***
 * Java interface representation of the ThingSpeak TalkBack API using the Retrofit library.
 *
 * @author Macro Yau
 */
public interface TalkBackService {

    @POST("/talkbacks/{id}/commands.json")
    void addCommand(@Path("id") Long talkBackId, @Query("api_key") String apiKey, @Query("command_string") String commandString, @Query("position") Integer position, Callback<TalkBackCommand> callback);

    @GET("/talkbacks/{id}/commands/{command}.json")
    void getCommand(@Path("id") Long talkBackId, @Path("command") Long commandId, @Query("api_key") String apiKey, Callback<TalkBackCommand> callback);

    @PUT("/talkbacks/{id}/commands/{command}.json")
    void updateCommand(@Path("id") Long talkBackId, @Path("command") Long commandId, @Query("api_key") String apiKey, @Query("command_string") String commandString, @Query("position") Integer position, Callback<TalkBackCommand> callback);

    @POST("/talkbacks/{id}/commands/execute.json")
    void executeNextCommand(@Path("id") Long talkBackId, @Query("api_key") String apiKey, Callback<TalkBackCommand> callback);

    @GET("/talkbacks/{id}/commands/last.json")
    void getLastExecutedCommand(@Path("id") Long talkBackId, @Query("api_key") String apiKey, Callback<TalkBackCommand> command);

    @DELETE("/talkbacks/{id}/commands/{command}.json")
    void deleteCommand(@Path("id") Long talkBackId, @Path("command") Long commandId, @Query("api_key") String apiKey, Callback<TalkBackCommand> callback);

    @GET("/talkbacks/{id}/commands.json")
    void listAllCommands(@Path("id") Long talkBackId, @Query("api_key") String apiKey, Callback<List<TalkBackCommand>> callback);

    @DELETE("/talkbacks/{id}/commands.json")
    void deleteAllCommands(@Path("id") Long talkBackId, @Query("api_key") String apiKey, Callback<List<TalkBackCommand>> callback);

}
