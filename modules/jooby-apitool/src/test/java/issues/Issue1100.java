package issues;

import apps.App1100;
import org.jooby.apitool.ApiParser;
import org.jooby.apitool.ApiToolFeature;
import org.jooby.apitool.RouteMethod;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.List;

public class Issue1100 extends ApiToolFeature {

  @Test
  public void apiOperation() throws Exception {
    List<RouteMethod> routes = new ApiParser(dir()).parseFully(new App1100());

    assertEquals("---\n"
        + "swagger: \"2.0\"\n"
        + "tags:\n"
        + "- name: \"foo\"\n"
        + "- name: \"bar\"\n"
        + "- name: \"1100\"\n"
        + "consumes:\n"
        + "- \"application/json\"\n"
        + "produces:\n"
        + "- \"application/json\"\n"
        + "paths:\n"
        + "  /api/1100:\n"
        + "    post:\n"
        + "      tags:\n"
        + "      - \"foo\"\n"
        + "      - \"bar\"\n"
        + "      summary: \"Summary\"\n"
        + "      description: \"List all pets\"\n"
        + "      operationId: \"listPets\"\n"
        + "      consumes:\n"
        + "      - \"foo/bar\"\n"
        + "      produces:\n"
        + "      - \"foo/bar\"\n"
        + "      - \" bar/baz\"\n"
        + "      parameters: []\n"
        + "      responses:\n"
        + "        202:\n"
        + "          description: \"Result\"\n"
        + "          headers:\n"
        + "            foo:\n"
        + "              type: \"string\"\n"
        + "          schema:\n"
        + "            $ref: \"#/definitions/Pet\"\n"
        + "  /api/1100/apiresponse:\n"
        + "    get:\n"
        + "      tags:\n"
        + "      - \"1100\"\n"
        + "      summary: \"ApiResponse\"\n"
        + "      operationId: \"/Controller1100.listApiResponse\"\n"
        + "      parameters: []\n"
        + "      responses:\n"
        + "        204:\n"
        + "          description: \"Response message\"\n"
        + "          headers:\n"
        + "            foo:\n"
        + "              type: \"string\"\n"
        + "          schema:\n"
        + "            $ref: \"#/definitions/Category\"\n"
        + "  /api/1100/nresponse:\n"
        + "    get:\n"
        + "      tags:\n"
        + "      - \"1100\"\n"
        + "      operationId: \"/Controller1100.listNApiResponse\"\n"
        + "      parameters: []\n"
        + "      responses:\n"
        + "        200:\n"
        + "          description: \"cat\"\n"
        + "          schema:\n"
        + "            $ref: \"#/definitions/Category\"\n"
        + "        200(Tag):\n"
        + "          description: \"tag\"\n"
        + "          headers:\n"
        + "            foo:\n"
        + "              type: \"string\"\n"
        + "          schema:\n"
        + "            $ref: \"#/definitions/Tag\"\n"
        + "definitions:\n"
        + "  Category:\n"
        + "    type: \"object\"\n"
        + "    properties:\n"
        + "      id:\n"
        + "        type: \"integer\"\n"
        + "        format: \"int64\"\n"
        + "      name:\n"
        + "        type: \"string\"\n"
        + "  Pet:\n"
        + "    type: \"object\"\n"
        + "    properties:\n"
        + "      id:\n"
        + "        type: \"integer\"\n"
        + "        format: \"int64\"\n"
        + "      name:\n"
        + "        type: \"string\"\n"
        + "      category:\n"
        + "        $ref: \"#/definitions/Category\"\n"
        + "      photoUrls:\n"
        + "        type: \"array\"\n"
        + "        items:\n"
        + "          type: \"string\"\n"
        + "      tags:\n"
        + "        type: \"array\"\n"
        + "        items:\n"
        + "          $ref: \"#/definitions/Tag\"\n"
        + "      status:\n"
        + "        type: \"string\"\n"
        + "        enum:\n"
        + "        - \"available\"\n"
        + "        - \"not_available\"\n"
        + "  Tag:\n"
        + "    type: \"object\"\n"
        + "    properties:\n"
        + "      id:\n"
        + "        type: \"integer\"\n"
        + "        format: \"int64\"\n"
        + "      name:\n"
        + "        type: \"string\"\n", yaml(swagger(routes), false));
  }

}