/*
 * Copyright 2019 BusyMachines
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package busymachines.pureharm.json

/** @author Lorand Szakacs, https://github.com/lorandszakacs
  * @since 10 Jun 2019
  */
trait PureharmJsonTypeDefinitions {
  final type Codec[A] = io.circe.Codec[A]
  final val Codec: io.circe.Codec.type = io.circe.Codec

  final type JsonDecodingAnomaly = busymachines.pureharm.internals.json.JsonDecodingAnomaly

  final val JsonDecodingAnomaly: busymachines.pureharm.internals.json.JsonDecodingAnomaly.type =
    busymachines.pureharm.internals.json.JsonDecodingAnomaly

  final type JsonParsingAnomaly = busymachines.pureharm.internals.json.JsonParsingAnomaly

  final val JsonParsingAnomaly: busymachines.pureharm.internals.json.JsonParsingAnomaly.type =
    busymachines.pureharm.internals.json.JsonParsingAnomaly

  final type Encoder[A] = io.circe.Encoder[A]
  final val Encoder: io.circe.Encoder.type = io.circe.Encoder

  final type Decoder[A] = io.circe.Decoder[A]
  final val Decoder: io.circe.Decoder.type = io.circe.Decoder

  final type Configuration = io.circe.generic.extras.Configuration
  final val Configuration: io.circe.generic.extras.Configuration.type = io.circe.generic.extras.Configuration

  final type Json       = io.circe.Json
  final type JsonObject = io.circe.JsonObject

  final val Json:       io.circe.Json.type       = io.circe.Json
  final val JsonObject: io.circe.JsonObject.type = io.circe.JsonObject

  final type HCursor = io.circe.HCursor
  final val HCursor: io.circe.HCursor.type = io.circe.HCursor
}
