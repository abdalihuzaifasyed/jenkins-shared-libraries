def call(String imageName, String tag) {
    echo 'This is building a code'
    sh "docker build -t ${imageName}:${tag} ."
    sh "docker images | grep ${imageName}"
}
