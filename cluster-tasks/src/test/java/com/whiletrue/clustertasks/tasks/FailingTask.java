package com.whiletrue.clustertasks.tasks;

public class FailingTask extends Task<String> {

    @Override
    public void run(String s, TaskExecutionContext taskExecutionContext) throws Exception {
        throw new Exception("This task always fails");
    }
}
