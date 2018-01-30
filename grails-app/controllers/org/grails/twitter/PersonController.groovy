package org.grails.twitter

import org.grails.twitter.auth.Person
import org.springframework.security.access.annotation.Secured

class PersonController {

    @Secured('IS_AUTHENTICATED_FULLY')
    def index() {

        //loggedInUser()
        render (view:'showuser.gsp')
    }

    def list() {
        [persons: Person.list(params)]
    }

//    def show() {
//        [person: Person.get(params.id)]
//    }

    def show(person) {
        [person:person, messages: Status.findAllByAuthor(person, [max: 10, sort: "dateCreated", order: "desc"] )]
    }
}
