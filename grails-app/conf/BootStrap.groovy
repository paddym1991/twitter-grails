import org.grails.twitter.auth.*

class BootStrap {

    def springSecurityService

    def init = { servletContext ->
        if(!Person.count()) {

            def userRole = new Authority(authority: 'ROLE_USER').save()

           // def password = springSecurityService.encodePassword('password')

            [jeff: 'Jeff Brown', graeme: 'Graeme Rocher', burt: 'Burt Binglesteen', peter: 'Peter Ledbrook'].each { userName, realName ->
                def user = new Person(username: userName, realName: realName, password: 'password', enabled: true).save()
                PersonAuthority.create user, userRole, true
            }

           // println 'THIS IS THE PASSWORD: ' + password
        }
    }
    def destroy = {
    }
}
