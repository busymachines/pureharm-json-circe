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

package busymachines.pureharm.json.test.derivetest

import busymachines.pureharm.effects._
import busymachines.pureharm.effects.implicits._
import busymachines.pureharm.json._
import busymachines.pureharm.json.implicits._
import busymachines.pureharm.json.test._

/** @author
  *   Lorand Szakacs, https://github.com/lorandszakacs
  * @since 11
  *   Jun 2019
  */
@scala.annotation.nowarn
final class JsonDerivationNestedTypesTest1 extends JsonTest {

  private val outdoorMelon: OutdoorMelon = OutdoorMelons.WildMelon(
    weight = 42,
    color  = OutdoorMelons.Colors.Green,
  )

  //-----------------------------------------------------------------------------------------------
  //moved outside of the test to avoid false positive of "implicit not used" warning
  implicit protected val color:             Codec[OutdoorMelons.Color] = jsonTestCodecs.`OutdoorMelons.Color.codec`
  implicit protected val outdoorMelonCodec: Codec[OutdoorMelon]        = derive.codec[OutdoorMelon]

  test("... derive for case classes defined within objects — normal codecs") {
    for {
      stringyJson <-
        """
          |{
          |  "weight" : 42,
          |  "color" : {
          |    "_type" : "Green"
          |  },
          |  "_type" : "WildMelon"
          |}
      """.stripMargin.trim.pure[IO]

      json = outdoorMelon.asJson
      read <- stringyJson.decodeAs[OutdoorMelon].liftTo[IO]

      _ = assertEquals(obtained = json.spaces2NoNulls, expected = stringyJson, "encoder")
      _ = assertEquals(obtained = read, expected = outdoorMelon, "decoder")
    } yield ()

  }

  //-----------------------------------------------------------------------------------------------

}

@scala.annotation.nowarn
final class JsonDerivationNestedTypesTest2 extends JsonTest {

  private val outdoorMelon: OutdoorMelon = OutdoorMelons.WildMelon(
    weight = 42,
    color  = OutdoorMelons.Colors.Green,
  )

  //-----------------------------------------------------------------------------------------------
  //moved outside of the test to avoid false positive of "implicit not used" warning
  implicit protected val color: Codec[OutdoorMelons.Color] = jsonTestCodecs.`OutdoorMelons.Color.enumerationCodec`
  implicit protected val outdoorMelonCodec: Codec[OutdoorMelon] = derive.codec[OutdoorMelon]

  test("... derive for case classes defined within objects — enumerationCodec") {
    for {
      stringyJson <-
        """
          |{
          |  "weight" : 42,
          |  "color" : "Green",
          |  "_type" : "WildMelon"
          |}
      """.stripMargin.trim.pure[IO]

      json = outdoorMelon.asJson
      read <- stringyJson.decodeAs[OutdoorMelon].liftTo[IO]

      _ = assertEquals(obtained = json.spaces2NoNulls, expected = stringyJson, "encoder")
      _ = assertEquals(obtained = read, expected = outdoorMelon, "decoder")
    } yield ()

  }

  //-----------------------------------------------------------------------------------------------

}
