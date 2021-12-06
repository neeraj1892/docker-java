pipeline {
    agent any
       tools {
            maven 'Maven'
       }
       parameters {
            choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
            booleanParam(name: 'executeTests', defaultValue: true, description: '')
       }
    stages {
        stage("build") {
            steps {
                echo "building the app"
            }
        }

        stage("test") {
            when {
                expressions {
                    params.executeTests
                }
            }
            steps {
                echo "testing the app"
            }
        }

        stage("deploy") {
            steps {
                echo "deploying the app"
                echo "deploying with version ${params.VERSION}"
                withCredentials([
                    usernamePassword(credentials: 'github-nj-credentials', usernameVariable: USER, passwordVariable: PWD)
                ]){
                        sh "some script ${USER} ${PWD}"
                }
            }
        }
    }
}