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

    /**
     * return the chosen user a JSON object based on their id
     * @return
     */
    @Secured('IS_AUTHENTICATED_FULLY')
    def shownUser() {
        //render the chosen user as a json object
        //render(personService.getShownUser(params.long('id')) as JSON)

        //create user variable and set user as the returned user from personService
        def user = personService.getShownUser(params.long('id'))
        //create a model of this user as a map
        def retModel = [id: user.id, username: user.username, realName: user.realName, phone: user.phone, email: user.email]
        //render the user's .gsp profile page, loaded with the retModel model data.     To use the data from the model in .gsp page use, for example, '${username}'
        render (view: '/person/showotheruser.gsp', model: retModel)
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
