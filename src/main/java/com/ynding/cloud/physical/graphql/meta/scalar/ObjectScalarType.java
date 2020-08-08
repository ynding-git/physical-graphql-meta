package com.ynding.cloud.physical.graphql.meta.scalar;

import graphql.language.ScalarTypeDefinition;
import graphql.schema.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ynding
 */
@Component
public class ObjectScalarType extends GraphQLScalarType {

    public ObjectScalarType() {
        super("Object", "object", new Coercing() {
            @Override
            public Object serialize(Object o) throws CoercingSerializeException {
                return o;
            }

            @Override
            public Object parseValue(Object o) throws CoercingParseValueException {
                return o;
            }

            @Override
            public Object parseLiteral(Object o) throws CoercingParseLiteralException {
                return o;
            }
        });
    }

    public ObjectScalarType(String name, String description, Coercing coercing, List<GraphQLDirective> directives, ScalarTypeDefinition definition) {
        super(name, description, coercing, directives, definition);
    }
}
