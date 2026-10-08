def call(String credId, String imageName, String tag) {
    echo 'This is pushing the image to Docker Hub'
    withCredentials([usernamePassword(
        credentialsId: credId,
        usernameVariable: 'dockerHubUser',
        passwordVariable: 'dockerHubPass'
    )]) {
        sh 'echo "$dockerHubPass" | docker login -u "$dockerHubUser" --password-stdin'
        sh "docker image tag ${imageName}:${tag} \$dockerHubUser/${imageName}:${tag}"
        sh "docker push \$dockerHubUser/${imageName}:${tag}"
        sh 'docker logout'
    }
}
