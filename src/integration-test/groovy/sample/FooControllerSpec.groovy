package sample

import grails.test.mixin.integration.Integration
import grails.transaction.*
import grails.plugins.rest.client.RestBuilder
import groovy.json.JsonBuilder

import spock.lang.*
import geb.spock.*

/**
 * See http://www.gebish.org/manual/current/ for more instructions
 */
@Integration
@Rollback
class FooControllerSpec extends Specification {

    def baseUrl

    def setup() {
        baseUrl = "http://localhost:${serverPort}"
    }

    def cleanup() {
    }

    void "/foo/index"() {
        given:
            def rest = new RestBuilder()
        when:
            def response = rest.get("${baseUrl}/foo/index") {
            }

        then:
            def json = response.json
            response.status == 200
            response.json.one == "We'll rock you :P"
            response.json.two == "We''ll rock you :P"
            response.json.three == "We'll rock you yay :P"
            response.json.four == "We''ll rock you yay :P"
    }

}
