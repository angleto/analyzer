package com.getjenny.analyzer.atoms

import com.getjenny.analyzer.expressions.{AnalyzersDataInternal, Result}
import scalaz.Scalaz._

/**
  * Created by angelo on 16/08/17.
  */

/** test the value of the penultimate traversed state
  *
  * @param arguments of the state to be checked
  */


class PrevTravStateIsAtomic(val arguments: List[String], restrictedArgs: Map[String, String])
  extends AbstractAtomic {
  val name: String = arguments.headOption match {
    case Some(t) => t
    case _ =>
      throw ExceptionAtomic("prevTravStateIs requires an argument")
  }
  override def toString: String = "prevTravStateIs"
  val isEvaluateNormalized: Boolean = true

  /** Check if the last state into data.traversed_states is <state>
    *
    * @param query the user query
    * @param data the data
    * @return Result with 1.0 if the penultimate state is <name> score = 0.0 otherwise
    */
  def evaluate(query: String, data: AnalyzersDataInternal = AnalyzersDataInternal()): Result = {
    val listLength = data.traversedStates.length
    if(listLength >= 2 && data.traversedStates(listLength-2) === name) {
      Result(score = 1.0)
    } else {
      Result(score = 0.0)
    }
  }
}
