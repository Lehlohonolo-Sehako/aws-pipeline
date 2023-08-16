package com.myorg;

import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.pipelines.CodePipeline;
import software.amazon.awscdk.pipelines.CodePipelineSource;
import software.amazon.awscdk.pipelines.ShellStep;
import software.constructs.Construct;

import java.util.ArrayList;
import java.util.List;

public class AwsPipelineStack extends Stack {
    public AwsPipelineStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public AwsPipelineStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        List<String> commands = new ArrayList<>();
        commands.add("mvn package");
        commands.add("npx cdk synth");

        CodePipeline demoCiCdPipeline = CodePipeline.Builder.create(this, "DemoPipelineId")
                .synth(ShellStep.Builder.create("Synth")
                        .input(CodePipelineSource.gitHub("Lehlohonolo-Sehako/aws-pipeline", "main"))
                        .commands(commands)
                        .build())
                .build();
    }
}
