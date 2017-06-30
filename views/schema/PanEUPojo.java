package org.pralayb.poc.views.schema;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

import java.util.ArrayList;

@ToString
public final class PanEUPojo {
    public final Include include;

    @JsonCreator
    public PanEUPojo(@JsonProperty("include") Include include){
        this.include = include;
    }

    @ToString
    public static final class Include {
        public final ArrayList<Node> node;
        public final ArrayList<Arc> arc;

        @JsonCreator
        public Include(@JsonProperty("node") ArrayList<Node> node, @JsonProperty("arc") ArrayList<Arc> arc){
            this.node = node;
            this.arc = arc;
        }

        @ToString
        public static final class Node {
            public final String type;
            public final ArrayList<String> value;
            public final ArrayList<String> capability;

            @JsonCreator
            public Node(@JsonProperty("type") String type, @JsonProperty("value") ArrayList<String> value, @JsonProperty("capability") ArrayList<String> capability){
                this.type = type;
                this.value = value;
                this.capability = capability;
            }
        }

        @ToString
        public static final class Arc {
            public final ArrayList<String> between;
            public final ArrayList<String> type;
            public final ArrayList<String> capability;

            @JsonCreator
            public Arc(@JsonProperty("between") ArrayList<String> between, @JsonProperty("type") ArrayList<String> type, @JsonProperty("capability") ArrayList<String> capability){
                this.between = between;
                this.type = type;
                this.capability = capability;
            }
        }
    }
}