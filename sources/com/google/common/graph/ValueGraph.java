package com.google.common.graph;

import java.util.Optional;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public interface ValueGraph<N, V> extends BaseGraph<N> {

    /* renamed from: com.google.common.graph.ValueGraph$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
    }

    Set<N> adjacentNodes(N n);

    boolean allowsSelfLoops();

    Graph<N> asGraph();

    int degree(N n);

    Optional<V> edgeValue(N n, N n2);

    @NullableDecl
    V edgeValueOrDefault(N n, N n2, @NullableDecl V v);

    Set<EndpointPair<N>> edges();

    boolean equals(@NullableDecl Object obj);

    boolean hasEdgeConnecting(N n, N n2);

    int hashCode();

    int inDegree(N n);

    Set<EndpointPair<N>> incidentEdges(N n);

    boolean isDirected();

    ElementOrder<N> nodeOrder();

    Set<N> nodes();

    int outDegree(N n);

    Set<N> predecessors(N n);

    Set<N> successors(N n);
}
