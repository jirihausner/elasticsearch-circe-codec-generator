/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import { AnalysisConfig, AnalysisLimits } from '@ml/_types/Analysis'
import { ModelPlotConfig } from '@ml/_types/ModelPlot'
import { Dictionary } from '@spec_utils/Dictionary'
import { CustomSettings } from '@ml/_types/Settings'
import { Field, Id, IndexName, VersionString } from '@_types/common'
import { double, integer, long } from '@_types/Numeric'
import { DateString, Time } from '@_types/Time'
import { DiscoveryNode } from './DiscoveryNode'
import { ModelSizeStats } from './Model'

export enum JobState {
  closing = 0,
  closed = 1,
  opened = 2,
  failed = 3,
  opening = 4
}

export class JobStatistics {
  avg: double
  max: double
  min: double
  total: double
}

export class Job {
  allow_lazy_open?: boolean
  analysis_config: AnalysisConfig
  analysis_limits?: AnalysisLimits
  background_persist_interval: Time
  create_time: integer
  data_description: DataDescription
  description: string
  finished_time: integer
  job_id: Id
  job_type: string
  model_snapshot_id: Id
  model_snapshot_retention_days: long
  renormalization_window_days: long
  results_index_name?: IndexName
  results_retention_days?: long
  groups?: string[]
  model_plot_config?: ModelPlotConfig
  custom_settings?: CustomSettings
  job_version?: VersionString
  deleting?: boolean
  daily_model_snapshot_retention_after_days?: long
}

export class JobStats {
  assignment_explanation: string
  data_counts: DataCounts
  forecasts_stats: JobForecastStatistics
  job_id: string
  model_size_stats: ModelSizeStats
  node: DiscoveryNode
  open_time?: DateString
  state: JobState
  timing_stats: JobTimingStats
  deleting?: boolean
}

export class JobTimingStats {
  average_bucket_processing_time_ms: double
  bucket_count: long
  exponential_average_bucket_processing_time_ms: double
  exponential_average_bucket_processing_time_per_hour_ms: double
  job_id: Id
  total_bucket_processing_time_ms: double
  maximum_bucket_processing_time_ms: double
  minimum_bucket_processing_time_ms: double
}

export class JobForecastStatistics {
  memory_bytes?: JobStatistics
  processing_time_ms?: JobStatistics
  records?: JobStatistics
  status?: Dictionary<string, long>
  total: long
  forecasted_jobs: integer
}

export class DataCounts {
  bucket_count: long
  earliest_record_timestamp: long
  empty_bucket_count: long
  input_bytes: long
  input_field_count: long
  input_record_count: long
  invalid_date_count: long
  job_id: Id
  last_data_time: long
  latest_empty_bucket_timestamp: long
  latest_record_timestamp: long
  latest_sparse_bucket_timestamp: long
  latest_bucket_timestamp: long
  missing_field_count: long
  out_of_order_timestamp_count: long
  processed_field_count: long
  processed_record_count: long
  sparse_bucket_count: long
}

export class DataDescription {
  format?: string
  time_field: Field
  time_format?: string
  field_delimiter?: string
}
