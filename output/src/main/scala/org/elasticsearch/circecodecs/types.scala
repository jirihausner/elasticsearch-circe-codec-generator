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

package org.elasticsearch.circecodecs

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

@JsonCodec case class BulkCreateOperation extends BulkOperation

@JsonCodec case class BulkCreateResponseItem extends BulkResponseItemBase

@JsonCodec case class BulkDeleteOperation extends BulkOperation

@JsonCodec case class BulkDeleteResponseItem extends BulkResponseItemBase

@JsonCodec case class BulkIndexOperation extends BulkOperation

@JsonCodec case class BulkIndexResponseItem extends BulkResponseItemBase

@JsonCodec case class BulkOperation(
	_id: Id, 
	_index: IndexName, 
	retry_on_conflict: integer, 
	routing: Routing, 
	version: VersionNumber, 
	version_type: VersionType
)

@JsonCodec case class BulkOperationContainer(
	index: BulkIndexOperation, 
	create: BulkCreateOperation, 
	update: BulkUpdateOperation, 
	delete: BulkDeleteOperation
)

@JsonCodec case class BulkRequest[TSource = None](
	index: IndexName, 
	`type`: Type, 
	pipeline: String, 
	refresh: Refresh, 
	routing: Routing, 
	_source: Boolean | Fields, 
	_source_excludes: Fields, 
	_source_includes: Fields, 
	timeout: Time, 
	wait_for_active_shards: WaitForActiveShards, 
	require_alias: Boolean, 
	body: Seq[BulkOperationContainer | TSource]
) extends RequestBase

@JsonCodec case class BulkResponse(
	errors: Boolean, 
	items: Seq[BulkResponseItemContainer], 
	took: long, 
	ingest_took: long
)

@JsonCodec case class BulkResponseItemBase(
	_id: String | null, 
	_index: String, 
	status: integer, 
	error: ErrorCause, 
	_primary_term: long, 
	result: String, 
	_seq_no: SequenceNumber, 
	_shards: ShardStatistics, 
	_type: String, 
	_version: VersionNumber, 
	forced_refresh: Boolean, 
	get: InlineGet[Record[String, Any]]
)

@JsonCodec case class BulkResponseItemContainer(
	index: BulkIndexResponseItem, 
	create: BulkCreateResponseItem, 
	update: BulkUpdateResponseItem, 
	delete: BulkDeleteResponseItem
)

@JsonCodec case class BulkUpdateOperation extends BulkOperation

@JsonCodec case class BulkUpdateResponseItem extends BulkResponseItemBase

@JsonCodec case class ClearScrollRequest(
	scroll_id: Ids, 
	body: Body
) extends RequestBase

object ClearScrollRequest {
	@JsonCodec case class Body(
		scroll_id: Ids
	)
}


@JsonCodec case class ClearScrollResponse(
	succeeded: Boolean, 
	num_freed: integer
)

@JsonCodec case class ClosePointInTimeRequest(
	body: Body
) extends RequestBase

object ClosePointInTimeRequest {
	@JsonCodec case class Body(
		id: Id
	)
}


@JsonCodec case class ClosePointInTimeResponse(
	succeeded: Boolean, 
	num_freed: integer
)

@JsonCodec case class CountRequest(
	index: Indices, 
	`type`: Types, 
	allow_no_indices: Boolean, 
	analyzer: String, 
	analyze_wildcard: Boolean, 
	default_operator: DefaultOperator, 
	df: String, 
	expand_wildcards: ExpandWildcards, 
	ignore_throttled: Boolean, 
	ignore_unavailable: Boolean, 
	lenient: Boolean, 
	min_score: double, 
	preference: String, 
	query_on_query_string: String, 
	routing: Routing, 
	terminate_after: long, 
	q: String, 
	body: Body
) extends RequestBase

object CountRequest {
	@JsonCodec case class Body(
		query: QueryDslQueryContainer
	)
}


@JsonCodec case class CountResponse(
	count: long, 
	_shards: ShardStatistics
)

@JsonCodec case class CreateRequest[TDocument = None](
	id: Id, 
	index: IndexName, 
	`type`: Type, 
	pipeline: String, 
	refresh: Refresh, 
	routing: Routing, 
	timeout: Time, 
	version: VersionNumber, 
	version_type: VersionType, 
	wait_for_active_shards: WaitForActiveShards, 
	body: TDocument
) extends RequestBase

@JsonCodec case class CreateResponse extends WriteResponseBase

@JsonCodec case class DeleteRequest(
	id: Id, 
	index: IndexName, 
	`type`: Type, 
	if_primary_term: long, 
	if_seq_no: SequenceNumber, 
	refresh: Refresh, 
	routing: Routing, 
	timeout: Time, 
	version: VersionNumber, 
	version_type: VersionType, 
	wait_for_active_shards: WaitForActiveShards
) extends RequestBase

@JsonCodec case class DeleteResponse extends WriteResponseBase

@JsonCodec case class DeleteByQueryRequest(
	index: Indices, 
	`type`: Types, 
	allow_no_indices: Boolean, 
	analyzer: String, 
	analyze_wildcard: Boolean, 
	conflicts: Conflicts, 
	default_operator: DefaultOperator, 
	df: String, 
	expand_wildcards: ExpandWildcards, 
	from: long, 
	ignore_unavailable: Boolean, 
	lenient: Boolean, 
	max_docs: long, 
	preference: String, 
	refresh: Boolean, 
	request_cache: Boolean, 
	requests_per_second: long, 
	routing: Routing, 
	q: String, 
	scroll: Time, 
	scroll_size: long, 
	search_timeout: Time, 
	search_type: SearchType, 
	size: long, 
	slices: long, 
	sort: Seq[String], 
	_source: Boolean | Fields, 
	_source_excludes: Fields, 
	_source_includes: Fields, 
	stats: Seq[String], 
	terminate_after: long, 
	timeout: Time, 
	version: Boolean, 
	wait_for_active_shards: WaitForActiveShards, 
	wait_for_completion: Boolean, 
	body: Body
) extends RequestBase

object DeleteByQueryRequest {
	@JsonCodec case class Body(
		max_docs: long, 
		query: QueryDslQueryContainer, 
		slice: SlicedScroll
	)
}


@JsonCodec case class DeleteByQueryResponse(
	batches: long, 
	deleted: long, 
	failures: Seq[BulkIndexByScrollFailure], 
	noops: long, 
	requests_per_second: float, 
	retries: Retries, 
	slice_id: integer, 
	task: TaskId, 
	throttled_millis: long, 
	throttled_until_millis: long, 
	timed_out: Boolean, 
	took: long, 
	total: long, 
	version_conflicts: long
)

@JsonCodec case class DeleteByQueryRethrottleRequest(
	task_id: Id, 
	requests_per_second: long
) extends RequestBase

@JsonCodec case class DeleteByQueryRethrottleResponse extends TaskListResponse

@JsonCodec case class DeleteScriptRequest(
	id: Id, 
	master_timeout: Time, 
	timeout: Time
) extends RequestBase

@JsonCodec case class DeleteScriptResponse extends AcknowledgedResponseBase

@JsonCodec case class ExistsRequest(
	id: Id, 
	index: IndexName, 
	`type`: Type, 
	preference: String, 
	realtime: Boolean, 
	refresh: Boolean, 
	routing: Routing, 
	source_enabled: Boolean, 
	source_excludes: Fields, 
	source_includes: Fields, 
	stored_fields: Fields, 
	version: VersionNumber, 
	version_type: VersionType
) extends RequestBase
type ExistsResponse = Boolean

@JsonCodec case class ExistsSourceRequest(
	id: Id, 
	index: IndexName, 
	`type`: Type, 
	preference: String, 
	realtime: Boolean, 
	refresh: Boolean, 
	routing: Routing, 
	source_enabled: Boolean, 
	source_excludes: Fields, 
	source_includes: Fields, 
	version: VersionNumber, 
	version_type: VersionType
) extends RequestBase
type ExistsSourceResponse = Boolean

@JsonCodec case class ExplainExplanation(
	description: String, 
	details: Seq[ExplainExplanationDetail], 
	value: float
)

@JsonCodec case class ExplainExplanationDetail(
	description: String, 
	details: Seq[ExplainExplanationDetail], 
	value: float
)

@JsonCodec case class ExplainRequest(
	id: Id, 
	index: IndexName, 
	`type`: Type, 
	analyzer: String, 
	analyze_wildcard: Boolean, 
	default_operator: DefaultOperator, 
	df: String, 
	lenient: Boolean, 
	preference: String, 
	query_on_query_string: String, 
	routing: Routing, 
	_source: Boolean | Fields, 
	_source_excludes: Fields, 
	_source_includes: Fields, 
	stored_fields: Fields, 
	q: String, 
	body: Body
) extends RequestBase

object ExplainRequest {
	@JsonCodec case class Body(
		query: QueryDslQueryContainer
	)
}


@JsonCodec case class ExplainResponse[TDocument = None](
	_index: IndexName, 
	_type: Type, 
	_id: Id, 
	matched: Boolean, 
	explanation: ExplainExplanationDetail, 
	get: InlineGet[TDocument]
)

@JsonCodec case class FieldCapsFieldCapabilitiesBodyIndexFilter(
	range: FieldCapsFieldCapabilitiesBodyIndexFilterRange, 
	match_none: EmptyObject, 
	term: FieldCapsFieldCapabilitiesBodyIndexFilterTerm
)

@JsonCodec case class FieldCapsFieldCapabilitiesBodyIndexFilterRange(
	timestamp: FieldCapsFieldCapabilitiesBodyIndexFilterRangeTimestamp
)

@JsonCodec case class FieldCapsFieldCapabilitiesBodyIndexFilterRangeTimestamp(
	gte: integer, 
	gt: integer, 
	lte: integer, 
	lt: integer
)

@JsonCodec case class FieldCapsFieldCapabilitiesBodyIndexFilterTerm(
	versionControl: FieldCapsFieldCapabilitiesBodyIndexFilterTermVersionControl
)

@JsonCodec case class FieldCapsFieldCapabilitiesBodyIndexFilterTermVersionControl(
	value: String
)

@JsonCodec case class FieldCapsFieldCapability(
	aggregatable: Boolean, 
	indices: Indices, 
	meta: Record[String, Seq[String]], 
	non_aggregatable_indices: Indices, 
	non_searchable_indices: Indices, 
	searchable: Boolean, 
	`type`: String
)

@JsonCodec case class FieldCapsRequest(
	index: Indices, 
	allow_no_indices: Boolean, 
	expand_wildcards: ExpandWildcards, 
	fields: Fields, 
	ignore_unavailable: Boolean, 
	include_unmapped: Boolean, 
	body: Body
) extends RequestBase

object FieldCapsRequest {
	@JsonCodec case class Body(
		index_filter: FieldCapsFieldCapabilitiesBodyIndexFilter
	)
}


@JsonCodec case class FieldCapsResponse(
	indices: Indices, 
	fields: Record[Field, Record[String, FieldCapsFieldCapability]]
)

@JsonCodec case class GetRequest(
	id: Id, 
	index: IndexName, 
	`type`: Type, 
	preference: String, 
	realtime: Boolean, 
	refresh: Boolean, 
	routing: Routing, 
	source_enabled: Boolean, 
	_source_excludes: Fields, 
	_source_includes: Fields, 
	stored_fields: Fields, 
	version: VersionNumber, 
	version_type: VersionType, 
	_source: Boolean | Fields
) extends RequestBase

@JsonCodec case class GetResponse[TDocument = None](
	_index: IndexName, 
	fields: Record[String, Any], 
	found: Boolean, 
	_id: Id, 
	_primary_term: long, 
	_routing: String, 
	_seq_no: SequenceNumber, 
	_source: TDocument, 
	_type: Type, 
	_version: VersionNumber
)

@JsonCodec case class GetScriptRequest(
	id: Id, 
	master_timeout: Time
) extends RequestBase

@JsonCodec case class GetScriptResponse(
	_id: Id, 
	found: Boolean, 
	script: StoredScript
)

@JsonCodec case class GetScriptContextContext(
	methods: Seq[GetScriptContextContextMethod], 
	name: Name
)

@JsonCodec case class GetScriptContextContextMethod(
	name: Name, 
	return_type: String, 
	params: Seq[GetScriptContextContextMethodParam]
)

@JsonCodec case class GetScriptContextContextMethodParam(
	name: Name, 
	`type`: String
)

@JsonCodec case class GetScriptContextRequest extends RequestBase

@JsonCodec case class GetScriptContextResponse(
	contexts: Seq[GetScriptContextContext]
)

@JsonCodec case class GetScriptLanguagesLanguageContext(
	contexts: Seq[String], 
	language: ScriptLanguage
)

@JsonCodec case class GetScriptLanguagesRequest extends RequestBase

@JsonCodec case class GetScriptLanguagesResponse(
	language_contexts: Seq[GetScriptLanguagesLanguageContext], 
	types_allowed: Seq[String]
)

@JsonCodec case class GetSourceRequest extends GetRequest
type GetSourceResponse[TDocument = None]  = TDocument

@JsonCodec case class IndexRequest[TDocument = None](
	id: Id, 
	index: IndexName, 
	`type`: Type, 
	if_primary_term: long, 
	if_seq_no: SequenceNumber, 
	op_type: OpType, 
	pipeline: String, 
	refresh: Refresh, 
	routing: Routing, 
	timeout: Time, 
	version: VersionNumber, 
	version_type: VersionType, 
	wait_for_active_shards: WaitForActiveShards, 
	require_alias: Boolean, 
	body: TDocument
) extends RequestBase

@JsonCodec case class IndexResponse extends WriteResponseBase

@JsonCodec case class InfoRequest extends RequestBase

@JsonCodec case class InfoResponse(
	cluster_name: Name, 
	cluster_uuid: Uuid, 
	name: Name, 
	tagline: String, 
	version: ElasticsearchVersionInfo
)

@JsonCodec case class MgetHit[TDocument = None](
	error: MainError, 
	fields: Record[String, Any], 
	found: Boolean, 
	_id: Id, 
	_index: IndexName, 
	_primary_term: long, 
	_routing: Routing, 
	_seq_no: SequenceNumber, 
	_source: TDocument, 
	_type: Type, 
	_version: VersionNumber
)
type MgetMultiGetId = String | integer

@JsonCodec case class MgetOperation(
	_id: MgetMultiGetId, 
	_index: IndexName, 
	routing: Routing, 
	_source: Boolean | Fields | SearchSourceFilter, 
	stored_fields: Fields, 
	_type: Type, 
	version: VersionNumber, 
	version_type: VersionType
)

@JsonCodec case class MgetRequest(
	index: IndexName, 
	`type`: Type, 
	preference: String, 
	realtime: Boolean, 
	refresh: Boolean, 
	routing: Routing, 
	_source: Boolean | Fields, 
	_source_excludes: Fields, 
	_source_includes: Fields, 
	stored_fields: Fields, 
	body: Body
) extends RequestBase

object MgetRequest {
	@JsonCodec case class Body(
		docs: Seq[MgetOperation], 
		ids: Seq[MgetMultiGetId]
	)
}


@JsonCodec case class MgetResponse[TDocument = None](
	docs: Seq[MgetHit[TDocument]]
)

@JsonCodec case class MsearchBody(
	aggregations: Record[String, AggregationsAggregationContainer], 
	aggs: Record[String, AggregationsAggregationContainer], 
	query: QueryDslQueryContainer, 
	from: integer, 
	size: integer, 
	pit: SearchPointInTimeReference, 
	track_total_hits: Boolean | integer, 
	suggest: SearchSuggestContainer | Record[String, SearchSuggestContainer]
)

@JsonCodec case class MsearchHeader(
	allow_no_indices: Boolean, 
	expand_wildcards: ExpandWildcards, 
	ignore_unavailable: Boolean, 
	index: Indices, 
	preference: String, 
	request_cache: Boolean, 
	routing: String, 
	search_type: SearchType
)

@JsonCodec case class MsearchRequest(
	index: Indices, 
	`type`: Types, 
	allow_no_indices: Boolean, 
	ccs_minimize_roundtrips: Boolean, 
	expand_wildcards: ExpandWildcards, 
	ignore_throttled: Boolean, 
	ignore_unavailable: Boolean, 
	max_concurrent_searches: long, 
	max_concurrent_shard_requests: long, 
	pre_filter_shard_size: long, 
	search_type: SearchType, 
	rest_total_hits_as_int: Boolean, 
	typed_keys: Boolean, 
	body: Seq[MsearchHeader | MsearchBody]
) extends RequestBase

@JsonCodec case class MsearchResponse[TDocument = None](
	took: long, 
	responses: Seq[MsearchSearchResult[TDocument] | ErrorResponseBase]
)

@JsonCodec case class MsearchSearchResult[TDocument = None](
	status: integer
) extends SearchResponse[TDocument]

@JsonCodec case class MsearchTemplateRequest(
	index: Indices, 
	`type`: Types, 
	ccs_minimize_roundtrips: Boolean, 
	max_concurrent_searches: long, 
	search_type: SearchType, 
	rest_total_hits_as_int: Boolean, 
	typed_keys: Boolean, 
	body: Seq[MsearchTemplateTemplateItem]
) extends RequestBase

@JsonCodec case class MsearchTemplateResponse[TDocument = None](
	responses: Seq[SearchResponse[TDocument]], 
	took: long
)

@JsonCodec case class MsearchTemplateTemplateItem(
	id: Id, 
	index: Indices, 
	params: Record[String, Any], 
	source: String
)

@JsonCodec case class MtermvectorsOperation(
	doc: object, 
	fields: Fields, 
	field_statistics: Boolean, 
	filter: TermvectorsFilter, 
	_id: Id, 
	_index: IndexName, 
	offsets: Boolean, 
	payloads: Boolean, 
	positions: Boolean, 
	routing: Routing, 
	term_statistics: Boolean, 
	version: VersionNumber, 
	version_type: VersionType
)

@JsonCodec case class MtermvectorsRequest(
	index: IndexName, 
	`type`: Type, 
	fields: Fields, 
	field_statistics: Boolean, 
	offsets: Boolean, 
	payloads: Boolean, 
	positions: Boolean, 
	preference: String, 
	realtime: Boolean, 
	routing: Routing, 
	term_statistics: Boolean, 
	version: VersionNumber, 
	version_type: VersionType, 
	body: Body
) extends RequestBase

object MtermvectorsRequest {
	@JsonCodec case class Body(
		docs: Seq[MtermvectorsOperation], 
		ids: Seq[Id]
	)
}


@JsonCodec case class MtermvectorsResponse(
	docs: Seq[MtermvectorsTermVectorsResult]
)

@JsonCodec case class MtermvectorsTermVectorsResult(
	found: Boolean, 
	id: Id, 
	index: IndexName, 
	term_vectors: Record[Field, TermvectorsTermVector], 
	took: long, 
	version: VersionNumber
)

@JsonCodec case class OpenPointInTimeRequest(
	index: Indices, 
	keep_alive: Time
) extends RequestBase

@JsonCodec case class OpenPointInTimeResponse(
	id: Id
)

@JsonCodec case class PingRequest extends RequestBase
type PingResponse = Boolean

@JsonCodec case class PutScriptRequest(
	id: Id, 
	context: Name, 
	master_timeout: Time, 
	timeout: Time, 
	body: Body
) extends RequestBase

object PutScriptRequest {
	@JsonCodec case class Body(
		script: StoredScript
	)
}


@JsonCodec case class PutScriptResponse extends AcknowledgedResponseBase

@JsonCodec case class RankEvalDocumentRating(
	_id: Id, 
	_index: IndexName, 
	rating: integer
)

@JsonCodec case class RankEvalRankEvalHit(
	_id: Id, 
	_index: IndexName, 
	_type: Type, 
	_score: double
)

@JsonCodec case class RankEvalRankEvalHitItem(
	hit: RankEvalRankEvalHit, 
	rating: double
)

@JsonCodec case class RankEvalRankEvalMetric(
	precision: RankEvalRankEvalMetricPrecision, 
	recall: RankEvalRankEvalMetricRecall, 
	mean_reciprocal_rank: RankEvalRankEvalMetricMeanReciprocalRank, 
	dcg: RankEvalRankEvalMetricDiscountedCumulativeGain, 
	expected_reciprocal_rank: RankEvalRankEvalMetricExpectedReciprocalRank
)

@JsonCodec case class RankEvalRankEvalMetricBase(
	k: integer
)

@JsonCodec case class RankEvalRankEvalMetricDetail(
	metric_score: double, 
	unrated_docs: Seq[RankEvalUnratedDocument], 
	hits: Seq[RankEvalRankEvalHitItem], 
	metric_details: Record[String, Record[String, Any]]
)

@JsonCodec case class RankEvalRankEvalMetricDiscountedCumulativeGain(
	normalize: Boolean
) extends RankEvalRankEvalMetricBase

@JsonCodec case class RankEvalRankEvalMetricExpectedReciprocalRank(
	maximum_relevance: integer
) extends RankEvalRankEvalMetricBase

@JsonCodec case class RankEvalRankEvalMetricMeanReciprocalRank extends RankEvalRankEvalMetricRatingTreshold

@JsonCodec case class RankEvalRankEvalMetricPrecision(
	ignore_unlabeled: Boolean
) extends RankEvalRankEvalMetricRatingTreshold

@JsonCodec case class RankEvalRankEvalMetricRatingTreshold(
	relevant_rating_threshold: integer
) extends RankEvalRankEvalMetricBase

@JsonCodec case class RankEvalRankEvalMetricRecall extends RankEvalRankEvalMetricRatingTreshold

@JsonCodec case class RankEvalRankEvalQuery(
	query: QueryDslQueryContainer, 
	size: integer
)

@JsonCodec case class RankEvalRankEvalRequestItem(
	id: Id, 
	request: RankEvalRankEvalQuery, 
	ratings: Seq[RankEvalDocumentRating], 
	template_id: Id, 
	params: Record[String, Any]
)

@JsonCodec case class RankEvalRequest(
	index: Indices, 
	allow_no_indices: Boolean, 
	expand_wildcards: ExpandWildcards, 
	ignore_unavailable: Boolean, 
	search_type: String, 
	body: Body
) extends RequestBase

object RankEvalRequest {
	@JsonCodec case class Body(
		requests: Seq[RankEvalRankEvalRequestItem], 
		metric: RankEvalRankEvalMetric
	)
}


@JsonCodec case class RankEvalResponse(
	metric_score: double, 
	details: Record[Id, RankEvalRankEvalMetricDetail], 
	failures: Record[String, Any]
)

@JsonCodec case class RankEvalUnratedDocument(
	_id: Id, 
	_index: IndexName
)

@JsonCodec case class ReindexDestination(
	index: IndexName, 
	op_type: OpType, 
	pipeline: String, 
	routing: Routing, 
	version_type: VersionType
)

@JsonCodec case class ReindexRemoteSource(
	connect_timeout: Time, 
	host: Host, 
	username: Username, 
	password: Password, 
	socket_timeout: Time
)

@JsonCodec case class ReindexRequest(
	refresh: Boolean, 
	requests_per_second: long, 
	scroll: Time, 
	slices: long, 
	timeout: Time, 
	wait_for_active_shards: WaitForActiveShards, 
	wait_for_completion: Boolean, 
	require_alias: Boolean, 
	body: Body
) extends RequestBase

object ReindexRequest {
	@JsonCodec case class Body(
		conflicts: Conflicts, 
		dest: ReindexDestination, 
		max_docs: long, 
		script: Script, 
		size: long, 
		source: ReindexSource
	)
}


@JsonCodec case class ReindexResponse(
	batches: long, 
	created: long, 
	deleted: long, 
	failures: Seq[BulkIndexByScrollFailure], 
	noops: long, 
	retries: Retries, 
	requests_per_second: long, 
	slice_id: integer, 
	task: TaskId, 
	throttled_millis: EpochMillis, 
	throttled_until_millis: EpochMillis, 
	timed_out: Boolean, 
	took: Time, 
	total: long, 
	updated: long, 
	version_conflicts: long
)

@JsonCodec case class ReindexSource(
	index: Indices, 
	query: QueryDslQueryContainer, 
	remote: ReindexRemoteSource, 
	size: integer, 
	slice: SlicedScroll, 
	sort: SearchSort, 
	_source: Fields
)

@JsonCodec case class ReindexRethrottleReindexNode(
	tasks: Record[TaskId, ReindexRethrottleReindexTask]
) extends SpecUtilsBaseNode

@JsonCodec case class ReindexRethrottleReindexStatus(
	batches: long, 
	created: long, 
	deleted: long, 
	noops: long, 
	requests_per_second: float, 
	retries: Retries, 
	throttled_millis: long, 
	throttled_until_millis: long, 
	total: long, 
	updated: long, 
	version_conflicts: long
)

@JsonCodec case class ReindexRethrottleReindexTask(
	action: String, 
	cancellable: Boolean, 
	description: String, 
	id: long, 
	node: Name, 
	running_time_in_nanos: long, 
	start_time_in_millis: long, 
	status: ReindexRethrottleReindexStatus, 
	`type`: String, 
	headers: HttpHeaders
)

@JsonCodec case class ReindexRethrottleRequest(
	task_id: Id, 
	requests_per_second: long
) extends RequestBase

@JsonCodec case class ReindexRethrottleResponse(
	nodes: Record[String, ReindexRethrottleReindexNode]
)

@JsonCodec case class RenderSearchTemplateRequest(
	body: Body
) extends RequestBase

object RenderSearchTemplateRequest {
	@JsonCodec case class Body(
		file: String, 
		params: Record[String, Any], 
		source: String
	)
}


@JsonCodec case class RenderSearchTemplateResponse(
	template_output: Record[String, Any]
)

@JsonCodec case class ScriptsPainlessExecutePainlessContextSetup(
	document: Any, 
	index: IndexName, 
	query: QueryDslQueryContainer
)

@JsonCodec case class ScriptsPainlessExecutePainlessExecutionPosition(
	offset: integer, 
	start: integer, 
	end: integer
)

@JsonCodec case class ScriptsPainlessExecuteRequest(
	body: Body
) extends RequestBase

object ScriptsPainlessExecuteRequest {
	@JsonCodec case class Body(
		context: String, 
		context_setup: ScriptsPainlessExecutePainlessContextSetup, 
		script: InlineScript
	)
}


@JsonCodec case class ScriptsPainlessExecuteResponse[TResult = None](
	result: TResult
)

@JsonCodec case class ScrollRequest(
	scroll_id: Id, 
	scroll: Time, 
	rest_total_hits_as_int: Boolean, 
	total_hits_as_integer: Boolean, 
	body: Body
) extends RequestBase

object ScrollRequest {
	@JsonCodec case class Body(
		scroll: Time, 
		scroll_id: ScrollId, 
		rest_total_hits_as_int: Boolean
	)
}


@JsonCodec case class ScrollResponse[TDocument = None] extends SearchResponse[TDocument]

@JsonCodec case class SearchRequest(
	index: Indices, 
	`type`: Types, 
	allow_no_indices: Boolean, 
	allow_partial_search_results: Boolean, 
	analyzer: String, 
	analyze_wildcard: Boolean, 
	batched_reduce_size: long, 
	ccs_minimize_roundtrips: Boolean, 
	default_operator: DefaultOperator, 
	df: String, 
	docvalue_fields: Fields, 
	expand_wildcards: ExpandWildcards, 
	explain: Boolean, 
	ignore_throttled: Boolean, 
	ignore_unavailable: Boolean, 
	lenient: Boolean, 
	max_concurrent_shard_requests: long, 
	min_compatible_shard_node: VersionString, 
	preference: String, 
	pre_filter_shard_size: long, 
	request_cache: Boolean, 
	routing: Routing, 
	scroll: Time, 
	search_type: SearchType, 
	stats: Seq[String], 
	stored_fields: Fields, 
	suggest_field: Field, 
	suggest_mode: SuggestMode, 
	suggest_size: long, 
	suggest_text: String, 
	terminate_after: long, 
	timeout: Time, 
	track_total_hits: Boolean | integer, 
	track_scores: Boolean, 
	typed_keys: Boolean, 
	rest_total_hits_as_int: Boolean, 
	version: Boolean, 
	_source: Boolean | Fields, 
	_source_excludes: Fields, 
	_source_includes: Fields, 
	seq_no_primary_term: Boolean, 
	q: String, 
	size: integer, 
	from: integer, 
	sort: String | Seq[String], 
	body: Body
) extends RequestBase

object SearchRequest {
	@JsonCodec case class Body(
		aggs: Record[String, AggregationsAggregationContainer], 
		aggregations: Record[String, AggregationsAggregationContainer], 
		collapse: SearchFieldCollapse, 
		explain: Boolean, 
		from: integer, 
		highlight: SearchHighlight, 
		track_total_hits: Boolean | integer, 
		indices_boost: Seq[Record[IndexName, double]], 
		docvalue_fields: SearchDocValueField | Seq[Field | SearchDocValueField], 
		min_score: double, 
		post_filter: QueryDslQueryContainer, 
		profile: Boolean, 
		query: QueryDslQueryContainer, 
		rescore: SearchRescore | Seq[SearchRescore], 
		script_fields: Record[String, ScriptField], 
		search_after: Seq[integer | String], 
		size: integer, 
		slice: SlicedScroll, 
		sort: SearchSort, 
		_source: Boolean | Fields | SearchSourceFilter, 
		fields: Seq[Field | DateField], 
		suggest: SearchSuggestContainer | Record[String, SearchSuggestContainer], 
		terminate_after: long, 
		timeout: String, 
		track_scores: Boolean, 
		version: Boolean, 
		seq_no_primary_term: Boolean, 
		stored_fields: Fields, 
		pit: SearchPointInTimeReference, 
		runtime_mappings: MappingRuntimeFields, 
		stats: Seq[String]
	)
}


@JsonCodec case class SearchResponse[TDocument = None](
	took: long, 
	timed_out: Boolean, 
	_shards: ShardStatistics, 
	hits: SearchHitsMetadata[TDocument], 
	aggregations: Record[AggregateName, AggregationsAggregate], 
	_clusters: ClusterStatistics, 
	documents: Seq[TDocument], 
	fields: Record[String, Any], 
	max_score: double, 
	num_reduce_phases: long, 
	profile: SearchProfile, 
	pit_id: Id, 
	_scroll_id: ScrollId, 
	suggest: Record[SuggestionName, Seq[SearchSuggest[TDocument]]], 
	terminated_early: Boolean
)

@JsonCodec case class SearchAggregationBreakdown(
	build_aggregation: long, 
	build_aggregation_count: long, 
	build_leaf_collector: long, 
	build_leaf_collector_count: long, 
	collect: long, 
	collect_count: long, 
	initialize: long, 
	initialize_count: long, 
	post_collection: long, 
	post_collection_count: long, 
	reduce: long, 
	reduce_count: long
)

@JsonCodec case class SearchAggregationProfile(
	breakdown: SearchAggregationBreakdown, 
	description: String, 
	time_in_nanos: long, 
	`type`: String, 
	debug: SearchAggregationProfileDebug, 
	children: Seq[SearchAggregationProfileDebug]
)

@JsonCodec sealed trait SearchAggregationProfileDebug
type SearchBoundaryScanner = "chars"" | "sentence"" | "word""

@JsonCodec case class SearchCollector(
	name: String, 
	reason: String, 
	time_in_nanos: long, 
	children: Seq[SearchCollector]
)

@JsonCodec case class SearchCompletionSuggestOption[TDocument = None](
	collate_match: Boolean, 
	contexts: Record[String, Seq[SearchContext]], 
	fields: Record[String, Any], 
	_id: String, 
	_index: IndexName, 
	_type: Type, 
	_routing: Routing, 
	_score: double, 
	_source: TDocument, 
	text: String
)

@JsonCodec case class SearchCompletionSuggester(
	contexts: Record[String, String | Seq[String] | QueryDslGeoLocation | Seq[SearchSuggestContextQuery]], 
	fuzzy: SearchSuggestFuzziness, 
	prefix: String, 
	regex: String, 
	skip_duplicates: Boolean
) extends SearchSuggesterBase
type SearchContext = String | QueryDslGeoLocation

@JsonCodec case class SearchDirectGenerator(
	field: Field, 
	max_edits: integer, 
	max_inspections: float, 
	max_term_freq: float, 
	min_doc_freq: float, 
	min_word_length: integer, 
	post_filter: String, 
	pre_filter: String, 
	prefix_length: integer, 
	size: integer, 
	suggest_mode: SuggestMode
)

@JsonCodec case class SearchDocValueField(
	field: Field, 
	format: String
)

@JsonCodec case class SearchFieldCollapse(
	field: Field, 
	inner_hits: SearchInnerHits | Seq[SearchInnerHits], 
	max_concurrent_group_searches: integer
)

@JsonCodec case class SearchFieldSort(
	missing: AggregationsMissing, 
	mode: SearchSortMode, 
	nested: SearchNestedSortValue, 
	order: SearchSortOrder, 
	unmapped_type: MappingFieldType
)

@JsonCodec case class SearchGeoDistanceSortKeys(
	mode: SearchSortMode, 
	distance_type: GeoDistanceType, 
	order: SearchSortOrder, 
	unit: DistanceUnit
)
type SearchGeoDistanceSort = SearchGeoDistanceSortKeys | @JsonCodec case class Undefined(
[[MemberIndex: TsMemberIndex(NoComments,false,Default,Dict(TsIdentSimple(property),TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(string))),IArray())),Some(TsTypeUnion(IArray(TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(QueryDslGeoLocation))),IArray()), TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(Array))),IArray(TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(QueryDslGeoLocation))),IArray())))))))]]
)


@JsonCodec case class SearchHighlight(
	fields: Record[Field, SearchHighlightField], 
	`type`: SearchHighlighterType, 
	boundary_chars: String, 
	boundary_max_scan: integer, 
	boundary_scanner: SearchBoundaryScanner, 
	boundary_scanner_locale: String, 
	encoder: SearchHighlighterEncoder, 
	fragmenter: SearchHighlighterFragmenter, 
	fragment_offset: integer, 
	fragment_size: integer, 
	max_fragment_length: integer, 
	no_match_size: integer, 
	number_of_fragments: integer, 
	order: SearchHighlighterOrder, 
	post_tags: Seq[String], 
	pre_tags: Seq[String], 
	require_field_match: Boolean, 
	tags_schema: SearchHighlighterTagsSchema, 
	highlight_query: QueryDslQueryContainer, 
	max_analyzed_offset: String | integer
)

@JsonCodec case class SearchHighlightField(
	boundary_chars: String, 
	boundary_max_scan: integer, 
	boundary_scanner: SearchBoundaryScanner, 
	boundary_scanner_locale: String, 
	field: Field, 
	force_source: Boolean, 
	fragmenter: SearchHighlighterFragmenter, 
	fragment_offset: integer, 
	fragment_size: integer, 
	highlight_query: QueryDslQueryContainer, 
	matched_fields: Fields, 
	max_fragment_length: integer, 
	no_match_size: integer, 
	number_of_fragments: integer, 
	order: SearchHighlighterOrder, 
	phrase_limit: integer, 
	post_tags: Seq[String], 
	pre_tags: Seq[String], 
	require_field_match: Boolean, 
	tags_schema: SearchHighlighterTagsSchema, 
	`type`: SearchHighlighterType | String
)
type SearchHighlighterEncoder = "default"" | "html""
type SearchHighlighterFragmenter = "simple"" | "span""
type SearchHighlighterOrder = "score""
type SearchHighlighterTagsSchema = "styled""
type SearchHighlighterType = "plain"" | "fvh"" | "unified""

@JsonCodec case class SearchHit[TDocument = None](
	_index: IndexName, 
	_id: Id, 
	_score: double, 
	_type: Type, 
	_explanation: ExplainExplanation, 
	fields: Record[String, Any], 
	highlight: Record[String, Seq[String]], 
	inner_hits: Record[String, SearchInnerHitsResult], 
	matched_queries: Seq[String], 
	_nested: SearchNestedIdentity, 
	_ignored: Seq[String], 
	_shard: String, 
	_node: String, 
	_routing: String, 
	_source: TDocument, 
	_seq_no: SequenceNumber, 
	_primary_term: long, 
	_version: VersionNumber, 
	sort: SearchSortResults
)

@JsonCodec case class SearchHitsMetadata[T = None](
	total: SearchTotalHits | long, 
	hits: Seq[SearchHit[T]], 
	max_score: double
)

@JsonCodec case class SearchInnerHits(
	name: Name, 
	size: integer, 
	from: integer, 
	collapse: SearchFieldCollapse, 
	docvalue_fields: Fields, 
	explain: Boolean, 
	highlight: SearchHighlight, 
	ignore_unmapped: Boolean, 
	script_fields: Record[String, ScriptField], 
	seq_no_primary_term: Boolean, 
	fields: Fields, 
	sort: SearchSort, 
	_source: Boolean | SearchSourceFilter, 
	version: Boolean
)

@JsonCodec case class SearchInnerHitsMetadata(
	total: SearchTotalHits | long, 
	hits: Seq[SearchHit[Record[String, Any]]], 
	max_score: double
)

@JsonCodec case class SearchInnerHitsResult(
	hits: SearchInnerHitsMetadata
)

@JsonCodec case class SearchLaplaceSmoothingModel(
	alpha: double
)

@JsonCodec case class SearchLinearInterpolationSmoothingModel(
	bigram_lambda: double, 
	trigram_lambda: double, 
	unigram_lambda: double
)

@JsonCodec case class SearchNestedIdentity(
	field: Field, 
	offset: integer, 
	_nested: SearchNestedIdentity
)

@JsonCodec case class SearchNestedSortValue(
	filter: QueryDslQueryContainer, 
	max_children: integer, 
	path: Field
)

@JsonCodec case class SearchPhraseSuggestCollate(
	params: Record[String, Any], 
	prune: Boolean, 
	query: SearchPhraseSuggestCollateQuery
)

@JsonCodec case class SearchPhraseSuggestCollateQuery(
	id: Id, 
	source: String
)

@JsonCodec case class SearchPhraseSuggestHighlight(
	post_tag: String, 
	pre_tag: String
)

@JsonCodec case class SearchPhraseSuggestOption(
	text: String, 
	highlighted: String, 
	score: double
)

@JsonCodec case class SearchPhraseSuggester(
	collate: SearchPhraseSuggestCollate, 
	confidence: double, 
	direct_generator: Seq[SearchDirectGenerator], 
	force_unigrams: Boolean, 
	gram_size: integer, 
	highlight: SearchPhraseSuggestHighlight, 
	max_errors: double, 
	real_word_error_likelihood: double, 
	separator: String, 
	shard_size: integer, 
	smoothing: SearchSmoothingModelContainer, 
	text: String, 
	token_limit: integer
) extends SearchSuggesterBase

@JsonCodec case class SearchPointInTimeReference(
	id: Id, 
	keep_alive: Time
)

@JsonCodec case class SearchProfile(
	shards: Seq[SearchShardProfile]
)

@JsonCodec case class SearchQueryBreakdown(
	advance: long, 
	advance_count: long, 
	build_scorer: long, 
	build_scorer_count: long, 
	create_weight: long, 
	create_weight_count: long, 
	`match`: long, 
	match_count: long, 
	shallow_advance: long, 
	shallow_advance_count: long, 
	next_doc: long, 
	next_doc_count: long, 
	score: long, 
	score_count: long, 
	compute_max_score: long, 
	compute_max_score_count: long, 
	set_min_competitive_score: long, 
	set_min_competitive_score_count: long
)

@JsonCodec case class SearchQueryProfile(
	breakdown: SearchQueryBreakdown, 
	description: String, 
	time_in_nanos: long, 
	`type`: String, 
	children: Seq[SearchQueryProfile]
)

@JsonCodec case class SearchRescore(
	query: SearchRescoreQuery, 
	window_size: integer
)

@JsonCodec case class SearchRescoreQuery(
	rescore_query: QueryDslQueryContainer, 
	query_weight: double, 
	rescore_query_weight: double, 
	score_mode: SearchScoreMode
)
type SearchScoreMode = "avg"" | "max"" | "min"" | "multiply"" | "total""

@JsonCodec case class SearchScoreSort(
	mode: SearchSortMode, 
	order: SearchSortOrder
)

@JsonCodec case class SearchScriptSort(
	order: SearchSortOrder, 
	script: Script, 
	`type`: String
)

@JsonCodec case class SearchSearchProfile(
	collector: Seq[SearchCollector], 
	query: Seq[SearchQueryProfile], 
	rewrite_time: long
)

@JsonCodec case class SearchShardProfile(
	aggregations: Seq[SearchAggregationProfile], 
	id: String, 
	searches: Seq[SearchSearchProfile]
)

@JsonCodec case class SearchSmoothingModelContainer(
	laplace: SearchLaplaceSmoothingModel, 
	linear_interpolation: SearchLinearInterpolationSmoothingModel, 
	stupid_backoff: SearchStupidBackoffSmoothingModel
)
type SearchSort = SearchSortCombinations | Seq[SearchSortCombinations]
type SearchSortCombinations = Field | SearchSortContainer | SearchSortOrder

@JsonCodec case class SearchSortContainerKeys(
	_score: SearchScoreSort, 
	_doc: SearchScoreSort, 
	_geo_distance: SearchGeoDistanceSort, 
	_script: SearchScriptSort
)
type SearchSortContainer = SearchSortContainerKeys | @JsonCodec case class Undefined(
[[MemberIndex: TsMemberIndex(NoComments,false,Default,Dict(TsIdentSimple(property),TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(string))),IArray())),Some(TsTypeUnion(IArray(TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(SearchFieldSort))),IArray()), TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(SearchSortOrder))),IArray())))))]]
)

type SearchSortMode = "min"" | "max"" | "sum"" | "avg"" | "median""
type SearchSortOrder = "asc"" | "desc"" | "_doc""
type SearchSortResults = Seq[long | double | String | null]

@JsonCodec case class SearchSourceFilter(
	excludes: Fields, 
	includes: Fields, 
	exclude: Fields, 
	include: Fields
)
type SearchStringDistance = "internal"" | "damerau_levenshtein"" | "levenshtein"" | "jaro_winkler"" | "ngram""

@JsonCodec case class SearchStupidBackoffSmoothingModel(
	discount: double
)

@JsonCodec case class SearchSuggest[T = None](
	length: integer, 
	offset: integer, 
	options: Seq[SearchSuggestOption[T]], 
	text: String
)

@JsonCodec case class SearchSuggestContainer(
	completion: SearchCompletionSuggester, 
	phrase: SearchPhraseSuggester, 
	prefix: String, 
	regex: String, 
	term: SearchTermSuggester, 
	text: String
)

@JsonCodec case class SearchSuggestContextQuery(
	boost: double, 
	context: SearchContext, 
	neighbours: Seq[Distance] | Seq[integer], 
	precision: Distance | integer, 
	prefix: Boolean
)

@JsonCodec case class SearchSuggestFuzziness(
	fuzziness: Fuzziness, 
	min_length: integer, 
	prefix_length: integer, 
	transpositions: Boolean, 
	unicode_aware: Boolean
)
type SearchSuggestOption[TDocument = None]  = SearchCompletionSuggestOption[TDocument] | SearchPhraseSuggestOption | SearchTermSuggestOption
type SearchSuggestSort = "score"" | "frequency""

@JsonCodec case class SearchSuggesterBase(
	field: Field, 
	analyzer: String, 
	size: integer
)

@JsonCodec case class SearchTermSuggestOption(
	text: String, 
	freq: long, 
	score: double
)

@JsonCodec case class SearchTermSuggester(
	lowercase_terms: Boolean, 
	max_edits: integer, 
	max_inspections: integer, 
	max_term_freq: float, 
	min_doc_freq: float, 
	min_word_length: integer, 
	prefix_length: integer, 
	shard_size: integer, 
	sort: SearchSuggestSort, 
	string_distance: SearchStringDistance, 
	suggest_mode: SuggestMode, 
	text: String
) extends SearchSuggesterBase

@JsonCodec case class SearchTotalHits(
	relation: SearchTotalHitsRelation, 
	value: long
)
type SearchTotalHitsRelation = "eq"" | "gte""

@JsonCodec case class SearchShardsRequest(
	index: Indices, 
	allow_no_indices: Boolean, 
	expand_wildcards: ExpandWildcards, 
	ignore_unavailable: Boolean, 
	local: Boolean, 
	preference: String, 
	routing: Routing
) extends RequestBase

@JsonCodec case class SearchShardsResponse(
	nodes: Record[String, NodeAttributes], 
	shards: Seq[Seq[NodeShard]], 
	indices: Record[IndexName, SearchShardsShardStoreIndex]
)

@JsonCodec case class SearchShardsShardStoreIndex(
	aliases: Seq[Name], 
	filter: QueryDslQueryContainer
)

@JsonCodec case class SearchTemplateRequest(
	index: Indices, 
	`type`: Types, 
	allow_no_indices: Boolean, 
	ccs_minimize_roundtrips: Boolean, 
	expand_wildcards: ExpandWildcards, 
	explain: Boolean, 
	ignore_throttled: Boolean, 
	ignore_unavailable: Boolean, 
	preference: String, 
	profile: Boolean, 
	routing: Routing, 
	scroll: Time, 
	search_type: SearchType, 
	total_hits_as_integer: Boolean, 
	typed_keys: Boolean, 
	body: Body
) extends RequestBase

object SearchTemplateRequest {
	@JsonCodec case class Body(
		id: Id, 
		params: Record[String, Any], 
		source: String
	)
}


@JsonCodec case class SearchTemplateResponse[TDocument = None](
	_shards: ShardStatistics, 
	timed_out: Boolean, 
	took: integer, 
	hits: SearchHitsMetadata[TDocument]
)

@JsonCodec case class TermsEnumRequest(
	index: IndexName, 
	body: Body
) extends RequestBase

object TermsEnumRequest {
	@JsonCodec case class Body(
		field: Field, 
		size: integer, 
		timeout: Time, 
		case_insensitive: Boolean, 
		index_filter: QueryDslQueryContainer, 
		string: String, 
		search_after: String
	)
}


@JsonCodec case class TermsEnumResponse(
	_shards: ShardStatistics, 
	terms: Seq[String], 
	complete: Boolean
)

@JsonCodec case class TermvectorsFieldStatistics(
	doc_count: integer, 
	sum_doc_freq: long, 
	sum_ttf: long
)

@JsonCodec case class TermvectorsFilter(
	max_doc_freq: integer, 
	max_num_terms: integer, 
	max_term_freq: integer, 
	max_word_length: integer, 
	min_doc_freq: integer, 
	min_term_freq: integer, 
	min_word_length: integer
)

@JsonCodec case class TermvectorsRequest[TDocument = None](
	index: IndexName, 
	id: Id, 
	`type`: Type, 
	fields: Fields, 
	field_statistics: Boolean, 
	offsets: Boolean, 
	payloads: Boolean, 
	positions: Boolean, 
	preference: String, 
	realtime: Boolean, 
	routing: Routing, 
	term_statistics: Boolean, 
	version: VersionNumber, 
	version_type: VersionType, 
	body: Body
) extends RequestBase

object TermvectorsRequest {
	@JsonCodec case class Body(
		doc: TDocument, 
		filter: TermvectorsFilter, 
		per_field_analyzer: Record[Field, String]
	)
}


@JsonCodec case class TermvectorsResponse(
	found: Boolean, 
	_id: Id, 
	_index: IndexName, 
	term_vectors: Record[Field, TermvectorsTermVector], 
	took: long, 
	_type: Type, 
	_version: VersionNumber
)

@JsonCodec case class TermvectorsTerm(
	doc_freq: integer, 
	score: double, 
	term_freq: integer, 
	tokens: Seq[TermvectorsToken], 
	ttf: integer
)

@JsonCodec case class TermvectorsTermVector(
	field_statistics: TermvectorsFieldStatistics, 
	terms: Record[String, TermvectorsTerm]
)

@JsonCodec case class TermvectorsToken(
	end_offset: integer, 
	payload: String, 
	position: integer, 
	start_offset: integer
)

@JsonCodec case class UpdateRequest[TDocument = None, TPartialDocument = None](
	id: Id, 
	index: IndexName, 
	`type`: Type, 
	if_primary_term: long, 
	if_seq_no: SequenceNumber, 
	lang: String, 
	refresh: Refresh, 
	require_alias: Boolean, 
	retry_on_conflict: long, 
	routing: Routing, 
	source_enabled: Boolean, 
	timeout: Time, 
	wait_for_active_shards: WaitForActiveShards, 
	_source: Boolean | Fields, 
	_source_excludes: Fields, 
	_source_includes: Fields, 
	body: Body
) extends RequestBase

object UpdateRequest {
	@JsonCodec case class Body(
		detect_noop: Boolean, 
		doc: TPartialDocument, 
		doc_as_upsert: Boolean, 
		script: Script, 
		scripted_upsert: Boolean, 
		_source: Boolean | SearchSourceFilter, 
		upsert: TDocument
	)
}


@JsonCodec case class UpdateResponse[TDocument = None](
	get: InlineGet[TDocument]
) extends WriteResponseBase

@JsonCodec case class UpdateByQueryRequest(
	index: Indices, 
	`type`: Types, 
	allow_no_indices: Boolean, 
	analyzer: String, 
	analyze_wildcard: Boolean, 
	conflicts: Conflicts, 
	default_operator: DefaultOperator, 
	df: String, 
	expand_wildcards: ExpandWildcards, 
	from: long, 
	ignore_unavailable: Boolean, 
	lenient: Boolean, 
	pipeline: String, 
	preference: String, 
	query_on_query_string: String, 
	refresh: Boolean, 
	request_cache: Boolean, 
	requests_per_second: long, 
	routing: Routing, 
	scroll: Time, 
	scroll_size: long, 
	search_timeout: Time, 
	search_type: SearchType, 
	size: long, 
	slices: long, 
	sort: Seq[String], 
	source_enabled: Boolean, 
	source_excludes: Fields, 
	source_includes: Fields, 
	stats: Seq[String], 
	terminate_after: long, 
	timeout: Time, 
	version: Boolean, 
	version_type: Boolean, 
	wait_for_active_shards: WaitForActiveShards, 
	wait_for_completion: Boolean, 
	body: Body
) extends RequestBase

object UpdateByQueryRequest {
	@JsonCodec case class Body(
		max_docs: long, 
		query: QueryDslQueryContainer, 
		script: Script, 
		slice: SlicedScroll, 
		conflicts: Conflicts
	)
}


@JsonCodec case class UpdateByQueryResponse(
	batches: long, 
	failures: Seq[BulkIndexByScrollFailure], 
	noops: long, 
	deleted: long, 
	requests_per_second: float, 
	retries: Retries, 
	task: TaskId, 
	timed_out: Boolean, 
	took: long, 
	total: long, 
	updated: long, 
	version_conflicts: long, 
	throttled_millis: ulong, 
	throttled_until_millis: ulong
)

@JsonCodec case class UpdateByQueryRethrottleRequest(
	task_id: Id, 
	requests_per_second: long
) extends RequestBase

@JsonCodec case class UpdateByQueryRethrottleResponse(
	nodes: Record[String, UpdateByQueryRethrottleUpdateByQueryRethrottleNode]
)

@JsonCodec case class UpdateByQueryRethrottleUpdateByQueryRethrottleNode(
	tasks: Record[TaskId, TaskInfo]
) extends SpecUtilsBaseNode

@JsonCodec case class SpecUtilsBaseNode(
	attributes: Record[String, String], 
	host: Host, 
	ip: Ip, 
	name: Name, 
	roles: NodeRoles, 
	transport_address: TransportAddress
)

@JsonCodec case class AcknowledgedResponseBase(
	acknowledged: Boolean
)
type AggregateName = String

@JsonCodec case class BulkIndexByScrollFailure(
	cause: MainError, 
	id: Id, 
	index: IndexName, 
	status: integer, 
	`type`: String
)

@JsonCodec case class BulkStats(
	total_operations: long, 
	total_time: String, 
	total_time_in_millis: long, 
	total_size: ByteSize, 
	total_size_in_bytes: long, 
	avg_time: String, 
	avg_time_in_millis: long, 
	avg_size: ByteSize, 
	avg_size_in_bytes: long
)
type ByteSize = long | String
type Bytes = "b"" | "k"" | "kb"" | "m"" | "mb"" | "g"" | "gb"" | "t"" | "tb"" | "p"" | "pb""
type CategoryId = String

@JsonCodec case class ChainTransform(
	transforms: Seq[TransformContainer]
)

@JsonCodec case class ClusterStatistics(
	skipped: integer, 
	successful: integer, 
	total: integer
)

@JsonCodec case class CompletionStats(
	size_in_bytes: long, 
	size: ByteSize, 
	fields: Record[Field, FieldSizeUsage]
)
type Conflicts = "abort"" | "proceed""
type DataStreamName = String

@JsonCodec case class DateField(
	field: Field, 
	format: String, 
	include_unmapped: Boolean
)
type DateMath = String
type DateMathTime = String
type DateString = String
type DefaultOperator = "AND"" | "OR""

@JsonCodec case class DictionaryResponseBase[TKey = None, TValue = None](
[[MemberIndex: TsMemberIndex(NoComments,false,Default,Dict(TsIdentSimple(key),TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(string))),IArray())),Some(TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(TValue))),IArray())))]]
)
type Distance = String
type DistanceUnit = "in"" | "ft"" | "yd"" | "mi"" | "nmi"" | "km"" | "m"" | "cm"" | "mm""

@JsonCodec case class DocStats(
	count: long, 
	deleted: long
)

@JsonCodec case class ElasticsearchVersionInfo(
	build_date: DateString, 
	build_flavor: String, 
	build_hash: String, 
	build_snapshot: Boolean, 
	build_type: String, 
	lucene_version: VersionString, 
	minimum_index_compatibility_version: VersionString, 
	minimum_wire_compatibility_version: VersionString, 
	number: String
)

@JsonCodec sealed trait EmptyObject
type EpochMillis = String | long

@JsonCodec case class ErrorCause(
	`type`: String, 
	reason: String, 
	caused_by: ErrorCause, 
	shard: integer | String, 
	stack_trace: String, 
	root_cause: Seq[ErrorCause], 
	bytes_limit: long, 
	bytes_wanted: long, 
	column: integer, 
	col: integer, 
	failed_shards: Seq[ShardFailure], 
	grouped: Boolean, 
	index: IndexName, 
	index_uuid: Uuid, 
	language: String, 
	licensed_expired_feature: String, 
	line: integer, 
	max_buckets: integer, 
	phase: String, 
	property_name: String, 
	processor_type: String, 
	resource_id: Ids, 
	`resource.id`: Ids, 
	resource_type: String, 
	`resource.type`: String, 
	script: String, 
	script_stack: Seq[String], 
	header: HttpHeaders, 
	lang: String, 
	position: ScriptsPainlessExecutePainlessExecutionPosition
)

@JsonCodec case class ErrorResponseBase(
	error: MainError | String, 
	status: integer
)
type ExpandWildcardOptions = "all"" | "open"" | "closed"" | "hidden"" | "none""
type ExpandWildcards = ExpandWildcardOptions | Seq[ExpandWildcardOptions] | String
type Field = String

@JsonCodec case class FieldMemoryUsage(
	memory_size: ByteSize, 
	memory_size_in_bytes: long
)

@JsonCodec case class FieldSizeUsage(
	size: ByteSize, 
	size_in_bytes: long
)

@JsonCodec case class FielddataStats(
	evictions: long, 
	memory_size: ByteSize, 
	memory_size_in_bytes: long, 
	fields: Record[Field, FieldMemoryUsage]
)
type Fields = Field | Seq[Field]

@JsonCodec case class FlushStats(
	periodic: long, 
	total: long, 
	total_time: String, 
	total_time_in_millis: long
)
type Fuzziness = String | integer
type GeoDistanceType = "arc"" | "plane""
type GeoHashPrecision = Double
type GeoShapeRelation = "intersects"" | "disjoint"" | "within"" | "contains""
type GeoTilePrecision = Double

@JsonCodec case class GetStats(
	current: long, 
	exists_time: String, 
	exists_time_in_millis: long, 
	exists_total: long, 
	missing_time: String, 
	missing_time_in_millis: long, 
	missing_total: long, 
	time: String, 
	time_in_millis: long, 
	total: long
)
type GroupBy = "nodes"" | "parents"" | "none""
type Health = "green"" | "yellow"" | "red""
type Host = String
type HttpHeaders = Record[String, String | Seq[String]]
type Id = String
type Ids = Id | Seq[Id]
type IndexAlias = String
type IndexName = String
type IndexPattern = String
type IndexPatterns = Seq[IndexPattern]

@JsonCodec case class IndexedScript(
	id: Id
) extends ScriptBase

@JsonCodec case class IndexingStats(
	index_current: long, 
	delete_current: long, 
	delete_time: String, 
	delete_time_in_millis: long, 
	delete_total: long, 
	is_throttled: Boolean, 
	noop_update_total: long, 
	throttle_time: String, 
	throttle_time_in_millis: long, 
	index_time: String, 
	index_time_in_millis: long, 
	index_total: long, 
	index_failed: long, 
	types: Record[String, IndexingStats]
)
type Indices = String | Seq[String]

@JsonCodec case class IndicesResponseBase(
	_shards: ShardStatistics
) extends AcknowledgedResponseBase

@JsonCodec case class InlineGet[TDocument = None](
	fields: Record[String, Any], 
	found: Boolean, 
	_seq_no: SequenceNumber, 
	_primary_term: long, 
	_routing: Routing, 
	_source: TDocument
)

@JsonCodec case class InlineScript(
	source: String
) extends ScriptBase
type Ip = String

@JsonCodec case class LatLon(
	lat: double, 
	lon: double
)
type Level = "cluster"" | "indices"" | "shards""
type LifecycleOperationMode = "RUNNING"" | "STOPPING"" | "STOPPED""

@JsonCodec case class MainError(
	headers: Record[String, String], 
	root_cause: Seq[ErrorCause]
) extends ErrorCause

@JsonCodec case class MergesStats(
	current: long, 
	current_docs: long, 
	current_size: String, 
	current_size_in_bytes: long, 
	total: long, 
	total_auto_throttle: String, 
	total_auto_throttle_in_bytes: long, 
	total_docs: long, 
	total_size: String, 
	total_size_in_bytes: long, 
	total_stopped_time: String, 
	total_stopped_time_in_millis: long, 
	total_throttled_time: String, 
	total_throttled_time_in_millis: long, 
	total_time: String, 
	total_time_in_millis: long
)
type Metadata = Record[String, Any]
type Metrics = String | Seq[String]
type MinimumShouldMatch = integer | String
type MultiTermQueryRewrite = String
type Name = String
type Names = String | Seq[String]
type Namespace = String

@JsonCodec case class NodeAttributes(
	attributes: Record[String, String], 
	ephemeral_id: Id, 
	id: Id, 
	name: NodeName, 
	transport_address: TransportAddress, 
	roles: NodeRoles
)
type NodeId = String
type NodeIds = String
type NodeName = String
type NodeRole = "master"" | "data"" | "data_cold"" | "data_content"" | "data_frozen"" | "data_hot"" | "data_warm"" | "client"" | "ingest"" | "ml"" | "voting_only"" | "transform"" | "remote_cluster_client"" | "coordinating_only""
type NodeRoles = Seq[NodeRole]

@JsonCodec case class NodeShard(
	state: IndicesStatsShardRoutingState, 
	primary: Boolean, 
	node: NodeName, 
	shard: integer, 
	index: IndexName, 
	allocation_id: Record[String, Id], 
	recovery_source: Record[String, Id], 
	unassigned_info: ClusterAllocationExplainUnassignedInformation
)

@JsonCodec case class NodeStatistics(
	failures: Seq[ErrorCause], 
	total: integer, 
	successful: integer, 
	failed: integer
)
type OpType = "index"" | "create""
type Password = String
type Percentage = String | float
type PipelineName = String

@JsonCodec case class PluginStats(
	classname: String, 
	description: String, 
	elasticsearch_version: VersionString, 
	extended_plugins: Seq[String], 
	has_native_controller: Boolean, 
	java_version: VersionString, 
	name: Name, 
	version: VersionString, 
	licensed: Boolean, 
	`type`: String
)
type PropertyName = String

@JsonCodec case class QueryCacheStats(
	cache_count: integer, 
	cache_size: integer, 
	evictions: integer, 
	hit_count: integer, 
	memory_size: ByteSize, 
	memory_size_in_bytes: integer, 
	miss_count: integer, 
	total_count: integer
)

@JsonCodec case class RecoveryStats(
	current_as_source: long, 
	current_as_target: long, 
	throttle_time: String, 
	throttle_time_in_millis: long
)
type Refresh = Boolean | RefreshOptions
type RefreshOptions = "wait_for""

@JsonCodec case class RefreshStats(
	external_total: long, 
	external_total_time_in_millis: long, 
	listeners: long, 
	total: long, 
	total_time: String, 
	total_time_in_millis: long
)
type RelationName = String

@JsonCodec case class RequestBase extends SpecUtilsCommonQueryParameters

@JsonCodec case class RequestCacheStats(
	evictions: long, 
	hit_count: long, 
	memory_size: String, 
	memory_size_in_bytes: long, 
	miss_count: long
)
type Result = "Error"" | "created"" | "updated"" | "deleted"" | "not_found"" | "noop""

@JsonCodec case class Retries(
	bulk: long, 
	search: long
)
type Routing = String | Double
type Script = InlineScript | IndexedScript | String

@JsonCodec case class ScriptBase(
	lang: ScriptLanguage, 
	params: Record[String, Any]
)

@JsonCodec case class ScriptField(
	script: Script
)
type ScriptLanguage = "painless"" | "expression"" | "mustache"" | "java""

@JsonCodec case class ScriptTransform(
	lang: String, 
	params: Record[String, Any]
)
type ScrollId = String

@JsonCodec case class SearchStats(
	fetch_current: long, 
	fetch_time_in_millis: long, 
	fetch_total: long, 
	open_contexts: long, 
	query_current: long, 
	query_time_in_millis: long, 
	query_total: long, 
	scroll_current: long, 
	scroll_time_in_millis: long, 
	scroll_total: long, 
	suggest_current: long, 
	suggest_time_in_millis: long, 
	suggest_total: long, 
	groups: Record[String, SearchStats]
)

@JsonCodec case class SearchTransform(
	request: WatcherSearchInputRequestDefinition, 
	timeout: Time
)
type SearchType = "query_then_fetch"" | "dfs_query_then_fetch""

@JsonCodec case class SegmentsStats(
	count: integer, 
	doc_values_memory: ByteSize, 
	doc_values_memory_in_bytes: integer, 
	file_sizes: Record[String, IndicesStatsShardFileSizeInfo], 
	fixed_bit_set: ByteSize, 
	fixed_bit_set_memory_in_bytes: integer, 
	index_writer_memory: ByteSize, 
	index_writer_max_memory_in_bytes: integer, 
	index_writer_memory_in_bytes: integer, 
	max_unsafe_auto_id_timestamp: integer, 
	memory: ByteSize, 
	memory_in_bytes: integer, 
	norms_memory: ByteSize, 
	norms_memory_in_bytes: integer, 
	points_memory: ByteSize, 
	points_memory_in_bytes: integer, 
	stored_memory: ByteSize, 
	stored_fields_memory_in_bytes: integer, 
	terms_memory_in_bytes: integer, 
	terms_memory: ByteSize, 
	term_vectory_memory: ByteSize, 
	term_vectors_memory_in_bytes: integer, 
	version_map_memory: ByteSize, 
	version_map_memory_in_bytes: integer
)
type SequenceNumber = integer
type Service = String
type ShapeRelation = "intersects"" | "disjoint"" | "within""

@JsonCodec case class ShardFailure(
	index: IndexName, 
	node: String, 
	reason: ErrorCause, 
	shard: integer, 
	status: String
)

@JsonCodec case class ShardStatistics(
	failed: uint, 
	successful: uint, 
	total: uint, 
	failures: Seq[ShardFailure], 
	skipped: uint
)

@JsonCodec case class ShardsOperationResponseBase(
	_shards: ShardStatistics
)
type Size = "Raw"" | "k"" | "m"" | "g"" | "t"" | "p""

@JsonCodec case class SlicedScroll(
	field: Field, 
	id: integer, 
	max: integer
)

@JsonCodec case class StoreStats(
	size: ByteSize, 
	size_in_bytes: integer, 
	reserved: ByteSize, 
	reserved_in_bytes: integer, 
	total_data_set_size: ByteSize, 
	total_data_set_size_in_bytes: integer
)

@JsonCodec case class StoredScript(
	lang: ScriptLanguage, 
	source: String
)
type SuggestMode = "missing"" | "popular"" | "always""
type SuggestionName = String
type TaskId = String | integer
type ThreadType = "cpu"" | "wait"" | "block""
type Time = String | integer
type TimeSpan = String
type Timestamp = String

@JsonCodec sealed trait Transform

@JsonCodec case class TransformContainer(
	chain: ChainTransform, 
	script: ScriptTransform, 
	search: SearchTransform
)

@JsonCodec case class TranslogStats(
	earliest_last_modified_age: long, 
	operations: long, 
	size: String, 
	size_in_bytes: long, 
	uncommitted_operations: integer, 
	uncommitted_size: String, 
	uncommitted_size_in_bytes: long
)
type TransportAddress = String
type Type = String
type Types = Type | Seq[Type]
type Username = String
type Uuid = String
type VersionNumber = long
type VersionString = String
type VersionType = "internal"" | "external"" | "external_gte"" | "force""
type WaitForActiveShardOptions = "all""
type WaitForActiveShards = integer | WaitForActiveShardOptions
type WaitForEvents = "immediate"" | "urgent"" | "high"" | "normal"" | "low"" | "languid""
type WaitForStatus = "green"" | "yellow"" | "red""

@JsonCodec case class WarmerStats(
	current: long, 
	total: long, 
	total_time: String, 
	total_time_in_millis: long
)

@JsonCodec case class WriteResponseBase(
	_id: Id, 
	_index: IndexName, 
	_primary_term: long, 
	result: Result, 
	_seq_no: SequenceNumber, 
	_shards: ShardStatistics, 
	_type: Type, 
	_version: VersionNumber, 
	forced_refresh: Boolean
)
type double = Double
type float = Double
type integer = Double
type long = Double
type uint = Double
type ulong = Double

@JsonCodec case class AggregationsAdjacencyMatrixAggregation(
	filters: Record[String, QueryDslQueryContainer]
) extends AggregationsBucketAggregationBase
type AggregationsAggregate = AggregationsSingleBucketAggregate | AggregationsAutoDateHistogramAggregate | AggregationsFiltersAggregate | AggregationsSignificantTermsAggregate[Any] | AggregationsTermsAggregate[Any] | AggregationsBucketAggregate | AggregationsCompositeBucketAggregate | AggregationsMultiBucketAggregate[AggregationsBucket] | AggregationsMatrixStatsAggregate | AggregationsKeyedValueAggregate | AggregationsMetricAggregate

@JsonCodec case class AggregationsAggregateBase(
	meta: Record[String, Any]
)

@JsonCodec case class AggregationsAggregation(
	meta: Record[String, Any], 
	name: String
)

@JsonCodec case class AggregationsAggregationContainer(
	aggs: Record[String, AggregationsAggregationContainer], 
	meta: Record[String, Any], 
	adjacency_matrix: AggregationsAdjacencyMatrixAggregation, 
	aggregations: Record[String, AggregationsAggregationContainer], 
	auto_date_histogram: AggregationsAutoDateHistogramAggregation, 
	avg: AggregationsAverageAggregation, 
	avg_bucket: AggregationsAverageBucketAggregation, 
	boxplot: AggregationsBoxplotAggregation, 
	bucket_script: AggregationsBucketScriptAggregation, 
	bucket_selector: AggregationsBucketSelectorAggregation, 
	bucket_sort: AggregationsBucketSortAggregation, 
	cardinality: AggregationsCardinalityAggregation, 
	children: AggregationsChildrenAggregation, 
	composite: AggregationsCompositeAggregation, 
	cumulative_cardinality: AggregationsCumulativeCardinalityAggregation, 
	cumulative_sum: AggregationsCumulativeSumAggregation, 
	date_histogram: AggregationsDateHistogramAggregation, 
	date_range: AggregationsDateRangeAggregation, 
	derivative: AggregationsDerivativeAggregation, 
	diversified_sampler: AggregationsDiversifiedSamplerAggregation, 
	extended_stats: AggregationsExtendedStatsAggregation, 
	extended_stats_bucket: AggregationsExtendedStatsBucketAggregation, 
	filter: QueryDslQueryContainer, 
	filters: AggregationsFiltersAggregation, 
	geo_bounds: AggregationsGeoBoundsAggregation, 
	geo_centroid: AggregationsGeoCentroidAggregation, 
	geo_distance: AggregationsGeoDistanceAggregation, 
	geohash_grid: AggregationsGeoHashGridAggregation, 
	geo_line: AggregationsGeoLineAggregation, 
	geotile_grid: AggregationsGeoTileGridAggregation, 
	global: AggregationsGlobalAggregation, 
	histogram: AggregationsHistogramAggregation, 
	ip_range: AggregationsIpRangeAggregation, 
	inference: AggregationsInferenceAggregation, 
	line: AggregationsGeoLineAggregation, 
	matrix_stats: AggregationsMatrixStatsAggregation, 
	max: AggregationsMaxAggregation, 
	max_bucket: AggregationsMaxBucketAggregation, 
	median_absolute_deviation: AggregationsMedianAbsoluteDeviationAggregation, 
	min: AggregationsMinAggregation, 
	min_bucket: AggregationsMinBucketAggregation, 
	missing: AggregationsMissingAggregation, 
	moving_avg: AggregationsMovingAverageAggregation, 
	moving_percentiles: AggregationsMovingPercentilesAggregation, 
	moving_fn: AggregationsMovingFunctionAggregation, 
	multi_terms: AggregationsMultiTermsAggregation, 
	nested: AggregationsNestedAggregation, 
	normalize: AggregationsNormalizeAggregation, 
	parent: AggregationsParentAggregation, 
	percentile_ranks: AggregationsPercentileRanksAggregation, 
	percentiles: AggregationsPercentilesAggregation, 
	percentiles_bucket: AggregationsPercentilesBucketAggregation, 
	range: AggregationsRangeAggregation, 
	rare_terms: AggregationsRareTermsAggregation, 
	rate: AggregationsRateAggregation, 
	reverse_nested: AggregationsReverseNestedAggregation, 
	sampler: AggregationsSamplerAggregation, 
	scripted_metric: AggregationsScriptedMetricAggregation, 
	serial_diff: AggregationsSerialDifferencingAggregation, 
	significant_terms: AggregationsSignificantTermsAggregation, 
	significant_text: AggregationsSignificantTextAggregation, 
	stats: AggregationsStatsAggregation, 
	stats_bucket: AggregationsStatsBucketAggregation, 
	string_stats: AggregationsStringStatsAggregation, 
	sum: AggregationsSumAggregation, 
	sum_bucket: AggregationsSumBucketAggregation, 
	terms: AggregationsTermsAggregation, 
	top_hits: AggregationsTopHitsAggregation, 
	t_test: AggregationsTTestAggregation, 
	top_metrics: AggregationsTopMetricsAggregation, 
	value_count: AggregationsValueCountAggregation, 
	weighted_avg: AggregationsWeightedAverageAggregation, 
	variable_width_histogram: AggregationsVariableWidthHistogramAggregation
)

@JsonCodec case class AggregationsAggregationRange(
	from: double | String, 
	key: String, 
	to: double | String
)

@JsonCodec case class AggregationsAutoDateHistogramAggregate(
	interval: DateMathTime
) extends AggregationsMultiBucketAggregate[AggregationsKeyedBucket[long]]

@JsonCodec case class AggregationsAutoDateHistogramAggregation(
	buckets: integer, 
	field: Field, 
	format: String, 
	minimum_interval: AggregationsMinimumInterval, 
	missing: DateString, 
	offset: String, 
	params: Record[String, Any], 
	script: Script, 
	time_zone: String
) extends AggregationsBucketAggregationBase

@JsonCodec case class AggregationsAverageAggregation extends AggregationsFormatMetricAggregationBase

@JsonCodec case class AggregationsAverageBucketAggregation extends AggregationsPipelineAggregationBase

@JsonCodec case class AggregationsBoxPlotAggregate(
	min: double, 
	max: double, 
	q1: double, 
	q2: double, 
	q3: double
) extends AggregationsAggregateBase

@JsonCodec case class AggregationsBoxplotAggregation(
	compression: double
) extends AggregationsMetricAggregationBase
type AggregationsBucket = AggregationsCompositeBucket | AggregationsDateHistogramBucket | AggregationsFiltersBucketItem | AggregationsIpRangeBucket | AggregationsRangeBucket | AggregationsRareTermsBucket[Any] | AggregationsSignificantTermsBucket[Any] | AggregationsKeyedBucket[Any]

@JsonCodec case class AggregationsBucketAggregate(
	after_key: Record[String, Any], 
	bg_count: long, 
	doc_count: long, 
	doc_count_error_upper_bound: long, 
	sum_other_doc_count: long, 
	interval: DateMathTime, 
	items: AggregationsBucket
) extends AggregationsAggregateBase

@JsonCodec case class AggregationsBucketAggregationBase(
	aggregations: Record[String, AggregationsAggregationContainer]
) extends AggregationsAggregation

@JsonCodec case class AggregationsBucketScriptAggregation(
	script: Script
) extends AggregationsPipelineAggregationBase

@JsonCodec case class AggregationsBucketSelectorAggregation(
	script: Script
) extends AggregationsPipelineAggregationBase

@JsonCodec case class AggregationsBucketSortAggregation(
	from: integer, 
	gap_policy: AggregationsGapPolicy, 
	size: integer, 
	sort: SearchSort
) extends AggregationsAggregation

@JsonCodec sealed trait AggregationsBucketsPath

@JsonCodec case class AggregationsCardinalityAggregation(
	precision_threshold: integer, 
	rehash: Boolean
) extends AggregationsMetricAggregationBase

@JsonCodec case class AggregationsChiSquareHeuristic(
	background_is_superset: Boolean, 
	include_negatives: Boolean
)

@JsonCodec case class AggregationsChildrenAggregation(
	`type`: RelationName
) extends AggregationsBucketAggregationBase

@JsonCodec case class AggregationsClassificationInferenceOptions(
	num_top_classes: integer, 
	num_top_feature_importance_values: integer, 
	prediction_field_type: String, 
	results_field: String, 
	top_classes_results_field: String
)

@JsonCodec case class AggregationsCompositeAggregation(
	after: Record[String, String | float | null], 
	size: integer, 
	sources: Seq[Record[String, AggregationsCompositeAggregationSource]]
) extends AggregationsBucketAggregationBase

@JsonCodec case class AggregationsCompositeAggregationSource(
	terms: AggregationsTermsAggregation, 
	histogram: AggregationsHistogramAggregation, 
	date_histogram: AggregationsDateHistogramAggregation, 
	geotile_grid: AggregationsGeoTileGridAggregation
)

@JsonCodec sealed trait AggregationsCompositeBucketKeys
type AggregationsCompositeBucket = AggregationsCompositeBucketKeys | @JsonCodec case class Undefined(
[[MemberIndex: TsMemberIndex(NoComments,false,Default,Dict(TsIdentSimple(property),TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(string))),IArray())),Some(TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(AggregationsAggregate))),IArray())))]]
)


@JsonCodec case class AggregationsCompositeBucketAggregate(
	after_key: Record[String, Any]
) extends AggregationsMultiBucketAggregate[Record[String, Any]]

@JsonCodec case class AggregationsCumulativeCardinalityAggregation extends AggregationsPipelineAggregationBase

@JsonCodec case class AggregationsCumulativeSumAggregation extends AggregationsPipelineAggregationBase

@JsonCodec case class AggregationsDateHistogramAggregation(
	calendar_interval: AggregationsDateInterval | Time, 
	extended_bounds: AggregationsExtendedBounds[DateMath | long], 
	hard_bounds: AggregationsExtendedBounds[DateMath | long], 
	field: Field, 
	fixed_interval: AggregationsDateInterval | Time, 
	format: String, 
	interval: AggregationsDateInterval | Time, 
	min_doc_count: integer, 
	missing: DateString, 
	offset: Time, 
	order: AggregationsHistogramOrder, 
	params: Record[String, Any], 
	script: Script, 
	time_zone: String
) extends AggregationsBucketAggregationBase

@JsonCodec sealed trait AggregationsDateHistogramBucketKeys
type AggregationsDateHistogramBucket = AggregationsDateHistogramBucketKeys | @JsonCodec case class Undefined(
[[MemberIndex: TsMemberIndex(NoComments,false,Default,Dict(TsIdentSimple(property),TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(string))),IArray())),Some(TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(AggregationsAggregate))),IArray())))]]
)

type AggregationsDateInterval = "second"" | "minute"" | "hour"" | "day"" | "week"" | "month"" | "quarter"" | "year""

@JsonCodec case class AggregationsDateRangeAggregation(
	field: Field, 
	format: String, 
	missing: AggregationsMissing, 
	ranges: Seq[AggregationsDateRangeExpression], 
	time_zone: String
) extends AggregationsBucketAggregationBase

@JsonCodec case class AggregationsDateRangeExpression(
	from: DateMath | float, 
	from_as_string: String, 
	to_as_string: String, 
	key: String, 
	to: DateMath | float, 
	doc_count: long
)

@JsonCodec case class AggregationsDerivativeAggregation extends AggregationsPipelineAggregationBase

@JsonCodec case class AggregationsDiversifiedSamplerAggregation(
	execution_hint: AggregationsSamplerAggregationExecutionHint, 
	max_docs_per_value: integer, 
	script: Script, 
	shard_size: integer, 
	field: Field
) extends AggregationsBucketAggregationBase

@JsonCodec case class AggregationsEwmaModelSettings(
	alpha: float
)

@JsonCodec case class AggregationsExtendedBounds[T = None](
	max: T, 
	min: T
)

@JsonCodec case class AggregationsExtendedStatsAggregate(
	std_deviation_bounds: AggregationsStandardDeviationBounds, 
	sum_of_squares: double, 
	variance: double, 
	variance_population: double, 
	variance_sampling: double, 
	std_deviation: double, 
	std_deviation_population: double, 
	std_deviation_sampling: double
) extends AggregationsStatsAggregate

@JsonCodec case class AggregationsExtendedStatsAggregation(
	sigma: double
) extends AggregationsFormatMetricAggregationBase

@JsonCodec case class AggregationsExtendedStatsBucketAggregation(
	sigma: double
) extends AggregationsPipelineAggregationBase

@JsonCodec case class AggregationsFiltersAggregate(
	buckets: Seq[AggregationsFiltersBucketItem] | Record[String, AggregationsFiltersBucketItem]
) extends AggregationsAggregateBase

@JsonCodec case class AggregationsFiltersAggregation(
	filters: Record[String, QueryDslQueryContainer] | Seq[QueryDslQueryContainer], 
	other_bucket: Boolean, 
	other_bucket_key: String
) extends AggregationsBucketAggregationBase

@JsonCodec case class AggregationsFiltersBucketItemKeys(
	doc_count: long
)
type AggregationsFiltersBucketItem = AggregationsFiltersBucketItemKeys | @JsonCodec case class Undefined(
[[MemberIndex: TsMemberIndex(NoComments,false,Default,Dict(TsIdentSimple(property),TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(string))),IArray())),Some(TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(AggregationsAggregate))),IArray())))]]
)


@JsonCodec case class AggregationsFormatMetricAggregationBase(
	format: String
) extends AggregationsMetricAggregationBase

@JsonCodec case class AggregationsFormattableMetricAggregation(
	format: String
) extends AggregationsMetricAggregationBase
type AggregationsGapPolicy = "skip"" | "insert_zeros""

@JsonCodec case class AggregationsGeoBounds(
	bottom_right: LatLon, 
	top_left: LatLon
)

@JsonCodec case class AggregationsGeoBoundsAggregate(
	bounds: AggregationsGeoBounds
) extends AggregationsAggregateBase

@JsonCodec case class AggregationsGeoBoundsAggregation(
	wrap_longitude: Boolean
) extends AggregationsMetricAggregationBase

@JsonCodec case class AggregationsGeoCentroidAggregate(
	count: long, 
	location: QueryDslGeoLocation
) extends AggregationsAggregateBase

@JsonCodec case class AggregationsGeoCentroidAggregation(
	count: long, 
	location: QueryDslGeoLocation
) extends AggregationsMetricAggregationBase

@JsonCodec case class AggregationsGeoDistanceAggregation(
	distance_type: GeoDistanceType, 
	field: Field, 
	origin: QueryDslGeoLocation | String, 
	ranges: Seq[AggregationsAggregationRange], 
	unit: DistanceUnit
) extends AggregationsBucketAggregationBase

@JsonCodec case class AggregationsGeoHashGridAggregation(
	bounds: QueryDslBoundingBox, 
	field: Field, 
	precision: GeoHashPrecision, 
	shard_size: integer, 
	size: integer
) extends AggregationsBucketAggregationBase

@JsonCodec case class AggregationsGeoLineAggregate(
	`type`: String, 
	geometry: AggregationsLineStringGeoShape, 
	properties: AggregationsGeoLineProperties
) extends AggregationsAggregateBase

@JsonCodec case class AggregationsGeoLineAggregation(
	point: AggregationsGeoLinePoint, 
	sort: AggregationsGeoLineSort, 
	include_sort: Boolean, 
	sort_order: SearchSortOrder, 
	size: integer
)

@JsonCodec case class AggregationsGeoLinePoint(
	field: Field
)

@JsonCodec case class AggregationsGeoLineProperties(
	complete: Boolean, 
	sort_values: Seq[double]
)

@JsonCodec case class AggregationsGeoLineSort(
	field: Field
)

@JsonCodec case class AggregationsGeoTileGridAggregation(
	field: Field, 
	precision: GeoTilePrecision, 
	shard_size: integer, 
	size: integer, 
	bounds: AggregationsGeoBounds
) extends AggregationsBucketAggregationBase

@JsonCodec case class AggregationsGlobalAggregation extends AggregationsBucketAggregationBase

@JsonCodec case class AggregationsGoogleNormalizedDistanceHeuristic(
	background_is_superset: Boolean
)

@JsonCodec case class AggregationsHdrMethod(
	number_of_significant_value_digits: integer
)

@JsonCodec case class AggregationsHdrPercentileItem(
	key: double, 
	value: double
)

@JsonCodec case class AggregationsHdrPercentilesAggregate(
	values: Seq[AggregationsHdrPercentileItem]
) extends AggregationsAggregateBase

@JsonCodec case class AggregationsHistogramAggregation(
	extended_bounds: AggregationsExtendedBounds[double], 
	hard_bounds: AggregationsExtendedBounds[double], 
	field: Field, 
	interval: double, 
	min_doc_count: integer, 
	missing: double, 
	offset: double, 
	order: AggregationsHistogramOrder, 
	script: Script, 
	format: String
) extends AggregationsBucketAggregationBase

@JsonCodec case class AggregationsHistogramOrder(
	_count: SearchSortOrder, 
	_key: SearchSortOrder
)

@JsonCodec case class AggregationsHoltLinearModelSettings(
	alpha: float, 
	beta: float
)

@JsonCodec case class AggregationsHoltWintersModelSettings(
	alpha: float, 
	beta: float, 
	gamma: float, 
	pad: Boolean, 
	period: integer, 
	`type`: AggregationsHoltWintersType
)
type AggregationsHoltWintersType = "add"" | "mult""

@JsonCodec case class AggregationsInferenceAggregation(
	model_id: Name, 
	inference_config: AggregationsInferenceConfigContainer
) extends AggregationsPipelineAggregationBase

@JsonCodec case class AggregationsInferenceConfigContainer(
	regression: AggregationsRegressionInferenceOptions, 
	classification: AggregationsClassificationInferenceOptions
)

@JsonCodec case class AggregationsIpRangeAggregation(
	field: Field, 
	ranges: Seq[AggregationsIpRangeAggregationRange]
) extends AggregationsBucketAggregationBase

@JsonCodec case class AggregationsIpRangeAggregationRange(
	from: String, 
	mask: String, 
	to: String
)

@JsonCodec sealed trait AggregationsIpRangeBucketKeys
type AggregationsIpRangeBucket = AggregationsIpRangeBucketKeys | @JsonCodec case class Undefined(
[[MemberIndex: TsMemberIndex(NoComments,false,Default,Dict(TsIdentSimple(property),TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(string))),IArray())),Some(TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(AggregationsAggregate))),IArray())))]]
)


@JsonCodec case class AggregationsKeyedBucketKeys[TKey = None](
	doc_count: long, 
	key: TKey, 
	key_as_string: String
)
type AggregationsKeyedBucket[TKey = None]  = AggregationsKeyedBucketKeys[TKey] | @JsonCodec case class Undefined(
[[MemberIndex: TsMemberIndex(NoComments,false,Default,Dict(TsIdentSimple(property),TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(string))),IArray())),Some(TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(AggregationsAggregate))),IArray())))]]
)


@JsonCodec case class AggregationsKeyedValueAggregate(
	keys: Seq[String]
) extends AggregationsValueAggregate

@JsonCodec case class AggregationsLineStringGeoShape(
	coordinates: Seq[QueryDslGeoCoordinate]
)

@JsonCodec case class AggregationsMatrixAggregation(
	fields: Fields, 
	missing: Record[Field, double]
) extends AggregationsAggregation

@JsonCodec case class AggregationsMatrixStatsAggregate(
	correlation: Record[String, double], 
	covariance: Record[String, double], 
	count: integer, 
	kurtosis: double, 
	mean: double, 
	skewness: double, 
	variance: double, 
	name: String
) extends AggregationsAggregateBase

@JsonCodec case class AggregationsMatrixStatsAggregation(
	mode: AggregationsMatrixStatsMode
) extends AggregationsMatrixAggregation
type AggregationsMatrixStatsMode = "avg"" | "min"" | "max"" | "sum"" | "median""

@JsonCodec case class AggregationsMaxAggregation extends AggregationsFormatMetricAggregationBase

@JsonCodec case class AggregationsMaxBucketAggregation extends AggregationsPipelineAggregationBase

@JsonCodec case class AggregationsMedianAbsoluteDeviationAggregation(
	compression: double
) extends AggregationsFormatMetricAggregationBase
type AggregationsMetricAggregate = AggregationsValueAggregate | AggregationsBoxPlotAggregate | AggregationsGeoBoundsAggregate | AggregationsGeoCentroidAggregate | AggregationsGeoLineAggregate | AggregationsPercentilesAggregate | AggregationsScriptedMetricAggregate | AggregationsStatsAggregate | AggregationsStringStatsAggregate | AggregationsTopHitsAggregate | AggregationsTopMetricsAggregate | AggregationsExtendedStatsAggregate | AggregationsTDigestPercentilesAggregate | AggregationsHdrPercentilesAggregate

@JsonCodec case class AggregationsMetricAggregationBase(
	field: Field, 
	missing: AggregationsMissing, 
	script: Script
)

@JsonCodec case class AggregationsMinAggregation extends AggregationsFormatMetricAggregationBase

@JsonCodec case class AggregationsMinBucketAggregation extends AggregationsPipelineAggregationBase
type AggregationsMinimumInterval = "second"" | "minute"" | "hour"" | "day"" | "month"" | "year""
type AggregationsMissing = String | integer | double | Boolean

@JsonCodec case class AggregationsMissingAggregation(
	field: Field, 
	missing: AggregationsMissing
) extends AggregationsBucketAggregationBase

@JsonCodec case class AggregationsMovingAverageAggregation(
	minimize: Boolean, 
	model: AggregationsMovingAverageModel, 
	settings: AggregationsMovingAverageSettings, 
	predict: integer, 
	window: integer
) extends AggregationsPipelineAggregationBase
type AggregationsMovingAverageModel = "linear"" | "simple"" | "ewma"" | "holt"" | "holt_winters""
type AggregationsMovingAverageSettings = AggregationsEwmaModelSettings | AggregationsHoltLinearModelSettings | AggregationsHoltWintersModelSettings

@JsonCodec case class AggregationsMovingFunctionAggregation(
	script: String, 
	shift: integer, 
	window: integer
) extends AggregationsPipelineAggregationBase

@JsonCodec case class AggregationsMovingPercentilesAggregation(
	window: integer, 
	shift: integer
) extends AggregationsPipelineAggregationBase

@JsonCodec case class AggregationsMultiBucketAggregate[TBucket = None](
	buckets: Seq[TBucket]
) extends AggregationsAggregateBase

@JsonCodec case class AggregationsMultiTermLookup(
	field: Field
)

@JsonCodec case class AggregationsMultiTermsAggregation(
	terms: Seq[AggregationsMultiTermLookup]
) extends AggregationsBucketAggregationBase

@JsonCodec case class AggregationsMutualInformationHeuristic(
	background_is_superset: Boolean, 
	include_negatives: Boolean
)

@JsonCodec case class AggregationsNestedAggregation(
	path: Field
) extends AggregationsBucketAggregationBase

@JsonCodec case class AggregationsNormalizeAggregation(
	method: AggregationsNormalizeMethod
) extends AggregationsPipelineAggregationBase
type AggregationsNormalizeMethod = "rescale_0_1"" | "rescale_0_100"" | "percent_of_sum"" | "mean"" | "zscore"" | "softmax""

@JsonCodec case class AggregationsParentAggregation(
	`type`: RelationName
) extends AggregationsBucketAggregationBase

@JsonCodec sealed trait AggregationsPercentageScoreHeuristic

@JsonCodec case class AggregationsPercentileItem(
	percentile: double, 
	value: double
)

@JsonCodec case class AggregationsPercentileRanksAggregation(
	keyed: Boolean, 
	values: Seq[double], 
	hdr: AggregationsHdrMethod, 
	tdigest: AggregationsTDigest
) extends AggregationsFormatMetricAggregationBase

@JsonCodec case class AggregationsPercentilesAggregate(
	items: Seq[AggregationsPercentileItem]
) extends AggregationsAggregateBase

@JsonCodec case class AggregationsPercentilesAggregation(
	keyed: Boolean, 
	percents: Seq[double], 
	hdr: AggregationsHdrMethod, 
	tdigest: AggregationsTDigest
) extends AggregationsFormatMetricAggregationBase

@JsonCodec case class AggregationsPercentilesBucketAggregation(
	percents: Seq[double]
) extends AggregationsPipelineAggregationBase

@JsonCodec case class AggregationsPipelineAggregationBase(
	buckets_path: AggregationsBucketsPath, 
	format: String, 
	gap_policy: AggregationsGapPolicy
) extends AggregationsAggregation

@JsonCodec case class AggregationsRangeAggregation(
	field: Field, 
	ranges: Seq[AggregationsAggregationRange], 
	script: Script
) extends AggregationsBucketAggregationBase

@JsonCodec sealed trait AggregationsRangeBucketKeys
type AggregationsRangeBucket = AggregationsRangeBucketKeys | @JsonCodec case class Undefined(
[[MemberIndex: TsMemberIndex(NoComments,false,Default,Dict(TsIdentSimple(property),TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(string))),IArray())),Some(TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(AggregationsAggregate))),IArray())))]]
)


@JsonCodec case class AggregationsRareTermsAggregation(
	exclude: String | Seq[String], 
	field: Field, 
	include: String | Seq[String] | AggregationsTermsInclude, 
	max_doc_count: long, 
	missing: AggregationsMissing, 
	precision: double, 
	value_type: String
) extends AggregationsBucketAggregationBase

@JsonCodec sealed trait AggregationsRareTermsBucketKeys[TKey = None]
type AggregationsRareTermsBucket[TKey = None]  = AggregationsRareTermsBucketKeys[TKey] | @JsonCodec case class Undefined(
[[MemberIndex: TsMemberIndex(NoComments,false,Default,Dict(TsIdentSimple(property),TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(string))),IArray())),Some(TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(AggregationsAggregate))),IArray())))]]
)


@JsonCodec case class AggregationsRateAggregation(
	unit: AggregationsDateInterval, 
	mode: AggregationsRateMode
) extends AggregationsFormatMetricAggregationBase
type AggregationsRateMode = "sum"" | "value_count""

@JsonCodec case class AggregationsRegressionInferenceOptions(
	results_field: Field, 
	num_top_feature_importance_values: integer
)

@JsonCodec case class AggregationsReverseNestedAggregation(
	path: Field
) extends AggregationsBucketAggregationBase

@JsonCodec case class AggregationsSamplerAggregation(
	shard_size: integer
) extends AggregationsBucketAggregationBase
type AggregationsSamplerAggregationExecutionHint = "map"" | "global_ordinals"" | "bytes_hash""

@JsonCodec case class AggregationsScriptedHeuristic(
	script: Script
)

@JsonCodec case class AggregationsScriptedMetricAggregate(
	value: Any
) extends AggregationsAggregateBase

@JsonCodec case class AggregationsScriptedMetricAggregation(
	combine_script: Script, 
	init_script: Script, 
	map_script: Script, 
	params: Record[String, Any], 
	reduce_script: Script
) extends AggregationsMetricAggregationBase

@JsonCodec case class AggregationsSerialDifferencingAggregation(
	lag: integer
) extends AggregationsPipelineAggregationBase

@JsonCodec case class AggregationsSignificantTermsAggregate[TKey = None](
	bg_count: long, 
	doc_count: long
) extends AggregationsMultiBucketAggregate[TKey]

@JsonCodec case class AggregationsSignificantTermsAggregation(
	background_filter: QueryDslQueryContainer, 
	chi_square: AggregationsChiSquareHeuristic, 
	exclude: String | Seq[String], 
	execution_hint: AggregationsTermsAggregationExecutionHint, 
	field: Field, 
	gnd: AggregationsGoogleNormalizedDistanceHeuristic, 
	include: String | Seq[String], 
	min_doc_count: long, 
	mutual_information: AggregationsMutualInformationHeuristic, 
	percentage: AggregationsPercentageScoreHeuristic, 
	script_heuristic: AggregationsScriptedHeuristic, 
	shard_min_doc_count: long, 
	shard_size: integer, 
	size: integer
) extends AggregationsBucketAggregationBase

@JsonCodec sealed trait AggregationsSignificantTermsBucketKeys[TKey = None]
type AggregationsSignificantTermsBucket[TKey = None]  = AggregationsSignificantTermsBucketKeys[TKey] | @JsonCodec case class Undefined(
[[MemberIndex: TsMemberIndex(NoComments,false,Default,Dict(TsIdentSimple(property),TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(string))),IArray())),Some(TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(AggregationsAggregate))),IArray())))]]
)


@JsonCodec case class AggregationsSignificantTextAggregation(
	background_filter: QueryDslQueryContainer, 
	chi_square: AggregationsChiSquareHeuristic, 
	exclude: String | Seq[String], 
	execution_hint: AggregationsTermsAggregationExecutionHint, 
	field: Field, 
	filter_duplicate_text: Boolean, 
	gnd: AggregationsGoogleNormalizedDistanceHeuristic, 
	include: String | Seq[String], 
	min_doc_count: long, 
	mutual_information: AggregationsMutualInformationHeuristic, 
	percentage: AggregationsPercentageScoreHeuristic, 
	script_heuristic: AggregationsScriptedHeuristic, 
	shard_min_doc_count: long, 
	shard_size: integer, 
	size: integer, 
	source_fields: Fields
) extends AggregationsBucketAggregationBase

@JsonCodec case class AggregationsSingleBucketAggregateKeys(
	doc_count: double
) extends AggregationsAggregateBase
type AggregationsSingleBucketAggregate = AggregationsSingleBucketAggregateKeys | @JsonCodec case class Undefined(
[[MemberIndex: TsMemberIndex(NoComments,false,Default,Dict(TsIdentSimple(property),TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(string))),IArray())),Some(TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(AggregationsAggregate))),IArray())))]]
)


@JsonCodec case class AggregationsStandardDeviationBounds(
	lower: double, 
	upper: double, 
	lower_population: double, 
	upper_population: double, 
	lower_sampling: double, 
	upper_sampling: double
)

@JsonCodec case class AggregationsStatsAggregate(
	count: double, 
	sum: double, 
	avg: double, 
	max: double, 
	min: double
) extends AggregationsAggregateBase

@JsonCodec case class AggregationsStatsAggregation extends AggregationsFormatMetricAggregationBase

@JsonCodec case class AggregationsStatsBucketAggregation extends AggregationsPipelineAggregationBase

@JsonCodec case class AggregationsStringStatsAggregate(
	count: long, 
	min_length: integer, 
	max_length: integer, 
	avg_length: double, 
	entropy: double, 
	distribution: Record[String, double]
) extends AggregationsAggregateBase

@JsonCodec case class AggregationsStringStatsAggregation(
	show_distribution: Boolean
) extends AggregationsMetricAggregationBase

@JsonCodec case class AggregationsSumAggregation extends AggregationsFormatMetricAggregationBase

@JsonCodec case class AggregationsSumBucketAggregation extends AggregationsPipelineAggregationBase

@JsonCodec case class AggregationsTDigest(
	compression: integer
)

@JsonCodec case class AggregationsTDigestPercentilesAggregate(
	values: Record[String, double]
) extends AggregationsAggregateBase

@JsonCodec case class AggregationsTTestAggregation(
	a: AggregationsTestPopulation, 
	b: AggregationsTestPopulation, 
	`type`: AggregationsTTestType
) extends AggregationsAggregation
type AggregationsTTestType = "paired"" | "homoscedastic"" | "heteroscedastic""

@JsonCodec case class AggregationsTermsAggregate[TKey = None](
	doc_count_error_upper_bound: long, 
	sum_other_doc_count: long
) extends AggregationsMultiBucketAggregate[TKey]

@JsonCodec case class AggregationsTermsAggregation(
	collect_mode: AggregationsTermsAggregationCollectMode, 
	exclude: String | Seq[String], 
	execution_hint: AggregationsTermsAggregationExecutionHint, 
	field: Field, 
	include: String | Seq[String] | AggregationsTermsInclude, 
	min_doc_count: integer, 
	missing: AggregationsMissing, 
	missing_bucket: Boolean, 
	value_type: String, 
	order: AggregationsTermsAggregationOrder, 
	script: Script, 
	shard_size: integer, 
	show_term_doc_count_error: Boolean, 
	size: integer
) extends AggregationsBucketAggregationBase
type AggregationsTermsAggregationCollectMode = "depth_first"" | "breadth_first""
type AggregationsTermsAggregationExecutionHint = "map"" | "global_ordinals"" | "global_ordinals_hash"" | "global_ordinals_low_cardinality""
type AggregationsTermsAggregationOrder = SearchSortOrder | Record[String, SearchSortOrder] | Seq[Record[String, SearchSortOrder]]

@JsonCodec case class AggregationsTermsInclude(
	num_partitions: long, 
	partition: long
)

@JsonCodec case class AggregationsTestPopulation(
	field: Field, 
	script: Script, 
	filter: QueryDslQueryContainer
)

@JsonCodec case class AggregationsTopHitsAggregate(
	hits: SearchHitsMetadata[Record[String, Any]]
) extends AggregationsAggregateBase

@JsonCodec case class AggregationsTopHitsAggregation(
	docvalue_fields: Fields, 
	explain: Boolean, 
	from: integer, 
	highlight: SearchHighlight, 
	script_fields: Record[String, ScriptField], 
	size: integer, 
	sort: SearchSort, 
	_source: Boolean | SearchSourceFilter | Fields, 
	stored_fields: Fields, 
	track_scores: Boolean, 
	version: Boolean, 
	seq_no_primary_term: Boolean
) extends AggregationsMetricAggregationBase

@JsonCodec case class AggregationsTopMetrics(
	sort: Seq[long | double | String], 
	metrics: Record[String, long | double | String]
)

@JsonCodec case class AggregationsTopMetricsAggregate(
	top: Seq[AggregationsTopMetrics]
) extends AggregationsAggregateBase

@JsonCodec case class AggregationsTopMetricsAggregation(
	metrics: AggregationsTopMetricsValue | Seq[AggregationsTopMetricsValue], 
	size: integer, 
	sort: SearchSort
) extends AggregationsMetricAggregationBase

@JsonCodec case class AggregationsTopMetricsValue(
	field: Field
)

@JsonCodec case class AggregationsValueAggregate(
	value: double, 
	value_as_string: String
) extends AggregationsAggregateBase

@JsonCodec case class AggregationsValueCountAggregation extends AggregationsFormattableMetricAggregation
type AggregationsValueType = "string"" | "long"" | "double"" | "number"" | "date"" | "date_nanos"" | "ip"" | "numeric"" | "geo_point"" | "boolean""

@JsonCodec case class AggregationsVariableWidthHistogramAggregation(
	field: Field, 
	buckets: integer, 
	shard_size: integer, 
	initial_buffer: integer
)

@JsonCodec case class AggregationsWeightedAverageAggregation(
	format: String, 
	value: AggregationsWeightedAverageValue, 
	value_type: AggregationsValueType, 
	weight: AggregationsWeightedAverageValue
) extends AggregationsAggregation

@JsonCodec case class AggregationsWeightedAverageValue(
	field: Field, 
	missing: double, 
	script: Script
)

@JsonCodec case class AnalysisAsciiFoldingTokenFilter(
	preserve_original: Boolean
) extends AnalysisTokenFilterBase
type AnalysisCharFilter = AnalysisHtmlStripCharFilter | AnalysisMappingCharFilter | AnalysisPatternReplaceTokenFilter

@JsonCodec case class AnalysisCharFilterBase(
	`type`: String, 
	version: VersionString
)

@JsonCodec case class AnalysisCharGroupTokenizer(
	tokenize_on_chars: Seq[String]
) extends AnalysisTokenizerBase

@JsonCodec case class AnalysisCommonGramsTokenFilter(
	common_words: Seq[String], 
	common_words_path: String, 
	ignore_case: Boolean, 
	query_mode: Boolean
) extends AnalysisTokenFilterBase

@JsonCodec case class AnalysisCompoundWordTokenFilterBase(
	hyphenation_patterns_path: String, 
	max_subword_size: integer, 
	min_subword_size: integer, 
	min_word_size: integer, 
	only_longest_match: Boolean, 
	word_list: Seq[String], 
	word_list_path: String
) extends AnalysisTokenFilterBase

@JsonCodec case class AnalysisConditionTokenFilter(
	filter: Seq[String], 
	script: Script
) extends AnalysisTokenFilterBase
type AnalysisDelimitedPayloadEncoding = "int"" | "float"" | "identity""

@JsonCodec case class AnalysisDelimitedPayloadTokenFilter(
	delimiter: String, 
	encoding: AnalysisDelimitedPayloadEncoding
) extends AnalysisTokenFilterBase
type AnalysisEdgeNGramSide = "front"" | "back""

@JsonCodec case class AnalysisEdgeNGramTokenFilter(
	max_gram: integer, 
	min_gram: integer, 
	side: AnalysisEdgeNGramSide
) extends AnalysisTokenFilterBase

@JsonCodec case class AnalysisEdgeNGramTokenizer(
	custom_token_chars: String, 
	max_gram: integer, 
	min_gram: integer, 
	token_chars: Seq[AnalysisTokenChar]
) extends AnalysisTokenizerBase

@JsonCodec case class AnalysisElisionTokenFilter(
	articles: Seq[String], 
	articles_case: Boolean
) extends AnalysisTokenFilterBase

@JsonCodec case class AnalysisFingerprintTokenFilter(
	max_output_size: integer, 
	separator: String
) extends AnalysisTokenFilterBase

@JsonCodec case class AnalysisHtmlStripCharFilter extends AnalysisCharFilterBase

@JsonCodec case class AnalysisHunspellTokenFilter(
	dedup: Boolean, 
	dictionary: String, 
	locale: String, 
	longest_only: Boolean
) extends AnalysisTokenFilterBase

@JsonCodec case class AnalysisHyphenationDecompounderTokenFilter extends AnalysisCompoundWordTokenFilterBase

@JsonCodec case class AnalysisKStemTokenFilter extends AnalysisTokenFilterBase
type AnalysisKeepTypesMode = "include"" | "exclude""

@JsonCodec case class AnalysisKeepTypesTokenFilter(
	mode: AnalysisKeepTypesMode, 
	types: Seq[String]
) extends AnalysisTokenFilterBase

@JsonCodec case class AnalysisKeepWordsTokenFilter(
	keep_words: Seq[String], 
	keep_words_case: Boolean, 
	keep_words_path: String
) extends AnalysisTokenFilterBase

@JsonCodec case class AnalysisKeywordMarkerTokenFilter(
	ignore_case: Boolean, 
	keywords: Seq[String], 
	keywords_path: String, 
	keywords_pattern: String
) extends AnalysisTokenFilterBase

@JsonCodec case class AnalysisKeywordTokenizer(
	buffer_size: integer
) extends AnalysisTokenizerBase

@JsonCodec case class AnalysisLengthTokenFilter(
	max: integer, 
	min: integer
) extends AnalysisTokenFilterBase

@JsonCodec case class AnalysisLetterTokenizer extends AnalysisTokenizerBase

@JsonCodec case class AnalysisLimitTokenCountTokenFilter(
	consume_all_tokens: Boolean, 
	max_token_count: integer
) extends AnalysisTokenFilterBase

@JsonCodec case class AnalysisLowercaseTokenFilter(
	language: String
) extends AnalysisTokenFilterBase

@JsonCodec case class AnalysisLowercaseTokenizer extends AnalysisTokenizerBase

@JsonCodec case class AnalysisMappingCharFilter(
	mappings: Seq[String], 
	mappings_path: String
) extends AnalysisCharFilterBase

@JsonCodec case class AnalysisMultiplexerTokenFilter(
	filters: Seq[String], 
	preserve_original: Boolean
) extends AnalysisTokenFilterBase

@JsonCodec case class AnalysisNGramTokenFilter(
	max_gram: integer, 
	min_gram: integer
) extends AnalysisTokenFilterBase

@JsonCodec case class AnalysisNGramTokenizer(
	custom_token_chars: String, 
	max_gram: integer, 
	min_gram: integer, 
	token_chars: Seq[AnalysisTokenChar]
) extends AnalysisTokenizerBase
type AnalysisNoriDecompoundMode = "discard"" | "none"" | "mixed""

@JsonCodec case class AnalysisNoriPartOfSpeechTokenFilter(
	stoptags: Seq[String]
) extends AnalysisTokenFilterBase

@JsonCodec case class AnalysisNoriTokenizer(
	decompound_mode: AnalysisNoriDecompoundMode, 
	discard_punctuation: Boolean, 
	user_dictionary: String, 
	user_dictionary_rules: Seq[String]
) extends AnalysisTokenizerBase

@JsonCodec case class AnalysisPathHierarchyTokenizer(
	buffer_size: integer, 
	delimiter: String, 
	replacement: String, 
	reverse: Boolean, 
	skip: integer
) extends AnalysisTokenizerBase

@JsonCodec case class AnalysisPatternCaptureTokenFilter(
	patterns: Seq[String], 
	preserve_original: Boolean
) extends AnalysisTokenFilterBase

@JsonCodec case class AnalysisPatternReplaceTokenFilter(
	flags: String, 
	pattern: String, 
	replacement: String
) extends AnalysisTokenFilterBase

@JsonCodec case class AnalysisPorterStemTokenFilter extends AnalysisTokenFilterBase

@JsonCodec case class AnalysisPredicateTokenFilter(
	script: Script
) extends AnalysisTokenFilterBase

@JsonCodec case class AnalysisRemoveDuplicatesTokenFilter extends AnalysisTokenFilterBase

@JsonCodec case class AnalysisReverseTokenFilter extends AnalysisTokenFilterBase

@JsonCodec case class AnalysisShingleTokenFilter(
	filler_token: String, 
	max_shingle_size: integer, 
	min_shingle_size: integer, 
	output_unigrams: Boolean, 
	output_unigrams_if_no_shingles: Boolean, 
	token_separator: String
) extends AnalysisTokenFilterBase
type AnalysisSnowballLanguage = "Armenian"" | "Basque"" | "Catalan"" | "Danish"" | "Dutch"" | "English"" | "Finnish"" | "French"" | "German"" | "German2"" | "Hungarian"" | "Italian"" | "Kp"" | "Lovins"" | "Norwegian"" | "Porter"" | "Portuguese"" | "Romanian"" | "Russian"" | "Spanish"" | "Swedish"" | "Turkish""

@JsonCodec case class AnalysisSnowballTokenFilter(
	language: AnalysisSnowballLanguage
) extends AnalysisTokenFilterBase

@JsonCodec case class AnalysisStandardTokenizer(
	max_token_length: integer
) extends AnalysisTokenizerBase

@JsonCodec case class AnalysisStemmerOverrideTokenFilter(
	rules: Seq[String], 
	rules_path: String
) extends AnalysisTokenFilterBase

@JsonCodec case class AnalysisStemmerTokenFilter(
	language: String
) extends AnalysisTokenFilterBase

@JsonCodec case class AnalysisStopTokenFilter(
	ignore_case: Boolean, 
	remove_trailing: Boolean, 
	stopwords: AnalysisStopWords, 
	stopwords_path: String
) extends AnalysisTokenFilterBase
type AnalysisStopWords = String | Seq[String]
type AnalysisSynonymFormat = "solr"" | "wordnet""

@JsonCodec case class AnalysisSynonymGraphTokenFilter(
	expand: Boolean, 
	format: AnalysisSynonymFormat, 
	lenient: Boolean, 
	synonyms: Seq[String], 
	synonyms_path: String, 
	tokenizer: String, 
	updateable: Boolean
) extends AnalysisTokenFilterBase

@JsonCodec case class AnalysisSynonymTokenFilter(
	expand: Boolean, 
	format: AnalysisSynonymFormat, 
	lenient: Boolean, 
	synonyms: Seq[String], 
	synonyms_path: String, 
	tokenizer: String, 
	updateable: Boolean
) extends AnalysisTokenFilterBase
type AnalysisTokenChar = "letter"" | "digit"" | "whitespace"" | "punctuation"" | "symbol"" | "custom""
type AnalysisTokenFilter = AnalysisAsciiFoldingTokenFilter | AnalysisCommonGramsTokenFilter | AnalysisConditionTokenFilter | AnalysisDelimitedPayloadTokenFilter | AnalysisEdgeNGramTokenFilter | AnalysisElisionTokenFilter | AnalysisFingerprintTokenFilter | AnalysisHunspellTokenFilter | AnalysisHyphenationDecompounderTokenFilter | AnalysisKeepTypesTokenFilter | AnalysisKeepWordsTokenFilter | AnalysisKeywordMarkerTokenFilter | AnalysisKStemTokenFilter | AnalysisLengthTokenFilter | AnalysisLimitTokenCountTokenFilter | AnalysisLowercaseTokenFilter | AnalysisMultiplexerTokenFilter | AnalysisNGramTokenFilter | AnalysisNoriPartOfSpeechTokenFilter | AnalysisPatternCaptureTokenFilter | AnalysisPatternReplaceTokenFilter | AnalysisPorterStemTokenFilter | AnalysisPredicateTokenFilter | AnalysisRemoveDuplicatesTokenFilter | AnalysisReverseTokenFilter | AnalysisShingleTokenFilter | AnalysisSnowballTokenFilter | AnalysisStemmerOverrideTokenFilter | AnalysisStemmerTokenFilter | AnalysisStopTokenFilter | AnalysisSynonymGraphTokenFilter | AnalysisSynonymTokenFilter | AnalysisTrimTokenFilter | AnalysisTruncateTokenFilter | AnalysisUniqueTokenFilter | AnalysisUppercaseTokenFilter | AnalysisWordDelimiterGraphTokenFilter | AnalysisWordDelimiterTokenFilter

@JsonCodec case class AnalysisTokenFilterBase(
	`type`: String, 
	version: VersionString
)
type AnalysisTokenizer = AnalysisCharGroupTokenizer | AnalysisEdgeNGramTokenizer | AnalysisKeywordTokenizer | AnalysisLetterTokenizer | AnalysisLowercaseTokenizer | AnalysisNGramTokenizer | AnalysisNoriTokenizer | AnalysisPathHierarchyTokenizer | AnalysisStandardTokenizer | AnalysisUaxEmailUrlTokenizer | AnalysisWhitespaceTokenizer

@JsonCodec case class AnalysisTokenizerBase(
	`type`: String, 
	version: VersionString
)

@JsonCodec case class AnalysisTrimTokenFilter extends AnalysisTokenFilterBase

@JsonCodec case class AnalysisTruncateTokenFilter(
	length: integer
) extends AnalysisTokenFilterBase

@JsonCodec case class AnalysisUaxEmailUrlTokenizer(
	max_token_length: integer
) extends AnalysisTokenizerBase

@JsonCodec case class AnalysisUniqueTokenFilter(
	only_on_same_position: Boolean
) extends AnalysisTokenFilterBase

@JsonCodec case class AnalysisUppercaseTokenFilter extends AnalysisTokenFilterBase

@JsonCodec case class AnalysisWhitespaceTokenizer(
	max_token_length: integer
) extends AnalysisTokenizerBase

@JsonCodec case class AnalysisWordDelimiterGraphTokenFilter(
	adjust_offsets: Boolean, 
	catenate_all: Boolean, 
	catenate_numbers: Boolean, 
	catenate_words: Boolean, 
	generate_number_parts: Boolean, 
	generate_word_parts: Boolean, 
	preserve_original: Boolean, 
	protected_words: Seq[String], 
	protected_words_path: String, 
	split_on_case_change: Boolean, 
	split_on_numerics: Boolean, 
	stem_english_possessive: Boolean, 
	type_table: Seq[String], 
	type_table_path: String
) extends AnalysisTokenFilterBase

@JsonCodec case class AnalysisWordDelimiterTokenFilter(
	catenate_all: Boolean, 
	catenate_numbers: Boolean, 
	catenate_words: Boolean, 
	generate_number_parts: Boolean, 
	generate_word_parts: Boolean, 
	preserve_original: Boolean, 
	protected_words: Seq[String], 
	protected_words_path: String, 
	split_on_case_change: Boolean, 
	split_on_numerics: Boolean, 
	stem_english_possessive: Boolean, 
	type_table: Seq[String], 
	type_table_path: String
) extends AnalysisTokenFilterBase

@JsonCodec case class MappingAllField(
	analyzer: String, 
	enabled: Boolean, 
	omit_norms: Boolean, 
	search_analyzer: String, 
	similarity: String, 
	store: Boolean, 
	store_term_vector_offsets: Boolean, 
	store_term_vector_payloads: Boolean, 
	store_term_vector_positions: Boolean, 
	store_term_vectors: Boolean
)

@JsonCodec case class MappingBinaryProperty(
	`type`: "binary""
) extends MappingDocValuesPropertyBase

@JsonCodec case class MappingBooleanProperty(
	boost: double, 
	fielddata: IndicesNumericFielddata, 
	index: Boolean, 
	null_value: Boolean, 
	`type`: "boolean""
) extends MappingDocValuesPropertyBase

@JsonCodec case class MappingCompletionProperty(
	analyzer: String, 
	contexts: Seq[MappingSuggestContext], 
	max_input_length: integer, 
	preserve_position_increments: Boolean, 
	preserve_separators: Boolean, 
	search_analyzer: String, 
	`type`: "completion""
) extends MappingDocValuesPropertyBase

@JsonCodec case class MappingConstantKeywordProperty(
	value: Any, 
	`type`: "constant_keyword""
) extends MappingPropertyBase
type MappingCoreProperty = MappingObjectProperty | MappingNestedProperty | MappingSearchAsYouTypeProperty | MappingTextProperty | MappingDocValuesProperty

@JsonCodec case class MappingCorePropertyBase(
	copy_to: Fields, 
	similarity: String, 
	store: Boolean
) extends MappingPropertyBase

@JsonCodec case class MappingDateNanosProperty(
	boost: double, 
	format: String, 
	ignore_malformed: Boolean, 
	index: Boolean, 
	null_value: DateString, 
	precision_step: integer, 
	`type`: "date_nanos""
) extends MappingDocValuesPropertyBase

@JsonCodec case class MappingDateProperty(
	boost: double, 
	fielddata: IndicesNumericFielddata, 
	format: String, 
	ignore_malformed: Boolean, 
	index: Boolean, 
	null_value: DateString, 
	precision_step: integer, 
	`type`: "date""
) extends MappingDocValuesPropertyBase

@JsonCodec case class MappingDateRangeProperty(
	format: String, 
	`type`: "date_range""
) extends MappingRangePropertyBase
type MappingDocValuesProperty = MappingBinaryProperty | MappingBooleanProperty | MappingDateProperty | MappingDateNanosProperty | MappingKeywordProperty | MappingNumberProperty | MappingRangeProperty | MappingGeoPointProperty | MappingGeoShapeProperty | MappingCompletionProperty | MappingGenericProperty | MappingIpProperty | MappingMurmur3HashProperty | MappingShapeProperty | MappingTokenCountProperty | MappingVersionProperty | MappingWildcardProperty | MappingPointProperty

@JsonCodec case class MappingDocValuesPropertyBase(
	doc_values: Boolean
) extends MappingCorePropertyBase

@JsonCodec case class MappingDoubleRangeProperty(
	`type`: "double_range""
) extends MappingRangePropertyBase
type MappingDynamicMapping = "strict"" | "runtime"" | "true"" | "false""

@JsonCodec case class MappingDynamicTemplate(
	mapping: MappingPropertyBase, 
	`match`: String, 
	match_mapping_type: String, 
	match_pattern: MappingMatchType, 
	path_match: String, 
	path_unmatch: String, 
	unmatch: String
)

@JsonCodec case class MappingFieldAliasProperty(
	path: Field, 
	`type`: "alias""
) extends MappingPropertyBase

@JsonCodec sealed trait MappingFieldMapping

@JsonCodec case class MappingFieldNamesField(
	enabled: Boolean
)
type MappingFieldType = "none"" | "geo_point"" | "geo_shape"" | "ip"" | "binary"" | "keyword"" | "text"" | "search_as_you_type"" | "date"" | "date_nanos"" | "boolean"" | "completion"" | "nested"" | "object"" | "murmur3"" | "token_count"" | "percolator"" | "integer"" | "long"" | "short"" | "byte"" | "float"" | "half_float"" | "scaled_float"" | "double"" | "integer_range"" | "float_range"" | "long_range"" | "double_range"" | "date_range"" | "ip_range"" | "alias"" | "join"" | "rank_feature"" | "rank_features"" | "flattened"" | "shape"" | "histogram"" | "constant_keyword""

@JsonCodec case class MappingFlattenedProperty(
	boost: double, 
	depth_limit: integer, 
	doc_values: Boolean, 
	eager_global_ordinals: Boolean, 
	index: Boolean, 
	index_options: MappingIndexOptions, 
	null_value: String, 
	similarity: String, 
	split_queries_on_whitespace: Boolean, 
	`type`: "flattened""
) extends MappingPropertyBase

@JsonCodec case class MappingFloatRangeProperty(
	`type`: "float_range""
) extends MappingRangePropertyBase

@JsonCodec case class MappingGenericProperty(
	analyzer: String, 
	boost: double, 
	fielddata: IndicesStringFielddata, 
	ignore_malformed: Boolean, 
	index: Boolean, 
	index_options: MappingIndexOptions, 
	norms: Boolean, 
	null_value: String, 
	position_increment_gap: integer, 
	search_analyzer: String, 
	term_vector: MappingTermVectorOption, 
	`type`: String
) extends MappingDocValuesPropertyBase
type MappingGeoOrientation = "right"" | "RIGHT"" | "counterclockwise"" | "COUNTERCLOCKWISE"" | "ccw"" | "CCW"" | "left"" | "LEFT"" | "clockwise"" | "CLOCKWISE"" | "cw"" | "CW""

@JsonCodec case class MappingGeoPointProperty(
	ignore_malformed: Boolean, 
	ignore_z_value: Boolean, 
	null_value: QueryDslGeoLocation, 
	`type`: "geo_point""
) extends MappingDocValuesPropertyBase

@JsonCodec case class MappingGeoShapeProperty(
	coerce: Boolean, 
	ignore_malformed: Boolean, 
	ignore_z_value: Boolean, 
	orientation: MappingGeoOrientation, 
	strategy: MappingGeoStrategy, 
	`type`: "geo_shape""
) extends MappingDocValuesPropertyBase
type MappingGeoStrategy = "recursive"" | "term""

@JsonCodec case class MappingHistogramProperty(
	ignore_malformed: Boolean, 
	`type`: "histogram""
) extends MappingPropertyBase

@JsonCodec case class MappingIndexField(
	enabled: Boolean
)
type MappingIndexOptions = "docs"" | "freqs"" | "positions"" | "offsets""

@JsonCodec case class MappingIntegerRangeProperty(
	`type`: "integer_range""
) extends MappingRangePropertyBase

@JsonCodec case class MappingIpProperty(
	boost: double, 
	index: Boolean, 
	null_value: String, 
	`type`: "ip""
) extends MappingDocValuesPropertyBase

@JsonCodec case class MappingIpRangeProperty(
	`type`: "ip_range""
) extends MappingRangePropertyBase

@JsonCodec case class MappingJoinProperty(
	relations: Record[RelationName, RelationName | Seq[RelationName]], 
	`type`: "join""
) extends MappingPropertyBase

@JsonCodec case class MappingKeywordProperty(
	boost: double, 
	eager_global_ordinals: Boolean, 
	index: Boolean, 
	index_options: MappingIndexOptions, 
	normalizer: String, 
	norms: Boolean, 
	null_value: String, 
	split_queries_on_whitespace: Boolean, 
	`type`: "keyword""
) extends MappingDocValuesPropertyBase

@JsonCodec case class MappingLongRangeProperty(
	`type`: "long_range""
) extends MappingRangePropertyBase
type MappingMatchType = "simple"" | "regex""

@JsonCodec case class MappingMurmur3HashProperty(
	`type`: "murmur3""
) extends MappingDocValuesPropertyBase

@JsonCodec case class MappingNestedProperty(
	enabled: Boolean, 
	include_in_parent: Boolean, 
	include_in_root: Boolean, 
	`type`: "nested""
) extends MappingCorePropertyBase

@JsonCodec case class MappingNumberProperty(
	boost: double, 
	coerce: Boolean, 
	fielddata: IndicesNumericFielddata, 
	ignore_malformed: Boolean, 
	index: Boolean, 
	null_value: double, 
	scaling_factor: double, 
	`type`: MappingNumberType
) extends MappingDocValuesPropertyBase
type MappingNumberType = "float"" | "half_float"" | "scaled_float"" | "double"" | "integer"" | "long"" | "short"" | "byte"" | "unsigned_long""

@JsonCodec case class MappingObjectProperty(
	enabled: Boolean, 
	`type`: "object""
) extends MappingCorePropertyBase

@JsonCodec case class MappingPercolatorProperty(
	`type`: "percolator""
) extends MappingPropertyBase

@JsonCodec case class MappingPointProperty(
	ignore_malformed: Boolean, 
	ignore_z_value: Boolean, 
	null_value: String, 
	`type`: "point""
) extends MappingDocValuesPropertyBase
type MappingProperty = MappingFlattenedProperty | MappingJoinProperty | MappingPercolatorProperty | MappingRankFeatureProperty | MappingRankFeaturesProperty | MappingConstantKeywordProperty | MappingFieldAliasProperty | MappingHistogramProperty | MappingCoreProperty

@JsonCodec case class MappingPropertyBase(
	local_metadata: Metadata, 
	meta: Record[String, String], 
	name: PropertyName, 
	properties: Record[PropertyName, MappingProperty], 
	ignore_above: integer, 
	dynamic: Boolean | MappingDynamicMapping, 
	fields: Record[PropertyName, MappingProperty]
)
type MappingRangeProperty = MappingLongRangeProperty | MappingIpRangeProperty | MappingIntegerRangeProperty | MappingFloatRangeProperty | MappingDoubleRangeProperty | MappingDateRangeProperty

@JsonCodec case class MappingRangePropertyBase(
	boost: double, 
	coerce: Boolean, 
	index: Boolean
) extends MappingDocValuesPropertyBase

@JsonCodec case class MappingRankFeatureProperty(
	positive_score_impact: Boolean, 
	`type`: "rank_feature""
) extends MappingPropertyBase

@JsonCodec case class MappingRankFeaturesProperty(
	`type`: "rank_features""
) extends MappingPropertyBase

@JsonCodec case class MappingRoutingField(
	required: Boolean
)

@JsonCodec case class MappingRuntimeField(
	format: String, 
	script: Script, 
	`type`: MappingRuntimeFieldType
)
type MappingRuntimeFieldType = "boolean"" | "date"" | "double"" | "geo_point"" | "ip"" | "keyword"" | "long""
type MappingRuntimeFields = Record[Field, MappingRuntimeField]

@JsonCodec case class MappingSearchAsYouTypeProperty(
	analyzer: String, 
	index: Boolean, 
	index_options: MappingIndexOptions, 
	max_shingle_size: integer, 
	norms: Boolean, 
	search_analyzer: String, 
	search_quote_analyzer: String, 
	term_vector: MappingTermVectorOption, 
	`type`: "search_as_you_type""
) extends MappingCorePropertyBase
type MappingShapeOrientation = "right"" | "counterclockwise"" | "ccw"" | "left"" | "clockwise"" | "cw""

@JsonCodec case class MappingShapeProperty(
	coerce: Boolean, 
	ignore_malformed: Boolean, 
	ignore_z_value: Boolean, 
	orientation: MappingShapeOrientation, 
	`type`: "shape""
) extends MappingDocValuesPropertyBase

@JsonCodec case class MappingSizeField(
	enabled: Boolean
)

@JsonCodec case class MappingSourceField(
	compress: Boolean, 
	compress_threshold: String, 
	enabled: Boolean, 
	excludes: Seq[String], 
	includes: Seq[String]
)

@JsonCodec case class MappingSuggestContext(
	name: Name, 
	path: Field, 
	`type`: String, 
	precision: integer
)
type MappingTermVectorOption = "no"" | "yes"" | "with_offsets"" | "with_positions"" | "with_positions_offsets"" | "with_positions_offsets_payloads""

@JsonCodec case class MappingTextIndexPrefixes(
	max_chars: integer, 
	min_chars: integer
)

@JsonCodec case class MappingTextProperty(
	analyzer: String, 
	boost: double, 
	eager_global_ordinals: Boolean, 
	fielddata: Boolean, 
	fielddata_frequency_filter: IndicesFielddataFrequencyFilter, 
	index: Boolean, 
	index_options: MappingIndexOptions, 
	index_phrases: Boolean, 
	index_prefixes: MappingTextIndexPrefixes, 
	norms: Boolean, 
	position_increment_gap: integer, 
	search_analyzer: String, 
	search_quote_analyzer: String, 
	term_vector: MappingTermVectorOption, 
	`type`: "text""
) extends MappingCorePropertyBase

@JsonCodec case class MappingTokenCountProperty(
	analyzer: String, 
	boost: double, 
	index: Boolean, 
	null_value: double, 
	enable_position_increments: Boolean, 
	`type`: "token_count""
) extends MappingDocValuesPropertyBase

@JsonCodec case class MappingTypeMapping(
	all_field: MappingAllField, 
	date_detection: Boolean, 
	dynamic: Boolean | MappingDynamicMapping, 
	dynamic_date_formats: Seq[String], 
	dynamic_templates: Record[String, MappingDynamicTemplate] | Seq[Record[String, MappingDynamicTemplate]], 
	_field_names: MappingFieldNamesField, 
	index_field: MappingIndexField, 
	_meta: Metadata, 
	numeric_detection: Boolean, 
	properties: Record[PropertyName, MappingProperty], 
	_routing: MappingRoutingField, 
	_size: MappingSizeField, 
	_source: MappingSourceField, 
	runtime: Record[String, MappingRuntimeField]
)

@JsonCodec case class MappingVersionProperty(
	`type`: "version""
) extends MappingDocValuesPropertyBase

@JsonCodec case class MappingWildcardProperty(
	`type`: "wildcard""
) extends MappingDocValuesPropertyBase

@JsonCodec case class QueryDslBoolQuery(
	filter: QueryDslQueryContainer | Seq[QueryDslQueryContainer], 
	minimum_should_match: MinimumShouldMatch, 
	must: QueryDslQueryContainer | Seq[QueryDslQueryContainer], 
	must_not: QueryDslQueryContainer | Seq[QueryDslQueryContainer], 
	should: QueryDslQueryContainer | Seq[QueryDslQueryContainer]
) extends QueryDslQueryBase

@JsonCodec case class QueryDslBoostingQuery(
	negative_boost: double, 
	negative: QueryDslQueryContainer, 
	positive: QueryDslQueryContainer
) extends QueryDslQueryBase

@JsonCodec case class QueryDslBoundingBox(
	bottom_right: QueryDslGeoLocation, 
	top_left: QueryDslGeoLocation, 
	wkt: String
)
type QueryDslChildScoreMode = "none"" | "avg"" | "sum"" | "max"" | "min""

@JsonCodec case class QueryDslCombinedFieldsQuery(
	query: String, 
	fields: Seq[Field], 
	operator: String
)

@JsonCodec case class QueryDslCommonTermsQuery(
	analyzer: String, 
	cutoff_frequency: double, 
	high_freq_operator: QueryDslOperator, 
	low_freq_operator: QueryDslOperator, 
	minimum_should_match: MinimumShouldMatch, 
	query: String
) extends QueryDslQueryBase

@JsonCodec case class QueryDslConstantScoreQuery(
	filter: QueryDslQueryContainer
) extends QueryDslQueryBase

@JsonCodec case class QueryDslDateDecayFunctionKeys extends QueryDslDecayFunctionBase
type QueryDslDateDecayFunction = QueryDslDateDecayFunctionKeys | @JsonCodec case class Undefined(
[[MemberIndex: TsMemberIndex(NoComments,false,Default,Dict(TsIdentSimple(property),TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(string))),IArray())),Some(TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(QueryDslDecayPlacement))),IArray(TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(DateMath))),IArray()), TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(Time))),IArray())))))]]
)

type QueryDslDecayFunction = QueryDslDateDecayFunction | QueryDslNumericDecayFunction | QueryDslGeoDecayFunction

@JsonCodec case class QueryDslDecayFunctionBase(
	multi_value_mode: QueryDslMultiValueMode
) extends QueryDslScoreFunctionBase

@JsonCodec case class QueryDslDecayPlacement[TOrigin = None, TScale = None](
	decay: double, 
	offset: TScale, 
	scale: TScale, 
	origin: TOrigin
)

@JsonCodec case class QueryDslDisMaxQuery(
	queries: Seq[QueryDslQueryContainer], 
	tie_breaker: double
) extends QueryDslQueryBase

@JsonCodec case class QueryDslDistanceFeatureQuery(
	origin: Seq[Double] | QueryDslGeoCoordinate | DateMath, 
	pivot: Distance | Time, 
	field: Field
) extends QueryDslQueryBase

@JsonCodec case class QueryDslExistsQuery(
	field: Field
) extends QueryDslQueryBase

@JsonCodec case class QueryDslFieldLookup(
	id: Id, 
	index: IndexName, 
	path: Field, 
	routing: Routing
)
type QueryDslFieldValueFactorModifier = "none"" | "log"" | "log1p"" | "log2p"" | "ln"" | "ln1p"" | "ln2p"" | "square"" | "sqrt"" | "reciprocal""

@JsonCodec case class QueryDslFieldValueFactorScoreFunction(
	field: Field, 
	factor: double, 
	missing: double, 
	modifier: QueryDslFieldValueFactorModifier
) extends QueryDslScoreFunctionBase
type QueryDslFunctionBoostMode = "multiply"" | "replace"" | "sum"" | "avg"" | "max"" | "min""

@JsonCodec case class QueryDslFunctionScoreContainer(
	exp: QueryDslDecayFunction, 
	gauss: QueryDslDecayFunction, 
	linear: QueryDslDecayFunction, 
	field_value_factor: QueryDslFieldValueFactorScoreFunction, 
	random_score: QueryDslRandomScoreFunction, 
	script_score: QueryDslScriptScoreFunction, 
	filter: QueryDslQueryContainer, 
	weight: double
)
type QueryDslFunctionScoreMode = "multiply"" | "sum"" | "avg"" | "first"" | "max"" | "min""

@JsonCodec case class QueryDslFunctionScoreQuery(
	boost_mode: QueryDslFunctionBoostMode, 
	functions: Seq[QueryDslFunctionScoreContainer], 
	max_boost: double, 
	min_score: double, 
	query: QueryDslQueryContainer, 
	score_mode: QueryDslFunctionScoreMode
) extends QueryDslQueryBase

@JsonCodec case class QueryDslFuzzyQuery(
	max_expansions: integer, 
	prefix_length: integer, 
	rewrite: MultiTermQueryRewrite, 
	transpositions: Boolean, 
	fuzziness: Fuzziness, 
	value: Any
) extends QueryDslQueryBase

@JsonCodec case class QueryDslGeoBoundingBoxQuery(
	bounding_box: QueryDslBoundingBox, 
	`type`: QueryDslGeoExecution, 
	validation_method: QueryDslGeoValidationMethod, 
	top_left: LatLon, 
	bottom_right: LatLon
) extends QueryDslQueryBase
type QueryDslGeoCoordinate = String | Seq[double] | QueryDslThreeDimensionalPoint

@JsonCodec case class QueryDslGeoDecayFunctionKeys extends QueryDslDecayFunctionBase
type QueryDslGeoDecayFunction = QueryDslGeoDecayFunctionKeys | @JsonCodec case class Undefined(
[[MemberIndex: TsMemberIndex(NoComments,false,Default,Dict(TsIdentSimple(property),TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(string))),IArray())),Some(TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(QueryDslDecayPlacement))),IArray(TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(QueryDslGeoLocation))),IArray()), TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(Distance))),IArray())))))]]
)


@JsonCodec case class QueryDslGeoDistanceQueryKeys(
	distance: Distance, 
	distance_type: GeoDistanceType, 
	validation_method: QueryDslGeoValidationMethod
) extends QueryDslQueryBase
type QueryDslGeoDistanceQuery = QueryDslGeoDistanceQueryKeys | @JsonCodec case class Undefined(
[[MemberIndex: TsMemberIndex(NoComments,false,Default,Dict(TsIdentSimple(property),TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(string))),IArray())),Some(TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(QueryDslGeoLocation))),IArray())))]]
)

type QueryDslGeoExecution = "memory"" | "indexed""
type QueryDslGeoLocation = String | Seq[double] | QueryDslTwoDimensionalPoint

@JsonCodec case class QueryDslGeoPolygonQuery(
	points: Seq[QueryDslGeoLocation], 
	validation_method: QueryDslGeoValidationMethod
) extends QueryDslQueryBase

@JsonCodec case class QueryDslGeoShape(
	`type`: String
)

@JsonCodec case class QueryDslGeoShapeQuery(
	ignore_unmapped: Boolean, 
	indexed_shape: QueryDslFieldLookup, 
	relation: GeoShapeRelation, 
	shape: QueryDslGeoShape
) extends QueryDslQueryBase
type QueryDslGeoValidationMethod = "coerce"" | "ignore_malformed"" | "strict""

@JsonCodec case class QueryDslHasChildQuery(
	ignore_unmapped: Boolean, 
	inner_hits: SearchInnerHits, 
	max_children: integer, 
	min_children: integer, 
	query: QueryDslQueryContainer, 
	score_mode: QueryDslChildScoreMode, 
	`type`: RelationName
) extends QueryDslQueryBase

@JsonCodec case class QueryDslHasParentQuery(
	ignore_unmapped: Boolean, 
	inner_hits: SearchInnerHits, 
	parent_type: RelationName, 
	query: QueryDslQueryContainer, 
	score: Boolean
) extends QueryDslQueryBase

@JsonCodec case class QueryDslIdsQuery(
	values: Seq[Id] | Seq[long]
) extends QueryDslQueryBase

@JsonCodec case class QueryDslIntervalsAllOf(
	intervals: Seq[QueryDslIntervalsContainer], 
	max_gaps: integer, 
	ordered: Boolean, 
	filter: QueryDslIntervalsFilter
)

@JsonCodec case class QueryDslIntervalsAnyOf(
	intervals: Seq[QueryDslIntervalsContainer], 
	filter: QueryDslIntervalsFilter
)

@JsonCodec case class QueryDslIntervalsContainer(
	all_of: QueryDslIntervalsAllOf, 
	any_of: QueryDslIntervalsAnyOf, 
	fuzzy: QueryDslIntervalsFuzzy, 
	`match`: QueryDslIntervalsMatch, 
	prefix: QueryDslIntervalsPrefix, 
	wildcard: QueryDslIntervalsWildcard
)

@JsonCodec case class QueryDslIntervalsFilter(
	after: QueryDslIntervalsContainer, 
	before: QueryDslIntervalsContainer, 
	contained_by: QueryDslIntervalsContainer, 
	containing: QueryDslIntervalsContainer, 
	not_contained_by: QueryDslIntervalsContainer, 
	not_containing: QueryDslIntervalsContainer, 
	not_overlapping: QueryDslIntervalsContainer, 
	overlapping: QueryDslIntervalsContainer, 
	script: Script
)

@JsonCodec case class QueryDslIntervalsFuzzy(
	analyzer: String, 
	fuzziness: Fuzziness, 
	prefix_length: integer, 
	term: String, 
	transpositions: Boolean, 
	use_field: Field
)

@JsonCodec case class QueryDslIntervalsMatch(
	analyzer: String, 
	max_gaps: integer, 
	ordered: Boolean, 
	query: String, 
	use_field: Field, 
	filter: QueryDslIntervalsFilter
)

@JsonCodec case class QueryDslIntervalsPrefix(
	analyzer: String, 
	prefix: String, 
	use_field: Field
)

@JsonCodec case class QueryDslIntervalsQuery(
	all_of: QueryDslIntervalsAllOf, 
	any_of: QueryDslIntervalsAnyOf, 
	fuzzy: QueryDslIntervalsFuzzy, 
	`match`: QueryDslIntervalsMatch, 
	prefix: QueryDslIntervalsPrefix, 
	wildcard: QueryDslIntervalsWildcard
) extends QueryDslQueryBase

@JsonCodec case class QueryDslIntervalsWildcard(
	analyzer: String, 
	pattern: String, 
	use_field: Field
)
type QueryDslLike = String | QueryDslLikeDocument

@JsonCodec case class QueryDslLikeDocument(
	doc: Any, 
	fields: Fields, 
	_id: Id | Double, 
	_type: Type, 
	_index: IndexName, 
	per_field_analyzer: Record[Field, String], 
	routing: Routing
)

@JsonCodec case class QueryDslMatchAllQuery(
	norm_field: String
) extends QueryDslQueryBase

@JsonCodec case class QueryDslMatchBoolPrefixQuery(
	analyzer: String, 
	fuzziness: Fuzziness, 
	fuzzy_rewrite: MultiTermQueryRewrite, 
	fuzzy_transpositions: Boolean, 
	max_expansions: integer, 
	minimum_should_match: MinimumShouldMatch, 
	operator: QueryDslOperator, 
	prefix_length: integer, 
	query: String
) extends QueryDslQueryBase

@JsonCodec case class QueryDslMatchNoneQuery extends QueryDslQueryBase

@JsonCodec case class QueryDslMatchPhrasePrefixQuery(
	analyzer: String, 
	max_expansions: integer, 
	query: String, 
	slop: integer, 
	zero_terms_query: QueryDslZeroTermsQuery
) extends QueryDslQueryBase

@JsonCodec case class QueryDslMatchPhraseQuery(
	analyzer: String, 
	query: String, 
	slop: integer
) extends QueryDslQueryBase

@JsonCodec case class QueryDslMatchQuery(
	analyzer: String, 
	auto_generate_synonyms_phrase_query: Boolean, 
	cutoff_frequency: double, 
	fuzziness: Fuzziness, 
	fuzzy_rewrite: MultiTermQueryRewrite, 
	fuzzy_transpositions: Boolean, 
	lenient: Boolean, 
	max_expansions: integer, 
	minimum_should_match: MinimumShouldMatch, 
	operator: QueryDslOperator, 
	prefix_length: integer, 
	query: String | float | Boolean, 
	zero_terms_query: QueryDslZeroTermsQuery
) extends QueryDslQueryBase

@JsonCodec case class QueryDslMoreLikeThisQuery(
	analyzer: String, 
	boost_terms: double, 
	fields: Fields, 
	include: Boolean, 
	like: QueryDslLike | Seq[QueryDslLike], 
	max_doc_freq: integer, 
	max_query_terms: integer, 
	max_word_length: integer, 
	min_doc_freq: integer, 
	minimum_should_match: MinimumShouldMatch, 
	min_term_freq: integer, 
	min_word_length: integer, 
	per_field_analyzer: Record[Field, String], 
	routing: Routing, 
	stop_words: AnalysisStopWords, 
	unlike: QueryDslLike | Seq[QueryDslLike], 
	version: VersionNumber, 
	version_type: VersionType
) extends QueryDslQueryBase

@JsonCodec case class QueryDslMultiMatchQuery(
	analyzer: String, 
	auto_generate_synonyms_phrase_query: Boolean, 
	cutoff_frequency: double, 
	fields: Fields, 
	fuzziness: Fuzziness, 
	fuzzy_rewrite: MultiTermQueryRewrite, 
	fuzzy_transpositions: Boolean, 
	lenient: Boolean, 
	max_expansions: integer, 
	minimum_should_match: MinimumShouldMatch, 
	operator: QueryDslOperator, 
	prefix_length: integer, 
	query: String, 
	slop: integer, 
	tie_breaker: double, 
	`type`: QueryDslTextQueryType, 
	use_dis_max: Boolean, 
	zero_terms_query: QueryDslZeroTermsQuery
) extends QueryDslQueryBase
type QueryDslMultiValueMode = "min"" | "max"" | "avg"" | "sum""

@JsonCodec case class QueryDslNamedQueryKeys[TQuery = None](
	boost: float, 
	_name: String, 
	ignore_unmapped: Boolean
)
type QueryDslNamedQuery[TQuery = None]  = QueryDslNamedQueryKeys[TQuery] | @JsonCodec case class Undefined(
[[MemberIndex: TsMemberIndex(NoComments,false,Default,Dict(TsIdentSimple(property),TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(string))),IArray())),Some(TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(TQuery))),IArray())))]]
)


@JsonCodec case class QueryDslNestedQuery(
	ignore_unmapped: Boolean, 
	inner_hits: SearchInnerHits, 
	path: Field, 
	query: QueryDslQueryContainer, 
	score_mode: QueryDslNestedScoreMode
) extends QueryDslQueryBase
type QueryDslNestedScoreMode = "avg"" | "sum"" | "min"" | "max"" | "none""

@JsonCodec case class QueryDslNumericDecayFunctionKeys extends QueryDslDecayFunctionBase
type QueryDslNumericDecayFunction = QueryDslNumericDecayFunctionKeys | @JsonCodec case class Undefined(
[[MemberIndex: TsMemberIndex(NoComments,false,Default,Dict(TsIdentSimple(property),TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(string))),IArray())),Some(TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(QueryDslDecayPlacement))),IArray(TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(double))),IArray()), TsTypeRef(NoComments,TsQIdent(IArray(TsIdentSimple(double))),IArray())))))]]
)

type QueryDslOperator = "and"" | "or"" | "AND"" | "OR""

@JsonCodec case class QueryDslParentIdQuery(
	id: Id, 
	ignore_unmapped: Boolean, 
	`type`: RelationName
) extends QueryDslQueryBase

@JsonCodec case class QueryDslPercolateQuery(
	document: Any, 
	documents: Seq[Any], 
	field: Field, 
	id: Id, 
	index: IndexName, 
	preference: String, 
	routing: Routing, 
	version: VersionNumber
) extends QueryDslQueryBase

@JsonCodec case class QueryDslPinnedQuery(
	ids: Seq[Id] | Seq[long], 
	organic: QueryDslQueryContainer
) extends QueryDslQueryBase

@JsonCodec case class QueryDslPrefixQuery(
	rewrite: MultiTermQueryRewrite, 
	value: String
) extends QueryDslQueryBase

@JsonCodec case class QueryDslQueryBase(
	boost: float, 
	_name: String
)

@JsonCodec case class QueryDslQueryContainer(
	bool: QueryDslBoolQuery, 
	boosting: QueryDslBoostingQuery, 
	common: Record[Field, QueryDslCommonTermsQuery | String], 
	combined_fields: QueryDslCombinedFieldsQuery, 
	constant_score: QueryDslConstantScoreQuery, 
	dis_max: QueryDslDisMaxQuery, 
	distance_feature: Record[Field, QueryDslDistanceFeatureQuery | String] | QueryDslDistanceFeatureQuery, 
	exists: QueryDslExistsQuery, 
	function_score: QueryDslFunctionScoreQuery, 
	fuzzy: Record[Field, QueryDslFuzzyQuery | String], 
	geo_bounding_box: QueryDslNamedQuery[QueryDslGeoBoundingBoxQuery | String], 
	geo_distance: QueryDslGeoDistanceQuery, 
	geo_polygon: QueryDslNamedQuery[QueryDslGeoPolygonQuery | String], 
	geo_shape: QueryDslNamedQuery[QueryDslGeoShapeQuery | String], 
	has_child: QueryDslHasChildQuery, 
	has_parent: QueryDslHasParentQuery, 
	ids: QueryDslIdsQuery, 
	intervals: QueryDslNamedQuery[QueryDslIntervalsQuery | String], 
	`match`: QueryDslNamedQuery[QueryDslMatchQuery | String | float | Boolean], 
	match_all: QueryDslMatchAllQuery, 
	match_bool_prefix: QueryDslNamedQuery[QueryDslMatchBoolPrefixQuery | String], 
	match_none: QueryDslMatchNoneQuery, 
	match_phrase: QueryDslNamedQuery[QueryDslMatchPhraseQuery | String], 
	match_phrase_prefix: QueryDslNamedQuery[QueryDslMatchPhrasePrefixQuery | String], 
	more_like_this: QueryDslMoreLikeThisQuery, 
	multi_match: QueryDslMultiMatchQuery, 
	nested: QueryDslNestedQuery, 
	parent_id: QueryDslParentIdQuery, 
	percolate: QueryDslPercolateQuery, 
	pinned: QueryDslPinnedQuery, 
	prefix: QueryDslNamedQuery[QueryDslPrefixQuery | String], 
	query_string: QueryDslQueryStringQuery, 
	range: QueryDslNamedQuery[QueryDslRangeQuery], 
	rank_feature: QueryDslNamedQuery[QueryDslRankFeatureQuery | String], 
	regexp: QueryDslNamedQuery[QueryDslRegexpQuery | String], 
	script: QueryDslScriptQuery, 
	script_score: QueryDslScriptScoreQuery, 
	shape: QueryDslNamedQuery[QueryDslShapeQuery | String], 
	simple_query_string: QueryDslSimpleQueryStringQuery, 
	span_containing: QueryDslSpanContainingQuery, 
	field_masking_span: QueryDslSpanFieldMaskingQuery, 
	span_first: QueryDslSpanFirstQuery, 
	span_multi: QueryDslSpanMultiTermQuery, 
	span_near: QueryDslSpanNearQuery, 
	span_not: QueryDslSpanNotQuery, 
	span_or: QueryDslSpanOrQuery, 
	span_term: QueryDslNamedQuery[QueryDslSpanTermQuery | String], 
	span_within: QueryDslSpanWithinQuery, 
	template: QueryDslQueryTemplate, 
	term: QueryDslNamedQuery[QueryDslTermQuery | String | float | Boolean], 
	terms: QueryDslNamedQuery[QueryDslTermsQuery | Seq[String] | Seq[long]], 
	terms_set: QueryDslNamedQuery[QueryDslTermsSetQuery | String], 
	wildcard: QueryDslNamedQuery[QueryDslWildcardQuery | String], 
	`type`: QueryDslTypeQuery
)

@JsonCodec case class QueryDslQueryStringQuery(
	allow_leading_wildcard: Boolean, 
	analyzer: String, 
	analyze_wildcard: Boolean, 
	auto_generate_synonyms_phrase_query: Boolean, 
	default_field: Field, 
	default_operator: QueryDslOperator, 
	enable_position_increments: Boolean, 
	escape: Boolean, 
	fields: Fields, 
	fuzziness: Fuzziness, 
	fuzzy_max_expansions: integer, 
	fuzzy_prefix_length: integer, 
	fuzzy_rewrite: MultiTermQueryRewrite, 
	fuzzy_transpositions: Boolean, 
	lenient: Boolean, 
	max_determinized_states: integer, 
	minimum_should_match: MinimumShouldMatch, 
	phrase_slop: double, 
	query: String, 
	quote_analyzer: String, 
	quote_field_suffix: String, 
	rewrite: MultiTermQueryRewrite, 
	tie_breaker: double, 
	time_zone: String, 
	`type`: QueryDslTextQueryType
) extends QueryDslQueryBase

@JsonCodec case class QueryDslQueryTemplate(
	source: String
)

@JsonCodec case class QueryDslRandomScoreFunction(
	field: Field, 
	seed: long | String
) extends QueryDslScoreFunctionBase

@JsonCodec case class QueryDslRangeQuery(
	gt: double | DateMath, 
	gte: double | DateMath, 
	lt: double | DateMath, 
	lte: double | DateMath, 
	relation: QueryDslRangeRelation, 
	time_zone: String, 
	from: double | DateMath, 
	to: double | DateMath
) extends QueryDslQueryBase
type QueryDslRangeRelation = "within"" | "contains"" | "intersects""

@JsonCodec sealed trait QueryDslRankFeatureFunction

@JsonCodec case class QueryDslRankFeatureQuery(
	function: QueryDslRankFeatureFunction
) extends QueryDslQueryBase

@JsonCodec case class QueryDslRegexpQuery(
	flags: String, 
	max_determinized_states: integer, 
	value: String
) extends QueryDslQueryBase

@JsonCodec case class QueryDslScoreFunctionBase(
	filter: QueryDslQueryContainer, 
	weight: double
)

@JsonCodec case class QueryDslScriptQuery(
	script: Script
) extends QueryDslQueryBase

@JsonCodec case class QueryDslScriptScoreFunction(
	script: Script
) extends QueryDslScoreFunctionBase

@JsonCodec case class QueryDslScriptScoreQuery(
	query: QueryDslQueryContainer, 
	script: Script
) extends QueryDslQueryBase

@JsonCodec case class QueryDslShapeQuery(
	ignore_unmapped: Boolean, 
	indexed_shape: QueryDslFieldLookup, 
	relation: ShapeRelation, 
	shape: QueryDslGeoShape
) extends QueryDslQueryBase
type QueryDslSimpleQueryStringFlags = "NONE"" | "AND"" | "OR"" | "NOT"" | "PREFIX"" | "PHRASE"" | "PRECEDENCE"" | "ESCAPE"" | "WHITESPACE"" | "FUZZY"" | "NEAR"" | "SLOP"" | "ALL""

@JsonCodec case class QueryDslSimpleQueryStringQuery(
	analyzer: String, 
	analyze_wildcard: Boolean, 
	auto_generate_synonyms_phrase_query: Boolean, 
	default_operator: QueryDslOperator, 
	fields: Fields, 
	flags: QueryDslSimpleQueryStringFlags | String, 
	fuzzy_max_expansions: integer, 
	fuzzy_prefix_length: integer, 
	fuzzy_transpositions: Boolean, 
	lenient: Boolean, 
	minimum_should_match: MinimumShouldMatch, 
	query: String, 
	quote_field_suffix: String
) extends QueryDslQueryBase

@JsonCodec case class QueryDslSpanContainingQuery(
	big: QueryDslSpanQuery, 
	little: QueryDslSpanQuery
) extends QueryDslQueryBase

@JsonCodec case class QueryDslSpanFieldMaskingQuery(
	field: Field, 
	query: QueryDslSpanQuery
) extends QueryDslQueryBase

@JsonCodec case class QueryDslSpanFirstQuery(
	end: integer, 
	`match`: QueryDslSpanQuery
) extends QueryDslQueryBase

@JsonCodec case class QueryDslSpanGapQuery(
	field: Field, 
	width: integer
) extends QueryDslQueryBase

@JsonCodec case class QueryDslSpanMultiTermQuery(
	`match`: QueryDslQueryContainer
) extends QueryDslQueryBase

@JsonCodec case class QueryDslSpanNearQuery(
	clauses: Seq[QueryDslSpanQuery], 
	in_order: Boolean, 
	slop: integer
) extends QueryDslQueryBase

@JsonCodec case class QueryDslSpanNotQuery(
	dist: integer, 
	exclude: QueryDslSpanQuery, 
	include: QueryDslSpanQuery, 
	post: integer, 
	pre: integer
) extends QueryDslQueryBase

@JsonCodec case class QueryDslSpanOrQuery(
	clauses: Seq[QueryDslSpanQuery]
) extends QueryDslQueryBase

@JsonCodec case class QueryDslSpanQuery(
	span_containing: QueryDslNamedQuery[QueryDslSpanContainingQuery | String], 
	field_masking_span: QueryDslNamedQuery[QueryDslSpanFieldMaskingQuery | String], 
	span_first: QueryDslNamedQuery[QueryDslSpanFirstQuery | String], 
	span_gap: QueryDslNamedQuery[QueryDslSpanGapQuery | integer], 
	span_multi: QueryDslSpanMultiTermQuery, 
	span_near: QueryDslNamedQuery[QueryDslSpanNearQuery | String], 
	span_not: QueryDslNamedQuery[QueryDslSpanNotQuery | String], 
	span_or: QueryDslNamedQuery[QueryDslSpanOrQuery | String], 
	span_term: QueryDslNamedQuery[QueryDslSpanTermQuery | String], 
	span_within: QueryDslNamedQuery[QueryDslSpanWithinQuery | String]
) extends QueryDslQueryBase

@JsonCodec case class QueryDslSpanTermQuery(
	value: String
) extends QueryDslQueryBase

@JsonCodec case class QueryDslSpanWithinQuery(
	big: QueryDslSpanQuery, 
	little: QueryDslSpanQuery
) extends QueryDslQueryBase

@JsonCodec case class QueryDslTermQuery(
	value: String | float | Boolean
) extends QueryDslQueryBase

@JsonCodec case class QueryDslTermsQuery(
	terms: Seq[String], 
	index: IndexName, 
	id: Id, 
	path: String, 
	routing: Routing
) extends QueryDslQueryBase

@JsonCodec case class QueryDslTermsSetQuery(
	minimum_should_match_field: Field, 
	minimum_should_match_script: Script, 
	terms: Seq[String]
) extends QueryDslQueryBase
type QueryDslTextQueryType = "best_fields"" | "most_fields"" | "cross_fields"" | "phrase"" | "phrase_prefix"" | "bool_prefix""

@JsonCodec case class QueryDslThreeDimensionalPoint(
	lat: double, 
	lon: double, 
	z: double
)

@JsonCodec case class QueryDslTwoDimensionalPoint(
	lat: double, 
	lon: double
)

@JsonCodec case class QueryDslTypeQuery(
	value: String
) extends QueryDslQueryBase

@JsonCodec case class QueryDslWildcardQuery(
	rewrite: MultiTermQueryRewrite, 
	value: String
) extends QueryDslQueryBase
type QueryDslZeroTermsQuery = "all"" | "none""

@JsonCodec case class AsyncSearchAsyncSearch[TDocument = None](
	aggregations: Record[String, AggregationsAggregate], 
	_clusters: ClusterStatistics, 
	fields: Record[String, Any], 
	hits: SearchHitsMetadata[TDocument], 
	max_score: double, 
	num_reduce_phases: long, 
	profile: SearchProfile, 
	pit_id: Id, 
	_scroll_id: Id, 
	_shards: ShardStatistics, 
	suggest: Record[SuggestionName, Seq[SearchSuggest[TDocument]]], 
	terminated_early: Boolean, 
	timed_out: Boolean, 
	took: long
)

@JsonCodec case class AsyncSearchAsyncSearchDocumentResponseBase[TDocument = None](
	response: AsyncSearchAsyncSearch[TDocument]
) extends AsyncSearchAsyncSearchResponseBase

@JsonCodec case class AsyncSearchAsyncSearchResponseBase(
	id: Id, 
	is_partial: Boolean, 
	is_running: Boolean, 
	expiration_time_in_millis: EpochMillis, 
	start_time_in_millis: EpochMillis
)

@JsonCodec case class AsyncSearchDeleteRequest(
	id: Id
) extends RequestBase

@JsonCodec case class AsyncSearchDeleteResponse extends AcknowledgedResponseBase

@JsonCodec case class AsyncSearchGetRequest(
	id: Id, 
	keep_alive: Time, 
	typed_keys: Boolean, 
	wait_for_completion_timeout: Time
) extends RequestBase

@JsonCodec case class AsyncSearchGetResponse[TDocument = None] extends AsyncSearchAsyncSearchDocumentResponseBase[TDocument]

@JsonCodec case class AsyncSearchStatusRequest(
	id: Id
) extends RequestBase

@JsonCodec case class AsyncSearchStatusResponse[TDocument = None](
	_shards: ShardStatistics, 
	completion_status: integer
) extends AsyncSearchAsyncSearchResponseBase

@JsonCodec case class AsyncSearchSubmitRequest(
	index: Indices, 
	batched_reduce_size: long, 
	wait_for_completion_timeout: Time, 
	keep_on_completion: Boolean, 
	typed_keys: Boolean, 
	body: Body
) extends RequestBase

object AsyncSearchSubmitRequest {
	@JsonCodec case class Body(
		aggs: Record[String, AggregationsAggregationContainer], 
		allow_no_indices: Boolean, 
		allow_partial_search_results: Boolean, 
		analyzer: String, 
		analyze_wildcard: Boolean, 
		batched_reduce_size: long, 
		collapse: SearchFieldCollapse, 
		default_operator: DefaultOperator, 
		df: String, 
		docvalue_fields: Fields, 
		expand_wildcards: ExpandWildcards, 
		explain: Boolean, 
		from: integer, 
		highlight: SearchHighlight, 
		ignore_throttled: Boolean, 
		ignore_unavailable: Boolean, 
		indices_boost: Seq[Record[IndexName, double]], 
		keep_alive: Time, 
		keep_on_completion: Boolean, 
		lenient: Boolean, 
		max_concurrent_shard_requests: long, 
		min_score: double, 
		post_filter: QueryDslQueryContainer, 
		preference: String, 
		profile: Boolean, 
		pit: SearchPointInTimeReference, 
		query: QueryDslQueryContainer, 
		query_on_query_string: String, 
		request_cache: Boolean, 
		rescore: Seq[SearchRescore], 
		routing: Routing, 
		script_fields: Record[String, ScriptField], 
		search_after: Seq[Any], 
		search_type: SearchType, 
		sequence_number_primary_term: Boolean, 
		size: integer, 
		sort: SearchSort, 
		_source: Boolean | SearchSourceFilter, 
		stats: Seq[String], 
		stored_fields: Fields, 
		suggest: Record[String, SearchSuggestContainer], 
		suggest_field: Field, 
		suggest_mode: SuggestMode, 
		suggest_size: long, 
		suggest_text: String, 
		terminate_after: long, 
		timeout: String, 
		track_scores: Boolean, 
		track_total_hits: Boolean, 
		typed_keys: Boolean, 
		version: Boolean, 
		wait_for_completion_timeout: Time, 
		fields: Seq[Field | DateField]
	)
}


@JsonCodec case class AsyncSearchSubmitResponse[TDocument = None] extends AsyncSearchAsyncSearchDocumentResponseBase[TDocument]

@JsonCodec case class AutoscalingCapacityGetRequest(
	stub_a: String, 
	stub_b: String, 
	body: Body
) extends RequestBase

object AutoscalingCapacityGetRequest {
	@JsonCodec case class Body(
		stub_c: String
	)
}


@JsonCodec case class AutoscalingCapacityGetResponse(
	stub: integer
)

@JsonCodec case class AutoscalingPolicyDeleteRequest(
	stub_a: String, 
	stub_b: String, 
	body: Body
) extends RequestBase

object AutoscalingPolicyDeleteRequest {
	@JsonCodec case class Body(
		stub_c: String
	)
}


@JsonCodec case class AutoscalingPolicyDeleteResponse(
	stub: integer
)

@JsonCodec case class AutoscalingPolicyGetRequest(
	stub_a: String, 
	stub_b: String, 
	body: Body
) extends RequestBase

object AutoscalingPolicyGetRequest {
	@JsonCodec case class Body(
		stub_c: String
	)
}


@JsonCodec case class AutoscalingPolicyGetResponse(
	stub: integer
)

@JsonCodec case class AutoscalingPolicyPutRequest(
	stub_a: String, 
	stub_b: String, 
	body: Body
) extends RequestBase

object AutoscalingPolicyPutRequest {
	@JsonCodec case class Body(
		stub_c: String
	)
}


@JsonCodec case class AutoscalingPolicyPutResponse(
	stub: integer
)

@JsonCodec case class CatCatRequestBase extends RequestBase, SpecUtilsCommonCatQueryParameters

@JsonCodec case class CatAliasesAliasesRecord(
	alias: String, 
	a: String, 
	index: IndexName, 
	i: IndexName, 
	idx: IndexName, 
	filter: String, 
	f: String, 
	fi: String, 
	`routing.index`: String, 
	ri: String, 
	routingIndex: String, 
	`routing.search`: String, 
	rs: String, 
	routingSearch: String, 
	is_write_index: String, 
	w: String, 
	isWriteIndex: String
)

@JsonCodec case class CatAliasesRequest(
	name: Names, 
	expand_wildcards: ExpandWildcards
) extends CatCatRequestBase
type CatAliasesResponse = Seq[CatAliasesAliasesRecord]

@JsonCodec case class CatAllocationAllocationRecord(
	shards: String, 
	s: String, 
	`disk.indices`: ByteSize, 
	di: ByteSize, 
	diskIndices: ByteSize, 
	`disk.used`: ByteSize, 
	du: ByteSize, 
	diskUsed: ByteSize, 
	`disk.avail`: ByteSize, 
	da: ByteSize, 
	diskAvail: ByteSize, 
	`disk.total`: ByteSize, 
	dt: ByteSize, 
	diskTotal: ByteSize, 
	`disk.percent`: Percentage, 
	dp: Percentage, 
	diskPercent: Percentage, 
	host: Host, 
	h: Host, 
	ip: Ip, 
	node: String, 
	n: String
)

@JsonCodec case class CatAllocationRequest(
	node_id: NodeIds, 
	bytes: Bytes
) extends CatCatRequestBase
type CatAllocationResponse = Seq[CatAllocationAllocationRecord]

@JsonCodec case class CatCountCountRecord(
	epoch: EpochMillis, 
	t: EpochMillis, 
	time: EpochMillis, 
	timestamp: DateString, 
	ts: DateString, 
	hms: DateString, 
	hhmmss: DateString, 
	count: String, 
	dc: String, 
	`docs.count`: String, 
	docsCount: String
)

@JsonCodec case class CatCountRequest(
	index: Indices
) extends CatCatRequestBase
type CatCountResponse = Seq[CatCountCountRecord]

@JsonCodec case class CatDataFrameAnalyticsDataFrameAnalyticsRecord(
	id: Id, 
	`type`: Type, 
	t: Type, 
	create_time: String, 
	ct: String, 
	createTime: String, 
	version: VersionString, 
	v: VersionString, 
	source_index: IndexName, 
	si: IndexName, 
	sourceIndex: IndexName, 
	dest_index: IndexName, 
	di: IndexName, 
	destIndex: IndexName, 
	description: String, 
	d: String, 
	model_memory_limit: String, 
	mml: String, 
	modelMemoryLimit: String, 
	state: String, 
	s: String, 
	failure_reason: String, 
	fr: String, 
	failureReason: String, 
	progress: String, 
	p: String, 
	assignment_explanation: String, 
	ae: String, 
	assignmentExplanation: String, 
	`node.id`: Id, 
	ni: Id, 
	nodeId: Id, 
	`node.name`: Name, 
	nn: Name, 
	nodeName: Name, 
	`node.ephemeral_id`: Id, 
	ne: Id, 
	nodeEphemeralId: Id, 
	`node.address`: String, 
	na: String, 
	nodeAddress: String
)

@JsonCodec case class CatDataFrameAnalyticsRequest(
	id: Id, 
	allow_no_match: Boolean, 
	bytes: Bytes
) extends CatCatRequestBase
type CatDataFrameAnalyticsResponse = Seq[CatDataFrameAnalyticsDataFrameAnalyticsRecord]

@JsonCodec case class CatDatafeedsDatafeedsRecord(
	id: String, 
	state: MlDatafeedState, 
	s: MlDatafeedState, 
	assignment_explanation: String, 
	ae: String, 
	`buckets.count`: String, 
	bc: String, 
	bucketsCount: String, 
	`search.count`: String, 
	sc: String, 
	searchCount: String, 
	`search.time`: String, 
	st: String, 
	searchTime: String, 
	`search.bucket_avg`: String, 
	sba: String, 
	searchBucketAvg: String, 
	`search.exp_avg_hour`: String, 
	seah: String, 
	searchExpAvgHour: String, 
	`node.id`: String, 
	ni: String, 
	nodeId: String, 
	`node.name`: String, 
	nn: String, 
	nodeName: String, 
	`node.ephemeral_id`: String, 
	ne: String, 
	nodeEphemeralId: String, 
	`node.address`: String, 
	na: String, 
	nodeAddress: String
)

@JsonCodec case class CatDatafeedsRequest(
	datafeed_id: Id, 
	allow_no_datafeeds: Boolean
) extends CatCatRequestBase
type CatDatafeedsResponse = Seq[CatDatafeedsDatafeedsRecord]

@JsonCodec case class CatFielddataFielddataRecord(
	id: String, 
	host: String, 
	h: String, 
	ip: String, 
	node: String, 
	n: String, 
	field: String, 
	f: String, 
	size: String
)

@JsonCodec case class CatFielddataRequest(
	fields: Fields, 
	bytes: Bytes
) extends CatCatRequestBase
type CatFielddataResponse = Seq[CatFielddataFielddataRecord]

@JsonCodec case class CatHealthHealthRecord(
	epoch: EpochMillis, 
	time: EpochMillis, 
	timestamp: DateString, 
	ts: DateString, 
	hms: DateString, 
	hhmmss: DateString, 
	cluster: String, 
	cl: String, 
	status: String, 
	st: String, 
	`node.total`: String, 
	nt: String, 
	nodeTotal: String, 
	`node.data`: String, 
	nd: String, 
	nodeData: String, 
	shards: String, 
	t: String, 
	sh: String, 
	`shards.total`: String, 
	shardsTotal: String, 
	pri: String, 
	p: String, 
	`shards.primary`: String, 
	shardsPrimary: String, 
	relo: String, 
	r: String, 
	`shards.relocating`: String, 
	shardsRelocating: String, 
	init: String, 
	i: String, 
	`shards.initializing`: String, 
	shardsInitializing: String, 
	unassign: String, 
	u: String, 
	`shards.unassigned`: String, 
	shardsUnassigned: String, 
	pending_tasks: String, 
	pt: String, 
	pendingTasks: String, 
	max_task_wait_time: String, 
	mtwt: String, 
	maxTaskWaitTime: String, 
	active_shards_percent: String, 
	asp: String, 
	activeShardsPercent: String
)

@JsonCodec case class CatHealthRequest(
	include_timestamp: Boolean, 
	ts: Boolean
) extends CatCatRequestBase
type CatHealthResponse = Seq[CatHealthHealthRecord]

@JsonCodec case class CatHelpHelpRecord(
	endpoint: String
)

@JsonCodec case class CatHelpRequest extends CatCatRequestBase
type CatHelpResponse = Seq[CatHelpHelpRecord]

@JsonCodec case class CatIndicesIndicesRecord(
	health: String, 
	h: String, 
	status: String, 
	s: String, 
	index: String, 
	i: String, 
	idx: String, 
	uuid: String, 
	id: String, 
	pri: String, 
	p: String, 
	`shards.primary`: String, 
	shardsPrimary: String, 
	rep: String, 
	r: String, 
	`shards.replica`: String, 
	shardsReplica: String, 
	`docs.count`: String, 
	dc: String, 
	docsCount: String, 
	`docs.deleted`: String, 
	dd: String, 
	docsDeleted: String, 
	`creation.date`: String, 
	cd: String, 
	`creation.date.string`: String, 
	cds: String, 
	`store.size`: String, 
	ss: String, 
	storeSize: String, 
	`pri.store.size`: String, 
	`completion.size`: String, 
	cs: String, 
	completionSize: String, 
	`pri.completion.size`: String, 
	`fielddata.memory_size`: String, 
	fm: String, 
	fielddataMemory: String, 
	`pri.fielddata.memory_size`: String, 
	`fielddata.evictions`: String, 
	fe: String, 
	fielddataEvictions: String, 
	`pri.fielddata.evictions`: String, 
	`query_cache.memory_size`: String, 
	qcm: String, 
	queryCacheMemory: String, 
	`pri.query_cache.memory_size`: String, 
	`query_cache.evictions`: String, 
	qce: String, 
	queryCacheEvictions: String, 
	`pri.query_cache.evictions`: String, 
	`request_cache.memory_size`: String, 
	rcm: String, 
	requestCacheMemory: String, 
	`pri.request_cache.memory_size`: String, 
	`request_cache.evictions`: String, 
	rce: String, 
	requestCacheEvictions: String, 
	`pri.request_cache.evictions`: String, 
	`request_cache.hit_count`: String, 
	rchc: String, 
	requestCacheHitCount: String, 
	`pri.request_cache.hit_count`: String, 
	`request_cache.miss_count`: String, 
	rcmc: String, 
	requestCacheMissCount: String, 
	`pri.request_cache.miss_count`: String, 
	`flush.total`: String, 
	ft: String, 
	flushTotal: String, 
	`pri.flush.total`: String, 
	`flush.total_time`: String, 
	ftt: String, 
	flushTotalTime: String, 
	`pri.flush.total_time`: String, 
	`get.current`: String, 
	gc: String, 
	getCurrent: String, 
	`pri.get.current`: String, 
	`get.time`: String, 
	gti: String, 
	getTime: String, 
	`pri.get.time`: String, 
	`get.total`: String, 
	gto: String, 
	getTotal: String, 
	`pri.get.total`: String, 
	`get.exists_time`: String, 
	geti: String, 
	getExistsTime: String, 
	`pri.get.exists_time`: String, 
	`get.exists_total`: String, 
	geto: String, 
	getExistsTotal: String, 
	`pri.get.exists_total`: String, 
	`get.missing_time`: String, 
	gmti: String, 
	getMissingTime: String, 
	`pri.get.missing_time`: String, 
	`get.missing_total`: String, 
	gmto: String, 
	getMissingTotal: String, 
	`pri.get.missing_total`: String, 
	`indexing.delete_current`: String, 
	idc: String, 
	indexingDeleteCurrent: String, 
	`pri.indexing.delete_current`: String, 
	`indexing.delete_time`: String, 
	idti: String, 
	indexingDeleteTime: String, 
	`pri.indexing.delete_time`: String, 
	`indexing.delete_total`: String, 
	idto: String, 
	indexingDeleteTotal: String, 
	`pri.indexing.delete_total`: String, 
	`indexing.index_current`: String, 
	iic: String, 
	indexingIndexCurrent: String, 
	`pri.indexing.index_current`: String, 
	`indexing.index_time`: String, 
	iiti: String, 
	indexingIndexTime: String, 
	`pri.indexing.index_time`: String, 
	`indexing.index_total`: String, 
	iito: String, 
	indexingIndexTotal: String, 
	`pri.indexing.index_total`: String, 
	`indexing.index_failed`: String, 
	iif: String, 
	indexingIndexFailed: String, 
	`pri.indexing.index_failed`: String, 
	`merges.current`: String, 
	mc: String, 
	mergesCurrent: String, 
	`pri.merges.current`: String, 
	`merges.current_docs`: String, 
	mcd: String, 
	mergesCurrentDocs: String, 
	`pri.merges.current_docs`: String, 
	`merges.current_size`: String, 
	mcs: String, 
	mergesCurrentSize: String, 
	`pri.merges.current_size`: String, 
	`merges.total`: String, 
	mt: String, 
	mergesTotal: String, 
	`pri.merges.total`: String, 
	`merges.total_docs`: String, 
	mtd: String, 
	mergesTotalDocs: String, 
	`pri.merges.total_docs`: String, 
	`merges.total_size`: String, 
	mts: String, 
	mergesTotalSize: String, 
	`pri.merges.total_size`: String, 
	`merges.total_time`: String, 
	mtt: String, 
	mergesTotalTime: String, 
	`pri.merges.total_time`: String, 
	`refresh.total`: String, 
	rto: String, 
	refreshTotal: String, 
	`pri.refresh.total`: String, 
	`refresh.time`: String, 
	rti: String, 
	refreshTime: String, 
	`pri.refresh.time`: String, 
	`refresh.external_total`: String, 
	reto: String, 
	`pri.refresh.external_total`: String, 
	`refresh.external_time`: String, 
	reti: String, 
	`pri.refresh.external_time`: String, 
	`refresh.listeners`: String, 
	rli: String, 
	refreshListeners: String, 
	`pri.refresh.listeners`: String, 
	`search.fetch_current`: String, 
	sfc: String, 
	searchFetchCurrent: String, 
	`pri.search.fetch_current`: String, 
	`search.fetch_time`: String, 
	sfti: String, 
	searchFetchTime: String, 
	`pri.search.fetch_time`: String, 
	`search.fetch_total`: String, 
	sfto: String, 
	searchFetchTotal: String, 
	`pri.search.fetch_total`: String, 
	`search.open_contexts`: String, 
	so: String, 
	searchOpenContexts: String, 
	`pri.search.open_contexts`: String, 
	`search.query_current`: String, 
	sqc: String, 
	searchQueryCurrent: String, 
	`pri.search.query_current`: String, 
	`search.query_time`: String, 
	sqti: String, 
	searchQueryTime: String, 
	`pri.search.query_time`: String, 
	`search.query_total`: String, 
	sqto: String, 
	searchQueryTotal: String, 
	`pri.search.query_total`: String, 
	`search.scroll_current`: String, 
	scc: String, 
	searchScrollCurrent: String, 
	`pri.search.scroll_current`: String, 
	`search.scroll_time`: String, 
	scti: String, 
	searchScrollTime: String, 
	`pri.search.scroll_time`: String, 
	`search.scroll_total`: String, 
	scto: String, 
	searchScrollTotal: String, 
	`pri.search.scroll_total`: String, 
	`segments.count`: String, 
	sc: String, 
	segmentsCount: String, 
	`pri.segments.count`: String, 
	`segments.memory`: String, 
	sm: String, 
	segmentsMemory: String, 
	`pri.segments.memory`: String, 
	`segments.index_writer_memory`: String, 
	siwm: String, 
	segmentsIndexWriterMemory: String, 
	`pri.segments.index_writer_memory`: String, 
	`segments.version_map_memory`: String, 
	svmm: String, 
	segmentsVersionMapMemory: String, 
	`pri.segments.version_map_memory`: String, 
	`segments.fixed_bitset_memory`: String, 
	sfbm: String, 
	fixedBitsetMemory: String, 
	`pri.segments.fixed_bitset_memory`: String, 
	`warmer.current`: String, 
	wc: String, 
	warmerCurrent: String, 
	`pri.warmer.current`: String, 
	`warmer.total`: String, 
	wto: String, 
	warmerTotal: String, 
	`pri.warmer.total`: String, 
	`warmer.total_time`: String, 
	wtt: String, 
	warmerTotalTime: String, 
	`pri.warmer.total_time`: String, 
	`suggest.current`: String, 
	suc: String, 
	suggestCurrent: String, 
	`pri.suggest.current`: String, 
	`suggest.time`: String, 
	suti: String, 
	suggestTime: String, 
	`pri.suggest.time`: String, 
	`suggest.total`: String, 
	suto: String, 
	suggestTotal: String, 
	`pri.suggest.total`: String, 
	`memory.total`: String, 
	tm: String, 
	memoryTotal: String, 
	`pri.memory.total`: String, 
	`search.throttled`: String, 
	sth: String, 
	`bulk.total_operations`: String, 
	bto: String, 
	bulkTotalOperation: String, 
	`pri.bulk.total_operations`: String, 
	`bulk.total_time`: String, 
	btti: String, 
	bulkTotalTime: String, 
	`pri.bulk.total_time`: String, 
	`bulk.total_size_in_bytes`: String, 
	btsi: String, 
	bulkTotalSizeInBytes: String, 
	`pri.bulk.total_size_in_bytes`: String, 
	`bulk.avg_time`: String, 
	bati: String, 
	bulkAvgTime: String, 
	`pri.bulk.avg_time`: String, 
	`bulk.avg_size_in_bytes`: String, 
	basi: String, 
	bulkAvgSizeInBytes: String, 
	`pri.bulk.avg_size_in_bytes`: String
)

@JsonCodec case class CatIndicesRequest(
	index: Indices, 
	bytes: Bytes, 
	expand_wildcards: ExpandWildcards, 
	health: Health, 
	include_unloaded_segments: Boolean, 
	pri: Boolean
) extends CatCatRequestBase
type CatIndicesResponse = Seq[CatIndicesIndicesRecord]

@JsonCodec case class CatJobsJobsRecord(
	id: Id, 
	state: MlJobState, 
	s: MlJobState, 
	opened_time: String, 
	ot: String, 
	assignment_explanation: String, 
	ae: String, 
	`data.processed_records`: String, 
	dpr: String, 
	dataProcessedRecords: String, 
	`data.processed_fields`: String, 
	dpf: String, 
	dataProcessedFields: String, 
	`data.input_bytes`: ByteSize, 
	dib: ByteSize, 
	dataInputBytes: ByteSize, 
	`data.input_records`: String, 
	dir: String, 
	dataInputRecords: String, 
	`data.input_fields`: String, 
	dif: String, 
	dataInputFields: String, 
	`data.invalid_dates`: String, 
	did: String, 
	dataInvalidDates: String, 
	`data.missing_fields`: String, 
	dmf: String, 
	dataMissingFields: String, 
	`data.out_of_order_timestamps`: String, 
	doot: String, 
	dataOutOfOrderTimestamps: String, 
	`data.empty_buckets`: String, 
	deb: String, 
	dataEmptyBuckets: String, 
	`data.sparse_buckets`: String, 
	dsb: String, 
	dataSparseBuckets: String, 
	`data.buckets`: String, 
	db: String, 
	dataBuckets: String, 
	`data.earliest_record`: String, 
	der: String, 
	dataEarliestRecord: String, 
	`data.latest_record`: String, 
	dlr: String, 
	dataLatestRecord: String, 
	`data.last`: String, 
	dl: String, 
	dataLast: String, 
	`data.last_empty_bucket`: String, 
	dleb: String, 
	dataLastEmptyBucket: String, 
	`data.last_sparse_bucket`: String, 
	dlsb: String, 
	dataLastSparseBucket: String, 
	`model.bytes`: ByteSize, 
	mb: ByteSize, 
	modelBytes: ByteSize, 
	`model.memory_status`: MlMemoryStatus, 
	mms: MlMemoryStatus, 
	modelMemoryStatus: MlMemoryStatus, 
	`model.bytes_exceeded`: ByteSize, 
	mbe: ByteSize, 
	modelBytesExceeded: ByteSize, 
	`model.memory_limit`: String, 
	mml: String, 
	modelMemoryLimit: String, 
	`model.by_fields`: String, 
	mbf: String, 
	modelByFields: String, 
	`model.over_fields`: String, 
	mof: String, 
	modelOverFields: String, 
	`model.partition_fields`: String, 
	mpf: String, 
	modelPartitionFields: String, 
	`model.bucket_allocation_failures`: String, 
	mbaf: String, 
	modelBucketAllocationFailures: String, 
	`model.categorization_status`: MlCategorizationStatus, 
	mcs: MlCategorizationStatus, 
	modelCategorizationStatus: MlCategorizationStatus, 
	`model.categorized_doc_count`: String, 
	mcdc: String, 
	modelCategorizedDocCount: String, 
	`model.total_category_count`: String, 
	mtcc: String, 
	modelTotalCategoryCount: String, 
	`model.frequent_category_count`: String, 
	modelFrequentCategoryCount: String, 
	`model.rare_category_count`: String, 
	mrcc: String, 
	modelRareCategoryCount: String, 
	`model.dead_category_count`: String, 
	mdcc: String, 
	modelDeadCategoryCount: String, 
	`model.failed_category_count`: String, 
	mfcc: String, 
	modelFailedCategoryCount: String, 
	`model.log_time`: String, 
	mlt: String, 
	modelLogTime: String, 
	`model.timestamp`: String, 
	mt: String, 
	modelTimestamp: String, 
	`forecasts.total`: String, 
	ft: String, 
	forecastsTotal: String, 
	`forecasts.memory.min`: String, 
	fmmin: String, 
	forecastsMemoryMin: String, 
	`forecasts.memory.max`: String, 
	fmmax: String, 
	forecastsMemoryMax: String, 
	`forecasts.memory.avg`: String, 
	fmavg: String, 
	forecastsMemoryAvg: String, 
	`forecasts.memory.total`: String, 
	fmt: String, 
	forecastsMemoryTotal: String, 
	`forecasts.records.min`: String, 
	frmin: String, 
	forecastsRecordsMin: String, 
	`forecasts.records.max`: String, 
	frmax: String, 
	forecastsRecordsMax: String, 
	`forecasts.records.avg`: String, 
	fravg: String, 
	forecastsRecordsAvg: String, 
	`forecasts.records.total`: String, 
	frt: String, 
	forecastsRecordsTotal: String, 
	`forecasts.time.min`: String, 
	ftmin: String, 
	forecastsTimeMin: String, 
	`forecasts.time.max`: String, 
	ftmax: String, 
	forecastsTimeMax: String, 
	`forecasts.time.avg`: String, 
	ftavg: String, 
	forecastsTimeAvg: String, 
	`forecasts.time.total`: String, 
	ftt: String, 
	forecastsTimeTotal: String, 
	`node.id`: NodeId, 
	ni: NodeId, 
	nodeId: NodeId, 
	`node.name`: String, 
	nn: String, 
	nodeName: String, 
	`node.ephemeral_id`: NodeId, 
	ne: NodeId, 
	nodeEphemeralId: NodeId, 
	`node.address`: String, 
	na: String, 
	nodeAddress: String, 
	`buckets.count`: String, 
	bc: String, 
	bucketsCount: String, 
	`buckets.time.total`: String, 
	btt: String, 
	bucketsTimeTotal: String, 
	`buckets.time.min`: String, 
	btmin: String, 
	bucketsTimeMin: String, 
	`buckets.time.max`: String, 
	btmax: String, 
	bucketsTimeMax: String, 
	`buckets.time.exp_avg`: String, 
	btea: String, 
	bucketsTimeExpAvg: String, 
	`buckets.time.exp_avg_hour`: String, 
	bteah: String, 
	bucketsTimeExpAvgHour: String
)

@JsonCodec case class CatJobsRequest(
	job_id: Id, 
	allow_no_jobs: Boolean, 
	bytes: Bytes
) extends CatCatRequestBase
type CatJobsResponse = Seq[CatJobsJobsRecord]

@JsonCodec case class CatMasterMasterRecord(
	id: String, 
	host: String, 
	h: String, 
	ip: String, 
	node: String, 
	n: String
)

@JsonCodec case class CatMasterRequest extends CatCatRequestBase
type CatMasterResponse = Seq[CatMasterMasterRecord]

@JsonCodec case class CatNodeAttributesNodeAttributesRecord(
	node: String, 
	id: String, 
	pid: String, 
	host: String, 
	h: String, 
	ip: String, 
	i: String, 
	port: String, 
	attr: String, 
	value: String
)

@JsonCodec case class CatNodeAttributesRequest extends CatCatRequestBase
type CatNodeAttributesResponse = Seq[CatNodeAttributesNodeAttributesRecord]

@JsonCodec case class CatNodesNodesRecord(
	id: Id, 
	nodeId: Id, 
	pid: String, 
	p: String, 
	ip: String, 
	i: String, 
	port: String, 
	po: String, 
	http_address: String, 
	http: String, 
	version: VersionString, 
	v: VersionString, 
	flavor: String, 
	f: String, 
	`type`: Type, 
	t: Type, 
	build: String, 
	b: String, 
	jdk: String, 
	j: String, 
	`disk.total`: ByteSize, 
	dt: ByteSize, 
	diskTotal: ByteSize, 
	`disk.used`: ByteSize, 
	du: ByteSize, 
	diskUsed: ByteSize, 
	`disk.avail`: ByteSize, 
	d: ByteSize, 
	da: ByteSize, 
	disk: ByteSize, 
	diskAvail: ByteSize, 
	`disk.used_percent`: Percentage, 
	dup: Percentage, 
	diskUsedPercent: Percentage, 
	`heap.current`: String, 
	hc: String, 
	heapCurrent: String, 
	`heap.percent`: Percentage, 
	hp: Percentage, 
	heapPercent: Percentage, 
	`heap.max`: String, 
	hm: String, 
	heapMax: String, 
	`ram.current`: String, 
	rc: String, 
	ramCurrent: String, 
	`ram.percent`: Percentage, 
	rp: Percentage, 
	ramPercent: Percentage, 
	`ram.max`: String, 
	rn: String, 
	ramMax: String, 
	`file_desc.current`: String, 
	fdc: String, 
	fileDescriptorCurrent: String, 
	`file_desc.percent`: Percentage, 
	fdp: Percentage, 
	fileDescriptorPercent: Percentage, 
	`file_desc.max`: String, 
	fdm: String, 
	fileDescriptorMax: String, 
	cpu: String, 
	load_1m: String, 
	load_5m: String, 
	load_15m: String, 
	l: String, 
	uptime: String, 
	u: String, 
	`node.role`: String, 
	r: String, 
	role: String, 
	nodeRole: String, 
	master: String, 
	m: String, 
	name: Name, 
	n: Name, 
	`completion.size`: String, 
	cs: String, 
	completionSize: String, 
	`fielddata.memory_size`: String, 
	fm: String, 
	fielddataMemory: String, 
	`fielddata.evictions`: String, 
	fe: String, 
	fielddataEvictions: String, 
	`query_cache.memory_size`: String, 
	qcm: String, 
	queryCacheMemory: String, 
	`query_cache.evictions`: String, 
	qce: String, 
	queryCacheEvictions: String, 
	`query_cache.hit_count`: String, 
	qchc: String, 
	queryCacheHitCount: String, 
	`query_cache.miss_count`: String, 
	qcmc: String, 
	queryCacheMissCount: String, 
	`request_cache.memory_size`: String, 
	rcm: String, 
	requestCacheMemory: String, 
	`request_cache.evictions`: String, 
	rce: String, 
	requestCacheEvictions: String, 
	`request_cache.hit_count`: String, 
	rchc: String, 
	requestCacheHitCount: String, 
	`request_cache.miss_count`: String, 
	rcmc: String, 
	requestCacheMissCount: String, 
	`flush.total`: String, 
	ft: String, 
	flushTotal: String, 
	`flush.total_time`: String, 
	ftt: String, 
	flushTotalTime: String, 
	`get.current`: String, 
	gc: String, 
	getCurrent: String, 
	`get.time`: String, 
	gti: String, 
	getTime: String, 
	`get.total`: String, 
	gto: String, 
	getTotal: String, 
	`get.exists_time`: String, 
	geti: String, 
	getExistsTime: String, 
	`get.exists_total`: String, 
	geto: String, 
	getExistsTotal: String, 
	`get.missing_time`: String, 
	gmti: String, 
	getMissingTime: String, 
	`get.missing_total`: String, 
	gmto: String, 
	getMissingTotal: String, 
	`indexing.delete_current`: String, 
	idc: String, 
	indexingDeleteCurrent: String, 
	`indexing.delete_time`: String, 
	idti: String, 
	indexingDeleteTime: String, 
	`indexing.delete_total`: String, 
	idto: String, 
	indexingDeleteTotal: String, 
	`indexing.index_current`: String, 
	iic: String, 
	indexingIndexCurrent: String, 
	`indexing.index_time`: String, 
	iiti: String, 
	indexingIndexTime: String, 
	`indexing.index_total`: String, 
	iito: String, 
	indexingIndexTotal: String, 
	`indexing.index_failed`: String, 
	iif: String, 
	indexingIndexFailed: String, 
	`merges.current`: String, 
	mc: String, 
	mergesCurrent: String, 
	`merges.current_docs`: String, 
	mcd: String, 
	mergesCurrentDocs: String, 
	`merges.current_size`: String, 
	mcs: String, 
	mergesCurrentSize: String, 
	`merges.total`: String, 
	mt: String, 
	mergesTotal: String, 
	`merges.total_docs`: String, 
	mtd: String, 
	mergesTotalDocs: String, 
	`merges.total_size`: String, 
	mts: String, 
	mergesTotalSize: String, 
	`merges.total_time`: String, 
	mtt: String, 
	mergesTotalTime: String, 
	`refresh.total`: String, 
	`refresh.time`: String, 
	`refresh.external_total`: String, 
	rto: String, 
	refreshTotal: String, 
	`refresh.external_time`: String, 
	rti: String, 
	refreshTime: String, 
	`refresh.listeners`: String, 
	rli: String, 
	refreshListeners: String, 
	`script.compilations`: String, 
	scrcc: String, 
	scriptCompilations: String, 
	`script.cache_evictions`: String, 
	scrce: String, 
	scriptCacheEvictions: String, 
	`script.compilation_limit_triggered`: String, 
	scrclt: String, 
	scriptCacheCompilationLimitTriggered: String, 
	`search.fetch_current`: String, 
	sfc: String, 
	searchFetchCurrent: String, 
	`search.fetch_time`: String, 
	sfti: String, 
	searchFetchTime: String, 
	`search.fetch_total`: String, 
	sfto: String, 
	searchFetchTotal: String, 
	`search.open_contexts`: String, 
	so: String, 
	searchOpenContexts: String, 
	`search.query_current`: String, 
	sqc: String, 
	searchQueryCurrent: String, 
	`search.query_time`: String, 
	sqti: String, 
	searchQueryTime: String, 
	`search.query_total`: String, 
	sqto: String, 
	searchQueryTotal: String, 
	`search.scroll_current`: String, 
	scc: String, 
	searchScrollCurrent: String, 
	`search.scroll_time`: String, 
	scti: String, 
	searchScrollTime: String, 
	`search.scroll_total`: String, 
	scto: String, 
	searchScrollTotal: String, 
	`segments.count`: String, 
	sc: String, 
	segmentsCount: String, 
	`segments.memory`: String, 
	sm: String, 
	segmentsMemory: String, 
	`segments.index_writer_memory`: String, 
	siwm: String, 
	segmentsIndexWriterMemory: String, 
	`segments.version_map_memory`: String, 
	svmm: String, 
	segmentsVersionMapMemory: String, 
	`segments.fixed_bitset_memory`: String, 
	sfbm: String, 
	fixedBitsetMemory: String, 
	`suggest.current`: String, 
	suc: String, 
	suggestCurrent: String, 
	`suggest.time`: String, 
	suti: String, 
	suggestTime: String, 
	`suggest.total`: String, 
	suto: String, 
	suggestTotal: String, 
	`bulk.total_operations`: String, 
	bto: String, 
	bulkTotalOperations: String, 
	`bulk.total_time`: String, 
	btti: String, 
	bulkTotalTime: String, 
	`bulk.total_size_in_bytes`: String, 
	btsi: String, 
	bulkTotalSizeInBytes: String, 
	`bulk.avg_time`: String, 
	bati: String, 
	bulkAvgTime: String, 
	`bulk.avg_size_in_bytes`: String, 
	basi: String, 
	bulkAvgSizeInBytes: String
)

@JsonCodec case class CatNodesRequest(
	bytes: Bytes, 
	full_id: Boolean | String
) extends CatCatRequestBase
type CatNodesResponse = Seq[CatNodesNodesRecord]

@JsonCodec case class CatPendingTasksPendingTasksRecord(
	insertOrder: String, 
	o: String, 
	timeInQueue: String, 
	t: String, 
	priority: String, 
	p: String, 
	source: String, 
	s: String
)

@JsonCodec case class CatPendingTasksRequest extends CatCatRequestBase
type CatPendingTasksResponse = Seq[CatPendingTasksPendingTasksRecord]

@JsonCodec case class CatPluginsPluginsRecord(
	id: NodeId, 
	name: Name, 
	n: Name, 
	component: String, 
	c: String, 
	version: VersionString, 
	v: VersionString, 
	description: String, 
	d: String, 
	`type`: Type, 
	t: Type
)

@JsonCodec case class CatPluginsRequest extends CatCatRequestBase
type CatPluginsResponse = Seq[CatPluginsPluginsRecord]

@JsonCodec case class CatRecoveryRecoveryRecord(
	index: IndexName, 
	i: IndexName, 
	idx: IndexName, 
	shard: String, 
	s: String, 
	sh: String, 
	start_time: String, 
	start: String, 
	start_time_millis: String, 
	start_millis: String, 
	stop_time: String, 
	stop: String, 
	stop_time_millis: String, 
	stop_millis: String, 
	time: String, 
	t: String, 
	ti: String, 
	`type`: Type, 
	ty: Type, 
	stage: String, 
	st: String, 
	source_host: String, 
	shost: String, 
	source_node: String, 
	snode: String, 
	target_host: String, 
	thost: String, 
	target_node: String, 
	tnode: String, 
	repository: String, 
	rep: String, 
	snapshot: String, 
	snap: String, 
	files: String, 
	f: String, 
	files_recovered: String, 
	fr: String, 
	files_percent: Percentage, 
	fp: Percentage, 
	files_total: String, 
	tf: String, 
	bytes: String, 
	b: String, 
	bytes_recovered: String, 
	br: String, 
	bytes_percent: Percentage, 
	bp: Percentage, 
	bytes_total: String, 
	tb: String, 
	translog_ops: String, 
	to: String, 
	translog_ops_recovered: String, 
	tor: String, 
	translog_ops_percent: Percentage, 
	top: Percentage
)

@JsonCodec case class CatRecoveryRequest(
	index: Indices, 
	active_only: Boolean, 
	bytes: Bytes, 
	detailed: Boolean
) extends CatCatRequestBase
type CatRecoveryResponse = Seq[CatRecoveryRecoveryRecord]

@JsonCodec case class CatRepositoriesRepositoriesRecord(
	id: String, 
	repoId: String, 
	`type`: String, 
	t: String
)

@JsonCodec case class CatRepositoriesRequest extends CatCatRequestBase
type CatRepositoriesResponse = Seq[CatRepositoriesRepositoriesRecord]

@JsonCodec case class CatSegmentsRequest(
	index: Indices, 
	bytes: Bytes
) extends CatCatRequestBase
type CatSegmentsResponse = Seq[CatSegmentsSegmentsRecord]

@JsonCodec case class CatSegmentsSegmentsRecord(
	index: IndexName, 
	i: IndexName, 
	idx: IndexName, 
	shard: String, 
	s: String, 
	sh: String, 
	prirep: String, 
	p: String, 
	pr: String, 
	primaryOrReplica: String, 
	ip: String, 
	id: NodeId, 
	segment: String, 
	seg: String, 
	generation: String, 
	g: String, 
	gen: String, 
	`docs.count`: String, 
	dc: String, 
	docsCount: String, 
	`docs.deleted`: String, 
	dd: String, 
	docsDeleted: String, 
	size: ByteSize, 
	si: ByteSize, 
	`size.memory`: ByteSize, 
	sm: ByteSize, 
	sizeMemory: ByteSize, 
	committed: String, 
	ic: String, 
	isCommitted: String, 
	searchable: String, 
	is: String, 
	isSearchable: String, 
	version: VersionString, 
	v: VersionString, 
	compound: String, 
	ico: String, 
	isCompound: String
)

@JsonCodec case class CatShardsRequest(
	index: Indices, 
	bytes: Bytes
) extends CatCatRequestBase
type CatShardsResponse = Seq[CatShardsShardsRecord]

@JsonCodec case class CatShardsShardsRecord(
	index: String, 
	i: String, 
	idx: String, 
	shard: String, 
	s: String, 
	sh: String, 
	prirep: String, 
	p: String, 
	pr: String, 
	primaryOrReplica: String, 
	state: String, 
	st: String, 
	docs: String, 
	d: String, 
	dc: String, 
	store: String, 
	sto: String, 
	ip: String, 
	id: String, 
	node: String, 
	n: String, 
	sync_id: String, 
	`unassigned.reason`: String, 
	ur: String, 
	`unassigned.at`: String, 
	ua: String, 
	`unassigned.for`: String, 
	uf: String, 
	`unassigned.details`: String, 
	ud: String, 
	`recoverysource.type`: String, 
	rs: String, 
	`completion.size`: String, 
	cs: String, 
	completionSize: String, 
	`fielddata.memory_size`: String, 
	fm: String, 
	fielddataMemory: String, 
	`fielddata.evictions`: String, 
	fe: String, 
	fielddataEvictions: String, 
	`query_cache.memory_size`: String, 
	qcm: String, 
	queryCacheMemory: String, 
	`query_cache.evictions`: String, 
	qce: String, 
	queryCacheEvictions: String, 
	`flush.total`: String, 
	ft: String, 
	flushTotal: String, 
	`flush.total_time`: String, 
	ftt: String, 
	flushTotalTime: String, 
	`get.current`: String, 
	gc: String, 
	getCurrent: String, 
	`get.time`: String, 
	gti: String, 
	getTime: String, 
	`get.total`: String, 
	gto: String, 
	getTotal: String, 
	`get.exists_time`: String, 
	geti: String, 
	getExistsTime: String, 
	`get.exists_total`: String, 
	geto: String, 
	getExistsTotal: String, 
	`get.missing_time`: String, 
	gmti: String, 
	getMissingTime: String, 
	`get.missing_total`: String, 
	gmto: String, 
	getMissingTotal: String, 
	`indexing.delete_current`: String, 
	idc: String, 
	indexingDeleteCurrent: String, 
	`indexing.delete_time`: String, 
	idti: String, 
	indexingDeleteTime: String, 
	`indexing.delete_total`: String, 
	idto: String, 
	indexingDeleteTotal: String, 
	`indexing.index_current`: String, 
	iic: String, 
	indexingIndexCurrent: String, 
	`indexing.index_time`: String, 
	iiti: String, 
	indexingIndexTime: String, 
	`indexing.index_total`: String, 
	iito: String, 
	indexingIndexTotal: String, 
	`indexing.index_failed`: String, 
	iif: String, 
	indexingIndexFailed: String, 
	`merges.current`: String, 
	mc: String, 
	mergesCurrent: String, 
	`merges.current_docs`: String, 
	mcd: String, 
	mergesCurrentDocs: String, 
	`merges.current_size`: String, 
	mcs: String, 
	mergesCurrentSize: String, 
	`merges.total`: String, 
	mt: String, 
	mergesTotal: String, 
	`merges.total_docs`: String, 
	mtd: String, 
	mergesTotalDocs: String, 
	`merges.total_size`: String, 
	mts: String, 
	mergesTotalSize: String, 
	`merges.total_time`: String, 
	mtt: String, 
	mergesTotalTime: String, 
	`refresh.total`: String, 
	`refresh.time`: String, 
	`refresh.external_total`: String, 
	rto: String, 
	refreshTotal: String, 
	`refresh.external_time`: String, 
	rti: String, 
	refreshTime: String, 
	`refresh.listeners`: String, 
	rli: String, 
	refreshListeners: String, 
	`search.fetch_current`: String, 
	sfc: String, 
	searchFetchCurrent: String, 
	`search.fetch_time`: String, 
	sfti: String, 
	searchFetchTime: String, 
	`search.fetch_total`: String, 
	sfto: String, 
	searchFetchTotal: String, 
	`search.open_contexts`: String, 
	so: String, 
	searchOpenContexts: String, 
	`search.query_current`: String, 
	sqc: String, 
	searchQueryCurrent: String, 
	`search.query_time`: String, 
	sqti: String, 
	searchQueryTime: String, 
	`search.query_total`: String, 
	sqto: String, 
	searchQueryTotal: String, 
	`search.scroll_current`: String, 
	scc: String, 
	searchScrollCurrent: String, 
	`search.scroll_time`: String, 
	scti: String, 
	searchScrollTime: String, 
	`search.scroll_total`: String, 
	scto: String, 
	searchScrollTotal: String, 
	`segments.count`: String, 
	sc: String, 
	segmentsCount: String, 
	`segments.memory`: String, 
	sm: String, 
	segmentsMemory: String, 
	`segments.index_writer_memory`: String, 
	siwm: String, 
	segmentsIndexWriterMemory: String, 
	`segments.version_map_memory`: String, 
	svmm: String, 
	segmentsVersionMapMemory: String, 
	`segments.fixed_bitset_memory`: String, 
	sfbm: String, 
	fixedBitsetMemory: String, 
	`seq_no.max`: String, 
	sqm: String, 
	maxSeqNo: String, 
	`seq_no.local_checkpoint`: String, 
	sql: String, 
	localCheckpoint: String, 
	`seq_no.global_checkpoint`: String, 
	sqg: String, 
	globalCheckpoint: String, 
	`warmer.current`: String, 
	wc: String, 
	warmerCurrent: String, 
	`warmer.total`: String, 
	wto: String, 
	warmerTotal: String, 
	`warmer.total_time`: String, 
	wtt: String, 
	warmerTotalTime: String, 
	`path.data`: String, 
	pd: String, 
	dataPath: String, 
	`path.state`: String, 
	ps: String, 
	statsPath: String, 
	`bulk.total_operations`: String, 
	bto: String, 
	bulkTotalOperations: String, 
	`bulk.total_time`: String, 
	btti: String, 
	bulkTotalTime: String, 
	`bulk.total_size_in_bytes`: String, 
	btsi: String, 
	bulkTotalSizeInBytes: String, 
	`bulk.avg_time`: String, 
	bati: String, 
	bulkAvgTime: String, 
	`bulk.avg_size_in_bytes`: String, 
	basi: String, 
	bulkAvgSizeInBytes: String
)

@JsonCodec case class CatSnapshotsRequest(
	repository: Names, 
	ignore_unavailable: Boolean
) extends CatCatRequestBase
type CatSnapshotsResponse = Seq[CatSnapshotsSnapshotsRecord]

@JsonCodec case class CatSnapshotsSnapshotsRecord(
	id: String, 
	snapshot: String, 
	repository: String, 
	re: String, 
	repo: String, 
	status: String, 
	s: String, 
	start_epoch: EpochMillis, 
	ste: EpochMillis, 
	startEpoch: EpochMillis, 
	start_time: DateString, 
	sti: DateString, 
	startTime: DateString, 
	end_epoch: EpochMillis, 
	ete: EpochMillis, 
	endEpoch: EpochMillis, 
	end_time: DateString, 
	eti: DateString, 
	endTime: DateString, 
	duration: Time, 
	dur: Time, 
	indices: String, 
	i: String, 
	successful_shards: String, 
	ss: String, 
	failed_shards: String, 
	fs: String, 
	total_shards: String, 
	ts: String, 
	reason: String, 
	r: String
)

@JsonCodec case class CatTasksRequest(
	actions: Seq[String], 
	detailed: Boolean, 
	node_id: Seq[String], 
	parent_task: long
) extends CatCatRequestBase
type CatTasksResponse = Seq[CatTasksTasksRecord]

@JsonCodec case class CatTasksTasksRecord(
	id: Id, 
	action: String, 
	ac: String, 
	task_id: Id, 
	ti: Id, 
	parent_task_id: String, 
	pti: String, 
	`type`: Type, 
	ty: Type, 
	start_time: String, 
	start: String, 
	timestamp: String, 
	ts: String, 
	hms: String, 
	hhmmss: String, 
	running_time_ns: String, 
	running_time: String, 
	time: String, 
	node_id: NodeId, 
	ni: NodeId, 
	ip: String, 
	i: String, 
	port: String, 
	po: String, 
	node: String, 
	n: String, 
	version: VersionString, 
	v: VersionString, 
	x_opaque_id: String, 
	x: String, 
	description: String, 
	desc: String
)

@JsonCodec case class CatTemplatesRequest(
	name: Name
) extends CatCatRequestBase
type CatTemplatesResponse = Seq[CatTemplatesTemplatesRecord]

@JsonCodec case class CatTemplatesTemplatesRecord(
	name: Name, 
	n: Name, 
	index_patterns: String, 
	t: String, 
	order: String, 
	o: String, 
	p: String, 
	version: VersionString, 
	v: VersionString, 
	composed_of: String, 
	c: String
)

@JsonCodec case class CatThreadPoolRequest(
	thread_pool_patterns: Names, 
	size: Size | Boolean
) extends CatCatRequestBase
type CatThreadPoolResponse = Seq[CatThreadPoolThreadPoolRecord]

@JsonCodec case class CatThreadPoolThreadPoolRecord(
	node_name: String, 
	nn: String, 
	node_id: NodeId, 
	id: NodeId, 
	ephemeral_node_id: String, 
	eid: String, 
	pid: String, 
	p: String, 
	host: String, 
	h: String, 
	ip: String, 
	i: String, 
	port: String, 
	po: String, 
	name: String, 
	n: String, 
	`type`: String, 
	t: String, 
	active: String, 
	a: String, 
	pool_size: String, 
	psz: String, 
	queue: String, 
	q: String, 
	queue_size: String, 
	qs: String, 
	rejected: String, 
	r: String, 
	largest: String, 
	l: String, 
	completed: String, 
	c: String, 
	core: String, 
	cr: String, 
	max: String, 
	mx: String, 
	size: String, 
	sz: String, 
	keep_alive: String, 
	ka: String
)

@JsonCodec case class CatTrainedModelsRequest(
	model_id: Id, 
	allow_no_match: Boolean, 
	bytes: Bytes, 
	from: integer, 
	size: integer
) extends CatCatRequestBase
type CatTrainedModelsResponse = Seq[CatTrainedModelsTrainedModelsRecord]

@JsonCodec case class CatTrainedModelsTrainedModelsRecord(
	id: Id, 
	created_by: String, 
	c: String, 
	createdBy: String, 
	heap_size: ByteSize, 
	hs: ByteSize, 
	modelHeapSize: ByteSize, 
	operations: String, 
	o: String, 
	modelOperations: String, 
	license: String, 
	l: String, 
	create_time: DateString, 
	ct: DateString, 
	version: VersionString, 
	v: VersionString, 
	description: String, 
	d: String, 
	`ingest.pipelines`: String, 
	ip: String, 
	ingestPipelines: String, 
	`ingest.count`: String, 
	ic: String, 
	ingestCount: String, 
	`ingest.time`: String, 
	it: String, 
	ingestTime: String, 
	`ingest.current`: String, 
	icurr: String, 
	ingestCurrent: String, 
	`ingest.failed`: String, 
	`if`: String, 
	ingestFailed: String, 
	`data_frame.id`: String, 
	dfid: String, 
	dataFrameAnalytics: String, 
	`data_frame.create_time`: String, 
	dft: String, 
	dataFrameAnalyticsTime: String, 
	`data_frame.source_index`: String, 
	dfsi: String, 
	dataFrameAnalyticsSrcIndex: String, 
	`data_frame.analysis`: String, 
	dfa: String, 
	dataFrameAnalyticsAnalysis: String
)

@JsonCodec case class CatTransformsRequest(
	transform_id: Id, 
	allow_no_match: Boolean, 
	from: integer, 
	size: integer
) extends CatCatRequestBase
type CatTransformsResponse = Seq[CatTransformsTransformsRecord]

@JsonCodec case class CatTransformsTransformsRecord(
	id: Id, 
	state: String, 
	s: String, 
	checkpoint: String, 
	c: String, 
	documents_processed: String, 
	docp: String, 
	documentsProcessed: String, 
	checkpoint_progress: String, 
	cp: String, 
	checkpointProgress: String, 
	last_search_time: String, 
	lst: String, 
	lastSearchTime: String, 
	changes_last_detection_time: String, 
	cldt: String, 
	create_time: String, 
	ct: String, 
	createTime: String, 
	version: VersionString, 
	v: VersionString, 
	source_index: String, 
	si: String, 
	sourceIndex: String, 
	dest_index: String, 
	di: String, 
	destIndex: String, 
	pipeline: String, 
	p: String, 
	description: String, 
	d: String, 
	transform_type: String, 
	tt: String, 
	frequency: String, 
	f: String, 
	max_page_search_size: String, 
	mpsz: String, 
	docs_per_second: String, 
	dps: String, 
	reason: String, 
	r: String, 
	search_total: String, 
	st: String, 
	search_failure: String, 
	sf: String, 
	search_time: String, 
	stime: String, 
	index_total: String, 
	it: String, 
	index_failure: String, 
	`if`: String, 
	index_time: String, 
	itime: String, 
	documents_indexed: String, 
	doci: String, 
	delete_time: String, 
	dtime: String, 
	documents_deleted: String, 
	docd: String, 
	trigger_count: String, 
	tc: String, 
	pages_processed: String, 
	pp: String, 
	processing_time: String, 
	pt: String, 
	checkpoint_duration_time_exp_avg: String, 
	cdtea: String, 
	checkpointTimeExpAvg: String, 
	indexed_documents_exp_avg: String, 
	idea: String, 
	processed_documents_exp_avg: String, 
	pdea: String
)

@JsonCodec case class CcrFollowIndexStats(
	index: IndexName, 
	shards: Seq[CcrShardStats]
)

@JsonCodec case class CcrReadException(
	exception: ErrorCause, 
	from_seq_no: SequenceNumber, 
	retries: integer
)

@JsonCodec case class CcrShardStats(
	bytes_read: long, 
	failed_read_requests: long, 
	failed_write_requests: long, 
	fatal_exception: ErrorCause, 
	follower_aliases_version: VersionNumber, 
	follower_global_checkpoint: long, 
	follower_index: String, 
	follower_mapping_version: VersionNumber, 
	follower_max_seq_no: SequenceNumber, 
	follower_settings_version: VersionNumber, 
	last_requested_seq_no: SequenceNumber, 
	leader_global_checkpoint: long, 
	leader_index: String, 
	leader_max_seq_no: SequenceNumber, 
	operations_read: long, 
	operations_written: long, 
	outstanding_read_requests: integer, 
	outstanding_write_requests: integer, 
	read_exceptions: Seq[CcrReadException], 
	remote_cluster: String, 
	shard_id: integer, 
	successful_read_requests: long, 
	successful_write_requests: long, 
	time_since_last_read_millis: EpochMillis, 
	total_read_remote_exec_time_millis: EpochMillis, 
	total_read_time_millis: EpochMillis, 
	total_write_time_millis: EpochMillis, 
	write_buffer_operation_count: long, 
	write_buffer_size_in_bytes: ByteSize
)

@JsonCodec case class CcrCreateFollowIndexRequest(
	index: IndexName, 
	wait_for_active_shards: WaitForActiveShards, 
	body: Body
) extends RequestBase

object CcrCreateFollowIndexRequest {
	@JsonCodec case class Body(
		leader_index: IndexName, 
		max_outstanding_read_requests: long, 
		max_outstanding_write_requests: long, 
		max_read_request_operation_count: long, 
		max_read_request_size: String, 
		max_retry_delay: Time, 
		max_write_buffer_count: long, 
		max_write_buffer_size: String, 
		max_write_request_operation_count: long, 
		max_write_request_size: String, 
		read_poll_timeout: Time, 
		remote_cluster: String
	)
}


@JsonCodec case class CcrCreateFollowIndexResponse(
	follow_index_created: Boolean, 
	follow_index_shards_acked: Boolean, 
	index_following_started: Boolean
)

@JsonCodec case class CcrDeleteAutoFollowPatternRequest(
	name: Name
) extends RequestBase

@JsonCodec case class CcrDeleteAutoFollowPatternResponse extends AcknowledgedResponseBase

@JsonCodec case class CcrFollowIndexStatsRequest(
	index: Indices
) extends RequestBase

@JsonCodec case class CcrFollowIndexStatsResponse(
	indices: Seq[CcrFollowIndexStats]
)

@JsonCodec case class CcrFollowInfoFollowerIndex(
	follower_index: IndexName, 
	leader_index: IndexName, 
	parameters: CcrFollowInfoFollowerIndexParameters, 
	remote_cluster: Name, 
	status: CcrFollowInfoFollowerIndexStatus
)

@JsonCodec case class CcrFollowInfoFollowerIndexParameters(
	max_outstanding_read_requests: integer, 
	max_outstanding_write_requests: integer, 
	max_read_request_operation_count: integer, 
	max_read_request_size: String, 
	max_retry_delay: Time, 
	max_write_buffer_count: integer, 
	max_write_buffer_size: String, 
	max_write_request_operation_count: integer, 
	max_write_request_size: String, 
	read_poll_timeout: Time
)
type CcrFollowInfoFollowerIndexStatus = "active"" | "paused""

@JsonCodec case class CcrFollowInfoRequest(
	index: Indices
) extends RequestBase

@JsonCodec case class CcrFollowInfoResponse(
	follower_indices: Seq[CcrFollowInfoFollowerIndex]
)

@JsonCodec case class CcrForgetFollowerIndexRequest(
	index: IndexName, 
	body: Body
) extends RequestBase

object CcrForgetFollowerIndexRequest {
	@JsonCodec case class Body(
		follower_cluster: String, 
		follower_index: IndexName, 
		follower_index_uuid: Uuid, 
		leader_remote_cluster: String
	)
}


@JsonCodec case class CcrForgetFollowerIndexResponse(
	_shards: ShardStatistics
)

@JsonCodec case class CcrGetAutoFollowPatternAutoFollowPattern(
	name: Name, 
	pattern: CcrGetAutoFollowPatternAutoFollowPatternSummary
)

@JsonCodec case class CcrGetAutoFollowPatternAutoFollowPatternSummary(
	active: Boolean, 
	remote_cluster: String, 
	follow_index_pattern: IndexPattern, 
	leader_index_patterns: IndexPatterns, 
	max_outstanding_read_requests: integer
)

@JsonCodec case class CcrGetAutoFollowPatternRequest(
	name: Name
) extends RequestBase

@JsonCodec case class CcrGetAutoFollowPatternResponse(
	patterns: Seq[CcrGetAutoFollowPatternAutoFollowPattern]
)

@JsonCodec case class CcrPauseAutoFollowPatternRequest(
	name: Name
) extends RequestBase

@JsonCodec case class CcrPauseAutoFollowPatternResponse extends AcknowledgedResponseBase

@JsonCodec case class CcrPauseFollowIndexRequest(
	index: IndexName
) extends RequestBase

@JsonCodec case class CcrPauseFollowIndexResponse extends AcknowledgedResponseBase

@JsonCodec case class CcrPutAutoFollowPatternRequest(
	name: Name, 
	body: Body
) extends RequestBase

object CcrPutAutoFollowPatternRequest {
	@JsonCodec case class Body(
		remote_cluster: String, 
		follow_index_pattern: IndexPattern, 
		leader_index_patterns: IndexPatterns, 
		max_outstanding_read_requests: integer, 
		settings: Record[String, Any], 
		max_outstanding_write_requests: integer, 
		read_poll_timeout: Time, 
		max_read_request_operation_count: integer, 
		max_read_request_size: ByteSize, 
		max_retry_delay: Time, 
		max_write_buffer_count: integer, 
		max_write_buffer_size: ByteSize, 
		max_write_request_operation_count: integer, 
		max_write_request_size: ByteSize
	)
}


@JsonCodec case class CcrPutAutoFollowPatternResponse extends AcknowledgedResponseBase

@JsonCodec case class CcrResumeAutoFollowPatternRequest(
	name: Name
) extends RequestBase

@JsonCodec case class CcrResumeAutoFollowPatternResponse extends AcknowledgedResponseBase

@JsonCodec case class CcrResumeFollowIndexRequest(
	index: IndexName, 
	body: Body
) extends RequestBase

object CcrResumeFollowIndexRequest {
	@JsonCodec case class Body(
		max_outstanding_read_requests: long, 
		max_outstanding_write_requests: long, 
		max_read_request_operation_count: long, 
		max_read_request_size: String, 
		max_retry_delay: Time, 
		max_write_buffer_count: long, 
		max_write_buffer_size: String, 
		max_write_request_operation_count: long, 
		max_write_request_size: String, 
		read_poll_timeout: Time
	)
}


@JsonCodec case class CcrResumeFollowIndexResponse extends AcknowledgedResponseBase

@JsonCodec case class CcrStatsAutoFollowStats(
	auto_followed_clusters: Seq[CcrStatsAutoFollowedCluster], 
	number_of_failed_follow_indices: long, 
	number_of_failed_remote_cluster_state_requests: long, 
	number_of_successful_follow_indices: long, 
	recent_auto_follow_errors: Seq[ErrorCause]
)

@JsonCodec case class CcrStatsAutoFollowedCluster(
	cluster_name: Name, 
	last_seen_metadata_version: VersionNumber, 
	time_since_last_check_millis: DateString
)

@JsonCodec case class CcrStatsFollowStats(
	indices: Seq[CcrFollowIndexStats]
)

@JsonCodec case class CcrStatsRequest extends RequestBase

@JsonCodec case class CcrStatsResponse(
	auto_follow_stats: CcrStatsAutoFollowStats, 
	follow_stats: CcrStatsFollowStats
)

@JsonCodec case class CcrUnfollowIndexRequest(
	index: IndexName
) extends RequestBase

@JsonCodec case class CcrUnfollowIndexResponse extends AcknowledgedResponseBase

@JsonCodec case class ClusterClusterStateBlockIndex(
	description: String, 
	retryable: Boolean, 
	levels: Seq[String], 
	aliases: Seq[IndexAlias], 
	aliases_version: VersionNumber, 
	version: VersionNumber, 
	mapping_version: VersionNumber, 
	settings_version: VersionNumber, 
	routing_num_shards: VersionNumber, 
	state: String, 
	settings: Record[IndexName, IndicesIndexSettings], 
	in_sync_allocations: Record[String, Seq[String]], 
	primary_terms: Record[String, integer], 
	mappings: Record[String, MappingTypeMapping], 
	rollover_info: Record[String, IndicesRolloverRolloverConditions], 
	timestamp_range: Record[String, Any], 
	system: Boolean
)

@JsonCodec case class ClusterClusterStateDeletedSnapshots(
	snapshot_deletions: Seq[String]
)

@JsonCodec case class ClusterClusterStateIndexLifecycle(
	policies: Record[IndexName, ClusterClusterStateIndexLifecycleSummary], 
	operation_mode: LifecycleOperationMode
)

@JsonCodec case class ClusterClusterStateIndexLifecyclePolicy(
	phases: IlmPhases
)

@JsonCodec case class ClusterClusterStateIndexLifecycleSummary(
	policy: ClusterClusterStateIndexLifecyclePolicy, 
	headers: HttpHeaders, 
	version: VersionNumber, 
	modified_date: long, 
	modified_date_string: DateString
)

@JsonCodec case class ClusterClusterStateIngest(
	pipeline: Seq[ClusterClusterStateIngestPipeline]
)

@JsonCodec case class ClusterClusterStateIngestPipeline(
	id: Id, 
	config: ClusterClusterStateIngestPipelineConfig
)

@JsonCodec case class ClusterClusterStateIngestPipelineConfig(
	description: String, 
	version: VersionNumber, 
	processors: Seq[IngestProcessorContainer]
)

@JsonCodec case class ClusterClusterStateMetadata(
	cluster_uuid: Uuid, 
	cluster_uuid_committed: Boolean, 
	templates: ClusterClusterStateMetadataTemplate, 
	indices: Record[IndexName, ClusterClusterStateBlockIndex], 
	`index-graveyard`: ClusterClusterStateMetadataIndexGraveyard, 
	cluster_coordination: ClusterClusterStateMetadataClusterCoordination, 
	ingest: ClusterClusterStateIngest, 
	repositories: Record[String, String], 
	component_template: Record[String, Any], 
	index_template: Record[String, Any], 
	index_lifecycle: ClusterClusterStateIndexLifecycle
)

@JsonCodec case class ClusterClusterStateMetadataClusterCoordination(
	term: integer, 
	last_committed_config: Seq[String], 
	last_accepted_config: Seq[String], 
	voting_config_exclusions: Seq[ClusterVotingConfigExclusionsItem]
)

@JsonCodec case class ClusterClusterStateMetadataIndexGraveyard(
	tombstones: Seq[ClusterTombstone]
)

@JsonCodec sealed trait ClusterClusterStateMetadataTemplate

@JsonCodec case class ClusterClusterStateRoutingNodes(
	unassigned: Seq[NodeShard], 
	nodes: Record[String, Seq[NodeShard]]
)

@JsonCodec case class ClusterClusterStateSnapshots(
	snapshots: Seq[SnapshotStatus]
)
type ClusterClusterStatus = "green"" | "yellow"" | "red""

@JsonCodec case class ClusterComponentTemplate(
	name: Name, 
	component_template: ClusterComponentTemplateNode
)

@JsonCodec case class ClusterComponentTemplateNode(
	template: ClusterComponentTemplateSummary, 
	version: VersionNumber, 
	_meta: Metadata
)

@JsonCodec case class ClusterComponentTemplateSummary(
	_meta: Metadata, 
	version: VersionNumber, 
	settings: Record[IndexName, IndicesIndexSettings], 
	mappings: MappingTypeMapping, 
	aliases: Record[String, IndicesAliasDefinition]
)

@JsonCodec case class ClusterTombstone(
	index: ClusterTombstoneIndex, 
	delete_date: DateString, 
	delete_date_in_millis: long
)

@JsonCodec case class ClusterTombstoneIndex(
	index_name: Name, 
	index_uuid: Uuid
)

@JsonCodec case class ClusterVotingConfigExclusionsItem(
	node_id: Id, 
	node_name: Name
)

@JsonCodec case class ClusterAllocationExplainAllocationDecision(
	decider: String, 
	decision: ClusterAllocationExplainAllocationExplainDecision, 
	explanation: String
)
type ClusterAllocationExplainAllocationExplainDecision = "NO"" | "YES"" | "THROTTLE"" | "ALWAYS""

@JsonCodec case class ClusterAllocationExplainAllocationStore(
	allocation_id: String, 
	found: Boolean, 
	in_sync: Boolean, 
	matching_size_in_bytes: long, 
	matching_sync_id: Boolean, 
	store_exception: String
)

@JsonCodec case class ClusterAllocationExplainClusterInfo(
	nodes: Record[String, ClusterAllocationExplainNodeDiskUsage], 
	shard_sizes: Record[String, long], 
	shard_data_set_sizes: Record[String, String], 
	shard_paths: Record[String, String], 
	reserved_sizes: Seq[ClusterAllocationExplainReservedSize]
)

@JsonCodec case class ClusterAllocationExplainCurrentNode(
	id: Id, 
	name: Name, 
	attributes: Record[String, String], 
	transport_address: TransportAddress, 
	weight_ranking: integer
)
type ClusterAllocationExplainDecision = "yes"" | "no"" | "worse_balance"" | "throttled"" | "awaiting_info"" | "allocation_delayed"" | "no_valid_shard_copy"" | "no_attempt""

@JsonCodec case class ClusterAllocationExplainDiskUsage(
	path: String, 
	total_bytes: long, 
	used_bytes: long, 
	free_bytes: long, 
	free_disk_percent: double, 
	used_disk_percent: double
)

@JsonCodec case class ClusterAllocationExplainNodeAllocationExplanation(
	deciders: Seq[ClusterAllocationExplainAllocationDecision], 
	node_attributes: Record[String, String], 
	node_decision: ClusterAllocationExplainDecision, 
	node_id: Id, 
	node_name: Name, 
	store: ClusterAllocationExplainAllocationStore, 
	transport_address: TransportAddress, 
	weight_ranking: integer
)

@JsonCodec case class ClusterAllocationExplainNodeDiskUsage(
	node_name: Name, 
	least_available: ClusterAllocationExplainDiskUsage, 
	most_available: ClusterAllocationExplainDiskUsage
)

@JsonCodec case class ClusterAllocationExplainRequest(
	include_disk_info: Boolean, 
	include_yes_decisions: Boolean, 
	body: Body
) extends RequestBase

object ClusterAllocationExplainRequest {
	@JsonCodec case class Body(
		current_node: String, 
		index: IndexName, 
		primary: Boolean, 
		shard: integer
	)
}


@JsonCodec case class ClusterAllocationExplainReservedSize(
	node_id: Id, 
	path: String, 
	total: long, 
	shards: Seq[String]
)

@JsonCodec case class ClusterAllocationExplainResponse(
	allocate_explanation: String, 
	allocation_delay: String, 
	allocation_delay_in_millis: long, 
	can_allocate: ClusterAllocationExplainDecision, 
	can_move_to_other_node: ClusterAllocationExplainDecision, 
	can_rebalance_cluster: ClusterAllocationExplainDecision, 
	can_rebalance_cluster_decisions: Seq[ClusterAllocationExplainAllocationDecision], 
	can_rebalance_to_other_node: ClusterAllocationExplainDecision, 
	can_remain_decisions: Seq[ClusterAllocationExplainAllocationDecision], 
	can_remain_on_current_node: ClusterAllocationExplainDecision, 
	cluster_info: ClusterAllocationExplainClusterInfo, 
	configured_delay: String, 
	configured_delay_in_millis: long, 
	current_node: ClusterAllocationExplainCurrentNode, 
	current_state: String, 
	index: IndexName, 
	move_explanation: String, 
	node_allocation_decisions: Seq[ClusterAllocationExplainNodeAllocationExplanation], 
	primary: Boolean, 
	rebalance_explanation: String, 
	remaining_delay: String, 
	remaining_delay_in_millis: long, 
	shard: integer, 
	unassigned_info: ClusterAllocationExplainUnassignedInformation
)

@JsonCodec case class ClusterAllocationExplainUnassignedInformation(
	at: DateString, 
	last_allocation_status: String, 
	reason: ClusterAllocationExplainUnassignedInformationReason, 
	details: String, 
	failed_allocation_attempts: integer, 
	delayed: Boolean, 
	allocation_status: String
)
type ClusterAllocationExplainUnassignedInformationReason = "INDEX_CREATED"" | "CLUSTER_RECOVERED"" | "INDEX_REOPENED"" | "DANGLING_INDEX_IMPORTED"" | "NEW_INDEX_RESTORED"" | "EXISTING_INDEX_RESTORED"" | "REPLICA_ADDED"" | "ALLOCATION_FAILED"" | "NODE_LEFT"" | "REROUTE_CANCELLED"" | "REINITIALIZED"" | "REALLOCATED_REPLICA"" | "PRIMARY_FAILED"" | "FORCED_EMPTY_PRIMARY"" | "MANUAL_ALLOCATION""

@JsonCodec case class ClusterDeleteComponentTemplateRequest(
	name: Name, 
	master_timeout: Time, 
	timeout: Time
) extends RequestBase

@JsonCodec case class ClusterDeleteComponentTemplateResponse extends AcknowledgedResponseBase

@JsonCodec case class ClusterDeleteVotingConfigExclusionsRequest(
	body: Body
) extends RequestBase

object ClusterDeleteVotingConfigExclusionsRequest {
	@JsonCodec case class Body(
		stub: String
	)
}


@JsonCodec case class ClusterDeleteVotingConfigExclusionsResponse(
	stub: integer
)

@JsonCodec case class ClusterExistsComponentTemplateRequest(
	stub_a: String, 
	stub_b: String, 
	body: Body
) extends RequestBase

object ClusterExistsComponentTemplateRequest {
	@JsonCodec case class Body(
		stub_c: String
	)
}


@JsonCodec case class ClusterExistsComponentTemplateResponse(
	stub: integer
)

@JsonCodec case class ClusterGetComponentTemplateRequest(
	name: Name, 
	flat_settings: Boolean, 
	local: Boolean, 
	master_timeout: Time
) extends RequestBase

@JsonCodec case class ClusterGetComponentTemplateResponse(
	component_templates: Seq[ClusterComponentTemplate]
)

@JsonCodec case class ClusterGetSettingsRequest(
	flat_settings: Boolean, 
	include_defaults: Boolean, 
	master_timeout: Time, 
	timeout: Time
) extends RequestBase

@JsonCodec case class ClusterGetSettingsResponse(
	persistent: Record[String, Any], 
	transient: Record[String, Any], 
	defaults: Record[String, Any]
)

@JsonCodec case class ClusterHealthIndexHealthStats(
	active_primary_shards: integer, 
	active_shards: integer, 
	initializing_shards: integer, 
	number_of_replicas: integer, 
	number_of_shards: integer, 
	relocating_shards: integer, 
	shards: Record[String, ClusterHealthShardHealthStats], 
	status: Health, 
	unassigned_shards: integer
)

@JsonCodec case class ClusterHealthRequest(
	index: Indices, 
	expand_wildcards: ExpandWildcards, 
	level: Level, 
	local: Boolean, 
	master_timeout: Time, 
	timeout: Time, 
	wait_for_active_shards: WaitForActiveShards, 
	wait_for_events: WaitForEvents, 
	wait_for_nodes: String, 
	wait_for_no_initializing_shards: Boolean, 
	wait_for_no_relocating_shards: Boolean, 
	wait_for_status: WaitForStatus
) extends RequestBase

@JsonCodec case class ClusterHealthResponse(
	active_primary_shards: integer, 
	active_shards: integer, 
	active_shards_percent_as_number: Percentage, 
	cluster_name: String, 
	delayed_unassigned_shards: integer, 
	indices: Record[IndexName, ClusterHealthIndexHealthStats], 
	initializing_shards: integer, 
	number_of_data_nodes: integer, 
	number_of_in_flight_fetch: integer, 
	number_of_nodes: integer, 
	number_of_pending_tasks: integer, 
	relocating_shards: integer, 
	status: Health, 
	task_max_waiting_in_queue_millis: EpochMillis, 
	timed_out: Boolean, 
	unassigned_shards: integer
)

@JsonCodec case class ClusterHealthShardHealthStats(
	active_shards: integer, 
	initializing_shards: integer, 
	primary_active: Boolean, 
	relocating_shards: integer, 
	status: Health, 
	unassigned_shards: integer
)

@JsonCodec case class ClusterPendingTasksPendingTask(
	insert_order: integer, 
	priority: String, 
	source: String, 
	time_in_queue: String, 
	time_in_queue_millis: integer
)

@JsonCodec case class ClusterPendingTasksRequest(
	local: Boolean, 
	master_timeout: Time
) extends RequestBase

@JsonCodec case class ClusterPendingTasksResponse(
	tasks: Seq[ClusterPendingTasksPendingTask]
)

@JsonCodec case class ClusterPutComponentTemplateRequest(
	name: Name, 
	create: Boolean, 
	master_timeout: Time, 
	body: Body
) extends RequestBase

object ClusterPutComponentTemplateRequest {
	@JsonCodec case class Body(
		template: IndicesIndexState, 
		aliases: Record[String, IndicesAliasDefinition], 
		mappings: MappingTypeMapping, 
		settings: IndicesIndexSettings, 
		version: VersionNumber, 
		_meta: Metadata
	)
}


@JsonCodec case class ClusterPutComponentTemplateResponse extends AcknowledgedResponseBase

@JsonCodec case class ClusterPutSettingsRequest(
	flat_settings: Boolean, 
	master_timeout: Time, 
	timeout: Time, 
	body: Body
) extends RequestBase

object ClusterPutSettingsRequest {
	@JsonCodec case class Body(
		persistent: Record[String, Any], 
		transient: Record[String, Any]
	)
}


@JsonCodec case class ClusterPutSettingsResponse(
	acknowledged: Boolean, 
	persistent: Record[String, Any], 
	transient: Record[String, Any]
)

@JsonCodec case class ClusterPutVotingConfigExclusionsRequest(
	node_names: Names, 
	node_ids: Ids, 
	timeout: Time, 
	wait_for_removal: Boolean
) extends RequestBase

@JsonCodec case class ClusterPutVotingConfigExclusionsResponse(
	stub: integer
)

@JsonCodec case class ClusterRemoteInfoClusterRemoteInfo(
	connected: Boolean, 
	initial_connect_timeout: Time, 
	max_connections_per_cluster: integer, 
	num_nodes_connected: long, 
	seeds: Seq[String], 
	skip_unavailable: Boolean
)

@JsonCodec case class ClusterRemoteInfoRequest(
	body: Body
) extends RequestBase

object ClusterRemoteInfoRequest {
	@JsonCodec case class Body(
		stub: String
	)
}


@JsonCodec case class ClusterRemoteInfoResponse extends DictionaryResponseBase[String, ClusterRemoteInfoClusterRemoteInfo]

@JsonCodec case class ClusterRerouteCommand(
	cancel: ClusterRerouteCommandCancelAction, 
	move: ClusterRerouteCommandMoveAction, 
	allocate_replica: ClusterRerouteCommandAllocateReplicaAction, 
	allocate_stale_primary: ClusterRerouteCommandAllocatePrimaryAction, 
	allocate_empty_primary: ClusterRerouteCommandAllocatePrimaryAction
)

@JsonCodec case class ClusterRerouteCommandAllocatePrimaryAction(
	index: IndexName, 
	shard: integer, 
	node: String, 
	accept_data_loss: Boolean
)

@JsonCodec case class ClusterRerouteCommandAllocateReplicaAction(
	index: IndexName, 
	shard: integer, 
	node: String
)

@JsonCodec case class ClusterRerouteCommandCancelAction(
	index: IndexName, 
	shard: integer, 
	node: String, 
	allow_primary: Boolean
)

@JsonCodec case class ClusterRerouteCommandMoveAction(
	index: IndexName, 
	shard: integer, 
	from_node: String, 
	to_node: String
)

@JsonCodec case class ClusterRerouteRequest(
	dry_run: Boolean, 
	explain: Boolean, 
	metric: Metrics, 
	retry_failed: Boolean, 
	master_timeout: Time, 
	timeout: Time, 
	body: Body
) extends RequestBase

object ClusterRerouteRequest {
	@JsonCodec case class Body(
		commands: Seq[ClusterRerouteCommand]
	)
}


@JsonCodec case class ClusterRerouteRerouteDecision(
	decider: String, 
	decision: String, 
	explanation: String
)

@JsonCodec case class ClusterRerouteRerouteExplanation(
	command: String, 
	decisions: Seq[ClusterRerouteRerouteDecision], 
	parameters: ClusterRerouteRerouteParameters
)

@JsonCodec case class ClusterRerouteRerouteParameters(
	allow_primary: Boolean, 
	index: IndexName, 
	node: NodeName, 
	shard: integer, 
	from_node: NodeName, 
	to_node: NodeName
)

@JsonCodec case class ClusterRerouteRerouteState(
	cluster_uuid: Uuid, 
	state_uuid: Uuid, 
	master_node: String, 
	version: VersionNumber, 
	blocks: EmptyObject, 
	nodes: Record[NodeName, NodeAttributes], 
	routing_table: Record[String, EmptyObject], 
	routing_nodes: ClusterClusterStateRoutingNodes, 
	security_tokens: Record[String, String], 
	snapshots: ClusterClusterStateSnapshots, 
	snapshot_deletions: ClusterClusterStateDeletedSnapshots, 
	metadata: ClusterClusterStateMetadata
)

@JsonCodec case class ClusterRerouteResponse(
	explanations: Seq[ClusterRerouteRerouteExplanation], 
	state: ClusterRerouteRerouteState
) extends AcknowledgedResponseBase

@JsonCodec case class ClusterStateClusterStateBlocks(
	indices: Record[IndexName, Record[String, ClusterClusterStateBlockIndex]]
)

@JsonCodec case class ClusterStateRequest(
	metric: Metrics, 
	index: Indices, 
	allow_no_indices: Boolean, 
	expand_wildcards: ExpandWildcards, 
	flat_settings: Boolean, 
	ignore_unavailable: Boolean, 
	local: Boolean, 
	master_timeout: Time, 
	wait_for_metadata_version: VersionNumber, 
	wait_for_timeout: Time
) extends RequestBase

@JsonCodec case class ClusterStateResponse(
	cluster_name: Name, 
	cluster_uuid: Uuid, 
	master_node: String, 
	state: Seq[String], 
	state_uuid: Uuid, 
	version: VersionNumber, 
	blocks: ClusterStateClusterStateBlocks, 
	metadata: ClusterClusterStateMetadata, 
	nodes: Record[NodeName, NodeAttributes], 
	routing_table: Record[String, EmptyObject], 
	routing_nodes: ClusterClusterStateRoutingNodes, 
	snapshots: ClusterClusterStateSnapshots, 
	snapshot_deletions: ClusterClusterStateDeletedSnapshots
)

@JsonCodec case class ClusterStatsCharFilterTypes(
	char_filter_types: Seq[ClusterStatsFieldTypes], 
	tokenizer_types: Seq[ClusterStatsFieldTypes], 
	filter_types: Seq[ClusterStatsFieldTypes], 
	analyzer_types: Seq[ClusterStatsFieldTypes], 
	built_in_char_filters: Seq[ClusterStatsFieldTypes], 
	built_in_tokenizers: Seq[ClusterStatsFieldTypes], 
	built_in_filters: Seq[ClusterStatsFieldTypes], 
	built_in_analyzers: Seq[ClusterStatsFieldTypes]
)

@JsonCodec case class ClusterStatsClusterFileSystem(
	available_in_bytes: long, 
	free_in_bytes: long, 
	total_in_bytes: long
)

@JsonCodec case class ClusterStatsClusterIndices(
	completion: CompletionStats, 
	count: long, 
	docs: DocStats, 
	fielddata: FielddataStats, 
	query_cache: QueryCacheStats, 
	segments: SegmentsStats, 
	shards: ClusterStatsClusterIndicesShards, 
	store: StoreStats, 
	mappings: ClusterStatsFieldTypesMappings, 
	analysis: ClusterStatsCharFilterTypes, 
	versions: Seq[ClusterStatsIndicesVersions]
)

@JsonCodec case class ClusterStatsClusterIndicesShards(
	index: ClusterStatsClusterIndicesShardsIndex, 
	primaries: double, 
	replication: double, 
	total: double
)

@JsonCodec case class ClusterStatsClusterIndicesShardsIndex(
	primaries: ClusterStatsClusterShardMetrics, 
	replication: ClusterStatsClusterShardMetrics, 
	shards: ClusterStatsClusterShardMetrics
)

@JsonCodec case class ClusterStatsClusterIngest(
	number_of_pipelines: integer, 
	processor_stats: Record[String, ClusterStatsClusterProcessor]
)

@JsonCodec case class ClusterStatsClusterJvm(
	max_uptime_in_millis: long, 
	mem: ClusterStatsClusterJvmMemory, 
	threads: long, 
	versions: Seq[ClusterStatsClusterJvmVersion]
)

@JsonCodec case class ClusterStatsClusterJvmMemory(
	heap_max_in_bytes: long, 
	heap_used_in_bytes: long
)

@JsonCodec case class ClusterStatsClusterJvmVersion(
	bundled_jdk: Boolean, 
	count: integer, 
	using_bundled_jdk: Boolean, 
	version: VersionString, 
	vm_name: String, 
	vm_vendor: String, 
	vm_version: VersionString
)

@JsonCodec case class ClusterStatsClusterNetworkTypes(
	http_types: Record[String, integer], 
	transport_types: Record[String, integer]
)

@JsonCodec case class ClusterStatsClusterNodeCount(
	coordinating_only: integer, 
	data: integer, 
	ingest: integer, 
	master: integer, 
	total: integer, 
	voting_only: integer, 
	data_cold: integer, 
	data_frozen: integer, 
	data_content: integer, 
	data_warm: integer, 
	data_hot: integer, 
	ml: integer, 
	remote_cluster_client: integer, 
	transform: integer
)

@JsonCodec case class ClusterStatsClusterNodes(
	count: ClusterStatsClusterNodeCount, 
	discovery_types: Record[String, integer], 
	fs: ClusterStatsClusterFileSystem, 
	ingest: ClusterStatsClusterIngest, 
	jvm: ClusterStatsClusterJvm, 
	network_types: ClusterStatsClusterNetworkTypes, 
	os: ClusterStatsClusterOperatingSystem, 
	packaging_types: Seq[ClusterStatsNodePackagingType], 
	plugins: Seq[PluginStats], 
	process: ClusterStatsClusterProcess, 
	versions: Seq[VersionString]
)

@JsonCodec case class ClusterStatsClusterOperatingSystem(
	allocated_processors: integer, 
	available_processors: integer, 
	mem: ClusterStatsOperatingSystemMemoryInfo, 
	names: Seq[ClusterStatsClusterOperatingSystemName], 
	pretty_names: Seq[ClusterStatsClusterOperatingSystemName], 
	architectures: Seq[ClusterStatsClusterOperatingSystemArchitecture]
)

@JsonCodec case class ClusterStatsClusterOperatingSystemArchitecture(
	count: integer, 
	arch: String
)

@JsonCodec case class ClusterStatsClusterOperatingSystemName(
	count: integer, 
	name: Name
)

@JsonCodec case class ClusterStatsClusterProcess(
	cpu: ClusterStatsClusterProcessCpu, 
	open_file_descriptors: ClusterStatsClusterProcessOpenFileDescriptors
)

@JsonCodec case class ClusterStatsClusterProcessCpu(
	percent: integer
)

@JsonCodec case class ClusterStatsClusterProcessOpenFileDescriptors(
	avg: long, 
	max: long, 
	min: long
)

@JsonCodec case class ClusterStatsClusterProcessor(
	count: long, 
	current: long, 
	failed: long, 
	time_in_millis: long
)

@JsonCodec case class ClusterStatsClusterShardMetrics(
	avg: double, 
	max: double, 
	min: double
)

@JsonCodec case class ClusterStatsFieldTypes(
	name: Name, 
	count: integer, 
	index_count: integer, 
	script_count: integer
)

@JsonCodec case class ClusterStatsFieldTypesMappings(
	field_types: Seq[ClusterStatsFieldTypes], 
	runtime_field_types: Seq[ClusterStatsRuntimeFieldTypes]
)

@JsonCodec case class ClusterStatsIndicesVersions(
	index_count: integer, 
	primary_shard_count: integer, 
	total_primary_bytes: long, 
	version: VersionString
)

@JsonCodec case class ClusterStatsNodePackagingType(
	count: integer, 
	flavor: String, 
	`type`: String
)

@JsonCodec case class ClusterStatsOperatingSystemMemoryInfo(
	free_in_bytes: long, 
	free_percent: integer, 
	total_in_bytes: long, 
	used_in_bytes: long, 
	used_percent: integer
)

@JsonCodec case class ClusterStatsRequest(
	node_id: NodeIds, 
	flat_settings: Boolean, 
	timeout: Time
) extends RequestBase

@JsonCodec case class ClusterStatsResponse(
	cluster_name: Name, 
	cluster_uuid: Uuid, 
	indices: ClusterStatsClusterIndices, 
	nodes: ClusterStatsClusterNodes, 
	status: ClusterClusterStatus, 
	timestamp: long
) extends NodesNodesResponseBase

@JsonCodec case class ClusterStatsRuntimeFieldTypes(
	name: Name, 
	count: integer, 
	index_count: integer, 
	scriptless_count: integer, 
	shadowed_count: integer, 
	lang: Seq[String], 
	lines_max: integer, 
	lines_total: integer, 
	chars_max: integer, 
	chars_total: integer, 
	source_max: integer, 
	source_total: integer, 
	doc_max: integer, 
	doc_total: integer
)

@JsonCodec case class DanglingIndicesIndexDeleteRequest(
	stub_a: String, 
	stub_b: String, 
	body: Body
) extends RequestBase

object DanglingIndicesIndexDeleteRequest {
	@JsonCodec case class Body(
		stub_c: String
	)
}


@JsonCodec case class DanglingIndicesIndexDeleteResponse(
	stub: integer
)

@JsonCodec case class DanglingIndicesIndexImportRequest(
	stub_a: String, 
	stub_b: String, 
	body: Body
) extends RequestBase

object DanglingIndicesIndexImportRequest {
	@JsonCodec case class Body(
		stub_c: String
	)
}


@JsonCodec case class DanglingIndicesIndexImportResponse(
	stub: integer
)

@JsonCodec case class DanglingIndicesIndicesListRequest(
	stub_a: String, 
	stub_b: String, 
	body: Body
) extends RequestBase

object DanglingIndicesIndicesListRequest {
	@JsonCodec case class Body(
		stub_c: String
	)
}


@JsonCodec case class DanglingIndicesIndicesListResponse(
	stub: integer
)

@JsonCodec case class EnrichConfiguration(
	geo_match: EnrichPolicy, 
	`match`: EnrichPolicy
)

@JsonCodec case class EnrichPolicy(
	enrich_fields: Fields, 
	indices: Indices, 
	match_field: Field, 
	query: String, 
	name: Name
)

@JsonCodec case class EnrichSummary(
	config: EnrichConfiguration
)

@JsonCodec case class EnrichDeletePolicyRequest(
	name: Name
) extends RequestBase

@JsonCodec case class EnrichDeletePolicyResponse extends AcknowledgedResponseBase
type EnrichExecutePolicyEnrichPolicyPhase = "SCHEDULED"" | "RUNNING"" | "COMPLETE"" | "FAILED""

@JsonCodec case class EnrichExecutePolicyExecuteEnrichPolicyStatus(
	phase: EnrichExecutePolicyEnrichPolicyPhase
)

@JsonCodec case class EnrichExecutePolicyRequest(
	name: Name, 
	wait_for_completion: Boolean
) extends RequestBase

@JsonCodec case class EnrichExecutePolicyResponse(
	status: EnrichExecutePolicyExecuteEnrichPolicyStatus, 
	task_id: TaskId
)

@JsonCodec case class EnrichGetPolicyRequest(
	name: Names
) extends RequestBase

@JsonCodec case class EnrichGetPolicyResponse(
	policies: Seq[EnrichSummary]
)

@JsonCodec case class EnrichPutPolicyRequest(
	name: Name, 
	body: Body
) extends RequestBase

object EnrichPutPolicyRequest {
	@JsonCodec case class Body(
		geo_match: EnrichPolicy, 
		`match`: EnrichPolicy
	)
}


@JsonCodec case class EnrichPutPolicyResponse extends AcknowledgedResponseBase

@JsonCodec case class EnrichStatsCoordinatorStats(
	executed_searches_total: long, 
	node_id: Id, 
	queue_size: integer, 
	remote_requests_current: integer, 
	remote_requests_total: long
)

@JsonCodec case class EnrichStatsExecutingPolicy(
	name: Name, 
	task: TaskInfo
)

@JsonCodec case class EnrichStatsRequest extends RequestBase

@JsonCodec case class EnrichStatsResponse(
	coordinator_stats: Seq[EnrichStatsCoordinatorStats], 
	executing_policies: Seq[EnrichStatsExecutingPolicy]
)

@JsonCodec case class EqlEqlHits[TEvent = None](
	total: SearchTotalHits, 
	events: Seq[EqlHitsEvent[TEvent]], 
	sequences: Seq[EqlHitsSequence[TEvent]]
)

@JsonCodec case class EqlEqlSearchResponseBase[TEvent = None](
	id: Id, 
	is_partial: Boolean, 
	is_running: Boolean, 
	took: integer, 
	timed_out: Boolean, 
	hits: EqlEqlHits[TEvent]
)

@JsonCodec case class EqlHitsEvent[TEvent = None](
	_index: IndexName, 
	_id: Id, 
	_source: TEvent, 
	fields: Record[Field, Seq[Any]]
)

@JsonCodec case class EqlHitsSequence[TEvent = None](
	events: Seq[EqlHitsEvent[TEvent]], 
	join_keys: Seq[Any]
)

@JsonCodec case class EqlDeleteRequest(
	id: Id
) extends RequestBase

@JsonCodec case class EqlDeleteResponse extends AcknowledgedResponseBase

@JsonCodec case class EqlGetRequest(
	id: Id, 
	keep_alive: Time, 
	wait_for_completion_timeout: Time
) extends RequestBase

@JsonCodec case class EqlGetResponse[TEvent = None] extends EqlEqlSearchResponseBase[TEvent]

@JsonCodec case class EqlGetStatusRequest(
	id: Id
) extends RequestBase

@JsonCodec case class EqlGetStatusResponse(
	id: Id, 
	is_partial: Boolean, 
	is_running: Boolean, 
	start_time_in_millis: EpochMillis, 
	expiration_time_in_millis: EpochMillis, 
	completion_status: integer
)

@JsonCodec case class EqlSearchRequest(
	index: IndexName, 
	allow_no_indices: Boolean, 
	expand_wildcards: ExpandWildcards, 
	ignore_unavailable: Boolean, 
	keep_alive: Time, 
	keep_on_completion: Boolean, 
	wait_for_completion_timeout: Time, 
	body: Body
) extends RequestBase

object EqlSearchRequest {
	@JsonCodec case class Body(
		query: String, 
		case_sensitive: Boolean, 
		event_category_field: Field, 
		tiebreaker_field: Field, 
		timestamp_field: Field, 
		fetch_size: uint, 
		filter: QueryDslQueryContainer | Seq[QueryDslQueryContainer], 
		keep_alive: Time, 
		keep_on_completion: Boolean, 
		wait_for_completion_timeout: Time, 
		size: uint | float, 
		fields: Seq[Field | EqlSearchSearchFieldFormatted], 
		result_position: EqlSearchResultPosition
	)
}


@JsonCodec case class EqlSearchResponse[TEvent = None] extends EqlEqlSearchResponseBase[TEvent]
type EqlSearchResultPosition = "tail"" | "head""

@JsonCodec case class EqlSearchSearchFieldFormatted(
	field: Field, 
	format: String
)

@JsonCodec case class FeaturesGetFeaturesRequest(
	stub_a: String, 
	stub_b: String, 
	body: Body
) extends RequestBase

object FeaturesGetFeaturesRequest {
	@JsonCodec case class Body(
		stub_c: String
	)
}


@JsonCodec case class FeaturesGetFeaturesResponse(
	stub: integer
)

@JsonCodec case class FeaturesResetFeaturesRequest(
	stub_a: String, 
	stub_b: String, 
	body: Body
) extends RequestBase

object FeaturesResetFeaturesRequest {
	@JsonCodec case class Body(
		stub_c: String
	)
}


@JsonCodec case class FeaturesResetFeaturesResponse(
	stub: integer
)

@JsonCodec case class GraphConnection(
	doc_count: long, 
	source: long, 
	target: long, 
	weight: double
)

@JsonCodec case class GraphExploreControls(
	sample_diversity: GraphSampleDiversity, 
	sample_size: integer, 
	timeout: Time, 
	use_significance: Boolean
)

@JsonCodec case class GraphHop(
	connections: GraphHop, 
	query: QueryDslQueryContainer, 
	vertices: Seq[GraphVertexDefinition]
)

@JsonCodec case class GraphSampleDiversity(
	field: Field, 
	max_docs_per_value: integer
)

@JsonCodec case class GraphVertex(
	depth: long, 
	field: Field, 
	term: String, 
	weight: double
)

@JsonCodec case class GraphVertexDefinition(
	exclude: Seq[String], 
	field: Field, 
	include: Seq[GraphVertexInclude], 
	min_doc_count: long, 
	shard_min_doc_count: long, 
	size: integer
)

@JsonCodec case class GraphVertexInclude(
	boost: double, 
	term: String
)

@JsonCodec case class GraphExploreRequest(
	index: Indices, 
	`type`: Types, 
	routing: Routing, 
	timeout: Time, 
	body: Body
) extends RequestBase

object GraphExploreRequest {
	@JsonCodec case class Body(
		connections: GraphHop, 
		controls: GraphExploreControls, 
		query: QueryDslQueryContainer, 
		vertices: Seq[GraphVertexDefinition]
	)
}


@JsonCodec case class GraphExploreResponse(
	connections: Seq[GraphConnection], 
	failures: Seq[ShardFailure], 
	timed_out: Boolean, 
	took: long, 
	vertices: Seq[GraphVertex]
)

@JsonCodec sealed trait IlmAction

@JsonCodec case class IlmPhase(
	actions: Record[String, IlmAction] | Seq[String], 
	min_age: Time
)

@JsonCodec case class IlmPhases(
	cold: IlmPhase, 
	delete: IlmPhase, 
	hot: IlmPhase, 
	warm: IlmPhase
)

@JsonCodec case class IlmPolicy(
	phases: IlmPhases, 
	name: Name
)

@JsonCodec case class IlmDeleteLifecycleRequest(
	policy: Name, 
	policy_id: Id
) extends RequestBase

@JsonCodec case class IlmDeleteLifecycleResponse extends AcknowledgedResponseBase

@JsonCodec case class IlmExplainLifecycleLifecycleExplain(
	action: Name, 
	action_time_millis: EpochMillis, 
	age: Time, 
	failed_step: Name, 
	failed_step_retry_count: integer, 
	index: IndexName, 
	is_auto_retryable_error: Boolean, 
	lifecycle_date_millis: EpochMillis, 
	managed: Boolean, 
	phase: Name, 
	phase_time_millis: EpochMillis, 
	policy: Name, 
	step: Name, 
	step_info: Record[String, Any], 
	step_time_millis: EpochMillis, 
	phase_execution: IlmExplainLifecycleLifecycleExplainPhaseExecution
)

@JsonCodec case class IlmExplainLifecycleLifecycleExplainPhaseExecution(
	policy: Name, 
	version: VersionNumber, 
	modified_date_in_millis: EpochMillis
)

@JsonCodec case class IlmExplainLifecycleLifecycleExplainProject(
	project: IlmExplainLifecycleLifecycleExplainProjectSummary
)

@JsonCodec case class IlmExplainLifecycleLifecycleExplainProjectSummary(
	index: IndexName, 
	managed: Boolean
)

@JsonCodec case class IlmExplainLifecycleRequest(
	index: IndexName, 
	only_errors: Boolean, 
	only_managed: Boolean
) extends RequestBase

@JsonCodec case class IlmExplainLifecycleResponse(
	indices: Record[IndexName, IlmExplainLifecycleLifecycleExplain] | IlmExplainLifecycleLifecycleExplainProject
)

@JsonCodec case class IlmGetLifecycleLifecycle(
	modified_date: DateString, 
	policy: IlmPolicy, 
	version: VersionNumber
)

@JsonCodec case class IlmGetLifecycleRequest(
	policy: Name, 
	policy_id: Id
) extends RequestBase

@JsonCodec case class IlmGetLifecycleResponse extends DictionaryResponseBase[String, IlmGetLifecycleLifecycle]

@JsonCodec case class IlmGetStatusRequest extends RequestBase

@JsonCodec case class IlmGetStatusResponse(
	operation_mode: LifecycleOperationMode
)

@JsonCodec case class IlmMoveToStepRequest(
	index: IndexName, 
	body: Body
) extends RequestBase

object IlmMoveToStepRequest {
	@JsonCodec case class Body(
		current_step: IlmMoveToStepStepKey, 
		next_step: IlmMoveToStepStepKey
	)
}


@JsonCodec case class IlmMoveToStepResponse extends AcknowledgedResponseBase

@JsonCodec case class IlmMoveToStepStepKey(
	action: String, 
	name: String, 
	phase: String
)

@JsonCodec case class IlmPutLifecycleRequest(
	policy: Name, 
	policy_id: Id, 
	body: Body
) extends RequestBase

object IlmPutLifecycleRequest {
	@JsonCodec case class Body(
		policy: IlmPolicy
	)
}


@JsonCodec case class IlmPutLifecycleResponse extends AcknowledgedResponseBase

@JsonCodec case class IlmRemovePolicyRequest(
	index: IndexName
) extends RequestBase

@JsonCodec case class IlmRemovePolicyResponse(
	failed_indexes: Seq[IndexName], 
	has_failures: Boolean
)

@JsonCodec case class IlmRetryRequest(
	index: IndexName
) extends RequestBase

@JsonCodec case class IlmRetryResponse extends AcknowledgedResponseBase

@JsonCodec case class IlmStartRequest(
	body: Body
) extends RequestBase

object IlmStartRequest {
	@JsonCodec case class Body(
		stub: Boolean
	)
}


@JsonCodec case class IlmStartResponse extends AcknowledgedResponseBase

@JsonCodec case class IlmStopRequest(
	body: Body
) extends RequestBase

object IlmStopRequest {
	@JsonCodec case class Body(
		stub: Boolean
	)
}


@JsonCodec case class IlmStopResponse extends AcknowledgedResponseBase

@JsonCodec case class IndicesAlias(
	filter: QueryDslQueryContainer, 
	index_routing: Routing, 
	is_hidden: Boolean, 
	is_write_index: Boolean, 
	routing: Routing, 
	search_routing: Routing
)

@JsonCodec case class IndicesAliasDefinition(
	filter: QueryDslQueryContainer, 
	index_routing: String, 
	is_write_index: Boolean, 
	routing: String, 
	search_routing: String
)
type IndicesDataStreamHealthStatus = "GREEN"" | "green"" | "YELLOW"" | "yellow"" | "RED"" | "red""

@JsonCodec case class IndicesFielddataFrequencyFilter(
	max: double, 
	min: double, 
	min_segment_size: integer
)
type IndicesIndexCheckOnStartup = "false"" | "checksum"" | "true""

@JsonCodec case class IndicesIndexRouting(
	allocation: IndicesIndexRoutingAllocation, 
	rebalance: IndicesIndexRoutingRebalance
)

@JsonCodec case class IndicesIndexRoutingAllocation(
	enable: IndicesIndexRoutingAllocationOptions, 
	include: IndicesIndexRoutingAllocationInclude, 
	initial_recovery: IndicesIndexRoutingAllocationInitialRecovery, 
	disk: IndicesIndexRoutingAllocationDisk
)

@JsonCodec case class IndicesIndexRoutingAllocationDisk(
	threshold_enabled: Boolean | String
)

@JsonCodec case class IndicesIndexRoutingAllocationInclude(
	_tier_preference: String, 
	_id: Id
)

@JsonCodec case class IndicesIndexRoutingAllocationInitialRecovery(
	_id: Id
)
type IndicesIndexRoutingAllocationOptions = "all"" | "primaries"" | "new_primaries"" | "none""

@JsonCodec case class IndicesIndexRoutingRebalance(
	enable: IndicesIndexRoutingRebalanceOptions
)
type IndicesIndexRoutingRebalanceOptions = "all"" | "primaries"" | "replicas"" | "none""

@JsonCodec case class IndicesIndexSettingBlocks(
	read_only: Boolean, 
	`index.blocks.read_only`: Boolean, 
	read_only_allow_delete: Boolean, 
	`index.blocks.read_only_allow_delete`: Boolean, 
	read: Boolean, 
	`index.blocks.read`: Boolean, 
	write: Boolean | String, 
	`index.blocks.write`: Boolean | String, 
	metadata: Boolean, 
	`index.blocks.metadata`: Boolean
)

@JsonCodec case class IndicesIndexSettings(
	number_of_shards: integer | String, 
	`index.number_of_shards`: integer | String, 
	number_of_replicas: integer | String, 
	`index.number_of_replicas`: integer | String, 
	number_of_routing_shards: integer, 
	`index.number_of_routing_shards`: integer, 
	check_on_startup: IndicesIndexCheckOnStartup, 
	`index.check_on_startup`: IndicesIndexCheckOnStartup, 
	codec: String, 
	`index.codec`: String, 
	routing_partition_size: integer | String, 
	`index.routing_partition_size`: integer | String, 
	`soft_deletes.retention_lease.period`: Time, 
	`index.soft_deletes.retention_lease.period`: Time, 
	load_fixed_bitset_filters_eagerly: Boolean, 
	`index.load_fixed_bitset_filters_eagerly`: Boolean, 
	hidden: Boolean | String, 
	`index.hidden`: Boolean | String, 
	auto_expand_replicas: String, 
	`index.auto_expand_replicas`: String, 
	`search.idle.after`: Time, 
	`index.search.idle.after`: Time, 
	refresh_interval: Time, 
	`index.refresh_interval`: Time, 
	max_result_window: integer, 
	`index.max_result_window`: integer, 
	max_inner_result_window: integer, 
	`index.max_inner_result_window`: integer, 
	max_rescore_window: integer, 
	`index.max_rescore_window`: integer, 
	max_docvalue_fields_search: integer, 
	`index.max_docvalue_fields_search`: integer, 
	max_script_fields: integer, 
	`index.max_script_fields`: integer, 
	max_ngram_diff: integer, 
	`index.max_ngram_diff`: integer, 
	max_shingle_diff: integer, 
	`index.max_shingle_diff`: integer, 
	blocks: IndicesIndexSettingBlocks, 
	`index.blocks`: IndicesIndexSettingBlocks, 
	max_refresh_listeners: integer, 
	`index.max_refresh_listeners`: integer, 
	`analyze.max_token_count`: integer, 
	`index.analyze.max_token_count`: integer, 
	`highlight.max_analyzed_offset`: integer, 
	`index.highlight.max_analyzed_offset`: integer, 
	max_terms_count: integer, 
	`index.max_terms_count`: integer, 
	max_regex_length: integer, 
	`index.max_regex_length`: integer, 
	routing: IndicesIndexRouting, 
	`index.routing`: IndicesIndexRouting, 
	gc_deletes: Time, 
	`index.gc_deletes`: Time, 
	default_pipeline: PipelineName, 
	`index.default_pipeline`: PipelineName, 
	final_pipeline: PipelineName, 
	`index.final_pipeline`: PipelineName, 
	lifecycle: IndicesIndexSettingsLifecycle, 
	`index.lifecycle`: IndicesIndexSettingsLifecycle, 
	provided_name: Name, 
	`index.provided_name`: Name, 
	creation_date: DateString, 
	`index.creation_date`: DateString, 
	uuid: Uuid, 
	`index.uuid`: Uuid, 
	version: IndicesIndexVersioning, 
	`index.version`: IndicesIndexVersioning, 
	verified_before_close: Boolean | String, 
	`index.verified_before_close`: Boolean | String, 
	format: String | integer, 
	`index.format`: String | integer, 
	max_slices_per_scroll: integer, 
	`index.max_slices_per_scroll`: integer, 
	`translog.durability`: String, 
	`index.translog.durability`: String, 
	`query_string.lenient`: Boolean | String, 
	`index.query_string.lenient`: Boolean | String, 
	priority: integer | String, 
	`index.priority`: integer | String, 
	top_metrics_max_size: integer, 
	analysis: IndicesIndexSettingsAnalysis
)

@JsonCodec case class IndicesIndexSettingsAnalysis(
	char_filter: Record[String, AnalysisCharFilter]
)

@JsonCodec case class IndicesIndexSettingsLifecycle(
	name: Name
)

@JsonCodec case class IndicesIndexState(
	aliases: Record[IndexName, IndicesAlias], 
	mappings: MappingTypeMapping, 
	settings: IndicesIndexSettings | IndicesIndexStatePrefixedSettings
)

@JsonCodec case class IndicesIndexStatePrefixedSettings(
	index: IndicesIndexSettings
)

@JsonCodec case class IndicesIndexVersioning(
	created: VersionString
)

@JsonCodec case class IndicesNumericFielddata(
	format: IndicesNumericFielddataFormat
)
type IndicesNumericFielddataFormat = "array"" | "disabled""

@JsonCodec case class IndicesOverlappingIndexTemplate(
	name: Name, 
	index_patterns: Seq[IndexName]
)

@JsonCodec case class IndicesStringFielddata(
	format: IndicesStringFielddataFormat
)
type IndicesStringFielddataFormat = "paged_bytes"" | "disabled""

@JsonCodec case class IndicesTemplateMapping(
	aliases: Record[IndexName, IndicesAlias], 
	index_patterns: Seq[Name], 
	mappings: MappingTypeMapping, 
	order: integer, 
	settings: Record[String, Any], 
	version: VersionNumber
)
type IndicesAddBlockIndicesBlockOptions = "metadata"" | "read"" | "read_only"" | "write""

@JsonCodec case class IndicesAddBlockIndicesBlockStatus(
	name: IndexName, 
	blocked: Boolean
)

@JsonCodec case class IndicesAddBlockRequest(
	index: IndexName, 
	block: IndicesAddBlockIndicesBlockOptions, 
	allow_no_indices: Boolean, 
	expand_wildcards: ExpandWildcards, 
	ignore_unavailable: Boolean, 
	master_timeout: Time, 
	timeout: Time
) extends RequestBase

@JsonCodec case class IndicesAddBlockResponse(
	shards_acknowledged: Boolean, 
	indices: Seq[IndicesAddBlockIndicesBlockStatus]
) extends AcknowledgedResponseBase

@JsonCodec case class IndicesAnalyzeAnalyzeDetail(
	analyzer: IndicesAnalyzeAnalyzerDetail, 
	charfilters: Seq[IndicesAnalyzeCharFilterDetail], 
	custom_analyzer: Boolean, 
	tokenfilters: Seq[IndicesAnalyzeTokenDetail], 
	tokenizer: IndicesAnalyzeTokenDetail
)

@JsonCodec case class IndicesAnalyzeAnalyzeToken(
	end_offset: long, 
	position: long, 
	position_length: long, 
	start_offset: long, 
	token: String, 
	`type`: String
)

@JsonCodec case class IndicesAnalyzeAnalyzerDetail(
	name: String, 
	tokens: Seq[IndicesAnalyzeExplainAnalyzeToken]
)

@JsonCodec case class IndicesAnalyzeCharFilterDetail(
	filtered_text: Seq[String], 
	name: String
)

@JsonCodec case class IndicesAnalyzeExplainAnalyzeToken(
	bytes: String, 
	end_offset: long, 
	keyword: Boolean, 
	position: long, 
	positionLength: long, 
	start_offset: long, 
	termFrequency: long, 
	token: String, 
	`type`: String
)

@JsonCodec case class IndicesAnalyzeRequest(
	index: IndexName, 
	body: Body
) extends RequestBase

object IndicesAnalyzeRequest {
	@JsonCodec case class Body(
		analyzer: String, 
		attributes: Seq[String], 
		char_filter: Seq[String | AnalysisCharFilter], 
		explain: Boolean, 
		field: Field, 
		filter: Seq[String | AnalysisTokenFilter], 
		normalizer: String, 
		text: IndicesAnalyzeTextToAnalyze, 
		tokenizer: String | AnalysisTokenizer
	)
}


@JsonCodec case class IndicesAnalyzeResponse(
	detail: IndicesAnalyzeAnalyzeDetail, 
	tokens: Seq[IndicesAnalyzeAnalyzeToken]
)
type IndicesAnalyzeTextToAnalyze = String | Seq[String]

@JsonCodec case class IndicesAnalyzeTokenDetail(
	name: String, 
	tokens: Seq[IndicesAnalyzeExplainAnalyzeToken]
)

@JsonCodec case class IndicesClearCacheRequest(
	index: Indices, 
	allow_no_indices: Boolean, 
	expand_wildcards: ExpandWildcards, 
	fielddata: Boolean, 
	fields: Fields, 
	ignore_unavailable: Boolean, 
	query: Boolean, 
	request: Boolean
) extends RequestBase

@JsonCodec case class IndicesClearCacheResponse extends ShardsOperationResponseBase

@JsonCodec case class IndicesCloneRequest(
	index: IndexName, 
	target: Name, 
	master_timeout: Time, 
	timeout: Time, 
	wait_for_active_shards: WaitForActiveShards, 
	body: Body
) extends RequestBase

object IndicesCloneRequest {
	@JsonCodec case class Body(
		aliases: Record[IndexName, IndicesAlias], 
		settings: Record[String, Any]
	)
}


@JsonCodec case class IndicesCloneResponse(
	index: IndexName, 
	shards_acknowledged: Boolean
) extends AcknowledgedResponseBase

@JsonCodec case class IndicesCloseCloseIndexResult(
	closed: Boolean, 
	shards: Record[String, IndicesCloseCloseShardResult]
)

@JsonCodec case class IndicesCloseCloseShardResult(
	failures: Seq[ShardFailure]
)

@JsonCodec case class IndicesCloseRequest(
	index: Indices, 
	allow_no_indices: Boolean, 
	expand_wildcards: ExpandWildcards, 
	ignore_unavailable: Boolean, 
	master_timeout: Time, 
	timeout: Time, 
	wait_for_active_shards: WaitForActiveShards
) extends RequestBase

@JsonCodec case class IndicesCloseResponse(
	indices: Record[IndexName, IndicesCloseCloseIndexResult], 
	shards_acknowledged: Boolean
) extends AcknowledgedResponseBase

@JsonCodec case class IndicesCreateRequest(
	index: IndexName, 
	include_type_name: Boolean, 
	master_timeout: Time, 
	timeout: Time, 
	wait_for_active_shards: WaitForActiveShards, 
	body: Body
) extends RequestBase

object IndicesCreateRequest {
	@JsonCodec case class Body(
		aliases: Record[IndexName, IndicesAlias], 
		mappings: Record[String, MappingTypeMapping] | MappingTypeMapping, 
		settings: Record[String, Any]
	)
}


@JsonCodec case class IndicesCreateResponse(
	index: IndexName, 
	shards_acknowledged: Boolean
) extends AcknowledgedResponseBase

@JsonCodec case class IndicesCreateDataStreamRequest(
	name: DataStreamName
) extends RequestBase

@JsonCodec case class IndicesCreateDataStreamResponse extends AcknowledgedResponseBase

@JsonCodec case class IndicesDataStreamsStatsDataStreamsStatsItem(
	backing_indices: integer, 
	data_stream: Name, 
	store_size: ByteSize, 
	store_size_bytes: integer, 
	maximum_timestamp: integer
)

@JsonCodec case class IndicesDataStreamsStatsRequest(
	name: IndexName, 
	expand_wildcards: ExpandWildcards, 
	human: Boolean
) extends RequestBase

@JsonCodec case class IndicesDataStreamsStatsResponse(
	_shards: ShardStatistics, 
	backing_indices: integer, 
	data_stream_count: integer, 
	total_store_sizes: ByteSize, 
	total_store_size_bytes: integer, 
	data_streams: Seq[IndicesDataStreamsStatsDataStreamsStatsItem]
)

@JsonCodec case class IndicesDeleteRequest(
	index: Indices, 
	allow_no_indices: Boolean, 
	expand_wildcards: ExpandWildcards, 
	ignore_unavailable: Boolean, 
	master_timeout: Time, 
	timeout: Time
) extends RequestBase

@JsonCodec case class IndicesDeleteResponse extends IndicesResponseBase

@JsonCodec case class IndicesDeleteAliasRequest(
	index: Indices, 
	name: Names, 
	master_timeout: Time, 
	timeout: Time
) extends RequestBase

@JsonCodec case class IndicesDeleteAliasResponse extends AcknowledgedResponseBase

@JsonCodec case class IndicesDeleteDataStreamRequest(
	name: DataStreamName
) extends RequestBase

@JsonCodec case class IndicesDeleteDataStreamResponse extends AcknowledgedResponseBase

@JsonCodec case class IndicesDeleteIndexTemplateRequest(
	name: Name
) extends RequestBase

@JsonCodec case class IndicesDeleteIndexTemplateResponse extends AcknowledgedResponseBase

@JsonCodec case class IndicesDeleteTemplateRequest(
	name: Name, 
	master_timeout: Time, 
	timeout: Time
) extends RequestBase

@JsonCodec case class IndicesDeleteTemplateResponse extends AcknowledgedResponseBase

@JsonCodec case class IndicesExistsRequest(
	index: Indices, 
	allow_no_indices: Boolean, 
	expand_wildcards: ExpandWildcards, 
	flat_settings: Boolean, 
	ignore_unavailable: Boolean, 
	include_defaults: Boolean, 
	local: Boolean
) extends RequestBase
type IndicesExistsResponse = Boolean

@JsonCodec case class IndicesExistsAliasRequest(
	name: Names, 
	index: Indices, 
	allow_no_indices: Boolean, 
	expand_wildcards: ExpandWildcards, 
	ignore_unavailable: Boolean, 
	local: Boolean
) extends RequestBase
type IndicesExistsAliasResponse = Boolean

@JsonCodec case class IndicesExistsIndexTemplateRequest(
	name: Name, 
	master_timeout: Time
) extends RequestBase
type IndicesExistsIndexTemplateResponse = Boolean

@JsonCodec case class IndicesExistsTemplateRequest(
	name: Names, 
	flat_settings: Boolean, 
	local: Boolean, 
	master_timeout: Time
) extends RequestBase
type IndicesExistsTemplateResponse = Boolean

@JsonCodec case class IndicesExistsTypeRequest(
	index: Indices, 
	`type`: Types, 
	allow_no_indices: Boolean, 
	expand_wildcards: ExpandWildcards, 
	ignore_unavailable: Boolean, 
	local: Boolean
) extends RequestBase
type IndicesExistsTypeResponse = Boolean

@JsonCodec case class IndicesFlushRequest(
	index: Indices, 
	allow_no_indices: Boolean, 
	expand_wildcards: ExpandWildcards, 
	force: Boolean, 
	ignore_unavailable: Boolean, 
	wait_if_ongoing: Boolean
) extends RequestBase

@JsonCodec case class IndicesFlushResponse extends ShardsOperationResponseBase

@JsonCodec case class IndicesFlushSyncedRequest(
	index: Indices, 
	allow_no_indices: Boolean, 
	expand_wildcards: ExpandWildcards, 
	ignore_unavailable: Boolean
) extends RequestBase

@JsonCodec case class IndicesFlushSyncedResponse(
	_shards: ShardStatistics
) extends DictionaryResponseBase[IndexName, ShardStatistics]

@JsonCodec case class IndicesForcemergeRequest(
	index: Indices, 
	allow_no_indices: Boolean, 
	expand_wildcards: ExpandWildcards, 
	flush: Boolean, 
	ignore_unavailable: Boolean, 
	max_num_segments: long, 
	only_expunge_deletes: Boolean
) extends RequestBase

@JsonCodec case class IndicesForcemergeResponse extends ShardsOperationResponseBase

@JsonCodec case class IndicesFreezeRequest(
	index: IndexName, 
	allow_no_indices: Boolean, 
	expand_wildcards: ExpandWildcards, 
	ignore_unavailable: Boolean, 
	master_timeout: Time, 
	timeout: Time, 
	wait_for_active_shards: WaitForActiveShards
) extends RequestBase

@JsonCodec case class IndicesFreezeResponse(
	shards_acknowledged: Boolean
) extends AcknowledgedResponseBase

@JsonCodec case class IndicesGetRequest(
	index: Indices, 
	allow_no_indices: Boolean, 
	expand_wildcards: ExpandWildcards, 
	flat_settings: Boolean, 
	ignore_unavailable: Boolean, 
	include_defaults: Boolean, 
	include_type_name: Boolean, 
	local: Boolean, 
	master_timeout: Time
) extends RequestBase

@JsonCodec case class IndicesGetResponse extends DictionaryResponseBase[IndexName, IndicesIndexState]

@JsonCodec case class IndicesGetAliasIndexAliases(
	aliases: Record[String, IndicesAliasDefinition]
)

@JsonCodec case class IndicesGetAliasRequest(
	name: Names, 
	index: Indices, 
	allow_no_indices: Boolean, 
	expand_wildcards: ExpandWildcards, 
	ignore_unavailable: Boolean, 
	local: Boolean
) extends RequestBase

@JsonCodec case class IndicesGetAliasResponse extends DictionaryResponseBase[IndexName, IndicesGetAliasIndexAliases]

@JsonCodec case class IndicesGetDataStreamIndicesGetDataStreamItem(
	name: DataStreamName, 
	timestamp_field: IndicesGetDataStreamIndicesGetDataStreamItemTimestampField, 
	indices: Seq[IndicesGetDataStreamIndicesGetDataStreamItemIndex], 
	generation: integer, 
	template: Name, 
	hidden: Boolean, 
	system: Boolean, 
	status: IndicesDataStreamHealthStatus, 
	ilm_policy: Name, 
	_meta: Metadata
)

@JsonCodec case class IndicesGetDataStreamIndicesGetDataStreamItemIndex(
	index_name: IndexName, 
	index_uuid: Uuid
)

@JsonCodec case class IndicesGetDataStreamIndicesGetDataStreamItemTimestampField(
	name: Field
)

@JsonCodec case class IndicesGetDataStreamRequest(
	name: IndexName, 
	expand_wildcards: ExpandWildcards
) extends RequestBase

@JsonCodec case class IndicesGetDataStreamResponse(
	data_streams: Seq[IndicesGetDataStreamIndicesGetDataStreamItem]
)

@JsonCodec case class IndicesGetFieldMappingRequest(
	fields: Fields, 
	index: Indices, 
	`type`: Types, 
	allow_no_indices: Boolean, 
	expand_wildcards: ExpandWildcards, 
	ignore_unavailable: Boolean, 
	include_defaults: Boolean, 
	include_type_name: Boolean, 
	local: Boolean
) extends RequestBase

@JsonCodec case class IndicesGetFieldMappingResponse extends DictionaryResponseBase[IndexName, IndicesGetFieldMappingTypeFieldMappings]

@JsonCodec case class IndicesGetFieldMappingTypeFieldMappings(
	mappings: Record[Field, MappingFieldMapping]
)

@JsonCodec case class IndicesGetIndexTemplateIndexTemplate(
	index_patterns: Seq[Name], 
	composed_of: Seq[Name], 
	template: IndicesGetIndexTemplateIndexTemplateSummary, 
	version: VersionNumber, 
	priority: long, 
	_meta: Metadata, 
	allow_auto_create: Boolean, 
	data_stream: Record[String, Any]
)

@JsonCodec case class IndicesGetIndexTemplateIndexTemplateItem(
	name: Name, 
	index_template: IndicesGetIndexTemplateIndexTemplate
)

@JsonCodec case class IndicesGetIndexTemplateIndexTemplateSummary(
	aliases: Record[IndexName, IndicesAlias], 
	mappings: MappingTypeMapping, 
	settings: Record[String, Any]
)

@JsonCodec case class IndicesGetIndexTemplateRequest(
	name: Name, 
	local: Boolean, 
	body: Body
) extends RequestBase

object IndicesGetIndexTemplateRequest {
	@JsonCodec case class Body(
		flat_settings: Boolean, 
		include_type_name: Boolean, 
		master_timeout: Time
	)
}


@JsonCodec case class IndicesGetIndexTemplateResponse(
	index_templates: Seq[IndicesGetIndexTemplateIndexTemplateItem]
)

@JsonCodec case class IndicesGetMappingIndexMappingRecord(
	item: MappingTypeMapping, 
	mappings: MappingTypeMapping
)

@JsonCodec case class IndicesGetMappingRequest(
	index: Indices, 
	`type`: Types, 
	allow_no_indices: Boolean, 
	expand_wildcards: ExpandWildcards, 
	ignore_unavailable: Boolean, 
	include_type_name: Boolean, 
	local: Boolean, 
	master_timeout: Time
) extends RequestBase

@JsonCodec case class IndicesGetMappingResponse extends DictionaryResponseBase[IndexName, IndicesGetMappingIndexMappingRecord]

@JsonCodec case class IndicesGetSettingsRequest(
	index: Indices, 
	name: Names, 
	allow_no_indices: Boolean, 
	expand_wildcards: ExpandWildcards, 
	flat_settings: Boolean, 
	ignore_unavailable: Boolean, 
	include_defaults: Boolean, 
	local: Boolean, 
	master_timeout: Time
) extends RequestBase

@JsonCodec case class IndicesGetSettingsResponse extends DictionaryResponseBase[IndexName, IndicesIndexState]

@JsonCodec case class IndicesGetTemplateRequest(
	name: Names, 
	flat_settings: Boolean, 
	include_type_name: Boolean, 
	local: Boolean, 
	master_timeout: Time
) extends RequestBase

@JsonCodec case class IndicesGetTemplateResponse extends DictionaryResponseBase[String, IndicesTemplateMapping]

@JsonCodec case class IndicesGetUpgradeRequest(
	stub: String
) extends RequestBase

@JsonCodec case class IndicesGetUpgradeResponse(
	overlapping: Seq[IndicesOverlappingIndexTemplate], 
	template: IndicesTemplateMapping
)

@JsonCodec case class IndicesMigrateToDataStreamRequest(
	name: IndexName
) extends RequestBase

@JsonCodec case class IndicesMigrateToDataStreamResponse extends AcknowledgedResponseBase

@JsonCodec case class IndicesOpenRequest(
	index: Indices, 
	allow_no_indices: Boolean, 
	expand_wildcards: ExpandWildcards, 
	ignore_unavailable: Boolean, 
	master_timeout: Time, 
	timeout: Time, 
	wait_for_active_shards: WaitForActiveShards
) extends RequestBase

@JsonCodec case class IndicesOpenResponse(
	shards_acknowledged: Boolean
) extends AcknowledgedResponseBase

@JsonCodec case class IndicesPromoteDataStreamRequest(
	name: IndexName
) extends RequestBase

@JsonCodec case class IndicesPromoteDataStreamResponse(
	stub: integer
)

@JsonCodec case class IndicesPutAliasRequest(
	index: Indices, 
	name: Name, 
	master_timeout: Time, 
	timeout: Time, 
	body: Body
) extends RequestBase

object IndicesPutAliasRequest {
	@JsonCodec case class Body(
		filter: QueryDslQueryContainer, 
		index_routing: Routing, 
		is_write_index: Boolean, 
		routing: Routing, 
		search_routing: Routing
	)
}


@JsonCodec case class IndicesPutAliasResponse extends AcknowledgedResponseBase

@JsonCodec case class IndicesPutIndexTemplateIndexTemplateMapping(
	aliases: Record[IndexName, IndicesAlias], 
	mappings: MappingTypeMapping, 
	settings: IndicesIndexSettings
)

@JsonCodec case class IndicesPutIndexTemplateRequest(
	name: Name, 
	body: Body
) extends RequestBase

object IndicesPutIndexTemplateRequest {
	@JsonCodec case class Body(
		index_patterns: Indices, 
		composed_of: Seq[Name], 
		template: IndicesPutIndexTemplateIndexTemplateMapping, 
		data_stream: EmptyObject, 
		priority: integer, 
		version: VersionNumber, 
		_meta: Metadata
	)
}


@JsonCodec case class IndicesPutIndexTemplateResponse extends AcknowledgedResponseBase

@JsonCodec case class IndicesPutMappingRequest(
	index: Indices, 
	`type`: Type, 
	allow_no_indices: Boolean, 
	expand_wildcards: ExpandWildcards, 
	ignore_unavailable: Boolean, 
	include_type_name: Boolean, 
	master_timeout: Time, 
	timeout: Time, 
	write_index_only: Boolean, 
	body: Body
) extends RequestBase

object IndicesPutMappingRequest {
	@JsonCodec case class Body(
		all_field: MappingAllField, 
		date_detection: Boolean, 
		dynamic: Boolean | MappingDynamicMapping, 
		dynamic_date_formats: Seq[String], 
		dynamic_templates: Record[String, MappingDynamicTemplate] | Seq[Record[String, MappingDynamicTemplate]], 
		field_names_field: MappingFieldNamesField, 
		index_field: MappingIndexField, 
		meta: Record[String, Any], 
		numeric_detection: Boolean, 
		properties: Record[PropertyName, MappingProperty], 
		routing_field: MappingRoutingField, 
		size_field: MappingSizeField, 
		source_field: MappingSourceField, 
		runtime: MappingRuntimeFields
	)
}


@JsonCodec case class IndicesPutMappingResponse extends IndicesResponseBase

@JsonCodec case class IndicesPutSettingsIndexSettingsBody(
	settings: IndicesIndexSettings
) extends IndicesIndexSettings

@JsonCodec case class IndicesPutSettingsRequest(
	index: Indices, 
	allow_no_indices: Boolean, 
	expand_wildcards: ExpandWildcards, 
	flat_settings: Boolean, 
	ignore_unavailable: Boolean, 
	master_timeout: Time, 
	preserve_existing: Boolean, 
	timeout: Time, 
	body: IndicesPutSettingsIndexSettingsBody
) extends RequestBase

@JsonCodec case class IndicesPutSettingsResponse extends AcknowledgedResponseBase

@JsonCodec case class IndicesPutTemplateRequest(
	name: Name, 
	create: Boolean, 
	flat_settings: Boolean, 
	include_type_name: Boolean, 
	master_timeout: Time, 
	timeout: Time, 
	body: Body
) extends RequestBase

object IndicesPutTemplateRequest {
	@JsonCodec case class Body(
		aliases: Record[IndexName, IndicesAlias], 
		index_patterns: String | Seq[String], 
		mappings: MappingTypeMapping, 
		order: integer, 
		settings: Record[String, Any], 
		version: VersionNumber
	)
}


@JsonCodec case class IndicesPutTemplateResponse extends AcknowledgedResponseBase

@JsonCodec case class IndicesRecoveryFileDetails(
	length: long, 
	name: String, 
	recovered: long
)

@JsonCodec case class IndicesRecoveryRecoveryBytes(
	percent: Percentage, 
	recovered: ByteSize, 
	recovered_in_bytes: ByteSize, 
	reused: ByteSize, 
	reused_in_bytes: ByteSize, 
	total: ByteSize, 
	total_in_bytes: ByteSize
)

@JsonCodec case class IndicesRecoveryRecoveryFiles(
	details: Seq[IndicesRecoveryFileDetails], 
	percent: Percentage, 
	recovered: long, 
	reused: long, 
	total: long
)

@JsonCodec case class IndicesRecoveryRecoveryIndexStatus(
	bytes: IndicesRecoveryRecoveryBytes, 
	files: IndicesRecoveryRecoveryFiles, 
	size: IndicesRecoveryRecoveryBytes, 
	source_throttle_time: Time, 
	source_throttle_time_in_millis: EpochMillis, 
	target_throttle_time: Time, 
	target_throttle_time_in_millis: EpochMillis, 
	total_time_in_millis: EpochMillis, 
	total_time: Time
)

@JsonCodec case class IndicesRecoveryRecoveryOrigin(
	hostname: String, 
	host: Host, 
	transport_address: TransportAddress, 
	id: Id, 
	ip: Ip, 
	name: Name, 
	bootstrap_new_history_uuid: Boolean, 
	repository: Name, 
	snapshot: Name, 
	version: VersionString, 
	restoreUUID: Uuid, 
	index: IndexName
)

@JsonCodec case class IndicesRecoveryRecoveryStartStatus(
	check_index_time: long, 
	total_time_in_millis: String
)

@JsonCodec case class IndicesRecoveryRecoveryStatus(
	shards: Seq[IndicesRecoveryShardRecovery]
)

@JsonCodec case class IndicesRecoveryRequest(
	index: Indices, 
	active_only: Boolean, 
	detailed: Boolean
) extends RequestBase

@JsonCodec case class IndicesRecoveryResponse extends DictionaryResponseBase[IndexName, IndicesRecoveryRecoveryStatus]

@JsonCodec case class IndicesRecoveryShardRecovery(
	id: long, 
	index: IndicesRecoveryRecoveryIndexStatus, 
	primary: Boolean, 
	source: IndicesRecoveryRecoveryOrigin, 
	stage: String, 
	start: IndicesRecoveryRecoveryStartStatus, 
	start_time: DateString, 
	start_time_in_millis: EpochMillis, 
	stop_time: DateString, 
	stop_time_in_millis: EpochMillis, 
	target: IndicesRecoveryRecoveryOrigin, 
	total_time: DateString, 
	total_time_in_millis: EpochMillis, 
	translog: IndicesRecoveryTranslogStatus, 
	`type`: Type, 
	verify_index: IndicesRecoveryVerifyIndex
)

@JsonCodec case class IndicesRecoveryTranslogStatus(
	percent: Percentage, 
	recovered: long, 
	total: long, 
	total_on_start: long, 
	total_time: String, 
	total_time_in_millis: EpochMillis
)

@JsonCodec case class IndicesRecoveryVerifyIndex(
	check_index_time: Time, 
	check_index_time_in_millis: EpochMillis, 
	total_time: Time, 
	total_time_in_millis: EpochMillis
)

@JsonCodec case class IndicesRefreshRequest(
	index: Indices, 
	allow_no_indices: Boolean, 
	expand_wildcards: ExpandWildcards, 
	ignore_unavailable: Boolean
) extends RequestBase

@JsonCodec case class IndicesRefreshResponse extends ShardsOperationResponseBase

@JsonCodec case class IndicesReloadSearchAnalyzersReloadDetails(
	index: String, 
	reloaded_analyzers: Seq[String], 
	reloaded_node_ids: Seq[String]
)

@JsonCodec case class IndicesReloadSearchAnalyzersRequest(
	index: Indices, 
	allow_no_indices: Boolean, 
	expand_wildcards: ExpandWildcards, 
	ignore_unavailable: Boolean
) extends RequestBase

@JsonCodec case class IndicesReloadSearchAnalyzersResponse(
	reload_details: Seq[IndicesReloadSearchAnalyzersReloadDetails], 
	_shards: ShardStatistics
)

@JsonCodec case class IndicesResolveIndexRequest(
	name: Names, 
	expand_wildcards: ExpandWildcards
) extends RequestBase

@JsonCodec case class IndicesResolveIndexResolveIndexAliasItem(
	name: Name, 
	indices: Indices
)

@JsonCodec case class IndicesResolveIndexResolveIndexDataStreamsItem(
	name: DataStreamName, 
	timestamp_field: Field, 
	backing_indices: Indices
)

@JsonCodec case class IndicesResolveIndexResolveIndexItem(
	name: Name, 
	aliases: Seq[String], 
	attributes: Seq[String], 
	data_stream: DataStreamName
)

@JsonCodec case class IndicesResolveIndexResponse(
	indices: Seq[IndicesResolveIndexResolveIndexItem], 
	aliases: Seq[IndicesResolveIndexResolveIndexAliasItem], 
	data_streams: Seq[IndicesResolveIndexResolveIndexDataStreamsItem]
)

@JsonCodec case class IndicesRolloverRequest(
	alias: IndexAlias, 
	new_index: IndexName, 
	dry_run: Boolean, 
	include_type_name: Boolean, 
	master_timeout: Time, 
	timeout: Time, 
	wait_for_active_shards: WaitForActiveShards, 
	body: Body
) extends RequestBase

object IndicesRolloverRequest {
	@JsonCodec case class Body(
		aliases: Record[IndexName, IndicesAlias], 
		conditions: IndicesRolloverRolloverConditions, 
		mappings: Record[String, MappingTypeMapping] | MappingTypeMapping, 
		settings: Record[String, Any]
	)
}


@JsonCodec case class IndicesRolloverResponse(
	conditions: Record[String, Boolean], 
	dry_run: Boolean, 
	new_index: String, 
	old_index: String, 
	rolled_over: Boolean, 
	shards_acknowledged: Boolean
) extends AcknowledgedResponseBase

@JsonCodec case class IndicesRolloverRolloverConditions(
	max_age: Time, 
	max_docs: long, 
	max_size: String, 
	max_primary_shard_size: ByteSize
)

@JsonCodec case class IndicesSegmentsIndexSegment(
	shards: Record[String, IndicesSegmentsShardsSegment | Seq[IndicesSegmentsShardsSegment]]
)

@JsonCodec case class IndicesSegmentsRequest(
	index: Indices, 
	allow_no_indices: Boolean, 
	expand_wildcards: ExpandWildcards, 
	ignore_unavailable: Boolean, 
	verbose: Boolean
) extends RequestBase

@JsonCodec case class IndicesSegmentsResponse(
	indices: Record[String, IndicesSegmentsIndexSegment], 
	_shards: ShardStatistics
)

@JsonCodec case class IndicesSegmentsSegment(
	attributes: Record[String, String], 
	committed: Boolean, 
	compound: Boolean, 
	deleted_docs: long, 
	generation: integer, 
	memory_in_bytes: double, 
	search: Boolean, 
	size_in_bytes: double, 
	num_docs: long, 
	version: VersionString
)

@JsonCodec case class IndicesSegmentsShardSegmentRouting(
	node: String, 
	primary: Boolean, 
	state: String
)

@JsonCodec case class IndicesSegmentsShardsSegment(
	num_committed_segments: integer, 
	routing: IndicesSegmentsShardSegmentRouting, 
	num_search_segments: integer, 
	segments: Record[String, IndicesSegmentsSegment]
)

@JsonCodec case class IndicesShardStoresIndicesShardStores(
	shards: Record[String, IndicesShardStoresShardStoreWrapper]
)

@JsonCodec case class IndicesShardStoresRequest(
	index: Indices, 
	allow_no_indices: Boolean, 
	expand_wildcards: ExpandWildcards, 
	ignore_unavailable: Boolean, 
	status: String | Seq[String]
) extends RequestBase

@JsonCodec case class IndicesShardStoresResponse(
	indices: Record[IndexName, IndicesShardStoresIndicesShardStores]
)

@JsonCodec case class IndicesShardStoresShardStore(
	allocation: IndicesShardStoresShardStoreAllocation, 
	allocation_id: Id, 
	attributes: Record[String, Any], 
	id: Id, 
	legacy_version: VersionNumber, 
	name: Name, 
	store_exception: IndicesShardStoresShardStoreException, 
	transport_address: TransportAddress
)
type IndicesShardStoresShardStoreAllocation = "primary"" | "replica"" | "unused""

@JsonCodec case class IndicesShardStoresShardStoreException(
	reason: String, 
	`type`: String
)

@JsonCodec case class IndicesShardStoresShardStoreWrapper(
	stores: Seq[IndicesShardStoresShardStore]
)

@JsonCodec case class IndicesShrinkRequest(
	index: IndexName, 
	target: IndexName, 
	master_timeout: Time, 
	timeout: Time, 
	wait_for_active_shards: WaitForActiveShards, 
	body: Body
) extends RequestBase

object IndicesShrinkRequest {
	@JsonCodec case class Body(
		aliases: Record[IndexName, IndicesAlias], 
		settings: Record[String, Any]
	)
}


@JsonCodec case class IndicesShrinkResponse(
	shards_acknowledged: Boolean, 
	index: IndexName
) extends AcknowledgedResponseBase

@JsonCodec case class IndicesSimulateIndexTemplateRequest(
	name: Name, 
	body: Body
) extends RequestBase

object IndicesSimulateIndexTemplateRequest {
	@JsonCodec case class Body(
		index_patterns: Seq[IndexName], 
		composed_of: Seq[Name], 
		overlapping: Seq[IndicesOverlappingIndexTemplate], 
		template: IndicesTemplateMapping
	)
}


@JsonCodec sealed trait IndicesSimulateIndexTemplateResponse

@JsonCodec case class IndicesSimulateTemplateRequest(
	name: Name, 
	create: Boolean, 
	master_timeout: Time, 
	body: IndicesGetIndexTemplateIndexTemplate
) extends RequestBase

@JsonCodec case class IndicesSimulateTemplateResponse(
	stub: String
)

@JsonCodec case class IndicesSplitRequest(
	index: IndexName, 
	target: IndexName, 
	master_timeout: Time, 
	timeout: Time, 
	wait_for_active_shards: WaitForActiveShards, 
	body: Body
) extends RequestBase

object IndicesSplitRequest {
	@JsonCodec case class Body(
		aliases: Record[IndexName, IndicesAlias], 
		settings: Record[String, Any]
	)
}


@JsonCodec case class IndicesSplitResponse(
	shards_acknowledged: Boolean, 
	index: IndexName
) extends AcknowledgedResponseBase

@JsonCodec case class IndicesStatsIndexStats(
	completion: CompletionStats, 
	docs: DocStats, 
	fielddata: FielddataStats, 
	flush: FlushStats, 
	get: GetStats, 
	indexing: IndexingStats, 
	merges: MergesStats, 
	query_cache: QueryCacheStats, 
	recovery: RecoveryStats, 
	refresh: RefreshStats, 
	request_cache: RequestCacheStats, 
	search: SearchStats, 
	segments: SegmentsStats, 
	store: StoreStats, 
	translog: TranslogStats, 
	warmer: WarmerStats, 
	bulk: BulkStats
)

@JsonCodec case class IndicesStatsIndicesStats(
	primaries: IndicesStatsIndexStats, 
	shards: Record[String, Seq[IndicesStatsShardStats]], 
	total: IndicesStatsIndexStats, 
	uuid: Uuid
)

@JsonCodec case class IndicesStatsRequest(
	metric: Metrics, 
	index: Indices, 
	completion_fields: Fields, 
	expand_wildcards: ExpandWildcards, 
	fielddata_fields: Fields, 
	fields: Fields, 
	forbid_closed_indices: Boolean, 
	groups: String | Seq[String], 
	include_segment_file_sizes: Boolean, 
	include_unloaded_segments: Boolean, 
	level: Level, 
	types: Types
) extends RequestBase

@JsonCodec case class IndicesStatsResponse(
	indices: Record[String, IndicesStatsIndicesStats], 
	_shards: ShardStatistics, 
	_all: IndicesStatsIndicesStats
)

@JsonCodec case class IndicesStatsShardCommit(
	generation: integer, 
	id: Id, 
	num_docs: long, 
	user_data: Record[String, String]
)

@JsonCodec case class IndicesStatsShardFileSizeInfo(
	description: String, 
	size_in_bytes: long, 
	min_size_in_bytes: long, 
	max_size_in_bytes: long, 
	average_size_in_bytes: long, 
	count: long
)

@JsonCodec case class IndicesStatsShardLease(
	id: Id, 
	retaining_seq_no: SequenceNumber, 
	timestamp: long, 
	source: String
)

@JsonCodec case class IndicesStatsShardPath(
	data_path: String, 
	is_custom_data_path: Boolean, 
	state_path: String
)

@JsonCodec case class IndicesStatsShardQueryCache(
	cache_count: long, 
	cache_size: long, 
	evictions: long, 
	hit_count: long, 
	memory_size_in_bytes: long, 
	miss_count: long, 
	total_count: long
)

@JsonCodec case class IndicesStatsShardRetentionLeases(
	primary_term: long, 
	version: VersionNumber, 
	leases: Seq[IndicesStatsShardLease]
)

@JsonCodec case class IndicesStatsShardRouting(
	node: String, 
	primary: Boolean, 
	relocating_node: String, 
	state: IndicesStatsShardRoutingState
)
type IndicesStatsShardRoutingState = "UNASSIGNED"" | "INITIALIZING"" | "STARTED"" | "RELOCATING""

@JsonCodec case class IndicesStatsShardSequenceNumber(
	global_checkpoint: long, 
	local_checkpoint: long, 
	max_seq_no: SequenceNumber
)

@JsonCodec case class IndicesStatsShardStats(
	commit: IndicesStatsShardCommit, 
	completion: CompletionStats, 
	docs: DocStats, 
	fielddata: FielddataStats, 
	flush: FlushStats, 
	get: GetStats, 
	indexing: IndexingStats, 
	merges: MergesStats, 
	shard_path: IndicesStatsShardPath, 
	query_cache: IndicesStatsShardQueryCache, 
	recovery: RecoveryStats, 
	refresh: RefreshStats, 
	request_cache: RequestCacheStats, 
	retention_leases: IndicesStatsShardRetentionLeases, 
	routing: IndicesStatsShardRouting, 
	search: SearchStats, 
	segments: SegmentsStats, 
	seq_no: IndicesStatsShardSequenceNumber, 
	store: StoreStats, 
	translog: TranslogStats, 
	warmer: WarmerStats, 
	bulk: BulkStats
)

@JsonCodec case class IndicesUnfreezeRequest(
	index: IndexName, 
	allow_no_indices: Boolean, 
	expand_wildcards: ExpandWildcards, 
	ignore_unavailable: Boolean, 
	master_timeout: Time, 
	timeout: Time, 
	wait_for_active_shards: String
) extends RequestBase

@JsonCodec case class IndicesUnfreezeResponse(
	shards_acknowledged: Boolean
) extends AcknowledgedResponseBase

@JsonCodec sealed trait IndicesUpdateAliasesIndicesUpdateAliasBulk

@JsonCodec case class IndicesUpdateAliasesRequest(
	master_timeout: Time, 
	timeout: Time, 
	body: Body
) extends RequestBase

object IndicesUpdateAliasesRequest {
	@JsonCodec case class Body(
		actions: Seq[IndicesUpdateAliasesIndicesUpdateAliasBulk]
	)
}


@JsonCodec case class IndicesUpdateAliasesResponse extends AcknowledgedResponseBase

@JsonCodec case class IndicesUpgradeRequest(
	stub_b: integer, 
	stub_a: integer, 
	body: Body
) extends RequestBase

object IndicesUpgradeRequest {
	@JsonCodec case class Body(
		stub_c: integer
	)
}


@JsonCodec case class IndicesUpgradeResponse(
	stub: integer
)

@JsonCodec case class IndicesValidateQueryIndicesValidationExplanation(
	error: String, 
	explanation: String, 
	index: IndexName, 
	valid: Boolean
)

@JsonCodec case class IndicesValidateQueryRequest(
	index: Indices, 
	`type`: Types, 
	allow_no_indices: Boolean, 
	all_shards: Boolean, 
	analyzer: String, 
	analyze_wildcard: Boolean, 
	default_operator: DefaultOperator, 
	df: String, 
	expand_wildcards: ExpandWildcards, 
	explain: Boolean, 
	ignore_unavailable: Boolean, 
	lenient: Boolean, 
	query_on_query_string: String, 
	rewrite: Boolean, 
	q: String, 
	body: Body
) extends RequestBase

object IndicesValidateQueryRequest {
	@JsonCodec case class Body(
		query: QueryDslQueryContainer
	)
}


@JsonCodec case class IndicesValidateQueryResponse(
	explanations: Seq[IndicesValidateQueryIndicesValidationExplanation], 
	_shards: ShardStatistics, 
	valid: Boolean, 
	error: String
)

@JsonCodec case class IngestAppendProcessor(
	field: Field, 
	value: Seq[Any], 
	allow_duplicates: Boolean
) extends IngestProcessorBase

@JsonCodec case class IngestAttachmentProcessor(
	field: Field, 
	ignore_missing: Boolean, 
	indexed_chars: long, 
	indexed_chars_field: Field, 
	properties: Seq[String], 
	target_field: Field, 
	resource_name: String
) extends IngestProcessorBase

@JsonCodec case class IngestBytesProcessor(
	field: Field, 
	ignore_missing: Boolean, 
	target_field: Field
) extends IngestProcessorBase

@JsonCodec case class IngestCircleProcessor(
	error_distance: double, 
	field: Field, 
	ignore_missing: Boolean, 
	shape_type: IngestShapeType, 
	target_field: Field
) extends IngestProcessorBase

@JsonCodec case class IngestConvertProcessor(
	field: Field, 
	ignore_missing: Boolean, 
	target_field: Field, 
	`type`: IngestConvertType
) extends IngestProcessorBase
type IngestConvertType = "integer"" | "long"" | "float"" | "double"" | "string"" | "boolean"" | "auto""

@JsonCodec case class IngestCsvProcessor(
	empty_value: Any, 
	description: String, 
	field: Field, 
	ignore_missing: Boolean, 
	quote: String, 
	separator: String, 
	target_fields: Fields, 
	trim: Boolean
) extends IngestProcessorBase

@JsonCodec case class IngestDateIndexNameProcessor(
	date_formats: Seq[String], 
	date_rounding: String | IngestDateRounding, 
	field: Field, 
	index_name_format: String, 
	index_name_prefix: String, 
	locale: String, 
	timezone: String
) extends IngestProcessorBase

@JsonCodec case class IngestDateProcessor(
	field: Field, 
	formats: Seq[String], 
	locale: String, 
	target_field: Field, 
	timezone: String
) extends IngestProcessorBase
type IngestDateRounding = "s"" | "m"" | "h"" | "d"" | "w"" | "M"" | "y""

@JsonCodec case class IngestDissectProcessor(
	append_separator: String, 
	field: Field, 
	ignore_missing: Boolean, 
	pattern: String
) extends IngestProcessorBase

@JsonCodec case class IngestDotExpanderProcessor(
	field: Field, 
	path: String
) extends IngestProcessorBase

@JsonCodec case class IngestDropProcessor extends IngestProcessorBase

@JsonCodec case class IngestEnrichProcessor(
	field: Field, 
	ignore_missing: Boolean, 
	max_matches: integer, 
	`override`: Boolean, 
	policy_name: String, 
	shape_relation: GeoShapeRelation, 
	target_field: Field
) extends IngestProcessorBase

@JsonCodec case class IngestFailProcessor(
	message: String
) extends IngestProcessorBase

@JsonCodec case class IngestForeachProcessor(
	field: Field, 
	ignore_missing: Boolean, 
	processor: IngestProcessorContainer
) extends IngestProcessorBase

@JsonCodec case class IngestGeoIpProcessor(
	database_file: String, 
	field: Field, 
	first_only: Boolean, 
	ignore_missing: Boolean, 
	properties: Seq[String], 
	target_field: Field
) extends IngestProcessorBase

@JsonCodec case class IngestGrokProcessor(
	field: Field, 
	ignore_missing: Boolean, 
	pattern_definitions: Record[String, String], 
	patterns: Seq[String], 
	trace_match: Boolean
) extends IngestProcessorBase

@JsonCodec case class IngestGsubProcessor(
	field: Field, 
	ignore_missing: Boolean, 
	pattern: String, 
	replacement: String, 
	target_field: Field
) extends IngestProcessorBase

@JsonCodec case class IngestInferenceConfig(
	regression: IngestInferenceConfigRegression
)

@JsonCodec case class IngestInferenceConfigRegression(
	results_field: String
)

@JsonCodec case class IngestInferenceProcessor(
	model_id: Id, 
	target_field: Field, 
	field_map: Record[Field, Any], 
	inference_config: IngestInferenceConfig
) extends IngestProcessorBase

@JsonCodec case class IngestJoinProcessor(
	field: Field, 
	separator: String, 
	target_field: Field
) extends IngestProcessorBase

@JsonCodec case class IngestJsonProcessor(
	add_to_root: Boolean, 
	field: Field, 
	target_field: Field
) extends IngestProcessorBase

@JsonCodec case class IngestKeyValueProcessor(
	exclude_keys: Seq[String], 
	field: Field, 
	field_split: String, 
	ignore_missing: Boolean, 
	include_keys: Seq[String], 
	prefix: String, 
	strip_brackets: Boolean, 
	target_field: Field, 
	trim_key: String, 
	trim_value: String, 
	value_split: String
) extends IngestProcessorBase

@JsonCodec case class IngestLowercaseProcessor(
	field: Field, 
	ignore_missing: Boolean, 
	target_field: Field
) extends IngestProcessorBase

@JsonCodec case class IngestPipeline(
	description: String, 
	on_failure: Seq[IngestProcessorContainer], 
	processors: Seq[IngestProcessorContainer], 
	version: VersionNumber
)

@JsonCodec case class IngestPipelineConfig(
	description: String, 
	version: VersionNumber, 
	processors: Seq[IngestProcessorContainer]
)

@JsonCodec case class IngestPipelineProcessor(
	name: Name
) extends IngestProcessorBase

@JsonCodec case class IngestProcessorBase(
	`if`: String, 
	ignore_failure: Boolean, 
	on_failure: Seq[IngestProcessorContainer], 
	tag: String
)

@JsonCodec case class IngestProcessorContainer(
	attachment: IngestAttachmentProcessor, 
	append: IngestAppendProcessor, 
	csv: IngestCsvProcessor, 
	convert: IngestConvertProcessor, 
	date: IngestDateProcessor, 
	date_index_name: IngestDateIndexNameProcessor, 
	dot_expander: IngestDotExpanderProcessor, 
	enrich: IngestEnrichProcessor, 
	fail: IngestFailProcessor, 
	foreach: IngestForeachProcessor, 
	json: IngestJsonProcessor, 
	user_agent: IngestUserAgentProcessor, 
	kv: IngestKeyValueProcessor, 
	geoip: IngestGeoIpProcessor, 
	grok: IngestGrokProcessor, 
	gsub: IngestGsubProcessor, 
	join: IngestJoinProcessor, 
	lowercase: IngestLowercaseProcessor, 
	remove: IngestRemoveProcessor, 
	rename: IngestRenameProcessor, 
	script: Script, 
	set: IngestSetProcessor, 
	sort: IngestSortProcessor, 
	split: IngestSplitProcessor, 
	trim: IngestTrimProcessor, 
	uppercase: IngestUppercaseProcessor, 
	urldecode: IngestUrlDecodeProcessor, 
	bytes: IngestBytesProcessor, 
	dissect: IngestDissectProcessor, 
	set_security_user: IngestSetSecurityUserProcessor, 
	pipeline: IngestPipelineProcessor, 
	drop: IngestDropProcessor, 
	circle: IngestCircleProcessor, 
	inference: IngestInferenceProcessor
)

@JsonCodec case class IngestRemoveProcessor(
	field: Fields, 
	ignore_missing: Boolean
) extends IngestProcessorBase

@JsonCodec case class IngestRenameProcessor(
	field: Field, 
	ignore_missing: Boolean, 
	target_field: Field
) extends IngestProcessorBase

@JsonCodec case class IngestSetProcessor(
	field: Field, 
	`override`: Boolean, 
	value: Any
) extends IngestProcessorBase

@JsonCodec case class IngestSetSecurityUserProcessor(
	field: Field, 
	properties: Seq[String]
) extends IngestProcessorBase
type IngestShapeType = "geo_shape"" | "shape""

@JsonCodec case class IngestSortProcessor(
	field: Field, 
	order: SearchSortOrder, 
	target_field: Field
) extends IngestProcessorBase

@JsonCodec case class IngestSplitProcessor(
	field: Field, 
	ignore_missing: Boolean, 
	preserve_trailing: Boolean, 
	separator: String, 
	target_field: Field
) extends IngestProcessorBase

@JsonCodec case class IngestTrimProcessor(
	field: Field, 
	ignore_missing: Boolean, 
	target_field: Field
) extends IngestProcessorBase

@JsonCodec case class IngestUppercaseProcessor(
	field: Field, 
	ignore_missing: Boolean, 
	target_field: Field
) extends IngestProcessorBase

@JsonCodec case class IngestUrlDecodeProcessor(
	field: Field, 
	ignore_missing: Boolean, 
	target_field: Field
) extends IngestProcessorBase

@JsonCodec case class IngestUserAgentProcessor(
	field: Field, 
	ignore_missing: Boolean, 
	options: Seq[IngestUserAgentProperty], 
	regex_file: String, 
	target_field: Field
) extends IngestProcessorBase
type IngestUserAgentProperty = "NAME"" | "MAJOR"" | "MINOR"" | "PATCH"" | "OS"" | "OS_NAME"" | "OS_MAJOR"" | "OS_MINOR"" | "DEVICE"" | "BUILD""

@JsonCodec case class IngestDeletePipelineRequest(
	id: Id, 
	master_timeout: Time, 
	timeout: Time
) extends RequestBase

@JsonCodec case class IngestDeletePipelineResponse extends AcknowledgedResponseBase

@JsonCodec case class IngestGeoIpStatsGeoIpDownloadStatistics(
	successful_downloads: integer, 
	failed_downloads: integer, 
	total_download_time: integer, 
	database_count: integer, 
	skipped_updates: integer
)

@JsonCodec case class IngestGeoIpStatsGeoIpNodeDatabaseName(
	name: Name
)

@JsonCodec case class IngestGeoIpStatsGeoIpNodeDatabases(
	databases: Seq[IngestGeoIpStatsGeoIpNodeDatabaseName], 
	files_in_temp: Seq[String]
)

@JsonCodec case class IngestGeoIpStatsRequest extends RequestBase

@JsonCodec case class IngestGeoIpStatsResponse(
	stats: IngestGeoIpStatsGeoIpDownloadStatistics, 
	nodes: Record[Id, IngestGeoIpStatsGeoIpNodeDatabases]
)

@JsonCodec case class IngestGetPipelineRequest(
	id: Id, 
	master_timeout: Time, 
	summary: Boolean
) extends RequestBase

@JsonCodec case class IngestGetPipelineResponse extends DictionaryResponseBase[String, IngestPipeline]

@JsonCodec case class IngestProcessorGrokRequest extends RequestBase

@JsonCodec case class IngestProcessorGrokResponse(
	patterns: Record[String, String]
)

@JsonCodec case class IngestPutPipelineRequest(
	id: Id, 
	master_timeout: Time, 
	timeout: Time, 
	body: Body
) extends RequestBase

object IngestPutPipelineRequest {
	@JsonCodec case class Body(
		description: String, 
		on_failure: Seq[IngestProcessorContainer], 
		processors: Seq[IngestProcessorContainer], 
		version: VersionNumber
	)
}


@JsonCodec case class IngestPutPipelineResponse extends AcknowledgedResponseBase

@JsonCodec case class IngestSimulatePipelineDocument(
	_id: Id, 
	_index: IndexName, 
	_source: Any
)

@JsonCodec case class IngestSimulatePipelineDocumentSimulation(
	_id: Id, 
	_index: IndexName, 
	_ingest: IngestSimulatePipelineIngest, 
	_parent: String, 
	_routing: String, 
	_source: Record[String, Any], 
	_type: Type
)

@JsonCodec case class IngestSimulatePipelineIngest(
	timestamp: DateString, 
	pipeline: Name
)

@JsonCodec case class IngestSimulatePipelinePipelineSimulation(
	doc: IngestSimulatePipelineDocumentSimulation, 
	processor_results: Seq[IngestSimulatePipelinePipelineSimulation], 
	tag: String, 
	processor_type: String, 
	status: WatcherActionStatusOptions
)

@JsonCodec case class IngestSimulatePipelineRequest(
	id: Id, 
	verbose: Boolean, 
	body: Body
) extends RequestBase

object IngestSimulatePipelineRequest {
	@JsonCodec case class Body(
		docs: Seq[IngestSimulatePipelineDocument], 
		pipeline: IngestPipeline
	)
}


@JsonCodec case class IngestSimulatePipelineResponse(
	docs: Seq[IngestSimulatePipelinePipelineSimulation]
)

@JsonCodec case class LicenseLicense(
	expiry_date_in_millis: EpochMillis, 
	issue_date_in_millis: EpochMillis, 
	issued_to: String, 
	issuer: String, 
	max_nodes: long, 
	max_resource_units: long, 
	signature: String, 
	start_date_in_millis: EpochMillis, 
	`type`: LicenseLicenseType, 
	uid: String
)
type LicenseLicenseStatus = "active"" | "valid"" | "invalid"" | "expired""
type LicenseLicenseType = "missing"" | "trial"" | "basic"" | "standard"" | "dev"" | "silver"" | "gold"" | "platinum"" | "enterprise""

@JsonCodec case class LicenseDeleteRequest extends RequestBase

@JsonCodec case class LicenseDeleteResponse extends AcknowledgedResponseBase

@JsonCodec case class LicenseGetLicenseInformation(
	expiry_date: DateString, 
	expiry_date_in_millis: EpochMillis, 
	issue_date: DateString, 
	issue_date_in_millis: EpochMillis, 
	issued_to: String, 
	issuer: String, 
	max_nodes: long, 
	max_resource_units: integer, 
	status: LicenseLicenseStatus, 
	`type`: LicenseLicenseType, 
	uid: Uuid, 
	start_date_in_millis: EpochMillis
)

@JsonCodec case class LicenseGetRequest(
	accept_enterprise: Boolean, 
	local: Boolean
) extends RequestBase

@JsonCodec case class LicenseGetResponse(
	license: LicenseGetLicenseInformation
)

@JsonCodec case class LicenseGetBasicStatusRequest extends RequestBase

@JsonCodec case class LicenseGetBasicStatusResponse(
	eligible_to_start_basic: Boolean
)

@JsonCodec case class LicenseGetTrialStatusRequest extends RequestBase

@JsonCodec case class LicenseGetTrialStatusResponse(
	eligible_to_start_trial: Boolean
)

@JsonCodec case class LicensePostAcknowledgement(
	license: Seq[String], 
	message: String
)

@JsonCodec case class LicensePostRequest(
	acknowledge: Boolean, 
	body: Body
) extends RequestBase

object LicensePostRequest {
	@JsonCodec case class Body(
		license: LicenseLicense, 
		licenses: Seq[LicenseLicense]
	)
}


@JsonCodec case class LicensePostResponse(
	acknowledge: LicensePostAcknowledgement, 
	acknowledged: Boolean, 
	license_status: LicenseLicenseStatus
)

@JsonCodec case class LicensePostStartBasicRequest(
	acknowledge: Boolean
) extends RequestBase

@JsonCodec case class LicensePostStartBasicResponse(
	acknowledge: Record[String, String | Seq[String]], 
	basic_was_started: Boolean, 
	error_message: String
) extends AcknowledgedResponseBase

@JsonCodec case class LicensePostStartTrialRequest(
	acknowledge: Boolean, 
	type_query_string: String
) extends RequestBase

@JsonCodec case class LicensePostStartTrialResponse(
	error_message: String, 
	acknowledged: Boolean, 
	trial_was_started: Boolean, 
	`type`: LicenseLicenseType
) extends AcknowledgedResponseBase

@JsonCodec case class LogstashPipelineDeleteRequest(
	stub_a: String, 
	stub_b: String, 
	body: Body
) extends RequestBase

object LogstashPipelineDeleteRequest {
	@JsonCodec case class Body(
		stub_c: String
	)
}


@JsonCodec case class LogstashPipelineDeleteResponse(
	stub: integer
)

@JsonCodec case class LogstashPipelineGetRequest(
	stub_a: String, 
	stub_b: String, 
	body: Body
) extends RequestBase

object LogstashPipelineGetRequest {
	@JsonCodec case class Body(
		stub_c: String
	)
}


@JsonCodec case class LogstashPipelineGetResponse(
	stub: integer
)

@JsonCodec case class LogstashPipelinePutRequest(
	stub_a: String, 
	stub_b: String, 
	body: Body
) extends RequestBase

object LogstashPipelinePutRequest {
	@JsonCodec case class Body(
		stub_c: String
	)
}


@JsonCodec case class LogstashPipelinePutResponse(
	stub: integer
)

@JsonCodec case class MigrationDeprecationInfoDeprecation(
	details: String, 
	level: MigrationDeprecationInfoDeprecationLevel, 
	message: String, 
	url: String
)
type MigrationDeprecationInfoDeprecationLevel = "none"" | "info"" | "warning"" | "critical""

@JsonCodec case class MigrationDeprecationInfoRequest(
	index: IndexName
) extends RequestBase

@JsonCodec case class MigrationDeprecationInfoResponse(
	cluster_settings: Seq[MigrationDeprecationInfoDeprecation], 
	index_settings: Record[String, Seq[MigrationDeprecationInfoDeprecation]], 
	node_settings: Seq[MigrationDeprecationInfoDeprecation], 
	ml_settings: Seq[MigrationDeprecationInfoDeprecation]
)

@JsonCodec case class MlAnalysisConfig(
	bucket_span: TimeSpan, 
	categorization_field_name: Field, 
	categorization_filters: Seq[String], 
	detectors: Seq[MlDetector], 
	influencers: Seq[Field], 
	latency: Time, 
	multivariate_by_fields: Boolean, 
	per_partition_categorization: MlPerPartitionCategorization, 
	summary_count_field_name: Field, 
	categorization_analyzer: MlCategorizationAnalyzer | String
)

@JsonCodec case class MlAnalysisLimits(
	categorization_examples_limit: long, 
	model_memory_limit: String
)

@JsonCodec case class MlAnalysisMemoryLimit(
	model_memory_limit: String
)

@JsonCodec case class MlAnomaly(
	actual: Seq[double], 
	bucket_span: Time, 
	by_field_name: String, 
	by_field_value: String, 
	causes: Seq[MlAnomalyCause], 
	detector_index: integer, 
	field_name: String, 
	function: String, 
	function_description: String, 
	influencers: Seq[MlInfluence], 
	initial_record_score: double, 
	is_interim: Boolean, 
	job_id: String, 
	over_field_name: String, 
	over_field_value: String, 
	partition_field_name: String, 
	partition_field_value: String, 
	probability: double, 
	record_score: double, 
	result_type: String, 
	timestamp: EpochMillis, 
	typical: Seq[double]
)

@JsonCodec case class MlAnomalyCause(
	actual: Seq[double], 
	by_field_name: Name, 
	by_field_value: String, 
	correlated_by_field_value: String, 
	field_name: Field, 
	function: String, 
	function_description: String, 
	influencers: Seq[MlInfluence], 
	over_field_name: Name, 
	over_field_value: String, 
	partition_field_name: String, 
	partition_field_value: String, 
	probability: double, 
	typical: Seq[double]
)
type MlAppliesTo = "actual"" | "typical"" | "diff_from_typical"" | "time""

@JsonCodec case class MlBucketInfluencer(
	bucket_span: long, 
	influencer_score: double, 
	influencer_field_name: Field, 
	influencer_field_value: String, 
	initial_influencer_score: double, 
	is_interim: Boolean, 
	job_id: Id, 
	probability: double, 
	result_type: String, 
	timestamp: Time, 
	foo: String
)

@JsonCodec case class MlBucketSummary(
	anomaly_score: double, 
	bucket_influencers: Seq[MlBucketInfluencer], 
	bucket_span: Time, 
	event_count: long, 
	initial_anomaly_score: double, 
	is_interim: Boolean, 
	job_id: Id, 
	partition_scores: Seq[MlPartitionScore], 
	processing_time_ms: double, 
	result_type: String, 
	timestamp: Time
)

@JsonCodec case class MlCalendarEvent(
	calendar_id: Id, 
	event_id: Id, 
	description: String, 
	end_time: EpochMillis, 
	start_time: EpochMillis
)

@JsonCodec case class MlCategorizationAnalyzer(
	filter: Seq[String | AnalysisTokenFilter], 
	tokenizer: String | AnalysisTokenizer, 
	char_filter: Seq[String | AnalysisCharFilter]
)
type MlCategorizationStatus = "ok"" | "warn""

@JsonCodec case class MlCategory(
	category_id: ulong, 
	examples: Seq[String], 
	grok_pattern: String, 
	job_id: Id, 
	max_matching_length: ulong, 
	partition_field_name: String, 
	partition_field_value: String, 
	regex: String, 
	terms: String, 
	num_matches: long, 
	preferred_to_categories: Seq[Id], 
	p: String, 
	result_type: String, 
	mlcategory: String
)

@JsonCodec case class MlChunkingConfig(
	mode: MlChunkingMode, 
	time_span: Time
)
type MlChunkingMode = "auto"" | "manual"" | "off""
type MlConditionOperator = "gt"" | "gte"" | "lt"" | "lte""

@JsonCodec case class MlCustomSettings(
	custom_urls: Seq[XpackUsageUrlConfig], 
	created_by: String, 
	job_tags: Record[String, String]
)

@JsonCodec case class MlDataCounts(
	bucket_count: long, 
	earliest_record_timestamp: long, 
	empty_bucket_count: long, 
	input_bytes: long, 
	input_field_count: long, 
	input_record_count: long, 
	invalid_date_count: long, 
	job_id: Id, 
	last_data_time: long, 
	latest_empty_bucket_timestamp: long, 
	latest_record_timestamp: long, 
	latest_sparse_bucket_timestamp: long, 
	latest_bucket_timestamp: long, 
	missing_field_count: long, 
	out_of_order_timestamp_count: long, 
	processed_field_count: long, 
	processed_record_count: long, 
	sparse_bucket_count: long
)

@JsonCodec case class MlDataDescription(
	format: String, 
	time_field: Field, 
	time_format: String, 
	field_delimiter: String
)

@JsonCodec case class MlDatafeed(
	aggregations: Record[String, AggregationsAggregationContainer], 
	aggs: Record[String, AggregationsAggregationContainer], 
	chunking_config: MlChunkingConfig, 
	datafeed_id: Id, 
	frequency: Timestamp, 
	indices: Seq[String], 
	indexes: Seq[String], 
	job_id: Id, 
	max_empty_searches: integer, 
	query: QueryDslQueryContainer, 
	query_delay: Timestamp, 
	script_fields: Record[String, ScriptField], 
	scroll_size: integer, 
	delayed_data_check_config: MlDelayedDataCheckConfig, 
	runtime_mappings: MappingRuntimeFields, 
	indices_options: MlDatafeedIndicesOptions
)

@JsonCodec case class MlDatafeedIndicesOptions(
	allow_no_indices: Boolean, 
	expand_wildcards: ExpandWildcards, 
	ignore_unavailable: Boolean, 
	ignore_throttled: Boolean
)
type MlDatafeedState = "started"" | "stopped"" | "starting"" | "stopping""

@JsonCodec case class MlDatafeedStats(
	assignment_explanation: String, 
	datafeed_id: Id, 
	node: MlDiscoveryNode, 
	state: MlDatafeedState, 
	timing_stats: MlDatafeedTimingStats
)

@JsonCodec case class MlDatafeedTimingStats(
	bucket_count: long, 
	exponential_average_search_time_per_hour_ms: double, 
	job_id: Id, 
	search_count: long, 
	total_search_time_ms: double, 
	average_search_time_per_bucket_ms: Double
)

@JsonCodec case class MlDataframeAnalysis(
	dependent_variable: String, 
	prediction_field_name: Field, 
	alpha: double, 
	lambda: double, 
	gamma: double, 
	eta: double, 
	eta_growth_rate_per_tree: double, 
	feature_bag_fraction: double, 
	max_trees: integer, 
	maximum_number_trees: integer, 
	soft_tree_depth_limit: integer, 
	soft_tree_depth_tolerance: double, 
	downsample_factor: double, 
	max_optimization_rounds_per_hyperparameter: integer, 
	early_stopping_enabled: Boolean, 
	num_top_feature_importance_values: integer, 
	feature_processors: Seq[MlDataframeAnalysisFeatureProcessor], 
	randomize_seed: double, 
	training_percent: Percentage
)
type MlDataframeAnalysisAnalyzedFields = Seq[String] | MlDataframeAnalysisAnalyzedFieldsIncludeExclude

@JsonCodec case class MlDataframeAnalysisAnalyzedFieldsIncludeExclude(
	includes: Seq[String], 
	excludes: Seq[String]
)

@JsonCodec case class MlDataframeAnalysisClassification(
	class_assignment_objective: String, 
	num_top_classes: integer
) extends MlDataframeAnalysis

@JsonCodec case class MlDataframeAnalysisContainer(
	outlier_detection: MlDataframeAnalysisOutlierDetection, 
	regression: MlDataframeAnalysisRegression, 
	classification: MlDataframeAnalysisClassification
)

@JsonCodec case class MlDataframeAnalysisFeatureProcessor(
	frequency_encoding: MlDataframeAnalysisFeatureProcessorFrequencyEncoding, 
	multi_encoding: MlDataframeAnalysisFeatureProcessorMultiEncoding, 
	n_gram_encoding: MlDataframeAnalysisFeatureProcessorNGramEncoding, 
	one_hot_encoding: MlDataframeAnalysisFeatureProcessorOneHotEncoding, 
	target_mean_encoding: MlDataframeAnalysisFeatureProcessorTargetMeanEncoding
)

@JsonCodec case class MlDataframeAnalysisFeatureProcessorFrequencyEncoding(
	feature_name: Name, 
	field: Field, 
	frequency_map: Record[String, double]
)

@JsonCodec case class MlDataframeAnalysisFeatureProcessorMultiEncoding(
	processors: Seq[integer]
)

@JsonCodec case class MlDataframeAnalysisFeatureProcessorNGramEncoding(
	feature_prefix: String, 
	field: Field, 
	length: integer, 
	n_grams: Seq[integer], 
	start: integer, 
	custom: Boolean
)

@JsonCodec case class MlDataframeAnalysisFeatureProcessorOneHotEncoding(
	field: Field, 
	hot_map: String
)

@JsonCodec case class MlDataframeAnalysisFeatureProcessorTargetMeanEncoding(
	default_value: integer, 
	feature_name: Name, 
	field: Field, 
	target_map: Record[String, Any]
)

@JsonCodec case class MlDataframeAnalysisOutlierDetection(
	n_neighbors: integer, 
	method: String, 
	feature_influence_threshold: double, 
	compute_feature_influence: Boolean, 
	outlier_fraction: double, 
	standardization_enabled: Boolean
)

@JsonCodec case class MlDataframeAnalysisRegression(
	loss_function: String, 
	loss_function_parameter: double
) extends MlDataframeAnalysis

@JsonCodec case class MlDataframeAnalytics(
	analysis_stats: MlDataframeAnalyticsStatsContainer, 
	assignment_explanation: String, 
	data_counts: MlDataframeAnalyticsStatsDataCounts, 
	id: Id, 
	memory_usage: MlDataframeAnalyticsStatsMemoryUsage, 
	node: NodeAttributes, 
	progress: Seq[MlDataframeAnalyticsStatsProgress], 
	state: MlDataframeState
)

@JsonCodec case class MlDataframeAnalyticsDestination(
	index: IndexName, 
	results_field: Field
)

@JsonCodec case class MlDataframeAnalyticsFieldSelection(
	is_included: Boolean, 
	is_required: Boolean, 
	feature_type: String, 
	mapping_types: Seq[String], 
	name: Field, 
	reason: String
)

@JsonCodec case class MlDataframeAnalyticsMemoryEstimation(
	expected_memory_with_disk: String, 
	expected_memory_without_disk: String
)

@JsonCodec case class MlDataframeAnalyticsSource(
	index: Indices, 
	query: QueryDslQueryContainer, 
	_source: MlDataframeAnalysisAnalyzedFields, 
	runtime_mappings: MappingRuntimeFields
)

@JsonCodec case class MlDataframeAnalyticsStatsContainer(
	classification_stats: MlDataframeAnalyticsStatsHyperparameters, 
	outlier_detection_stats: MlDataframeAnalyticsStatsOutlierDetection, 
	regression_stats: MlDataframeAnalyticsStatsHyperparameters
)

@JsonCodec case class MlDataframeAnalyticsStatsDataCounts(
	skipped_docs_count: integer, 
	test_docs_count: integer, 
	training_docs_count: integer
)

@JsonCodec case class MlDataframeAnalyticsStatsHyperparameters(
	hyperparameters: MlHyperparameters, 
	iteration: integer, 
	timestamp: DateString, 
	timing_stats: MlTimingStats, 
	validation_loss: MlValidationLoss
)

@JsonCodec case class MlDataframeAnalyticsStatsMemoryUsage(
	memory_reestimate_bytes: long, 
	peak_usage_bytes: long, 
	status: String, 
	timestamp: DateString
)

@JsonCodec case class MlDataframeAnalyticsStatsOutlierDetection(
	parameters: MlOutlierDetectionParameters, 
	timestamp: DateString, 
	timing_stats: MlTimingStats
)

@JsonCodec case class MlDataframeAnalyticsStatsProgress(
	phase: String, 
	progress_percent: integer
)

@JsonCodec case class MlDataframeAnalyticsSummary(
	id: Id, 
	source: MlDataframeAnalyticsSource, 
	dest: MlDataframeAnalyticsDestination, 
	analysis: MlDataframeAnalysisContainer, 
	description: String, 
	model_memory_limit: String, 
	max_num_threads: integer, 
	analyzed_fields: MlDataframeAnalysisAnalyzedFields, 
	allow_lazy_start: Boolean, 
	create_time: long, 
	version: VersionString
)

@JsonCodec case class MlDataframeEvaluationClassification(
	actual_field: Field, 
	predicted_field: Field, 
	top_classes_field: Field, 
	metrics: MlDataframeEvaluationClassificationMetrics
)

@JsonCodec case class MlDataframeEvaluationClassificationMetrics(
	accuracy: Record[String, Any], 
	multiclass_confusion_matrix: Record[String, Any]
) extends MlDataframeEvaluationMetrics

@JsonCodec case class MlDataframeEvaluationClassificationMetricsAucRoc(
	class_name: Name, 
	include_curve: Boolean
)

@JsonCodec case class MlDataframeEvaluationContainer(
	classification: MlDataframeEvaluationClassification, 
	outlier_detection: MlDataframeEvaluationOutlierDetection, 
	regression: MlDataframeEvaluationRegression
)

@JsonCodec case class MlDataframeEvaluationMetrics(
	auc_roc: MlDataframeEvaluationClassificationMetricsAucRoc, 
	precision: Record[String, Any], 
	recall: Record[String, Any]
)

@JsonCodec case class MlDataframeEvaluationOutlierDetection(
	actual_field: Field, 
	predicted_probability_field: Field, 
	metrics: MlDataframeEvaluationOutlierDetectionMetrics
)

@JsonCodec case class MlDataframeEvaluationOutlierDetectionMetrics(
	confusion_matrix: Record[String, Any]
) extends MlDataframeEvaluationMetrics

@JsonCodec case class MlDataframeEvaluationRegression(
	actual_field: Field, 
	predicted_field: Field, 
	metrics: MlDataframeEvaluationRegressionMetrics
)

@JsonCodec case class MlDataframeEvaluationRegressionMetrics(
	mse: Record[String, Any], 
	msle: MlDataframeEvaluationRegressionMetricsMsle, 
	huber: MlDataframeEvaluationRegressionMetricsHuber, 
	r_squared: Record[String, Any]
)

@JsonCodec case class MlDataframeEvaluationRegressionMetricsHuber(
	delta: double
)

@JsonCodec case class MlDataframeEvaluationRegressionMetricsMsle(
	offset: double
)
type MlDataframeState = "started"" | "stopped"" | "starting"" | "stopping"" | "failed""

@JsonCodec case class MlDelayedDataCheckConfig(
	check_window: Time, 
	enabled: Boolean
)

@JsonCodec case class MlDetectionRule(
	actions: Seq[MlRuleAction], 
	conditions: Seq[MlRuleCondition], 
	scope: Record[Field, MlFilterRef]
)

@JsonCodec case class MlDetector(
	by_field_name: Field, 
	custom_rules: Seq[MlDetectionRule], 
	detector_description: String, 
	detector_index: integer, 
	exclude_frequent: MlExcludeFrequent, 
	field_name: Field, 
	function: String, 
	use_null: Boolean, 
	over_field_name: Field, 
	partition_field_name: Field
)

@JsonCodec case class MlDiscoveryNode(
	attributes: Record[String, String], 
	ephemeral_id: Id, 
	id: Id, 
	name: Name, 
	transport_address: TransportAddress
)
type MlExcludeFrequent = "all"" | "none"" | "by"" | "over""

@JsonCodec case class MlFilter(
	description: String, 
	filter_id: Id, 
	items: Seq[String]
)

@JsonCodec case class MlFilterRef(
	filter_id: Id, 
	filter_type: MlFilterType
)
type MlFilterType = "include"" | "exclude""

@JsonCodec case class MlHyperparameter(
	absolute_importance: double, 
	name: Name, 
	relative_importance: double, 
	supplied: Boolean, 
	value: double
)

@JsonCodec case class MlHyperparameters(
	alpha: double, 
	lambda: double, 
	gamma: double, 
	eta: double, 
	eta_growth_rate_per_tree: double, 
	feature_bag_fraction: double, 
	downsample_factor: double, 
	max_attempts_to_add_tree: integer, 
	max_optimization_rounds_per_hyperparameter: integer, 
	max_trees: integer, 
	num_folds: integer, 
	num_splits_per_feature: integer, 
	soft_tree_depth_limit: integer, 
	soft_tree_depth_tolerance: double
)

@JsonCodec case class MlInfluence(
	influencer_field_name: String, 
	influencer_field_values: Seq[String]
)

@JsonCodec case class MlJob(
	allow_lazy_open: Boolean, 
	analysis_config: MlAnalysisConfig, 
	analysis_limits: MlAnalysisLimits, 
	background_persist_interval: Time, 
	create_time: integer, 
	data_description: MlDataDescription, 
	description: String, 
	finished_time: integer, 
	job_id: Id, 
	job_type: String, 
	model_snapshot_id: Id, 
	model_snapshot_retention_days: long, 
	renormalization_window_days: long, 
	results_index_name: IndexName, 
	results_retention_days: long, 
	groups: Seq[String], 
	model_plot_config: MlModelPlotConfig, 
	custom_settings: MlCustomSettings, 
	job_version: VersionString, 
	deleting: Boolean, 
	daily_model_snapshot_retention_after_days: long
)

@JsonCodec case class MlJobForecastStatistics(
	memory_bytes: MlJobStatistics, 
	processing_time_ms: MlJobStatistics, 
	records: MlJobStatistics, 
	status: Record[String, long], 
	total: long, 
	forecasted_jobs: integer
)
type MlJobState = "closing"" | "closed"" | "opened"" | "failed"" | "opening""

@JsonCodec case class MlJobStatistics(
	avg: double, 
	max: double, 
	min: double, 
	total: double
)

@JsonCodec case class MlJobStats(
	assignment_explanation: String, 
	data_counts: MlDataCounts, 
	forecasts_stats: MlJobForecastStatistics, 
	job_id: String, 
	model_size_stats: MlModelSizeStats, 
	node: MlDiscoveryNode, 
	open_time: DateString, 
	state: MlJobState, 
	timing_stats: MlJobTimingStats, 
	deleting: Boolean
)

@JsonCodec case class MlJobTimingStats(
	average_bucket_processing_time_ms: double, 
	bucket_count: long, 
	exponential_average_bucket_processing_time_ms: double, 
	exponential_average_bucket_processing_time_per_hour_ms: double, 
	job_id: Id, 
	total_bucket_processing_time_ms: double, 
	maximum_bucket_processing_time_ms: double, 
	minimum_bucket_processing_time_ms: double
)
type MlMemoryStatus = "ok"" | "soft_limit"" | "hard_limit""

@JsonCodec case class MlModelPlotConfig(
	terms: Field, 
	enabled: Boolean, 
	annotations_enabled: Boolean
)

@JsonCodec case class MlModelSizeStats(
	bucket_allocation_failures_count: long, 
	job_id: Id, 
	log_time: Time, 
	memory_status: MlMemoryStatus, 
	model_bytes: long, 
	model_bytes_exceeded: long, 
	model_bytes_memory_limit: long, 
	peak_model_bytes: long, 
	assignment_memory_basis: String, 
	result_type: String, 
	total_by_field_count: long, 
	total_over_field_count: long, 
	total_partition_field_count: long, 
	categorization_status: MlCategorizationStatus, 
	categorized_doc_count: integer, 
	dead_category_count: integer, 
	failed_category_count: integer, 
	frequent_category_count: integer, 
	rare_category_count: integer, 
	total_category_count: integer, 
	timestamp: long
)

@JsonCodec case class MlModelSnapshot(
	description: String, 
	job_id: Id, 
	latest_record_time_stamp: integer, 
	latest_result_time_stamp: integer, 
	min_version: VersionString, 
	model_size_stats: MlModelSizeStats, 
	retain: Boolean, 
	snapshot_doc_count: long, 
	snapshot_id: Id, 
	timestamp: integer
)

@JsonCodec case class MlOutlierDetectionParameters(
	compute_feature_influence: Boolean, 
	feature_influence_threshold: double, 
	method: String, 
	n_neighbors: integer, 
	outlier_fraction: double, 
	standardization_enabled: Boolean
)

@JsonCodec case class MlOverallBucket(
	bucket_span: long, 
	is_interim: Boolean, 
	jobs: Seq[MlOverallBucketJob], 
	overall_score: double, 
	result_type: String, 
	timestamp: Time
)

@JsonCodec case class MlOverallBucketJob(
	job_id: Id, 
	max_anomaly_score: double
)

@JsonCodec case class MlPage(
	from: integer, 
	size: integer
)

@JsonCodec case class MlPartitionScore(
	initial_record_score: double, 
	partition_field_name: Field, 
	partition_field_value: String, 
	probability: double, 
	record_score: double
)

@JsonCodec case class MlPerPartitionCategorization(
	enabled: Boolean, 
	stop_on_warn: Boolean
)
type MlRuleAction = "skip_result"" | "skip_model_update""

@JsonCodec case class MlRuleCondition(
	applies_to: MlAppliesTo, 
	operator: MlConditionOperator, 
	value: double
)

@JsonCodec case class MlTimingStats(
	elapsed_time: integer, 
	iteration_time: integer
)

@JsonCodec case class MlTotalFeatureImportance(
	feature_name: Name, 
	importance: Seq[MlTotalFeatureImportanceStatistics], 
	classes: Seq[MlTotalFeatureImportanceClass]
)

@JsonCodec case class MlTotalFeatureImportanceClass(
	class_name: Name, 
	importance: Seq[MlTotalFeatureImportanceStatistics]
)

@JsonCodec case class MlTotalFeatureImportanceStatistics(
	mean_magnitude: double, 
	max: integer, 
	min: integer
)

@JsonCodec case class MlTrainedModelConfig(
	model_id: Id, 
	tags: Seq[String], 
	version: VersionString, 
	compressed_definition: String, 
	created_by: String, 
	create_time: Time, 
	default_field_map: Record[String, String], 
	description: String, 
	estimated_heap_memory_usage_bytes: integer, 
	estimated_operations: integer, 
	inference_config: AggregationsInferenceConfigContainer, 
	input: MlTrainedModelConfigInput, 
	license_level: String, 
	metadata: MlTrainedModelConfigMetadata
)

@JsonCodec case class MlTrainedModelConfigInput(
	field_names: Seq[Field]
)

@JsonCodec case class MlTrainedModelConfigMetadata(
	model_aliases: Seq[String], 
	feature_importance_baseline: Record[String, String], 
	hyperparameters: Seq[MlHyperparameter], 
	total_feature_importance: Seq[MlTotalFeatureImportance]
)

@JsonCodec case class MlTrainedModelInferenceStats(
	failure_count: long, 
	inference_count: long, 
	cache_miss_count: long, 
	missing_all_fields_count: long, 
	timestamp: Time
)

@JsonCodec case class MlTrainedModelStats(
	model_id: Id, 
	pipeline_count: integer, 
	inference_stats: MlTrainedModelInferenceStats, 
	ingest: Record[String, Any]
)

@JsonCodec case class MlValidationLoss(
	fold_values: Seq[String], 
	loss_type: String
)

@JsonCodec case class MlCloseJobRequest(
	job_id: Id, 
	allow_no_jobs: Boolean, 
	force: Boolean, 
	timeout: Time
) extends RequestBase

@JsonCodec case class MlCloseJobResponse(
	closed: Boolean
)

@JsonCodec case class MlDeleteCalendarRequest(
	calendar_id: Id
) extends RequestBase

@JsonCodec case class MlDeleteCalendarResponse extends AcknowledgedResponseBase

@JsonCodec case class MlDeleteCalendarEventRequest(
	calendar_id: Id, 
	event_id: Id
) extends RequestBase

@JsonCodec case class MlDeleteCalendarEventResponse extends AcknowledgedResponseBase

@JsonCodec case class MlDeleteCalendarJobRequest(
	calendar_id: Id, 
	job_id: Id
) extends RequestBase

@JsonCodec case class MlDeleteCalendarJobResponse(
	calendar_id: Id, 
	description: String, 
	job_ids: Ids
)

@JsonCodec case class MlDeleteDataFrameAnalyticsRequest(
	id: Id, 
	force: Boolean, 
	timeout: Time
) extends RequestBase

@JsonCodec case class MlDeleteDataFrameAnalyticsResponse extends AcknowledgedResponseBase

@JsonCodec case class MlDeleteDatafeedRequest(
	datafeed_id: Id, 
	force: Boolean
) extends RequestBase

@JsonCodec case class MlDeleteDatafeedResponse extends AcknowledgedResponseBase

@JsonCodec case class MlDeleteExpiredDataRequest(
	name: Name, 
	requests_per_second: float, 
	timeout: Time, 
	body: Body
) extends RequestBase

object MlDeleteExpiredDataRequest {
	@JsonCodec case class Body(
		requests_per_second: float, 
		timeout: Time
	)
}


@JsonCodec case class MlDeleteExpiredDataResponse(
	deleted: Boolean
)

@JsonCodec case class MlDeleteFilterRequest(
	filter_id: Id
) extends RequestBase

@JsonCodec case class MlDeleteFilterResponse extends AcknowledgedResponseBase

@JsonCodec case class MlDeleteForecastRequest(
	job_id: Id, 
	forecast_id: Id, 
	allow_no_forecasts: Boolean, 
	timeout: Time
) extends RequestBase

@JsonCodec case class MlDeleteForecastResponse extends AcknowledgedResponseBase

@JsonCodec case class MlDeleteJobRequest(
	job_id: Id, 
	force: Boolean, 
	wait_for_completion: Boolean
) extends RequestBase

@JsonCodec case class MlDeleteJobResponse extends AcknowledgedResponseBase

@JsonCodec case class MlDeleteModelSnapshotRequest(
	job_id: Id, 
	snapshot_id: Id
) extends RequestBase

@JsonCodec case class MlDeleteModelSnapshotResponse extends AcknowledgedResponseBase

@JsonCodec case class MlDeleteTrainedModelRequest(
	model_id: Id
) extends RequestBase

@JsonCodec case class MlDeleteTrainedModelResponse extends AcknowledgedResponseBase

@JsonCodec case class MlDeleteTrainedModelAliasRequest(
	model_alias: Name, 
	model_id: Id
) extends RequestBase

@JsonCodec case class MlDeleteTrainedModelAliasResponse extends AcknowledgedResponseBase

@JsonCodec case class MlEstimateModelMemoryRequest(
	body: Body
) extends RequestBase

object MlEstimateModelMemoryRequest {
	@JsonCodec case class Body(
		analysis_config: MlAnalysisConfig, 
		max_bucket_cardinality: Record[Field, long], 
		overall_cardinality: Record[Field, long]
	)
}


@JsonCodec case class MlEstimateModelMemoryResponse(
	model_memory_estimate: String
)

@JsonCodec case class MlEvaluateDataFrameConfusionMatrixItem(
	actual_class: Name, 
	actual_class_doc_count: integer, 
	predicted_classes: Seq[MlEvaluateDataFrameConfusionMatrixPrediction], 
	other_predicted_class_doc_count: integer
)

@JsonCodec case class MlEvaluateDataFrameConfusionMatrixPrediction(
	predicted_class: Name, 
	count: integer
)

@JsonCodec case class MlEvaluateDataFrameConfusionMatrixTreshold(
	tp: integer, 
	fp: integer, 
	tn: integer, 
	fn: integer
)

@JsonCodec case class MlEvaluateDataFrameDataframeClassificationSummary(
	auc_roc: MlEvaluateDataFrameDataframeEvaluationSummaryAucRoc, 
	accuracy: MlEvaluateDataFrameDataframeClassificationSummaryAccuracy, 
	multiclass_confusion_matrix: MlEvaluateDataFrameDataframeClassificationSummaryMulticlassConfusionMatrix, 
	precision: MlEvaluateDataFrameDataframeClassificationSummaryPrecision, 
	recall: MlEvaluateDataFrameDataframeClassificationSummaryRecall
)

@JsonCodec case class MlEvaluateDataFrameDataframeClassificationSummaryAccuracy(
	classes: Seq[MlEvaluateDataFrameDataframeEvaluationClass], 
	overall_accuracy: double
)

@JsonCodec case class MlEvaluateDataFrameDataframeClassificationSummaryMulticlassConfusionMatrix(
	confusion_matrix: Seq[MlEvaluateDataFrameConfusionMatrixItem], 
	other_actual_class_count: integer
)

@JsonCodec case class MlEvaluateDataFrameDataframeClassificationSummaryPrecision(
	classes: Seq[MlEvaluateDataFrameDataframeEvaluationClass], 
	avg_precision: double
)

@JsonCodec case class MlEvaluateDataFrameDataframeClassificationSummaryRecall(
	classes: Seq[MlEvaluateDataFrameDataframeEvaluationClass], 
	avg_recall: double
)

@JsonCodec case class MlEvaluateDataFrameDataframeEvaluationClass(
	class_name: Name
) extends MlEvaluateDataFrameDataframeEvaluationValue

@JsonCodec case class MlEvaluateDataFrameDataframeEvaluationSummaryAucRoc(
	curve: Seq[MlEvaluateDataFrameDataframeEvaluationSummaryAucRocCurveItem]
) extends MlEvaluateDataFrameDataframeEvaluationValue

@JsonCodec case class MlEvaluateDataFrameDataframeEvaluationSummaryAucRocCurveItem(
	tpr: double, 
	fpr: double, 
	threshold: double
)

@JsonCodec case class MlEvaluateDataFrameDataframeEvaluationValue(
	value: double
)

@JsonCodec case class MlEvaluateDataFrameDataframeOutlierDetectionSummary(
	auc_roc: MlEvaluateDataFrameDataframeEvaluationSummaryAucRoc, 
	precision: Record[String, double], 
	recall: Record[String, double], 
	confusion_matrix: Record[String, MlEvaluateDataFrameConfusionMatrixTreshold]
)

@JsonCodec case class MlEvaluateDataFrameDataframeRegressionSummary(
	huber: MlEvaluateDataFrameDataframeEvaluationValue, 
	mse: MlEvaluateDataFrameDataframeEvaluationValue, 
	msle: MlEvaluateDataFrameDataframeEvaluationValue, 
	r_squared: MlEvaluateDataFrameDataframeEvaluationValue
)

@JsonCodec case class MlEvaluateDataFrameRequest(
	body: Body
) extends RequestBase

object MlEvaluateDataFrameRequest {
	@JsonCodec case class Body(
		evaluation: MlDataframeEvaluationContainer, 
		index: IndexName, 
		query: QueryDslQueryContainer
	)
}


@JsonCodec case class MlEvaluateDataFrameResponse(
	classification: MlEvaluateDataFrameDataframeClassificationSummary, 
	outlier_detection: MlEvaluateDataFrameDataframeOutlierDetectionSummary, 
	regression: MlEvaluateDataFrameDataframeRegressionSummary
)

@JsonCodec case class MlExplainDataFrameAnalyticsRequest(
	id: Id, 
	body: Body
) extends RequestBase

object MlExplainDataFrameAnalyticsRequest {
	@JsonCodec case class Body(
		source: MlDataframeAnalyticsSource, 
		dest: MlDataframeAnalyticsDestination, 
		analysis: MlDataframeAnalysisContainer, 
		description: String, 
		model_memory_limit: String, 
		max_num_threads: integer, 
		analyzed_fields: MlDataframeAnalysisAnalyzedFields, 
		allow_lazy_start: Boolean
	)
}


@JsonCodec case class MlExplainDataFrameAnalyticsResponse(
	field_selection: Seq[MlDataframeAnalyticsFieldSelection], 
	memory_estimation: MlDataframeAnalyticsMemoryEstimation
)

@JsonCodec case class MlFindFileStructureRequest(
	stub: String
) extends RequestBase

@JsonCodec case class MlFindFileStructureResponse(
	stub: String
)

@JsonCodec case class MlFlushJobRequest(
	job_id: Id, 
	skip_time: String, 
	body: Body
) extends RequestBase

object MlFlushJobRequest {
	@JsonCodec case class Body(
		advance_time: DateString, 
		calc_interim: Boolean, 
		end: DateString, 
		start: DateString
	)
}


@JsonCodec case class MlFlushJobResponse(
	flushed: Boolean, 
	last_finalized_bucket_end: integer
)

@JsonCodec case class MlForecastJobRequest(
	job_id: Id, 
	body: Body
) extends RequestBase

object MlForecastJobRequest {
	@JsonCodec case class Body(
		duration: Time, 
		expires_in: Time
	)
}


@JsonCodec case class MlForecastJobResponse(
	forecast_id: Id
) extends AcknowledgedResponseBase

@JsonCodec case class MlGetAnomalyRecordsRequest(
	job_id: Id, 
	exclude_interim: Boolean, 
	from: integer, 
	size: integer, 
	start: DateString, 
	end: DateString, 
	body: Body
) extends RequestBase

object MlGetAnomalyRecordsRequest {
	@JsonCodec case class Body(
		desc: Boolean, 
		exclude_interim: Boolean, 
		page: MlPage, 
		record_score: double, 
		sort: Field, 
		start: DateString, 
		end: DateString
	)
}


@JsonCodec case class MlGetAnomalyRecordsResponse(
	count: long, 
	records: Seq[MlAnomaly]
)

@JsonCodec case class MlGetBucketsRequest(
	job_id: Id, 
	timestamp: Timestamp, 
	from: integer, 
	size: integer, 
	exclude_interim: Boolean, 
	sort: Field, 
	desc: Boolean, 
	start: DateString, 
	end: DateString, 
	body: Body
) extends RequestBase

object MlGetBucketsRequest {
	@JsonCodec case class Body(
		anomaly_score: double, 
		desc: Boolean, 
		exclude_interim: Boolean, 
		expand: Boolean, 
		page: MlPage, 
		sort: Field, 
		start: DateString, 
		end: DateString
	)
}


@JsonCodec case class MlGetBucketsResponse(
	buckets: Seq[MlBucketSummary], 
	count: long
)

@JsonCodec case class MlGetCalendarEventsRequest(
	calendar_id: Id, 
	job_id: Id, 
	end: DateString, 
	from: integer, 
	start: String, 
	size: integer, 
	body: Body
) extends RequestBase

object MlGetCalendarEventsRequest {
	@JsonCodec case class Body(
		end: DateString, 
		from: integer, 
		start: String, 
		size: integer
	)
}


@JsonCodec case class MlGetCalendarEventsResponse(
	count: long, 
	events: Seq[MlCalendarEvent]
)

@JsonCodec case class MlGetCalendarsCalendar(
	calendar_id: Id, 
	description: String, 
	job_ids: Seq[Id]
)

@JsonCodec case class MlGetCalendarsRequest(
	calendar_id: Id, 
	from: integer, 
	size: integer, 
	body: Body
) extends RequestBase

object MlGetCalendarsRequest {
	@JsonCodec case class Body(
		page: MlPage
	)
}


@JsonCodec case class MlGetCalendarsResponse(
	calendars: Seq[MlGetCalendarsCalendar], 
	count: long
)

@JsonCodec case class MlGetCategoriesRequest(
	job_id: Id, 
	category_id: CategoryId, 
	from: integer, 
	size: integer, 
	partition_field_value: String, 
	body: Body
) extends RequestBase

object MlGetCategoriesRequest {
	@JsonCodec case class Body(
		page: MlPage
	)
}


@JsonCodec case class MlGetCategoriesResponse(
	categories: Seq[MlCategory], 
	count: long
)

@JsonCodec case class MlGetDataFrameAnalyticsRequest(
	id: Id, 
	allow_no_match: Boolean, 
	from: integer, 
	size: integer, 
	exclude_generated: Boolean
) extends RequestBase

@JsonCodec case class MlGetDataFrameAnalyticsResponse(
	count: integer, 
	data_frame_analytics: Seq[MlDataframeAnalyticsSummary]
)

@JsonCodec case class MlGetDataFrameAnalyticsStatsRequest(
	id: Id, 
	allow_no_match: Boolean, 
	from: integer, 
	size: integer, 
	verbose: Boolean
) extends RequestBase

@JsonCodec case class MlGetDataFrameAnalyticsStatsResponse(
	count: long, 
	data_frame_analytics: Seq[MlDataframeAnalytics]
)

@JsonCodec case class MlGetDatafeedStatsRequest(
	datafeed_id: Ids, 
	allow_no_datafeeds: Boolean
) extends RequestBase

@JsonCodec case class MlGetDatafeedStatsResponse(
	count: long, 
	datafeeds: Seq[MlDatafeedStats]
)

@JsonCodec case class MlGetDatafeedsRequest(
	datafeed_id: Ids, 
	allow_no_datafeeds: Boolean, 
	exclude_generated: Boolean
) extends RequestBase

@JsonCodec case class MlGetDatafeedsResponse(
	count: long, 
	datafeeds: Seq[MlDatafeed]
)

@JsonCodec case class MlGetFiltersRequest(
	filter_id: Id, 
	from: integer, 
	size: integer
) extends RequestBase

@JsonCodec case class MlGetFiltersResponse(
	count: long, 
	filters: Seq[MlFilter]
)

@JsonCodec case class MlGetInfluencersRequest(
	job_id: Id, 
	desc: Boolean, 
	end: DateString, 
	exclude_interim: Boolean, 
	influencer_score: double, 
	from: integer, 
	size: integer, 
	sort: Field, 
	start: DateString, 
	body: Body
) extends RequestBase

object MlGetInfluencersRequest {
	@JsonCodec case class Body(
		page: MlPage
	)
}


@JsonCodec case class MlGetInfluencersResponse(
	count: long, 
	influencers: Seq[MlBucketInfluencer]
)

@JsonCodec case class MlGetJobStatsRequest(
	job_id: Id, 
	allow_no_jobs: Boolean
) extends RequestBase

@JsonCodec case class MlGetJobStatsResponse(
	count: long, 
	jobs: Seq[MlJobStats]
)

@JsonCodec case class MlGetJobsRequest(
	job_id: Ids, 
	allow_no_match: Boolean, 
	allow_no_jobs: Boolean, 
	exclude_generated: Boolean
) extends RequestBase

@JsonCodec case class MlGetJobsResponse(
	count: long, 
	jobs: Seq[MlJob]
)

@JsonCodec case class MlGetModelSnapshotsRequest(
	job_id: Id, 
	snapshot_id: Id, 
	desc: Boolean, 
	end: Time, 
	from: integer, 
	size: integer, 
	sort: Field, 
	start: Time, 
	body: Body
) extends RequestBase

object MlGetModelSnapshotsRequest {
	@JsonCodec case class Body(
		start: Time, 
		end: Time
	)
}


@JsonCodec case class MlGetModelSnapshotsResponse(
	count: long, 
	model_snapshots: Seq[MlModelSnapshot]
)

@JsonCodec case class MlGetOverallBucketsRequest(
	job_id: Id, 
	bucket_span: Time, 
	overall_score: double | String, 
	top_n: integer, 
	end: Time, 
	start: Time, 
	exclude_interim: Boolean, 
	allow_no_match: Boolean, 
	body: Body
) extends RequestBase

object MlGetOverallBucketsRequest {
	@JsonCodec case class Body(
		allow_no_jobs: Boolean
	)
}


@JsonCodec case class MlGetOverallBucketsResponse(
	count: long, 
	overall_buckets: Seq[MlOverallBucket]
)

@JsonCodec case class MlGetTrainedModelsRequest(
	model_id: Id, 
	allow_no_match: Boolean, 
	decompress_definition: Boolean, 
	exclude_generated: Boolean, 
	from: integer, 
	include: String, 
	size: integer, 
	tags: String
) extends RequestBase

@JsonCodec case class MlGetTrainedModelsResponse(
	count: integer, 
	trained_model_configs: Seq[MlTrainedModelConfig]
)

@JsonCodec case class MlGetTrainedModelsStatsRequest(
	model_id: Id, 
	allow_no_match: Boolean, 
	from: integer, 
	size: integer
) extends RequestBase

@JsonCodec case class MlGetTrainedModelsStatsResponse(
	count: integer, 
	trained_model_stats: Seq[MlTrainedModelStats]
)

@JsonCodec case class MlInfoAnomalyDetectors(
	categorization_analyzer: MlCategorizationAnalyzer, 
	categorization_examples_limit: integer, 
	model_memory_limit: String, 
	model_snapshot_retention_days: integer, 
	daily_model_snapshot_retention_after_days: integer
)

@JsonCodec case class MlInfoDatafeeds(
	scroll_size: integer
)

@JsonCodec case class MlInfoDefaults(
	anomaly_detectors: MlInfoAnomalyDetectors, 
	datafeeds: MlInfoDatafeeds
)

@JsonCodec case class MlInfoLimits(
	max_model_memory_limit: String, 
	effective_max_model_memory_limit: String, 
	total_ml_memory: String
)

@JsonCodec case class MlInfoNativeCode(
	build_hash: String, 
	version: VersionString
)

@JsonCodec case class MlInfoRequest extends RequestBase

@JsonCodec case class MlInfoResponse(
	defaults: MlInfoDefaults, 
	limits: MlInfoLimits, 
	upgrade_mode: Boolean, 
	native_code: MlInfoNativeCode
)

@JsonCodec case class MlOpenJobRequest(
	job_id: Id, 
	body: Body
) extends RequestBase

object MlOpenJobRequest {
	@JsonCodec case class Body(
		timeout: Time
	)
}


@JsonCodec case class MlOpenJobResponse(
	opened: Boolean
)

@JsonCodec case class MlPostCalendarEventsRequest(
	calendar_id: Id, 
	body: Body
) extends RequestBase

object MlPostCalendarEventsRequest {
	@JsonCodec case class Body(
		events: Seq[MlCalendarEvent]
	)
}


@JsonCodec case class MlPostCalendarEventsResponse(
	events: Seq[MlCalendarEvent]
)

@JsonCodec case class MlPostJobDataRequest(
	job_id: Id, 
	reset_end: DateString, 
	reset_start: DateString, 
	body: Body
) extends RequestBase

object MlPostJobDataRequest {
	@JsonCodec case class Body(
		data: Seq[Any]
	)
}


@JsonCodec case class MlPostJobDataResponse(
	bucket_count: long, 
	earliest_record_timestamp: integer, 
	empty_bucket_count: long, 
	input_bytes: long, 
	input_field_count: long, 
	input_record_count: long, 
	invalid_date_count: long, 
	job_id: Id, 
	last_data_time: integer, 
	latest_record_timestamp: integer, 
	missing_field_count: long, 
	out_of_order_timestamp_count: long, 
	processed_field_count: long, 
	processed_record_count: long, 
	sparse_bucket_count: long
)

@JsonCodec case class MlPreviewDataFrameAnalyticsDataframePreviewConfig(
	source: MlDataframeAnalyticsSource, 
	analysis: MlDataframeAnalysisContainer, 
	model_memory_limit: String, 
	max_num_threads: integer, 
	analyzed_fields: MlDataframeAnalysisAnalyzedFields
)

@JsonCodec case class MlPreviewDataFrameAnalyticsRequest(
	id: Id, 
	body: Body
) extends RequestBase

object MlPreviewDataFrameAnalyticsRequest {
	@JsonCodec case class Body(
		config: MlPreviewDataFrameAnalyticsDataframePreviewConfig
	)
}


@JsonCodec case class MlPreviewDataFrameAnalyticsResponse(
	feature_values: Seq[Record[Field, String]]
)

@JsonCodec case class MlPreviewDatafeedRequest(
	datafeed_id: Id, 
	body: Body
) extends RequestBase

object MlPreviewDatafeedRequest {
	@JsonCodec case class Body(
		job_config: MlJob, 
		datafeed_config: MlDatafeed
	)
}


@JsonCodec case class MlPreviewDatafeedResponse[TDocument = None](
	data: Seq[TDocument]
)

@JsonCodec case class MlPutCalendarRequest(
	calendar_id: Id, 
	body: Body
) extends RequestBase

object MlPutCalendarRequest {
	@JsonCodec case class Body(
		description: String
	)
}


@JsonCodec case class MlPutCalendarResponse(
	calendar_id: Id, 
	description: String, 
	job_ids: Ids
)

@JsonCodec case class MlPutCalendarJobRequest(
	calendar_id: Id, 
	job_id: Id
) extends RequestBase

@JsonCodec case class MlPutCalendarJobResponse(
	calendar_id: Id, 
	description: String, 
	job_ids: Ids
)

@JsonCodec case class MlPutDataFrameAnalyticsRequest(
	id: Id, 
	body: Body
) extends RequestBase

object MlPutDataFrameAnalyticsRequest {
	@JsonCodec case class Body(
		source: MlDataframeAnalyticsSource, 
		dest: MlDataframeAnalyticsDestination, 
		analysis: MlDataframeAnalysisContainer, 
		description: String, 
		model_memory_limit: String, 
		max_num_threads: integer, 
		analyzed_fields: MlDataframeAnalysisAnalyzedFields, 
		allow_lazy_start: Boolean
	)
}


@JsonCodec case class MlPutDataFrameAnalyticsResponse(
	id: Id, 
	create_time: long, 
	version: VersionString, 
	source: MlDataframeAnalyticsSource, 
	description: String, 
	dest: MlDataframeAnalyticsDestination, 
	model_memory_limit: String, 
	allow_lazy_start: Boolean, 
	max_num_threads: integer, 
	analysis: MlDataframeAnalysisContainer, 
	analyzed_fields: MlDataframeAnalysisAnalyzedFields
)

@JsonCodec case class MlPutDatafeedRequest(
	datafeed_id: Id, 
	allow_no_indices: Boolean, 
	expand_wildcards: ExpandWildcards, 
	ignore_throttled: Boolean, 
	ignore_unavailable: Boolean, 
	body: Body
) extends RequestBase

object MlPutDatafeedRequest {
	@JsonCodec case class Body(
		aggregations: Record[String, AggregationsAggregationContainer], 
		chunking_config: MlChunkingConfig, 
		delayed_data_check_config: MlDelayedDataCheckConfig, 
		frequency: Time, 
		indices: Seq[String], 
		indexes: Seq[String], 
		indices_options: MlDatafeedIndicesOptions, 
		job_id: Id, 
		max_empty_searches: integer, 
		query: QueryDslQueryContainer, 
		query_delay: Time, 
		runtime_mappings: MappingRuntimeFields, 
		script_fields: Record[String, ScriptField], 
		scroll_size: integer
	)
}


@JsonCodec case class MlPutDatafeedResponse(
	aggregations: Record[String, AggregationsAggregationContainer], 
	chunking_config: MlChunkingConfig, 
	delayed_data_check_config: MlDelayedDataCheckConfig, 
	datafeed_id: Id, 
	frequency: Time, 
	indices: Seq[String], 
	job_id: Id, 
	indices_options: MlDatafeedIndicesOptions, 
	max_empty_searches: integer, 
	query: QueryDslQueryContainer, 
	query_delay: Time, 
	runtime_mappings: MappingRuntimeFields, 
	script_fields: Record[String, ScriptField], 
	scroll_size: integer
)

@JsonCodec case class MlPutFilterRequest(
	filter_id: Id, 
	body: Body
) extends RequestBase

object MlPutFilterRequest {
	@JsonCodec case class Body(
		description: String, 
		items: Seq[String]
	)
}


@JsonCodec case class MlPutFilterResponse(
	description: String, 
	filter_id: Id, 
	items: Seq[String]
)

@JsonCodec case class MlPutJobRequest(
	job_id: Id, 
	body: Body
) extends RequestBase

object MlPutJobRequest {
	@JsonCodec case class Body(
		allow_lazy_open: Boolean, 
		analysis_config: MlAnalysisConfig, 
		analysis_limits: MlAnalysisLimits, 
		background_persist_interval: Time, 
		custom_settings: MlCustomSettings, 
		data_description: MlDataDescription, 
		daily_model_snapshot_retention_after_days: long, 
		groups: Seq[String], 
		description: String, 
		model_plot_config: MlModelPlotConfig, 
		model_snapshot_retention_days: long, 
		results_index_name: IndexName, 
		results_retention_days: long
	)
}


@JsonCodec case class MlPutJobResponse(
	allow_lazy_open: Boolean, 
	analysis_config: MlAnalysisConfig, 
	analysis_limits: MlAnalysisLimits, 
	background_persist_interval: Time, 
	create_time: DateString, 
	custom_settings: MlCustomSettings, 
	data_description: MlDataDescription, 
	daily_model_snapshot_retention_after_days: long, 
	groups: Seq[String], 
	description: String, 
	job_id: Id, 
	job_type: String, 
	model_plot_config: MlModelPlotConfig, 
	model_snapshot_id: Id, 
	model_snapshot_retention_days: long, 
	renormalization_window_days: long, 
	results_index_name: String, 
	results_retention_days: long
)

@JsonCodec case class MlPutTrainedModelRequest(
	stub: String, 
	body: Body
) extends RequestBase

object MlPutTrainedModelRequest {
	@JsonCodec case class Body(
		stub: String
	)
}


@JsonCodec case class MlPutTrainedModelResponse(
	stub: Boolean
)

@JsonCodec case class MlPutTrainedModelAliasRequest(
	model_alias: String, 
	model_id: Id, 
	reassign: Boolean
) extends RequestBase

@JsonCodec case class MlPutTrainedModelAliasResponse extends AcknowledgedResponseBase

@JsonCodec case class MlRevertModelSnapshotRequest(
	job_id: Id, 
	snapshot_id: Id, 
	body: Body
) extends RequestBase

object MlRevertModelSnapshotRequest {
	@JsonCodec case class Body(
		delete_intervening_results: Boolean
	)
}


@JsonCodec case class MlRevertModelSnapshotResponse(
	model: MlModelSnapshot
)

@JsonCodec case class MlSetUpgradeModeRequest(
	enabled: Boolean, 
	timeout: Time
) extends RequestBase

@JsonCodec case class MlSetUpgradeModeResponse extends AcknowledgedResponseBase

@JsonCodec case class MlStartDataFrameAnalyticsRequest(
	id: Id, 
	timeout: Time
) extends RequestBase

@JsonCodec case class MlStartDataFrameAnalyticsResponse(
	node: NodeId
) extends AcknowledgedResponseBase

@JsonCodec case class MlStartDatafeedRequest(
	datafeed_id: Id, 
	start: Time, 
	body: Body
) extends RequestBase

object MlStartDatafeedRequest {
	@JsonCodec case class Body(
		end: Time, 
		start: Time, 
		timeout: Time
	)
}


@JsonCodec case class MlStartDatafeedResponse(
	node: NodeIds, 
	started: Boolean
)

@JsonCodec case class MlStopDataFrameAnalyticsRequest(
	id: Id, 
	allow_no_match: Boolean, 
	force: Boolean, 
	timeout: Time
) extends RequestBase

@JsonCodec case class MlStopDataFrameAnalyticsResponse(
	stopped: Boolean
)

@JsonCodec case class MlStopDatafeedRequest(
	datafeed_id: Id, 
	allow_no_match: Boolean, 
	force: Boolean, 
	body: Body
) extends RequestBase

object MlStopDatafeedRequest {
	@JsonCodec case class Body(
		force: Boolean, 
		timeout: Time
	)
}


@JsonCodec case class MlStopDatafeedResponse(
	stopped: Boolean
)

@JsonCodec case class MlUpdateDataFrameAnalyticsRequest(
	id: Id, 
	body: Body
) extends RequestBase

object MlUpdateDataFrameAnalyticsRequest {
	@JsonCodec case class Body(
		description: String, 
		model_memory_limit: String, 
		max_num_threads: integer, 
		allow_lazy_start: Boolean
	)
}


@JsonCodec case class MlUpdateDataFrameAnalyticsResponse(
	id: Id, 
	create_time: long, 
	version: VersionString, 
	source: MlDataframeAnalyticsSource, 
	description: String, 
	dest: MlDataframeAnalyticsDestination, 
	model_memory_limit: String, 
	allow_lazy_start: Boolean, 
	max_num_threads: integer, 
	analysis: MlDataframeAnalysisContainer, 
	analyzed_fields: MlDataframeAnalysisAnalyzedFields
)

@JsonCodec case class MlUpdateFilterRequest(
	filter_id: Id, 
	body: Body
) extends RequestBase

object MlUpdateFilterRequest {
	@JsonCodec case class Body(
		add_items: Seq[String], 
		description: String, 
		remove_items: Seq[String]
	)
}


@JsonCodec case class MlUpdateFilterResponse(
	description: String, 
	filter_id: Id, 
	items: Seq[String]
)

@JsonCodec case class MlUpdateJobRequest(
	job_id: Id, 
	body: Body
) extends RequestBase

object MlUpdateJobRequest {
	@JsonCodec case class Body(
		allow_lazy_open: Boolean, 
		analysis_limits: MlAnalysisMemoryLimit, 
		background_persist_interval: Time, 
		custom_settings: Record[String, Any], 
		categorization_filters: Seq[String], 
		description: String, 
		model_plot_config: MlModelPlotConfig, 
		daily_model_snapshot_retention_after_days: long, 
		model_snapshot_retention_days: long, 
		renormalization_window_days: long, 
		results_retention_days: long, 
		groups: Seq[String], 
		detectors: Seq[MlDetector], 
		per_partition_categorization: MlPerPartitionCategorization
	)
}


@JsonCodec case class MlUpdateJobResponse(
	stub: Boolean
)

@JsonCodec case class MlUpdateModelSnapshotRequest(
	job_id: Id, 
	snapshot_id: Id, 
	body: Body
) extends RequestBase

object MlUpdateModelSnapshotRequest {
	@JsonCodec case class Body(
		description: String, 
		retain: Boolean
	)
}


@JsonCodec case class MlUpdateModelSnapshotResponse(
	model: MlModelSnapshot
) extends AcknowledgedResponseBase

@JsonCodec case class MlUpgradeJobSnapshotRequest(
	job_id: Id, 
	snapshot_id: Id, 
	wait_for_completion: Boolean, 
	timeout: Time
) extends RequestBase

@JsonCodec case class MlUpgradeJobSnapshotResponse(
	node: NodeId, 
	completed: Boolean
)

@JsonCodec case class MlValidateDetectorRequest(
	body: MlDetector
) extends RequestBase

@JsonCodec case class MlValidateDetectorResponse extends AcknowledgedResponseBase

@JsonCodec case class MlValidateJobRequest(
	body: Body
) extends RequestBase

object MlValidateJobRequest {
	@JsonCodec case class Body(
		job_id: Id, 
		analysis_config: MlAnalysisConfig, 
		analysis_limits: MlAnalysisLimits, 
		data_description: MlDataDescription, 
		description: String, 
		model_plot: MlModelPlotConfig, 
		model_snapshot_retention_days: long, 
		results_index_name: IndexName
	)
}


@JsonCodec case class MlValidateJobResponse extends AcknowledgedResponseBase

@JsonCodec case class MonitoringBulkRequest(
	stub_a: String, 
	stub_b: String, 
	body: Body
) extends RequestBase

object MonitoringBulkRequest {
	@JsonCodec case class Body(
		stub_c: String
	)
}


@JsonCodec case class MonitoringBulkResponse(
	stub: integer
)

@JsonCodec case class NodesAdaptiveSelection(
	avg_queue_size: long, 
	avg_response_time: long, 
	avg_response_time_ns: long, 
	avg_service_time: String, 
	avg_service_time_ns: long, 
	outgoing_searches: long, 
	rank: String
)

@JsonCodec case class NodesBreaker(
	estimated_size: String, 
	estimated_size_in_bytes: long, 
	limit_size: String, 
	limit_size_in_bytes: long, 
	overhead: float, 
	tripped: float
)

@JsonCodec case class NodesCpu(
	percent: integer, 
	sys: String, 
	sys_in_millis: long, 
	total: String, 
	total_in_millis: long, 
	user: String, 
	user_in_millis: long, 
	load_average: Record[String, double]
)

@JsonCodec case class NodesDataPathStats(
	available: String, 
	available_in_bytes: long, 
	disk_queue: String, 
	disk_reads: long, 
	disk_read_size: String, 
	disk_read_size_in_bytes: long, 
	disk_writes: long, 
	disk_write_size: String, 
	disk_write_size_in_bytes: long, 
	free: String, 
	free_in_bytes: long, 
	mount: String, 
	path: String, 
	total: String, 
	total_in_bytes: long, 
	`type`: String
)

@JsonCodec case class NodesExtendedMemoryStats(
	free_percent: integer, 
	used_percent: integer, 
	total_in_bytes: integer, 
	free_in_bytes: integer, 
	used_in_bytes: integer
) extends NodesMemoryStats

@JsonCodec case class NodesFileSystem(
	data: Seq[NodesDataPathStats], 
	timestamp: long, 
	total: NodesFileSystemTotal
)

@JsonCodec case class NodesFileSystemTotal(
	available: String, 
	available_in_bytes: long, 
	free: String, 
	free_in_bytes: long, 
	total: String, 
	total_in_bytes: long
)

@JsonCodec case class NodesGarbageCollector(
	collectors: Record[String, NodesGarbageCollectorTotal]
)

@JsonCodec case class NodesGarbageCollectorTotal(
	collection_count: long, 
	collection_time: String, 
	collection_time_in_millis: long
)

@JsonCodec case class NodesHttp(
	current_open: integer, 
	total_opened: long
)

@JsonCodec case class NodesIngest(
	pipelines: Record[String, NodesIngestTotal], 
	total: NodesIngestTotal
)

@JsonCodec case class NodesIngestTotal(
	count: long, 
	current: long, 
	failed: long, 
	processors: Seq[NodesKeyedProcessor], 
	time_in_millis: long
)

@JsonCodec case class NodesJvm(
	buffer_pools: Record[String, NodesNodeBufferPool], 
	classes: NodesJvmClasses, 
	gc: NodesGarbageCollector, 
	mem: NodesMemoryStats, 
	threads: NodesJvmThreads, 
	timestamp: long, 
	uptime: String, 
	uptime_in_millis: long
)

@JsonCodec case class NodesJvmClasses(
	current_loaded_count: long, 
	total_loaded_count: long, 
	total_unloaded_count: long
)

@JsonCodec case class NodesJvmThreads(
	count: long, 
	peak_count: long
)

@JsonCodec case class NodesKeyedProcessor(
	statistics: NodesProcess, 
	`type`: String
)

@JsonCodec case class NodesMemoryStats(
	resident: String, 
	resident_in_bytes: long, 
	share: String, 
	share_in_bytes: long, 
	total_virtual: String, 
	total_virtual_in_bytes: long, 
	total_in_bytes: long, 
	free_in_bytes: long, 
	used_in_bytes: long
)

@JsonCodec case class NodesNodeBufferPool(
	count: long, 
	total_capacity: String, 
	total_capacity_in_bytes: long, 
	used: String, 
	used_in_bytes: long
)

@JsonCodec case class NodesNodesResponseBase(
	_nodes: NodeStatistics
)

@JsonCodec case class NodesOperatingSystem(
	cpu: NodesCpu, 
	mem: NodesExtendedMemoryStats, 
	swap: NodesMemoryStats, 
	timestamp: long
)

@JsonCodec case class NodesProcess(
	cpu: NodesCpu, 
	mem: NodesMemoryStats, 
	open_file_descriptors: integer, 
	timestamp: long
)

@JsonCodec case class NodesScripting(
	cache_evictions: long, 
	compilations: long
)

@JsonCodec case class NodesStats(
	adaptive_selection: Record[String, NodesAdaptiveSelection], 
	breakers: Record[String, NodesBreaker], 
	fs: NodesFileSystem, 
	host: Host, 
	http: NodesHttp, 
	indices: IndicesStatsIndexStats, 
	ingest: NodesIngest, 
	ip: Ip | Seq[Ip], 
	jvm: NodesJvm, 
	name: Name, 
	os: NodesOperatingSystem, 
	process: NodesProcess, 
	roles: NodeRoles, 
	script: NodesScripting, 
	thread_pool: Record[String, NodesThreadCount], 
	timestamp: long, 
	transport: NodesTransport, 
	transport_address: TransportAddress, 
	attributes: Record[Field, String]
)

@JsonCodec case class NodesThreadCount(
	active: long, 
	completed: long, 
	largest: long, 
	queue: long, 
	rejected: long, 
	threads: long
)

@JsonCodec case class NodesTransport(
	rx_count: long, 
	rx_size: String, 
	rx_size_in_bytes: long, 
	server_open: integer, 
	tx_count: long, 
	tx_size: String, 
	tx_size_in_bytes: long
)

@JsonCodec case class NodesHotThreadsHotThread(
	hosts: Seq[Host], 
	node_id: Id, 
	node_name: Name, 
	threads: Seq[String]
)

@JsonCodec case class NodesHotThreadsRequest(
	node_id: NodeIds, 
	ignore_idle_threads: Boolean, 
	interval: Time, 
	snapshots: long, 
	threads: long, 
	thread_type: ThreadType, 
	timeout: Time
) extends RequestBase

@JsonCodec case class NodesHotThreadsResponse(
	hot_threads: Seq[NodesHotThreadsHotThread]
)

@JsonCodec case class NodesInfoNodeInfo(
	attributes: Record[String, String], 
	build_flavor: String, 
	build_hash: String, 
	build_type: String, 
	host: Host, 
	http: NodesInfoNodeInfoHttp, 
	ip: Ip, 
	jvm: NodesInfoNodeJvmInfo, 
	name: Name, 
	network: NodesInfoNodeInfoNetwork, 
	os: NodesInfoNodeOperatingSystemInfo, 
	plugins: Seq[PluginStats], 
	process: NodesInfoNodeProcessInfo, 
	roles: NodeRoles, 
	settings: NodesInfoNodeInfoSettings, 
	thread_pool: Record[String, NodesInfoNodeThreadPoolInfo], 
	total_indexing_buffer: long, 
	total_indexing_buffer_in_bytes: ByteSize, 
	transport: NodesInfoNodeInfoTransport, 
	transport_address: TransportAddress, 
	version: VersionString, 
	modules: Seq[PluginStats], 
	ingest: NodesInfoNodeInfoIngest, 
	aggregations: Record[String, NodesInfoNodeInfoAggregation]
)

@JsonCodec case class NodesInfoNodeInfoAction(
	destructive_requires_name: String
)

@JsonCodec case class NodesInfoNodeInfoAggregation(
	types: Seq[String]
)

@JsonCodec case class NodesInfoNodeInfoBootstrap(
	memory_lock: String
)

@JsonCodec case class NodesInfoNodeInfoClient(
	`type`: String
)

@JsonCodec case class NodesInfoNodeInfoDiscover(
	seed_hosts: String
)

@JsonCodec case class NodesInfoNodeInfoHttp(
	bound_address: Seq[String], 
	max_content_length: ByteSize, 
	max_content_length_in_bytes: long, 
	publish_address: String
)

@JsonCodec case class NodesInfoNodeInfoIngest(
	processors: Seq[NodesInfoNodeInfoIngestProcessor]
)

@JsonCodec case class NodesInfoNodeInfoIngestProcessor(
	`type`: String
)

@JsonCodec case class NodesInfoNodeInfoJvmMemory(
	direct_max: ByteSize, 
	direct_max_in_bytes: long, 
	heap_init: ByteSize, 
	heap_init_in_bytes: long, 
	heap_max: ByteSize, 
	heap_max_in_bytes: long, 
	non_heap_init: ByteSize, 
	non_heap_init_in_bytes: long, 
	non_heap_max: ByteSize, 
	non_heap_max_in_bytes: long
)

@JsonCodec case class NodesInfoNodeInfoMemory(
	total: String, 
	total_in_bytes: long
)

@JsonCodec case class NodesInfoNodeInfoNetwork(
	primary_interface: NodesInfoNodeInfoNetworkInterface, 
	refresh_interval: integer
)

@JsonCodec case class NodesInfoNodeInfoNetworkInterface(
	address: String, 
	mac_address: String, 
	name: Name
)

@JsonCodec case class NodesInfoNodeInfoOSCPU(
	cache_size: String, 
	cache_size_in_bytes: integer, 
	cores_per_socket: integer, 
	mhz: integer, 
	model: String, 
	total_cores: integer, 
	total_sockets: integer, 
	vendor: String
)

@JsonCodec case class NodesInfoNodeInfoPath(
	logs: String, 
	home: String, 
	repo: Seq[String], 
	data: Seq[String]
)

@JsonCodec case class NodesInfoNodeInfoRepositories(
	url: NodesInfoNodeInfoRepositoriesUrl
)

@JsonCodec case class NodesInfoNodeInfoRepositoriesUrl(
	allowed_urls: String
)

@JsonCodec case class NodesInfoNodeInfoScript(
	allowed_types: String, 
	disable_max_compilations_rate: String
)

@JsonCodec case class NodesInfoNodeInfoSearch(
	remote: NodesInfoNodeInfoSearchRemote
)

@JsonCodec case class NodesInfoNodeInfoSearchRemote(
	connect: String
)

@JsonCodec case class NodesInfoNodeInfoSettings(
	cluster: NodesInfoNodeInfoSettingsCluster, 
	node: NodesInfoNodeInfoSettingsNode, 
	path: NodesInfoNodeInfoPath, 
	repositories: NodesInfoNodeInfoRepositories, 
	discovery: NodesInfoNodeInfoDiscover, 
	action: NodesInfoNodeInfoAction, 
	client: NodesInfoNodeInfoClient, 
	http: NodesInfoNodeInfoSettingsHttp, 
	bootstrap: NodesInfoNodeInfoBootstrap, 
	transport: NodesInfoNodeInfoSettingsTransport, 
	network: NodesInfoNodeInfoSettingsNetwork, 
	xpack: NodesInfoNodeInfoXpack, 
	script: NodesInfoNodeInfoScript, 
	search: NodesInfoNodeInfoSearch
)

@JsonCodec case class NodesInfoNodeInfoSettingsCluster(
	name: Name, 
	routing: IndicesIndexRouting, 
	election: NodesInfoNodeInfoSettingsClusterElection, 
	initial_master_nodes: String
)

@JsonCodec case class NodesInfoNodeInfoSettingsClusterElection(
	strategy: Name
)

@JsonCodec case class NodesInfoNodeInfoSettingsHttp(
	`type`: String | NodesInfoNodeInfoSettingsHttpType, 
	`type.default`: String, 
	compression: Boolean | String, 
	port: integer | String
)

@JsonCodec case class NodesInfoNodeInfoSettingsHttpType(
	default: String
)

@JsonCodec case class NodesInfoNodeInfoSettingsNetwork(
	host: Host
)

@JsonCodec case class NodesInfoNodeInfoSettingsNode(
	name: Name, 
	attr: Record[String, Any], 
	max_local_storage_nodes: String
)

@JsonCodec case class NodesInfoNodeInfoSettingsTransport(
	`type`: String | NodesInfoNodeInfoSettingsTransportType, 
	`type.default`: String, 
	features: NodesInfoNodeInfoSettingsTransportFeatures
)

@JsonCodec case class NodesInfoNodeInfoSettingsTransportFeatures(
	`x-pack`: String
)

@JsonCodec case class NodesInfoNodeInfoSettingsTransportType(
	default: String
)

@JsonCodec case class NodesInfoNodeInfoTransport(
	bound_address: Seq[String], 
	publish_address: String, 
	profiles: Record[String, String]
)

@JsonCodec case class NodesInfoNodeInfoXpack(
	license: NodesInfoNodeInfoXpackLicense, 
	security: NodesInfoNodeInfoXpackSecurity, 
	notification: Record[String, Any]
)

@JsonCodec case class NodesInfoNodeInfoXpackLicense(
	self_generated: NodesInfoNodeInfoXpackLicenseType
)

@JsonCodec case class NodesInfoNodeInfoXpackLicenseType(
	`type`: String
)

@JsonCodec case class NodesInfoNodeInfoXpackSecurity(
	http: NodesInfoNodeInfoXpackSecuritySsl, 
	enabled: String, 
	transport: NodesInfoNodeInfoXpackSecuritySsl, 
	authc: NodesInfoNodeInfoXpackSecurityAuthc
)

@JsonCodec case class NodesInfoNodeInfoXpackSecurityAuthc(
	realms: NodesInfoNodeInfoXpackSecurityAuthcRealms, 
	token: NodesInfoNodeInfoXpackSecurityAuthcToken
)

@JsonCodec case class NodesInfoNodeInfoXpackSecurityAuthcRealms(
	file: Record[String, NodesInfoNodeInfoXpackSecurityAuthcRealmsStatus], 
	native: Record[String, NodesInfoNodeInfoXpackSecurityAuthcRealmsStatus], 
	pki: Record[String, NodesInfoNodeInfoXpackSecurityAuthcRealmsStatus]
)

@JsonCodec case class NodesInfoNodeInfoXpackSecurityAuthcRealmsStatus(
	enabled: String, 
	order: String
)

@JsonCodec case class NodesInfoNodeInfoXpackSecurityAuthcToken(
	enabled: String
)

@JsonCodec case class NodesInfoNodeInfoXpackSecuritySsl(
	ssl: Record[String, String]
)

@JsonCodec case class NodesInfoNodeJvmInfo(
	gc_collectors: Seq[String], 
	mem: NodesInfoNodeInfoJvmMemory, 
	memory_pools: Seq[String], 
	pid: integer, 
	start_time_in_millis: long, 
	version: VersionString, 
	vm_name: Name, 
	vm_vendor: String, 
	vm_version: VersionString, 
	bundled_jdk: Boolean, 
	using_bundled_jdk: Boolean, 
	using_compressed_ordinary_object_pointers: Boolean | String, 
	input_arguments: Seq[String]
)

@JsonCodec case class NodesInfoNodeOperatingSystemInfo(
	arch: String, 
	available_processors: integer, 
	allocated_processors: integer, 
	name: Name, 
	pretty_name: Name, 
	refresh_interval_in_millis: integer, 
	version: VersionString, 
	cpu: NodesInfoNodeInfoOSCPU, 
	mem: NodesInfoNodeInfoMemory, 
	swap: NodesInfoNodeInfoMemory
)

@JsonCodec case class NodesInfoNodeProcessInfo(
	id: long, 
	mlockall: Boolean, 
	refresh_interval_in_millis: long
)

@JsonCodec case class NodesInfoNodeThreadPoolInfo(
	core: integer, 
	keep_alive: String, 
	max: integer, 
	queue_size: integer, 
	size: integer, 
	`type`: String
)

@JsonCodec case class NodesInfoRequest(
	node_id: NodeIds, 
	metric: Metrics, 
	flat_settings: Boolean, 
	master_timeout: Time, 
	timeout: Time
) extends RequestBase

@JsonCodec case class NodesInfoResponse(
	cluster_name: Name, 
	nodes: Record[String, NodesInfoNodeInfo]
) extends NodesNodesResponseBase

@JsonCodec case class NodesReloadSecureSettingsNodeReloadException(
	name: Name, 
	reload_exception: NodesReloadSecureSettingsNodeReloadExceptionCausedBy
)

@JsonCodec case class NodesReloadSecureSettingsNodeReloadExceptionCausedBy(
	`type`: String, 
	reason: String, 
	caused_by: NodesReloadSecureSettingsNodeReloadExceptionCausedBy
)

@JsonCodec case class NodesReloadSecureSettingsRequest(
	node_id: NodeIds, 
	timeout: Time, 
	body: Body
) extends RequestBase

object NodesReloadSecureSettingsRequest {
	@JsonCodec case class Body(
		secure_settings_password: Password
	)
}


@JsonCodec case class NodesReloadSecureSettingsResponse(
	cluster_name: Name, 
	nodes: Record[String, NodesStats | NodesReloadSecureSettingsNodeReloadException]
) extends NodesNodesResponseBase

@JsonCodec case class NodesStatsRequest(
	node_id: NodeIds, 
	metric: Metrics, 
	index_metric: Metrics, 
	completion_fields: Fields, 
	fielddata_fields: Fields, 
	fields: Fields, 
	groups: Boolean, 
	include_segment_file_sizes: Boolean, 
	level: Level, 
	master_timeout: Time, 
	timeout: Time, 
	types: Seq[String], 
	include_unloaded_segments: Boolean
) extends RequestBase

@JsonCodec case class NodesStatsResponse(
	cluster_name: Name, 
	nodes: Record[String, NodesStats]
) extends NodesNodesResponseBase

@JsonCodec case class NodesUsageNodeUsage(
	rest_actions: Record[String, integer], 
	since: EpochMillis, 
	timestamp: EpochMillis, 
	aggregations: Record[String, Any]
)

@JsonCodec case class NodesUsageRequest(
	node_id: NodeIds, 
	metric: Metrics, 
	timeout: Time
) extends RequestBase

@JsonCodec case class NodesUsageResponse(
	cluster_name: Name, 
	nodes: Record[String, NodesUsageNodeUsage]
) extends NodesNodesResponseBase

@JsonCodec case class RollupDateHistogramGrouping(
	delay: Time, 
	field: Field, 
	format: String, 
	interval: Time, 
	calendar_interval: Time, 
	fixed_interval: Time, 
	time_zone: String
)

@JsonCodec case class RollupFieldMetric(
	field: Field, 
	metrics: Seq[RollupMetric]
)

@JsonCodec case class RollupGroupings(
	date_histogram: RollupDateHistogramGrouping, 
	histogram: RollupHistogramGrouping, 
	terms: RollupTermsGrouping
)

@JsonCodec case class RollupHistogramGrouping(
	fields: Fields, 
	interval: long
)
type RollupMetric = "min"" | "max"" | "sum"" | "avg"" | "value_count""

@JsonCodec case class RollupTermsGrouping(
	fields: Fields
)

@JsonCodec case class RollupCreateRollupJobRequest(
	id: Id, 
	body: Body
) extends RequestBase

object RollupCreateRollupJobRequest {
	@JsonCodec case class Body(
		cron: String, 
		groups: RollupGroupings, 
		index_pattern: String, 
		metrics: Seq[RollupFieldMetric], 
		page_size: long, 
		rollup_index: IndexName
	)
}


@JsonCodec case class RollupCreateRollupJobResponse extends AcknowledgedResponseBase

@JsonCodec case class RollupDeleteRollupJobRequest(
	id: Id
) extends RequestBase

@JsonCodec case class RollupDeleteRollupJobResponse(
	task_failures: Seq[RollupDeleteRollupJobTaskFailure]
) extends AcknowledgedResponseBase

@JsonCodec case class RollupDeleteRollupJobTaskFailure(
	task_id: TaskId, 
	node_id: Id, 
	status: String, 
	reason: RollupDeleteRollupJobTaskFailureReason
)

@JsonCodec case class RollupDeleteRollupJobTaskFailureReason(
	`type`: String, 
	reason: String
)

@JsonCodec case class RollupGetRollupCapabilitiesRequest(
	id: Id
) extends RequestBase

@JsonCodec case class RollupGetRollupCapabilitiesResponse extends DictionaryResponseBase[IndexName, RollupGetRollupCapabilitiesRollupCapabilities]

@JsonCodec case class RollupGetRollupCapabilitiesRollupCapabilities(
	rollup_jobs: Seq[RollupGetRollupCapabilitiesRollupCapabilitySummary]
)

@JsonCodec case class RollupGetRollupCapabilitiesRollupCapabilitySummary(
	fields: Record[Field, Record[String, Any]], 
	index_pattern: String, 
	job_id: String, 
	rollup_index: String
)

@JsonCodec case class RollupGetRollupIndexCapabilitiesIndexCapabilities(
	rollup_jobs: Seq[RollupGetRollupIndexCapabilitiesRollupJobSummary]
)

@JsonCodec case class RollupGetRollupIndexCapabilitiesRequest(
	index: Id
) extends RequestBase

@JsonCodec case class RollupGetRollupIndexCapabilitiesResponse extends DictionaryResponseBase[IndexName, RollupGetRollupIndexCapabilitiesIndexCapabilities]

@JsonCodec case class RollupGetRollupIndexCapabilitiesRollupJobSummary(
	fields: Record[Field, Seq[RollupGetRollupIndexCapabilitiesRollupJobSummaryField]], 
	index_pattern: String, 
	job_id: Id, 
	rollup_index: IndexName
)

@JsonCodec case class RollupGetRollupIndexCapabilitiesRollupJobSummaryField(
	agg: String, 
	time_zone: String, 
	calendar_interval: Time
)
type RollupGetRollupJobIndexingJobState = "started"" | "indexing"" | "stopping"" | "stopped"" | "aborting""

@JsonCodec case class RollupGetRollupJobRequest(
	id: Id
) extends RequestBase

@JsonCodec case class RollupGetRollupJobResponse(
	jobs: Seq[RollupGetRollupJobRollupJob]
)

@JsonCodec case class RollupGetRollupJobRollupJob(
	config: RollupGetRollupJobRollupJobConfiguration, 
	stats: RollupGetRollupJobRollupJobStats, 
	status: RollupGetRollupJobRollupJobStatus
)

@JsonCodec case class RollupGetRollupJobRollupJobConfiguration(
	cron: String, 
	groups: RollupGroupings, 
	id: Id, 
	index_pattern: String, 
	metrics: Seq[RollupFieldMetric], 
	page_size: long, 
	rollup_index: IndexName, 
	timeout: Time
)

@JsonCodec case class RollupGetRollupJobRollupJobStats(
	documents_processed: long, 
	index_failures: long, 
	index_time_in_ms: long, 
	index_total: long, 
	pages_processed: long, 
	rollups_indexed: long, 
	search_failures: long, 
	search_time_in_ms: long, 
	search_total: long, 
	trigger_count: long, 
	processing_time_in_ms: long, 
	processing_total: long
)

@JsonCodec case class RollupGetRollupJobRollupJobStatus(
	current_position: Record[String, Any], 
	job_state: RollupGetRollupJobIndexingJobState, 
	upgraded_doc_id: Boolean
)

@JsonCodec case class RollupRollupRequest(
	stubb: integer, 
	stuba: integer, 
	body: Body
) extends RequestBase

object RollupRollupRequest {
	@JsonCodec case class Body(
		stub: integer
	)
}


@JsonCodec case class RollupRollupResponse(
	stub: integer
)

@JsonCodec case class RollupRollupSearchRequest(
	index: Indices, 
	`type`: Type, 
	rest_total_hits_as_int: Boolean, 
	typed_keys: Boolean, 
	body: Body
) extends RequestBase

object RollupRollupSearchRequest {
	@JsonCodec case class Body(
		aggs: Record[String, AggregationsAggregationContainer], 
		query: QueryDslQueryContainer, 
		size: integer
	)
}


@JsonCodec case class RollupRollupSearchResponse[TDocument = None](
	took: long, 
	timed_out: Boolean, 
	terminated_early: Boolean, 
	_shards: ShardStatistics, 
	hits: SearchHitsMetadata[TDocument], 
	aggregations: Record[AggregateName, AggregationsAggregate]
)

@JsonCodec case class RollupStartRollupJobRequest(
	id: Id
) extends RequestBase

@JsonCodec case class RollupStartRollupJobResponse(
	started: Boolean
)

@JsonCodec case class RollupStopRollupJobRequest(
	id: Id, 
	timeout: Time, 
	wait_for_completion: Boolean
) extends RequestBase

@JsonCodec case class RollupStopRollupJobResponse(
	stopped: Boolean
)

@JsonCodec case class SearchableSnapshotsClearCacheRequest(
	index: Indices, 
	expand_wildcards: ExpandWildcards, 
	allow_no_indices: Boolean, 
	ignore_unavailable: Boolean, 
	pretty: Boolean, 
	human: Boolean
) extends RequestBase

@JsonCodec case class SearchableSnapshotsClearCacheResponse(
	stub: integer
)

@JsonCodec case class SearchableSnapshotsMountMountedSnapshot(
	snapshot: Name, 
	indices: Indices, 
	shards: ShardStatistics
)

@JsonCodec case class SearchableSnapshotsMountRequest(
	repository: Name, 
	snapshot: Name, 
	master_timeout: Time, 
	wait_for_completion: Boolean, 
	storage: String, 
	body: Body
) extends RequestBase

object SearchableSnapshotsMountRequest {
	@JsonCodec case class Body(
		index: IndexName, 
		renamed_index: IndexName, 
		index_settings: Record[String, Any], 
		ignore_index_settings: Seq[String]
	)
}


@JsonCodec case class SearchableSnapshotsMountResponse(
	snapshot: SearchableSnapshotsMountMountedSnapshot
)

@JsonCodec case class SearchableSnapshotsRepositoryStatsRequest(
	stub_a: integer, 
	stub_b: integer, 
	body: Body
) extends RequestBase

object SearchableSnapshotsRepositoryStatsRequest {
	@JsonCodec case class Body(
		stub_c: integer
	)
}


@JsonCodec case class SearchableSnapshotsRepositoryStatsResponse(
	stub: integer
)

@JsonCodec case class SearchableSnapshotsStatsRequest(
	stub_a: integer, 
	stub_b: integer, 
	body: Body
) extends RequestBase

object SearchableSnapshotsStatsRequest {
	@JsonCodec case class Body(
		stub_c: integer
	)
}


@JsonCodec case class SearchableSnapshotsStatsResponse(
	stub: integer
)

@JsonCodec case class SecurityApplicationGlobalUserPrivileges(
	manage: SecurityManageUserPrivileges
)

@JsonCodec case class SecurityApplicationPrivileges(
	application: String, 
	privileges: Seq[String], 
	resources: Seq[String]
)

@JsonCodec case class SecurityClusterNode(
	name: Name
)

@JsonCodec case class SecurityCreatedStatus(
	created: Boolean
)

@JsonCodec case class SecurityFieldSecurity(
	except: Fields, 
	grant: Fields
)

@JsonCodec case class SecurityGlobalPrivileges(
	application: SecurityApplicationGlobalUserPrivileges
)

@JsonCodec case class SecurityIndicesPrivileges(
	field_security: SecurityFieldSecurity, 
	names: Indices, 
	privileges: Seq[String], 
	query: String | QueryDslQueryContainer, 
	allow_restricted_indices: Boolean
)

@JsonCodec case class SecurityManageUserPrivileges(
	applications: Seq[String]
)

@JsonCodec case class SecurityRealmInfo(
	name: Name, 
	`type`: String
)

@JsonCodec case class SecurityRoleMapping(
	enabled: Boolean, 
	metadata: Metadata, 
	roles: Seq[String], 
	rules: SecurityRoleMappingRuleBase
)

@JsonCodec sealed trait SecurityRoleMappingRuleBase

@JsonCodec case class SecurityUser(
	email: String, 
	full_name: Name, 
	metadata: Metadata, 
	roles: Seq[String], 
	username: Username, 
	enabled: Boolean
)

@JsonCodec case class SecurityAuthenticateRequest extends RequestBase

@JsonCodec case class SecurityAuthenticateResponse(
	authentication_realm: SecurityRealmInfo, 
	email: String, 
	full_name: Name, 
	lookup_realm: SecurityRealmInfo, 
	metadata: Metadata, 
	roles: Seq[String], 
	username: Username, 
	enabled: Boolean, 
	authentication_type: String, 
	token: SecurityAuthenticateToken
)

@JsonCodec case class SecurityAuthenticateToken(
	name: Name
)

@JsonCodec case class SecurityChangePasswordRequest(
	username: Username, 
	refresh: Refresh, 
	body: Body
) extends RequestBase

object SecurityChangePasswordRequest {
	@JsonCodec case class Body(
		password: Password
	)
}


@JsonCodec sealed trait SecurityChangePasswordResponse

@JsonCodec case class SecurityClearApiKeyCacheRequest(
	ids: Ids
) extends RequestBase

@JsonCodec case class SecurityClearApiKeyCacheResponse(
	_nodes: NodeStatistics, 
	cluster_name: Name, 
	nodes: Record[String, SecurityClusterNode]
)

@JsonCodec case class SecurityClearCachedPrivilegesRequest(
	application: Name
) extends RequestBase

@JsonCodec case class SecurityClearCachedPrivilegesResponse(
	_nodes: NodeStatistics, 
	cluster_name: Name, 
	nodes: Record[String, SecurityClusterNode]
)

@JsonCodec case class SecurityClearCachedRealmsRequest(
	realms: Names, 
	usernames: Seq[String]
) extends RequestBase

@JsonCodec case class SecurityClearCachedRealmsResponse(
	_nodes: NodeStatistics, 
	cluster_name: Name, 
	nodes: Record[String, SecurityClusterNode]
)

@JsonCodec case class SecurityClearCachedRolesRequest(
	name: Names
) extends RequestBase

@JsonCodec case class SecurityClearCachedRolesResponse(
	_nodes: NodeStatistics, 
	cluster_name: Name, 
	nodes: Record[String, SecurityClusterNode]
)

@JsonCodec case class SecurityClearCachedServiceTokensRequest(
	namespace: Namespace, 
	service: Service, 
	name: Names
) extends RequestBase

@JsonCodec case class SecurityClearCachedServiceTokensResponse(
	_nodes: NodeStatistics, 
	cluster_name: Name, 
	nodes: Record[String, SecurityClusterNode]
)

@JsonCodec case class SecurityCreateApiKeyIndexPrivileges(
	names: Indices, 
	privileges: Seq[String]
)

@JsonCodec case class SecurityCreateApiKeyRequest(
	refresh: Refresh, 
	body: Body
) extends RequestBase

object SecurityCreateApiKeyRequest {
	@JsonCodec case class Body(
		expiration: Time, 
		name: Name, 
		role_descriptors: Record[String, SecurityCreateApiKeyRoleDescriptor], 
		metadata: Metadata
	)
}


@JsonCodec case class SecurityCreateApiKeyResponse(
	api_key: String, 
	expiration: long, 
	id: Id, 
	name: Name
)

@JsonCodec case class SecurityCreateApiKeyRoleDescriptor(
	cluster: Seq[String], 
	index: Seq[SecurityCreateApiKeyIndexPrivileges], 
	applications: Seq[SecurityApplicationPrivileges]
)

@JsonCodec case class SecurityCreateServiceTokenRequest(
	namespace: Namespace, 
	service: Service, 
	name: Name
) extends RequestBase

@JsonCodec case class SecurityCreateServiceTokenResponse(
	created: Boolean, 
	token: SecurityCreateServiceTokenToken
)

@JsonCodec case class SecurityCreateServiceTokenToken(
	name: Name, 
	value: String
)

@JsonCodec case class SecurityDeletePrivilegesFoundStatus(
	found: Boolean
)

@JsonCodec case class SecurityDeletePrivilegesRequest(
	application: Name, 
	name: Name, 
	refresh: Refresh
) extends RequestBase

@JsonCodec case class SecurityDeletePrivilegesResponse extends DictionaryResponseBase[String, Record[String, SecurityDeletePrivilegesFoundStatus]]

@JsonCodec case class SecurityDeleteRoleRequest(
	name: Name, 
	refresh: Refresh
) extends RequestBase

@JsonCodec case class SecurityDeleteRoleResponse(
	found: Boolean
)

@JsonCodec case class SecurityDeleteRoleMappingRequest(
	name: Name, 
	refresh: Refresh
) extends RequestBase

@JsonCodec case class SecurityDeleteRoleMappingResponse(
	found: Boolean
)

@JsonCodec case class SecurityDeleteServiceTokenRequest(
	namespace: Namespace, 
	service: Service, 
	name: Name, 
	refresh: Refresh
) extends RequestBase

@JsonCodec case class SecurityDeleteServiceTokenResponse(
	found: Boolean
)

@JsonCodec case class SecurityDeleteUserRequest(
	username: Username, 
	refresh: Refresh
) extends RequestBase

@JsonCodec case class SecurityDeleteUserResponse(
	found: Boolean
)

@JsonCodec case class SecurityDisableUserRequest(
	username: Username, 
	refresh: Refresh
) extends RequestBase

@JsonCodec sealed trait SecurityDisableUserResponse

@JsonCodec case class SecurityEnableUserRequest(
	username: Username, 
	refresh: Refresh
) extends RequestBase

@JsonCodec sealed trait SecurityEnableUserResponse

@JsonCodec case class SecurityGetApiKeyApiKey(
	creation: long, 
	expiration: long, 
	id: Id, 
	invalidated: Boolean, 
	name: Name, 
	realm: String, 
	username: Username, 
	metadata: Metadata
)

@JsonCodec case class SecurityGetApiKeyRequest(
	id: Id, 
	name: Name, 
	owner: Boolean, 
	realm_name: Name, 
	username: Username
) extends RequestBase

@JsonCodec case class SecurityGetApiKeyResponse(
	api_keys: Seq[SecurityGetApiKeyApiKey]
)

@JsonCodec case class SecurityGetBuiltinPrivilegesRequest extends RequestBase

@JsonCodec case class SecurityGetBuiltinPrivilegesResponse(
	cluster: Seq[String], 
	index: Indices
)

@JsonCodec case class SecurityGetPrivilegesRequest(
	application: Name, 
	name: Name
) extends RequestBase

@JsonCodec case class SecurityGetPrivilegesResponse extends DictionaryResponseBase[String, Record[String, SecurityPutPrivilegesActions]]

@JsonCodec case class SecurityGetRoleInlineRoleTemplate(
	template: SecurityGetRoleInlineRoleTemplateSource, 
	format: SecurityGetRoleTemplateFormat
)

@JsonCodec case class SecurityGetRoleInlineRoleTemplateSource(
	source: String
)

@JsonCodec case class SecurityGetRoleInvalidRoleTemplate(
	template: String, 
	format: SecurityGetRoleTemplateFormat
)

@JsonCodec case class SecurityGetRoleRequest(
	name: Name
) extends RequestBase

@JsonCodec case class SecurityGetRoleResponse extends DictionaryResponseBase[String, SecurityGetRoleRole]

@JsonCodec case class SecurityGetRoleRole(
	cluster: Seq[String], 
	indices: Seq[SecurityIndicesPrivileges], 
	metadata: Metadata, 
	run_as: Seq[String], 
	transient_metadata: SecurityGetRoleTransientMetadata, 
	applications: Seq[SecurityApplicationPrivileges], 
	role_templates: Seq[SecurityGetRoleRoleTemplate]
)
type SecurityGetRoleRoleTemplate = SecurityGetRoleInlineRoleTemplate | SecurityGetRoleStoredRoleTemplate | SecurityGetRoleInvalidRoleTemplate

@JsonCodec case class SecurityGetRoleStoredRoleTemplate(
	template: SecurityGetRoleStoredRoleTemplateId, 
	format: SecurityGetRoleTemplateFormat
)

@JsonCodec case class SecurityGetRoleStoredRoleTemplateId(
	id: String
)
type SecurityGetRoleTemplateFormat = "string"" | "json""

@JsonCodec case class SecurityGetRoleTransientMetadata(
	enabled: Boolean
)

@JsonCodec case class SecurityGetRoleMappingRequest(
	name: Name
) extends RequestBase

@JsonCodec case class SecurityGetRoleMappingResponse extends DictionaryResponseBase[String, SecurityRoleMapping]

@JsonCodec case class SecurityGetServiceAccountsRequest(
	namespace: Namespace, 
	service: Service
) extends RequestBase

@JsonCodec case class SecurityGetServiceAccountsResponse extends DictionaryResponseBase[String, SecurityGetServiceAccountsRoleDescriptorWrapper]

@JsonCodec case class SecurityGetServiceAccountsRoleDescriptor(
	cluster: Seq[String], 
	indices: Seq[SecurityIndicesPrivileges], 
	global: Seq[SecurityGlobalPrivileges], 
	applications: Seq[SecurityApplicationPrivileges], 
	metadata: Metadata, 
	run_as: Seq[String], 
	transient_metadata: Record[String, Any]
)

@JsonCodec case class SecurityGetServiceAccountsRoleDescriptorWrapper(
	role_descriptor: SecurityGetServiceAccountsRoleDescriptor
)

@JsonCodec case class SecurityGetServiceCredentialsRequest(
	namespace: Namespace, 
	service: Service
) extends RequestBase

@JsonCodec case class SecurityGetServiceCredentialsResponse(
	service_account: String, 
	node_name: NodeName, 
	count: integer, 
	tokens: Record[String, EmptyObject], 
	file_tokens: Record[String, EmptyObject]
)
type SecurityGetTokenAccessTokenGrantType = "password"" | "client_credentials"" | "_kerberos"" | "refresh_token""

@JsonCodec case class SecurityGetTokenAuthenticatedUser(
	authentication_realm: SecurityGetTokenUserRealm, 
	lookup_realm: SecurityGetTokenUserRealm, 
	authentication_provider: SecurityGetTokenAuthenticationProvider, 
	authentication_type: String
) extends SecurityUser

@JsonCodec case class SecurityGetTokenAuthenticationProvider(
	`type`: String, 
	name: Name
)

@JsonCodec case class SecurityGetTokenRequest(
	body: Body
) extends RequestBase

object SecurityGetTokenRequest {
	@JsonCodec case class Body(
		grant_type: SecurityGetTokenAccessTokenGrantType, 
		scope: String, 
		password: Password, 
		kerberos_ticket: String, 
		refresh_token: String, 
		username: Username
	)
}


@JsonCodec case class SecurityGetTokenResponse(
	access_token: String, 
	expires_in: long, 
	scope: String, 
	`type`: String, 
	refresh_token: String, 
	kerberos_authentication_response_token: String, 
	authentication: SecurityGetTokenAuthenticatedUser
)

@JsonCodec case class SecurityGetTokenUserRealm(
	name: Name, 
	`type`: String
)

@JsonCodec case class SecurityGetUserRequest(
	username: Username | Seq[Username]
) extends RequestBase

@JsonCodec case class SecurityGetUserResponse extends DictionaryResponseBase[String, SecurityUser]

@JsonCodec case class SecurityGetUserPrivilegesRequest(
	application: Name, 
	priviledge: Name
) extends RequestBase

@JsonCodec case class SecurityGetUserPrivilegesResponse(
	applications: Seq[SecurityApplicationPrivileges], 
	cluster: Seq[String], 
	global: Seq[SecurityGlobalPrivileges], 
	indices: Seq[SecurityIndicesPrivileges], 
	run_as: Seq[String]
)

@JsonCodec case class SecurityGrantApiKeyApiKey(
	name: Name, 
	expiration: Time, 
	role_descriptors: Seq[Record[String, Any]]
)
type SecurityGrantApiKeyApiKeyGrantType = "access_token"" | "password""

@JsonCodec case class SecurityGrantApiKeyRequest(
	body: Body
) extends RequestBase

object SecurityGrantApiKeyRequest {
	@JsonCodec case class Body(
		api_key: SecurityGrantApiKeyApiKey, 
		grant_type: SecurityGrantApiKeyApiKeyGrantType, 
		access_token: String, 
		username: Username, 
		password: Password
	)
}


@JsonCodec case class SecurityGrantApiKeyResponse(
	api_key: String, 
	id: Id, 
	name: Name, 
	expiration: EpochMillis
)

@JsonCodec case class SecurityHasPrivilegesApplicationPrivilegesCheck(
	application: String, 
	privileges: Seq[String], 
	resources: Seq[String]
)
type SecurityHasPrivilegesApplicationsPrivileges = Record[Name, SecurityHasPrivilegesResourcePrivileges]

@JsonCodec case class SecurityHasPrivilegesIndexPrivilegesCheck(
	names: Seq[String], 
	privileges: Seq[String]
)
type SecurityHasPrivilegesPrivileges = Record[String, Boolean]

@JsonCodec case class SecurityHasPrivilegesRequest(
	user: Name, 
	body: Body
) extends RequestBase

object SecurityHasPrivilegesRequest {
	@JsonCodec case class Body(
		application: Seq[SecurityHasPrivilegesApplicationPrivilegesCheck], 
		cluster: Seq[String], 
		index: Seq[SecurityHasPrivilegesIndexPrivilegesCheck]
	)
}

type SecurityHasPrivilegesResourcePrivileges = Record[Name, SecurityHasPrivilegesPrivileges]

@JsonCodec case class SecurityHasPrivilegesResponse(
	application: SecurityHasPrivilegesApplicationsPrivileges, 
	cluster: Record[String, Boolean], 
	has_all_requested: Boolean, 
	index: Record[IndexName, SecurityHasPrivilegesPrivileges], 
	username: Username
)

@JsonCodec case class SecurityInvalidateApiKeyRequest(
	body: Body
) extends RequestBase

object SecurityInvalidateApiKeyRequest {
	@JsonCodec case class Body(
		id: Id, 
		ids: Seq[Id], 
		name: Name, 
		owner: Boolean, 
		realm_name: String, 
		username: Username
	)
}


@JsonCodec case class SecurityInvalidateApiKeyResponse(
	error_count: integer, 
	error_details: Seq[ErrorCause], 
	invalidated_api_keys: Seq[String], 
	previously_invalidated_api_keys: Seq[String]
)

@JsonCodec case class SecurityInvalidateTokenRequest(
	body: Body
) extends RequestBase

object SecurityInvalidateTokenRequest {
	@JsonCodec case class Body(
		token: String, 
		refresh_token: String, 
		realm_name: Name, 
		username: Username
	)
}


@JsonCodec case class SecurityInvalidateTokenResponse(
	error_count: long, 
	error_details: Seq[ErrorCause], 
	invalidated_tokens: long, 
	previously_invalidated_tokens: long
)

@JsonCodec case class SecurityPutPrivilegesActions(
	actions: Seq[String], 
	application: String, 
	name: Name, 
	metadata: Metadata
)

@JsonCodec case class SecurityPutPrivilegesRequest(
	refresh: Refresh, 
	body: Record[String, Record[String, SecurityPutPrivilegesActions]]
) extends RequestBase

@JsonCodec case class SecurityPutPrivilegesResponse extends DictionaryResponseBase[String, Record[String, SecurityCreatedStatus]]

@JsonCodec case class SecurityPutRoleRequest(
	name: Name, 
	refresh: Refresh, 
	body: Body
) extends RequestBase

object SecurityPutRoleRequest {
	@JsonCodec case class Body(
		applications: Seq[SecurityApplicationPrivileges], 
		cluster: Seq[String], 
		global: Record[String, Any], 
		indices: Seq[SecurityIndicesPrivileges], 
		metadata: Metadata, 
		run_as: Seq[String], 
		transient_metadata: SecurityGetRoleTransientMetadata
	)
}


@JsonCodec case class SecurityPutRoleResponse(
	role: SecurityCreatedStatus
)

@JsonCodec case class SecurityPutRoleMappingRequest(
	name: Name, 
	refresh: Refresh, 
	body: Body
) extends RequestBase

object SecurityPutRoleMappingRequest {
	@JsonCodec case class Body(
		enabled: Boolean, 
		metadata: Metadata, 
		roles: Seq[String], 
		rules: SecurityRoleMappingRuleBase, 
		run_as: Seq[String]
	)
}


@JsonCodec case class SecurityPutRoleMappingResponse(
	created: Boolean, 
	role_mapping: SecurityCreatedStatus
)

@JsonCodec case class SecurityPutUserRequest(
	username: Username, 
	refresh: Refresh, 
	body: Body
) extends RequestBase

object SecurityPutUserRequest {
	@JsonCodec case class Body(
		username: Username, 
		email: String | null, 
		full_name: String | null, 
		metadata: Metadata, 
		password: Password, 
		password_hash: String, 
		roles: Seq[String], 
		enabled: Boolean
	)
}


@JsonCodec case class SecurityPutUserResponse(
	created: Boolean
)

@JsonCodec case class ShutdownDeleteNodeRequest(
	body: Body
) extends RequestBase

object ShutdownDeleteNodeRequest {
	@JsonCodec case class Body(
		stub: String
	)
}


@JsonCodec case class ShutdownDeleteNodeResponse(
	stub: Boolean
)

@JsonCodec case class ShutdownGetNodeRequest(
	body: Body
) extends RequestBase

object ShutdownGetNodeRequest {
	@JsonCodec case class Body(
		stub: String
	)
}


@JsonCodec case class ShutdownGetNodeResponse(
	stub: Boolean
)

@JsonCodec case class ShutdownPutNodeRequest(
	body: Body
) extends RequestBase

object ShutdownPutNodeRequest {
	@JsonCodec case class Body(
		stub: String
	)
}


@JsonCodec case class ShutdownPutNodeResponse(
	stub: Boolean
)

@JsonCodec case class SlmConfiguration(
	ignore_unavailable: Boolean, 
	include_global_state: Boolean, 
	indices: Indices
)

@JsonCodec case class SlmInProgress(
	name: Name, 
	start_time_millis: DateString, 
	state: String, 
	uuid: Uuid
)

@JsonCodec case class SlmInvocation(
	snapshot_name: Name, 
	time: DateString
)

@JsonCodec case class SlmPolicy(
	config: SlmConfiguration, 
	name: Name, 
	repository: String, 
	retention: SlmRetention, 
	schedule: WatcherCronExpression
)

@JsonCodec case class SlmRetention(
	expire_after: Time, 
	max_count: integer, 
	min_count: integer
)

@JsonCodec case class SlmSnapshotLifecycle(
	in_progress: SlmInProgress, 
	last_failure: SlmInvocation, 
	last_success: SlmInvocation, 
	modified_date: DateString, 
	modified_date_millis: EpochMillis, 
	next_execution: DateString, 
	next_execution_millis: EpochMillis, 
	policy: SlmPolicy, 
	version: VersionNumber, 
	stats: SlmStatistics
)

@JsonCodec case class SlmStatistics(
	retention_deletion_time: DateString, 
	retention_deletion_time_millis: EpochMillis, 
	retention_failed: long, 
	retention_runs: long, 
	retention_timed_out: long, 
	policy: Id, 
	total_snapshots_deleted: long, 
	snapshots_deleted: long, 
	total_snapshot_deletion_failures: long, 
	snapshot_deletion_failures: long, 
	total_snapshots_failed: long, 
	snapshots_failed: long, 
	total_snapshots_taken: long, 
	snapshots_taken: long
)

@JsonCodec case class SlmDeleteLifecycleRequest(
	policy_id: Name
) extends RequestBase

@JsonCodec case class SlmDeleteLifecycleResponse extends AcknowledgedResponseBase

@JsonCodec case class SlmExecuteLifecycleRequest(
	policy_id: Name
) extends RequestBase

@JsonCodec case class SlmExecuteLifecycleResponse(
	snapshot_name: Name
)

@JsonCodec case class SlmExecuteRetentionRequest extends RequestBase

@JsonCodec case class SlmExecuteRetentionResponse extends AcknowledgedResponseBase

@JsonCodec case class SlmGetLifecycleRequest(
	policy_id: Names
) extends RequestBase

@JsonCodec case class SlmGetLifecycleResponse extends DictionaryResponseBase[Id, SlmSnapshotLifecycle]

@JsonCodec case class SlmGetStatsRequest extends RequestBase

@JsonCodec case class SlmGetStatsResponse(
	retention_deletion_time: String, 
	retention_deletion_time_millis: EpochMillis, 
	retention_failed: long, 
	retention_runs: long, 
	retention_timed_out: long, 
	total_snapshots_deleted: long, 
	total_snapshot_deletion_failures: long, 
	total_snapshots_failed: long, 
	total_snapshots_taken: long, 
	policy_stats: Seq[String]
)

@JsonCodec case class SlmGetStatusRequest extends RequestBase

@JsonCodec case class SlmGetStatusResponse(
	operation_mode: LifecycleOperationMode
)

@JsonCodec case class SlmPutLifecycleRequest(
	policy_id: Name, 
	body: Body
) extends RequestBase

object SlmPutLifecycleRequest {
	@JsonCodec case class Body(
		config: SlmConfiguration, 
		name: Name, 
		repository: String, 
		retention: SlmRetention, 
		schedule: WatcherCronExpression
	)
}


@JsonCodec case class SlmPutLifecycleResponse extends AcknowledgedResponseBase

@JsonCodec case class SlmStartRequest extends RequestBase

@JsonCodec case class SlmStartResponse extends AcknowledgedResponseBase

@JsonCodec case class SlmStopRequest extends RequestBase

@JsonCodec case class SlmStopResponse extends AcknowledgedResponseBase

@JsonCodec case class SnapshotFileCountSnapshotStats(
	file_count: integer, 
	size_in_bytes: long
)

@JsonCodec case class SnapshotIndexDetails(
	shard_count: integer, 
	size: ByteSize, 
	size_in_bytes: long, 
	max_segments_per_shard: long
)

@JsonCodec case class SnapshotInfoFeatureState(
	feature_name: String, 
	indices: Indices
)

@JsonCodec case class SnapshotRepository(
	`type`: String, 
	uuid: Uuid, 
	settings: SnapshotRepositorySettings
)

@JsonCodec case class SnapshotRepositorySettings(
	chunk_size: String, 
	compress: String | Boolean, 
	concurrent_streams: String | integer, 
	location: String, 
	read_only: String | Boolean, 
	readonly: String | Boolean
)

@JsonCodec case class SnapshotShardsStats(
	done: long, 
	failed: long, 
	finalizing: long, 
	initializing: long, 
	started: long, 
	total: long
)
type SnapshotShardsStatsStage = "DONE"" | "FAILURE"" | "FINALIZE"" | "INIT"" | "STARTED""

@JsonCodec case class SnapshotShardsStatsSummary(
	incremental: SnapshotShardsStatsSummaryItem, 
	total: SnapshotShardsStatsSummaryItem, 
	start_time_in_millis: long, 
	time_in_millis: long
)

@JsonCodec case class SnapshotShardsStatsSummaryItem(
	file_count: long, 
	size_in_bytes: long
)

@JsonCodec case class SnapshotSnapshotIndexStats(
	shards: Record[String, SnapshotSnapshotShardsStatus], 
	shards_stats: SnapshotShardsStats, 
	stats: SnapshotSnapshotStats
)

@JsonCodec case class SnapshotSnapshotInfo(
	data_streams: Seq[String], 
	duration: Time, 
	duration_in_millis: EpochMillis, 
	end_time: Time, 
	end_time_in_millis: EpochMillis, 
	failures: Seq[SnapshotSnapshotShardFailure], 
	include_global_state: Boolean, 
	indices: Seq[IndexName], 
	index_details: Record[IndexName, SnapshotIndexDetails], 
	metadata: Metadata, 
	reason: String, 
	snapshot: Name, 
	shards: ShardStatistics, 
	start_time: Time, 
	start_time_in_millis: EpochMillis, 
	state: String, 
	uuid: Uuid, 
	version: VersionString, 
	version_id: VersionNumber, 
	feature_states: Seq[SnapshotInfoFeatureState]
)

@JsonCodec case class SnapshotSnapshotShardFailure(
	index: IndexName, 
	node_id: Id, 
	reason: String, 
	shard_id: Id, 
	status: String
)

@JsonCodec case class SnapshotSnapshotShardsStatus(
	stage: SnapshotShardsStatsStage, 
	stats: SnapshotShardsStatsSummary
)

@JsonCodec case class SnapshotSnapshotStats(
	incremental: SnapshotFileCountSnapshotStats, 
	start_time_in_millis: long, 
	time_in_millis: long, 
	total: SnapshotFileCountSnapshotStats
)

@JsonCodec case class SnapshotStatus(
	include_global_state: Boolean, 
	indices: Record[String, SnapshotSnapshotIndexStats], 
	repository: String, 
	shards_stats: SnapshotShardsStats, 
	snapshot: String, 
	state: String, 
	stats: SnapshotSnapshotStats, 
	uuid: Uuid
)

@JsonCodec case class SnapshotCleanupRepositoryCleanupRepositoryResults(
	deleted_blobs: long, 
	deleted_bytes: long
)

@JsonCodec case class SnapshotCleanupRepositoryRequest(
	repository: Name, 
	master_timeout: Time, 
	timeout: Time
) extends RequestBase

@JsonCodec case class SnapshotCleanupRepositoryResponse(
	results: SnapshotCleanupRepositoryCleanupRepositoryResults
)

@JsonCodec case class SnapshotCloneRequest(
	repository: Name, 
	snapshot: Name, 
	target_snapshot: Name, 
	master_timeout: Time, 
	timeout: Time, 
	body: Body
) extends RequestBase

object SnapshotCloneRequest {
	@JsonCodec case class Body(
		indices: String
	)
}


@JsonCodec case class SnapshotCloneResponse extends AcknowledgedResponseBase

@JsonCodec case class SnapshotCreateRequest(
	repository: Name, 
	snapshot: Name, 
	master_timeout: Time, 
	wait_for_completion: Boolean, 
	body: Body
) extends RequestBase

object SnapshotCreateRequest {
	@JsonCodec case class Body(
		ignore_unavailable: Boolean, 
		include_global_state: Boolean, 
		indices: Indices, 
		metadata: Metadata, 
		partial: Boolean
	)
}


@JsonCodec case class SnapshotCreateResponse(
	accepted: Boolean, 
	snapshot: SnapshotSnapshotInfo
)

@JsonCodec case class SnapshotCreateRepositoryRequest(
	repository: Name, 
	master_timeout: Time, 
	timeout: Time, 
	verify: Boolean, 
	body: Body
) extends RequestBase

object SnapshotCreateRepositoryRequest {
	@JsonCodec case class Body(
		repository: SnapshotRepository, 
		`type`: String, 
		settings: SnapshotRepositorySettings
	)
}


@JsonCodec case class SnapshotCreateRepositoryResponse extends AcknowledgedResponseBase

@JsonCodec case class SnapshotDeleteRequest(
	repository: Name, 
	snapshot: Name, 
	master_timeout: Time
) extends RequestBase

@JsonCodec case class SnapshotDeleteResponse extends AcknowledgedResponseBase

@JsonCodec case class SnapshotDeleteRepositoryRequest(
	repository: Names, 
	master_timeout: Time, 
	timeout: Time
) extends RequestBase

@JsonCodec case class SnapshotDeleteRepositoryResponse extends AcknowledgedResponseBase

@JsonCodec case class SnapshotGetRequest(
	repository: Name, 
	snapshot: Names, 
	ignore_unavailable: Boolean, 
	master_timeout: Time, 
	verbose: Boolean, 
	index_details: Boolean, 
	human: Boolean
) extends RequestBase

@JsonCodec case class SnapshotGetResponse(
	responses: Seq[SnapshotGetSnapshotResponseItem], 
	snapshots: Seq[SnapshotSnapshotInfo]
)

@JsonCodec case class SnapshotGetSnapshotResponseItem(
	repository: Name, 
	snapshots: Seq[SnapshotSnapshotInfo], 
	error: ErrorCause
)

@JsonCodec case class SnapshotGetRepositoryRequest(
	repository: Names, 
	local: Boolean, 
	master_timeout: Time
) extends RequestBase

@JsonCodec case class SnapshotGetRepositoryResponse extends DictionaryResponseBase[String, SnapshotRepository]

@JsonCodec case class SnapshotRestoreRequest(
	repository: Name, 
	snapshot: Name, 
	master_timeout: Time, 
	wait_for_completion: Boolean, 
	body: Body
) extends RequestBase

object SnapshotRestoreRequest {
	@JsonCodec case class Body(
		ignore_index_settings: Seq[String], 
		ignore_unavailable: Boolean, 
		include_aliases: Boolean, 
		include_global_state: Boolean, 
		index_settings: IndicesPutSettingsRequest, 
		indices: Indices, 
		partial: Boolean, 
		rename_pattern: String, 
		rename_replacement: String
	)
}


@JsonCodec case class SnapshotRestoreResponse(
	snapshot: SnapshotRestoreSnapshotRestore
)

@JsonCodec case class SnapshotRestoreSnapshotRestore(
	indices: Seq[IndexName], 
	snapshot: String, 
	shards: ShardStatistics
)

@JsonCodec case class SnapshotStatusRequest(
	repository: Name, 
	snapshot: Names, 
	ignore_unavailable: Boolean, 
	master_timeout: Time
) extends RequestBase

@JsonCodec case class SnapshotStatusResponse(
	snapshots: Seq[SnapshotStatus]
)

@JsonCodec case class SnapshotVerifyRepositoryCompactNodeInfo(
	name: Name
)

@JsonCodec case class SnapshotVerifyRepositoryRequest(
	repository: Name, 
	master_timeout: Time, 
	timeout: Time
) extends RequestBase

@JsonCodec case class SnapshotVerifyRepositoryResponse(
	nodes: Record[String, SnapshotVerifyRepositoryCompactNodeInfo]
)

@JsonCodec case class SqlClearCursorRequest(
	body: Body
) extends RequestBase

object SqlClearCursorRequest {
	@JsonCodec case class Body(
		cursor: String
	)
}


@JsonCodec case class SqlClearCursorResponse(
	succeeded: Boolean
)

@JsonCodec case class SqlQueryColumn(
	name: Name, 
	`type`: String
)

@JsonCodec case class SqlQueryRequest(
	format: String, 
	body: Body
) extends RequestBase

object SqlQueryRequest {
	@JsonCodec case class Body(
		columnar: Boolean, 
		cursor: String, 
		fetch_size: integer, 
		filter: QueryDslQueryContainer, 
		query: String, 
		request_timeout: Time, 
		page_timeout: Time, 
		time_zone: String, 
		field_multi_value_leniency: Boolean
	)
}


@JsonCodec case class SqlQueryResponse(
	columns: Seq[SqlQueryColumn], 
	cursor: String, 
	rows: Seq[SqlQueryRow]
)
type SqlQueryRow = Seq[Any]

@JsonCodec case class SqlTranslateRequest(
	body: Body
) extends RequestBase

object SqlTranslateRequest {
	@JsonCodec case class Body(
		fetch_size: integer, 
		filter: QueryDslQueryContainer, 
		query: String, 
		time_zone: String
	)
}


@JsonCodec case class SqlTranslateResponse(
	size: long, 
	_source: Boolean | Fields | SearchSourceFilter, 
	fields: Seq[Record[Field, String]], 
	sort: SearchSort
)

@JsonCodec case class SslGetCertificatesCertificateInformation(
	alias: String, 
	expiry: DateString, 
	format: String, 
	has_private_key: Boolean, 
	path: String, 
	serial_number: String, 
	subject_dn: String
)

@JsonCodec case class SslGetCertificatesRequest extends RequestBase
type SslGetCertificatesResponse = Seq[SslGetCertificatesCertificateInformation]

@JsonCodec case class TaskInfo(
	action: String, 
	cancellable: Boolean, 
	children: Seq[TaskInfo], 
	description: String, 
	headers: HttpHeaders, 
	id: long, 
	node: String, 
	running_time_in_nanos: long, 
	start_time_in_millis: long, 
	status: TaskStatus, 
	`type`: String, 
	parent_task_id: Id
)

@JsonCodec case class TaskState(
	action: String, 
	cancellable: Boolean, 
	description: String, 
	headers: HttpHeaders, 
	id: long, 
	node: String, 
	parent_task_id: TaskId, 
	running_time_in_nanos: long, 
	start_time_in_millis: long, 
	status: TaskStatus, 
	`type`: String
)

@JsonCodec case class TaskStatus(
	batches: long, 
	canceled: String, 
	created: long, 
	deleted: long, 
	noops: long, 
	failures: Seq[String], 
	requests_per_second: float, 
	retries: Retries, 
	throttled: Time, 
	throttled_millis: long, 
	throttled_until: Time, 
	throttled_until_millis: long, 
	timed_out: Boolean, 
	took: long, 
	total: long, 
	updated: long, 
	version_conflicts: long
)

@JsonCodec case class TaskTaskExecutingNode(
	tasks: Record[TaskId, TaskState]
) extends SpecUtilsBaseNode

@JsonCodec case class TaskCancelRequest(
	task_id: TaskId, 
	actions: String | Seq[String], 
	nodes: Seq[String], 
	parent_task_id: String, 
	wait_for_completion: Boolean
) extends RequestBase

@JsonCodec case class TaskCancelResponse(
	node_failures: Seq[ErrorCause], 
	nodes: Record[String, TaskTaskExecutingNode]
)

@JsonCodec case class TaskGetRequest(
	task_id: Id, 
	timeout: Time, 
	wait_for_completion: Boolean
) extends RequestBase

@JsonCodec case class TaskGetResponse(
	completed: Boolean, 
	task: TaskInfo, 
	response: TaskStatus, 
	error: ErrorCause
)

@JsonCodec case class TaskListRequest(
	actions: String | Seq[String], 
	detailed: Boolean, 
	group_by: GroupBy, 
	nodes: Seq[String], 
	parent_task_id: Id, 
	timeout: Time, 
	wait_for_completion: Boolean
) extends RequestBase

@JsonCodec case class TaskListResponse(
	node_failures: Seq[ErrorCause], 
	nodes: Record[String, TaskTaskExecutingNode], 
	tasks: Record[String, TaskInfo] | Seq[TaskInfo]
)

@JsonCodec case class TextStructureFindStructureFieldStat(
	count: integer, 
	cardinality: integer, 
	top_hits: Seq[TextStructureFindStructureTopHit], 
	mean_value: integer, 
	median_value: integer, 
	max_value: integer, 
	min_value: integer, 
	earliest: String, 
	latest: String
)

@JsonCodec case class TextStructureFindStructureRequest[TJsonDocument = None](
	charset: String, 
	column_names: String, 
	delimiter: String, 
	explain: Boolean, 
	format: String, 
	grok_pattern: String, 
	has_header_row: Boolean, 
	line_merge_size_limit: uint, 
	lines_to_sample: uint, 
	quote: String, 
	should_trim_fields: Boolean, 
	timeout: Time, 
	timestamp_field: Field, 
	timestamp_format: String, 
	body: Seq[TJsonDocument]
)

@JsonCodec case class TextStructureFindStructureResponse(
	charset: String, 
	has_header_row: Boolean, 
	has_byte_order_marker: Boolean, 
	format: String, 
	field_stats: Record[Field, TextStructureFindStructureFieldStat], 
	sample_start: String, 
	num_messages_analyzed: integer, 
	mappings: MappingTypeMapping, 
	quote: String, 
	delimiter: String, 
	need_client_timezone: Boolean, 
	num_lines_analyzed: integer, 
	column_names: Seq[String], 
	explanation: Seq[String], 
	grok_pattern: String, 
	multiline_start_pattern: String, 
	exclude_lines_pattern: String, 
	java_timestamp_formats: Seq[String], 
	joda_timestamp_formats: Seq[String], 
	timestamp_field: Field, 
	should_trim_fields: Boolean, 
	ingest_pipeline: IngestPipelineConfig
)

@JsonCodec case class TextStructureFindStructureTopHit(
	count: long, 
	value: Any
)

@JsonCodec case class TransformLatest(
	sort: Field, 
	unique_key: Seq[Field]
)

@JsonCodec case class TransformPivot(
	aggregations: Record[String, AggregationsAggregationContainer], 
	aggs: Record[String, AggregationsAggregationContainer], 
	group_by: Record[String, TransformPivotGroupByContainer], 
	max_page_search_size: integer
)

@JsonCodec case class TransformPivotGroupByContainer(
	date_histogram: AggregationsDateHistogramAggregation, 
	geotile_grid: AggregationsGeoTileGridAggregation, 
	histogram: AggregationsHistogramAggregation, 
	terms: AggregationsTermsAggregation
)

@JsonCodec case class TransformRetentionPolicy(
	field: Field, 
	max_age: Time
)

@JsonCodec case class TransformRetentionPolicyContainer(
	time: TransformRetentionPolicy
)

@JsonCodec case class TransformSettings(
	dates_as_epoch_millis: Boolean, 
	docs_per_second: float, 
	max_page_search_size: integer
)

@JsonCodec case class TransformSyncContainer(
	time: TransformTimeSync
)

@JsonCodec case class TransformTimeSync(
	delay: Time, 
	field: Field
)

@JsonCodec case class TransformDeleteTransformRequest(
	transform_id: Name, 
	force: Boolean
) extends RequestBase

@JsonCodec case class TransformDeleteTransformResponse extends AcknowledgedResponseBase

@JsonCodec case class TransformGetTransformRequest(
	transform_id: Name, 
	allow_no_match: Boolean, 
	from: integer, 
	size: integer, 
	exclude_generated: Boolean
) extends RequestBase

@JsonCodec case class TransformGetTransformResponse(
	count: long, 
	transforms: Seq[Transform]
)

@JsonCodec case class TransformGetTransformStatsCheckpointStats(
	checkpoint: long, 
	checkpoint_progress: TransformGetTransformStatsTransformProgress, 
	timestamp: DateString, 
	timestamp_millis: EpochMillis, 
	time_upper_bound: DateString, 
	time_upper_bound_millis: EpochMillis
)

@JsonCodec case class TransformGetTransformStatsCheckpointing(
	changes_last_detected_at: long, 
	changes_last_detected_at_date_time: DateString, 
	last: TransformGetTransformStatsCheckpointStats, 
	next: TransformGetTransformStatsCheckpointStats, 
	operations_behind: long
)

@JsonCodec case class TransformGetTransformStatsRequest(
	transform_id: Name, 
	allow_no_match: Boolean, 
	from: long, 
	size: long
) extends RequestBase

@JsonCodec case class TransformGetTransformStatsResponse(
	count: long, 
	transforms: Seq[TransformGetTransformStatsTransformStats]
)

@JsonCodec case class TransformGetTransformStatsTransformIndexerStats(
	documents_indexed: long, 
	documents_processed: long, 
	exponential_avg_checkpoint_duration_ms: double, 
	exponential_avg_documents_indexed: double, 
	exponential_avg_documents_processed: double, 
	index_failures: long, 
	index_time_in_ms: long, 
	index_total: long, 
	pages_processed: long, 
	processing_time_in_ms: long, 
	processing_total: long, 
	search_failures: long, 
	search_time_in_ms: long, 
	search_total: long, 
	trigger_count: long
)

@JsonCodec case class TransformGetTransformStatsTransformProgress(
	docs_indexed: long, 
	docs_processed: long, 
	docs_remaining: long, 
	percent_complete: double, 
	total_docs: long
)

@JsonCodec case class TransformGetTransformStatsTransformStats(
	checkpointing: TransformGetTransformStatsCheckpointing, 
	id: Id, 
	node: NodeAttributes, 
	reason: String, 
	state: String, 
	stats: TransformGetTransformStatsTransformIndexerStats
)

@JsonCodec case class TransformPreviewTransformRequest(
	body: Body
) extends RequestBase

object TransformPreviewTransformRequest {
	@JsonCodec case class Body(
		dest: ReindexDestination, 
		description: String, 
		frequency: Time, 
		pivot: TransformPivot, 
		source: ReindexSource, 
		settings: TransformSettings, 
		sync: TransformSyncContainer, 
		retention_policy: TransformRetentionPolicyContainer, 
		latest: TransformLatest
	)
}


@JsonCodec case class TransformPreviewTransformResponse[TTransform = None](
	generated_dest_index: IndicesIndexState, 
	preview: Seq[TTransform]
)

@JsonCodec case class TransformPutTransformRequest(
	transform_id: Id, 
	defer_validation: Boolean
) extends TransformPreviewTransformRequest

@JsonCodec case class TransformPutTransformResponse extends AcknowledgedResponseBase

@JsonCodec case class TransformStartTransformRequest(
	transform_id: Name, 
	timeout: Time
) extends RequestBase

@JsonCodec case class TransformStartTransformResponse extends AcknowledgedResponseBase

@JsonCodec case class TransformStopTransformRequest(
	transform_id: Name, 
	allow_no_match: Boolean, 
	force: Boolean, 
	timeout: Time, 
	wait_for_checkpoint: Boolean, 
	wait_for_completion: Boolean
) extends RequestBase

@JsonCodec case class TransformStopTransformResponse extends AcknowledgedResponseBase

@JsonCodec case class TransformUpdateTransformRequest extends TransformPutTransformRequest

@JsonCodec case class TransformUpdateTransformResponse(
	create_time: long, 
	description: String, 
	dest: ReindexDestination, 
	frequency: Time, 
	id: Id, 
	pivot: TransformPivot, 
	settings: TransformSettings, 
	source: ReindexSource, 
	sync: TransformSyncContainer, 
	version: VersionString
)

@JsonCodec case class WatcherAcknowledgeState(
	state: WatcherAcknowledgementOptions, 
	timestamp: DateString
)
type WatcherAcknowledgementOptions = "awaits_successful_execution"" | "ackable"" | "acked""

@JsonCodec case class WatcherAction(
	action_type: WatcherActionType, 
	condition: WatcherConditionContainer, 
	foreach: String, 
	max_iterations: integer, 
	name: Name, 
	throttle_period: Time, 
	throttle_period_in_millis: EpochMillis, 
	transform: TransformContainer, 
	index: WatcherIndex, 
	logging: WatcherLogging
)
type WatcherActionExecutionMode = "simulate"" | "force_simulate"" | "execute"" | "force_execute"" | "skip""

@JsonCodec case class WatcherActionStatus(
	ack: WatcherAcknowledgeState, 
	last_execution: WatcherExecutionState, 
	last_successful_execution: WatcherExecutionState, 
	last_throttle: WatcherThrottleState
)
type WatcherActionStatusOptions = "success"" | "failure"" | "simulated"" | "throttled""
type WatcherActionType = "email"" | "webhook"" | "index"" | "logging"" | "slack"" | "pagerduty""
type WatcherActions = Record[IndexName, WatcherActionStatus]

@JsonCodec case class WatcherActivationState(
	active: Boolean, 
	timestamp: Timestamp
)

@JsonCodec case class WatcherActivationStatus(
	actions: WatcherActions, 
	state: WatcherActivationState, 
	version: VersionNumber
)

@JsonCodec sealed trait WatcherAlwaysCondition

@JsonCodec case class WatcherArrayCompareCondition(
	array_path: String, 
	comparison: String, 
	path: String, 
	quantifier: WatcherQuantifier, 
	value: Any
)

@JsonCodec case class WatcherChainInput(
	inputs: Seq[WatcherInputContainer]
)

@JsonCodec case class WatcherCompareCondition(
	comparison: String, 
	path: String, 
	value: Any, 
	`ctx.payload.match`: WatcherCompareContextPayloadCondition, 
	`ctx.payload.value`: WatcherCompareContextPayloadCondition
)

@JsonCodec case class WatcherCompareContextPayloadCondition(
	eq: Any, 
	lt: Any, 
	gt: Any, 
	lte: Any, 
	gte: Any
)

@JsonCodec case class WatcherConditionContainer(
	always: WatcherAlwaysCondition, 
	array_compare: WatcherArrayCompareCondition, 
	compare: WatcherCompareCondition, 
	never: WatcherNeverCondition, 
	script: WatcherScriptCondition
)
type WatcherConditionType = "always"" | "never"" | "script"" | "compare"" | "array_compare""
type WatcherConnectionScheme = "http"" | "https""

@JsonCodec case class WatcherCronExpression extends WatcherScheduleBase

@JsonCodec case class WatcherDailySchedule(
	at: Seq[String] | WatcherTimeOfDay
)
type WatcherDay = "sunday"" | "monday"" | "tuesday"" | "wednesday"" | "thursday"" | "friday"" | "saturday""

@JsonCodec case class WatcherEmailResult(
	account: String, 
	message: WatcherEmailResult, 
	reason: String
)
type WatcherExecutionPhase = "awaits_execution"" | "started"" | "input"" | "condition"" | "actions"" | "watch_transform"" | "aborted"" | "finished""

@JsonCodec case class WatcherExecutionResult(
	actions: Seq[WatcherExecutionResultAction], 
	condition: WatcherExecutionResultCondition, 
	execution_duration: integer, 
	execution_time: DateString, 
	input: WatcherExecutionResultInput
)

@JsonCodec case class WatcherExecutionResultAction(
	email: WatcherEmailResult, 
	id: Id, 
	index: WatcherIndexResult, 
	logging: WatcherLoggingResult, 
	pagerduty: WatcherPagerDutyResult, 
	reason: String, 
	slack: WatcherSlackResult, 
	status: WatcherActionStatusOptions, 
	`type`: WatcherActionType, 
	webhook: WatcherWebhookResult
)

@JsonCodec case class WatcherExecutionResultCondition(
	met: Boolean, 
	status: WatcherActionStatusOptions, 
	`type`: WatcherConditionType
)

@JsonCodec case class WatcherExecutionResultInput(
	payload: Record[String, Any], 
	status: WatcherActionStatusOptions, 
	`type`: WatcherInputType
)

@JsonCodec case class WatcherExecutionState(
	successful: Boolean, 
	timestamp: DateString
)
type WatcherExecutionStatus = "awaits_execution"" | "checking"" | "execution_not_needed"" | "throttled"" | "executed"" | "failed"" | "deleted_while_queued"" | "not_executed_already_queued""

@JsonCodec case class WatcherExecutionThreadPool(
	max_size: long, 
	queue_size: long
)

@JsonCodec case class WatcherHourlySchedule(
	minute: Seq[integer]
)

@JsonCodec case class WatcherHttpInput(
	http: WatcherHttpInput, 
	extract: Seq[String], 
	request: WatcherHttpInputRequestDefinition, 
	response_content_type: WatcherResponseContentType
)

@JsonCodec case class WatcherHttpInputAuthentication(
	basic: WatcherHttpInputBasicAuthentication
)

@JsonCodec case class WatcherHttpInputBasicAuthentication(
	password: Password, 
	username: Username
)
type WatcherHttpInputMethod = "head"" | "get"" | "post"" | "put"" | "delete""

@JsonCodec case class WatcherHttpInputProxy(
	host: Host, 
	port: uint
)

@JsonCodec case class WatcherHttpInputRequestDefinition(
	auth: WatcherHttpInputAuthentication, 
	body: String, 
	connection_timeout: Time, 
	headers: Record[String, String], 
	host: Host, 
	method: WatcherHttpInputMethod, 
	params: Record[String, String], 
	path: String, 
	port: uint, 
	proxy: WatcherHttpInputProxy, 
	read_timeout: Time, 
	scheme: WatcherConnectionScheme, 
	url: String
)

@JsonCodec case class WatcherHttpInputRequestResult extends WatcherHttpInputRequestDefinition

@JsonCodec case class WatcherHttpInputResponseResult(
	body: String, 
	headers: HttpHeaders, 
	status: integer
)

@JsonCodec case class WatcherIndex(
	index: IndexName, 
	doc_id: Id
)

@JsonCodec case class WatcherIndexResult(
	response: WatcherIndexResultSummary
)

@JsonCodec case class WatcherIndexResultSummary(
	created: Boolean, 
	id: Id, 
	index: IndexName, 
	result: Result, 
	version: VersionNumber, 
	`type`: Type
)

@JsonCodec case class WatcherIndicesOptions(
	allow_no_indices: Boolean, 
	expand_wildcards: ExpandWildcards, 
	ignore_unavailable: Boolean, 
	ignore_throttled: Boolean
)

@JsonCodec case class WatcherInputContainer(
	chain: WatcherChainInput, 
	http: WatcherHttpInput, 
	search: WatcherSearchInput, 
	simple: Record[String, Any]
)
type WatcherInputType = "http"" | "search"" | "simple""

@JsonCodec case class WatcherLogging(
	level: String, 
	text: String
)

@JsonCodec case class WatcherLoggingResult(
	logged_text: String
)
type WatcherMonth = "january"" | "february"" | "march"" | "april"" | "may"" | "june"" | "july"" | "august"" | "september"" | "october"" | "november"" | "december""

@JsonCodec sealed trait WatcherNeverCondition

@JsonCodec case class WatcherPagerDutyActionEventResult(
	event: WatcherPagerDutyEvent, 
	reason: String, 
	request: WatcherHttpInputRequestResult, 
	response: WatcherHttpInputResponseResult
)

@JsonCodec case class WatcherPagerDutyContext(
	href: String, 
	src: String, 
	`type`: WatcherPagerDutyContextType
)
type WatcherPagerDutyContextType = "link"" | "image""

@JsonCodec case class WatcherPagerDutyEvent(
	account: String, 
	attach_payload: Boolean, 
	client: String, 
	client_url: String, 
	context: Seq[WatcherPagerDutyContext], 
	description: String, 
	event_type: WatcherPagerDutyEventType, 
	incident_key: String
)
type WatcherPagerDutyEventType = "trigger"" | "resolve"" | "acknowledge""

@JsonCodec case class WatcherPagerDutyResult(
	sent_event: WatcherPagerDutyActionEventResult
)
type WatcherQuantifier = "some"" | "all""
type WatcherResponseContentType = "json"" | "yaml"" | "text""

@JsonCodec sealed trait WatcherScheduleBase

@JsonCodec case class WatcherScheduleContainer(
	cron: WatcherCronExpression, 
	daily: WatcherDailySchedule, 
	hourly: WatcherHourlySchedule, 
	interval: Time, 
	monthly: Seq[WatcherTimeOfMonth], 
	weekly: Seq[WatcherTimeOfWeek], 
	yearly: Seq[WatcherTimeOfYear]
)

@JsonCodec case class WatcherScheduleTriggerEvent(
	scheduled_time: DateString | String, 
	triggered_time: DateString | String
)

@JsonCodec case class WatcherScriptCondition(
	lang: String, 
	params: Record[String, Any], 
	source: String
)

@JsonCodec case class WatcherSearchInput(
	extract: Seq[String], 
	request: WatcherSearchInputRequestDefinition, 
	timeout: Time
)

@JsonCodec case class WatcherSearchInputRequestBody(
	query: QueryDslQueryContainer
)

@JsonCodec case class WatcherSearchInputRequestDefinition(
	body: WatcherSearchInputRequestBody, 
	indices: Seq[IndexName], 
	indices_options: WatcherIndicesOptions, 
	search_type: SearchType, 
	template: SearchTemplateRequest, 
	rest_total_hits_as_int: Boolean
)

@JsonCodec case class WatcherSimulatedActions(
	actions: Seq[String], 
	all: WatcherSimulatedActions, 
	use_all: Boolean
)

@JsonCodec case class WatcherSlackAttachment(
	author_icon: String, 
	author_link: String, 
	author_name: String, 
	color: String, 
	fallback: String, 
	fields: Seq[WatcherSlackAttachmentField], 
	footer: String, 
	footer_icon: String, 
	image_url: String, 
	pretext: String, 
	text: String, 
	thumb_url: String, 
	title: String, 
	title_link: String, 
	ts: DateString
)

@JsonCodec case class WatcherSlackAttachmentField(
	short: Boolean, 
	title: String, 
	value: String
)

@JsonCodec case class WatcherSlackDynamicAttachment(
	attachment_template: WatcherSlackAttachment, 
	list_path: String
)

@JsonCodec case class WatcherSlackMessage(
	attachments: Seq[WatcherSlackAttachment], 
	dynamic_attachments: WatcherSlackDynamicAttachment, 
	from: String, 
	icon: String, 
	text: String, 
	to: Seq[String]
)

@JsonCodec case class WatcherSlackResult(
	account: String, 
	message: WatcherSlackMessage
)

@JsonCodec case class WatcherThrottleState(
	reason: String, 
	timestamp: DateString
)

@JsonCodec case class WatcherTimeOfDay(
	hour: Seq[integer], 
	minute: Seq[integer]
)

@JsonCodec case class WatcherTimeOfMonth(
	at: Seq[String], 
	on: Seq[integer]
)

@JsonCodec case class WatcherTimeOfWeek(
	at: Seq[String], 
	on: Seq[WatcherDay]
)

@JsonCodec case class WatcherTimeOfYear(
	at: Seq[String], 
	int: Seq[WatcherMonth], 
	on: Seq[integer]
)

@JsonCodec case class WatcherTriggerContainer(
	schedule: WatcherScheduleContainer
)

@JsonCodec case class WatcherTriggerEventContainer(
	schedule: WatcherScheduleTriggerEvent
)

@JsonCodec case class WatcherTriggerEventResult(
	manual: WatcherTriggerEventContainer, 
	triggered_time: DateString, 
	`type`: String
)

@JsonCodec case class WatcherWatch(
	actions: Record[IndexName, WatcherAction], 
	condition: WatcherConditionContainer, 
	input: WatcherInputContainer, 
	metadata: Metadata, 
	status: WatcherWatchStatus, 
	throttle_period: String, 
	transform: TransformContainer, 
	trigger: WatcherTriggerContainer, 
	throttle_period_in_millis: long
)

@JsonCodec case class WatcherWatchStatus(
	actions: WatcherActions, 
	last_checked: DateString, 
	last_met_condition: DateString, 
	state: WatcherActivationState, 
	version: VersionNumber, 
	execution_state: String
)

@JsonCodec case class WatcherWebhookResult(
	request: WatcherHttpInputRequestResult, 
	response: WatcherHttpInputResponseResult
)

@JsonCodec case class WatcherAckWatchRequest(
	watch_id: Name, 
	action_id: Names
) extends RequestBase

@JsonCodec case class WatcherAckWatchResponse(
	status: WatcherWatchStatus
)

@JsonCodec case class WatcherActivateWatchRequest(
	watch_id: Name
) extends RequestBase

@JsonCodec case class WatcherActivateWatchResponse(
	status: WatcherActivationStatus
)

@JsonCodec case class WatcherDeactivateWatchRequest(
	watch_id: Name
) extends RequestBase

@JsonCodec case class WatcherDeactivateWatchResponse(
	status: WatcherActivationStatus
)

@JsonCodec case class WatcherDeleteWatchRequest(
	id: Name
) extends RequestBase

@JsonCodec case class WatcherDeleteWatchResponse(
	found: Boolean, 
	_id: Id, 
	_version: VersionNumber
)

@JsonCodec case class WatcherExecuteWatchRequest(
	id: Id, 
	debug: Boolean, 
	body: Body
) extends RequestBase

object WatcherExecuteWatchRequest {
	@JsonCodec case class Body(
		action_modes: Record[String, WatcherActionExecutionMode], 
		alternative_input: Record[String, Any], 
		ignore_condition: Boolean, 
		record_execution: Boolean, 
		simulated_actions: WatcherSimulatedActions, 
		trigger_data: WatcherScheduleTriggerEvent, 
		watch: WatcherWatch
	)
}


@JsonCodec case class WatcherExecuteWatchResponse(
	_id: Id, 
	watch_record: WatcherExecuteWatchWatchRecord
)

@JsonCodec case class WatcherExecuteWatchWatchRecord(
	condition: WatcherConditionContainer, 
	input: WatcherInputContainer, 
	messages: Seq[String], 
	metadata: Metadata, 
	node: String, 
	result: WatcherExecutionResult, 
	state: WatcherExecutionStatus, 
	trigger_event: WatcherTriggerEventResult, 
	user: Username, 
	watch_id: Id
)

@JsonCodec case class WatcherGetWatchRequest(
	id: Name
) extends RequestBase

@JsonCodec case class WatcherGetWatchResponse(
	found: Boolean, 
	_id: Id, 
	status: WatcherWatchStatus, 
	watch: WatcherWatch, 
	_primary_term: integer, 
	_seq_no: SequenceNumber, 
	_version: VersionNumber
)

@JsonCodec case class WatcherPutWatchRequest(
	id: Id, 
	active: Boolean, 
	if_primary_term: long, 
	if_sequence_number: long, 
	version: VersionNumber, 
	body: Body
) extends RequestBase

object WatcherPutWatchRequest {
	@JsonCodec case class Body(
		actions: Record[String, WatcherAction], 
		condition: WatcherConditionContainer, 
		input: WatcherInputContainer, 
		metadata: Metadata, 
		throttle_period: String, 
		transform: TransformContainer, 
		trigger: WatcherTriggerContainer
	)
}


@JsonCodec case class WatcherPutWatchResponse(
	created: Boolean, 
	_id: Id, 
	_primary_term: long, 
	_seq_no: SequenceNumber, 
	_version: VersionNumber
)

@JsonCodec case class WatcherQueryWatchesRequest(
	stub_a: String, 
	stub_b: String, 
	body: Body
) extends RequestBase

object WatcherQueryWatchesRequest {
	@JsonCodec case class Body(
		stub_c: String
	)
}


@JsonCodec case class WatcherQueryWatchesResponse(
	stub: integer
)

@JsonCodec case class WatcherStartRequest extends RequestBase

@JsonCodec case class WatcherStartResponse extends AcknowledgedResponseBase

@JsonCodec case class WatcherStatsRequest(
	metric: WatcherStatsWatcherMetric | Seq[WatcherStatsWatcherMetric], 
	emit_stacktraces: Boolean
) extends RequestBase

@JsonCodec case class WatcherStatsResponse(
	_nodes: NodeStatistics, 
	cluster_name: Name, 
	manually_stopped: Boolean, 
	stats: Seq[WatcherStatsWatcherNodeStats]
)

@JsonCodec case class WatcherStatsWatchRecordQueuedStats(
	execution_time: DateString
)

@JsonCodec case class WatcherStatsWatchRecordStats(
	execution_phase: WatcherExecutionPhase, 
	triggered_time: DateString, 
	executed_actions: Seq[String], 
	watch_id: Id, 
	watch_record_id: Id
) extends WatcherStatsWatchRecordQueuedStats
type WatcherStatsWatcherMetric = "_all"" | "queued_watches"" | "current_watches"" | "pending_watches""

@JsonCodec case class WatcherStatsWatcherNodeStats(
	current_watches: Seq[WatcherStatsWatchRecordStats], 
	execution_thread_pool: WatcherExecutionThreadPool, 
	queued_watches: Seq[WatcherStatsWatchRecordQueuedStats], 
	watch_count: long, 
	watcher_state: WatcherStatsWatcherState, 
	node_id: Id
)
type WatcherStatsWatcherState = "stopped"" | "starting"" | "started"" | "stopping""

@JsonCodec case class WatcherStopRequest extends RequestBase

@JsonCodec case class WatcherStopResponse extends AcknowledgedResponseBase

@JsonCodec case class XpackInfoBuildInformation(
	date: DateString, 
	hash: String
)

@JsonCodec case class XpackInfoFeature(
	available: Boolean, 
	description: String, 
	enabled: Boolean, 
	native_code_info: XpackInfoNativeCodeInformation
)

@JsonCodec case class XpackInfoFeatures(
	aggregate_metric: XpackInfoFeature, 
	analytics: XpackInfoFeature, 
	ccr: XpackInfoFeature, 
	data_frame: XpackInfoFeature, 
	data_science: XpackInfoFeature, 
	data_streams: XpackInfoFeature, 
	data_tiers: XpackInfoFeature, 
	enrich: XpackInfoFeature, 
	eql: XpackInfoFeature, 
	flattened: XpackInfoFeature, 
	frozen_indices: XpackInfoFeature, 
	graph: XpackInfoFeature, 
	ilm: XpackInfoFeature, 
	logstash: XpackInfoFeature, 
	ml: XpackInfoFeature, 
	monitoring: XpackInfoFeature, 
	rollup: XpackInfoFeature, 
	runtime_fields: XpackInfoFeature, 
	searchable_snapshots: XpackInfoFeature, 
	security: XpackInfoFeature, 
	slm: XpackInfoFeature, 
	spatial: XpackInfoFeature, 
	sql: XpackInfoFeature, 
	transform: XpackInfoFeature, 
	vectors: XpackInfoFeature, 
	voting_only: XpackInfoFeature, 
	watcher: XpackInfoFeature
)

@JsonCodec case class XpackInfoMinimalLicenseInformation(
	expiry_date_in_millis: EpochMillis, 
	mode: LicenseLicenseType, 
	status: LicenseLicenseStatus, 
	`type`: LicenseLicenseType, 
	uid: String
)

@JsonCodec case class XpackInfoNativeCodeInformation(
	build_hash: String, 
	version: VersionString
)

@JsonCodec case class XpackInfoRequest(
	categories: Seq[String]
) extends RequestBase

@JsonCodec case class XpackInfoResponse(
	build: XpackInfoBuildInformation, 
	features: XpackInfoFeatures, 
	license: XpackInfoMinimalLicenseInformation, 
	tagline: String
)

@JsonCodec case class XpackUsageAnalytics(
	stats: XpackUsageAnalyticsStatistics
) extends XpackUsageBase

@JsonCodec case class XpackUsageAnalyticsStatistics(
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

@JsonCodec case class XpackUsageAudit(
	outputs: Seq[String]
) extends XpackUsageFeatureToggle

@JsonCodec case class XpackUsageBase(
	available: Boolean, 
	enabled: Boolean
)

@JsonCodec case class XpackUsageBaseUrlConfig(
	url_name: String, 
	url_value: String
)

@JsonCodec case class XpackUsageCcr(
	auto_follow_patterns_count: integer, 
	follower_indices_count: integer
) extends XpackUsageBase

@JsonCodec case class XpackUsageCounter(
	active: long, 
	total: long
)

@JsonCodec case class XpackUsageDataStreams(
	data_streams: long, 
	indices_count: long
) extends XpackUsageBase

@JsonCodec case class XpackUsageDataTierPhaseStatistics(
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

@JsonCodec case class XpackUsageDataTiers(
	data_warm: XpackUsageDataTierPhaseStatistics, 
	data_frozen: XpackUsageDataTierPhaseStatistics, 
	data_cold: XpackUsageDataTierPhaseStatistics, 
	data_content: XpackUsageDataTierPhaseStatistics, 
	data_hot: XpackUsageDataTierPhaseStatistics
) extends XpackUsageBase

@JsonCodec case class XpackUsageDatafeed(
	count: long
)

@JsonCodec case class XpackUsageEql(
	features: XpackUsageEqlFeatures, 
	queries: Record[String, XpackUsageQuery]
) extends XpackUsageBase

@JsonCodec case class XpackUsageEqlFeatures(
	join: uint, 
	joins: XpackUsageEqlFeaturesJoin, 
	keys: XpackUsageEqlFeaturesKeys, 
	event: uint, 
	pipes: XpackUsageEqlFeaturesPipes, 
	sequence: uint, 
	sequences: XpackUsageEqlFeaturesSequences
)

@JsonCodec case class XpackUsageEqlFeaturesJoin(
	join_queries_two: uint, 
	join_queries_three: uint, 
	join_until: uint, 
	join_queries_five_or_more: uint, 
	join_queries_four: uint
)

@JsonCodec case class XpackUsageEqlFeaturesKeys(
	join_keys_two: uint, 
	join_keys_one: uint, 
	join_keys_three: uint, 
	join_keys_five_or_more: uint, 
	join_keys_four: uint
)

@JsonCodec case class XpackUsageEqlFeaturesPipes(
	pipe_tail: uint, 
	pipe_head: uint
)

@JsonCodec case class XpackUsageEqlFeaturesSequences(
	sequence_queries_three: uint, 
	sequence_queries_four: uint, 
	sequence_queries_two: uint, 
	sequence_until: uint, 
	sequence_queries_five_or_more: uint, 
	sequence_maxspan: uint
)

@JsonCodec case class XpackUsageFeatureToggle(
	enabled: Boolean
)

@JsonCodec case class XpackUsageFlattened(
	field_count: integer
) extends XpackUsageBase

@JsonCodec case class XpackUsageFrozenIndices(
	indices_count: long
) extends XpackUsageBase

@JsonCodec case class XpackUsageIlm(
	policy_count: integer, 
	policy_stats: Seq[XpackUsageIlmPolicyStatistics]
)

@JsonCodec case class XpackUsageIlmPolicyStatistics(
	indices_managed: integer, 
	phases: IlmPhases
)

@JsonCodec case class XpackUsageIpFilter(
	http: Boolean, 
	transport: Boolean
)

@JsonCodec case class XpackUsageKibanaUrlConfig(
	time_range: String
) extends XpackUsageBaseUrlConfig

@JsonCodec case class XpackUsageMachineLearning(
	datafeeds: Record[String, XpackUsageDatafeed], 
	jobs: Record[String, MlJob], 
	node_count: integer, 
	data_frame_analytics_jobs: XpackUsageMlDataFrameAnalyticsJobs, 
	inference: XpackUsageMlInference
) extends XpackUsageBase

@JsonCodec case class XpackUsageMlCounter(
	count: long
)

@JsonCodec case class XpackUsageMlDataFrameAnalyticsJobs(
	memory_usage: XpackUsageMlDataFrameAnalyticsJobsMemory, 
	_all: XpackUsageMlDataFrameAnalyticsJobsCount, 
	analysis_counts: EmptyObject
)

@JsonCodec case class XpackUsageMlDataFrameAnalyticsJobsCount(
	count: long
)

@JsonCodec case class XpackUsageMlDataFrameAnalyticsJobsMemory(
	peak_usage_bytes: MlJobStatistics
)

@JsonCodec case class XpackUsageMlInference(
	ingest_processors: Record[String, XpackUsageMlInferenceIngestProcessor], 
	trained_models: XpackUsageMlInferenceTrainedModels
)

@JsonCodec case class XpackUsageMlInferenceIngestProcessor(
	num_docs_processed: XpackUsageMlInferenceIngestProcessorCount, 
	pipelines: XpackUsageMlCounter, 
	num_failures: XpackUsageMlInferenceIngestProcessorCount, 
	time_ms: XpackUsageMlInferenceIngestProcessorCount
)

@JsonCodec case class XpackUsageMlInferenceIngestProcessorCount(
	max: long, 
	sum: long, 
	min: long
)

@JsonCodec case class XpackUsageMlInferenceTrainedModels(
	estimated_operations: MlJobStatistics, 
	estimated_heap_memory_usage_bytes: MlJobStatistics, 
	count: XpackUsageMlInferenceTrainedModelsCount, 
	_all: XpackUsageMlCounter
)

@JsonCodec case class XpackUsageMlInferenceTrainedModelsCount(
	total: long, 
	prepackaged: long, 
	other: long, 
	regression: long, 
	classification: long
)

@JsonCodec case class XpackUsageMonitoring(
	collection_enabled: Boolean, 
	enabled_exporters: Record[String, long]
) extends XpackUsageBase

@JsonCodec case class XpackUsageQuery(
	count: integer, 
	failed: integer, 
	paging: integer, 
	total: integer
)

@JsonCodec case class XpackUsageRealm(
	name: Seq[String], 
	order: Seq[long], 
	size: Seq[long], 
	cache: Seq[XpackUsageRealmCache], 
	has_authorization_realms: Seq[Boolean], 
	has_default_username_pattern: Seq[Boolean], 
	has_truststore: Seq[Boolean], 
	is_authentication_delegated: Seq[Boolean]
) extends XpackUsageBase

@JsonCodec case class XpackUsageRealmCache(
	size: long
)

@JsonCodec case class XpackUsageRequest(
	master_timeout: Time
) extends RequestBase

@JsonCodec case class XpackUsageResponse(
	aggregate_metric: XpackUsageBase, 
	analytics: XpackUsageAnalytics, 
	watcher: XpackUsageWatcher, 
	ccr: XpackUsageCcr, 
	data_frame: XpackUsageBase, 
	data_science: XpackUsageBase, 
	data_streams: XpackUsageDataStreams, 
	data_tiers: XpackUsageDataTiers, 
	enrich: XpackUsageBase, 
	eql: XpackUsageEql, 
	flattened: XpackUsageFlattened, 
	frozen_indices: XpackUsageFrozenIndices, 
	graph: XpackUsageBase, 
	ilm: XpackUsageIlm, 
	logstash: XpackUsageBase, 
	ml: XpackUsageMachineLearning, 
	monitoring: XpackUsageMonitoring, 
	rollup: XpackUsageBase, 
	runtime_fields: XpackUsageRuntimeFieldTypes, 
	spatial: XpackUsageBase, 
	searchable_snapshots: XpackUsageSearchableSnapshots, 
	security: XpackUsageSecurity, 
	slm: XpackUsageSlm, 
	sql: XpackUsageSql, 
	transform: XpackUsageBase, 
	vectors: XpackUsageVector, 
	voting_only: XpackUsageBase
)

@JsonCodec case class XpackUsageRoleMapping(
	enabled: integer, 
	size: integer
)

@JsonCodec case class XpackUsageRuntimeFieldTypes(
	field_types: Seq[XpackUsageRuntimeFieldsType]
) extends XpackUsageBase

@JsonCodec case class XpackUsageRuntimeFieldsType(
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

@JsonCodec case class XpackUsageSearchableSnapshots(
	indices_count: integer, 
	full_copy_indices_count: integer, 
	shared_cache_indices_count: integer
) extends XpackUsageBase

@JsonCodec case class XpackUsageSecurity(
	api_key_service: XpackUsageFeatureToggle, 
	anonymous: XpackUsageFeatureToggle, 
	audit: XpackUsageAudit, 
	fips_140: XpackUsageFeatureToggle, 
	ipfilter: XpackUsageIpFilter, 
	realms: Record[String, XpackUsageRealm], 
	role_mapping: Record[String, XpackUsageRoleMapping], 
	roles: XpackUsageSecurityRoles, 
	ssl: XpackUsageSsl, 
	system_key: XpackUsageFeatureToggle, 
	token_service: XpackUsageFeatureToggle, 
	operator_privileges: XpackUsageBase
) extends XpackUsageBase

@JsonCodec case class XpackUsageSecurityRoles(
	native: XpackUsageSecurityRolesNative, 
	dls: XpackUsageSecurityRolesDls, 
	file: XpackUsageSecurityRolesFile
)

@JsonCodec case class XpackUsageSecurityRolesDls(
	bit_set_cache: XpackUsageSecurityRolesDlsBitSetCache
)

@JsonCodec case class XpackUsageSecurityRolesDlsBitSetCache(
	count: integer, 
	memory: ByteSize, 
	memory_in_bytes: ulong
)

@JsonCodec case class XpackUsageSecurityRolesFile(
	dls: Boolean, 
	fls: Boolean, 
	size: long
)

@JsonCodec case class XpackUsageSecurityRolesNative(
	dls: Boolean, 
	fls: Boolean, 
	size: long
)

@JsonCodec case class XpackUsageSlm(
	policy_count: integer, 
	policy_stats: SlmStatistics
) extends XpackUsageBase

@JsonCodec case class XpackUsageSql(
	features: Record[String, integer], 
	queries: Record[String, XpackUsageQuery]
) extends XpackUsageBase

@JsonCodec case class XpackUsageSsl(
	http: XpackUsageFeatureToggle, 
	transport: XpackUsageFeatureToggle
)
type XpackUsageUrlConfig = XpackUsageBaseUrlConfig | XpackUsageKibanaUrlConfig

@JsonCodec case class XpackUsageVector(
	dense_vector_dims_avg_count: integer, 
	dense_vector_fields_count: integer, 
	sparse_vector_fields_count: integer
) extends XpackUsageBase

@JsonCodec case class XpackUsageWatcher(
	execution: XpackUsageWatcherActions, 
	watch: XpackUsageWatcherWatch, 
	count: XpackUsageCounter
) extends XpackUsageBase

@JsonCodec case class XpackUsageWatcherActionTotals(
	total: long, 
	total_time_in_ms: long
)

@JsonCodec case class XpackUsageWatcherActions(
	actions: Record[Name, XpackUsageWatcherActionTotals]
)

@JsonCodec case class XpackUsageWatcherWatch(
	input: Record[Name, XpackUsageCounter], 
	condition: Record[Name, XpackUsageCounter], 
	action: Record[Name, XpackUsageCounter], 
	trigger: XpackUsageWatcherWatchTrigger
)

@JsonCodec case class XpackUsageWatcherWatchTrigger(
	schedule: XpackUsageWatcherWatchTriggerSchedule, 
	_all: XpackUsageCounter
)

@JsonCodec case class XpackUsageWatcherWatchTriggerSchedule(
	cron: XpackUsageCounter, 
	_all: XpackUsageCounter
) extends XpackUsageCounter

@JsonCodec sealed trait SpecUtilsAdditionalProperties[TKey = None, TValue = None]

@JsonCodec case class SpecUtilsCommonQueryParameters(
	error_trace: Boolean, 
	filter_path: String | Seq[String], 
	human: Boolean, 
	pretty: Boolean, 
	source_query_string: String
)

@JsonCodec case class SpecUtilsCommonCatQueryParameters(
	format: String, 
	h: Names, 
	help: Boolean, 
	local: Boolean, 
	master_timeout: Time, 
	s: Seq[String], 
	v: Boolean
)
