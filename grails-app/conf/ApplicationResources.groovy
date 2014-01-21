modules = {
    application {
        dependsOn 'jquery'
        resource url:'js/application.js'
        resource url: 'css/bootstrap/bootstrap.css'
        resource url: 'css/main.css'

        resource url: 'js/fancybox/jquery.fancybox-1.3.4.pack.js'
        resource url: 'js/fancybox/jquery.easing-1.3.pack.js'
        resource url: 'js/fancybox/jquery.fancybox-1.3.4.css'
    }
}