def call() {
    echo 'This is deploying the code'
    sh 'docker compose down || true'
    sh 'docker compose up -d --build'
    sh 'docker ps'
}
