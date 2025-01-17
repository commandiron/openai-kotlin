package com.aallam.openai.client

import com.aallam.openai.api.ExperimentalOpenAI
import com.aallam.openai.api.finetune.*
import com.aallam.openai.api.model.ModelId
import kotlinx.coroutines.flow.Flow

/**
 * Manage fine-tuning jobs to tailor a model to your specific training data.
 */
public interface FineTunes {

    /**
     * Creates a job that fine-tunes a specified model from a given dataset.
     *
     * Response includes details of the enqueued job including job status and the name of the fine-tuned models once
     * complete.
     */
    @ExperimentalOpenAI
    public suspend fun fineTune(request: FineTuneRequest): FineTune

    /**
     * List your organization's fine-tuning jobs.
     */
    @ExperimentalOpenAI
    public suspend fun fineTunes(): List<FineTune>

    /**
     * Gets info about to fine-tune job.
     */
    @ExperimentalOpenAI
    public suspend fun fineTune(fineTuneId: FineTuneId): FineTune?

    /**
     * Immediately cancel a fine-tune job.
     */
    @ExperimentalOpenAI
    public suspend fun cancel(fineTuneId: FineTuneId): FineTune?

    /**
     * Get fine-grained status updates for fine-tune job.
     */
    @ExperimentalOpenAI
    public suspend fun fineTuneEvents(fineTuneId: FineTuneId): List<FineTuneEvent>

    /**
     * Get fine-grained status updates for fine-tune job.
     */
    @ExperimentalOpenAI
    public fun fineTuneEventsFlow(fineTuneId: FineTuneId): Flow<FineTuneEvent>

    /**
     * Delete a fine-tuned model. You must have the Owner role in your organization.
     */
    @ExperimentalOpenAI
    public suspend fun delete(fineTuneModel: ModelId): Boolean
}
