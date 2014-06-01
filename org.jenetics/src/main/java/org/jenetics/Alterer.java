/*
 * Java Genetic Algorithm Library (@__identifier__@).
 * Copyright (c) @__year__@ Franz Wilhelmstötter
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:
 *    Franz Wilhelmstötter (franz.wilhelmstoetter@gmx.at)
 */
package org.jenetics;

/**
 * The Alterer is responsible for the changing/recombining the Population.
 * Alterers can be chained by appending a list of alterers with the
 * {@link GeneticAlgorithm#setAlterers(Alterer...)} method.
 *
 * [code]
 * final GeneticAlgorithm&lt;DoubleGene, Double&gt; ga = ...
 * ga.setAlterers(
 *     new Crossover&lt;DoubleGene, Double&gt;(0.1),
 *     new Mutator&lt;DoubleGene, Double&gt;(0.05),
 *     new MeanAlterer&lt;DoubleGene, Double&gt;(0.2)
 * );
 * [/code]
 *
 * The order of the alterer calls is: Crossover, Mutation and MeanAlterer.
 *
 * @param <G> the gene type
 * @param <C> the fitness function result type
 *
 * @author <a href="mailto:franz.wilhelmstoetter@gmx.at">Franz Wilhelmstötter</a>
 * @since 1.0
 * @version 3.0 &mdash; <em>$Date: 2014-06-01 $</em>
 */
@FunctionalInterface
public interface Alterer<
	G extends Gene<?, G>,
	C extends Comparable<? super C>
>
{

	public static final double DEFAULT_ALTER_PROBABILITY = 0.2;

	/**
	 * Alters (recombine) a given population. If the {@code population}
	 * is empty, nothing is altered.
	 *
	 * @param population The Population to be altered. If the
	 *        {@code population} is {@code null} or empty, nothing is altered.
	 * @param generation the date of birth (generation) of the altered phenotypes.
	 * @return the number of genes that has been altered.
	 * @throws NullPointerException if the given {@code population} is
	 *        {@code null}.
	 */
	public int alter(final Population<G, C> population, final int generation);

}
