package com.converted.elasticsearch._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.{ integer, long }

@JsonCodec sealed trait UrlParameter

type Uri = String
type ScrollId = String
type ScrollIds = String
type CategoryId = String
type ActionIds = String
type Id = String
type Ids = Id | Array(Id)
type NodeId = String
type IndexName = String
type Indices = String | Array(String)
type IndexAlias = String
type IndexPattern = String
type IndexPatterns = Array(IndexPattern)
type Type = String
type Types = Type | Array(Type)
type Routing = String | Numeric
type LongId = String
type IndexMetrics = String
type Metrics = String | Array(String)
type Name = String
type Names = String | Array(String)
type Namespace = String
type Service = String
type PipelineName = String
type NodeName = String
type DataStreamName = String
type ByteSize = long | String
type Metadata = Dictionary(String, UserDefinedValue)
type VersionNumber = long
type VersionNumbers = Array(VersionNumber)
type VersionString = String
type VersionStrings = Array(VersionString)

object VersionType extends Enumeration {
	type VersionType = Value

val internal = Value(0, "internal")
val external = Value(1, "external")
val external_gte = Value(2, "external_gte")
val force = Value(3, "force")
}

implicit val versionTypeDecoder: Decoder[VersionType.Value] = Decoder.decodeEnumeration(VersionType)
implicit val versionTypeEncoder: Encoder[VersionType.Value] = Decoder.encodeEnumeration(VersionType)

type Uuid = String
type SequenceNumber = integer
type NodeIds = String
type PropertyName = String
type RelationName = String
type TaskId = String | integer
type Fuzziness = String | integer
type MultiTermQueryRewrite = String
type Field = String
type Fields = Field | Array(Field)
type WaitForActiveShards = integer | WaitForActiveShardOptions
type AggregateName = String
type SuggestionName = String
type HttpHeaders = Dictionary(String, String | Array(String))

@JsonCodec sealed trait EmptyObject

type MinimumShouldMatch = integer | String

object ShapeRelation extends Enumeration {
	type ShapeRelation = Value

val intersects = Value(0, "intersects")
val disjoint = Value(1, "disjoint")
val within = Value(2, "within")
}

implicit val shapeRelationDecoder: Decoder[ShapeRelation.Value] = Decoder.decodeEnumeration(ShapeRelation)
implicit val shapeRelationEncoder: Encoder[ShapeRelation.Value] = Decoder.encodeEnumeration(ShapeRelation)


object Bytes extends Enumeration {
	type Bytes = Value

val b = Value(0, "b")
val k = Value(1, "k")
val kb = Value(2, "kb")
val m = Value(3, "m")
val mb = Value(4, "mb")
val g = Value(5, "g")
val gb = Value(6, "gb")
val t = Value(7, "t")
val tb = Value(8, "tb")
val p = Value(9, "p")
val pb = Value(10, "pb")
}

implicit val bytesDecoder: Decoder[Bytes.Value] = Decoder.decodeEnumeration(Bytes)
implicit val bytesEncoder: Encoder[Bytes.Value] = Decoder.encodeEnumeration(Bytes)


object Conflicts extends Enumeration {
	type Conflicts = Value

val abort = Value(0, "abort")
val proceed = Value(1, "proceed")
}

implicit val conflictsDecoder: Decoder[Conflicts.Value] = Decoder.decodeEnumeration(Conflicts)
implicit val conflictsEncoder: Encoder[Conflicts.Value] = Decoder.encodeEnumeration(Conflicts)

type Username = String
type Password = String

object DefaultOperator extends Enumeration {
	type DefaultOperator = Value

val aND = Value(0, "AND")
val oR = Value(1, "OR")
}

implicit val defaultOperatorDecoder: Decoder[DefaultOperator.Value] = Decoder.decodeEnumeration(DefaultOperator)
implicit val defaultOperatorEncoder: Encoder[DefaultOperator.Value] = Decoder.encodeEnumeration(DefaultOperator)


@JsonCodec sealed trait ElasticsearchResponseBase


@JsonCodec sealed trait ElasticsearchUrlFormatter


object ExpandWildcardOptions extends Enumeration {
	type ExpandWildcardOptions = Value

val all = Value(0, "all")
val open = Value(1, "open")
val closed = Value(2, "closed")
val hidden = Value(3, "hidden")
val none = Value(4, "none")
}

implicit val expandWildcardOptionsDecoder: Decoder[ExpandWildcardOptions.Value] = Decoder.decodeEnumeration(ExpandWildcardOptions)
implicit val expandWildcardOptionsEncoder: Encoder[ExpandWildcardOptions.Value] = Decoder.encodeEnumeration(ExpandWildcardOptions)

type ExpandWildcards = ExpandWildcardOptions | Array(ExpandWildcardOptions) | String

object GroupBy extends Enumeration {
	type GroupBy = Value

val nodes = Value(0, "nodes")
val parents = Value(1, "parents")
val none = Value(2, "none")
}

implicit val groupByDecoder: Decoder[GroupBy.Value] = Decoder.decodeEnumeration(GroupBy)
implicit val groupByEncoder: Encoder[GroupBy.Value] = Decoder.encodeEnumeration(GroupBy)


object Health extends Enumeration {
	type Health = Value

val green = Value(0, "green")
val yellow = Value(1, "yellow")
val red = Value(2, "red")
}

implicit val healthDecoder: Decoder[Health.Value] = Decoder.decodeEnumeration(Health)
implicit val healthEncoder: Encoder[Health.Value] = Decoder.encodeEnumeration(Health)


object HttpMethod extends Enumeration {
	type HttpMethod = Value

val gET = Value(0, "GET")
val pOST = Value(1, "POST")
val pUT = Value(2, "PUT")
val dELETE = Value(3, "DELETE")
val hEAD = Value(4, "HEAD")
}

implicit val httpMethodDecoder: Decoder[HttpMethod.Value] = Decoder.decodeEnumeration(HttpMethod)
implicit val httpMethodEncoder: Encoder[HttpMethod.Value] = Decoder.encodeEnumeration(HttpMethod)


object Level extends Enumeration {
	type Level = Value

val cluster = Value(0, "cluster")
val indices = Value(1, "indices")
val shards = Value(2, "shards")
}

implicit val levelDecoder: Decoder[Level.Value] = Decoder.decodeEnumeration(Level)
implicit val levelEncoder: Encoder[Level.Value] = Decoder.encodeEnumeration(Level)


object OpType extends Enumeration {
	type OpType = Value

val index = Value(0, "index")
val create = Value(1, "create")
}

implicit val opTypeDecoder: Decoder[OpType.Value] = Decoder.decodeEnumeration(OpType)
implicit val opTypeEncoder: Encoder[OpType.Value] = Decoder.encodeEnumeration(OpType)

type Refresh = Boolean | RefreshOptions

object RefreshOptions extends Enumeration {
	type RefreshOptions = Value

val wait_for = Value(1, "wait_for")
}

implicit val refreshOptionsDecoder: Decoder[RefreshOptions.Value] = Decoder.decodeEnumeration(RefreshOptions)
implicit val refreshOptionsEncoder: Encoder[RefreshOptions.Value] = Decoder.encodeEnumeration(RefreshOptions)


object SearchType extends Enumeration {
	type SearchType = Value

val query_then_fetch = Value(0, "query_then_fetch")
val dfs_query_then_fetch = Value(1, "dfs_query_then_fetch")
}

implicit val searchTypeDecoder: Decoder[SearchType.Value] = Decoder.decodeEnumeration(SearchType)
implicit val searchTypeEncoder: Encoder[SearchType.Value] = Decoder.encodeEnumeration(SearchType)


object Size extends Enumeration {
	type Size = Value

val raw = Value(0, "Raw")
val k = Value(1, "k")
val m = Value(2, "m")
val g = Value(3, "g")
val t = Value(4, "t")
val p = Value(5, "p")
}

implicit val sizeDecoder: Decoder[Size.Value] = Decoder.decodeEnumeration(Size)
implicit val sizeEncoder: Encoder[Size.Value] = Decoder.encodeEnumeration(Size)


object SuggestMode extends Enumeration {
	type SuggestMode = Value

val missing = Value(0, "missing")
val popular = Value(1, "popular")
val always = Value(2, "always")
}

implicit val suggestModeDecoder: Decoder[SuggestMode.Value] = Decoder.decodeEnumeration(SuggestMode)
implicit val suggestModeEncoder: Encoder[SuggestMode.Value] = Decoder.encodeEnumeration(SuggestMode)


object ThreadType extends Enumeration {
	type ThreadType = Value

val cpu = Value(0, "cpu")
val wait = Value(1, "wait")
val block = Value(2, "block")
}

implicit val threadTypeDecoder: Decoder[ThreadType.Value] = Decoder.decodeEnumeration(ThreadType)
implicit val threadTypeEncoder: Encoder[ThreadType.Value] = Decoder.encodeEnumeration(ThreadType)


object WaitForActiveShardOptions extends Enumeration {
	type WaitForActiveShardOptions = Value

val all = Value(0, "all")
}

implicit val waitForActiveShardOptionsDecoder: Decoder[WaitForActiveShardOptions.Value] = Decoder.decodeEnumeration(WaitForActiveShardOptions)
implicit val waitForActiveShardOptionsEncoder: Encoder[WaitForActiveShardOptions.Value] = Decoder.encodeEnumeration(WaitForActiveShardOptions)


object WaitForEvents extends Enumeration {
	type WaitForEvents = Value

val immediate = Value(0, "immediate")
val urgent = Value(1, "urgent")
val high = Value(2, "high")
val normal = Value(3, "normal")
val low = Value(4, "low")
val languid = Value(5, "languid")
}

implicit val waitForEventsDecoder: Decoder[WaitForEvents.Value] = Decoder.decodeEnumeration(WaitForEvents)
implicit val waitForEventsEncoder: Encoder[WaitForEvents.Value] = Decoder.encodeEnumeration(WaitForEvents)


object WaitForStatus extends Enumeration {
	type WaitForStatus = Value

val green = Value(0, "green")
val yellow = Value(1, "yellow")
val red = Value(2, "red")
}

implicit val waitForStatusDecoder: Decoder[WaitForStatus.Value] = Decoder.decodeEnumeration(WaitForStatus)
implicit val waitForStatusEncoder: Encoder[WaitForStatus.Value] = Decoder.encodeEnumeration(WaitForStatus)


@JsonCodec case class InlineGet[TDocument](
	fields: Dictionary(String, UserDefinedValue), 
	found: Boolean, 
	_seq_no: SequenceNumber, 
	_primary_term: long, 
	_routing: Routing, 
	_source: TDocument
)

