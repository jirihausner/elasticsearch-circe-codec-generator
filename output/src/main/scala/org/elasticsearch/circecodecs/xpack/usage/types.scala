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

package org.elasticsearch.circecodecs.xpack.usage

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._ilm._types.Phase.{ Phases }
import org.elasticsearch.circecodecs._slm._types.SnapshotLifecycle.{ Statistics }
import org.elasticsearch.circecodecs._spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs._types.common.{ ByteSize, EmptyObject, Field, Name }
import org.elasticsearch.circecodecs._ml._types.Job.{ Job, JobStatistics }
import org.elasticsearch.circecodecs._types.Numeric.{ integer, long, uint, ulong }

@JsonCodec case class Base(
	available: Boolean, 
	enabled: Boolean
)

@JsonCodec case class Counter(
	active: long, 
	total: long
)

@JsonCodec case class FeatureToggle(
	enabled: Boolean
)

@JsonCodec case class BaseUrlConfig(
	url_name: String, 
	url_value: String
)

@JsonCodec case class KibanaUrlConfig(
	time_range: String
) extends BaseUrlConfig
type UrlConfig = BaseUrlConfig | KibanaUrlConfig

@JsonCodec case class AlertingExecution(
	actions: Dictionary[String, ExecutionAction]
)

@JsonCodec case class AlertingInput(
	input: Dictionary[String, Counter], 
	trigger: Dictionary[String, Counter]
)

@JsonCodec case class AnalyticsStatistics(
	boxplot_usage: long, 
	cumulative_cardinality_usage: long, 
	string_stats_usage: long, 
	top_metrics_usage: long, 
	t_test_usage: long, 
	moving_percentiles_usage: long, 
	normalize_usage: long, 
	rate_usage: long, 
	multi_terms_usage: long
)

@JsonCodec case class Audit(
	outputs: Seq[String]
) extends FeatureToggle

@JsonCodec case class Datafeed(
	count: long
)

@JsonCodec case class DataStreams(
	data_streams: long, 
	indices_count: long
) extends Base

@JsonCodec case class DataTierPhaseStatistics(
	node_count: long, 
	index_count: long, 
	total_shard_count: long, 
	primary_shard_count: long, 
	doc_count: long, 
	total_size_bytes: long, 
	primary_size_bytes: long, 
	primary_shard_size_avg_bytes: long, 
	primary_shard_size_median_bytes: long, 
	primary_shard_size_mad_bytes: long
)

@JsonCodec case class EqlFeatures(
	join: uint, 
	joins: EqlFeaturesJoin, 
	keys: EqlFeaturesKeys, 
	event: uint, 
	pipes: EqlFeaturesPipes, 
	sequence: uint, 
	sequences: EqlFeaturesSequences
)

@JsonCodec case class EqlFeaturesJoin(
	join_queries_two: uint, 
	join_queries_three: uint, 
	join_until: uint, 
	join_queries_five_or_more: uint, 
	join_queries_four: uint
)

@JsonCodec case class EqlFeaturesKeys(
	join_keys_two: uint, 
	join_keys_one: uint, 
	join_keys_three: uint, 
	join_keys_five_or_more: uint, 
	join_keys_four: uint
)

@JsonCodec case class EqlFeaturesPipes(
	pipe_tail: uint, 
	pipe_head: uint
)

@JsonCodec case class EqlFeaturesSequences(
	sequence_queries_three: uint, 
	sequence_queries_four: uint, 
	sequence_queries_two: uint, 
	sequence_until: uint, 
	sequence_queries_five_or_more: uint, 
	sequence_maxspan: uint
)

@JsonCodec case class ExecutionAction(
	total: long, 
	total_in_ms: long
)

@JsonCodec case class ForecastStatistics(
	forecasted_jobs: long, 
	memory_bytes: JobStatistics, 
	processing_time_ms: JobStatistics, 
	records: JobStatistics, 
	status: Dictionary[String, long], 
	total: long
)

@JsonCodec case class IlmPolicyStatistics(
	indices_managed: integer, 
	phases: Phases
)

@JsonCodec case class Ilm(
	policy_count: integer, 
	policy_stats: Seq[IlmPolicyStatistics]
)

@JsonCodec case class IpFilter(
	http: Boolean, 
	transport: Boolean
)

@JsonCodec case class MlJobForecasts(
	total: long, 
	forecasted_jobs: long
)

@JsonCodec case class MlDataFrameAnalyticsJobs(
	memory_usage: MlDataFrameAnalyticsJobsMemory, 
	_all: MlDataFrameAnalyticsJobsCount, 
	analysis_counts: EmptyObject
)

@JsonCodec case class MlDataFrameAnalyticsJobsMemory(
	peak_usage_bytes: JobStatistics
)

@JsonCodec case class MlDataFrameAnalyticsJobsCount(
	count: long
)

@JsonCodec case class MlInference(
	ingest_processors: Dictionary[String, MlInferenceIngestProcessor], 
	trained_models: MlInferenceTrainedModels
)

@JsonCodec case class MlInferenceIngestProcessor(
	num_docs_processed: MlInferenceIngestProcessorCount, 
	pipelines: MlCounter, 
	num_failures: MlInferenceIngestProcessorCount, 
	time_ms: MlInferenceIngestProcessorCount
)

@JsonCodec case class MlInferenceTrainedModels(
	estimated_operations: JobStatistics, 
	estimated_heap_memory_usage_bytes: JobStatistics, 
	count: MlInferenceTrainedModelsCount, 
	_all: MlCounter
)

@JsonCodec case class MlInferenceIngestProcessorCount(
	max: long, 
	sum: long, 
	min: long
)

@JsonCodec case class MlInferenceTrainedModelsCount(
	total: long, 
	prepackaged: long, 
	other: long, 
	regression: long, 
	classification: long
)

@JsonCodec case class MlCounter(
	count: long
)

@JsonCodec case class Query(
	count: integer, 
	failed: integer, 
	paging: integer, 
	total: integer
)

@JsonCodec case class RealmCache(
	size: long
)

@JsonCodec case class RoleMapping(
	enabled: integer, 
	size: integer
)

@JsonCodec case class RuntimeFieldTypes(
	field_types: Seq[RuntimeFieldsType]
) extends Base

@JsonCodec case class RuntimeFieldsType(
	chars_max: long, 
	chars_total: long, 
	count: long, 
	doc_max: long, 
	doc_total: long, 
	index_count: long, 
	lang: Seq[String], 
	lines_max: long, 
	lines_total: long, 
	name: Field, 
	scriptless_count: long, 
	shadowed_count: long, 
	source_max: long, 
	source_total: long
)

@JsonCodec case class SecurityRoles(
	native: SecurityRolesNative, 
	dls: SecurityRolesDls, 
	file: SecurityRolesFile
)

@JsonCodec case class SecurityRolesNative(
	dls: Boolean, 
	fls: Boolean, 
	size: long
)

@JsonCodec case class SecurityRolesDls(
	bit_set_cache: SecurityRolesDlsBitSetCache
)

@JsonCodec case class SecurityRolesDlsBitSetCache(
	count: integer, 
	memory: ByteSize, 
	memory_in_bytes: ulong
)

@JsonCodec case class SecurityRolesFile(
	dls: Boolean, 
	fls: Boolean, 
	size: long
)

@JsonCodec case class Alerting(
	count: Counter, 
	execution: AlertingExecution, 
	watch: AlertingInput
) extends Base

@JsonCodec case class Analytics(
	stats: AnalyticsStatistics
) extends Base

@JsonCodec case class Ccr(
	auto_follow_patterns_count: integer, 
	follower_indices_count: integer
) extends Base

@JsonCodec case class DataTiers(
	data_warm: DataTierPhaseStatistics, 
	data_frozen: DataTierPhaseStatistics, 
	data_cold: DataTierPhaseStatistics, 
	data_content: DataTierPhaseStatistics, 
	data_hot: DataTierPhaseStatistics
) extends Base

@JsonCodec case class Eql(
	features: EqlFeatures, 
	queries: Dictionary[String, Query]
) extends Base

@JsonCodec case class Flattened(
	field_count: integer
) extends Base

@JsonCodec case class FrozenIndices(
	indices_count: long
) extends Base

@JsonCodec case class MachineLearning(
	datafeeds: Dictionary[String, Datafeed], 
	jobs: Dictionary[String, Job], 
	node_count: integer, 
	data_frame_analytics_jobs: MlDataFrameAnalyticsJobs, 
	inference: MlInference
) extends Base

@JsonCodec case class Monitoring(
	collection_enabled: Boolean, 
	enabled_exporters: Dictionary[String, long]
) extends Base

@JsonCodec case class Sql(
	features: Dictionary[String, integer], 
	queries: Dictionary[String, Query]
) extends Base

@JsonCodec case class Ssl(
	http: FeatureToggle, 
	transport: FeatureToggle
)

@JsonCodec case class WatcherActions(
	actions: Dictionary[Name, WatcherActionTotals]
)

@JsonCodec case class WatcherWatch(
	input: Dictionary[Name, Counter], 
	condition: Dictionary[Name, Counter], 
	action: Dictionary[Name, Counter], 
	trigger: WatcherWatchTrigger
)

@JsonCodec case class WatcherWatchTrigger(
	schedule: WatcherWatchTriggerSchedule, 
	_all: Counter
)

@JsonCodec case class WatcherActionTotals(
	total: long, 
	total_time_in_ms: long
)

@JsonCodec case class Realm(
	name: Seq[String], 
	order: Seq[long], 
	size: Seq[long], 
	cache: Seq[RealmCache], 
	has_authorization_realms: Seq[Boolean], 
	has_default_username_pattern: Seq[Boolean], 
	has_truststore: Seq[Boolean], 
	is_authentication_delegated: Seq[Boolean]
) extends Base

@JsonCodec case class SearchableSnapshots(
	indices_count: integer, 
	full_copy_indices_count: integer, 
	shared_cache_indices_count: integer
) extends Base

@JsonCodec case class Security(
	api_key_service: FeatureToggle, 
	anonymous: FeatureToggle, 
	audit: Audit, 
	fips_140: FeatureToggle, 
	ipfilter: IpFilter, 
	realms: Dictionary[String, Realm], 
	role_mapping: Dictionary[String, RoleMapping], 
	roles: SecurityRoles, 
	ssl: Ssl, 
	system_key: FeatureToggle, 
	token_service: FeatureToggle, 
	operator_privileges: Base
) extends Base

@JsonCodec case class Slm(
	policy_count: integer, 
	policy_stats: Statistics
) extends Base

@JsonCodec case class Vector(
	dense_vector_dims_avg_count: integer, 
	dense_vector_fields_count: integer, 
	sparse_vector_fields_count: integer
) extends Base

@JsonCodec case class Watcher(
	execution: WatcherActions, 
	watch: WatcherWatch, 
	count: Counter
) extends Base

@JsonCodec case class WatcherWatchTriggerSchedule(
	cron: Counter, 
	_all: Counter
) extends Counter
