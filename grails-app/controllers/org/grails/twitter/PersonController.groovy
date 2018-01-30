package org.grails.twitter

import grails.converters.JSON
import org.grails.twitter.auth.Person
import org.springframework.security.access.annotation.Secured
import wdtwitter.PersonService

class PersonController {

    PersonService personService

    @Secured('IS_AUTHENTICATED_FULLY')
    def index() {

        //loggedInUser()
        render (view:'showuser.gsp')
    }

    @Secured('IS_AUTHENTICATED_FULLY')
    def shownUser() {
        //render the chosen user as a json object
        render(personService.getShownUser(params.long('id')) as JSON)
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
