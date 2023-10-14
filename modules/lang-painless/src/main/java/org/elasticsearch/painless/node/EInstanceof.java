/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License
 * 2.0 and the Server Side Public License, v 1; you may not use this file except
 * in compliance with, at your election, the Elastic License 2.0 or the Server
 * Side Public License, v 1.
 */

package org.elasticsearch.painless.node;

import org.elasticsearch.painless.Location;
import org.elasticsearch.painless.phase.UserTreeVisitor;

import java.util.Objects;

/**
 * Represents {@code instanceof} operator.
 * <p>
 * Unlike java's, this works for primitive types too.
 */
public class EInstanceof extends AExpression {

    private final AExpression expressionNode;
    private final String canonicalTypeName;

    public EInstanceof(int identifier, Location location, AExpression expression, String canonicalTypeName) {
        super(identifier, location);

        this.expressionNode = Objects.requireNonNull(expression);
        this.canonicalTypeName = Objects.requireNonNull(canonicalTypeName);
    }

    public AExpression getExpressionNode() {
        return expressionNode;
    }

    public String getCanonicalTypeName() {
        return canonicalTypeName;
    }

    @Override
    public <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
        userTreeVisitor.visitInstanceof(this, scope);
    }

    @Override
    public <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
        expressionNode.visit(userTreeVisitor, scope);
    }
}
