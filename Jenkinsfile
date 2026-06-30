pipeline {

    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK21'
    }

    stages {

        stage('Checkout') {
            steps {
                echo '===== Checking out source code ====='
                checkout scm
            }
        }

        stage('Environment Information') {
            steps {
                sh '''
                    echo "===== Build Environment ====="

                    echo "Hostname:"
                    hostname

                    echo "Current User:"
                    whoami

                    echo "Workspace:"
                    pwd

                    echo "Java Version:"
                    java -version

                    echo "Git Version:"
                    git --version

                    echo "Maven Version:"
                    mvn -version

                    echo "Memory Usage:"
                    free -h

                    echo "Disk Usage:"
                    df -h
                '''
            }
        }

        stage('Build Validation') {
            steps {
                sh '''
                    test -f pom.xml
                    test -d src/main
                    test -d src/test

                    echo "Project structure validated successfully."
                '''
            }
        }

        stage('Compile') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Unit Test') {
        steps {
                sh 'mvn test'
                }
        }		

        stage('Publish JUnit Report') {
            steps {
                junit '**/target/surefire-reports/*.xml'
                }
        }

        stage('Publish JaCoCo Report') {
            steps {
                publishHTML([
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target/site/jacoco',
                    reportFiles: 'index.html',
                    reportName: 'JaCoCo Code Coverage'
                ])
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }

        stage('Archive Artifact') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }


    }

    post {

        always {
            echo "Pipeline execution completed."
        }

        success {
            echo "Compilation completed successfully."
        }

        failure {
            echo "Compilation failed."
        }
    }
}
