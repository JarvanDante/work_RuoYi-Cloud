pipeline {
    agent any

    options {
        buildDiscarder(logRotator(numToKeepStr: '20'))
        disableConcurrentBuilds()
        timestamps()
    }

    environment {
        MAVEN_OPTS = '-Dmaven.repo.local=.m2/repository'
        NODE_OPTIONS = '--openssl-legacy-provider'
    }

    stages {
        stage('Environment') {
            steps {
                sh '''
                    java -version
                    mvn -version
                    docker --version
                '''
            }
        }

        stage('Build') {
            parallel {
                stage('Backend') {
                    steps {
                        sh 'mvn -B clean verify'
                    }
                }

                stage('Frontend') {
                    agent {
                        docker {
                            image 'node:18-bullseye'
                            reuseNode true
                        }
                    }
                    steps {
                        dir('ruoyi-ui') {
                            sh 'npm ci --no-audit --no-fund'
                            sh 'npm run build:prod'
                        }
                    }
                }
            }
        }

        stage('Prepare Docker Context') {
            when {
                branch 'main'
            }
            steps {
                dir('docker') {
                    sh 'sh copy.sh'
                }
            }
        }
    }

    post {
        always {
            junit allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'
        }
        success {
            archiveArtifacts artifacts: '**/target/*.jar,ruoyi-ui/dist/**', fingerprint: true
        }
        cleanup {
            deleteDir()
        }
    }
}
