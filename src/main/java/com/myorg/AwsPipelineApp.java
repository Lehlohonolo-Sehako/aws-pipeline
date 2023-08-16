package com.myorg;

import software.amazon.awscdk.App;
import software.amazon.awscdk.Environment;
import software.amazon.awscdk.StackProps;

public class AwsPipelineApp {
    public static void main(final String[] args) {
        App app = new App();

        new AwsPipelineStack(app, "AwsPipelineStack", StackProps.builder()
                .env(Environment.builder()
                        .account("536672707934")
                        .region("eu-west-2")
                        .build())
                .build());

        app.synth();
    }
}

