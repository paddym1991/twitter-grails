import org.grails.twitter.auth.*

class BootStrap {

    def springSecurityService

    def init = { servletContext ->
        if(!Person.count()) {

            def userRole = new Authority(authority: 'ROLE_USER').save()

           // def password = springSecurityService.encodePassword('password')

             [[realName: 'Jeff Brown', userName: 'jeff', phone: '0877907968', email: 'jdawg@grails.com'], [realName: 'Graeme Rocher', userName: 'graeme', phone: '0877654321', email: 'gdawg@grails.com'],
             [realName: 'Burt Binglesteen', userName: 'burt', phone: '0876934510', email: 'bdawg@grails.com'], [realName: 'Peter Ledbrook', userName: 'peter', phone: '0876879876', email: 'pdawg@grails.com']].each {
                 def user = new Person(username: it.userName, realName: it.realName, password: 'password', phone: it.phone, email: it.email, enabled: true).save()
                 PersonAuthority.create user, userRole, true
             }

//                 new Status(message: 'This is a status message', author: jeff).save()
//                 new Status(message: 'status number 2', author: peter).save()

//             [[message: 'This is a status message', author: jeff], [message: 'status number 2', author: peter]].each {
//                def status = new Status(message: it.message, author: it.author).save()
//             }



           // println 'THIS IS THE PASSWORD: ' + password
        }
    }
    def destroy = {
    }
}
