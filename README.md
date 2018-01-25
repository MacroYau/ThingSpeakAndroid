# ThingSpeakAndroid

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-ThingSpeakAndroid-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/1645)

Unofficial [ThingSpeak](https://thingspeak.com) API library for Android.

## Features

* Convenient access to [ThingSpeak API](http://community.thingspeak.com/documentation/api/)
* Support for [TalkBack API](https://thingspeak.com/docs/talkback)
* Asynchronous data fetching using [Retrofit](http://square.github.io/retrofit/)
* Customizable charting based on [HelloCharts for Android](https://github.com/lecho/hellocharts-android)

## Download

ThingSpeakAndroid is available on the jCenter repository. If you are using Android Studio, you can simply add a dependency on your app module's `build.gradle` file to import this library.

```Gradle
dependencies {
    compile 'com.macroyau:thingspeakandroid:0.2.2'
}
```

Please add the following lines to the `build.gradle` file if Android Studio fails to resolve the jCenter repository.

```Gradle
repositories {
    maven {
        url "http://dl.bintray.com/macroyau/maven"
    }
}
```

## Usage

Using ThingSpeakAndroid is extremely easy. Create a `ThingSpeakChannel`, set an event listener and load the data!

```java
ThingSpeakChannel tsChannel = new ThingSpeakChannel(CHANNEL_ID);
tsChannel.setChannelFeedUpdateListener(new ThingSpeakChannel.ChannelFeedUpdateListener() {
    @Override
    public void onChannelFeedUpdated(long channelId, String channelName, ChannelFeed channelFeed) {
        // Make use of your Channel feed here!
    }
});
tsChannel.loadChannelFeed();
```

If you want to connect to a private Channel, you need to provide a valid [Read API Key](https://thingspeak.com/docs/channels#api_keys).

```java
ThingSpeakChannel tsPrivateChannel = new ThingSpeakChannel(CHANNEL_ID, READ_API_KEY);
```

You can also create a line chart of a specific Channel field using [HelloCharts for Android](https://github.com/lecho/hellocharts-android).

```java
LineChartView chartView = (LineChartView) findViewById(R.id.chart);
tsChart = new ThingSpeakLineChart(CHANNEL_ID, FIELD_ID);
tsChart.setListener(new ThingSpeakLineChart.ChartDataUpdateListener() {
    @Override
    public void onChartDataUpdated(long channelId, int fieldId, String title, LineChartData lineChartData, Viewport maxViewport, Viewport initialViewport) {
        chartView.setLineChartData(lineChartData);
        chartView.setMaximumViewport(maxViewport);
        chartView.setCurrentViewport(initialViewport);
    }
});
tsChart.loadChartData();
```

Please read the API documentation and sample app [source code](https://github.com/MacroYau/ThingSpeakAndroid/blob/master/app/src/main/java/com/macroyau/thingspeakandroid/demo/DemoActivity.java) for further details. Sample for TalkBack is coming soon.

## License

```
Copyright 2018 Macro Yau

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
