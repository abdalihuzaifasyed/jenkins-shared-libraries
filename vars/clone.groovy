def call(String url, String branch) {
    sh 'whoami'
    echo 'This is cloning a code'
    git branch: branch, url: url
}
