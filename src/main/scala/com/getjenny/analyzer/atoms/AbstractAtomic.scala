package com.getjenny.analyzer.atoms

import com.getjenny.analyzer.expressions._

/**
  * Created by mal on 20/02/2017.
  */

/**
  * These are the Atomic components of Analyzer.
  * Atomic can be for instance a Pattern (i.e. a Regex) or a Similarity.
  * Atomics can be composed in Analyzers through Operators, like:
  *
  *     AND(regex > 0, similarity > 0.9)
  *
  *  NB New atomic must be registered in
  */
abstract class AbstractAtomic extends Expression(List.empty[Expression]) {
  val isEvaluateNormalized: Boolean  // does "evaluate" return normalized values?
}
