pipeline {

    agent any

    tools {
        maven 'Maven-3.8.4'
    }

    stages {

        stage('Checkout') {
            steps {
                echo 'Checking out source code...'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Building Employee Management System...'
                sh 'mvn clean package'
            }
        }
    }

    post {

        success {
            echo 'Build Successful.'

            archiveArtifacts artifacts: 'target/*.jar'
        }

        failure {
            echo 'Build Failed.'
        }
    }
}
