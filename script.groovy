def buildJar() {
    echo "building the app"
    sh 'mvn package'
}

def buildImage() {
    echo "building the docker image"
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', usernameVariable: 'USER', passwordVariable: 'PWD')]) {
        sh "docker build -t nj1892/demo-app:jma-2.0 ."
        sh "echo $PWD | docker login -u $USER --password-stdin"
        sh "docker push nj1892/demo-app:jma-2.0"
    }
}

return this