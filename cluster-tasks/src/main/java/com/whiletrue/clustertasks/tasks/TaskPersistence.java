package com.whiletrue.clustertasks.tasks;

import java.time.Instant;
import java.util.List;

public interface TaskPersistence {

    List<TaskWrapper<?>> pollForNextTasks(int maxTasks) throws Exception;
    List<TaskWrapper<?>> findClaimedTasks(List<TaskWrapper<?>> tasks) throws Exception;

    int tryClaimTasks(List<TaskWrapper<?>> tasks);

    <INPUT> String queueTask(Task<INPUT> task, INPUT input) throws Exception;
    <INPUT> String queueTask(Task<INPUT> task, INPUT input, int priority) throws Exception;
    <INPUT> String queueTaskDelayed(Task<INPUT> task, INPUT input, long startDelayInMilliseconds) throws Exception;
    <INPUT> String queueTaskDelayed(Task<INPUT> task, INPUT input, long startDelayInMilliseconds, int priority) throws Exception;

    void deleteTask(String id);
    void unlockAndChangeStatus(List<TaskWrapper<?>> tasks, TaskStatus status);

    void unlockAndMarkForRetry(TaskWrapper<?> task, int retryCount, Instant newScheduledTime);

    TaskWrapper<?> getTask(String taskId);

    TaskStatus getTaskStatus(String taskId);
}
