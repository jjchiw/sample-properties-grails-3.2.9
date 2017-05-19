package sample


import isdirty.*
import grails.converters.JSON

class FooController {
    def index(){
        def one = message(code:"some.text.one")
        def two = message(code:"some.text.two")
        def three = message(code:"some.text.three", args:["yay"])
        def four = message(code:"some.text.four", args:["yay"])

        render text: ["one":one, "two":two, "three":three, "four":four] as JSON
    }
}




